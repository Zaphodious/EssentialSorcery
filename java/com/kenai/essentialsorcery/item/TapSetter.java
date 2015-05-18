package com.kenai.essentialsorcery.item;

import com.kenai.essentialsorcery.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class TapSetter extends Item {
	
	Block block;

	public TapSetter(String unlocalizedName) {
		super();
		
		
		this.block = ModBlocks.dragon_tap;
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
	//	return Item.getItemFromBlock(block).onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
		
	//}
	
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	
    	
    	try {
    		return Item.getItemFromBlock(block).onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
    	} catch (Exception exc) {
    		System.out.println("Yep, here's the error: " + exc.toString());
    	}
    	return false;
    }
    
    
    
	
}
