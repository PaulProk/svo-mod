package com.missile.item;

import com.missile.entity.MissileEntity;
import com.missile.entity.MissileType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.PlayerEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PturItem extends MissileItem {
	public PturItem(Item.Properties properties) {
		super(properties, MissileType.PTUR, 55.0F, 5.0F, 40.0F);
	}

	@Override
	public MissileEntity createMissile(Level level, double x, double y, double z, Entity owner) {
		return null;
	}
}
