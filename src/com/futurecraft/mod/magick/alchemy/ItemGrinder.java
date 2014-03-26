package com.futurecraft.mod.magick.alchemy;

import java.util.List;

import com.futurecraft.mod.generic.helpers.ChatHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public class ItemGrinder extends Item {

	public ItemGrinder(int par1) {
		super(par1);
		
	}
	@Override 
	public void addInformation(ItemStack stack,
	          EntityPlayer player,
	          List list,
	          boolean par4) {
		if(stack.stackTagCompound != null) {
			list.add(ChatHelper.acf("It uses magic, and pulverises things.!",EnumChatFormatting.DARK_PURPLE));
			list.add(ChatHelper.acf("!.Single use.!",EnumChatFormatting.DARK_PURPLE));
		}else {
			stack.stackTagCompound = new NBTTagCompound();
			list.add(ChatHelper.acf("It uses magic, and pulverises things.!",EnumChatFormatting.DARK_PURPLE));
			list.add(ChatHelper.acf("!.Single use.!",EnumChatFormatting.DARK_PURPLE));
		}
	}
}
