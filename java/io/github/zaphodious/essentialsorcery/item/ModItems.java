package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectAttack;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectDefend;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementAir;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementEarth;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementFire;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementWater;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementWood;
import io.github.zaphodious.essentialsorcery.item.rune.RuneShapeProjectile;
import io.github.zaphodious.essentialsorcery.item.rune.RuneShapeSelf;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static Item tapSetter;
	public static Item testWand;
	public static Item dragonTapPlacer;
	public static Item runeTablePlacer;
	
	
	/*    Rune variable declarations    */
	
	public static RuneEffectAttack rune_attack;
	public static RuneEffectDefend rune_defend;
	
	public static RuneElementAir rune_air;
	public static RuneElementWater rune_water;
	public static RuneElementEarth rune_earth;
	public static RuneElementWood rune_wood;
	public static RuneElementFire rune_fire;
	
	public static RuneShapeProjectile rune_projectile;
	public static RuneShapeSelf rune_self;
	

	public static void createItems() {
		GameRegistry.registerItem(tapSetter = new TapSetter("tap_setter"), "tap_setter");
		GameRegistry.registerItem(dragonTapPlacer = new DragonTapPlacer("dragon_tap_placer"), "dragon_tap_placer");
		GameRegistry.registerItem(testWand = new TestWand("test_wand", 8, Element.NEUTRAL), "test_wand");
		GameRegistry.registerItem(runeTablePlacer = new RuneTablePlacer("rune_table_placer"), "rune_table_placer");

		/*    Rune registrations    */
		GameRegistry.registerItem(rune_attack = new RuneEffectAttack(0, "rune_attack"), "rune_attack");
		GameRegistry.registerItem(rune_defend = new RuneEffectDefend(1, "rune_defend"), "rune_defend");
		
		GameRegistry.registerItem(rune_air = new RuneElementAir("rune_air"), "rune_air");
		GameRegistry.registerItem(rune_water = new RuneElementWater("rune_water"), "rune_water");
		GameRegistry.registerItem(rune_fire = new RuneElementFire("rune_fire"), "rune_fire");
		GameRegistry.registerItem(rune_earth = new RuneElementEarth("rune_earth"), "rune_earth");
		GameRegistry.registerItem(rune_wood = new RuneElementWood("rune_wood"), "rune_wood");
		
		GameRegistry.registerItem(rune_projectile = new RuneShapeProjectile(0, "rune_projectile"), "rune_projectile");
		GameRegistry.registerItem(rune_self = new RuneShapeSelf(1, "rune_self"), "rune_self");
	}
	
}
