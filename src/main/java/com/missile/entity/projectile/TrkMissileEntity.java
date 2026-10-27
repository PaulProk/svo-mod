package com.missile.entity.projectile;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class TrkMissileEntity extends MissileEntity {
	public TrkMissileEntity(EntityType<? extends TrkMissileEntity> type, Level level) {
		super(type, level);
		this.type = MissileType.TRK;
		this.speed = 180.0F;
		this.turnSpeed = 8.0F;
		this.fuseDistance = 200.0F;
	}

	public static TrkMissileEntity create(EntityType<TrkMissileEntity> type, Level level) {
		return new TrkMissileEntity(type, level);
	}
}
