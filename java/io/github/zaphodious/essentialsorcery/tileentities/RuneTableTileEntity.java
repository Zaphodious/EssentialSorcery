package io.github.zaphodious.essentialsorcery.tileentities;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.item.ModItems;
import io.github.zaphodious.essentialsorcery.spellcasting.MaterialLevel;
import io.github.zaphodious.essentialsorcery.spellcasting.RuneHelper;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneEffect;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneElement;
import io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.RuneShape;
import io.github.zaphodious.essentialsorcery.spellcasting.runeboards.BasicBoard;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
		
		
		// 42 is the maximum power level for runes. So, if the total power level is above 42, it won't make a rune!
		if (RuneHelper.totalPowerLevelIn(inventory) > 42) {
			return false;
		}
		
		
		
		try { // make sure that the inventory contains at least one element, one shape, and one effect in the correct slots, or else nothing happens.
			RuneElement runeTestElement = (RuneElement) inventory[2].getItem();
			RuneShape runeTestShape = (RuneShape) inventory[3].getItem();
			RuneEffect runeTestEffect = (RuneEffect) inventory[4].getItem();
		} catch (Exception e) {
			System.out.println("Things weren't in the correct place. Error: " + e );
			return false;
		}
		
		
		int materialFactor = 0;
		
		try {
			for (MaterialLevel level : MaterialLevel.values()) {
			if (inventory[0].getItem() == level.getItem()) {
				materialFactor = level.getLevel();
				
			}
		} 
			
		} catch (Exception e) {
			return false;
		}
		
		if (materialFactor == 0 || materialFactor < RuneHelper.totalPowerLevelIn(inventory)) {
			return false;
		}
		
		
		
		inventory[1] = this.figureOutWhichBoard();
		
		
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
	
	private RuneElement getElementRune(){
		RuneElement elementRune = null;
		try {
			elementRune = (RuneElement) inventory[2].getItem();
		} catch (Exception e) {
		}
		return elementRune;
	}
	
	private ItemStack figureOutWhichBoard() {
		//  Goes through a list of spell-caster items, and finds the one that fits
		//  with what the player has in the input boxes.
		ItemStack toReturn = new ItemStack(ModItems.glove_wood_fire);
		for (Item item : ModItems.getBoardRegistery()) {
			BasicBoard board = (BasicBoard) item;
			if (board.getMaterialLevel().getItem() == inventory[0].getItem()) {
				if (board.getElement() == getElementRune().getElement()) {
					toReturn = new ItemStack(item);
				}
				
			}
		}
		
		
		return toReturn;
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
