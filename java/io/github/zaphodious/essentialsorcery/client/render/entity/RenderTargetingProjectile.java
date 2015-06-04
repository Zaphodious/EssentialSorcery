package io.github.zaphodious.essentialsorcery.client.render.entity;

import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderTargetingProjectile extends RenderSnowball {

	public RenderTargetingProjectile(Item itemIn) {
		super(Minecraft.getMinecraft().getRenderManager(), itemIn, Minecraft
				.getMinecraft().getRenderItem());
		
		/*
		 * 
		 * The RenderSnowball class takes an item and uses that item's model
		 * as the model for the projectile entity. This is a whole lot easier
		 * then using the tesselator, so we'll do it instead using dummy items
		 * (as you can see from the EntityRenderRegister in this package. We override
		 * the RenderSnowball function in order to shorten the constructor method.
		 * 
		 */

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.client.renderer.entity.RenderArrow#doRender(net.minecraft
	 * .entity.Entity, double, double, double, float, float)
	 */
	@Override
	public void doRender(Entity entity, double x, double y, double z,
			float entityYaw, float partialTicks) {

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

}