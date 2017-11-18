package com.valentin.assembler.models;

public class CInstruction {

	public String dest;
	public String jump;
	public String comp;
	
	public String getDest() {
		return dest;
	}
	
	public CInstruction setDest(String dest) {
		this.dest = dest;
		return this;
	}
	
	public String getJump() {
		return jump;
	}
	
	public CInstruction setJump(String jump) {
		this.jump = jump;
		return this;
	}
	
	public String getComp() {
		return comp;
	}
	
	public CInstruction setComp(String comp) {
		this.comp = comp;
		return this;
	}
}
