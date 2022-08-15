package com.tuto.mowitnow.entities;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class LawnTest {
    @DisplayName("Test Lawn.equals() OK")
    @Test
    public void testEquals() {
        Lawn l1 = new Lawn(new Coordinates(1,2));
        Lawn l2 = new Lawn(new Coordinates(1,2));
        assertEquals(l1,l2);
        Lawn l3 = new Lawn(new Coordinates(1,3));
        assertNotEquals(l1,l3);
    }
    @DisplayName("Test Lawn.equals() KO")
    @Test
    public void testEquals_KO() {
        Lawn l1 = new Lawn(new Coordinates(1, 2));
        Lawn l3 = new Lawn(new Coordinates(1, 3));
        assertNotEquals(l1,l3);
    }
}
