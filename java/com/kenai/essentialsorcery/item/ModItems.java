package com.kenai.essentialsorcery.item;

import spellcasting.Element;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static Item tapSetter;
	public static Item testWand;

	public static void createItems() {
		GameRegistry.registerItem(tapSetter = new TapSetter("tap_setter"), "tap_setter");
		GameRegistry.registerItem(testWand = new TestWand("test_wand", 8, Element.NEUTRAL), "test_wand");
	}
	
}
