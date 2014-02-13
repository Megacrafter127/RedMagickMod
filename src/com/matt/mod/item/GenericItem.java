package com.matt.mod.item;

import java.awt.List;

import com.matt.lib.Ref;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GenericItem extends Item {
	//DERP
	static int idI = 590;
	static String unlocName = "netheriumIngot";
	static CreativeTabs tab = CreativeTabs.tabMisc;
	static String readName = "Netherium Ingot";
	static ItemIngot instance;
	static String textureName = "null";
	
	public GenericItem(int id, String unlocalizedName, CreativeTabs creativetab,String textureNameC) {
		super(id);
		idI = id;
		unlocName = unlocalizedName;
		tab = creativetab;
		textureName = Ref.NAME + ":" + textureNameC;
		setUnlocalizedName(unlocName);
		setCreativeTab(tab);
		setTextureName(textureName);
	}
	public void addInformation(ItemStack par1ItemStack, List par2List)
	{
	         par2List.add("Lore Line #1");
	         par2List.add("Lore Line #2");
	         // etc ...
	}
	
}
