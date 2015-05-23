package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.block.states.TapState;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ItemBlockMeta;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {

	public static DragonTap dragon_tap;
	public static Block rune_table;
	
	public static void createBlocks() {
		
		GameRegistry.registerBlock(dragon_tap = new DragonTap("dragon_tap"), ItemBlockMeta.class, "dragon_tap");
		GameRegistry.registerBlock(rune_table = new RuneTable("rune_table"), "rune_table");
		
		
		System.out.println("registered " + dragon_tap.getUnlocalizedName());
		//dragon_tap.setLightOpacity(1);
		
		//dragon_tap_set = dragon_tap.setState(TapState.SET);
		//dragon_tap_set.setLightLevel(1);
		
	}
	
	private static Block register(Block block) {
		
		return block;
	}
	
	public static void registerRenders() {
		registerRender(rune_table);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		System.out.println(Reference.MODID + ":" + item.getUnlocalizedName().substring(5) + " has been thrown into the render registry, as a sub-thingy of " + block.getUnlocalizedName());
		ModelResourceLocation theThing = new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, theThing);
		System.out.println(theThing);
	}
	
}
