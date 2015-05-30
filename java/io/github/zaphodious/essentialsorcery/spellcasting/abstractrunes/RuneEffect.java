package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

import io.github.zaphodious.essentialsorcery.core.Reference;
import net.minecraft.item.Item;

public abstract class RuneEffect extends Item implements Rune {

	protected int id;
	protected String name;
	
	public RuneEffect(int id, String name) {
		this.id = id;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Reference.tabEssential);
	}
	
	
	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}


	/* (non-Javadoc)
	 * @see io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes.Rune#getID()
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}


	public abstract boolean fireEffect();
	public abstract boolean waterEffect();
	public abstract boolean airEffect();
	public abstract boolean earthEffect();
	public abstract boolean woodEffect();
	
}
