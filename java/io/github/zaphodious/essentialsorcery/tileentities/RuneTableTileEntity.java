package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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

	
	public boolean makeTheSpell() {
		
		inventory[1] = new ItemStack(ModItems.testWand);
		
		
		
		
		NBTTagList runes = new NBTTagList();
		inventory[1].setTagCompound(new NBTTagCompound());
		NBTTagCompound tbttc = inventory[1].getTagCompound();
		
		for (int i = 2; i < 8; i++) {
			if (inventory[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				try {
					Rune newRune = (Rune) inventory[i].getItem();
					
				} catch (Exception e) {
					
				}
				
				inventory[i].writeToNBT(compound);
				String testName = inventory[i].getUnlocalizedName();
				ItemStack testItem = inventory[i];
				inventory[1].getTagCompound().setTag(inventory[i].getUnlocalizedName(), compound);
			}
		}
		
		
		// for(ItemStack rune : runeStacks) { NBTTagCompound c = new NBTTagCompound(); rune.writeToNBT(c); runes.appendTag(c); }
		inventory[1].setStackDisplayName("Iron Fisted Warrior Wand");
		this.sync();
		return true;
		
	}
	
	private boolean writeRuneToNBT(int i) {
		try {
			Rune newRune = (Rune) inventory[i].getItem();
			
		} catch (Exception e) { //If this doesn't implement the "rune" interface, we skip it.
			return false;
		}
		
		String runeIndex;
		
		switch (i) {
		
		
		
		
		
		}
		
		return true;
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
			
			/*if (inventory[0] == null) {
				//inventory[1] = null;
			
			} else {
				inventory[1] = inventory[0].copy();
				//inventory[0].stackSize--;
				progress = 0;
				if (inventory[0].stackSize <= 0) {
					inventory[0] = null;
				}
				
			
			//}
				
		
			
			this.sync();
			}*/
		}
		
	}
	
	/*This method builds the spell, first getting a HashMap that includes the board itself and
	all of the runes used in creation, followed by a number that indicates how many Effect Runes
	are being passed.*/
	
	public boolean setInventory() {
		ItemStack boardStack = inventory[1];
		
		
		boardStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound compound = new NBTTagCompound();
		new ItemStack(Items.apple).writeToNBT(compound);
		boardStack.getTagCompound().setTag("apple", compound);
		
		return false;
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
