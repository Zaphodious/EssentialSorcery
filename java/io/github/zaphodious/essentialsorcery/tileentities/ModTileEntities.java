package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.gui.RuneTableGUI;
import net.minecraftforge.fml.common.registry.GameRegistry;
import cyano.poweradvantage.PowerAdvantage;
import cyano.poweradvantage.registry.MachineGUIRegistry;

public class ModTileEntities {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(RuneTableTileEntity.class, Reference.MODID + ".rune_table");
		System.out.println("registered the Rune Table");
	}
	
	public static void regGUIs() {
		ModBlocks.rune_table.setGuiID(MachineGUIRegistry.addGUI(new RuneTableGUI()), PowerAdvantage.getInstance());
		System.out.println(ModBlocks.rune_table.getGuiID() + " has been registered");
	}
	
}
