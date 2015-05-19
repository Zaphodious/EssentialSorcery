package com.kenai.essentialsorcery.block;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.kenai.essentialsorcery.block.states.TapState;
import com.kenai.essentialsorcery.item.ItemBlockMeta;

public final class ModBlocks {

	public static DragonTap dragon_tap;
	public static DragonTap dragon_tap_set;
	
	public static void createBlocks() {
		
		GameRegistry.registerBlock(dragon_tap = new DragonTap("dragon_tap"), ItemBlockMeta.class, "dragon_tap");
		System.out.println("registered " + dragon_tap.getUnlocalizedName());
		
		dragon_tap_set = dragon_tap.setState(TapState.SET);
	}
	
	private static Block reg(Block block) {
		
		return block;
	}
	
}
