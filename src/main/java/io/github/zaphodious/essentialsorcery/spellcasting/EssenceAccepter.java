package io.github.zaphodious.essentialsorcery.spellcasting;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EssenceAccepter extends Item implements UsesEssence {

	protected Element element;

	public EssenceAccepter(int maxPool, Element element) {
		super();
		this.element = element;
		this.setMaxDamage(maxPool);
	}

	public boolean useTap(
			World worldIn,
			BlockPos pos,
			ItemStack stack,
			EntityPlayer playerIn) {
		GivesEssence giver = null;
		// get the specific block
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		try { // If this block doesn't implement the GivesEssence interface, the
				// function stops.
			giver = (GivesEssence) block;
		} catch (Exception e) {
			System.out.println("Didn't pass the GivesEssence test.");
			return false;
		}

		if (giver.getElement(worldIn, pos) != this.element
				&& this.element != Element.NEUTRAL) {
			System.out.println("Didn't pass the element test.");
			return false; // If this block doesn't give the right type of
							// essence, the function stops.
		}

		if (giver.canTap(worldIn, pos)) {

			Essence newEssence = giver.getEssence(worldIn, pos);

			System.out.println("This Damage: "
					+ stack.getItemDamage()
					+ " New Essence amount :"
					+ newEssence.getAmount()
					+ " while this Damage Limit = "
					+ this.getMaxDamage());

			if (newEssence.getAmount() > this.getDamage(stack)) {
				System.out.println("Didn't pass the amount test.");
				return false; // If this will add more essence then the max, the
								// function stops.
			}

			// stack.setItemDamage(stack.getItemDamage() -
			// newEssence.getAmount());
			// DragonTap.dragonToSpent(worldIn, pos);
			// stack.damageItem(newEssence.getAmount(), playerIn);
			// this.setDamage(stack, this.getDamage(stack) -
			// newEssence.getAmount());
			return true;
		}

		System.out.println("Didn't pass the canTap test."); // If this block
															// cannot be tapped,
															// the function
															// skips to the end.
		return false;

	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public boolean useEssence(int req, ItemStack stack) {
		if (stack.getItemDamage() + req > stack.getMaxDamage()) {
			return false;
		}

		stack.setItemDamage(stack.getItemDamage() + req);

		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		subItems.add(new ItemStack(itemIn, 1, this.getMaxDamage()));
		subItems.add(new ItemStack(itemIn, 1, 0));
	}

}
