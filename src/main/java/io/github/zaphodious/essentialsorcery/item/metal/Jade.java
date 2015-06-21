package io.github.zaphodious.essentialsorcery.item.metal;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class Jade extends Item {

	String tooltipName;

	protected Jade(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.setHasSubtypes(true);
	}

	protected Jade(String unlocalizedName, String tooltipName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.setHasSubtypes(true);
		this.tooltipName = tooltipName;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return super.getUnlocalizedName() + "_" + this.getElement(stack).getColor();

	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		String elementName =
				this.getElement(stack).getName().substring(0, 1).toUpperCase()
						+ this.getElement(stack).getName().substring(1);
		tooltip.add(elementName + "-Aspected " + tooltipName);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 5; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}

	public Element getElement(ItemStack stackIn) {
		if (stackIn.getItem() instanceof Jade) {
			Element toReturn = Element.FIRE;
			for (Element element : Element.values()) {
				if (element.getID() == stackIn.getItemDamage()) {
					toReturn = element;
				}
			}
			return toReturn;
		} else {
			return null;
		}

	}

}
