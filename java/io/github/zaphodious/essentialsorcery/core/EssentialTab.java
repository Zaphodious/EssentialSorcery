package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EssentialTab extends CreativeTabs {

	public EssentialTab(String label) {
		super(label);
		//this.setBackgroundImageName("essential.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return ModItems.dragonTapPlacer;
	}

}
