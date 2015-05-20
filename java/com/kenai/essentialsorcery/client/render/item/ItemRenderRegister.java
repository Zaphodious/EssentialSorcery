package com.kenai.essentialsorcery.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.core.Reference;
import com.kenai.essentialsorcery.item.ModItems;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		reg(ModItems.tapSetter, 0);
		reg(ModItems.testWand, 0);
	}
	
	private static void reg(Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
