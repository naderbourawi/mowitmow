package com.tuto.mowitnow.services.Instructions;


import com.tuto.mowitnow.entities.*;
import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.services.linesRetrieveHandlers.SecondLineHandler;
import com.tuto.mowitnow.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * gérer les instructions de tondeuse.
 *
 * @author Nader Bourawi
 */
@Service
public class ExecuteInstructions {
    Logger logger = LoggerFactory.getLogger(ExecuteInstructions.class);
    private Lawn lawn; // pelouse
    private Position position;
    private List<Instruction> listInstructions;

    /**
     * executer l'ensemble des insctructions
     *
     * @throws ExceptionMower Exception liée au tondeuse
     */
    public void executerInstructions() throws ExceptionMower {
        int i = 0;
        for (Instruction instruction : listInstructions) {
            executeInstruction(position, instruction, this.lawn.getPositionMax());
            if (listInstructions.size() == i + 1) {
                logger.info(">> Position final: " + position.getCoordonneesMower().getX() + " " + position.getCoordonneesMower().getY() + " " + position.getOrientationMower());
            } else {
                logger.info("Pas num " + i + ": " + position.getCoordonneesMower().getX() + " " + position.getCoordonneesMower().getY() + " " + position.getOrientationMower());
            }
            i++;
        }
    }

    public static void executeInstruction(Position position, Instruction instruction, Coordinates coordinatesMax) throws ExceptionMower {
        switch (instruction) {
            case AVANCER:
                position.setCoordonneesMower(Coordinates.avancer(position, coordinatesMax));
                break;
            case DROITE:
                position.setOrientationMower(Orientation.pivoterDroite(position.getOrientationMower()));
                break;
            case GAUCHE:
                position.setOrientationMower(Orientation.pivoterGauche(position.getOrientationMower()));
                break;
            default:
                throw new ExceptionMower(Constants.INSTRUCTION_INCORRECTE);


        }

    }

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public Position getPositionTondeuse() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Instruction> getListeInstructions() {
        return listInstructions;
    }

    public void setListeInstructions(List<Instruction> listeInstructions) {
        this.listInstructions = listeInstructions;
        if (listeInstructions == null) {
            this.listInstructions = new ArrayList<>();
        }
    }

    public String toString() {
        return position.getCoordonneesMower().getX()
                + " "
                + position.getCoordonneesMower().getY()
                + " "
                + position.getOrientationMower().getCodeOrientation();
    }
}
