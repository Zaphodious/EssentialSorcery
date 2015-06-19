package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import java.util.Map;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import io.github.zaphodious.essentialsorcery.spellcasting.*;

public abstract class RuneEffect extends Item implements Rune {

	protected int id;
	protected String name;
	
	public RuneEffect(int id, String name) {
		this.id = id;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Reference.tabEssential);
		this.setMaxStackSize(42);
	}
	
	
	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#isEffectRune()
	 */
	@Override
	public boolean isEffectRune() {
		// TODO Auto-generated method stub
		return true;
	}


	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public boolean makeMagic(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {
		
		
		
			
			RuneElement elementRune = (RuneElement) runeMapIn.get("element").getItem();
			
			switch (elementRune.getElement()) {
			case AIR: this.airEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			case EARTH: this.earthEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			case FIRE: this.fireEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			case NEUTRAL: this.fireEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			case WATER: this.waterEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			case WOOD: this.woodEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			default: this.fireEffect(entity, worldIn, throwerIn, runeMapIn, pos, movObjPos, thisRuneKey);
				break;
			}
		
		
		return true;
		
	}
	
	public abstract boolean fireEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey);
	public abstract boolean waterEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey);
	public abstract boolean airEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey);
	public abstract boolean earthEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey);
	public abstract boolean woodEffect(Entity entity, World worldIn, EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn, BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey);
	
	public int getPowerLevel() {
		return 1;
	}
	
}
