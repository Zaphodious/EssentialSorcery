package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRuneTable extends TileEntity  implements IUpdatePlayerListBox{

	private String id = ModBlocks.rune_table.getUnlocalizedName().substring(5);
	
	public static String getID() {
		return ModBlocks.rune_table.getUnlocalizedName().substring(5)+"tileentity";
	}
	
	int tick = 0;
	 
 
    
 
    
    public void update() {
 
        if(!worldObj.isRemote) {
        	
            tick++;
            System.out.println("Tick number is: " + tick);
            if(tick == 100) {
            	System.out.println("Changing the world time to 1000");
                this.worldObj.setWorldTime(1000);
                tick = 0;
            }
        }
    }
}
