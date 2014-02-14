package com.matt.mod.swag.items;

import com.matt.lib.Ref;
import com.matt.mod.swag.lib.SwagLib;

import net.minecraft.item.Item;

public class ItemSwaggishWand extends Item{

	public ItemSwaggishWand(int i, String str) {
		super(i);
		setTextureName(Ref.NAME.toLowerCase() + ":" + str);
		setMaxStackSize(1);
	}

}
