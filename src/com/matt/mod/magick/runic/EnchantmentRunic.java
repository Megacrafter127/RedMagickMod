package com.matt.mod.magick.runic;

import com.matt.mod.magick.lib.MagickLib;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.EnumHelper;

public class EnchantmentRunic extends Enchantment{
	public static int idNew;
	public static int id = MagickLib.getIdFor("Runic Enchantment ID",52);
	public EnchantmentRunic() {
		super(id, 1, EnumEnchantmentType.armor);
		
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
