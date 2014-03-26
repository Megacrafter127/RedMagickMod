package com.futurecraft.mod.magick.runic;

import java.util.List;
import java.util.Map;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.items.INBTItem;
import com.futurecraft.mod.magick.lib.MagickLib;

public class ItemRunicSword extends ItemSword{

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
				//nope
				return false;
			}
			
		 return true;
	    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,List list, boolean bool) {
		if(stack.stackTagCompound != null) {
		list.add(ChatHelper.acf("A sword carved from the ancient runes found in fossils.",EnumChatFormatting.LIGHT_PURPLE));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("A sword carved from the ancient runes found in fossils.",EnumChatFormatting.LIGHT_PURPLE));
		}
	}
	
}
