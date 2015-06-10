package io.github.zaphodious.essentialsorcery.item.metal;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.item.Item;

public class JadeNugget extends Item {
	Element element;

	public JadeNugget(String unlocalizedName, Element element) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.element = element;
	}
}
