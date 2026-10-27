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

public class Rpg7Item extends MissileItem {
	public Rpg7Item(Item.Properties properties) {
		super(properties, MissileType.RPG, 120.0F, 10.0F, 30.0F);
	}

	@Override
	public MissileEntity createMissile(Level level, double x, double y, double z, Entity owner) {
		return new RpgMissileEntity(MissileRegistries.RPG7.get(), level);
	}
}
