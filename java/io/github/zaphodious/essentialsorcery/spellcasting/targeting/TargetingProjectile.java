package io.github.zaphodious.essentialsorcery.spellcasting.targeting;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TargetingProjectile extends EntityThrowable
{
    /* (non-Javadoc)
	 * @see net.minecraft.entity.projectile.EntityThrowable#getVelocity()
	 */
	@Override
	protected float getVelocity() {
		// TODO Auto-generated method stub
		return 5F;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.projectile.EntityThrowable#getGravityVelocity()
	 */
	@Override
	protected float getGravityVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static final String __OBFID = "CL_00001722";

    public TargetingProjectile(World worldIn)
    {
        super(worldIn);
    }

    public TargetingProjectile(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public TargetingProjectile(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
    	System.out.println("Hey, we hit something at " + this.posX + "," + this.posY + "," + this.posZ);
        if (p_70184_1_.entityHit != null)
        {
            byte b0 = 0;

            if (p_70184_1_.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
