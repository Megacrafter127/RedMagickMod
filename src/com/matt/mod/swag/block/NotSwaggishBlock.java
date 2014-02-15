package com.matt.mod.swag.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.matt.FutureCraft;
import com.matt.mod.swag.lib.SwagLib;

public class NotSwaggishBlock extends Block {

	public NotSwaggishBlock(String str) {
		super(SwagLib.getIdFor(str, FutureCraft.swag_default_id), Material.rock);
		// TODO Auto-generated constructor stub
	}

}
