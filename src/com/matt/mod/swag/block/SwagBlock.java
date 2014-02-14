package com.matt.mod.swag.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.matt.lib.Ref;
import com.matt.mod.swag.lib.SwagLib;

public class SwagBlock extends Block {

	public SwagBlock(String str) {
		super(SwagLib.getIdFor(str), Material.sand);
		setTextureName(Ref.NAME.toLowerCase() + ":" + str);
	}
	

}
