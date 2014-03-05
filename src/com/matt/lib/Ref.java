package com.matt.lib;

import com.matt.FutureCraft;

import net.minecraft.creativetab.CreativeTabs;

public class Ref {
public static final String ID = "FCraft";
public static final String NAME = "FutureCraft";
public static final String VERSION = "0.0.1";
public static final String ALPHA = "a0.0.1";
public static final String BUILD = "b884rev98";
public static final String BLOCKPREFIX = "FutureCraft.tile.";
public static final String ITEMPREFIX = ".FutureCraft.item.";
public static final String STRING_WITTY_COMMENT = "Press shift to see silly comment.";
/**
 * Gets the recommended futurecraft tab for type.
 * @author Matheus
 * @param type - block or item
 * @return return item or bloc tab
 */
public static CreativeTabs getRecommendedTab(String type) {
	if(type.toLowerCase() == "block") {
		return FutureCraft.tabFCraft;
	} else if(type.toLowerCase() == "item") {
		return FutureCraft.tabFCraftItems;
	}
	else{
		return CreativeTabs.tabMisc;
	}
}
public static String toItemName(String string) {
	// TODO Auto-generated method stub
	return Ref.ID + Ref.ITEMPREFIX + string.toLowerCase();
}
public static String toBlockName(String unlocalizedName) {
	// TODO Auto-generated method stub
	return BLOCKPREFIX + "." + unlocalizedName;
}
}
