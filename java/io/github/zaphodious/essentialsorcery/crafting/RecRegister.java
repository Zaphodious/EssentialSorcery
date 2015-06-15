package io.github.zaphodious.essentialsorcery.crafting;

import cyano.basemetals.registry.CrusherRecipeRegistry;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecRegister {

	public static void makeRecipes() {
		ItemStack plankStack = new ItemStack(Blocks.planks);
		ItemStack craftingStack = new ItemStack(Blocks.crafting_table);
		ItemStack stickStack = new ItemStack(Items.stick);
		ItemStack woolStack = new ItemStack(Blocks.wool);
		ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
		ItemStack coalStack = new ItemStack(Items.coal);
		ItemStack steelStack = new ItemStack(cyano.basemetals.init.Items.steel_ingot);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.runeTablePlacer),
	    "xxx",
	    "zyz",
	    "xxx",
	    'x', plankStack, 'y', craftingStack, 'z', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.tapSetter),
		"  y",
		"xy ",
		"yx ",
		'x', woolStack, 'y', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.dragonTapPlacer),
		"yyx",
		"yxz",
		"xxx",
		'x', cobbleStack, 'y', coalStack, 'z', woolStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stone_trowel),
				
				"zx",
				"yz",
				'x', cobbleStack, 'y', stickStack, 'z', woolStack);

		

		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockBlackPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_ingot, 1, Element.WATER.getID()));
				
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockWhitePlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_ingot, 1, Element.EARTH.getID()));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockGreenPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_ingot, 1, Element.WOOD.getID()));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockRedPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_ingot, 1, Element.FIRE.getID()));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockBluePlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_ingot, 1, Element.AIR.getID()));
		
		
		for (int i = 0; i < 5; i++) {
			GameRegistry.addRecipe(new ItemStack(ModItems.jade_ingot, 1, i),
					"xxx",
					"xyx",
					"xxx",
					'x', new ItemStack(ModItems.jade_nugget, 1, i), 'y', steelStack);
			GameRegistry.addSmelting(new ItemStack(ModItems.jade_dust, 1, i), new ItemStack(ModItems.jade_nugget, 1, i), 1.0F);
			CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(ModItems.jade_raw, 1, i), new ItemStack(ModItems.jade_dust, 2, i));
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_raw, 0, i));
			System.out.println("the i value of " + i + " has been run through the system");
		}
		

	}
	
}
