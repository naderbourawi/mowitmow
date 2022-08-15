package com.tuto.mowitnow.services.parseDataPiloteHandlers;

import com.tuto.mowitnow.entities.Instruction;
import com.tuto.mowitnow.entities.Orientation;

/**
 * Contrôler les Données qui permettent le pilotage d'une ou plusieurs tondeuses
 *
 * @author Nader BOURAWI
 */
public class CheckDataBeforeParce {

    /**
     * check position de la pelouse ( 2 chiffres séparés par un espace )
     *
     * @param lawn: Pelouse
     * @return true si la ligne est correcte, false sinon
     */
    public static boolean CheckParseLawn(String lawn) {
        return lawn.matches("(\\d+) (\\d+)");
    }

    /**
     * check  position de la tondeuse & orientation ( deux chiffres et une lettre séparés par un espace)
     *
     * @param mower : tondeuse
     * @return true si la ligne est correcte, false sinon
     */
    public static boolean CheckParseMower(String mower) {
        String stringM = Orientation.NORTH.getCodeOrientation() +
                "|" + Orientation.SOUTH.getCodeOrientation() +
                "|" + Orientation.EAST.getCodeOrientation() +
                "|" + Orientation.WEST.getCodeOrientation();
        return mower.matches("(\\d+) (\\d+) (" + stringM + ")");
    }

    /**
     * check  la ligne des instructions (une suite de caractères(G, D, A) sans espaces)
     *
     * @param instructions d'instructions
     * @return true si la ligne des instructions est correcte, false sinon
     */
    public static boolean checkParseListInstructions(String instructions) {
        String stringInst = "(" + Instruction.AVANCER.getCodeInstruction() +
                "|" + Instruction.DROITE.getCodeInstruction() +
                "|" + Instruction.GAUCHE.getCodeInstruction() +
                ")+";

        return instructions.matches(stringInst);
    }

}
