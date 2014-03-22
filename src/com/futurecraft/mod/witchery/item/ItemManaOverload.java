package com.futurecraft.mod.witchery.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.futurecraft.mod.magick.alchemy.IManaContainer;
import com.futurecraft.mod.magick.lib.MagickLib;

public class ItemManaOverload extends Item implements IManaContainer {
	public static final int load=50;

	public ItemManaOverload(int par1) {
		super(par1);
		super.setUnlocalizedName("ManaOverload");
		super.setTextureName(MagickLib.toTextureName("manaoverload.png"));
		super.setMaxStackSize(1);
	}

	@Override
	public int getManaTypeCount(ItemStack stack) {
		return 1;
	}

	@Override
	public int getMana(ItemStack stack, int type) {
		return load;
	}

	@Override
	public int useMana(ItemStack stack, int type, int amount) {
		return amount>load?load:amount;
	}

}
