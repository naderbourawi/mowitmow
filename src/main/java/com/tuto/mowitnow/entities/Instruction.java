package com.tuto.mowitnow.entities;

/**
 * Represente l'instruction ordonnant à la tondeuse
 */

public enum Instruction {
    AVANCER('A', "Avancer"),
    DROITE('D', "Pivoter à droite"),
    GAUCHE('G', "Pivoter à gauche");

    private char codeInstruction;
    private String labelInstruction;

    /***
     * Constructeur paramètré
     * @param codeInstruction Code d'instruction
     * @param labelInstruction libellé orientation
     */
    private Instruction(char codeInstruction, String labelInstruction) {
        this.codeInstruction = codeInstruction;
        this.labelInstruction = labelInstruction;
    }

    /**
     * @return Code de type char
     */
    public char getCodeInstruction() {
        return codeInstruction;
    }

    /**
     * @return Label de type String
     */
    public String getLibelInstruction() {
        return labelInstruction;
    }
}
