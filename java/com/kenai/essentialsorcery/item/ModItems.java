package com.kenai.essentialsorcery.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static Item tapSetter;

	public static void createItems() {
		GameRegistry.registerItem(tapSetter = new TapSetter("tap_setter"), "tap_setter");
	}
	
}
