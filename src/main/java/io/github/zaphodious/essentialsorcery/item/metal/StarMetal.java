package io.github.zaphodious.essentialsorcery.item.metal;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StarMetal extends Item {

	String tooltip;
	
	public StarMetal(String unlocalizedName, String tooltipName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		String a = (Reference.doesBeginWithVowel(tooltipName)) ? "An " : "A ";
		this.tooltip = a + tooltipName + "-Sized Piece of A Dead God";
	}
	
	@Override
	public void addInformation(
			ItemStack stack,
			EntityPlayer playerIn,
			List tooltip,
			boolean advanced) {

		tooltip.add(this.tooltip);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
