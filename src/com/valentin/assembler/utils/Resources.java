package com.valentin.assembler.utils;

import java.util.HashMap;
import java.util.Map;

public class Resources {

	public static Map<String, String> symbols = new HashMap<>();
	public static Map<String, String> cDestinationMap = new HashMap<>();
	public static Map<String, String> cCompMap = new HashMap<>();
	public static Map<String, String> cJumpMap = new HashMap<>();
	
	static {
		for(int i = 0; i <= 15; i++)
			symbols.put("R" + i, String.valueOf(i));
		symbols.put("SCREEN", "16384");
		symbols.put("KBD", "24576");
		symbols.put("SP", "0");
		symbols.put("LCL", "1");
		symbols.put("ARG", "2");
		symbols.put("THIS", "3");
		symbols.put("THAT", "4");
		
		cDestinationMap.put(null, "000");
		cDestinationMap.put("M", "001");
		cDestinationMap.put("D", "010");
		cDestinationMap.put("MD", "011");
		cDestinationMap.put("A", "100");
		cDestinationMap.put("AM", "101");
		cDestinationMap.put("AD", "110");
		cDestinationMap.put("AMD", "111");
		
		cCompMap.put("0", "0101010");
		cCompMap.put("1", "0111111");
		cCompMap.put("-1", "0111010");
		cCompMap.put("D", "0001100");
		cCompMap.put("A", "0110000");
		cCompMap.put("M", "1110000");
		cCompMap.put("!D", "0001101");
		cCompMap.put("!A", "0110011");
		cCompMap.put("!M", "1110001");
		cCompMap.put("-D", "0001111");
		cCompMap.put("-A", "0110011");
		cCompMap.put("-M", "1110011");
		cCompMap.put("D+1", "0011111");
		cCompMap.put("A+1", "0110111");
		cCompMap.put("M+1", "1110111");
		cCompMap.put("D-1", "0001110");
		cCompMap.put("A-1", "0110010");
		cCompMap.put("M-1", "1110010");
		cCompMap.put("D+A", "0000010");
		cCompMap.put("D+M", "1000010");
		cCompMap.put("D-A", "0010011");
		cCompMap.put("D-M", "1010011");
		cCompMap.put("A-D", "0000111");
		cCompMap.put("M-D", "1000111");
		cCompMap.put("D&A", "0000000");
		cCompMap.put("D&M", "1000000");
		cCompMap.put("D|A", "0010101");
		cCompMap.put("D|M", "1010101");
		
		cJumpMap.put(null, "000");
		cJumpMap.put("JGT", "001");
		cJumpMap.put("JEQ", "010");
		cJumpMap.put("JGE", "011");
		cJumpMap.put("JLT", "100");
		cJumpMap.put("JNE", "101");
		cJumpMap.put("JLE", "110");
		cJumpMap.put("JMP", "111");
	}
}
