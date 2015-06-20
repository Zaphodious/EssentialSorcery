package io.github.zaphodious.essentialsorcery.spellcasting.manse;

import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.Essence;
import io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import cyano.poweradvantage.api.PoweredEntity;
import cyano.poweradvantage.api.simple.BlockSimpleFluidConsumer;

public abstract class Hearth extends BlockSimpleFluidConsumer
		implements
		GivesEssence {

	Element element;

	public Hearth(Material blockMaterial, float hardness) {
		super(blockMaterial, hardness);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence#getEssence
	 * (net.minecraft.world.World, net.minecraft.util.BlockPos)
	 */
	@Override
	public Essence getEssence(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence#getElement
	 * (net.minecraft.world.World, net.minecraft.util.BlockPos)
	 */
	@Override
	public Element getElement(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.zaphodious.essentialsorcery.spellcasting.GivesEssence#canTap
	 * (net.minecraft.world.World, net.minecraft.util.BlockPos)
	 */
	@Override
	public Boolean canTap(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#createNewTileEntity
	 * (net.minecraft.world.World, int)
	 */
	@Override
	public PoweredEntity createNewTileEntity(World world, int metaDataValue) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#getItemDropped
	 * (net.minecraft.block.state.IBlockState, java.util.Random, int)
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random prng, int i3) {
		// TODO Auto-generated method stub
		return super.getItemDropped(state, prng, i3);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#
	 * hasComparatorInputOverride()
	 */
	@Override
	public boolean hasComparatorInputOverride() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#
	 * getComparatorInputOverride(net.minecraft.world.World,
	 * net.minecraft.util.BlockPos)
	 */
	@Override
	public int getComparatorInputOverride(World world, BlockPos coord) {
		// TODO Auto-generated method stub
		return 0;
	}

}
