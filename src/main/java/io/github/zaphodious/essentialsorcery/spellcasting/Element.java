package io.github.zaphodious.essentialsorcery.spellcasting;

import io.github.zaphodious.essentialsorcery.block.states.StateEnum;
import net.minecraft.util.IStringSerializable;

public enum Element implements IStringSerializable, StateEnum {

	FIRE(0, "fire", "red"), WATER(1, "water", "black"), EARTH(
			2,
			"earth",
			"white"), AIR(3, "air", "blue"), WOOD(4, "wood", "green"), NEUTRAL(
			5,
			"neutral",
			"clear");

	private int ID;
	private String name;
	private String color;

	private Element(int ID, String name, String color) {
		this.ID = ID;
		this.name = name;
		this.color = color;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return this.getStateName();
	}

	public static Element getElementForID(int ID) {
		Element toReturn = null;
		for (Element element : Element.values()) {
			if (element.getID() == ID) {
				toReturn = element;
			}
		}
		return toReturn;
	}

	@Override
	public String getStateNameFromMeta(int meta) {
		return getElementForID(meta).getColor();
	}

	@Override
	public String getStateName() {
		return color;
	}

}
