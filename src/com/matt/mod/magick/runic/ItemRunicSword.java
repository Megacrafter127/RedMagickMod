package com.matt.mod.magick.runic;

import java.util.Map;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.matt.mod.magick.lib.MagickLib;

public class ItemRunicSword extends ItemSword {

	public ItemRunicSword() {
		super(MagickLib.getIdFor("Runic Sword",3203),RunicHelper.runicToolMat);
		setTextureName(MagickLib.toTextureName("swordrunic"));
	}
	@Override
	 public boolean hitEntity(ItemStack stack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	    {
			stack.damageItem(1,par2EntityLivingBase);
			Map enchantsMap = EnchantmentHelper.getEnchantments(stack);
			if(enchantsMap.containsKey(RunicHelper.eNecrotic.id)) {
				par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.getId(),0,1));
			}else {
				//nope
				return false;
			}
			
		 return true;
	    }
}
