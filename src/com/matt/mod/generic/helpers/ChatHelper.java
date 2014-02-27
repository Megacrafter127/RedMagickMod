package com.matt.mod.generic.helpers;

import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;
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
	/**
	 * Applied the given format to the string, resetting it at the end.
	 * Also applies the key down to see details of most tooltips.
	 * htt stands for hide-tool-tip.
	 * @param s - the string to apply the formats to
	 * @param key_id - the key to check for
	 * @param formats - the formats to apply
	 * @return the formatted string, or if key is not down, shift to see details in gray.
	 */
	public static String htt(String s,int key_id, EnumChatFormatting... formats) {
		if(Keyboard.isKeyDown(key_id)) {
		return acf(s,formats);
		}else{
			return acf("Press shift to see details", new EnumChatFormatting[]{EnumChatFormatting.GRAY});
		}
	}
}
