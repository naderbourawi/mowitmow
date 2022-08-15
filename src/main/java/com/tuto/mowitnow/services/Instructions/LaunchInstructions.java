package com.tuto.mowitnow.services.Instructions;

import com.tuto.mowitnow.exceptions.ExceptionFile;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FirstLineHandler;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineInstruction;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineLawn;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineMower;
import com.tuto.mowitnow.services.linesRetrieveHandlers.SecondLineHandler;
import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;

import com.tuto.mowitnow.utils.Files;
import com.tuto.mowitnow.services.parseDataPiloteHandlers.PiloteMowerParcer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Permet de retourner la liste des positions final de(s) tondeuse(s)
 *
 * @author Nader BOURAWI
 */
@Service
public class LaunchInstructions {
    Logger logger = LoggerFactory.getLogger(LaunchInstructions.class);
    /**
     * Injecter les services
     **/
    @Autowired
    LineLawn lineLawn;
    @Autowired
    LineMower lineMower;
    @Autowired
    LineInstruction lineInstruction;
    @Autowired
    FirstLineHandler firstLineHandler;
    @Autowired
    SecondLineHandler secondLineHandler;

    /**
     * lecture et contrôle du fichier input
     * Extraire la première ligne ( les coordonnées de pelouse )
     * Extraire la deuxième ligne ( les lignes de tondeuses )
     *
     * @param fichier input d'instructions
     * @return List<String> : la liste des positions des tondeuses
     * @throws ExceptionMower Exception liée au tondeuse
     * @throws IOException    IO Exception
     */
    public List<String> getMowersFinalPositions(File fichier)
            throws ExceptionMower, IOException, ExceptionFile {
        if (Files.isFile(fichier)) { // contrôle du fichier input
            throw new ExceptionFile(Constants.ERREUR_FICHIER_INCORRECT);
        } else {
            PiloteMowerParcer parserPiloteMower = new PiloteMowerParcer();
            Scanner scanner = new Scanner(fichier);
            try {
                firstLineHandler.ExtractLawn(parserPiloteMower, scanner); // Extraire la valeur de pelouse
                return secondLineHandler.ExtractNextLines(parserPiloteMower, scanner); // Extraire la liste des tondeuses

            } finally {
                scanner.close();
            }
        }
    }

    /**
     * Exécuter les instructions provient de l'objet parcé l'objet qui permet de piloter les tondeuses ( PiloteMowerParcer )
     *
     * @param piloteMowerParcer : l'objet qui permet de piloter les tondeuses
     * @throws ExceptionMower Exception liée au Tondeuse
     */
    public String ExecuteInstructions(PiloteMowerParcer piloteMowerParcer) throws ExceptionMower {
        ExecuteInstructions instructionsForMower = new ExecuteInstructions();
        instructionsForMower.setLawn(LineLawn.format(piloteMowerParcer.getLawn())); // Formatter la ligne de pelouse
        instructionsForMower.setPosition(LineMower.format(piloteMowerParcer.getMower())); // formatter la ligne de position tondeuse
        instructionsForMower.setListeInstructions(LineInstruction.format(piloteMowerParcer.getInstructions())); // formatter le ligne des instructions
        instructionsForMower.executerInstructions(); //executer les instrcution
        return instructionsForMower.toString();

    }

    public FirstLineHandler getFirstLineHandler() {
        return firstLineHandler;
    }

    public void setFirstLineHandler(FirstLineHandler firstLineHandler) {
        this.firstLineHandler = firstLineHandler;
    }

    public SecondLineHandler getSecondLineHandler() {
        return secondLineHandler;
    }

    public void setSecondLineHandler(SecondLineHandler secondLineHandler) {
        this.secondLineHandler = secondLineHandler;
    }
}
