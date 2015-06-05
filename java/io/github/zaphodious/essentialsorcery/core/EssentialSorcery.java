package io.github.zaphodious.essentialsorcery.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class EssentialSorcery {

	@SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
    @Instance
    public static EssentialSorcery instance = new EssentialSorcery();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	Configuration config = new Configuration(e.getSuggestedConfigurationFile());
    	config.load();
    	EssentialSorcery.proxy.preInit(e);
    	System.out.println("called method: preInit");
    	System.out.println("Is this working?");
    	System.out.println("called method: preInit");
    	System.out.println("called method: preInit");
    	System.out.println("called method: preInit");
    	config.save();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	EssentialSorcery.proxy.init(e);
    	System.out.println("called method: init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	EssentialSorcery.proxy.postInit(e);
    	System.out.println("called method: postInit");
    }
}