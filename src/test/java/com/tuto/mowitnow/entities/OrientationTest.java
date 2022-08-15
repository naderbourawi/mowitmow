package com.tuto.mowitnow.entities;

import com.tuto.mowitnow.exceptions.ExceptionMower;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @DisplayName("Test Orientation.pivot_right() ok")
    @Test
    public void pivot_right_ok() throws ExceptionMower {

        Orientation orienSui = Orientation.pivoterDroite(Orientation.EAST);
        assertEquals(orienSui,Orientation.SOUTH);

        Orientation orienSui1 = Orientation.pivoterDroite(Orientation.SOUTH);
        assertEquals(orienSui1,Orientation.WEST);

        Orientation orienSui2 = Orientation.pivoterDroite(Orientation.WEST);
        assertEquals(orienSui2,Orientation.NORTH);

        Orientation orienSui3 = Orientation.pivoterDroite(Orientation.NORTH);
        assertEquals(orienSui3,Orientation.EAST);
    }

    @DisplayName("Test Orientation.pivot_left() ok")
    @Test
    public void pivot_left_ok() throws ExceptionMower {

        Orientation orienSui = Orientation.pivoterGauche(Orientation.EAST);
        assertEquals(orienSui,Orientation.NORTH);

        Orientation orienSui1 = Orientation.pivoterGauche(Orientation.NORTH);
        assertEquals(orienSui1,Orientation.WEST);

        Orientation orienSui2 = Orientation.pivoterGauche(Orientation.WEST);
        assertEquals(orienSui2,Orientation.SOUTH);

        Orientation orienSui3 = Orientation.pivoterGauche(Orientation.SOUTH);
        assertEquals(orienSui3,Orientation.EAST);
    }

}
