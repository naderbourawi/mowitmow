package com.tuto.mowitnow.entities;


import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;

/**
 * Represente l'orientation de tendeuse
 */

public enum Orientation {
    NORTH('N', "Nord"),
    SOUTH('S', "sud"),
    EAST('E', "est"),
    WEST('W', "ouest");

    private char codeOrientation;
    private String labelOrientation;

    private Orientation(char pCodeOrientation, String pLibelOrientation) {
        this.codeOrientation = pCodeOrientation;
        this.labelOrientation = pLibelOrientation;
    }

    public static Orientation pivoterGauche(Orientation orientationMower) throws ExceptionMower {
        Orientation orientationSuivante = null ;
        switch (orientationMower){
            case NORTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case EAST :
                orientationSuivante =  Orientation.NORTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case WEST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            default :
                throw new ExceptionMower(Constants.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }

    /**
     * @return Code de type char
     */
    public char getCodeOrientation() {
        return codeOrientation;
    }

    /**
     * @return Label de type String
     */
    public String getLibelOrientation() {
        return labelOrientation;
    }

    /**
     * faire pivoter la tondeuse à droite
     * @param orientation : orientation initiale de la tondeuse
     * @return nouvelle orientation
     * @throws ExceptionMower
     */

    public static Orientation pivoterDroite(Orientation orientation) throws ExceptionMower {
        Orientation orientationSuivante = null ;
        switch (orientation){
            case NORTH :
                orientationSuivante =  Orientation.EAST;
                break;
            case EAST :
                orientationSuivante =  Orientation.SOUTH;
                break;
            case SOUTH :
                orientationSuivante =  Orientation.WEST;
                break;
            case WEST :
                orientationSuivante =  Orientation.NORTH;
                break;
            default :
                throw new ExceptionMower(Constants.ORIENTATION_INCORRECTE);
        }
        return orientationSuivante;
    }
}
