package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.gui.GuiHandler;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	EssentialEventHandler events = new EssentialEventHandler();

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.createBlocks();
		ModItems.createItems();
		
		Reference.SORTER.fillBiomeList();
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);
		
		
		Reference.SORTER.fillBiomeList();
    }

    public void init(FMLInitializationEvent e) {
    	ModTileEntities.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(EssentialSorcery.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
	
}
