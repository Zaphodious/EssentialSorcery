package io.github.zaphodious.essentialsorcery.item.renderitems;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PrettyBallBrown extends Item{
	public PrettyBallBrown(String unlocalizedName) {
		
		/*
		 * 
		 * This item exists as a shortcut. With it, we can
		 * bypass working with the tesselator directly, by passing
		 * its model to the part of this program that renders
		 * entities. 
		 * 
		 */
		
		this.setUnlocalizedName(unlocalizedName);
		//this.setCreativeTab(Reference.tabEssential);
		
	}
}
