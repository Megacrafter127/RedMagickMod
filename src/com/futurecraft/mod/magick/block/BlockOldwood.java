package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.lib.MagickLib;

public class BlockOldwood extends Block {
	
	public BlockOldwood() {
	super(getRecommendedID(),Material.wood);
	setTextureName(MagickLib.toTextureName("oldwood"));
	setHardness(0.5F);
	}

	private static int getRecommendedID() {
		return FutureCraft.blockOldwoodID;
	}
	

	

}
