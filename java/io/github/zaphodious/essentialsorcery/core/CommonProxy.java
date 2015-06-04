package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.crafting.RecRegister;
import io.github.zaphodious.essentialsorcery.event.Events;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.RegTargetingEntities;
import io.github.zaphodious.essentialsorcery.tileentities.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	/*
	 * 
	 * If it happens with both the server and the client, it happens
	 * here rather then in the main mod class. I like to keep things
	 * clean that way. Better a bunch of easily-readable files that all 
	 * link back and forth, then one large file that's more difficult
	 * for a human to parse.
	 * 
	 * if you don't know what on earth I'm talking about, 
	 * read this. It explains it all quite nicely:
	 * http://greyminecraftcoder.blogspot.com.br/2013/10/the-most-important-minecraft-classes.html
	 * 
	 */

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.createBlocks();
		ModItems.createItems();
		ModItems.putRunesIntoDropList();
		
		Reference.SORTER.fillBiomeList();
		
		
		ModTileEntities.regGUIs();
		Reference.SORTER.fillBiomeList();
    }

    public void init(FMLInitializationEvent e) {

    	RegTargetingEntities.Reg();
    	RecRegister.makeRecipes();
    }

    public void postInit(FMLPostInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new Events());
    }
	
}
