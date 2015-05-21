package com.kenai.essentialsorcery.item;

import spellcasting.BiomeSorter;
import spellcasting.Caster;
import spellcasting.Element;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.kenai.essentialsorcery.block.ModBlocks;
import com.kenai.essentialsorcery.block.states.TapState;
import com.kenai.essentialsorcery.core.Reference;

public class TestWand extends Caster {

	public TestWand(String unlocalizedName, int maxPool, Element element) {
		super(maxPool, element);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.maxStackSize = 1;
		this.setMaxDamage(maxPool);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {

		boolean canUse = false;
		if (!playerIn.capabilities.isCreativeMode) {
			canUse = super.useEssence(2, itemStackIn);
		} else {
			canUse = true;
		}

		//canUse = !playerIn.isSneaking();
		
		if (canUse) {
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote) {
				worldIn.spawnEntityInWorld(new EntitySnowball(worldIn, playerIn));
			}

			playerIn.triggerAchievement(StatList.objectUseStats[Item
					.getIdFromItem(this)]);
		}

		return itemStackIn;
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn,
			World worldIn, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		try {

			if (!super.useTap(worldIn, pos, stack, playerIn)) {

				// this.onItemRightClick(stack, worldIn, playerIn);

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;

	}

}