package com.futurecraft.mod.magick.infusion;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.futurecraft.mod.magick.runic.ItemRune;

public class RecipeRunicInfusion {
	ItemStack output;
	Object input;
	
	ItemRune rune;

	public RecipeRunicInfusion(ItemStack output, Object input, ItemRune rune) {
		this.output = output;
		this.input = input;
		this.rune = rune;
	}

	public boolean matches(ItemStack stack) {
		if(input instanceof ItemStack)
			return stack.isItemEqual((ItemStack) input);

		String oredict = OreDictionary.getOreName(OreDictionary.getOreID(stack));
		return oredict.equals(input);
	}

	public Object getInput() {
		return input;
	}

	public ItemStack getOutput() {
		return output;
	}

	public ItemRune getRuneToUse() {
		return rune;
	}
}
