package com.matt.lib;

import com.matt.FutureCraft;

import net.minecraft.creativetab.CreativeTabs;

public class Ref {
public static final String ID = "FCraft";
public static final String NAME = "FutureCraft";
public static final String VERSION = "0.0.1";
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
}
