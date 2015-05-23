package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRuneTable.class, TileEntityRuneTable.getID());
		System.out.println("registered the Rune Table");
	}
	
}
