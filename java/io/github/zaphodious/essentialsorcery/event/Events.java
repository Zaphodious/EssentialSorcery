package io.github.zaphodious.essentialsorcery.event;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {

	
	@SubscribeEvent
	public void MakeDirtDropRunes(HarvestDropsEvent event) {
		
		/*
		 * 
		 * First, we make an ItemStack to add to the event.drops
		 * list. If it's null by the end (which it will be if the
		 * RuneHelper.getRuneToDrop method doesn't determine
		 * that a rune will drop. Then nothing is added.
		 * 
		 * We then check to see if the block that is being harvested
		 * is a Dirt, Grass, or Sand block. If it's none of these
		 * things, then we don't do anything. If it is, *and*
		 * the player is holding a stone trowel (certain to be just
		 * "trowel" in future versions), we see if a rune is dropped.
		 * 
		 * See RuneHelper.java for more information on how
		 * rune drop rates are determined.
		 * 
		 */
		
		ItemStack toAdd = null;
		if (event.state.getBlock() == Blocks.dirt || event.state.getBlock() == Blocks.grass || event.state.getBlock() == Blocks.sand) {
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
	
	
}
