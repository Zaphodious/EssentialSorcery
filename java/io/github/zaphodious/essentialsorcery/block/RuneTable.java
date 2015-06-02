package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.container.ContainerRuneTable;
import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.tileentities.RuneTableTileEntity;
import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.IFluidHandler;
import cyano.poweradvantage.api.ConduitType;
import cyano.poweradvantage.api.PoweredEntity;
import cyano.poweradvantage.api.simple.BlockSimplePowerConsumer;

public class RuneTable extends BlockSimplePowerConsumer {

	public RuneTable(String unlocalizedName) {
		super(Material.wood, 0.25F, new ConduitType("essence"));
		this.setUnlocalizedName(unlocalizedName);
		// TODO Auto-generated constructor stub
	}
	
	
	




	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#canPlaceTorchOnTop(net.minecraft.world.IBlockAccess, net.minecraft.util.BlockPos)
	 */
	@Override
	public boolean canPlaceTorchOnTop(IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return true;
		
		//return super.canPlaceTorchOnTop(world, pos);
	}




	



	/* (non-Javadoc)
	 * @see net.minecraft.block.Block#onNeighborBlockChange(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.block.Block)
	 */
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos,
			IBlockState state, Block neighborBlock) {
		// TODO Auto-generated method stub
		
		RuneTableTileEntity rtte = (RuneTableTileEntity) worldIn.getTileEntity(pos);
		
		if (worldIn.isBlockPowered(pos)) {
			rtte.makeTheSpell();
		}
		
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}



	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos,
			IBlockState state, EntityPlayer playerIn, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		
		boolean toReturn = false;
		if (playerIn.getCurrentEquippedItem() == null) {
			toReturn = super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		} else if (playerIn.getCurrentEquippedItem().getItem() == ModItems.tapSetter) {
			RuneTableTileEntity rtte = (RuneTableTileEntity) worldIn.getTileEntity(pos);
			System.out.println("spell result is " + rtte.makeTheSpell());
			return true;
		} else {
			toReturn = super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
		}
		
		return toReturn;
		
    }
	/*
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public int getRenderType()
    {
        return 3;
    }*/
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return ModItems.runeTablePlacer;
	}

	/*public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileEntityRuneTable();
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}*/
	

	
	    /*public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
	        if(!world.isRemote) {
	            if (world.getTileEntity(pos) != null)
	            	player.openGui(EssentialSorcery.instance, GUIs.RUNE_DESK.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
	            return true;
	        }
	        return true;
	    }*/

		
	    /*@Override
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
	    }*/

	    /* (non-Javadoc)
		 * @see cyano.poweradvantage.api.GUIBlock#onBlockActivated(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.block.state.IBlockState, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumFacing, float, float, float)
		 */
		/*@Override
		public boolean onBlockActivated(World w, BlockPos coord,
				IBlockState bs, EntityPlayer player, EnumFacing facing,
				float f1, float f2, float f3) {
			
				boolean didItWork = super.onBlockActivated(w, coord, bs, player, facing, f1, f2, f3);
			System.out.println("Rune Table Activated, result of " + didItWork + " for world.isRemote = " + w.isRemote);
			
			return didItWork;
			
		}
		
		@Override
	    public boolean onBlockActivated(final World w, final BlockPos coord, final IBlockState bs, 
	    		final EntityPlayer player, final EnumFacing facing, final float f1, final float f2, 
	    		final float f3) {
	         if (!w.isRemote) {
	            return false;
	        }
	        final TileEntity tileEntity = w.getTileEntity(coord);
	        if (tileEntity == null || player.isSneaking()) {
	        	return false;
	        }
	        // handle buckets and fluid containers
	        ItemStack item = player.getCurrentEquippedItem();
	        if(item != null && FluidContainerRegistry.isContainer(item) && tileEntity instanceof IFluidHandler){
	        	boolean bucketed = handleBucketInteraction(item,player,facing,(IFluidHandler)tileEntity,w);
	        	if(bucketed){
	        		return true;
	        	}
	        }
	        
	        // open GUI
	        if(this.getGuiOwner() == null) return false;
	        System.out.println("GuiID is " + this.getGuiID());
	        player.openGui(this.getGuiOwner(), this.getGuiID(), w, coord.getX(), coord.getY(), coord.getZ());
	        return true;
	    }*/

		
		
			/* (non-Javadoc)
		 * @see cyano.poweradvantage.api.simple.BlockSimplePowerConsumer#onBlockPlaced(net.minecraft.world.World, net.minecraft.util.BlockPos, net.minecraft.util.EnumFacing, float, float, float, int, net.minecraft.entity.EntityLivingBase)
		 */
		@Override
		public IBlockState onBlockPlaced(World world, BlockPos coord,
				EnumFacing facing, float f1, float f2, float f3, int meta,
				EntityLivingBase player) {
			// TODO Auto-generated method stub
			return super.onBlockPlaced(world, coord, facing, f1, f2, f3, meta, player);
			
		}

			/*public static class InterfaceCraftingTable implements IInteractionObject
        {
            private final World world;
            private final BlockPos position;
            private static final String __OBFID = "CL_00002127";

            public InterfaceCraftingTable(World worldIn, BlockPos pos)
            {
            	System.out.println("InterfaceCraftinTable called");
                this.world = worldIn;
                this.position = pos;
            }

            *//**
             * Gets the name of this command sender (usually username, but possibly "Rcon")
             *//*
            public String getCommandSenderName()
            {
                return null;
            }

            *//**
             * Returns true if this thing is named
             *//*
            public boolean hasCustomName()
            {
                return false;
            }

            *//**
             * Get the formatted ChatComponent that will be used for the sender's username in chat
             *//*
            public IChatComponent getDisplayName()
            {
                return new ChatComponentTranslation(Blocks.crafting_table.getUnlocalizedName() + ".name", new Object[0]);
            }

            public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
            {
                return new ContainerRuneTable(playerInventory, this.world, this.position);
            }

            public String getGuiID()
            {
                return "minecraft:crafting_table";
            }
        }*/

		

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
