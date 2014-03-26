package com.futurecraft.mod.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

public class SwordRecipe extends ShapedRecipes {

	public SwordRecipe(ItemStack material,
			ItemStack stick,ItemStack result) {
		super(3,3, new ItemStack[]{null,material,null,null,material,null,null,stick,null},result);
		// TODO Auto-generated constructor stub
	}
}

