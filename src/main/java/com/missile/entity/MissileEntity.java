package com.missile.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.data.DataTracker;
import net.minecraft.world.entity.projectile.ProjectileEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.Vec3;

public abstract class MissileEntity extends ProjectileEntity {
	public com.missile.entity.MissileType type;
	public Entity target;
	public float turnSpeed;
	public float speed;
	public float fuseDistance;

	private final BlockPos launchPos;
	private boolean exploded;

	public MissileEntity(EntityType<? extends MissileEntity> type, Level level) {
		super(type, level);
		this.launchPos = new BlockPos(getX(), getY(), getZ());
		this.exploded = false;
	}

	public com.missile.entity.MissileType getMissileType() {
		return this.type;
	}

	public float getTurnSpeed() {
		return this.turnSpeed;
	}

	public float getSpeed() {
		return this.speed;
	}

	public float getFuseDistance() {
		return this.fuseDistance;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}

	public Entity getTarget() {
		return this.target;
	}

	protected void steerTowards(Entity target) {
		BlockPos pos = this.blockPosition();
		BlockPos tar = target.blockPosition();
		double dx = tar.getX() - pos.getX();
		double dy = tar.getY() - pos.getY();
		double dz = tar.getZ() - pos.getZ();
		double distSq = dx * dx + dy * dy + dz * dz;
		if (distSq < 1.0E-6) {
			return;
		}
		double dist = Math.sqrt(distSq);
		double yaw = Math.toDegrees(Math.atan2(dz, dx));
		double pitch = Math.toDegrees(Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)));
		float yawRad = this.getYaw();
		float pitchRad = this.getPitch();
		double diffYaw = yaw - yawRad;
		while (diffYaw > Math.PI) {
			diffYaw -= Math.PI * 2;
		}
		while (diffYaw < -Math.PI) {
			diffYaw += Math.PI * 2;
		}
		if (Math.abs(diffYaw) > turnSpeed) {
			diffYaw = (diffYaw > 0 ? turnSpeed : -turnSpeed);
		}
		this.setYaw((float) (this.getYaw() + (float) Math.toRadians(diffYaw)));
		this.setPitch((float) (this.getPitch() + (float) Math.toRadians(diffYaw * (float) Math.tan(pitchRad))));
	}

	@Override
	protected void initDataTracker(net.minecraft.core.registries.DataRegistries dataRegistries) {
	}

	@Override
	public void tick() {
		super.tick();
		if (this.exploded) {
			this.discard();
			return;
		}
		if (this.target != null && this.target.isAlive()) {
			this.steerTowards(this.target);
			Vec3 forward = this.getRotationVector().normalize().multiply(this.speed * 0.1F);
			this.setDeltaMovement(forward.x, forward.y, forward.z);
		}
		BlockPos pos = this.blockPosition();
		double dist = pos.distSqr(this.launchPos.getX(), this.launchPos.getY(), this.launchPos.getZ());
		if (dist >= this.fuseDistance * this.fuseDistance) {
			this.exploded = true;
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 4.0F, false, Explosion.BlockInteraction.ALWAYS);
			this.discard();
		}
	}
}
