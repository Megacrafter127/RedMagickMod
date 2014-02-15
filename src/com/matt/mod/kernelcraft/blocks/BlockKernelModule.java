package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.kernelcraft.KernelCraftCore;

public class BlockKernelModule extends Block {

	public BlockKernelModule() {
		super(FutureCraft.config.getBlock("kernelmodule", 901).getInt(), Material.iron);
		setTextureName(Ref.NAME.toLowerCase() + ":kernelModule");
		setUnlocalizedName("Kernel Module");
	}
	
}
