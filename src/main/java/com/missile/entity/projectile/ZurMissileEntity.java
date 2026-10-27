package com.missile.entity.projectile;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ZurMissileEntity extends MissileEntity {
	public ZurMissileEntity(EntityType<? extends ZurMissileEntity> type, Level level) {
		super(type, level);
		this.type = MissileType.ZUR;
		this.speed = 90.0F;
		this.turnSpeed = 12.0F;
		this.fuseDistance = 25.0F;
	}

	public static ZurMissileEntity create(EntityType<ZurMissileEntity> type, Level level) {
		return new ZurMissileEntity(type, level);
	}
}
