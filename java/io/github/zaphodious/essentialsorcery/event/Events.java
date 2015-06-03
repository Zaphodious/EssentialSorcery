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
		
		if (event.state.getBlock() == Blocks.dirt || event.state.getBlock() == Blocks.grass) {
			ItemStack toAdd = RuneHelper.getRuneToDrop(event);
			if (toAdd != null) {
				event.drops.add(toAdd);
			}
		}
		
		
	}
	
	
}
