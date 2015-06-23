package io.github.zaphodious.essentialsorcery.gen;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class EssentialWorldGen implements IWorldGenerator {

	@Override
	public void generate(
			Random random,
			int chunkX,
			int chunkZ,
			World world,
			IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimensionId()) {
		case -1:
			generateNether(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		case 0:
			generateOverworld(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		case 1:
			generateEnd(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;

		}

	}

	private void generateEnd(
			Random random,
			int i,
			int j,
			World world,
			IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub

	}

	private void generateOverworld(
			Random random,
			int i,
			int j,
			World world,
			IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {

		/*int counter = 0;
		while (counter < 4) {
			
			//do(stuff);
			
			counter++;
		}*/
		//for (int counter = 0; counter < 4; counter++) {

		
				
				world.setBlockState(new BlockPos(i*random.nextInt(16), 100, j*random.nextInt(16)), Blocks.glowstone.getDefaultState());

		//}

	}

	private void generateNether(
			Random random,
			int i,
			int j,
			World world,
			IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub

	}

}
