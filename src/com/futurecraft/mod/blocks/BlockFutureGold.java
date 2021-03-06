package com.futurecraft.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.futurecraft.FutureCraft;
import com.futurecraft.lib.Ref;

public class BlockFutureGold extends Block {

	public BlockFutureGold(int par1, Material par2Material, String textureName) {
		super(par1, par2Material);
		setTextureName(Ref.NAME.toLowerCase() + ":goldfutureblock");
		setUnlocalizedName("goldenFutureBlock");
		this.setCreativeTab(Ref.getRecommendedTab("block"));
	}

}
