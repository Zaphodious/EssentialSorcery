package io.github.zaphodious.essentialsorcery.spellcasting;

import net.minecraft.util.IStringSerializable;

public enum Element implements IStringSerializable {

	FIRE(0, "fire"),
	WATER(1, "water"),
	EARTH(2, "earth"),
	AIR(3, "air"),
	WOOD(4, "wood"),
	NEUTRAL(5, "neutral");
	
	private int ID;
	private String name;
	
	private Element(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
