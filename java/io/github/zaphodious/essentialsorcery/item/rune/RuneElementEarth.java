package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

public class RuneElementEarth extends RuneElement {

	public RuneElementEarth(String name) {
		super(Element.EARTH.getID(), name, Element.EARTH);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Unshakable";
	}

}
