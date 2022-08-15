package com.tuto.mowitnow.entities;

/**
 * Définir l'objet Position du tondeuse
 *
 * @author Nader BOURAWI
 */
public class Position {
    private Coordinates coordonneesMower; /*  Coordonnées Tondeuse */
    private Orientation orientationMower;/*  Orientation  Tondeuse */

    public Position(Coordinates coordonneesMower, Orientation orientationMower) {
        this.coordonneesMower = coordonneesMower;
        this.orientationMower = orientationMower;
    }

    public Coordinates getCoordonneesMower() {
        return coordonneesMower;
    }

    public void setCoordonneesMower(Coordinates coordonneesMower) {
        this.coordonneesMower = coordonneesMower;
    }

    public Orientation getOrientationMower() {
        return orientationMower;
    }

    public void setOrientationMower(Orientation orientationMower) {
        this.orientationMower = orientationMower;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (coordonneesMower == null) {
            if (other.coordonneesMower != null)
                return false;
        } else if (!coordonneesMower.equals(other.coordonneesMower))
            return false;
        if (orientationMower != other.orientationMower)
            return false;
        return true;
    }
}
