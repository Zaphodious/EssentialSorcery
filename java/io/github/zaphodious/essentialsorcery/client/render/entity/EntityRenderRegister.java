package io.github.zaphodious.essentialsorcery.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegister {

	public static void renderEntities() {
		RenderManager render = Minecraft.getMinecraft().getRenderManager();
		Render renderer = new RenderArrow(render);
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile.class, renderer);
	}
	
}
