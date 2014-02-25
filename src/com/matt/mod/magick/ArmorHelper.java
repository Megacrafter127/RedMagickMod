package com.matt.mod.magick;

import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.magick.armor.ItemArmorMana;

import cpw.mods.fml.common.registry.GameRegistry;

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
	
}
}
