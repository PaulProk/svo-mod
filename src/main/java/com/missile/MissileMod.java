package com.missile;

import com.missile.registry.MissileRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MissileMod.MOD_ID)
public class MissileMod {
	public static final String MOD_ID = "missile";

	public MissileMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MissileRegistries.register(modEventBus);
	}
}
