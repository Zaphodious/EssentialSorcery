package io.github.zaphodious.essentialsorcery.client.render.block;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.client.render.item.ItemRenderRegister;
import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		addVariantsForDragonTap();
		/*
		 * 
		 * Supposedly, this lets us render our BlockItems. It doesn't seem to be working.
		 * 
		 */
		reg(ModBlocks.dragon_tap, 0, "dragon_tap_placed");
		reg(ModBlocks.dragon_tap, 1, "dragon_tap_set");
		reg(ModBlocks.dragon_tap, 2, "dragon_tap_spent");
	}
	
	public static void reg(Block block) {

		reg(block, 0, Reference.MODID + ":" + block.getUnlocalizedName().substring(5));
		
	}
	
	public static void reg(Block block, int meta, String file) {
	    Item item = Item.getItemFromBlock(block);
	    ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MODID + ":" + file, "inventory"));
	    System.out.println("Ran " + Reference.MODID + ":" +  block.getUnlocalizedName().substring(5) + " through the render reg.");

	}
	
	private static void addVariantsForDragonTap() {
		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.dragon_tap), "essentialsorcery:dragon_tap_placed", "essentialsorcery:dragon_tap_set", "essentialsorcery:dragon_tap_spent");
	}
	
}
