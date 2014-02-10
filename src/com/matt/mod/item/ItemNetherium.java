/**
 * 
 */
package com.matt.mod.item;

/**
 * @author Matheus
 *
 */

import com.matt.lib.Ref;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
/**
 * @author Matheus
 * The Netherium ( ingot ) item
 */
public class ItemNetherium extends Item {
	
	static int idI = 590;
	static String unlocName = "netheriumIngot";
	static CreativeTabs tab = CreativeTabs.tabMisc;
	static String readName = "Netherium Ingot";
	static ItemNetherium instance;
	static String textureName = "null";
	/**
	 * @param id The item id
	 * @param unlocalizedName The item's unlocalized name
	 * @param creativetab The Item's creative tab
	 * @param textureNameC The item's texture name ( will be concatenated with Ref.Name )
	 */
	public ItemNetherium(int id, String unlocalizedName, CreativeTabs creativetab,String textureNameC) {
		super(id);
		idI = id;
		unlocName = unlocalizedName;
		tab = creativetab;
		textureName = Ref.NAME + ":" + textureNameC;
		setUnlocalizedName(unlocName);
		setCreativeTab(tab);
		setTextureName(textureName);
	}
	
}

