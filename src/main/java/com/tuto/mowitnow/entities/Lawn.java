package com.tuto.mowitnow.entities;


import com.tuto.mowitnow.entities.Coordinates;

/***
 * Represente la pelouse
 * @author  Nader BOURAWI
 */
public class Lawn {
    private Coordinates positionMax;

    public Lawn(Coordinates positionMax) {
        this.positionMax = positionMax;
    }

    public Coordinates getPositionMax() {
        return positionMax;
    }

    public void setPositionMax(Coordinates positionMax) {
        this.positionMax = positionMax;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lawn other = (Lawn) obj;
        if (positionMax == null) {
            if (other.positionMax != null)
                return false;
        } else if (!positionMax.equals(other.positionMax))
            return false;
        return true;
    }
}
