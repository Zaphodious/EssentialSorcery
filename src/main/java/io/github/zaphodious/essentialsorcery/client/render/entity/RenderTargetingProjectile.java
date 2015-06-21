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
		super(Minecraft.getMinecraft().getRenderManager(), itemIn, Minecraft.getMinecraft().getRenderItem());

		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.client.renderer.entity.RenderArrow#doRender(net.minecraft
	 * .entity.Entity, double, double, double, float, float)
	 */
	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		// TODO Auto-generated method stub
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	/*
	 * @Override public void doRender(Entity entity, double x, double y, double
	 * z, float par8, float par9) { this.bindEntityTexture(entity);
	 * GL11.glPushMatrix(); GL11.glTranslatef((float) x, (float) y, (float) z);
	 * GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw -
	 * entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
	 * GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch -
	 * entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F); Tessellator
	 * tessellator = Tessellator.getInstance(); byte b0 = 0; float f2 = 0.0F;
	 * float f3 = 0.5F; float f4 = (float) (0 + b0 * 10) / 32.0F; float f5 =
	 * (float) (5 + b0 * 10) / 32.0F; float f6 = 0.0F; float f7 = 0.15625F;
	 * float f8 = (float) (5 + b0 * 10) / 32.0F; float f9 = (float) (10 + b0 *
	 * 10) / 32.0F; float f10 = 0.05625F; GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	 * float f11 = par9;
	 * 
	 * if (f11 > 0.0F) { float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
	 * GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F); }
	 * 
	 * GL11.glEnable(GL11.GL_BLEND); GL11.glBlendFunc(GL11.GL_SRC_ALPHA,
	 * GL11.GL_ONE_MINUS_SRC_ALPHA); GL11.glColor4d(1, 1, 1, 0.5f);
	 * 
	 * GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F); GL11.glScalef(f10, f10, f10);
	 * GL11.glTranslatef(-4.0F, 0.0F, 0.0F); GL11.glNormal3f(f10, 0.0F, 0.0F);
	 * tessellator.startDrawingQuads(); tessellator.addVertexWithUV(-7.0D,
	 * -2.0D, -2.0D, (double) f6, (double) f8);
	 * tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double) f7, (double)
	 * f8); tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double) f7, (double)
	 * f9); tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double) f6,
	 * (double) f9); tessellator.draw(); GL11.glNormal3f(-f10, 0.0F, 0.0F);
	 * tessellator.startDrawingQuads(); tessellator.addVertexWithUV(-7.0D, 2.0D,
	 * -2.0D, (double) f6, (double) f8); tessellator.addVertexWithUV(-7.0D,
	 * 2.0D, 2.0D, (double) f7, (double) f8); tessellator.addVertexWithUV(-7.0D,
	 * -2.0D, 2.0D, (double) f7, (double) f9);
	 * tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double) f6, (double)
	 * f9); tessellator.draw();
	 * 
	 * for (int i = 0; i < 4; ++i) { GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
	 * GL11.glNormal3f(0.0F, 0.0F, f10); tessellator.startDrawingQuads();
	 * tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double) f2, (double)
	 * f4); tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double) f3, (double)
	 * f4); tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double) f3, (double)
	 * f5); tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double) f2, (double)
	 * f5); tessellator.draw(); }
	 * 
	 * GL11.glDisable(GL12.GL_RESCALE_NORMAL); GL11.glPopMatrix(); }
	 * 
	 * @Override protected ResourceLocation getEntityTexture(Entity var1) {
	 * return new
	 * ResourceLocation(DoctorForge.modid+":textures/entity/doctorwho/laser.png"
	 * ); }
	 */

}