package io.github.zaphodious.essentialsorcery.event;

import io.github.zaphodious.essentialsorcery.gen.PuttingThingsPlaces;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {

	@SubscribeEvent
	public void NoRepairingRuneBoards(AnvilUpdateEvent event) {

		System.out.println(event.right);

	}

	@SubscribeEvent
	public void MakeDirtDropRunes(HarvestDropsEvent event) {
		ItemStack toAdd = null;
		if (event.state.getBlock() == Blocks.dirt
				|| event.state.getBlock() == Blocks.grass
				|| event.state.getBlock() == Blocks.sand) {
			try {
				if (event.harvester.getCurrentEquippedItem().getItem() == ModItems.stone_trowel) {

					toAdd = RuneHelper.getRuneToDrop(event);
					int testVariable = toAdd.stackSize;
				}
			} catch (Exception e) {

			}

			if (toAdd != null) {
				event.drops.clear();
				event.drops.add(toAdd);
			}
		}

	}

	@SubscribeEvent
	public void MakeStarsFall(HarvestDropsEvent event) {
		if (event.world.rand.nextFloat() < .000000002) {
			int xOffset = event.world.rand.nextInt(40) - 20;
			int zOffset = event.world.rand.nextInt(40) - 20;
			PuttingThingsPlaces.starmetalMeteorFall(event.world, event.harvester, new BlockPos(event.pos.getX() + xOffset, event.pos.getY(), event.pos.getZ() + zOffset));
		}
		
	}
		
}
