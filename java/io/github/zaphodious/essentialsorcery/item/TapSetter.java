package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.block.DragonTap;
import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.block.states.TapState;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.spellcasting.BiomeSorter;
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

public class TapSetter extends Item {


	public TapSetter(String unlocalizedName) {
		super();

		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.maxStackSize = 1;
        this.setMaxDamage(8);
	}

	

	
	
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		try {
			// First, this gets the blockstate for whatever block it's been used on.
			// If it's not a Dragon Tap (or its a "set" Dragon Tap), it places a dragon tap and the setter takes a point of damage.
			// If it's not a "set" dragon tap, it sets it.
			
			
			
			Reference.SORTER.getBiomeID(worldIn, pos);
			IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            System.out.println(iblockstate);
            
            if (block == ModBlocks.dragon_tap && (iblockstate.equals(ModBlocks.dragon_tap.getStateFromMeta(0)))) {
            	
            	DragonTap.dragonToSet(worldIn, pos);
            	//DragonTap dragonTap = (DragonTap) block;
            	//System.out.println(block.getDefaultState());
            	//dragonTap.setState(TapState.SET);
            } else {
            //	stack.damageItem(1, playerIn);
			//return this.getItemFromBlock(ModBlocks.dragon_tap).onItemUse(new ItemStack(Items.apple), playerIn, worldIn, pos, side, hitX, hitY, hitZ);
			// The new stack of apples is a hack to prevent this item from being used up when the player is in survival. If you know how to make it better, please do! :-D
            }
			
			
		} catch (Exception e) {
			System.out.println("doh! The TapSetter messed up. Here's the error: " + e.toString());
		}
		return false;
		
	}
	
}