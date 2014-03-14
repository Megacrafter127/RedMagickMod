package com.futurecraft.mod.magick.alchemy;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.lib.MagickLib;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemSunDust extends Item {

	public ItemSunDust() {
		super(MagickLib.getIdFor("Sun Dust",5002));
		setTextureName(MagickLib.toTextureName("dustsun"));
		LanguageRegistry.addName(this,"Sun Dust");
	}
	@Override
	
	public void addInformation(ItemStack stack,
	          EntityPlayer player,
	          List list,
	          boolean par4) {
		if(stack.stackTagCompound != null) {
			list.add(ChatHelper.acf("Dust from the sun", EnumChatFormatting.GOLD));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("Dust from the sun", EnumChatFormatting.GOLD));
		}
		
	}

}
