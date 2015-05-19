package com.kenai.essentialsorcery.util;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.kenai.essentialsorcery.block.ModBlocks;

public class Setter {

	
	
	
	
	public static void dragonToSet(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, ModBlocks.dragon_tap_set.getDefaultState());
	}
	
}
