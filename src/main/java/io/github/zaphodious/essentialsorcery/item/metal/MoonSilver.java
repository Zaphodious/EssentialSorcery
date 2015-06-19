package io.github.zaphodious.essentialsorcery.item.metal;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MoonSilver extends Item {
	
	String tooltip;

	public MoonSilver(String unlocalizedName, String tooltipName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		

		String a = (Reference.doesBeginWithVowel(tooltipName)) ? "An " : "A ";
		this.tooltip = a + tooltipName + " Of Pure Potential";
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		
		tooltip.add(this.tooltip);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	
}
