package com.valentin.assembler;

import java.util.List;

import com.valentin.assembler.core.Assembler;

public class Program {
	
	public static void main(String args[]) throws Exception {
		List<String> commands = new Assembler().assemble("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/rect/Rect.asm");
		
		commands.stream()
			.forEach(System.out::println);
	}
}
