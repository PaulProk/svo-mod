package com.missile.entity.projectile;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class PturMissileEntity extends MissileEntity {
	public PturMissileEntity(EntityType<? extends PturMissileEntity> type, Level level) {
		super(type, level);
		this.type = MissileType.PTUR;
		this.speed = 55.0F;
		this.turnSpeed = 5.0F;
		this.fuseDistance = 40.0F;
	}

	public static PturMissileEntity create(EntityType<PturMissileEntity> type, Level level) {
		return new PturMissileEntity(type, level);
	}
}
