package com.kenai.essentialsorcery.block;

import java.util.List;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.kenai.essentialsorcery.block.states.TapState;
import com.kenai.essentialsorcery.item.IMetaBlockName;

public class DragonTap extends BasicBlock implements IMetaBlockName {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", com.kenai.essentialsorcery.block.states.TapState.class);
	
	public DragonTap(String unlocalizedName) {
		super(unlocalizedName);

	    this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, TapState.PLACED));
		
	}

	public DragonTap setState(TapState newState) {
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, newState));
		return this;
	}
	
	
	@Override protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    IBlockState toReturn = null;
	    if (meta == 1) {
	    	toReturn = getDefaultState().withProperty(TYPE, TapState.SET);
	    } else if (meta == 2) {
	    	toReturn = getDefaultState().withProperty(TYPE, TapState.SPENT);
	    } else {
	    	toReturn = getDefaultState().withProperty(TYPE, TapState.PLACED);
	    }
		return toReturn;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    TapState type = (TapState) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	    list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	    list.add(new ItemStack(itemIn, 1, 2)); //Meta 2
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}


	@Override
	public String getSpecialName(ItemStack stack) {
		String toReturn = "placed";
		
		if (stack.getItemDamage() == 1) {
			toReturn = "set";
		} else if (stack.getItemDamage() == 2) {
			toReturn = "spent";
		}
		
		return toReturn;
	}
	
	
}
