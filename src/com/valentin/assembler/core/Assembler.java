package com.valentin.assembler.core;

import java.io.IOException;
import java.util.List;

import com.valentin.assembler.utils.Utils;

public class Assembler {
	
	public List<String> assemble(String programPath) throws IOException {
		Translator t = new Translator();
		
		return t.translateProgram(
				t.replaceLabels(
						Filter.filter(
								Utils.getProgram(programPath))));
	}
}
