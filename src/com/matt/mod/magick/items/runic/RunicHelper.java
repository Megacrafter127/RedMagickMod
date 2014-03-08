package com.matt.mod.magick.items.runic;

import net.minecraft.enchantment.Enchantment;

import com.matt.mod.handlers.FutureCraftRegistry;

public class RunicHelper {
	public static final Enchantment eRunic= new EnchantmentRunic();
	public RunicHelper() {
		
	}
	public void init() {
		FutureCraftRegistry.registerEnchantment(eRunic,52);
		
	}
}
