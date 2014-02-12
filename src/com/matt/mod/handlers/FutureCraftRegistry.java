package com.matt.mod.handlers;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class FutureCraftRegistry {
static FutureCraftRegistry instance;
// Hashmap!
static HashMap<Object,String> registryMapToR=new HashMap<Object,String>();
static HashMap<String,Object> registeredMap=new HashMap<String,Object>();
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
/**
 *  FutureCraft's way of setting names!
 *  @author Matheus
 *  @see LanguageRegistry.addName();
 * @param loc - The localization. For american english, use "en_US"
 * @param obj - The object you want to name. Either an block or item.
 * @param str - The name you want to add to the object
 */
public static void setLocalizedName(String loc, Object obj, String str) {
	if(obj instanceof Block) {	
		Block b = (Block)obj;
		//b.setUnlocalizedName(str2);
		LanguageRegistry.instance().addNameForObject(obj, loc, str);
		registeredMap.put(str, obj);
	} else if(obj instanceof Item) {
		Item i = (Item)obj;
		//i.setUnlocalizedName(str2);
		LanguageRegistry.instance().addNameForObject(obj, loc, str);
		registeredMap.put(str, obj);
	}
}
/**
 * Adds an object to registering queue
 * @param obj
 * @param str
 */
public static void addNameToRegisterQueue(Object obj, String str) {
	registryMapToR.put(obj, str);
}
public static void registerFromQueue(String key, String name, String loc) {
	Object obj = registryMapToR.get(key);
	setLocalizedName(loc,obj,name);
}
}
