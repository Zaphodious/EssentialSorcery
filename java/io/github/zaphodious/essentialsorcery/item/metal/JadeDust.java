package io.github.zaphodious.essentialsorcery.item.metal;

import java.util.List;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JadeDust extends Item {
	
	Element element;

	public JadeDust(String unlocalizedName, Element element) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.element = element;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack, net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		String elementName = element.getName().substring(0, 1).toUpperCase() + element.getName().substring(1);
		tooltip.add(elementName+"-Aspected Imperial Bootpolish");
		tooltip.add("Note: does not actually polish boots.");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	
	
}
