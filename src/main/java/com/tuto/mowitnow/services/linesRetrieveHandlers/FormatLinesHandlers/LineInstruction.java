package com.tuto.mowitnow.services.linesRetrieveHandlers.FormatLinesHandlers;

import com.tuto.mowitnow.entities.Instruction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Récupérer la liste des instructions à suivre
 *
 * @author Nader BOURAWI
 */
@Service
public class LineInstruction {

    /**
     * récupérer une liste d'enum Instruction
     *
     * @param ligneInstruction : suite d'instruction ( exemple : GDAGD)
     * @return une liste d'enum Instrction
     */
    public static List<Instruction> format(String ligneInstruction) {
        List<Instruction> instructionsList = new ArrayList<>();
        for (char instruction : ligneInstruction.toCharArray()) {
            instructionsList.add(getInstruction(instruction));
        }
        return instructionsList;
    }

    /**
     * récupérer un enum Instruction correspondant au caractère d'instrction
     *
     * @param cInstruction : caractère de l'instruction (A, G, D)
     * @return l'enum correspondant à l'instruction
     */
    public static Instruction getInstruction(char cInstruction) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.getCodeInstruction() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}
