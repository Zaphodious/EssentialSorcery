package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

public class RuneElementWater extends RuneElement {

	public RuneElementWater(String name) {
		super(Element.WATER.getID(), name , Element.WATER);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Shimmering";
	}

}
