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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TapSetter extends Item {


	public TapSetter(String unlocalizedName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	// public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World
	// worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float
	// hitZ) {
	// return Item.getItemFromBlock(block).onItemUse(stack, playerIn, worldIn,
	// pos, side, hitX, hitY, hitZ);

	// }

	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		try {
			return this.getItemFromBlock(ModBlocks.dragon_tap).onItemUse(new ItemStack(Items.apple), playerIn, worldIn, pos, side, hitX, hitY, hitZ);
			// The new stack of apples is a hack to prevent this item from being used up when the player is in survival. If you know how to make it better, please do! :-D
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
		
	}
	
}