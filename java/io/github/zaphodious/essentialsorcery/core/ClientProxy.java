package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.client.render.block.BlockRenderRegister;
import io.github.zaphodious.essentialsorcery.client.render.entity.EntityRenderRegister;
import io.github.zaphodious.essentialsorcery.client.render.item.ItemRenderRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	/*
	 * 
	 * This is, basically, where we register rendering information. 
	 * If we do this with the server we'll crash the whole thing.
	 * 
	 */

	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        ItemRenderRegister.registerItemRenderer();
        BlockRenderRegister.registerBlockRenderer();
        EntityRenderRegister.renderEntities();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        
    }
	
}
