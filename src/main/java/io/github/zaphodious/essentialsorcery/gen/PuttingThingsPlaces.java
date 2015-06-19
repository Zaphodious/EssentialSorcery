package io.github.zaphodious.essentialsorcery.gen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PuttingThingsPlaces {

	public static boolean starmetalMeteorFall(World world, EntityPlayer player,
			BlockPos pos) {
		BlockPos skyDrop = new BlockPos(pos.getX(), 250, pos.getZ());
		boolean isAir = true;
		while (isAir) {
			if (world.getBlockState(skyDrop).getBlock() != Blocks.air) {
				if (world.getBlockState(skyDrop.down()).getBlock() == Blocks.air) {
					world.setBlockState(skyDrop, Blocks.air.getDefaultState());
					skyDrop = skyDrop.down();
				} else {
					isAir = false;
				}

			} else {
				skyDrop = skyDrop.down();
			}
		}

		if (!world.isRemote) {
			try {
				MinecraftServer
						.getServer()
						.getConfigurationManager()
						.sendChatMsg(
								new ChatComponentText(
										"A god has died, and his star has fallen near "
												+ player.getDisplayNameString()
												+ "."));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				MinecraftServer
						.getServer()
						.getConfigurationManager()
						.sendChatMsg(
								new ChatComponentText(
										"A god has died, and his star has fallen."));
			}

		}

		world.setBlockState(skyDrop, Blocks.glowstone.getDefaultState());
		world.setBlockState(skyDrop.east(), Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.west(), Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.north(), Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.south(), Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.north().east(),
				Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.north().west(),
				Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.south().east(),
				Blocks.air.getDefaultState());
		world.setBlockState(skyDrop.south().west(),
				Blocks.air.getDefaultState());

		return true;
	}

	public static boolean starmetalMeteorFall(World world, BlockPos pos) {
		return PuttingThingsPlaces.starmetalMeteorFall(world, null, pos);
	}

}
