package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPlacer extends Item {
	
	/*
	 * this is a hack
	 * 
	 * A dirty, filthy hack.
	 * 
	 * There's a bug in this project, whereby all
	 * the BlockItems that would normally render... don't.
	 * I've tried to fix it, but I have literally no idea
	 * what's going wrong. So, this class exists. Rather
	 * then use BlockItems, we use this (which invokes
	 * the block item from the "toPlace" block) to place
	 * our blocks for us.
	 * 
	 * Ugh... need a shower.
	 */

	private Block toPlace;
	
	public BlockPlacer(String unlocalizedName, Block toPlace) {
		this.toPlace = toPlace;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.maxStackSize = 64;
	}


	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// TODO Auto-generated method stub
		
		return this.getItemFromBlock(toPlace).onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}
	
	public Item getBlockItem() {
		return this.getItemFromBlock(toPlace);
	}
	
	
	
}
