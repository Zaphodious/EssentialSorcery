package io.github.zaphodious.essentialsorcery.gen;

import ibxm.Player;
import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class PuttingThingsPlaces {

	public static boolean starmetalMeteorFall(World world, EntityPlayer player, BlockPos pos, boolean fallDirect) {

		try {
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
						// world.setBlockState(skyDrop,
						// ModBlocks.magic_field.getDefaultState());
						replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop);

						skyDrop = skyDrop.down();

					} else {
						isAir = false;

					}

				} else {
					replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop);
					if (counterNorth == northSeverity && !fallDirect) {
						skyDrop = (goingNorth) ? skyDrop.north() : skyDrop.south();
						counterNorth = 0;
						replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop);
					}
					if (counterWest == westSeverity && !fallDirect) {
						skyDrop = (goingWest) ? skyDrop.west() : skyDrop.east();
						counterWest = 0;
						replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop);
					}

					// world.setBlockState(skyDrop,
					// ModBlocks.magic_field.getDefaultState());
					skyDrop = skyDrop.down();
				}
			}

			if (!world.isRemote) {
				try {
					MinecraftServer
							.getServer()
							.getConfigurationManager()
							.sendChatMsg(
									new ChatComponentText("A god has died, and his star has fallen near "
											+ player.getDisplayNameString()
											+ "."));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					MinecraftServer
							.getServer()
							.getConfigurationManager()
							.sendChatMsg(new ChatComponentText("A god has died, and his star has fallen."));
				}

			}
			if (world.isRemote) {
				world.playSound(
						skyDrop.getX(),
						skyDrop.getY(),
						skyDrop.getZ(),
						Reference.MODID + ":event.meteor.crash",
						10F,
						1.0F,
						true);
			}

			replaceWith(world, ModBlocks.star_metal_ore.getDefaultState(), skyDrop);
			
			try {
				fauxExplosion(world, skyDrop, true, 5);
			} catch (Exception e) {
				
			}

			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.east());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.west());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north().east());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north().west());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south().east());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south().west());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.east().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.west().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north().east().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.north().west().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south().east().up());
			replaceWith(world, ModBlocks.magic_field.getDefaultState(), skyDrop.south().west().up());
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public static boolean starmetalMeteorFall(World world, EntityPlayer player, BlockPos pos) {
		return starmetalMeteorFall(world, player, pos, false);
	}

	public static boolean starmetalMeteorFall(World world, BlockPos pos) {
		return PuttingThingsPlaces.starmetalMeteorFall(world, null, pos);
	}

	public static boolean putARoomHere(World world, BlockPos pos) {
		BlockPos skyDrop = new BlockPos(pos.getX(), 250, pos.getZ());
		while (true) {
			if (world.getBlockState(skyDrop).getBlock() == Blocks.air) {

				skyDrop = skyDrop.down();
			} else {
				break;
			}
		}

		GenTest.makeASimpleBuilding(
				world,
				skyDrop,
				world.rand.nextInt(10 + 2),
				world.rand.nextInt(10 + 2),
				world.rand.nextInt(10 + 2));

		return true;
	}

	public static IBlockState replaceWith(World world, IBlockState state, BlockPos pos) {

		world.destroyBlock(pos, true);
		world.setBlockState(pos, state);
		return world.getBlockState(pos);
	}

	@SuppressWarnings("null")
	public static boolean fauxExplosion(World world, BlockPos pos, boolean fire, double radius) {

		if (fire) {
			EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), radius);
			if (player != null) {
				return false;
			}
			if (!player.isImmuneToExplosions() && !player.isImmuneToFire()) {
				if (fire) {
					player.setFire(20);
					player.knockBack(player, 6, 1, 6);

				}

			}
		}

		return true;
	}

}
