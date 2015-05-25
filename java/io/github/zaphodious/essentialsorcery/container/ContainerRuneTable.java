package io.github.zaphodious.essentialsorcery.container;

import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRuneTable extends Container {

	protected TileEntityRuneTable tileEntity;

	public ContainerRuneTable(InventoryPlayer inventoryPlayer,
			TileEntityRuneTable tileEntity) {
		this.tileEntity = tileEntity;

		
		//addSlotToContainer(new Slot(tileEntity, 1, 1, ))
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("crafting slot " + (j + i * 3) + " added");
				addSlotToContainer(new Slot(tileEntity, j + i * 3, 60 + j * 20,
						25 + i * 20));
			}
		}
		
		addSlotToContainer(new Slot(tileEntity, 6, 19, 36));
		addSlotToContainer(new Slot(tileEntity, 7, 148, 35));
		addSlotToContainer(new Slot(tileEntity, 0, 0, 0));
		this.bindPlayerInventory(inventoryPlayer);
	}

	public String getDisplayName() {
		
		
		return tileEntity.getName();
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return tileEntity.isUseableByPlayer(playerIn);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int index = j + i * 9 + 9;
				addSlotToContainer(new Slot(inventoryPlayer,index,
						8 + j * 18, 67 + i * 18));
				System.out.println("inventory slot " + (index) + " added");
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 125));
			System.out.println("hot bar slot " + i + " added");
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot < tileEntity.getSizeInventory()) {
				if (!this.mergeItemStack(stackInSlot,
						tileEntity.getSizeInventory(),
						36 + tileEntity.getSizeInventory(), true)) {
					return null;
				}
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if (!this.mergeItemStack(stackInSlot, 0,
					tileEntity.getSizeInventory(), false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
}
