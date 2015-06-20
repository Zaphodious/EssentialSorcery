package io.github.zaphodious.essentialsorcery.spellcasting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface UsesEssence {

	public boolean useTap(
			World worldIn,
			BlockPos pos,
			ItemStack stack,
			EntityPlayer playerIn);

	public Element getElement();

	public void setElement(Element elementIn);

	public boolean useEssence(int req, ItemStack stackIn);

	public int getCost(ItemStack stackIn);

	public boolean takeInEssence(Essence essenceIn, ItemStack stackIn);

}