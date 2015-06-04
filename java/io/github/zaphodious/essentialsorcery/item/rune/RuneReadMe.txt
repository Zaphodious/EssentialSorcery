Rather then comment on every individual rune file, It's much easier (less copy-paste) to just make a read-me.

Note- for more information about how spells work as a whole, please see spellcasting.runeboards.basicboard.

Types

There are three types of rune, each one based on a specific abstract class located in spellcasting.abstractrunes: Element (RuneElement), Shape (RuneShape), and Effect(RuneEffect).

Element runes give each spell its element. It is used by Effect runes to determine what effect to give, as well as by the caster item to determine if a spell can gain essence from a tap in a particular biome.

Shape runes tell the spell how it should identify its targets. A projectile rune will send out an elementally-aligned subclass of spellcasting.targeting.TargetingProjectile that in turn calls each Effect Rune ItemStack within the main Caster item passing back information about what the projectile hit. A self rune will directly call the effect runes, passing back information about the player as though the player were being hit. Other shape runes (will) operate in a similar fashion.

Effect runes provide the real meat of each spell. Each effect starts with a call to makeMagic, a method implemented by the RuneEffect superclass. (It is recommended that this be overridden (and super.makeMagic() invoked within the override) if a targeting filter needs to be applied (ex: RuneEffectAttack only wants to go off if the targeting entity hits an entity, so it checks to see if movObjPos.entityHit has something in it before it calls the super function).) That method determines which Effect method (ex: waterEffect, fireEffect) to call based on what Element rune is included in the caster item. Each method then takes the information passed to it, and does something.

Effect Logic

In general, there are three different kinds of effect: effects that apply a potion effect to the target entity, effects that do something directly to the target entity, and effects that do something directly to the block/area that the target has hit (not necessarily an entity).

The one overriding concept that should be implemented with all spells, is that the spell effect gets better the larger the stack containing this effect's runes. The largest stack that will be seen is 42, though most spells will be far below that. Spell costs scale with the Fibonacci sequence starting with 1,2, such that (for example) a spell with 3 effect runes will cost 3 essence to cast while a spell with 8 effect runes will cost 34.

Potion effects

Exerpt from RuneEffectDefend.java :

	@Override
	public boolean fireEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {

		int spellStrength = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		try {
			EntityLivingBase hitPlayer = (EntityLivingBase) movObjPos.entityHit;

			hitPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance
					.getId(), spellStrength * 200, spellStrength / 5, false,
					true));

			return true;

		} catch (Exception e) {

		}
		return false;
	}
	
This spell puts a Fire Resistance potion effect on the player. First, we get the number of runes in this stack, by using thisRuneKey to get the correct ItemStack object within runeMapIn. Surrounded by a try block (so that nothing happens if the entity can't have potion effects applied), we type-cast the entity that the spell hit to EntityLivingBase (which can have potion effects applied, whereas simple entities cannot). Then, we apply the potion effect using .addPotionEffect(), first passing in the ID of the potion we want (in this case, Potion.fireResistance.getId()). For the length of the effect, we multiply the stack size by 200, giving us 200 ticks (or 10 seconds) per item in the stack. For the level of the potion effect, we make it so that every five items in the stack bumps up the potion effect by 1 level. This is not an ambient effect, and we do want to have particles, so we pass in false and true respectively. Then, as the potion has been applied, we return true. Aside from numbers being tweaked (and, in the future, custom potion effects being applied) this is how each potion-effect-giving effect function works.

Direct Effects to Entity

Excerpt from RuneEffectAttack.java :

	@Override
	public boolean woodEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {

		int damageToDeal = RuneHelper.totalEffectRunesIn(runeMapIn
				.get(thisRuneKey));
		movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(entity, throwerIn), damageToDeal*3);
		throwerIn.heal(damageToDeal*3);
		return true;
	}

This is a vampiric spell, hurting the target and healing the caster. Like with potions, we get the ItemStack size using thisRuneKey to reference the correct ItemStack within runeMapIn. Next, we use the Entity class's attackEntityFrom() method to deal damage to the entity equal to three times the number of runes in the stack. Then, we heal the player, represented here by EntityLivingBase throwerIn, by that much using .heal().

Direct effects to world

Excerpt from RuneEffectSpawnVanilla.java :

	@Override
	public boolean airEffect(Entity entity, World worldIn,
			EntityLivingBase throwerIn, Map<String, ItemStack> runeMapIn,
			BlockPos pos, MovingObjectPosition movObjPos, String thisRuneKey) {

		try {
			int spellPower = runeMapIn.get(thisRuneKey).stackSize;
			EntityPlayer playerCaster = (EntityPlayer) throwerIn;
			EntityOcelot entityOcelot = new EntityOcelot(worldIn);
			entityOcelot.setTamed(true);
			entityOcelot.setTameSkin(1 + worldIn.rand.nextInt(3));
            entityOcelot.setOwnerId(throwerIn.getUniqueID().toString());
            entityOcelot.setHealth(10*spellPower);
			entityOcelot.setLocationAndAngles(pos.getX(), pos.getY(),
					pos.getZ(), entity.rotationYaw, 0.0F);
			worldIn.spawnEntityInWorld(entityOcelot);
			return true;
		} catch (Exception e) {

		}
		return false;
	}
	
This spell spawns a cat, pre-tamed and owned by the caster, into the world. As before, we get the stack size of the ItemStack with thisRuneKey. We then (surrounded by a try block as per usual) get an EntityPlayer variable by casting throwerIn. We then make a new EntityOcelot, tame it, set its tamed skin at random (we add 1 to the random result as the default yellow Ocelot skin is at index 0)), and set its owner to be the casting player. For health, we set that to be ten for each rune in the stack. We want it to spawn at the position indicated by the targeting entity, so we use setLocationAndAngles by passing in  values contained in the pos and entity variables. Finally, we spawn the entity into the world. (See woodEffect() in RuneEffectSpawnVanilla.java for spawning a dog.)

