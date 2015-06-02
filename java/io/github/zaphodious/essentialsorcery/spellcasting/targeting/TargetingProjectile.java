package io.github.zaphodious.essentialsorcery.spellcasting.targeting;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

import java.util.Map;
import java.util.Set;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class TargetingProjectile extends EntityThrowable {
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.entity.projectile.EntityThrowable#getVelocity()
	 */
	@Override
	protected float getVelocity() {
		// TODO Auto-generated method stub
		return 2F;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.entity.projectile.EntityThrowable#getGravityVelocity()
	 */
	@Override
	protected float getGravityVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.entity.projectile.EntityThrowable#onUpdate()
	 */
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this
				.getPosition().getX(), this.getPosition().getY(), this
				.getPosition().getZ(), -.5F, -.5F, -.5F, 1);
		if (this.ticksExisted > 600) {
			this.setDead();
		}
		super.onUpdate();
	}

	private static final String __OBFID = "CL_00001722";
	protected Map<String, ItemStack> runeMap;

	public TargetingProjectile(World worldIn) {
		super(worldIn);

	}

	public TargetingProjectile(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		this.setSize(0.5F, 0.5F);
		;

	}

	public TargetingProjectile(World worldIn, double x, double y, double z) {

		super(worldIn, x, y, z);

	}

	/**
	 * @param runeMap
	 *            the runeMap to set
	 */
	public void setRuneMap(Map<String, ItemStack> runeMap) {
		System.out.println("Trying to set the runeMap.");
		this.runeMap = runeMap;
		System.out.println("the runeMap is " + this.runeMap
				+ "..... derived from " + runeMap);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	public void onImpact(MovingObjectPosition p_70184_1_) {
		this.setDead();
		if (!worldObj.isRemote) {
			//System.out.println(runeMap.toString());
			System.out.println("Hey, we hit something at " + this.posX + ","
					+ this.posY + "," + this.posZ + " at @Clientside:"
					+ this.worldObj.isRemote);
			System.out
					.print("And, hey, just because I can... the rune-bag you're holding contains: ");

			// try {

			for (String key : runeMap.keySet()) {
				if (runeMap.get(key) != null) {
					System.out.print(runeMap.get(key).toString());
				}
				
			}

			System.out.println("");

			byte b0 = 0;

			for (String key : runeMap.keySet()) {
				if (key.contains("effect")) {
					RuneEffect effectRune = (RuneEffect) runeMap.get(key)
							.getItem();
					effectRune.makeMagic(this, super.worldObj,
							super.getThrower(), runeMap, this.getPosition(),
							p_70184_1_, key);
				}
			}

		}

		// } catch (Exception e) {
		// System.out.println("Something went wrong. Here's the error: " + e);
		// }

		// try {
		// if (casterStack.hasTagCompound()) {
		// System.out.println("It identified the casterStack as having NBT");
		// ItemStack newStack = (ItemStack)
		// ItemStack.loadItemStackFromNBT(casterStack.getTagCompound().getCompoundTag("effect1"));
		// RuneEffect effectRune = (RuneEffect) newStack.getItem();

		// }
		// } catch (Exception e) {
		// System.out.println("Something went wrong. Here's the error: " + e);
		// }

		/*
		 * if (p_70184_1_.entityHit != null) { byte b0 = 0;
		 * 
		 * if (p_70184_1_.entityHit instanceof EntityBlaze) { b0 = 3; }
		 * 
		 * p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this
		 * , this.getThrower()), (float)b0); }
		 * 
		 * for (int i = 0; i < 8; ++i) {
		 * this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX,
		 * this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]); }
		 */

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}
