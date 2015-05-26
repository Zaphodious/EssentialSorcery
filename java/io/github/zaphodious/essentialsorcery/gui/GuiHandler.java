package io.github.zaphodious.essentialsorcery.gui;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.container.ContainerTestingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, 
          World world, int x, int y, int z) 
    { 
        /*TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        if (tileEntity != null)
        {
            if (ID == GUI_ENUM.RUNE_TABLE.ordinal())
            {
                return new GuiRuneDesk(player.inventory, 
                      (TileEntityRuneTable)tileEntity);
            }
            if (ID == GUI_ENUM.RUNE_TABLE.ordinal())
            {
                return new ContainerCompactor(player.inventory, 
                      (IInventory)tileEntity);
            }
        }
        if (ID == Reference.GUI_ENUM.DECONSTRUCTOR.ordinal())
        {
            return new ContainerDeconstructor(player.inventory, world, 
                  x, y, z);
        }
    	}*/
    	
    	if (ID == Gui_Enum.TESTING_TABLE.getID()) {
    		return ID == Gui_Enum.TESTING_TABLE.getID() && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.testing_table ? new ContainerTestingTable(player.inventory, world, new BlockPos(x, y, z)) : null;
    	}
    	
        return null;
        
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, 
          World world, int x, int y, int z)
    {
        /*TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        return new GuiRuneDesk(player.inventory, world, player.playerLocation);
        if (tileEntity != null)
        {
            if (ID == GUI_ENUM.RUNE_TABLE.ordinal())
            {
                
            }
            if (ID == Reference.GUI_ENUM.COMPACTOR.ordinal())
            {
                return new GuiCompactor(player.inventory, 
                      (IInventory)tileEntity);
            }
        }
        if (ID == Reference.GUI_ENUM.DECONSTRUCTOR.ordinal())
        {
            return new GuiDeconstructor(player.inventory, world, 
                  I18n.format("tile.deconstructor.name"), x, y, z);
        }
        }*/
    	
    	if (ID == Gui_Enum.TESTING_TABLE.getID()) {
    		return ID == Gui_Enum.TESTING_TABLE.getID() && world.getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.testing_table ? new GuiTestingTable(player.inventory, world, new BlockPos(x, y, z)) : null;
    	}
        return null;
    }
}
