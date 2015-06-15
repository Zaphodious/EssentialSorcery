package io.github.zaphodious.essentialsorcery.item.metal;

import java.util.List;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class Jade extends Item {

	protected Jade(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return super.getUnlocalizedName() + "_"
				+ this.getElement(stack).getColor();

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
