package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

import java.util.Map;

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

public class RuneEffectDefend extends RuneEffect {

	public RuneEffectDefend(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Defense";
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
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		try {
			EntityLivingBase hitPlayer = (EntityLivingBase) movObjPos.entityHit;

			hitPlayer.addPotionEffect(new PotionEffect(
					Potion.fireResistance.getId(),
					spellStrength * 100,
					spellStrength / 5,
					false,
					true));

			return true;

		} catch (Exception e) {

		}
		return false;
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
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		try {
			EntityLivingBase hitPlayer = (EntityLivingBase) movObjPos.entityHit;

			hitPlayer.addPotionEffect(new PotionEffect(
					Potion.moveSlowdown.getId(),
					spellStrength * 200,
					spellStrength / 5,
					false,
					true));

			return true;

		} catch (Exception e) {

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
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		/*
		 * try { EntityLivingBase hitPlayer = (EntityLivingBase)
		 * movObjPos.entityHit;
		 * 
		 * hitPlayer.addPotionEffect(new PotionEffect(Potion.jump.getId(),
		 * spellStrength*200, (spellStrength/5)*2, false, true));
		 * 
		 * return true;
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */

		try {

			EntityLivingBase entityLivingBase = (EntityLivingBase) movObjPos.entityHit;

			entityLivingBase.motionY = entity.motionX * (spellStrength * .3);

		} catch (Exception e) {

		}

		return false;
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
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));
		try {
			EntityLivingBase hitPlayer = (EntityLivingBase) movObjPos.entityHit;

			hitPlayer.addPotionEffect(new PotionEffect(
					Potion.healthBoost.getId(),
					spellStrength * 200,
					(spellStrength / 5) * 2,
					false,
					true));

			return true;

		} catch (Exception e) {

		}
		return false;
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
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn.get(thisRuneKey));

		/*
		 * try { EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
		 * 
		 * int foodlevel = hitPlayer.getFoodStats().getFoodLevel();
		 * hitPlayer.getFoodStats().setFoodLevel(foodlevel + spellStrength*4);
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 */
		try {
			EntityLivingBase hitPlayer = (EntityLivingBase) movObjPos.entityHit;

			hitPlayer.addPotionEffect(new PotionEffect(
					Potion.invisibility.getId(),
					spellStrength * 200,
					(spellStrength / 5) * 2,
					false,
					true));

			return true;

		} catch (Exception e) {

		}
		return false;
	}

}
