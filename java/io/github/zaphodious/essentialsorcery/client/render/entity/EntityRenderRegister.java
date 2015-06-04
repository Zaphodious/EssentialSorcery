package io.github.zaphodious.essentialsorcery.client.render.entity;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegister {

	public static void renderEntities() {
		
		/*
		 * 
		 * When you use the projectile rune to cast a spell, (depending on your element)
		 * you'll get a colorful ball jetting forth from your hand. As you can see, we use special dummy
		 * items to register our entity models.
		 * 
		 */
		
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileAir.class, new RenderTargetingProjectile(ModItems.prettyBallYellow));
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileFire.class, new RenderTargetingProjectile(ModItems.prettyBallRed));
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileWater.class, new RenderTargetingProjectile(ModItems.prettyBallBlue));
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileEarth.class, new RenderTargetingProjectile(ModItems.prettyBallBrown));
		RenderingRegistry.registerEntityRenderingHandler(io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectileWood.class, new RenderTargetingProjectile(ModItems.prettyBallGreen));

	}
	
}
