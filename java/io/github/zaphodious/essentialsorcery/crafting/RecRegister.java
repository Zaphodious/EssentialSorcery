package io.github.zaphodious.essentialsorcery.crafting;

import cyano.basemetals.registry.CrusherRecipeRegistry;
import io.github.zaphodious.essentialsorcery.item.ModItems;
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
		
		
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jade_black_ingot),
				"xxx",
				"xyx",
				"xxx",
				'x', new ItemStack(ModItems.jade_black_nugget), 'y', steelStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jade_blue_ingot),
				"xxx",
				"xyx",
				"xxx",
				'x', new ItemStack(ModItems.jade_blue_nugget), 'y', steelStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jade_red_ingot),
				"xxx",
				"xyx",
				"xxx",
				'x', new ItemStack(ModItems.jade_red_nugget), 'y', steelStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jade_white_ingot),
				"xxx",
				"xyx",
				"xxx",
				'x', new ItemStack(ModItems.jade_white_nugget), 'y', steelStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jade_green_ingot),
				"xxx",
				"xyx",
				"xxx",
				'x', new ItemStack(ModItems.jade_green_nugget), 'y', steelStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockBlackPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_black_ingot));
				
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockWhitePlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_white_ingot));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockGreenPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_green_ingot));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockRedPlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_red_ingot));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.jadeBlockBluePlacer),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(ModItems.jade_blue_ingot));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_green_raw));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_red_raw));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_black_raw));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_blue_raw));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_white_raw));
				
		GameRegistry.addSmelting(ModItems.jade_black_dust, new ItemStack(ModItems.jade_black_nugget), 1.0F);
		GameRegistry.addSmelting(ModItems.jade_blue_dust, new ItemStack(ModItems.jade_blue_nugget), 1.0F);
		GameRegistry.addSmelting(ModItems.jade_red_dust, new ItemStack(ModItems.jade_red_nugget), 1.0F);
		GameRegistry.addSmelting(ModItems.jade_white_dust, new ItemStack(ModItems.jade_white_nugget), 1.0F);
		GameRegistry.addSmelting(ModItems.jade_green_dust, new ItemStack(ModItems.jade_green_nugget), 1.0F);
		
		CrusherRecipeRegistry.addNewCrusherRecipe(ModItems.jade_green_raw, new ItemStack(ModItems.jade_green_dust));
		CrusherRecipeRegistry.addNewCrusherRecipe(ModItems.jade_red_raw, new ItemStack(ModItems.jade_red_dust));
		CrusherRecipeRegistry.addNewCrusherRecipe(ModItems.jade_black_raw, new ItemStack(ModItems.jade_black_dust));
		CrusherRecipeRegistry.addNewCrusherRecipe(ModItems.jade_blue_raw, new ItemStack(ModItems.jade_blue_dust));
		CrusherRecipeRegistry.addNewCrusherRecipe(ModItems.jade_white_raw, new ItemStack(ModItems.jade_white_dust));
	}
	
}
