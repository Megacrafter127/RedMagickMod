package com.futurecraft.mod.magick.alchemy;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.lib.MagickLib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemMoonDust extends Item{

	public ItemMoonDust() {
		super(MagickLib.getIdFor("Moon Dust",5003));
		setTextureName(MagickLib.toTextureName("dustmoon"));
		
		LanguageRegistry.addName(this,"Moon Dust");
	}
	@Override
	
	public void addInformation(ItemStack stack,
	          EntityPlayer player,
	          List list,
	          boolean par4) {
		if(stack.stackTagCompound != null) {
			list.add(ChatHelper.acf("Dust from the moon", EnumChatFormatting.DARK_GRAY));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("Dust from the moon", EnumChatFormatting.DARK_GRAY));
		}
		
	}
}
