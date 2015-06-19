package io.github.zaphodious.essentialsorcery.block.states;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.block.properties.IProperty;
import net.minecraft.util.IStringSerializable;

public enum DragonTapState implements IStringSerializable, IProperty, StateEnum{
	
	
	PLACED(0, "placed"),
	SET(1, "set"),
	SPENT(2, "spent");
	
	private int ID;
	private String name;
	
	private DragonTapState(int ID, String name) {
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
		Collection<DragonTapState> toReturn = new ArrayList<DragonTapState>();
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
	
	public static DragonTapState getStateForID(int ID) {
		DragonTapState toReturn = null;
		for (DragonTapState state : DragonTapState.values()) {
			if (state.getID() == ID) {
				toReturn = state;
			}
		}
		return toReturn;
	}

	@Override
	public String getStateNameFromMeta(int meta) {
		return getStateForID(meta).getName();
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
