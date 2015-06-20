package io.github.zaphodious.essentialsorcery.core;

import cyano.basemetals.BaseMetals;
import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.core.defaultconfigs.OreSpawnJSON;
import io.github.zaphodious.essentialsorcery.crafting.RecRegister;
import io.github.zaphodious.essentialsorcery.entity.RegisterMobs;
import io.github.zaphodious.essentialsorcery.event.Events;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.targeting.RegTargetingEntities;
import io.github.zaphodious.essentialsorcery.tileentities.ModTileEntities;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(
		modid = Reference.MODID,
		name = Reference.MODNAME,
		version = Reference.VERSION,
		dependencies = Reference.DEPENDENCIES)
public class EssentialSorcery {

	EssentialEventHandler events = new EssentialEventHandler();

	@SidedProxy(
			clientSide = Reference.CLIENT_PROXY,
			serverSide = Reference.SERVER_PROXY)
	public static Proxy proxy;

	@Instance
	public static EssentialSorcery instance = new EssentialSorcery();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Configuration config =
				new Configuration(e.getSuggestedConfigurationFile());
		config.load();

		System.out.println("called method: preInit... and has this changed?");
		OreSpawnJSON.makeOreGenConfigFile(e);

		ModBlocks.createBlocks();
		ModItems.createItems();
		ModItems.putRunesIntoDropList();

		Reference.SORTER.fillBiomeList();
		FMLCommonHandler.instance().bus().register(events);
		MinecraftForge.EVENT_BUS.register(events);

		Reference.SORTER.fillBiomeList();
		this.proxy.preInit(e);
		config.save();

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

		System.out.println("called method: init");

		ModTileEntities.registerTileEntities();
		RegisterMobs.registerMobs();
		ModTileEntities.regGUIs();
		// NetworkRegistry.INSTANCE.registerGuiHandler(EssentialSorcery.instance,
		// new MachineGUIRegistry());
		RegTargetingEntities.Reg();
		RecRegister.makeRecipes();
		this.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

		System.out.println("called method: postInit");

		MinecraftForge.EVENT_BUS.register(new Events());
		System.out.println("***************");
		System.out.println("The ore gen config files that have been loaded: "
				+ BaseMetals.oreSpawnConfigFiles);
		System.out.println("***************");
		this.proxy.postInit(e);
	}
}