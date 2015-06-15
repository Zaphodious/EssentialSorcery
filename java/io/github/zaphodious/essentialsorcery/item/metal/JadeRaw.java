package io.github.zaphodious.essentialsorcery.item.metal;

import java.util.List;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class JadeRaw extends Jade {

	public JadeRaw(String unlocalizedName) {
		super (unlocalizedName);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#addInformation(net.minecraft.item.ItemStack, net.minecraft.entity.player.EntityPlayer, java.util.List, boolean)
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		String elementName = this.getElement(stack).getName().substring(0, 1).toUpperCase() + this.getElement(stack).getName().substring(1);
		tooltip.add(elementName+"-Aspected Raw Jade");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	
	
}
