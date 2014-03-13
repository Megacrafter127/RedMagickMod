package com.futurecraft.mod.magick.infusion;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipe {
	Object[] input;
	ItemStack output;
	public InfusionRecipe(ItemStack newOut, Object... input) {
		output = newOut;
		this.input = input;
	}

}
