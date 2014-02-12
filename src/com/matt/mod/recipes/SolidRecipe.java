package com.matt.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class SolidRecipe extends ShapedRecipes {
	private static ItemStack[] generateArray(int len,ItemStack filler) {
		ItemStack[] ret=new ItemStack[len];
		for(int i=0;i<len;i++) {
			ret[i]=filler;
		}
		return ret;
	}

	public SolidRecipe(ItemStack result, int width, int height, ItemStack material) {
		super(width, height, generateArray(width*height,material), result);
		// TODO Auto-generated constructor stub
	}

}
