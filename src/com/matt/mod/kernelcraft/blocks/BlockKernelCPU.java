package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.block.ITileEntityProvider;

import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCPU;

public class BlockKernelCPU extends ColumnBlock implements ITileEntityProvider {
	public BlockKernelCPU(int par1) {
		super(par1, Material.iron, KernelCraftCore.toTextureName("cputop"), KernelCraftCore.toTextureName("cpubottom"), KernelCraftCore.toTextureName("cpuside"), "Kernel CPU");
	}
	
	public TileEntityKernelCPU createNewTileEntity(World w) {
		return new TileEntityKernelCPU(w);
	}
	@Override
	public void onBlockAdded(World w,int x,int y,int z) {
		super.onBlockAdded(w, x, y, z);
		w.setBlockTileEntity(x, y, z, createNewTileEntity(w));
	}
}
