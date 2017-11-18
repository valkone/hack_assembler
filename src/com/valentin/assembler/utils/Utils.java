package com.valentin.assembler.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static String repeat(String toRepeat, int times) {
	    return Collections.nCopies(times, toRepeat).stream()
	    		.collect(Collectors.joining(""));
	}
	
	public static String toBinary(String num) {
		return Integer.toBinaryString(Integer.parseInt(num));
	}
	
	public static List<String> getProgram(String programPath) throws IOException {
		return Files.lines(Paths.get(programPath))
			.collect(Collectors.toList());
	}
}
