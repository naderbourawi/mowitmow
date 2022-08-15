package com.tuto.mowitnow.services.linesRetrieveHandlers;

import com.tuto.mowitnow.services.Instructions.LaunchInstructions;
import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;
import com.tuto.mowitnow.services.parseDataPiloteHandlers.PiloteMowerParcer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * traiter la deuxième ligne du fichier ( liste des tondeuses et leurs instructions )
 *
 * @author Nader BOURAWI
 */
@Service
public class SecondLineHandler {
    Logger logger = LoggerFactory.getLogger(SecondLineHandler.class);

    /**
     * @param piloteMowerParcer l'objet qui permet de piloter les tondeuses
     * @param scanner           fichier input
     * @return la position des tondeuses
     * @throws ExceptionMower Exception liée au tondeuse
     */
    public List<String> ExtractNextLines(PiloteMowerParcer piloteMowerParcer,
                                         Scanner scanner) throws ExceptionMower {
        List<String> listePositions = new ArrayList<>();
        while (scanner.hasNext()) {
            piloteMowerParcer.setMower(scanner.nextLine()); // mettre la position initiale de la tondeuse .
            if (scanner.hasNext()) {
                piloteMowerParcer.setInstructions(scanner.nextLine()); // mettre les instructions
                // vérifier si les données de pelouse, tondeuse et instructions sont correctes.
                if (!piloteMowerParcer.checkIfDataCorrect()) {
                    throw new ExceptionMower(Constants.ERREUR_DONNEES_INCORRECTES);
                } else {
                    //ajouter à la liste des positions
                    logger.info("## Tondeuse " + piloteMowerParcer.getMower());
                    logger.info("Liste d'instructions à suivre: " + piloteMowerParcer.getInstructions());
                    listePositions.add(new LaunchInstructions().ExecuteInstructions(piloteMowerParcer));

                }

            } else {
                throw new ExceptionMower(Constants.ERREUR_DONNEES_LIGNE2_INCORRECTES);
            }
        }
        return listePositions; // la liste final de positions des tondeuses
    }
}
