package com.gmail.ptimofejev;

public class Letter {
	private int symbolCode;
	private int uses;

	public Letter() {

	}

	public Letter(int symbolCode, int uses) {
		this.symbolCode = symbolCode;
		this.uses = uses;
	}

	public int getSymbolCode() {
		return symbolCode;
	}

	public void setSymbolCode(int symbolCode) {
		this.symbolCode = symbolCode;
	}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}

	@Override
	public String toString() {
		return "Letter " + (char) symbolCode + ", uses=" + uses + "]";
	}

}
