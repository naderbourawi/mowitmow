package com.tuto.mowitnow.services.instructions;


import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.services.Instructions.LaunchInstructions;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FirstLineHandler;
import com.tuto.mowitnow.services.linesRetrieveHandlers.SecondLineHandler;

import com.tuto.mowitnow.services.parseDataPiloteHandlers.PiloteMowerParcer;
import com.tuto.mowitnow.utils.Constants;
import org.junit.jupiter.api.Assertions;

import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;


import java.io.File;


@RunWith(MockitoJUnitRunner.class)
public class LaunchInstructionsTest {
    public static final String FILE_LIGNE1_ERROR = "./src/test/resources/input_ligne1_ko.txt";
    public static final String FILE_LIGNE2_ERROR = "./src/test/resources/input_ligne2_ko.txt";
    /** call the service launchInstructions **/
    @Spy
    FirstLineHandler firstLineHandler;
    @Spy
    SecondLineHandler secondLineHandler;

    @InjectMocks
    LaunchInstructions launchInstructions;

    @DisplayName("Test LaunchInstructions.extract_ligne1() KO")
    @Test
    public void extract_ligne1_KO() {
        //GIVEN
        File file = new File(FILE_LIGNE1_ERROR);
        //WHEN && THEN
        Assertions.assertThrows(ExceptionMower.class, () -> launchInstructions.getMowersFinalPositions(file),
                Constants.ERREUR_DONNEES_LIGNE2_INCORRECTES);
    }

    @DisplayName("Test LaunchInstructions.extract_ligne2() KO")
    @Test
    public void extract_ligne2_KO() {
        //GIVEN
        File file = new File(FILE_LIGNE2_ERROR);
        //WHEN && THEN
        Assertions.assertThrows(ExceptionMower.class, () -> launchInstructions.getMowersFinalPositions(file),
                Constants.ERREUR_DONNEES_LIGNE1_INCORRECTES);
    }

    @DisplayName("Test LaunchInstructions.execute_instruction_testResult1() OK")
    @Test
    public void excute_instruction_testResult1_ok() throws ExceptionMower {
        // GIVEN
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("1 2 N");
        piloteMowerParcer.setInstructions("GAGAGAGAA");
        //WHEN
        String resTest1 = launchInstructions.ExecuteInstructions(piloteMowerParcer);
        // THEN
        Assertions.assertEquals(resTest1, "1 3 N");
    }

    @DisplayName("Test LaunchInstructions.execute_instruction_testResult2() OK")
    @Test
    public void excute_instruction_testResult2_ok() throws ExceptionMower {
        // GIVEN
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("3 3 E");
        piloteMowerParcer.setInstructions("AADAADADDA");
        //WHEN
        String resTest1 = launchInstructions.ExecuteInstructions(piloteMowerParcer);
        // THEN
        Assertions.assertEquals(resTest1, "5 1 E");
    }
    @DisplayName("Test LaunchInstructions.execute_instruction_test3() OK")
    @Test
    public void excute_instruction_test3_ok() throws ExceptionMower {
        // GIVEN
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("2 1 E");
        piloteMowerParcer.setInstructions("AADAAGGAAG");
        //WHEN
        String resTest1 = launchInstructions.ExecuteInstructions(piloteMowerParcer);
        // THEN
        Assertions.assertEquals(resTest1, "4 2 W");
    }
    @DisplayName("Test LaunchInstructions.execute_mouve_north() OK")
    @Test
    public void excute_instruction_mouve_north_ok() throws ExceptionMower {
        //GIVEN
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        //WHEN
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("0 0 N");
        piloteMowerParcer.setInstructions("AA");
        //THEN
        Assertions.assertEquals(launchInstructions.ExecuteInstructions(piloteMowerParcer),"0 2 N");
    }
    @DisplayName("Test LaunchInstructions.move_limit() KO")
    @Test
    public void excute_instruction_move_limit_ko() throws ExceptionMower {
        //GIVEN
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        //WHEN
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("0 0 W");
        piloteMowerParcer.setInstructions("AAAA");
        //THEN
        Assertions.assertEquals(launchInstructions.ExecuteInstructions(piloteMowerParcer),"0 0 W");
    }
    @DisplayName("Test LaunchInstructions.execute_mouve_north() OK")
    @Test
    public void excute_instruction_mouve_south_ok() throws ExceptionMower {
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("2 2 S");
        piloteMowerParcer.setInstructions("A");
        Assertions.assertEquals(launchInstructions.ExecuteInstructions(piloteMowerParcer),"2 1 S");
    }
    @DisplayName("Test LaunchInstructions.execute_mouve_right() OK")
    @Test
    public void excute_instruction_mouve_right_ok() throws ExceptionMower {
        PiloteMowerParcer piloteMowerParcer = new PiloteMowerParcer();
        piloteMowerParcer.setLawn("5 5");
        piloteMowerParcer.setMower("2 2 E");
        piloteMowerParcer.setInstructions("A");
        Assertions.assertEquals(launchInstructions.ExecuteInstructions(piloteMowerParcer),"3 2 E");
    }
}
