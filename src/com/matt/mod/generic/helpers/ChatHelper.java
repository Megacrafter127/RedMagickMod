package com.matt.mod.generic.helpers;

import net.minecraft.util.EnumChatFormatting;
/**
 * 
 * @author Megacrafter127
 *
 */
public class ChatHelper {
	/**
	 * Applies the given formats to the string, resetting it at the string's end.
	 * afc stands for apply-chat-formattings.
	 * @param s - the string to apply the formats to
	 * @param formats - the formats to apply on the string
	 * @return the formatted string
	 */
	public static String acf(String s,EnumChatFormatting... formats) {
		String ret="";
		for(EnumChatFormatting f:formats) {
			ret+=f;
		}
		return ret+s+EnumChatFormatting.RESET;
	} 
}
