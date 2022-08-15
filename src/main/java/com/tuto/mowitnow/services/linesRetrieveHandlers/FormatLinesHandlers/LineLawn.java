package com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers;

import com.tuto.mowitnow.entities.Coordinates;
import com.tuto.mowitnow.entities.Lawn;
import com.tuto.mowitnow.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class LineLawn {
    public static  Lawn format(String lawnLine) {
        String[] elements = lawnLine.split(Constants.STRING_ESPACE);
        return new Lawn(new Coordinates(Integer.valueOf(elements[0]), Integer.valueOf(elements[1])));
    }
}
