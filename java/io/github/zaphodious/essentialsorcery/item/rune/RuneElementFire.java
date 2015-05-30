package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

public class RuneElementFire extends RuneElement {

	public RuneElementFire(String name) {
		super(Element.FIRE.getID(), name, Element.FIRE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Incandescent";
	}

}
