package io.github.zaphodious.essentialsorcery.gui;

public enum Gui_Enum {
	RUNE_TABLE(0, "Rune Table"), TESTING_TABLE(1, "Testing Table");

	private int ID;
	private String name;

	private Gui_Enum(int ID, String name) {
		this.ID = ID;
		this.name = name;

	}
	
	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}
}