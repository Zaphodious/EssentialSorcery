package io.github.zaphodious.essentialsorcery.spellcasting.targeting;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

import java.util.Map;
import java.util.Set;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TargetingProjectileFire extends TargetingProjectile {

	private static final String __OBFID = "CL_00001722";

	public TargetingProjectileFire(World worldIn) {
		super(worldIn);

	}

	public TargetingProjectileFire(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);

	}

	public TargetingProjectileFire(World worldIn, double x, double y, double z) {

		super(worldIn, x, y, z);

	}

}
