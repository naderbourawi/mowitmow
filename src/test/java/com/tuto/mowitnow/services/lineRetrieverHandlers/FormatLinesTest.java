package com.tuto.mowitnow.services.lineRetrieverHandlers;

import com.tuto.mowitnow.entities.Coordinates;
import com.tuto.mowitnow.entities.Instruction;
import com.tuto.mowitnow.entities.Orientation;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineInstruction;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineLawn;
import com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers.LineMower;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class FormatLinesTest {

    @Mock
    LineLawn lineLawn;
    @Mock
    LineMower lineMower;

    @Mock
    LineInstruction lineInstruction;

    @DisplayName("Test LineLawn.format() OK ( Pelouse)")
    @Test
    public void format_lawn_ok() {
        Assertions.assertEquals(lineLawn.format("5 5").getPositionMax().equals(new Coordinates(5, 5)), true);
        Assertions.assertEquals(lineLawn.format("4 1").getPositionMax().equals(new Coordinates(4, 1)), true);

    }

    @DisplayName("Test LineMower.format() OK")
    @Test
    public void format_mower_ok() {
        Assertions.assertEquals(
                lineMower.format("1 2 E").getOrientationMower().equals(Orientation.EAST), true);
        Assertions.assertEquals(
                lineMower.format("1 2 W").getOrientationMower().equals(Orientation.WEST), true);
        Assertions.assertEquals(
                lineMower.format("1 2 S").getOrientationMower().equals(Orientation.SOUTH), true);
        Assertions.assertEquals(
                lineMower.format("1 2 N").getOrientationMower().equals(Orientation.NORTH), true);
        Assertions.assertEquals(
                lineMower.format("1 2 E").getCoordonneesMower().equals(new Coordinates(1, 2)), true);

    }

    @DisplayName("Test LineInstruction.format() OK")
    @Test
    public void format_instruction_ok() {
        Assertions.assertEquals(
                lineInstruction.format("GDGA").contains(Instruction.AVANCER), true);
        Assertions.assertEquals(
                lineInstruction.format("GDGA").contains(Instruction.GAUCHE), true);
        Assertions.assertEquals(
                lineInstruction.format("GDGA").contains(Instruction.DROITE), true);
        Assertions.assertEquals(
                lineInstruction.format("GDGA").size() == 4, true);

    }
}
