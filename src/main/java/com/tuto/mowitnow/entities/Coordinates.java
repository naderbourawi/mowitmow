package com.tuto.mowitnow.entities;


import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;

/***
 * Represente les Coordonnées x y
 * @author Nader BOURAWI
 */
public class Coordinates  {
    private int x;
    private int y;

    /***
     * Constructeur de la class
     * @param pX coordonnée x
     * @param pY coordonnée y
     */
    public Coordinates (int pX, int pY){
        this.x = pX;
        this.y = pY;
    }
    /**
     * faire avancer la tondeuse
     * @param position : position initiale de la tondeuse
     * @param coordinatesMax : coordonnees de la pelouse - coin superieur droit de la pelouse
     * @return coordonnees : nouvelles coordonnees de la tondeuse
     * @throws ExceptionMower
     */
    public static Coordinates avancer(Position position, Coordinates coordinatesMax) throws ExceptionMower {
        Coordinates coordonneesSuivantes = null;
        int x, y;
        switch (position.getOrientationMower()) {
            case NORTH:
                x = position.getCoordonneesMower().getX();
                y = position.getCoordonneesMower().getY() + 1;
                break;
            case EAST:
                x = position.getCoordonneesMower().getX() + 1;
                y = position.getCoordonneesMower().getY();
                break;
            case SOUTH:
                x = position.getCoordonneesMower().getX();
                y = position.getCoordonneesMower().getY() - 1;
                break;
            case WEST:
                x = position.getCoordonneesMower().getX() - 1;
                y = position.getCoordonneesMower().getY();
                break;
            default:
                throw new ExceptionMower(Constants.POSITION_INCORRECTE);
        }
        coordonneesSuivantes = new Coordinates(x, y);
        // si les nouvelles coordonnées sont en dehors de la pelouse, on garde
        // la derniere position connue
        if (coordonneesSuivantes != null
                && coordinatesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
            return coordonneesSuivantes;
        } else {
            return position.getCoordonneesMower();
        }


    }
    /**
     * vérifier si les coordonnées de la tondeuse après mouvement sont en dehors de celles
     * de la pelouse
     * @param pCoordonnees
     * @return true si les coordonnées de la tondeuse sont à l'intérieur de la pelouse
     */
    public boolean isHorsCoordonnesMax(Coordinates pCoordonnees){
        return pCoordonnees.getX() >= 0
                && pCoordonnees.getY() >= 0
                && pCoordonnees.getX() <= this.x
                && pCoordonnees.getY() <= this.y;
    }
    /***
     * @return x
     */
    public int getX() {
        return x;
    }
    /***
     * @return y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (x != other.x || y != other.y)
            return false;
        return true;
    }
}
