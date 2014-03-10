package com.matt.mod.magick.runic;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.magick.lib.MagickLib;

public class RunicHelper {
	public static final EnchantmentRunic eRunic= new EnchantmentRunic();
	public static final EnchantmentNecrotic eNecrotic = new EnchantmentNecrotic();
	public static EnumToolMaterial runicToolMat = EnumHelper.addToolMaterial("Runic",5,Integer.MAX_VALUE,99.9F,95F,1000);
	public RunicHelper() {
		
	}
	public void init() {
		FutureCraftRegistry.registerEnchantment(eRunic,eRunic.id);
		FutureCraftRegistry.registerEnchantment(eNecrotic,eNecrotic.id);
	}
}
