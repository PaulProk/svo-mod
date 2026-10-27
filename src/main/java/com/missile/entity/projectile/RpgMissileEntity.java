package com.missile.entity.projectile;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class RpgMissileEntity extends MissileEntity {
	public RpgMissileEntity(EntityType<? extends RpgMissileEntity> type, Level level) {
		super(type, level);
		this.type = MissileType.RPG;
		this.speed = 120.0F;
		this.turnSpeed = 10.0F;
		this.fuseDistance = 30.0F;
	}

	public static RpgMissileEntity create(EntityType<RpgMissileEntity> type, Level level) {
		return new RpgMissileEntity(type, level);
	}
}
