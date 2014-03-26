package com.futurecraft.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class HoeRecipe extends ShapedRecipes {

	public HoeRecipe(ItemStack result,ItemStack material, ItemStack stick) {
		super(2, 3, new ItemStack[]{material,material,null,stick,null,stick}, result);
	}

}
