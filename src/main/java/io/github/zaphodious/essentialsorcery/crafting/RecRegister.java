package io.github.zaphodious.essentialsorcery.crafting;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cyano.basemetals.registry.CrusherRecipeRegistry;

public class RecRegister {

	public static void makeRecipes() {
		ItemStack plankStack = new ItemStack(Blocks.planks);
		ItemStack craftingStack = new ItemStack(Blocks.crafting_table);
		ItemStack stickStack = new ItemStack(Items.stick);
		ItemStack woolStack = new ItemStack(Blocks.wool);
		ItemStack cobbleStack = new ItemStack(Blocks.cobblestone);
		ItemStack coalStack = new ItemStack(Items.coal);
		
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.rune_table),
	    "xxx",
	    "zyz",
	    "xxx",
	    'x', plankStack, 'y', craftingStack, 'z', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.tapSetter),
		"  y",
		"xy ",
		"yx ",
		'x', woolStack, 'y', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.dragon_tap, 1, 0),
		"yyx",
		"yxz",
		"xxx",
		'x', cobbleStack, 'y', coalStack, 'z', woolStack);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stone_trowel),
				
				"zx",
				"yz",
				'x', cobbleStack, 'y', stickStack, 'z', woolStack);

		
		addXWithReverse(ModItems.jade_ingot, Item.getItemFromBlock(ModBlocks.jade_block_black), Element.WATER.getID(), 0, 2);
		addXWithReverse(ModItems.jade_ingot, Item.getItemFromBlock(ModBlocks.jade_block_white), Element.EARTH.getID(), 0, 2);
		addXWithReverse(ModItems.jade_ingot, Item.getItemFromBlock(ModBlocks.jade_block_green), Element.WOOD.getID(), 0, 2);
		addXWithReverse(ModItems.jade_ingot, Item.getItemFromBlock(ModBlocks.jade_block_red), Element.FIRE.getID(), 0, 2);
		addXWithReverse(ModItems.jade_ingot, Item.getItemFromBlock(ModBlocks.jade_block_blue), Element.AIR.getID(), 0, 2);
		
		addXWithReverse(ModItems.moon_silver_ingot, Item.getItemFromBlock(ModBlocks.moon_silver_block), 0, 0, 3);
		
		add3x3(ModItems.obol, Items.emerald, 0, 0);
		addXWithReverse(ModItems.moon_silver_nugget, ModItems.moon_silver_ingot, 0, 0, 3);
		
		
		for (int i = 0; i < 5; i++) {
			addXWithReverse(ModItems.jade_nugget, ModItems.jade_ingot, i, i, 3);
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.jade_alloy_dust, 2, i),
					new ItemStack(ModItems.jade_dust, 1, i), new ItemStack(ModItems.jade_dust, 1, i), new ItemStack(ModItems.jade_dust, 1, i), "dustSteel"));
			GameRegistry.addSmelting(new ItemStack(ModItems.jade_alloy_dust, 1, i), new ItemStack(ModItems.jade_ingot, 1, i), 1.0F);
			CrusherRecipeRegistry.addNewCrusherRecipe(new ItemStack(ModItems.jade_raw, 1, i), new ItemStack(ModItems.jade_dust, 2, i));
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obol), new ItemStack(ModItems.jade_raw, 1, i));
		}
		

	}
	
	private static void add3x3(Item input, Item result, int metaInput, int metaResult) {
		GameRegistry.addRecipe(new ItemStack(result, 1, metaResult),
				"xxx",
				"xxx",
				"xxx",
				'x', new ItemStack(input, 1, metaInput));
		
	}
	
	private static void add2x2(Item input, Item result, int metaInput, int metaResult) {
		GameRegistry.addRecipe(new ItemStack(result, 1, metaResult),

				"xx",
				"xx",
				'x', new ItemStack(input, 1, metaInput));
	}
	
	private static void addXWithReverse(Item input, Item result, int metaInput, int metaResult, int amount) {
		
		switch (amount) {
		case 1: GameRegistry.addShapelessRecipe(new ItemStack(result, 1, metaResult), new ItemStack(input, 1, metaInput));
			break;
		case 2: add2x2(input, result, metaInput, metaResult);
			break;
		case 3: add3x3(input, result, metaInput, metaResult);
			break;
		default: System.out.println("The amount number needs to be between 1 and 3. You put " + amount);
			return;
		}
		
		GameRegistry.addShapelessRecipe(new ItemStack(input, amount*amount, metaInput), new ItemStack(result, 1, metaResult));
		
	}
	
	
	
}
