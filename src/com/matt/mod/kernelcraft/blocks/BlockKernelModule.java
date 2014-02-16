package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelModule;

public class BlockKernelModule extends ColumnBlock implements ITileEntityProvider {

	public BlockKernelModule(int id) {
		super(id, Material.iron,KernelCraftCore.toTextureName("kernelmoduletop"),KernelCraftCore.toTextureName("kernelmodulebottom"),KernelCraftCore.toTextureName("kernelmoduleside"),"Kernel Module");
	}
	
	public TileEntityKernelModule createNewTileEntity(World w) {
		return new TileEntityKernelModule(w);
	}
	@Override
	public void onBlockAdded(World w,int x,int y,int z) {
		super.onBlockAdded(w, x, y, z);
		w.setBlockTileEntity(x, y, z, createNewTileEntity(w));
	}
}
