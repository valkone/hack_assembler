package com.valentin.assembler.core;

import java.util.List;
import java.util.stream.Collectors;

import com.valentin.assembler.models.CInstruction;
import com.valentin.assembler.utils.Resources;
import com.valentin.assembler.utils.Utils;

public class Translator {

	private static final int INSTRUCTION_BIT_LENGHT = 16;
	private static final int INSTRUCTION_INDICATOR_BIT_LENGHT = 1;
	private static final String A_INSTRUCTION_INDICATOR = "0";
	private static final String C_INSTRUCTION_INDICATOR = "1";
	
	private int availableVarRegister = 16;
	private int instructionCount = 0;
	
	public List<String> replaceLabels(List<String> commands) {
		return commands.stream()
				.map(this::replaceLabel)
				.collect(Collectors.toList());
	}

	private String replaceLabel(String instruction) {
		if(isLabel(instruction)) {
			instruction = instruction
					.replace("(", "")
					.replace(")", "");
			Resources.symbols.put(instruction, String.valueOf(instructionCount));
			instruction = null;
		} else {
			instructionCount++;
		}
		
		return instruction;
	}
	
	private boolean isLabel(String instruction) {
		return instruction.matches("\\([aA-zZ0-9._$]+\\)");
	}
	
	public List<String> translateProgram(List<String> commnds) {
		return commnds.stream()
				.map(this::translateLine)
				.filter(c -> !c.isEmpty())
				.collect(Collectors.toList());
	}
	
	private String translateLine(String instruction) {
		if(instruction == null)
			return "";
		
		if(isAInstruction(instruction)) {
			return translateAInstruction(instruction);
		} else {
			CInstruction parsedInstruction = Parser.parseCInstruction(instruction);
			return translateCInstruction(parsedInstruction);
		}
	}

	private boolean isAInstruction(String instruction) {
		return instruction.startsWith("@");
	}

	private String translateAInstruction(String instruction) {
		instruction = instruction.replace("@", "");
		if(isInstructionVar(instruction))
			instruction = translateVariable(instruction);
		instruction = Utils.toBinary(instruction);
		
		return buildAInstruction(instruction);
	}
	
	private boolean isInstructionVar(String instruction) {
		return instruction.matches("[aA-zZ._$]+([0-9]+)?");
	}
	
	private String translateVariable(String var) {
		if(!Resources.symbols.containsKey(var)) {
			Resources.symbols.put(var, String.valueOf(availableVarRegister));
			availableVarRegister++;
		}
		return Resources.symbols.get(var);
	}
	
	private String buildAInstruction(String instruction) {
		int paddedZeroCount = INSTRUCTION_BIT_LENGHT - instruction.length() - INSTRUCTION_INDICATOR_BIT_LENGHT;
		return A_INSTRUCTION_INDICATOR + Utils.repeat("0", paddedZeroCount) + instruction;
	}
	
	private String translateCInstruction(CInstruction instruction) {
		instruction
			.setDest(translateCDestination(instruction.getDest()))
			.setComp(translateCComp(instruction.getComp()))
			.setJump(translateCJump(instruction.getJump()));
		return buildCInstruction(instruction);
	}
	
	private String translateCDestination(String destination) {
		return Resources.cDestinationMap.get(destination);
	}
	
	private String translateCComp(String comp) {
		return Resources.cCompMap.get(comp);
	}
	
	private String translateCJump(String jump) {
		return Resources.cJumpMap.get(jump);
	}
	
	private String buildCInstruction(CInstruction instruction) {
		return C_INSTRUCTION_INDICATOR + "11" + instruction.comp + "" + instruction.dest + "" + instruction.jump;
	}
}
