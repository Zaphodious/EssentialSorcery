package io.github.zaphodious.essentialsorcery.client.render.item;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		reg(ModItems.tapSetter, 0);
		reg(ModItems.testWand, 0);
		reg(ModItems.dragonTapPlacer, 0);
		reg(ModItems.runeTablePlacer, 0);
		
		reg(ModItems.prettyBallRed, 0);
		reg(ModItems.prettyBallBlue, 0);
		reg(ModItems.prettyBallGreen, 0);
		reg(ModItems.prettyBallYellow, 0);
		reg(ModItems.prettyBallBrown, 0);
		
		reg(ModItems.rune_air, 0);
		reg(ModItems.rune_earth, 0);
		reg(ModItems.rune_fire, 0);
		reg(ModItems.rune_water, 0);
		reg(ModItems.rune_wood, 0);
		
		reg(ModItems.rune_attack, 0);
		reg(ModItems.rune_defend, 0);
		reg(ModItems.rune_spawn_vanilla, 0);
		
		reg(ModItems.rune_projectile, 0);
		reg(ModItems.rune_self, 0);
		
		
		reg(ModItems.glove_wood_air, 0);
		reg(ModItems.glove_wood_earth, 0);
		reg(ModItems.glove_wood_fire, 0);
		reg(ModItems.glove_wood_water, 0);
		reg(ModItems.glove_wood_wood, 0);
		
		reg(ModItems.glove_leather_air, 0);
		reg(ModItems.glove_leather_earth, 0);
		reg(ModItems.glove_leather_fire, 0);
		reg(ModItems.glove_leather_water, 0);
		reg(ModItems.glove_leather_wood, 0);
		
		reg(ModItems.glove_stone_air, 0);
		reg(ModItems.glove_stone_earth, 0);
		reg(ModItems.glove_stone_fire, 0);
		reg(ModItems.glove_stone_water, 0);
		reg(ModItems.glove_stone_wood, 0);
		
		reg(ModItems.glove_iron_air, 0);
		reg(ModItems.glove_iron_earth, 0);
		reg(ModItems.glove_iron_fire, 0);
		reg(ModItems.glove_iron_water, 0);
		reg(ModItems.glove_iron_wood, 0);
		
		reg(ModItems.glove_gold_air, 0);
		reg(ModItems.glove_gold_earth, 0);
		reg(ModItems.glove_gold_fire, 0);
		reg(ModItems.glove_gold_water, 0);
		reg(ModItems.glove_gold_wood, 0);
		
		reg(ModItems.glove_diamond_air, 0);
		reg(ModItems.glove_diamond_earth, 0);
		reg(ModItems.glove_diamond_fire, 0);
		reg(ModItems.glove_diamond_water, 0);
		reg(ModItems.glove_diamond_wood, 0);
		
	}
	
	public static void reg(Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	
	
}
