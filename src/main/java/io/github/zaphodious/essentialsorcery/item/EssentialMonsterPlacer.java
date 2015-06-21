package io.github.zaphodious.essentialsorcery.item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import io.github.zaphodious.essentialsorcery.core.Reference;
import io.github.zaphodious.essentialsorcery.entity.monster.EntityHobgoblin;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EssentialMonsterPlacer extends ItemMonsterPlacer {

	int primaryColor;
	int secondaryColor;
	String unlocalizedName;
	Class entityClass;

	public EssentialMonsterPlacer(String unlocalizedName, Class entityToSpawn, int primaryColor, int secondaryColor) {

		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.unlocalizedName = unlocalizedName;

		this.entityClass = entityToSpawn.getClass();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.ItemMonsterPlacer#getColorFromItemStack(net.minecraft
	 * .item.ItemStack, int)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
		// TODO Auto-generated method stub
		return (renderPass == 0 ? this.primaryColor : this.secondaryColor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.ItemMonsterPlacer#getItemStackDisplayName(net.minecraft
	 * .item.ItemStack)
	 */
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		// TODO Auto-generated method stub
		return super.getItemStackDisplayName(stack);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.ItemMonsterPlacer#onItemUse(net.minecraft.item.ItemStack
	 * , net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World,
	 * net.minecraft.util.BlockPos, net.minecraft.util.EnumFacing, float, float,
	 * float)
	 */
	@Override
	public boolean onItemUse(
			ItemStack stack,
			EntityPlayer playerIn,
			World worldIn,
			BlockPos pos,
			EnumFacing side,
			float hitX,
			float hitY,
			float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
			return false;
		} else {
			IBlockState iblockstate = worldIn.getBlockState(pos);

			// TODO: Make it so that mob spawners can spawn this mob.

			/*
			 * if (iblockstate.getBlock() == Blocks.mob_spawner) { TileEntity
			 * tileentity = worldIn.getTileEntity(pos);
			 * 
			 * if (tileentity instanceof TileEntityMobSpawner) {
			 * MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)
			 * tileentity) .getSpawnerBaseLogic();
			 * mobspawnerbaselogic.setEntityName
			 * (entityToSpawn.getDisplayName().getFormattedText());
			 * tileentity.markDirty(); worldIn.markBlockForUpdate(pos);
			 * 
			 * if (!playerIn.capabilities.isCreativeMode) { --stack.stackSize; }
			 * 
			 * return true; } }
			 */

			/*
			 * pos = pos.offset(side); double d0 = 0.0D;
			 * 
			 * if (side == EnumFacing.UP && iblockstate instanceof BlockFence) {
			 * d0 = 0.5D; }
			 * 
			 * Entity entity = spawnCreature(worldIn, entityToSpawn, (double)
			 * pos.getX() + 0.5D, (double) pos.getY() + d0, (double) pos.getZ()
			 * + 0.5D);
			 * 
			 * if (entity != null) { if (entity instanceof EntityLivingBase &&
			 * stack.hasDisplayName()) {
			 * entity.setCustomNameTag(stack.getDisplayName()); }
			 * 
			 * if (!playerIn.capabilities.isCreativeMode) { --stack.stackSize; }
			 * }
			 */

			try {
				EntityLivingBase entityLiving = null;

				Constructor<?> cons = this.entityClass.getConstructor(World.class);
				Object object = cons.newInstance(worldIn);

				entityLiving = (EntityLivingBase) object;

				entityLiving.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), entityLiving.rotationYaw, 0.0F);
				worldIn.spawnEntityInWorld(entityLiving);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

			if (!playerIn.capabilities.isCreativeMode) {
				--stack.stackSize;
			}

			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.ItemMonsterPlacer#onItemRightClick(net.minecraft.item
	 * .ItemStack, net.minecraft.world.World,
	 * net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (worldIn.isRemote) {
			return itemStackIn;
		} else {
			/*
			 * MovingObjectPosition movingobjectposition = this
			 * .getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
			 * 
			 * if (movingobjectposition == null) { return itemStackIn; } else {
			 * if (movingobjectposition.typeOfHit ==
			 * MovingObjectPosition.MovingObjectType.BLOCK) { BlockPos blockpos
			 * = movingobjectposition.getBlockPos();
			 * 
			 * if (!worldIn.isBlockModifiable(playerIn, blockpos)) { return
			 * itemStackIn; }
			 * 
			 * if (!playerIn.canPlayerEdit(blockpos,
			 * movingobjectposition.sideHit, itemStackIn)) { return itemStackIn;
			 * }
			 * 
			 * if (worldIn.getBlockState(blockpos).getBlock() instanceof
			 * BlockLiquid) { Entity entity = spawnCreature(worldIn,
			 * itemStackIn.getMetadata(), (double) blockpos.getX() + 0.5D,
			 * (double) blockpos.getY() + 0.5D, (double) blockpos.getZ() +
			 * 0.5D);
			 * 
			 * if (entity != null) { if (entity instanceof EntityLivingBase &&
			 * itemStackIn.hasDisplayName()) { ((EntityLiving) entity)
			 * .setCustomNameTag(itemStackIn .getDisplayName()); }
			 * 
			 * if (!playerIn.capabilities.isCreativeMode) {
			 * --itemStackIn.stackSize; }
			 * 
			 * playerIn.triggerAchievement(StatList.objectUseStats[Item
			 * .getIdFromItem(this)]); } } }
			 * 
			 * return itemStackIn; }
			 */

			return itemStackIn;
		}
	}

	public static Entity spawnCreature(World worldIn, EntityLiving entityToSpawn, double x, double y, double z) {
		/*
		 * if (!EntityList.entityEggs.containsKey(Integer.valueOf(entityID))) {
		 * return null; } else {
		 */
		Entity entity = null;

		entity = entityToSpawn;

		if (entity instanceof EntityLivingBase) {
			EntityLiving entityliving = (EntityLiving) entity;
			entity.setLocationAndAngles(
					x,
					y,
					z,
					MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F),
					0.0F);
			entityliving.rotationYawHead = entityliving.rotationYaw;
			entityliving.renderYawOffset = entityliving.rotationYaw;
			entityliving.onInitialSpawn(
					worldIn.getDifficultyForLocation(new BlockPos(entityliving)),
					(IEntityLivingData) null);
			worldIn.spawnEntityInWorld(entity);
			entityliving.playLivingSound();
		}

		return entity;
		// }
	}
}
