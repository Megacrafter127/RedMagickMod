package com.matt.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class FlintSteelRecipe extends ShapedRecipes {

	public FlintSteelRecipe(ItemStack result,ItemStack material1,ItemStack material2) {
		super(2, 2, new ItemStack[]{material1,null,null,material2}, result);
	}

}
