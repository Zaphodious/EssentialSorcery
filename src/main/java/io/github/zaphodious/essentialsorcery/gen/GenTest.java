package io.github.zaphodious.essentialsorcery.gen;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class GenTest {

	public static boolean makeAWall(
			ItemStack stack,
			EntityPlayer player,
			World world,
			BlockPos pos,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ) {
		BlockPos workingPos = null;
		for (int j = 0; j < 10; j++) {
			workingPos = pos.up(j);
			for (int i = 0; i < 5; i++) {
				workingPos = (i == 0) ? workingPos : workingPos.west();
				IBlockState toPlace =
						(j > 5 || j < 3) ? ModBlocks.moon_silver_block.getDefaultState() : Blocks.coal_block
								.getDefaultState();
				world.setBlockState(workingPos, toPlace, 3);

				world.setBlockState(workingPos.south(), Blocks.air.getDefaultState(), 3);
				world.setBlockState(workingPos.north(), Blocks.air.getDefaultState(), 3);
			}

		}
		return true;
	}

	public static boolean makeASimpleBuilding(
			ItemStack stack,
			EntityPlayer player,
			World world,
			BlockPos pos,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ,
			int buildHeight,
			int buildWidth,
			int buildLength) {

		BlockPos workingPos = null;
		IBlockState toPlace = Blocks.cobblestone.getDefaultState();
		boolean[] bounds = new boolean[3];

		for (int i = 0; i <= buildWidth; i++) {
			bounds[0] = i == buildWidth || i == 0;
			for (int j = 0; j <= buildHeight; j++) {
				bounds[1] = j == buildHeight || j == 0;
				for (int k = 0; k <= buildLength; k++) {
					bounds[2] = k == buildLength || k == 0;

					if (!bounds[0] && !bounds[1] && !bounds[2]) {
						toPlace = Blocks.air.getDefaultState();
					} else {
						toPlace = Blocks.cobblestone.getDefaultState();
					}
					workingPos = pos.add(i, j, k);

					world.setBlockState(workingPos, toPlace, 3);
				}
			}
		}

		/*
		 * for (int j = 0; j <= buildHeight; j++) { workingPos = pos.up(j+1);
		 * for (int i = 0; i <= buildWidth; i++) { workingPos = (i==0) ?
		 * workingPos : workingPos.west(); IBlockState toPlace =
		 * Blocks.cobblestone.getDefaultState();
		 * 
		 * for (int k = 0; k <= buildLength; k++) { if (i != 0 && i !=
		 * buildWidth && j != buildHeight && k != buildLength) { toPlace =
		 * Blocks.air.getDefaultState(); } workingPos = (k==0) ?
		 * workingPos:workingPos.north(); world.setBlockState(workingPos,
		 * toPlace, 3);
		 * 
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

		return true;
	}
	
	public static boolean genTestStructure(World world, BlockPos pos){
		return genTestStructure(null, null, world, pos, null, 0,0,0);
	}

	public static boolean genTestStructure(
			ItemStack stack,
			EntityPlayer player,
			World world,
			BlockPos pos,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		world.setBlockState(new BlockPos(x + 0, y + 0, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 0), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 0), Blocks.lapis_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 1), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 0, z + 7), Blocks.lapis_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 0, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 7), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 1), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 1), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 2), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 3), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 3), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 4), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 5), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 6), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), Blocks.cobblestone.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 6), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 1, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 1, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 1), Blocks.wool.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), Blocks.wool.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), Blocks.bedrock.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 2, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 2, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 3), Blocks.lapis_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 4), Blocks.lapis_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 3, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 3, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 0), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 1), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 2), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 3), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 4), Blocks.lapis_block.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 4), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 5), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 6), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 4, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 4, z + 7), Blocks.air.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 7), Blocks.air.getDefaultState(), 3);
		return true;
	}
}
