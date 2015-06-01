package io.github.zaphodious.essentialsorcery.item.rune;

import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;

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

	@Override
	public boolean fireEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos) {
		// TODO Auto-generated method stub
		System.out.println("trying to make boom happen...");
		movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(entity, throwerIn), 20F);
		System.out.println("did boom happen?");
		return true;
	}

	@Override
	public boolean waterEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean airEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean earthEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean woodEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
