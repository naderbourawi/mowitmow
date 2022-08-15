package com.tuto.mowitnow.entities;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinatesTest {
    @DisplayName("Test Coordinates.equals() OK")
    @Test
    public void testEquals() {
        Coordinates c1 = new Coordinates(1,2);
        Coordinates c2 = new Coordinates(1,2);
        assertEquals(c1,c2);
    }
}
