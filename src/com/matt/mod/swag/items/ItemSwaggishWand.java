package com.matt.mod.swag.items;

import com.matt.lib.Ref;
import com.matt.mod.swag.lib.SwagLib;

import net.minecraft.item.Item;

public class ItemSwaggishWand extends Item{
	public enum tier {
		BASIC,
		NETHERIUM,
		ENDERIUM,
		DIENDER,
		MATRIX
	}
	public ItemSwaggishWand(int i, String str, tier t) {
		super(i);
		if(t.equals(tier.BASIC)) {
				setTextureName(Ref.NAME.toLowerCase() + ":" + str);
		setMaxStackSize(1);
		} else if(t.equals(tier.NETHERIUM)) {
			setTextureName(Ref.NAME.toLowerCase() + ":" + str + "t2");
			setMaxStackSize(1);
		} else if(t.equals(tier.ENDERIUM)) {
			setTextureName(Ref.NAME.toLowerCase() + ":" + str + "t3");
			setMaxStackSize(1);
		}
	}

}
