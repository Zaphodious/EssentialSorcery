package io.github.zaphodious.essentialsorcery.spellcasting.targeting;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class TargetingProjectileAir extends TargetingProjectile {
	

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.targeting.TargetingProjectile#setRuneMap(java.util.Map)
	 */
	

	private static final String __OBFID = "CL_00001722";
	

	public TargetingProjectileAir(World worldIn) {
		super(worldIn);

	}

	public TargetingProjectileAir(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);

	}

	public TargetingProjectileAir(World worldIn, double x, double y, double z) {

		super(worldIn, x, y, z);

	}

	

	

}
