package com.matt.mod.swag.lib;

import com.matt.FutureCraft;

public class SwagLib {
	public static int getIdFor(String str) {
		if(str != null) {
			return FutureCraft.config.get("swag", str, false).getInt();
		}
		return 0;
	}
}
