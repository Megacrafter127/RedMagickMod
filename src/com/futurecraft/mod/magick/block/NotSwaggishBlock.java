package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.lib.MagickLib;

public class NotSwaggishBlock extends Block {

	public NotSwaggishBlock(String str) {
		super(MagickLib.getIdFor(str, FutureCraft.swag_default_id), Material.rock);
		// TODO Auto-generated constructor stub
	}

}
