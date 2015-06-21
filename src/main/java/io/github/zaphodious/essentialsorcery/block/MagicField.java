package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.core.Reference;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicField extends BlockBreakable {

	protected MagicField(String unlocalizedName) {
		super(Material.glass, false);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Reference.tabEssential);
		this.setTickRandomly(true);

	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	public boolean isFullCube() {
		return false;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// TODO Auto-generated method stub
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	}

	public int getLightOpacity(World world, int x, int y, int z) {
		return 0;
	}

	@Override
	public int getLightValue(IBlockAccess world, BlockPos pos) {

		return 5;
	}

}
