package com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers;

import com.tuto.mowitnow.entities.Coordinates;
import com.tuto.mowitnow.entities.Orientation;
import com.tuto.mowitnow.entities.Position;
import com.tuto.mowitnow.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class LineMower {

    /**
     * récuperer la position de la tondeuse qui est définit par ses coordonnées et son orientation
     *
     * @param mowerLine : ligne de la position de la tondeuse ( ex : 2 3 G)
     * @return l'objet qui définit la position dela tondeuse
     */
    public static Position format(String mowerLine) {
        String[] elements = mowerLine.split(Constants.STRING_ESPACE);
        Coordinates coordonneesT = new Coordinates(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]));
        Orientation orientationT = getOrientation(elements[2].charAt(0));
        return new Position(coordonneesT, orientationT);
    }

    /**
     * récuperer un enum Orientation correspondant au caractère de l'orientation
     *
     * @param cOrientation : caractère de l'orientation (E, W, N, S)
     * @return l'enum correspondant à l'orientation
     */
    public static Orientation getOrientation(char cOrientation) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getCodeOrientation() == cOrientation) {
                return orientation;
            }
        }
        return null;
    }
}
