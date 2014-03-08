package com.matt.mod.magick.items.runic;

import com.google.common.collect.ObjectArrays;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class EnchantmentRunic extends Enchantment{
	public static int idNew;
	protected EnchantmentRunic(int par1, int par2,
			EnumEnchantmentType par3EnumEnchantmentType) {
		super(52, 1, EnumEnchantmentType.all);
		
	}
	public EnchantmentRunic() {
		super(52, 1, EnumEnchantmentType.all);
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
	 String enchantmentName = "Runic";
	 return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	 }
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}

}
