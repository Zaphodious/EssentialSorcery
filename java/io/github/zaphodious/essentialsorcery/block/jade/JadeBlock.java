package io.github.zaphodious.essentialsorcery.block.jade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.github.zaphodious.essentialsorcery.block.BasicBlock;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.Element;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class JadeBlock extends BasicBlock {

	

	Element element;

	public JadeBlock(String unlocalizedName, Element element) {
		super(unlocalizedName, Material.iron, 2F, 100F);
		this.element = element;
		this.setHarvestLevel("pickaxe", 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.block.Block#getLightValue()
	 */
	@Override
	public int getLightValue() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World,
	 * net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState,
	 * net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumFacing,
	 * float, float, float)
	 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		return this.activate(worldIn, pos, playerIn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.block.Block#onEntityCollidedWithBlock(net.minecraft.world
	 * .World, net.minecraft.util.BlockPos, net.minecraft.entity.Entity)
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos,
			Entity entityIn) {
		this.activate(worldIn, pos, entityIn);
	}
	
	

	private boolean activate(World worldIn, BlockPos pos, Entity entityIn) {
		
		// TODO: Make it so that the more blocks in a column, the more potent the effect.
		// Hint: Use pos.
		
		int duration = 100;
		int effectLevel = 0;
		boolean particles = false;

		if (entityIn instanceof EntityLivingBase) {
			EntityLivingBase livingEntity = (EntityLivingBase) entityIn;
			switch (element) {
			case AIR:
				livingEntity.addPotionEffect(new PotionEffect(
						Potion.jump.getId(), duration, effectLevel, false, particles));
				break;
			case EARTH:
				livingEntity.addPotionEffect(new PotionEffect(
						Potion.resistance.getId(), duration, effectLevel, false, particles));
				break;
			case FIRE:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;
			case NEUTRAL:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;
			case WATER:
				livingEntity.addPotionEffect(new PotionEffect(
						Potion.waterBreathing.getId(), duration, effectLevel, false, particles));
				break;
			case WOOD:
				livingEntity.addPotionEffect(new PotionEffect(Potion.regeneration
						.getId(), duration, effectLevel, false, particles));
				break;
			default:
				livingEntity.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), duration, effectLevel, false, particles));
				break;

			}
		}

		return false;
	}
	
	
	
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		switch (this.element) {
		case AIR: return ModItems.jadeBlockBluePlacer;
		case EARTH: return ModItems.jadeBlockWhitePlacer;
		case FIRE: return ModItems.jadeBlockRedPlacer;
		case NEUTRAL: return ModItems.jadeBlockRedPlacer;
		case WATER: return ModItems.jadeBlockBlackPlacer;
		case WOOD: return ModItems.jadeBlockGreenPlacer;
		default: return ModItems.jadeBlockRedPlacer;
		
		}
	}

}
