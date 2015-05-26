package io.github.zaphodious.essentialsorcery.container;

import io.github.zaphodious.essentialsorcery.block.ModBlocks;
import io.github.zaphodious.essentialsorcery.crafting.TestingTableCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerTestingTable extends Container {

	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private BlockPos position;


	public ContainerTestingTable(InventoryPlayer invPlayer, World worldIn,
			BlockPos pos) {


		craftMatrix = new InventoryCrafting(this, 5, 5);
		craftResult = new InventoryCraftResult();
		worldObj = worldIn;
		position = pos;
		
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 131, 36));
		
		int index;
		int posX;
		int posY;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				index = j + i * 5;
				posX = 8 + j * 18;
				posY = 7 + i * 18;
				System.out.println("Adding index " + (index) + " to craftMatrix at position (" +(posX)+ ","+(posY)+ ")");
				this.addSlotToContainer(new Slot(craftMatrix, index, posX, posY));
			}
		}
		
		for (int l = 0; l < 3; l++) {
			for (int m = 0; m < 9; m++) {
				index = m + l * 9 + 9;
				posX = 8 + m * 18;
				posY = 94 + l * 18;
				System.out.println("Adding index " + (index) + " to Inventory at position (" +(posX)+ ","+(posY)+ ")");
				this.addSlotToContainer(new Slot(invPlayer, index, posX, posY ));
			}
		}
		
		for (int n = 0; n < 9; n++) {
			index = n;
			posX = 8 + n * 18;
			posY = 148;
			System.out.println("Adding index " + (index) + " to HotBar at position (" +(posX)+ ","+(posY)+ ")");
			this.addSlotToContainer(new Slot(invPlayer, index, posX, posY));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}


	public void onCraftMatrixChanged(IInventory iinventory) {
		//craftResult.setInventorySlotContents(0, TestingTableCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}







	public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    playerIn.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }


	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		if (worldObj.getBlockState(position).getBlock() != ModBlocks.testing_table) {
			return false;
		} else {
			return playerIn.getDistanceSq(position) <= 64.0D;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

	
}
