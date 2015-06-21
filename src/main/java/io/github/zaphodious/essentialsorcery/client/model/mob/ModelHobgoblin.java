package io.github.zaphodious.essentialsorcery.client.model.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHobgoblin extends ModelBiped {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.client.model.ModelBase#render(net.minecraft.entity.Entity,
	 * float, float, float, float, float, float)
	 */

	public ModelRenderer head;
	public ModelRenderer body;
	public ModelRenderer legLeft;
	public ModelRenderer legRight;
	public ModelRenderer armLeft;
	public ModelRenderer armRight;

	public ModelHobgoblin() {

		textureWidth = 64;
		textureHeight = 64;

		this.head = new ModelRenderer(this, 15, 0);
		this.head.setRotationPoint(0F, 10F, 0F);
		this.head.addBox(-3F, -5F, -4F, 6, 5, 6); // base
		// this.head.setTextureOffset(0,0).addBox(-3.5F, -5F, 1F, 3, 4, 4); //
		// right lobe
		// this.head.setTextureOffset(40, 0).addBox(0.5F, -5F, 1F, 3, 4, 4); //
		// left lobe

		this.body = new ModelRenderer(this, 11, 39);
		this.body.setRotationPoint(0F, 10F, 0F);
		this.body.addBox(-4F, -2F, -8F, 8, 4, 8); // chest
		this.body.setTextureOffset(18, 33).addBox(-3F, -3F, -7F, 6, 1, 3); // potbelly

		this.legLeft = new ModelRenderer(this, 38, 28);
		this.legLeft.setRotationPoint(2F, 18F, 0F);
		this.legLeft.addBox(-2F, 0F, -2F, 4, 6, 4);

		this.legRight = new ModelRenderer(this, 0, 28);
		this.legRight.setRotationPoint(-2F, 18F, 0F);
		this.legRight.addBox(-2F, 0F, -2F, 4, 6, 4);

		this.armLeft = new ModelRenderer(this, 40, 12);
		this.armLeft.setRotationPoint(5F, 12F, 0F);
		this.armLeft.addBox(-1F, -2F, -2F, 3, 11, 4);

		this.armRight = new ModelRenderer(this, 0, 12);
		this.armRight.setRotationPoint(-5F, 12F, 0F);
		this.armRight.addBox(-2F, -2F, -2F, 3, 11, 4);

	}

	@Override
	public void render(
			Entity entityIn,
			float time,
			float limbSwingDistance,
			float unknownValue,
			float headYRot,
			float headXRot,
			float scale) {
		this.setRotationAngles(time, limbSwingDistance, unknownValue, headYRot, headXRot, scale, entityIn);

		if (this.isChild) {
			float div = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1F / div, 1F / div, 1F / div);
			GlStateManager.translate(0, 24.0F * scale, 0);

			this.head.render(scale);
			this.body.render(scale);
			this.legLeft.render(scale);
			this.legRight.render(scale);
			this.armLeft.render(scale);
			this.armRight.render(scale);
			GlStateManager.popMatrix();

		} else {
			this.head.render(scale);
			this.body.render(scale);
			this.legLeft.render(scale);
			this.legRight.render(scale);
			this.armLeft.render(scale);
			this.armRight.render(scale);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.client.model.ModelBase#setRotationAngles(float, float,
	 * float, float, float, float, net.minecraft.entity.Entity)
	 */
	@Override
	public void setRotationAngles(
			float time,
			float limbSwingDistance,
			float p_78087_3_,
			float headYRot,
			float headXRot,
			float p_78087_6_,
			Entity entityIn) {

		this.head.rotateAngleX = headXRot / (180F / (float) Math.PI);
		this.head.rotateAngleY = headYRot / (180F / (float) Math.PI);

		this.head.rotateAngleX = headXRot / (180F / (float) Math.PI);
		this.head.rotateAngleY = headYRot / (180F / (float) Math.PI);

		this.body.rotateAngleX = ((float) Math.PI / 2F);
		// this.body.rotateAngleX = -90;

		this.legLeft.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * limbSwingDistance;
		this.armRight.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * limbSwingDistance;
		this.legRight.rotateAngleX = MathHelper.cos(time * 0.6662F + (float) Math.PI) * 1.4F * limbSwingDistance;
		this.armLeft.rotateAngleX = MathHelper.cos(time * 0.6662F + (float) Math.PI) * 1.4F * limbSwingDistance;

	}

}
