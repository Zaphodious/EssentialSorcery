package com.kenai.essentialsorcery.client.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.core.Reference;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		addVariantsForDragonTap();
		reg(ModBlocks.dragon_tap);
		reg(ModBlocks.dragon_tap, 0, "dragon_tap_placed");
		reg(ModBlocks.dragon_tap, 1, "dragon_tap_set");
		reg(ModBlocks.dragon_tap, 2, "dragon_tap_spent");
	}
	
	public static void reg(Block block) {

		reg(block, 0, Reference.MODID + ":" + block.getUnlocalizedName().substring(5));
		
	}
	
	public static void reg(Block block, int meta, String file) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MODID + ":" + file, "inventory"));
	    System.out.println("Ran " + Reference.MODID + ":" +  block.getUnlocalizedName().substring(5) + " through the render reg.");

	}
	
	private static void addVariantsForDragonTap() {
		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.dragon_tap), "essentialsorcery:draton_tap_placed", "essentialsorcery:draton_tap_set", "essentialsorcery:draton_tap_spent");
	}
	
}
