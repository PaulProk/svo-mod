package com.missile.item;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import com.missile.entity.projectile.RpgMissileEntity;
import com.missile.registry.MissileRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.PlayerEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;

public abstract class MissileItem extends Item {
	protected final MissileType missileType;
	protected final float speed;
	protected final float turnSpeed;
	protected final float fuseDistance;

	protected MissileItem(Item.Properties properties, MissileType missileType, float speed, float turnSpeed, float fuseDistance) {
		super(properties);
		this.missileType = missileType;
		this.speed = speed;
		this.turnSpeed = turnSpeed;
		this.fuseDistance = fuseDistance;
	}

	public MissileType getMissileType() {
		return this.missileType;
	}

	public float getSpeed() {
		return this.speed;
	}

	public float getTurnSpeed() {
		return this.turnSpeed;
	}

	public float getFuseDistance() {
		return this.fuseDistance;
	}

	public abstract MissileEntity createMissile(Level level, double x, double y, double z, Entity owner);

	@Override
	public InteractionResult use(ItemStack stack, Level level, PlayerEntity player, InteractionHand hand) {
		if (level != null && player != null) {
			double x = player.getX();
			double y = player.getY();
			double z = player.getZ();
			MissileEntity missile = createMissile(level, x, y, z, player);
			if (missile != null) {
				missile.setPos(x, y, z);
				Vec3 velocity = player.getLookAngle().normalize().scale(this.speed);
				missile.setDeltaMovement(velocity.x, velocity.y, velocity.z);
				missile.setOwner(player);

				level.addFreshEntity(missile);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}
