package com.matt.mod.magick.lib;

import com.matt.FutureCraft;
import com.matt.lib.Ref;

public class MagickLib {
	public static int getIdFor(String str, int defaultid) {
		if(str != null) {
			FutureCraft.config.load();
			int i = FutureCraft.config.getBlock(str, defaultid).getInt();
			FutureCraft.config.save();
			return i;
		
		}
		return 0;
	}
	public static String toTextureName(String name) {
		return Ref.NAME.toLowerCase()+":"+name;
	}
}
