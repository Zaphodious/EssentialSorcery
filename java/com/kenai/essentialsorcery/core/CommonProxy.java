package com.kenai.essentialsorcery.core;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.gui.GuiHandler;
import com.kenai.essentialsorcery.item.ModItems;
import com.kenai.essentialsorcery.tileentities.ModTileEntities;

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
