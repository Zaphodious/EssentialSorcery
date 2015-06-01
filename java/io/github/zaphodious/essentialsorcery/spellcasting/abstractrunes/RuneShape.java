package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class RuneShape extends Item implements Rune {

	protected int id;
	protected String name;
	
	protected RuneShape(int id, String name) {
		this.setCreativeTab(Reference.tabEssential);
		this.setUnlocalizedName(name);
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public abstract boolean deployTargetingEntity(Map<String,ItemStack> runeMap, World worldIn,
			EntityPlayer playerIn);

}
