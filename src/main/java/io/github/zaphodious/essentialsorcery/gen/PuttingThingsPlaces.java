package io.github.zaphodious.essentialsorcery.gen;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PuttingThingsPlaces {

	public static boolean starmetalMeteorFall(
			World world,
			EntityPlayer player,
			BlockPos pos) {
		boolean goingNorth = world.rand.nextBoolean();
		int northSeverity = world.rand.nextInt(20);
		boolean goingWest = world.rand.nextBoolean();
		int westSeverity = world.rand.nextInt(20);
		int counterNorth = 0;
		int counterWest = 0;
		BlockPos skyDrop = new BlockPos(pos.getX(), 250, pos.getZ());
		boolean isAir = true;
		while (isAir) {
			counterNorth++;
			counterWest++;
			if (world.getBlockState(skyDrop).getBlock() != Blocks.air
					&& world.getBlockState(skyDrop).getBlock() != Blocks.water) {

				if (world.getBlockState(skyDrop.down()).getBlock() == Blocks.air) {
					world.setBlockState(
							skyDrop,
							ModBlocks.magic_field.getDefaultState());

					skyDrop = skyDrop.down();

				} else {
					isAir = false;

				}

			} else {
				world.setBlockState(
						skyDrop,
						ModBlocks.magic_field.getDefaultState());
				if (counterNorth == northSeverity) {
					skyDrop = (goingNorth) ? skyDrop.north() : skyDrop.south();
					counterNorth = 0;
				}
				if (counterWest == westSeverity) {
					skyDrop = (goingWest) ? skyDrop.west() : skyDrop.east();
					counterWest = 0;
				}
				world.setBlockState(
						skyDrop,
						ModBlocks.magic_field.getDefaultState());
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
		world.playSound(
				skyDrop.getX(),
				skyDrop.getY(),
				skyDrop.getZ(),
				Reference.MODID + ":event.meteor.crash",
				10F,
				1.0F,
				true);
		world
				.setBlockState(
						skyDrop,
						ModBlocks.star_metal_ore.getDefaultState());
		world.setBlockState(
				skyDrop.east(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.west(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north().east(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north().west(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south().east(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south().west(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.east().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.west().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north().east().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.north().west().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south().east().up(),
				ModBlocks.magic_field.getDefaultState());
		world.setBlockState(
				skyDrop.south().west().up(),
				ModBlocks.magic_field.getDefaultState());

		return true;
	}

	public static boolean starmetalMeteorFall(World world, BlockPos pos) {
		return PuttingThingsPlaces.starmetalMeteorFall(world, null, pos);
	}

}
