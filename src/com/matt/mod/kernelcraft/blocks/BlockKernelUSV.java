package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.block.ITileEntityProvider;

import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelUSV;

public class BlockKernelUSV extends ColumnBlock implements ITileEntityProvider {
	public BlockKernelUSV(int par1) {
		super(par1, Material.iron, KernelCraftCore.toTextureName("iofacetop"), KernelCraftCore.toTextureName("iofacebottom"), KernelCraftCore.toTextureName("iofaceside"), "Kernel IOFace");
	}
	
	public TileEntityKernelUSV createNewTileEntity(World w) {
		return new TileEntityKernelUSV(w);
	}
}
