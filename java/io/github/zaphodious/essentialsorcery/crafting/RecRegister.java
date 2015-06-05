package io.github.zaphodious.essentialsorcery.crafting;

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
				
				
		
	}
	
}
