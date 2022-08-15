package com.tuto.mowitnow.services.parceDatePiloteHandlers;

import com.tuto.mowitnow.services.parseDataPiloteHandlers.PiloteMowerParcer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PiloteMowerParcerTest {


    @DisplayName("Test PiloteMowerParcer.parceALL() OK")
    @Test
    void parce_all_ok(){
        PiloteMowerParcer pMowerP= new PiloteMowerParcer();
        pMowerP.setLawn("5 5");
        pMowerP.setMower("1 1 S");
        pMowerP.setInstructions("DDGAA");
        assertEquals(pMowerP.checkIfDataCorrect(),true);
    }
    @DisplayName("Test PiloteMowerParcer.parceLawn() KO")
    @Test
    void parce_lawn_KO(){
        PiloteMowerParcer pMowerP= new PiloteMowerParcer();
        pMowerP.setLawn("5 ");
        pMowerP.setMower("1 1 S");
        pMowerP.setInstructions("DDGAA");
        assertEquals(pMowerP.checkIfDataCorrect(),false);
    }
    @DisplayName("Test PiloteMowerParcer.parceMower() KO")
    @Test
    void parce_mower_KO(){
        PiloteMowerParcer pMowerP= new PiloteMowerParcer();
        pMowerP.setLawn("5 5");
        pMowerP.setMower("1  S");
        pMowerP.setInstructions("DDGAA");
        assertEquals(pMowerP.checkIfDataCorrect(),false);
    }
    @DisplayName("Test PiloteMowerParcer.parceInstruction() KO")
    @Test
    void parce_instruction_KO(){
        PiloteMowerParcer pMowerP= new PiloteMowerParcer();
        pMowerP.setLawn("5 5");
        pMowerP.setMower("1 1 S");
        pMowerP.setInstructions("");
        assertEquals(pMowerP.checkIfDataCorrect(),false);
    }
}
