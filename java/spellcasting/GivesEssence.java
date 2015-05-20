package spellcasting;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface GivesEssence {

	public Essence getEssence(World worldIn, BlockPos pos);
	public Element getElement(World worldIn, BlockPos pos);
	public Boolean canTap(World worldIn, BlockPos pos);
	
}
