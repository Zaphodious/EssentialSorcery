package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

public class RuneElementAir extends RuneElement {

	public RuneElementAir(String name) {
		super(Element.AIR.getID(), name, Element.AIR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Blusterous";
	}

}
