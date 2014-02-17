package com.matt.mod.swag.infusion;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipe {
	Block[] blocksFor;
	Item[] resultFor;
public InfusionRecipe(Block[] blocks, Item[] results) {
	if(blocks != null && results != null) {
	blocksFor = blocks;
	resultFor = results;
	}
}
public ItemStack[] getResults() {
	ItemStack[] stack = new ItemStack[5];
	for(Item i : resultFor) {
		for(int j = 0; j <= resultFor.length; j++) {
			stack[j] = new ItemStack(i);
		}
	}
	return stack;
}

}
