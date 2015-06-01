package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;
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
		
		try { // make sure that the inventory contains at least one element, one shape, and one effect in the correct slots, or else nothing happens.
			RuneElement runeTestElement = (RuneElement) inventory[2].getItem();
			RuneShape runeTestShape = (RuneShape) inventory[3].getItem();
			RuneEffect runeTestEffect = (RuneEffect) inventory[4].getItem();
		} catch (Exception e) {
			System.out.println("Things weren't in the correct place. Error: " + e );
			return false;
		}
		
		inventory[1] = new ItemStack(ModItems.testWand);
		
		
		String displayString = "";
		
		NBTTagList runes = new NBTTagList();
		inventory[1].setTagCompound(new NBTTagCompound());
		NBTTagCompound tbttc = inventory[1].getTagCompound();
		
		for (int i = 2; i < 8; i++) {
			if (inventory[i] != null) {
				boolean isRune = this.writeRuneToNBT(i);
				if (isRune) {
					Rune thisRune = (Rune) inventory[i].getItem();
					displayString += " " + thisRune.getTitleString();
				}
			}
		}
		
		displayString += " lvl ";
		int spellLevel = 0;
		
		for (int i = 4; i < 8; i++) {
			if (inventory[i] != null) {
				boolean isRune = this.writeRuneToNBT(i);
				if (isRune) {
					spellLevel += RuneHelper.totalEffectRunesIn(inventory[i]);
				}
			}
		}
		
		displayString += "" + spellLevel;
		
		// for(ItemStack rune : runeStacks) { NBTTagCompound c = new NBTTagCompound(); rune.writeToNBT(c); runes.appendTag(c); }
		inventory[1].setStackDisplayName("Spell of" + displayString);
		this.sync();
		return true;
		
	}
	
	private boolean writeRuneToNBT(int i) {
		System.out.println("The 'i' passed to writeRuneToNBT is " + i);
		try {
			Rune newRune = (Rune) inventory[i].getItem();
			
		} catch (Exception e) { //If this doesn't implement the "rune" interface, we skip it.
			System.out.println(inventory[i].toString() + "isn't a Rune");
			return false;
		}
		
		System.out.println("successfully turned " + inventory[i] + " into a rune-type");
		
		String runeIndex = "useless";
		
		switch (i) {
		
		
		case 2: runeIndex = "element";
			break;
		case 3: runeIndex = "shape";
			break;
		case 4: runeIndex = "effect1";
			break;
		case 5: runeIndex = "effect2";
			break;
		case 6: runeIndex = "effect3";
			break;
		case 7: runeIndex = "effect4";
			break;
		
		}
			
			NBTTagCompound compound = new NBTTagCompound();
			inventory[i].writeToNBT(compound);
			ItemStack testItem = inventory[i];
			inventory[1].getTagCompound().setTag(runeIndex, compound);
			System.out.println("put " + inventory[1].getTagCompound().getTag(runeIndex) + " into the wand. The runeIndex is " + runeIndex);
		
		
		
		
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
