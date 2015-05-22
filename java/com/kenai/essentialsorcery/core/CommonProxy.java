package com.kenai.essentialsorcery.core;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.item.ModItems;

public class CommonProxy {
	
	EssentialEventHandler events = new EssentialEventHandler();

	public void preInit(FMLPreInitializationEvent e) {
		
		ModItems.createItems();
		ModBlocks.createBlocks();
		Reference.SORTER.fillBiomeList();
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);
		
		
		Reference.SORTER.fillBiomeList();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
	
}
