package com.matt.mod.handlers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class FutureCraftRegistry {
static FutureCraftRegistry instance;
public static FutureCraftRegistry getInstance() {
	return instance;
}
public static void setCommonName(Object obj, String str) { 
	if(obj instanceof Block) {
		Block b = (Block)obj;
		b.setUnlocalizedName(str);
	} else if(obj instanceof Item) {
		Item i = (Item)obj;
		i.setUnlocalizedName(str);
		
	}
}
public static void setLocalizedName(String loc, Object obj, String str) {
	if(obj instanceof Block) {
		Block b = (Block)obj;
		b.setUnlocalizedName(str);
		LanguageRegistry.instance().addNameForObject(obj, loc, str);
	} else if(obj instanceof Item) {
		Item i = (Item)obj;
		i.setUnlocalizedName(str);
		LanguageRegistry.instance().addNameForObject(obj, loc, str);
	}
}
}
