package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EssentialTab extends CreativeTabs {
	
	/*
	 * 
	 * Our creative tab. Thanks MrCrayFish! (the custom
	 * background graphic doesn't seem to actually work,
	 * however.)
	 * 
	 */

	public EssentialTab(String label) {
		super(label);
		//this.setBackgroundImageName("essential.png");
	}

	@Override
	public Item getTabIconItem() {
		
		return ModItems.dragonTapPlacer;
	}

}
