package com.matt.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class AxeRecipe extends ShapedRecipes {

	public AxeRecipe(ItemStack result,ItemStack material,ItemStack stick) {
		super(2, 3, new ItemStack[]{material,material,material,stick,null,stick}, result);
	}

}
