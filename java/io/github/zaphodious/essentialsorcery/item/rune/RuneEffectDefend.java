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

	@Override
	public boolean fireEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			
			hitPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), spellStrength*20, spellStrength/5, false, true));
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean waterEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			
			hitPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), spellStrength*20, spellStrength/5, false, true));
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean airEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean earthEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			
			hitPlayer.addPotionEffect(new PotionEffect(Potion.healthBoost.getId(), spellStrength*20, (spellStrength/5)*2, false, true));
			
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean woodEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		
		try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			
			int foodlevel = hitPlayer.getFoodStats().getFoodLevel();
			hitPlayer.getFoodStats().setFoodLevel(foodlevel + spellStrength*4);
			
		} catch (Exception e) {
			
		}
		/*try {
			EntityPlayer hitPlayer = (EntityPlayer) movObjPos.entityHit;
			
			hitPlayer.addPotionEffect(new PotionEffect(Potion.jump.getId(), spellStrength*20, (spellStrength/5)*2, false, true));
			
			return true;
			
		} catch (Exception e) {
			
		}*/
		return false;
	}

	

	

}
