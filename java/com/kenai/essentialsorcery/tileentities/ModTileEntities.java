package com.kenai.essentialsorcery.tileentities;

import com.kenai.essentialsorcery.block.ModBlocks;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRuneTable.class, TileEntityRuneTable.getID());
		System.out.println("registered the Rune Table");
	}
	
}
