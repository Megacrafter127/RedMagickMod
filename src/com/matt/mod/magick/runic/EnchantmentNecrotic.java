package com.matt.mod.magick.runic;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.matt.mod.magick.lib.MagickLib;


public class EnchantmentNecrotic extends Enchantment {
	  static int id = MagickLib.getIdFor("Necrotic Enchantment ID",53);
	public EnchantmentNecrotic() {
		super(id,1,EnumEnchantmentType.weapon);
	}
		@Override
		public int getMinEnchantability(int par1)
		{
		return 20;
		}
	
		@Override
		public int getMaxEnchantability(int par1)
		{
		return 500;
		}
		@Override
		public int getMinLevel()
		{
		 return 1;
		}
	
		@Override
		public int getMaxLevel()
		{
		 return 5;
	    }
		@Override
		public String getTranslatedName(int par1)
		{
		String enchantmentName = "Necrotic";
		return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
		}
		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			return false;
		}
}
