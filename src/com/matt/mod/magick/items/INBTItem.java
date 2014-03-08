package com.matt.mod.magick.items;

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

}
