package io.github.zaphodious.essentialsorcery.item.runeglove;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.MaterialLevel;
import io.github.zaphodious.essentialsorcery.spellcasting.runeboards.BasicBoard;

public class GloveDiamond extends BasicBoard {

	public GloveDiamond(String unlocalizedName, Element element) {
		super(unlocalizedName, MaterialLevel.DIAMOND, element);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.item.Item#isRepairable()
	 */
	@Override
	public boolean isRepairable() {
		return false;
	}

}
