package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.material.Material;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.blocks.ColumnBlock;

public class BlockKernelMainExpander extends ColumnBlock {

	public BlockKernelMainExpander(int id,String top,String bot,String side,String name) {
		super(id, Material.iron,top,bot,side,name);
	}

}
