package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectAttack;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectDefend;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectSpawnVanilla;
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
	
	public static Item prettyBallRed;
	public static Item prettyBallGreen;
	public static Item prettyBallBlue;
	public static Item prettyBallBrown;
	public static Item prettyBallYellow;
	
	
	/*    Rune variable declarations    */
	
	public static RuneEffectAttack rune_attack;
	public static RuneEffectDefend rune_defend;
	public static RuneEffectSpawnVanilla rune_spawn_vanilla;
	
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
		
		GameRegistry.registerItem(prettyBallRed = new RuneTablePlacer("pretty_ball_red"), "pretty_ball_red");
		GameRegistry.registerItem(prettyBallYellow = new RuneTablePlacer("pretty_ball_yellow"), "pretty_ball_yellow");
		GameRegistry.registerItem(prettyBallGreen = new RuneTablePlacer("pretty_ball_green"), "pretty_ball_green");
		GameRegistry.registerItem(prettyBallBlue = new RuneTablePlacer("pretty_ball_blue"), "pretty_ball_blue");
		GameRegistry.registerItem(prettyBallBrown = new RuneTablePlacer("pretty_ball_brown"), "pretty_ball_brown");
		

		/*    Rune registrations    */
		GameRegistry.registerItem(rune_attack = new RuneEffectAttack(0, "rune_attack"), "rune_attack");
		GameRegistry.registerItem(rune_defend = new RuneEffectDefend(1, "rune_defend"), "rune_defend");
		GameRegistry.registerItem(rune_spawn_vanilla = new RuneEffectSpawnVanilla(2, "rune_spawn_vanilla"), "rune_spawn_vanilla");
		
		GameRegistry.registerItem(rune_air = new RuneElementAir("rune_air"), "rune_air");
		GameRegistry.registerItem(rune_water = new RuneElementWater("rune_water"), "rune_water");
		GameRegistry.registerItem(rune_fire = new RuneElementFire("rune_fire"), "rune_fire");
		GameRegistry.registerItem(rune_earth = new RuneElementEarth("rune_earth"), "rune_earth");
		GameRegistry.registerItem(rune_wood = new RuneElementWood("rune_wood"), "rune_wood");
		
		GameRegistry.registerItem(rune_projectile = new RuneShapeProjectile(0, "rune_projectile"), "rune_projectile");
		GameRegistry.registerItem(rune_self = new RuneShapeSelf(1, "rune_self"), "rune_self");
	}
	
}
