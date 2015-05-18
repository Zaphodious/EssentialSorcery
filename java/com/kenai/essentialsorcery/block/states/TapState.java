package com.kenai.essentialsorcery.block.states;

import net.minecraft.util.IStringSerializable;

public enum TapState implements IStringSerializable{
	
	
	PLACED(0, "placed"),
	SET(1, "set"),
	SPENT(2, "spent");
	
	private int ID;
	private String name;
	
	private TapState(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}
	
}
