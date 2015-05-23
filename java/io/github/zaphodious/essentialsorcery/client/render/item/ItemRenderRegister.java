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
	}
	
	public static void reg(Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	
	
}
