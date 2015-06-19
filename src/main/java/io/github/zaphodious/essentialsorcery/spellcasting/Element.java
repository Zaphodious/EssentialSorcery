package io.github.zaphodious.essentialsorcery.spellcasting;

import net.minecraft.util.IStringSerializable;

public enum Element implements IStringSerializable {

	FIRE(0, "fire", "red"),
	WATER(1, "water", "black"),
	EARTH(2, "earth", "white"),
	AIR(3, "air", "blue"),
	WOOD(4, "wood", "green"),
	NEUTRAL(5, "neutral", "red");
	
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
		return this.getName();
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
	
}
