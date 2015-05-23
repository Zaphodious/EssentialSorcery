package io.github.zaphodious.essentialsorcery.block.states;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.block.properties.IProperty;
import net.minecraft.util.IStringSerializable;

public enum TapState implements IStringSerializable, IProperty{
	
	
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

	@Override
	public Collection getAllowedValues() {
		Collection<TapState> toReturn = new ArrayList<TapState>();
		toReturn.add(PLACED);
		toReturn.add(SET);
		toReturn.add(SPENT);
		return toReturn;
	}

	@Override
	public Class getValueClass() {
		return this.getClass();
	}

	@Override
	public String getName(Comparable value) {
		// TODO Auto-generated method stub
		return value.toString();
	}
	
}
