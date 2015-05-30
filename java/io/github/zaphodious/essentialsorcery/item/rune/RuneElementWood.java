package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

public class RuneElementWood extends RuneElement {

	public RuneElementWood(String name) {
		super(Element.WOOD.getID(), name, Element.WOOD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Sylvan";
	}

}
