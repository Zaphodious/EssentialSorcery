package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.gui.GUIs;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class RuneTable extends BlockContainer /*BasicBlock*/ implements ITileEntityProvider {

	public RuneTable(String unlocalizedName) {
		super(Material.wood);
		this.setUnlocalizedName(unlocalizedName);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote) {
            if (worldIn.getTileEntity(pos) != null)
            	playerIn.openGui(EssentialSorcery.instance, GUIs.RUNE_DESK.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return true;
    }
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public int getRenderType()
    {
        return 3;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return ModItems.runeTablePlacer;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileEntityRuneTable();
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	

	
	    public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
	        if(world.isRemote) {
	            if (world.getTileEntity(pos) != null)
	            	player.openGui(EssentialSorcery.instance, GUIs.RUNE_DESK.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
	            return true;
	        }
	        return true;
	    }

	    
	    @Override
	    public void breakBlock(
	          World worldIn, 
	          BlockPos pos, 
	          IBlockState state)
	    {
	        if (!hasTileEntity())
	        {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof TileEntityRuneTable)
	            {
	                InventoryHelper.dropInventoryItems(worldIn, pos, 
	                      (TileEntityRuneTable)tileentity);
	                worldIn.updateComparatorOutputLevel(pos, this);
	            }
	        }

	        super.breakBlock(worldIn, pos, state);
	    }

}
