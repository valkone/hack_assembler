package com.valentin.assembler.core;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {

	public static List<String> filter(List<String> commnds) {
		return commnds.stream()
				.filter(Filter::removeComments)
				.filter(Filter::removeEmptyLines)
				.map(Filter::removeCommandLineComments)
				.map(String::trim)
				.collect(Collectors.toList());
	}

	private static boolean removeComments(String line) {
		return !line.startsWith("//");
	}
	
	private static boolean removeEmptyLines(String line) {
		return !line.isEmpty();
	}

	private static String removeCommandLineComments(String line) {
		if(line.matches(".*\\/\\/.*"))
			line = line.substring(0, line.indexOf("//"));
		return line;
	}
}
