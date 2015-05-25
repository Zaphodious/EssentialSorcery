package io.github.zaphodious.essentialsorcery.spellcasting.abstractrunes;

public abstract class RuneEffect implements Rune {

	protected int id;
	protected String name;
	
	public RuneEffect(int id, String name) {
		this.id = id;
		this.name = name;
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
