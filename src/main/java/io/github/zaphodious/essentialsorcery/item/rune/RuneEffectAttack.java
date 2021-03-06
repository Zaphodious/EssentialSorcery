package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

import java.util.Map;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RuneEffectAttack extends RuneEffect {

	public RuneEffectAttack(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Aggression";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect
	 * #makeMagic(net.minecraft.entity.Entity, net.minecraft.world.World,
	 * net.minecraft.entity.EntityLivingBase, java.util.Map,
	 * net.minecraft.util.BlockPos, net.minecraft.util.MovingObjectPosition,
	 * java.lang.String)
	 */
	@Override
	public boolean makeMagic(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		if (movObjPos.entityHit != null) {
			return super.makeMagic(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
		}

		return false;

	}

	@Override
	public boolean fireEffect(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		int secondToBurn = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		movObjPos.entityHit.setFire(secondToBurn);
		// movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(entity,
		// throwerIn), damageToDeal);
		System.out.println("I should have set on fire for " + secondToBurn + " seconds!");
		return true;
	}

	@Override
	public boolean waterEffect(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		int damageToDeal = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));

		// movObjPos.entityHit.setAir(movObjPos.entityHit.getAir() -
		// damageToDeal);
		try {
			EntityLivingBase entityLivingBase = (EntityLivingBase) movObjPos.entityHit;
			entityLivingBase.addPotionEffect(new PotionEffect(
					Potion.saturation.getId(),
					damageToDeal * 20,
					damageToDeal / 5,
					false,
					true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return false;

	}

	@Override
	public boolean airEffect(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		int damageToDeal = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));

		/*
		 * Random rand = new Random(); float xDir =
		 * rand.nextFloat()*damageToDeal*3; float yDir=
		 * rand.nextFloat()*damageToDeal; float zDir=
		 * rand.nextFloat()*damageToDeal*3; if (rand.nextFloat() < .5F) { xDir =
		 * -xDir; }
		 * 
		 * if (rand.nextFloat() < .5F) { zDir = -zDir; }
		 */

		try {

			movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(entity, throwerIn), 0);

			EntityLivingBase entityLivingBase = (EntityLivingBase) movObjPos.entityHit;

			entityLivingBase.knockBack(throwerIn, 5, -(entity.motionX), -(entity.motionZ));
			// entityLivingBase.motionY = damageToDeal*.2;
			entityLivingBase.motionX = entity.motionX * (damageToDeal * .5);
			entityLivingBase.motionZ = entity.motionZ * (damageToDeal * .5);

			// entityLivingBase.setLastAttacker(throwerIn);

		} catch (Exception e) {

		}

		// movObjPos.entityHit.moveEntity(xDir, yDir, zDir);

		System.out.println("did it make it fly?");
		return true;
	}

	@Override
	public boolean earthEffect(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		int damageToDeal = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));

		try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			for (int i = 0; i < 4; i++) {
				hitPlayer.getCurrentArmor(0).damageItem(damageToDeal * 3, throwerIn);
			}

		} catch (Exception e) {
			System.out.println("The entity hit was not a player!");
			return false;
		}

		return true;
	}

	@Override
	public boolean woodEffect(
			Entity entity,
			World worldIn,
			EntityLivingBase throwerIn,
			Map<String, ItemStack> runeMapIn,
			BlockPos pos,
			MovingObjectPosition movObjPos,
			String thisRuneKey) {
		// TODO Auto-generated method stub
		int damageToDeal = 2 * RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(entity, throwerIn), damageToDeal);
		throwerIn.heal(damageToDeal);
		return true;
	}

}
