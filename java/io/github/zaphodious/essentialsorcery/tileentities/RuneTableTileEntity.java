package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cyano.poweradvantage.api.ConduitType;
import cyano.poweradvantage.api.simple.TileEntitySimplePowerConsumer;

public class RuneTableTileEntity extends TileEntitySimplePowerConsumer {

	private ItemStack[] inventory;
	private int progress;
	private final int[] dataSyncArray;
	
	public RuneTableTileEntity() {
		super(	new ConduitType("essence"),
				100, // essence buffer size
				RuneTableTileEntity.class.getName());
		
		System.out.println("the tile entity has been placed!");
		
		inventory = new ItemStack[8];
		progress = 0;
		dataSyncArray = new int[2];
		
	}

	@Override
	public String getCommandSenderName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ItemStack[] getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}

	@Override
	public int[] getDataFieldArray() {
		// TODO Auto-generated method stub
		return dataSyncArray;
	}

	@Override
	public void prepareDataFieldsForSync() {
		// TODO Auto-generated method stub
		dataSyncArray[0] = Float.floatToRawIntBits(this.getEnergy());
		dataSyncArray[1] = this.progress;
		
	}

	@Override
	public void onDataFieldUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickUpdate(boolean isServerWorld) {
		// TODO Auto-generated method stub
		
		if (isServerWorld) {
			
			if (	inventory[0] != null
				&& 	inventory[1] == null
				/*&& 	this.getEnergy() >= 1*/	) {
			
				
				
			/*this.subtractEnergy(1, this.getType());
			progress++;
			
			if ( progress >= 3 ) {*/
				inventory[1] = new ItemStack(ModItems.testWand);
				//inventory[0].stackSize--;
				progress = 0;
				if (inventory[0].stackSize <= 0) {
					inventory[0] = null;
				}
				
			
			//}
				
			
			
			this.sync();
			}
		}
		
	}

	@Override
	public void readFromNBT(NBTTagCompound tagRoot) {
		// TODO Auto-generated method stub
		super.readFromNBT(tagRoot);
		tagRoot.setShort("progress", (short)progress);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagRoot) {
		// TODO Auto-generated method stub
		super.writeToNBT(tagRoot);
		if (tagRoot.hasKey("progress")) {
			progress = tagRoot.getShort("progress");
		}
	}
	
	

}
