package com.futurecraft.mod.magick;

import net.minecraft.item.Item;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;
import com.futurecraft.mod.magick.armor.ItemArmorMana;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArmorHelper {
	public static final Item manaHelm = new ItemArmorMana(FutureCraft.armor_1,0,0).setUnlocalizedName(Ref.ID.toLowerCase() + ".armor.manaHelmet");;
	public static final Item manaChest = new ItemArmorMana(FutureCraft.armor_2,0,1).setUnlocalizedName(Ref.ID.toLowerCase() + ".armor.manaChestplate");;
	public static final Item manaLegs = new ItemArmorMana(FutureCraft.armor_3,0,2).setUnlocalizedName(Ref.ID.toLowerCase() + ".armor.manaLeggins");;
	public static final Item manaBoots = new ItemArmorMana(FutureCraft.armor_4,0,3).setUnlocalizedName(Ref.ID.toLowerCase() + ".armor.manaBoots");
public static void register()
{
	GameRegistry.registerItem(manaHelm,Ref.ID.toLowerCase() + ".armor.manaHelmet");
	GameRegistry.registerItem(manaChest,Ref.ID.toLowerCase() + ".armor.manaChestplate");
	GameRegistry.registerItem(manaLegs,Ref.ID.toLowerCase() + ".armor.manaLeggins");
	GameRegistry.registerItem(manaBoots,Ref.ID.toLowerCase() + ".armor.manaBoots");
	LanguageRegistry.addName(manaHelm,"Mana Helmet");
	LanguageRegistry.addName(manaChest,"Mana Chestplate");
	LanguageRegistry.addName(manaLegs,"Mana Leggings");
	LanguageRegistry.addName(manaBoots,"Mana Boots");
	
}
}
