package io.github.zaphodious.essentialsorcery.client.render.item;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		reg(ModItems.tapSetter, 0);
		reg(ModItems.testWand, 0);
		
		reg(ModItems.stone_trowel, 0);
		reg(ModItems.obol, 0);

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
		reg(ModItems.rune_transport, 0);

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
		reg(ModItems.hobgoblin_placer, 0);


		

		regJade(ModItems.jade_raw, 0);
		regJade(ModItems.jade_raw, 1);
		regJade(ModItems.jade_raw, 2);
		regJade(ModItems.jade_raw, 3);
		regJade(ModItems.jade_raw, 4);

		regJade(ModItems.jade_dust, 0);
		regJade(ModItems.jade_dust, 1);
		regJade(ModItems.jade_dust, 2);
		regJade(ModItems.jade_dust, 3);
		regJade(ModItems.jade_dust, 4);
		
		regJade(ModItems.jade_alloy_dust, 0);
		regJade(ModItems.jade_alloy_dust, 1);
		regJade(ModItems.jade_alloy_dust, 2);
		regJade(ModItems.jade_alloy_dust, 3);
		regJade(ModItems.jade_alloy_dust, 4);
		
		regJade(ModItems.jade_nugget, 0);
		regJade(ModItems.jade_nugget, 1);
		regJade(ModItems.jade_nugget, 2);
		regJade(ModItems.jade_nugget, 3);
		regJade(ModItems.jade_nugget, 4);
		
		regJade(ModItems.jade_ingot, 0);
		regJade(ModItems.jade_ingot, 1);
		regJade(ModItems.jade_ingot, 2);
		regJade(ModItems.jade_ingot, 3);
		regJade(ModItems.jade_ingot, 4);
		
		reg(ModItems.moon_silver_ingot, 0);
		reg(ModItems.moon_silver_nugget, 0);
		
		
	}

	public static void reg(Item item, int meta) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						meta,
						new ModelResourceLocation(Reference.MODID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}

	public static void regJade(Item item, int meta) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						meta,
						new ModelResourceLocation(Reference.MODID + ":"
								+ item.getUnlocalizedName().substring(5) + "_"
								+ Element.getElementForID(meta).getColor(),
								"inventory"));
		System.out.println("registered " + Reference.MODID + ":"
				+ item.getUnlocalizedName().substring(5) + "_"
				+ Element.getElementForID(meta).getColor());
	}

	public static void registerVariants() {
		ModelBakery.addVariantName(ModItems.jade_raw, Reference.MODID + ":"
				+ ModItems.jade_raw.getUnlocalizedName().substring(5) + "_"
				+ Element.FIRE.getColor(), Reference.MODID + ":"
				+ ModItems.jade_raw.getUnlocalizedName().substring(5) + "_"
				+ Element.WATER.getColor(), Reference.MODID + ":"
				+ ModItems.jade_raw.getUnlocalizedName().substring(5) + "_"
				+ Element.AIR.getColor(), Reference.MODID + ":"
				+ ModItems.jade_raw.getUnlocalizedName().substring(5) + "_"
				+ Element.EARTH.getColor(), Reference.MODID + ":"
				+ ModItems.jade_raw.getUnlocalizedName().substring(5) + "_"
				+ Element.WOOD.getColor());

		ModelBakery.addVariantName(ModItems.jade_raw, Reference.MODID + ":"
				+ ModItems.jade_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.FIRE.getColor(), Reference.MODID + ":"
				+ ModItems.jade_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.WATER.getColor(), Reference.MODID + ":"
				+ ModItems.jade_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.AIR.getColor(), Reference.MODID + ":"
				+ ModItems.jade_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.EARTH.getColor(), Reference.MODID + ":"
				+ ModItems.jade_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.WOOD.getColor());
		
		ModelBakery.addVariantName(ModItems.jade_raw, Reference.MODID + ":"
				+ ModItems.jade_alloy_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.FIRE.getColor(), Reference.MODID + ":"
				+ ModItems.jade_alloy_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.WATER.getColor(), Reference.MODID + ":"
				+ ModItems.jade_alloy_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.AIR.getColor(), Reference.MODID + ":"
				+ ModItems.jade_alloy_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.EARTH.getColor(), Reference.MODID + ":"
				+ ModItems.jade_alloy_dust.getUnlocalizedName().substring(5) + "_"
				+ Element.WOOD.getColor());
		
		ModelBakery.addVariantName(ModItems.jade_nugget, Reference.MODID + ":"
				+ ModItems.jade_nugget.getUnlocalizedName().substring(5) + "_"
				+ Element.FIRE.getColor(), Reference.MODID + ":"
				+ ModItems.jade_nugget.getUnlocalizedName().substring(5) + "_"
				+ Element.WATER.getColor(), Reference.MODID + ":"
				+ ModItems.jade_nugget.getUnlocalizedName().substring(5) + "_"
				+ Element.AIR.getColor(), Reference.MODID + ":"
				+ ModItems.jade_nugget.getUnlocalizedName().substring(5) + "_"
				+ Element.EARTH.getColor(), Reference.MODID + ":"
				+ ModItems.jade_nugget.getUnlocalizedName().substring(5) + "_"
				+ Element.WOOD.getColor());
		
		ModelBakery.addVariantName(ModItems.jade_ingot, Reference.MODID + ":"
				+ ModItems.jade_ingot.getUnlocalizedName().substring(5) + "_"
				+ Element.FIRE.getColor(), Reference.MODID + ":"
				+ ModItems.jade_ingot.getUnlocalizedName().substring(5) + "_"
				+ Element.WATER.getColor(), Reference.MODID + ":"
				+ ModItems.jade_ingot.getUnlocalizedName().substring(5) + "_"
				+ Element.AIR.getColor(), Reference.MODID + ":"
				+ ModItems.jade_ingot.getUnlocalizedName().substring(5) + "_"
				+ Element.EARTH.getColor(), Reference.MODID + ":"
				+ ModItems.jade_ingot.getUnlocalizedName().substring(5) + "_"
				+ Element.WOOD.getColor());
	}

}
