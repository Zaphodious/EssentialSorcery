package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.block.jade.JadeBlock;
import io.github.zaphodious.essentialsorcery.block.jade.JadeOre;
import io.github.zaphodious.essentialsorcery.block.states.DragonTapState;
import io.github.zaphodious.essentialsorcery.block.states.StateEnum;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ItemBlockMeta;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static DragonTap dragon_tap;
	public static RuneTable rune_table;
	public static Block testing_table;
	public static JadeOre jade_ore;
	public static JadeBlock jade_block;
	public static MoonSilverBlock moon_silver_block;
	public static MagicField magic_field;
	public static StarMetalOre star_metal_ore;
	public static Block star_metal_block;

	public static void createBlocks() {

		dragon_tap = new DragonTap("dragon_tap");
		GameRegistry.registerBlock(dragon_tap, ItemBlockMeta.class, "dragon_tap");

		rune_table = new RuneTable("rune_table");
		GameRegistry.registerBlock(rune_table, "rune_table");

		jade_ore = new JadeOre("jade_ore");
		GameRegistry.registerBlock(jade_ore, "jade_ore");

		jade_block = new JadeBlock("jade_block");
		GameRegistry.registerBlock(jade_block, ItemBlockMeta.class, "jade_block");

		moon_silver_block = new MoonSilverBlock("moon_silver_block");
		GameRegistry.registerBlock(moon_silver_block, "moon_silver_block");

		magic_field = new MagicField("magic_field");
		GameRegistry.registerBlock(magic_field, "magic_field");

		star_metal_ore = new StarMetalOre("star_metal_ore");
		GameRegistry.registerBlock(star_metal_ore, "star_metal_ore");
		
		star_metal_block = new BasicBlock("star_metal_block");
		GameRegistry.registerBlock(star_metal_block, "star_metal_block");

	}

	private static Block register(Block block) {

		return block;
	}

	public static void registerRenders() {
		registerRender(rune_table);
		registerRender(star_metal_block);
		registerRender(star_metal_ore);
		registerRenderMeta(dragon_tap, DragonTapState.PLACED.getID(), DragonTapState.PLACED);
		registerRenderMeta(dragon_tap, DragonTapState.SET.getID(), DragonTapState.SET);
		registerRenderMeta(dragon_tap, DragonTapState.SPENT.getID(), DragonTapState.SPENT);
		registerRender(jade_ore);
		registerRenderMeta(jade_block, Element.FIRE.getID(), Element.FIRE);
		registerRenderMeta(jade_block, Element.AIR.getID(), Element.AIR);
		registerRenderMeta(jade_block, Element.WATER.getID(), Element.WATER);
		registerRenderMeta(jade_block, Element.EARTH.getID(), Element.EARTH);
		registerRenderMeta(jade_block, Element.WOOD.getID(), Element.WOOD);
		registerRender(moon_silver_block);
		registerRender(magic_field);

	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		registerRender(block, Reference.MODID + ":" + item.getUnlocalizedName().substring(5), 0);
	}

	public static void registerRenderMeta(Block block, int meta, StateEnum stateEnum) {
		Item item = Item.getItemFromBlock(block);
		registerRender(
				block,
				Reference.MODID + ":" + item.getUnlocalizedName().substring(5) + "_" + stateEnum.getStateName(),
				meta);
	}

	public static void registerRender(Block block, String name, int meta) {
		Item item = Item.getItemFromBlock(block);
		System.out.println(name
				+ " has been thrown into the render registry, as a sub-thingy of "
				+ block.getUnlocalizedName());
		ModelResourceLocation theThing = new ModelResourceLocation(name, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, theThing);
		System.out.println(theThing);
	}

	public static void addBlockVariants() {
		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.dragon_tap), Reference.MODID
				+ ":"
				+ ModBlocks.dragon_tap.getUnlocalizedName().substring(5)
				+ "_"
				+ DragonTapState.PLACED.getName(), Reference.MODID
				+ ":"
				+ ModBlocks.dragon_tap.getUnlocalizedName().substring(5)
				+ "_"
				+ DragonTapState.SET.getName(), Reference.MODID
				+ ":"
				+ ModBlocks.dragon_tap.getUnlocalizedName().substring(5)
				+ "_"
				+ DragonTapState.SPENT.getName());

		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.jade_block), Reference.MODID
				+ ":"
				+ ModBlocks.jade_block.getUnlocalizedName().substring(5)
				+ "_"
				+ Element.AIR.getStateName(), Reference.MODID
				+ ":"
				+ ModBlocks.jade_block.getUnlocalizedName().substring(5)
				+ "_"
				+ Element.FIRE.getStateName(), Reference.MODID
				+ ":"
				+ ModBlocks.jade_block.getUnlocalizedName().substring(5)
				+ "_"
				+ Element.WATER.getStateName(), Reference.MODID
				+ ":"
				+ ModBlocks.jade_block.getUnlocalizedName().substring(5)
				+ "_"
				+ Element.EARTH.getStateName(), Reference.MODID
				+ ":"
				+ ModBlocks.jade_block.getUnlocalizedName().substring(5)
				+ "_"
				+ Element.WOOD.getStateName());
	}

}
