package com.futurecraft.mod.magick.alchemy;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.lib.MagickLib;

public class ItemAlchemicalFuel extends Item{
	public ItemAlchemicalFuel() {
		super(MagickLib.getIdFor("Alchemical Fuel",5001));
		setTextureName(MagickLib.toTextureName("fuelalch"));
	}
	@Override 
	public void addInformation(ItemStack stack,
	          EntityPlayer player,
	          List list,
	          boolean par4) {
		if(stack.stackTagCompound != null) {
			list.add(ChatHelper.acf("Fuel, Coal, Whatever. It's cool, and magical!",EnumChatFormatting.DARK_PURPLE));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("Fuel, Coal, Whatever. It's cool, and magical!",EnumChatFormatting.DARK_PURPLE));
		}
	}
}
