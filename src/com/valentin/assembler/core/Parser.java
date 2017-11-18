package com.valentin.assembler.core;

import com.valentin.assembler.models.CInstruction;

public class Parser {

	public static CInstruction parseCInstruction(String instruction) {
		CInstruction cInstruction = null;
		
		if(isFullInstuction(instruction)) {
			cInstruction = parseFullInstruction(instruction);
		} else if(isDestAndComp(instruction)) {
			cInstruction = parseDestAndComp(instruction);
		} else if(isCompAndJump(instruction)){
			cInstruction = parseCompAndJump(instruction);
		}
		
		return cInstruction;
	}
	
	private static boolean isFullInstuction(String instruction) {
		return instruction.contains("=") && instruction.contains(";");
	}
	
	private static boolean isDestAndComp(String instruction) {
		return instruction.contains("=");
	}
	
	private static boolean isCompAndJump(String instruction) {
		return instruction.contains(";");
	}
	
	private static CInstruction parseFullInstruction(String instruction) {
		String[] instructionSplit = instruction.split("=");
		String dest = instructionSplit[0];
		String[] restSplit = instructionSplit[1].split(";");
		String comp = restSplit[0];
		String jump = restSplit.length > 1 ? restSplit[1] : null;
		
		return new CInstruction()
				.setDest(dest)
				.setComp(comp)
				.setJump(jump);
	}
	
	private static CInstruction parseDestAndComp(String instruction) {
		String[] instructionSplit = instruction.split("=");
		String dest = instructionSplit[0];
		String comp = instructionSplit[1];
		
		return new CInstruction()
				.setDest(dest)
				.setComp(comp);
	}
	
	private static CInstruction parseCompAndJump(String instruction) {
		String[] instructionSplit = instruction.split(";");
		String comp = instructionSplit[0];
		String jump = instructionSplit[1];
		
		return new CInstruction()
				.setComp(comp)
				.setJump(jump);
	}
}
