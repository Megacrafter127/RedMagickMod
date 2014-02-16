package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.block.ITileEntityProvider;

import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelStorage;

public class BlockKernelStorage extends ColumnBlock implements ITileEntityProvider {
	public BlockKernelStorage(int par1) {
		super(par1, Material.iron, KernelCraftCore.toTextureName("storagetop"), KernelCraftCore.toTextureName("storagebottom"), KernelCraftCore.toTextureName("storageside"), "Kernel Storage");
	}
	
	public TileEntityKernelStorage createNewTileEntity(World w) {
		return new TileEntityKernelStorage(w);
	}
	@Override
	public void onBlockAdded(World w,int x,int y,int z) {
		super.onBlockAdded(w, x, y, z);
		w.setBlockTileEntity(x, y, z, createNewTileEntity(w));
	}
}
