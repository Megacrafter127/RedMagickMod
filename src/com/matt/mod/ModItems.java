package com.matt.mod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.item.ItemEnderium;
import com.matt.mod.item.ItemNetherium; 

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
public class ModItems {
	public static ItemNetherium neth = new ItemNetherium(FutureCraft.netheriumIngotId,"ingotNetherium", CreativeTabs.tabMisc, "netheriumingot");
	public static ItemEnderium endh = new ItemEnderium(FutureCraft.enderiumIngotId,"ingotEnderium", CreativeTabs.tabMisc, "enderiumingot");
	public static Item ingotIndium = new ItemEnderium(FutureCraft.ingotIndiumId,"ingotIndium", CreativeTabs.tabMisc, "indiumtingot").setTextureName(Ref.NAME.toLowerCase() +":indiumingot");
	public static Item ingotRoentgenium = new ItemEnderium(FutureCraft.ingotRoentgeniumId,"ingotRoentgenium", CreativeTabs.tabMisc, "roentgeniumingot").setTextureName(Ref.NAME.toLowerCase() +":roentgeniumingot");
	public static void registerAllItems() {
		GameRegistry.registerItem(neth, "ingotNetherium");
		LanguageRegistry.addName(neth, "Netherium Ingot");
		GameRegistry.registerItem(endh, "ingotEnderium");
		LanguageRegistry.addName(endh, "Enderium Ingot");
		GameRegistry.registerItem(ingotIndium, "ingotIndium");
		LanguageRegistry.addName(ingotIndium, "Indium Ingot");
		GameRegistry.registerItem(ingotIndium, "ingotRoentgenium");
		LanguageRegistry.addName(ingotRoentgenium, "Roentgenium Ingot");
		neth.setCreativeTab(Ref.getRecommendedTab("block"));
		endh.setCreativeTab(Ref.getRecommendedTab("block"));
		ingotIndium.setCreativeTab(Ref.getRecommendedTab("block"));
		ingotRoentgenium.setCreativeTab(Ref.getRecommendedTab("block"));
	}

}
			