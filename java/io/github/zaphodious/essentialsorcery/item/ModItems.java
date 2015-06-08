package io.github.zaphodious.essentialsorcery.item;

import io.github.zaphodious.essentialsorcery.entity.monster.EntityHobgoblin;
import io.github.zaphodious.essentialsorcery.item.renderitems.PrettyBallBlue;
import io.github.zaphodious.essentialsorcery.item.renderitems.PrettyBallBrown;
import io.github.zaphodious.essentialsorcery.item.renderitems.PrettyBallGreen;
import io.github.zaphodious.essentialsorcery.item.renderitems.PrettyBallRed;
import io.github.zaphodious.essentialsorcery.item.renderitems.PrettyBallYellow;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectAttack;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectDefend;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectSpawnVanilla;
import io.github.zaphodious.essentialsorcery.item.rune.RuneEffectTransportation;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementAir;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementEarth;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementFire;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementWater;
import io.github.zaphodious.essentialsorcery.item.rune.RuneElementWood;
import io.github.zaphodious.essentialsorcery.item.rune.RuneShapeProjectile;
import io.github.zaphodious.essentialsorcery.item.rune.RuneShapeSelf;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveDiamond;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveGold;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveIron;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveLeather;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveStone;
import io.github.zaphodious.essentialsorcery.item.runeglove.GloveWood;
import io.github.zaphodious.essentialsorcery.spellcasting.DropChance;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static ToolMaterial STONETROWEL = EnumHelper.addToolMaterial("STONETROWEL", 1, 60, 1F, 0, 5);
	
	public static Item tapSetter;
	public static Item testWand;
	public static Item dragonTapPlacer;
	public static Item runeTablePlacer;
	
	public static Item prettyBallRed;
	public static Item prettyBallGreen;
	public static Item prettyBallBlue;
	public static Item prettyBallBrown;
	public static Item prettyBallYellow;
	
	public static Item stone_trowel;
	
	
	/*    Rune variable declarations    */
	
	public static RuneEffectAttack rune_attack;
	public static RuneEffectDefend rune_defend;
	public static RuneEffectSpawnVanilla rune_spawn_vanilla;
	public static RuneEffectTransportation rune_transport;
	
	public static RuneElementAir rune_air;
	public static RuneElementWater rune_water;
	public static RuneElementEarth rune_earth;
	public static RuneElementWood rune_wood;
	public static RuneElementFire rune_fire;
	
	public static RuneShapeProjectile rune_projectile;
	public static RuneShapeSelf rune_self;
	
	
	/*    Casting variable declarations   */
	
	public static GloveWood glove_wood_air;
	public static GloveWood glove_wood_earth;
	public static GloveWood glove_wood_fire;
	public static GloveWood glove_wood_water;
	public static GloveWood glove_wood_wood;
	
	public static GloveLeather glove_leather_air;
	public static GloveLeather glove_leather_earth;
	public static GloveLeather glove_leather_fire;
	public static GloveLeather glove_leather_water;
	public static GloveLeather glove_leather_wood;
	
	public static GloveStone glove_stone_air;
	public static GloveStone glove_stone_earth;
	public static GloveStone glove_stone_fire;
	public static GloveStone glove_stone_water;
	public static GloveStone glove_stone_wood;
	
	public static GloveIron glove_iron_air;
	public static GloveIron glove_iron_earth;
	public static GloveIron glove_iron_fire;
	public static GloveIron glove_iron_water;
	public static GloveIron glove_iron_wood;
	
	public static GloveGold glove_gold_air;
	public static GloveGold glove_gold_earth;
	public static GloveGold glove_gold_fire;
	public static GloveGold glove_gold_water;
	public static GloveGold glove_gold_wood;
	
	public static GloveDiamond glove_diamond_air;
	public static GloveDiamond glove_diamond_earth;
	public static GloveDiamond glove_diamond_fire;
	public static GloveDiamond glove_diamond_water;
	public static GloveDiamond glove_diamond_wood;
	
	public static EssentialMonsterPlacer hobgoblin_placer;
	

	public static void createItems() {
		GameRegistry.registerItem(tapSetter = new TapSetter("tap_setter"), "tap_setter");
		GameRegistry.registerItem(dragonTapPlacer = new DragonTapPlacer("dragon_tap_placer"), "dragon_tap_placer");
		GameRegistry.registerItem(testWand = new TestWand("test_wand", 8, Element.NEUTRAL), "test_wand");
		GameRegistry.registerItem(runeTablePlacer = new RuneTablePlacer("rune_table_placer"), "rune_table_placer");
		
		GameRegistry.registerItem(prettyBallRed = new PrettyBallRed("pretty_ball_red"), "pretty_ball_red");
		GameRegistry.registerItem(prettyBallYellow = new PrettyBallYellow("pretty_ball_yellow"), "pretty_ball_yellow");
		GameRegistry.registerItem(prettyBallGreen = new PrettyBallGreen("pretty_ball_green"), "pretty_ball_green");
		GameRegistry.registerItem(prettyBallBlue = new PrettyBallBlue("pretty_ball_blue"), "pretty_ball_blue");
		GameRegistry.registerItem(prettyBallBrown = new PrettyBallBrown("pretty_ball_brown"), "pretty_ball_brown");
		
		GameRegistry.registerItem(stone_trowel = new Trowel("stone_trowel", ModItems.STONETROWEL), "stone_trowel");

		 GameRegistry.registerItem(hobgoblin_placer = new EssentialMonsterPlacer("hobgoblin_placer", EntityHobgoblin.class, 0xFFA62E, 0x820000), "hobgoblin_placer");

		/*    Rune registrations    */
		GameRegistry.registerItem(rune_attack = new RuneEffectAttack(0, "rune_attack"), "rune_attack");
		GameRegistry.registerItem(rune_defend = new RuneEffectDefend(1, "rune_defend"), "rune_defend");
		GameRegistry.registerItem(rune_spawn_vanilla = new RuneEffectSpawnVanilla(2, "rune_spawn_vanilla"), "rune_spawn_vanilla");
		GameRegistry.registerItem(rune_transport = new RuneEffectTransportation(3, "rune_transport"), "rune_transport");
		
		GameRegistry.registerItem(rune_air = new RuneElementAir("rune_air"), "rune_air");
		GameRegistry.registerItem(rune_water = new RuneElementWater("rune_water"), "rune_water");
		GameRegistry.registerItem(rune_fire = new RuneElementFire("rune_fire"), "rune_fire");
		GameRegistry.registerItem(rune_earth = new RuneElementEarth("rune_earth"), "rune_earth");
		GameRegistry.registerItem(rune_wood = new RuneElementWood("rune_wood"), "rune_wood");
		
		GameRegistry.registerItem(rune_projectile = new RuneShapeProjectile(0, "rune_projectile"), "rune_projectile");
		GameRegistry.registerItem(rune_self = new RuneShapeSelf(1, "rune_self"), "rune_self");
		
		
		/*    Casting registrations   */
		
		GameRegistry.registerItem(glove_wood_air = new GloveWood("glove_wood_air",Element.AIR), "glove_wood_air");
		GameRegistry.registerItem(glove_wood_earth = new GloveWood("glove_wood_earth",Element.EARTH), "glove_wood_earth");
		GameRegistry.registerItem(glove_wood_fire = new GloveWood("glove_wood_fire",Element.FIRE), "glove_wood_fire");
		GameRegistry.registerItem(glove_wood_water = new GloveWood("glove_wood_water",Element.WATER), "glove_wood_water");
		GameRegistry.registerItem(glove_wood_wood = new GloveWood("glove_wood_wood",Element.WOOD), "glove_wood_wood");
		
		GameRegistry.registerItem(glove_leather_air = new GloveLeather("glove_leather_air",Element.AIR), "glove_leather_air");
		GameRegistry.registerItem(glove_leather_earth = new GloveLeather("glove_leather_earth",Element.EARTH), "glove_leather_earth");
		GameRegistry.registerItem(glove_leather_fire = new GloveLeather("glove_leather_fire",Element.FIRE), "glove_leather_fire");
		GameRegistry.registerItem(glove_leather_water = new GloveLeather("glove_leather_water",Element.WATER), "glove_leather_water");
		GameRegistry.registerItem(glove_leather_wood = new GloveLeather("glove_leather_wood",Element.WOOD), "glove_leather_wood");
		
		GameRegistry.registerItem(glove_stone_air = new GloveStone("glove_stone_air",Element.AIR), "glove_stone_air");
		GameRegistry.registerItem(glove_stone_earth = new GloveStone("glove_stone_earth",Element.EARTH), "glove_stone_earth");
		GameRegistry.registerItem(glove_stone_fire = new GloveStone("glove_stone_fire",Element.FIRE), "glove_stone_fire");
		GameRegistry.registerItem(glove_stone_water = new GloveStone("glove_stone_water",Element.WATER), "glove_stone_water");
		GameRegistry.registerItem(glove_stone_wood = new GloveStone("glove_stone_wood",Element.WOOD), "glove_stone_wood");
		
		GameRegistry.registerItem(glove_iron_air = new GloveIron("glove_iron_air",Element.AIR), "glove_iron_air");
		GameRegistry.registerItem(glove_iron_earth = new GloveIron("glove_iron_earth",Element.EARTH), "glove_iron_earth");
		GameRegistry.registerItem(glove_iron_fire = new GloveIron("glove_iron_fire",Element.FIRE), "glove_iron_fire");
		GameRegistry.registerItem(glove_iron_water = new GloveIron("glove_iron_water",Element.WATER), "glove_iron_water");
		GameRegistry.registerItem(glove_iron_wood = new GloveIron("glove_iron_wood",Element.WOOD), "glove_iron_wood");
		
		GameRegistry.registerItem(glove_gold_air = new GloveGold("glove_gold_air",Element.AIR), "glove_gold_air");
		GameRegistry.registerItem(glove_gold_earth = new GloveGold("glove_gold_earth",Element.EARTH), "glove_gold_earth");
		GameRegistry.registerItem(glove_gold_fire = new GloveGold("glove_gold_fire",Element.FIRE), "glove_gold_fire");
		GameRegistry.registerItem(glove_gold_water = new GloveGold("glove_gold_water",Element.WATER), "glove_gold_water");
		GameRegistry.registerItem(glove_gold_wood = new GloveGold("glove_gold_wood",Element.WOOD), "glove_gold_wood");
		
		GameRegistry.registerItem(glove_diamond_air = new GloveDiamond("glove_diamond_air",Element.AIR), "glove_diamond_air");
		GameRegistry.registerItem(glove_diamond_earth = new GloveDiamond("glove_diamond_earth",Element.EARTH), "glove_diamond_earth");
		GameRegistry.registerItem(glove_diamond_fire = new GloveDiamond("glove_diamond_fire",Element.FIRE), "glove_diamond_fire");
		GameRegistry.registerItem(glove_diamond_water = new GloveDiamond("glove_diamond_water",Element.WATER), "glove_diamond_water");
		GameRegistry.registerItem(glove_diamond_wood = new GloveDiamond("glove_diamond_wood",Element.WOOD), "glove_diamond_wood");
	}
	
	public static void putRunesIntoDropList() {
		RuneHelper.addRuneToDropList(rune_attack, DropChance.COMMON);
		RuneHelper.addRuneToDropList(rune_defend, DropChance.COMMON);
		RuneHelper.addRuneToDropList(rune_transport, DropChance.COMMON);
		RuneHelper.addRuneToDropList(rune_spawn_vanilla, DropChance.RARE);
		RuneHelper.addRuneToDropList(rune_projectile, DropChance.UNCOMMON);
		RuneHelper.addRuneToDropList(rune_self, DropChance.UNCOMMON);
	}
	
	public static ArrayList<RuneElement> getElementRunes() {
		ArrayList<RuneElement> toReturn = new ArrayList<RuneElement>();
		
		toReturn.add(rune_air);
		toReturn.add(rune_earth);
		toReturn.add(rune_fire);
		toReturn.add(rune_water);
		toReturn.add(rune_wood);
		
		
		return toReturn;
	}
	
	public static ArrayList<Item> getBoardRegistery(){
		
		/*Adding these items to a list helps sort through them quickly, meaning that
		I don't need to hard-code in every single one of them into the custom crafting stuff.*/
		
		ArrayList<Item> toReturn = new ArrayList<Item>();
		
		toReturn.add(glove_wood_air);
		toReturn.add(glove_wood_air);
		toReturn.add(glove_wood_earth);
		toReturn.add(glove_wood_fire);
		toReturn.add(glove_wood_water);
		toReturn.add(glove_wood_wood);
		
		toReturn.add(glove_leather_air);
		toReturn.add(glove_leather_earth);
		toReturn.add(glove_leather_fire);
		toReturn.add(glove_leather_water);
		toReturn.add(glove_leather_wood);
		
		toReturn.add(glove_stone_air);
		toReturn.add(glove_stone_earth);
		toReturn.add(glove_stone_fire);
		toReturn.add(glove_stone_water);
		toReturn.add(glove_stone_wood);
		
		toReturn.add(glove_iron_air);
		toReturn.add(glove_iron_earth);
		toReturn.add(glove_iron_fire);
		toReturn.add(glove_iron_water);
		toReturn.add(glove_iron_wood);
		
		toReturn.add(glove_gold_air);
		toReturn.add(glove_gold_earth);
		toReturn.add(glove_gold_fire);
		toReturn.add(glove_gold_water);
		toReturn.add(glove_gold_wood);
		
		toReturn.add(glove_diamond_air);
		toReturn.add(glove_diamond_earth);
		toReturn.add(glove_diamond_fire);
		toReturn.add(glove_diamond_water);
		toReturn.add(glove_diamond_wood);
		
		return toReturn;
	}
	
}
