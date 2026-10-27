package com.missile.registry;

import com.missile.MissileMod;
import com.missile.entity.MissileType;
import com.missile.entity.projectile.PturMissileEntity;
import com.missile.entity.projectile.RpgMissileEntity;
import com.missile.entity.projectile.TrkMissileEntity;
import com.missile.entity.projectile.ZurMissileEntity;
import com.missile.item.PturItem;
import com.missile.item.Rpg7Item;
import com.missile.item.ZurItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.component.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MissileRegistries {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MissileMod.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(ForgeRegistries.CREATIVE_MODE_TABS, MissileMod.MOD_ID);

	public static final RegistryObject<Item> RPG7 = ITEMS.register("rpg7", () -> new Rpg7Item(new Item.Properties()));
	public static final RegistryObject<Item> PTUR_ITEM = ITEMS.register("ptur", () -> new PturItem(new Item.Properties()));
	public static final RegistryObject<Item> ZUR_ITEM = ITEMS.register("zur", () -> new ZurItem(new Item.Properties()));

	public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("missile_arsenal", () ->
		CreativeModeTab.builder().icon(() -> new ItemStack(RPG7.get()))
			.title(Component.literal("Missile Arsenal"))
			.displayItems((params) -> {
				params.accept(RPG7.get());
				params.accept(PTUR_ITEM.get());
				params.accept(ZUR_ITEM.get());
			})
			.build()
	);

	public static void register(IEventBus modEventBus) {
		ITEMS.register(modEventBus);
		CREATIVE_MODE_TABS.register(modEventBus);
	}
}
