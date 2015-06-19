package io.github.zaphodious.essentialsorcery.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock {

    public ItemBlockMeta(Block block) {
        super(block);
        
        if (!(block instanceof IMetaBlockName)) {
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of ISpecialBlockName!", block.getUnlocalizedName()));
        }
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
    	String toReturn = super.getUnlocalizedName(stack) + "_" + ((IMetaBlockName)this.block).getSpecialName(stack);
    	//System.out.println("This is the name that we got from getUnlocalizedName: " + toReturn);
        return toReturn;
    }
}