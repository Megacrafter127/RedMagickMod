package com.futurecraft.mod.blocks;

import net.minecraft.block.Block;

import com.futurecraft.lib.Ref;
import com.futurecraft.mod.generic.helpers.BlockProperties;

public class GenericBlock extends Block {

	public GenericBlock(BlockProperties p) {
		super(p.getId(),p.getMaterial());
		setUnlocalizedName(p.getName());
		setTextureName(p.getTexture());
		this.setCreativeTab(Ref.getRecommendedTab("block"));

	}
	
}