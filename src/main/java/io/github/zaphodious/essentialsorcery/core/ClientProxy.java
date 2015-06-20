package io.github.zaphodious.essentialsorcery.core;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.client.render.block.BlockRenderRegister;
import io.github.zaphodious.essentialsorcery.client.render.entity.EntityRenderRegister;
import io.github.zaphodious.essentialsorcery.client.render.item.ItemRenderRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy  implements Proxy  {


    public void preInit(FMLPreInitializationEvent e) {
        
        
        
    }


    public void init(FMLInitializationEvent e) {
        
        ItemRenderRegister.registerVariants();
        ModBlocks.addVariantsForDragonTap();
        ItemRenderRegister.registerItemRenderer();
        EntityRenderRegister.renderEntities();
        ModBlocks.registerRenders();
        
    }


    public void postInit(FMLPostInitializationEvent e) {
        
    }
	
}
