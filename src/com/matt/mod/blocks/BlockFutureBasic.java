package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.matt.FutureCraft;
import com.matt.lib.Ref;

public class BlockFutureBasic extends Block {

	public BlockFutureBasic(int par1, Material par2Material, String textureName) {
		super(par1, par2Material);
		setTextureName(Ref.NAME.toLowerCase() + ":" + textureName);
		setUnlocalizedName("basicFutureBlock");
		this.setCreativeTab(Ref.getRecommendedTab("block"));
	}

}
