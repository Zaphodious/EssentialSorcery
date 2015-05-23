package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static Item tapSetter;
	public static Item testWand;
	public static Item dragonTapPlacer;
	public static Item runeTablePlacer;

	public static void createItems() {
		GameRegistry.registerItem(tapSetter = new TapSetter("tap_setter"), "tap_setter");
		GameRegistry.registerItem(dragonTapPlacer = new DragonTapPlacer("dragon_tap_placer"), "dragon_tap_placer");
		GameRegistry.registerItem(testWand = new TestWand("test_wand", 8, Element.NEUTRAL), "test_wand");
		GameRegistry.registerItem(runeTablePlacer = new RuneTablePlacer("rune_table_placer"), "rune_table_placer");

	}
	
}
