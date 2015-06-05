package io.github.zaphodious.essentialsorcery.container;

import io.github.zaphodious.essentialsorcery.tileentities.TileEntityRuneTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerRuneTable extends Container
{
    /** The crafting matrix inventory (3x3). */
    public ISidedInventory craftMatrix;
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    /** Position of the workbench */
    private BlockPos pos;
    private static final String __OBFID = "CL_00001744";
    protected TileEntityRuneTable tileEntity;

    public ContainerRuneTable(InventoryPlayer playerInventory, World worldIn, BlockPos posIn)
    {
    	this.craftMatrix = new TileEntityRuneTable();
        this.worldObj = worldIn;
        this.pos = posIn;
        //this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        int i;
        int j;

        for (int i1 = 0; i1 < 2; i1++) {
			for (int j1 = 0; j1 < 3; j1++) {
				System.out.println("crafting slot " + (j1 + i1 * 3) + " added");
				addSlotToContainer(new Slot(tileEntity, j1 + i1 * 3, 60 + j1 * 20,
						8 + i1 * 20));
			}
		}
		
		addSlotToContainer(new Slot(tileEntity, 6, 19, 19));
		addSlotToContainer(new Slot(tileEntity, 7, 148, 18));
		addSlotToContainer(new Slot(tileEntity, -1, 0, 0));
		this.bindPlayerInventory(playerInventory);

        

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
	public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        //this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    	System.out.println("onCraftMatrixChanged has been called");
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int index = j + i * 9 + 9;
				addSlotToContainer(new Slot(inventoryPlayer,index,
						8 + j * 18, 50 + i * 18));
				System.out.println("inventory slot " + (index) + " added");
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 108));
			System.out.println("hot bar slot " + i + " added");
		}
	}
    
    /**
     * Called when the container is closed.
     */
    @Override
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
	public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.worldObj.getBlockState(this.pos).getBlock() != Blocks.crafting_table ? false : playerIn.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    @Override
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

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    @Override
	public boolean canMergeSlot(ItemStack stack, Slot p_94530_2_)
    {
        return p_94530_2_.inventory != this.craftResult && super.canMergeSlot(stack, p_94530_2_);
    }
}