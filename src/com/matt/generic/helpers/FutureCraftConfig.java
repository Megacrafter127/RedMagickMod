package com.matt.generic.helpers;

import net.minecraftforge.common.Configuration;

public class FutureCraftConfig {
	public enum classification {
		SWAG,
		KERNEL,
		BLOCK,
		ITEM
	}
public static Configuration cfg;
private static boolean hasCfg;
public static void instanciate() {
	if(cfg != null) {
		hasCfg = true;
	}
}
public static int get(Configuration c, int defId, String category, String key) {
	c.load();
	if(c.get(category,key,defId).getInt() != 0) {
		return c.get(category,key,defId).getInt();
	}
	return defId;
}
}