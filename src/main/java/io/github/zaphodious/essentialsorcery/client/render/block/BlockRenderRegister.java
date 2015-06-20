package io.github.zaphodious.essentialsorcery.client.render.block;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.block.states.DragonTapState;
import io.github.zaphodious.essentialsorcery.client.render.item.ItemRenderRegister;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		addBlockVariants();
		// reg(ModBlocks.dragon_tap);
		reg(ModBlocks.dragon_tap, 0, "dragon_tap_placed");
		reg(ModBlocks.dragon_tap, 1, "dragon_tap_set");
		reg(ModBlocks.dragon_tap, 2, "dragon_tap_spent");
		System.out.println(ModBlocks.rune_table
				+ "should be registered after this.");
		reg(ModBlocks.rune_table, 0, "rune_table");
		reg(ModBlocks.jade_ore, 0, "jade_ore");
	}

	public static void reg(Block block) {

		reg(block, 0, Reference.MODID
				+ ":"
				+ block.getUnlocalizedName().substring(5));

	}

	public static void reg(Block block, int meta, String file) {
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		// .register(Item.getItemFromBlock(block), meta, new
		// ModelResourceLocation(Reference.MODID + ":item/" + file,
		// "inventory"));
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block),
		// meta, new ModelResourceLocation(Reference.MODID + ":" + file,
		// "inventory"));
		Item item = Item.getItemFromBlock(block);
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,
		// meta, new ModelResourceLocation(Reference.MODID + ":" +
		// item.getUnlocalizedName().substring(5), "inventory"));
		ModelLoader.setCustomModelResourceLocation(
				item,
				meta,
				new ModelResourceLocation(
						Reference.MODID + ":" + file,
						"inventory"));
		// ItemRenderRegister.reg(item, meta);
		System.out.println("Ran "
				+ Reference.MODID
				+ ":"
				+ Item.getItemFromBlock(block).getUnlocalizedName()
				+ " through the render reg.");

	}

	public static void addBlockVariants() {
		ModelBakery.addVariantName(
				Item.getItemFromBlock(ModBlocks.dragon_tap),
				Reference.MODID
						+ ":"
						+ ModBlocks.dragon_tap
								.getUnlocalizedName()
								.substring(5)
						+ "_"
						+ DragonTapState.PLACED.getName(),
				Reference.MODID
						+ ":"
						+ ModBlocks.dragon_tap
								.getUnlocalizedName()
								.substring(5)
						+ "_"
						+ DragonTapState.SET.getName(),
				Reference.MODID
						+ ":"
						+ ModBlocks.dragon_tap
								.getUnlocalizedName()
								.substring(5)
						+ "_"
						+ DragonTapState.SPENT.getName());
	}

}
