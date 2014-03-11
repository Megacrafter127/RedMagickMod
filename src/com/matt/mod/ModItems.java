package com.matt.mod;
import net.minecraft.creativetab.CreativeTabs;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.item.ItemEnderium;
import com.matt.mod.item.ItemNetherium; 

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
public class ModItems {
	public static ItemNetherium neth = new ItemNetherium(FutureCraft.netheriumIngotId,"ingotNetherium", CreativeTabs.tabMisc, "netheriumingot");
	public static ItemEnderium endh = new ItemEnderium(FutureCraft.enderiumIngotId,"ingotEnderium", CreativeTabs.tabMisc, "enderiumingot");
	public static void registerAllItems() {
		GameRegistry.registerItem(neth, "ingotNetherium");
		LanguageRegistry.addName(neth, "Netherium Ingot");
		GameRegistry.registerItem(endh, "ingotEnderium");
		LanguageRegistry.addName(endh, "Enderium Ingot");
		neth.setCreativeTab(Ref.getRecommendedTab("block"));
		endh.setCreativeTab(Ref.getRecommendedTab("block"));
	}

}
			