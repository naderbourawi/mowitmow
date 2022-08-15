package com.tuto.mowitnow.services.linesRetrieveHandlers;

import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;
import com.tuto.mowitnow.services.parseDataPiloteHandlers.PiloteMowerParcer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * traiter la premiere ligne du fichier ( pelouse )
 *
 * @author Nader BOURAWI
 */
@Service
public class FirstLineHandler {
    Logger logger = LoggerFactory.getLogger(FirstLineHandler.class);

    /**
     * Recupérer les coordonnées de pelouse
     *
     * @param piloteMowerParcer l'objet qui permet de piloter les tondeuses
     * @param scanner           ligne
     * @throws ExceptionMower exception tondeuse
     */
    public void ExtractLawn(PiloteMowerParcer piloteMowerParcer, Scanner scanner)
            throws ExceptionMower {
        if (scanner.hasNext()) {
            piloteMowerParcer.setLawn(scanner.nextLine()); // set la valeur de pelouse ( 1 ère ligne )
            logger.info("##Pelouse: " + piloteMowerParcer.getLawn());
        }
        if (!scanner.hasNext()) {
            throw new ExceptionMower(Constants.ERREUR_DONNEES_LIGNE1_INCORRECTES);
        }
    }
}
