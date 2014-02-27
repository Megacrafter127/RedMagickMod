package com.matt.mod.magick.items;

import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.lib.Ref;

public class ItemManaDust extends Item {
 public static final String name = "Mageia Foscos";
public ItemManaDust() {
	super(FutureCraft.manaDustID);
	setTextureName(Ref.NAME.toLowerCase() + ":mageiafoscos");
}
}
