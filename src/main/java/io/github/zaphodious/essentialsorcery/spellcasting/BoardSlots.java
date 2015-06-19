package io.github.zaphodious.essentialsorcery.spellcasting;

public enum BoardSlots {
	
	ELEMENT("element"),
	SHAPE("shape"),
	EFFECT("effect"),
	ESSENCE_CONTAINED("essenceContained");
	
	private String slotname;
	
	BoardSlots(String slotname) {
		this.slotname = slotname;
	}

	/**
	 * @return the slotname
	 */
	public String getSlotname() {
		return slotname;
	}
	
	

}
