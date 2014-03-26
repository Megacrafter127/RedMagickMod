package com.futurecraft.mod.magick.lib;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;

public class MagickLib {
	/**
	 * 
	 * @param str - block or item's name
	 * @param defaultid - the default id
	 * @return An id, present or generated, in the FutureCraft cfg file.
	 */
	public static int getIdFor(String str, int defaultid) {
		if(str != null) {
			FutureCraft.config.load();
			int i = FutureCraft.config.get("Magick",str, defaultid).getInt();
			FutureCraft.config.save();
			return i;
		
		}
		return 0;
	}
	/**
	 * 
	 * @param name
	 * @return a concatenated string with the mod's name and a <bold>':'</bold> signal.
	 */
	public static String toTextureName(String name) {
		return Ref.NAME.toLowerCase()+":"+name;
	}
}
