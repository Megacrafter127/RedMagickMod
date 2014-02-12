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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.rare;
	}
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
}

