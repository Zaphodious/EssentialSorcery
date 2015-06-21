package io.github.zaphodious.essentialsorcery.item.metal;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class JadeDust extends Jade {

	public JadeDust(String unlocalizedName) {
		super(unlocalizedName);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		String elementName =
				this.getElement(stack).getName().substring(0, 1).toUpperCase()
						+ this.getElement(stack).getName().substring(1);
		tooltip.add(elementName + "-Aspected Imperial Bootpolish");
		tooltip.add("Note: does not actually polish boots.");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}
