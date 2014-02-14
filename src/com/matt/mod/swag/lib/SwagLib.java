package com.matt.mod.swag.lib;

import com.matt.FutureCraft;

public class SwagLib {
	public static int getIdFor(String str) {
		if(str != null) {
			System.out.println(FutureCraft.config.getBlock(str, str.length() + 700).getInt());
			return FutureCraft.config.getBlock(str, str.length() + 700).getInt();
		
		}
		return 0;
	}
}
