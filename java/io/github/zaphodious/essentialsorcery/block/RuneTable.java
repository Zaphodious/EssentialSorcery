package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.tileentities.RuneTableTileEntity;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cyano.poweradvantage.api.ConduitType;
import cyano.poweradvantage.api.PoweredEntity;
import cyano.poweradvantage.api.simple.BlockSimplePowerConsumer;

public class RuneTable extends BlockSimplePowerConsumer {

	public RuneTable(String unlocalizedName) {
		super(Material.wood, 0.25F, new ConduitType("essence"));
		this.setUnlocalizedName(unlocalizedName);
		// TODO Auto-generated constructor stub
	}
	
	
	




	
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return true;
		
		//return super.canPlaceTorchOnTop(world, pos);
	}


	/*
	 * 
	 * The following was an early function, designed to make the table
	 * spit out a spell if redstone power was applied. I have since
	 * moved away from this (we use the Dragon Wand now, as it gives
	 * PlayerEntity information, which is useful), but I've decided
	 * to leave it in here for reference (and to pad the line count /s).
	 * 
	 */
	
	/*@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos,
			IBlockState state, Block neighborBlock) {
		// TODO Auto-generated method stub
		
		RuneTableTileEntity rtte = (RuneTableTileEntity) worldIn.getTileEntity(pos);
		
		if (worldIn.isBlockPowered(pos)) {
			rtte.makeTheSpell();
		}
		
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}*/


	

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		
		/*
		 * 
		 * First, we check to see if the stack is null. Otherwise we'll crash the game.
		 * If it isn't null *and* the player is holding a Dragon Wand, we make the spell.
		 * In any case, if the player isn't holding a Dragon Wand we let the superclass
		 * take care of things.
		 * 
		 */
		
		boolean toReturn = false;
		if (playerIn.getCurrentEquippedItem() == null) {
			toReturn = super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		} else if (playerIn.getCurrentEquippedItem().getItem() == ModItems.tapSetter) {
			RuneTableTileEntity rtte = (RuneTableTileEntity) worldIn.getTileEntity(pos);
			System.out.println("spell result is " + rtte.makeTheSpell(playerIn));
			return true;
		} else {
			toReturn = super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		}
		
		return toReturn;
		
    }

	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		/*
		 * 
		 * This isn't pretty. There's a rather bad bug in this mod: BlockItems aren't rendering *at all*,
		 * even if their file can be found and correctly parsed. So far, We've been unable to find the
		 * source. Until we do, this function overrides the regular drop function, and returns a special
		 * item that mimics this block's natural BlockItem.
		 * 
		 */
		
		return ModItems.runeTablePlacer;
	}

	

		
		
			/* (non-Javadoc)
		 * @see cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#onBlockPlaced(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.util.EnumFacing, float, float, float, int, net.minecraft.entity.EntityLivingBase)
		 */
		@Override
		public IBlockState onBlockPlaced(World world, BlockPos coord,
				EnumFacing facing, float f1, float f2, float f3, int meta,
				EntityLivingBase player) {
			
			/*
			 * 
			 * We are using DrCyano's PowerAdvantage API for (at the moment only) GUI creation.
			 * There is more planned, and we have a bunch of metal to work with. For now,
			 * his stuff requires that we have this particular method (and the ones after it.)
			 * 
			 */
			
			
			return super.onBlockPlaced(world, coord, facing, f1, f2, f3, meta, player);
			
		}

			
		@Override
		public boolean hasTileEntity() {
			return true;
		}
		

		@Override
		public boolean hasComparatorInputOverride() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int getComparatorInputOverride(World world, BlockPos coord) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public PoweredEntity createNewTileEntity(World world, int metaDataValue) {
			// TODO Auto-generated method stub
			return new RuneTableTileEntity();
		}
}
