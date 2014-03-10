package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface INBTItem {
	/**
	 * Default method for writing an itemstack to nbt.
	 * @param stack
	 */
	void writeToNbt(ItemStack stack);
	/**
	 * Default method for reading a stack from nbt.
	 * @param stack
	 */
	void readFromNbt(ItemStack stack);
	
	/**
	 * Default callback for adding item tooltips
	 * @param stack
	 * @param player
	 * @param list
	 * @param bool
	 */
	public void addInformation(ItemStack stack, EntityPlayer player,List list, boolean bool);
}
