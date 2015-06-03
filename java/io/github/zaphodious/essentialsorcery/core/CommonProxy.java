package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.event.Events;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.RegTargetingEntities;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile;
import io.github.zaphodious.essentialsorcery.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	EssentialEventHandler events = new EssentialEventHandler();

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.createBlocks();
		ModItems.createItems();
		ModItems.putRunesIntoDropList();
		
		Reference.SORTER.fillBiomeList();
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);
		
		
		Reference.SORTER.fillBiomeList();
    }

    public void init(FMLInitializationEvent e) {
    	ModTileEntities.registerTileEntities();
    	ModTileEntities.regGUIs();
        //NetworkRegistry.INSTANCE.registerGuiHandler(EssentialSorcery.instance, new MachineGUIRegistry());
    	RegTargetingEntities.Reg();
    }

    public void postInit(FMLPostInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new Events());
    }
	
}
