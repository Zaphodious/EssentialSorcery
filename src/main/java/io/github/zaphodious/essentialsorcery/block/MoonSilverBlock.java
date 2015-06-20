package io.github.zaphodious.essentialsorcery.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class MoonSilverBlock extends BasicBlock {

	public MoonSilverBlock(String unlocalizedName) {
		super(unlocalizedName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getItemDropped(net.minecraft.block.state.
	 * IBlockState, java.util.Random, int)
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return super.getItemDropped(state, rand, fortune);
	}

}
