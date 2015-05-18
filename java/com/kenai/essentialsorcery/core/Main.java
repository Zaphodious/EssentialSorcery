package com.kenai.essentialsorcery.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class Main {

	@SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
    @Instance
    public static Main instance = new Main();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	this.proxy.preInit(e);
    	System.out.println("called method: preInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	this.proxy.init(e);
    	System.out.println("called method: init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	this.proxy.postInit(e);
    	System.out.println("called method: postInit");
    }
}