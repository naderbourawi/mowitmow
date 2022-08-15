package com.tuto.mowitnow.services.parseDataPiloteHandlers;

/**
 * Récuper informations relatives aux tondeuse, pelouse et instrcutions
 *
 * @author Nader BOURAWI
 */
public class PiloteMowerParcer {
    private String lawn;
    private String mower;
    private String instructions;

    public PiloteMowerParcer() {
        this.lawn = "";
        this.mower = "";
        this.instructions = "";
    }

    /**
     * @return Check si les informations de la tondeuse sont correctes
     * Sinon return false
     */
    public boolean checkIfDataCorrect() {
        return CheckDataBeforeParce.CheckParseLawn(lawn)
                && CheckDataBeforeParce.CheckParseMower(mower)
                && CheckDataBeforeParce.checkParseListInstructions(instructions);
    }

    /*
    SETTER && GETTER
     */
    public String getLawn() {
        return lawn;
    }

    public void setLawn(String lawn) {
        this.lawn = lawn;
    }

    public String getMower() {
        return mower;
    }

    public void setMower(String mower) {
        this.mower = mower;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
