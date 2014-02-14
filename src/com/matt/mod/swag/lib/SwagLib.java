package com.matt.mod.swag.lib;

import com.matt.FutureCraft;

public class SwagLib {
	public static int getIdFor(String str) {
		if(str != null) {
			System.out.println(FutureCraft.config.get("swag", str, str.length() + 700).getInt());
			return FutureCraft.config.get("swag", str, str.length() + 6).getInt();
		
		}
		return 0;
	}
}
