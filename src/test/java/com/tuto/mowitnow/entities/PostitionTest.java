package com.tuto.mowitnow.entities;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostitionTest {

    @DisplayName("Test Position.equals() OK")
    @Test
    public void testEquals_OK() {
        Position p1 = new Position(new Coordinates(1,2), Orientation.EAST);
        Position p2 = new Position(new Coordinates(1,2), Orientation.EAST);
        assertEquals(p1.equals(p2),true);
    }
    @DisplayName("Test Position.equals() KO")
    @Test
    public void testEquals_KO() {
        Position p1 = new Position(new Coordinates(1,2), Orientation.EAST);
        Position p2 = new Position(new Coordinates(1,3), Orientation.EAST);
        assertEquals(p1.equals(p2),false);
    }
}
