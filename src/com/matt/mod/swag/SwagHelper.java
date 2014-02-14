package com.matt.mod.swag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.matt.mod.handlers.FutureCraftRegistry;
import com.matt.mod.swag.block.SwagBlock;
import com.matt.mod.swag.items.ItemSwaggishWand;

import cpw.mods.fml.common.registry.GameRegistry;

public class SwagHelper {
public static final Item swaggishWand = new ItemSwaggishWand("swaggishwand");
public static final Block blockMagicalBlock = new SwagBlock("magicalwall");
public static void register() {
	GameRegistry.registerBlock(blockMagicalBlock,"magicalWall");
	GameRegistry.registerItem(swaggishWand, "swaggishWand");
	FutureCraftRegistry.setLocalizedName("en_US", blockMagicalBlock, "Magical Wall");
	FutureCraftRegistry.setLocalizedName("en_US", swaggishWand, "Swaggish Wand");
}
}
