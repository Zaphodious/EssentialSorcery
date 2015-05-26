package io.github.zaphodious.essentialsorcery.block;

import io.github.zaphodious.essentialsorcery.container.ContainerRuneTable;
import io.github.zaphodious.essentialsorcery.core.EssentialSorcery;
import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.gui.GUIs;
import io.github.zaphodious.essentialsorcery.gui.GuiRuneDesk;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
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
		if (!worldIn.isRemote)
        {
            return true;
        }
        else
        {
            
            playerIn.openGui(EssentialSorcery.instance, GUIs.RUNE_DESK.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
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
	

	
	    /*public boolean onBlockActivated(World world, BlockPos pos, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
	        if(!world.isRemote) {
	            if (world.getTileEntity(pos) != null)
	            	player.openGui(EssentialSorcery.instance, GUIs.RUNE_DESK.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
	            return true;
	        }
	        return true;
	    }*/

	    
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

	    public static class InterfaceCraftingTable implements IInteractionObject
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

            /**
             * Gets the name of this command sender (usually username, but possibly "Rcon")
             */
            public String getCommandSenderName()
            {
                return null;
            }

            /**
             * Returns true if this thing is named
             */
            public boolean hasCustomName()
            {
                return false;
            }

            /**
             * Get the formatted ChatComponent that will be used for the sender's username in chat
             */
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
        }
}
