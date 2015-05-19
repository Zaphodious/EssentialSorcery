package com.kenai.essentialsorcery.item;

import spellcasting.BiomeSorter;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.block.states.TapState;
import com.kenai.essentialsorcery.util.Setter;

public class TapSetter extends Item {


	public TapSetter(String unlocalizedName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.maxStackSize = 1;
        this.setMaxDamage(8);
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
			BiomeSorter sorter = new BiomeSorter();
			sorter.getBiome(worldIn, pos);
			IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            System.out.println(iblockstate);
            
            if (block == ModBlocks.dragon_tap && !iblockstate.equals(ModBlocks.dragon_tap_set.getDefaultState())) {

            	Setter.dragonToSet(worldIn, pos);
            	//DragonTap dragonTap = (DragonTap) block;
            	//System.out.println(block.getDefaultState());
            	//dragonTap.setState(TapState.SET);
            } else {
            	stack.damageItem(1, playerIn);
			return this.getItemFromBlock(ModBlocks.dragon_tap).onItemUse(new ItemStack(Items.apple), playerIn, worldIn, pos, side, hitX, hitY, hitZ);
			// The new stack of apples is a hack to prevent this item from being used up when the player is in survival. If you know how to make it better, please do! :-D
            }
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
		
	}
	
}