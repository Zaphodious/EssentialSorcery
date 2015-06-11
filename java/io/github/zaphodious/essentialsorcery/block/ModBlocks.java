package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.block.jade.JadeBlock;
import io.github.zaphodious.essentialsorcery.block.jade.JadeOre;
import io.github.zaphodious.essentialsorcery.block.states.TapState;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ItemBlockMeta;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static DragonTap dragon_tap;
	public static RuneTable rune_table;
	public static Block testing_table;
	public static JadeOre jade_ore;
	public static JadeBlock jade_block_red;
	public static JadeBlock jade_block_white;
	public static JadeBlock jade_block_blue;
	public static JadeBlock jade_block_green;
	public static JadeBlock jade_block_black;
	

	public static void createBlocks() {

		dragon_tap = new DragonTap("dragon_tap");
		GameRegistry.registerBlock(dragon_tap, ItemBlockMeta.class,
				"dragon_tap");
		
		rune_table = new RuneTable("rune_table");
		GameRegistry.registerBlock(rune_table, "rune_table");

		jade_ore = new JadeOre("jade_ore");
		GameRegistry.registerBlock(jade_ore, "jade_ore");

		jade_block_red = new JadeBlock("jade_block_red", Element.FIRE);
		GameRegistry.registerBlock(jade_block_red, "jade_block_red");
		
		jade_block_white = new JadeBlock("jade_block_white", Element.EARTH);
		GameRegistry.registerBlock(jade_block_white, "jade_block_white");
		
		jade_block_blue = new JadeBlock("jade_block_blue", Element.AIR);
		GameRegistry.registerBlock(jade_block_blue, "jade_block_blue");
		
		jade_block_green = new JadeBlock("jade_block_green", Element.WOOD);
		GameRegistry.registerBlock(jade_block_green, "jade_block_green");
		
		jade_block_black = new JadeBlock("jade_block_black", Element.WATER);
		GameRegistry.registerBlock(jade_block_black, "jade_block_black");
		

	}

	private static Block register(Block block) {

		return block;
	}

	public static void registerRenders() {
		registerRender(rune_table);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		System.out
				.println(Reference.MODID
						+ ":"
						+ item.getUnlocalizedName().substring(5)
						+ " has been thrown into the render registry, as a sub-thingy of "
						+ block.getUnlocalizedName());
		ModelResourceLocation theThing = new ModelResourceLocation(
				Reference.MODID + ":" + item.getUnlocalizedName().substring(5),
				"inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(item, 0, theThing);
		System.out.println(theThing);
	}

}
