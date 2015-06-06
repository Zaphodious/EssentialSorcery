package io.github.zaphodious.essentialsorcery.item.rune;

import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RuneEffectSpawnVanilla extends RuneEffect {

	public RuneEffectSpawnVanilla(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitleString() {
		// TODO Auto-generated method stub
		return "Mob Spawning";
	}
	
	

	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect#getPowerLevel()
	 */
	@Override
	public int getPowerLevel() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public boolean fireEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		int spellPower = runeMapIn.get(thisRuneKey).stackSize;
		EntityCreeper entityCreeper = new EntityCreeper(worldIn);

		entityCreeper.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(),
				entity.rotationYaw, 0.0F);
		entityCreeper.setHealth(5*spellPower);
		worldIn.spawnEntityInWorld(entityCreeper);
		return true;
	}

	@Override
	public boolean waterEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		int spellPower = runeMapIn.get(thisRuneKey).stackSize;
		EntitySlime entitySlime = new EntitySlime(worldIn);

		entitySlime.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(),
				entity.rotationYaw, 0.0F);
		entitySlime.setHealth(5*spellPower);
		worldIn.spawnEntityInWorld(entitySlime);
		return true;
	}

	@Override
	public boolean airEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		try {
			int spellPower = runeMapIn.get(thisRuneKey).stackSize;
			EntityPlayer playerCaster = (EntityPlayer) throwerIn;
			EntityOcelot entityOcelot = new EntityOcelot(worldIn);
			entityOcelot.setTamed(true);
			entityOcelot.setTameSkin(1 + worldIn.rand.nextInt(3));
            entityOcelot.setOwnerId(throwerIn.getUniqueID().toString());
            entityOcelot.setHealth(10*spellPower);
			entityOcelot.setLocationAndAngles(pos.getX(), pos.getY(),
					pos.getZ(), entity.rotationYaw, 0.0F);
			worldIn.spawnEntityInWorld(entityOcelot);
			return true;
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean earthEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		EntityIronGolem entityIronGolem = new EntityIronGolem(worldIn);
		int spellPower = runeMapIn.get(thisRuneKey).stackSize;
		entityIronGolem.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(),
				entity.rotationYaw, 0.0F);
		entityIronGolem.setPlayerCreated(true);
		entityIronGolem.setHealth(10*spellPower);
		worldIn.spawnEntityInWorld(entityIronGolem);
		return false;
	}

	@Override
	public boolean woodEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		// TODO Auto-generated method stub
		int spellPower = runeMapIn.get(thisRuneKey).stackSize;
		EntityPlayer playerCaster = (EntityPlayer) throwerIn;
		EntityWolf entityWolf = new EntityWolf(worldIn);
		entityWolf.setTamed(true);
		entityWolf.getNavigator().clearPathEntity();
		entityWolf.setAttackTarget((EntityLivingBase)null);
		entityWolf.setHealth(10*spellPower);
		entityWolf.setOwnerId(playerCaster.getUniqueID().toString());
        entityWolf.setLocationAndAngles(pos.getX(), pos.getY(),
				pos.getZ(), entity.rotationYaw, 0.0F);
		worldIn.spawnEntityInWorld(entityWolf);
		return false;
	}

}
