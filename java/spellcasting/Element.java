package spellcasting;

public enum Element {

	FIRE(0, "fire"),
	WATER(1, "water"),
	EARTH(2, "earth"),
	AIR(3, "air"),
	WOOD(4, "wood");
	
	private int ID;
	private String name;
	
	private Element(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
}
