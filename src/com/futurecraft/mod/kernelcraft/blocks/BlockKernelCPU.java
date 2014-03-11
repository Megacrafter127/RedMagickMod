package com.futurecraft.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.block.ITileEntityProvider;

import com.futurecraft.mod.blocks.ColumnBlock;
import com.futurecraft.mod.kernelcraft.KernelCraftCore;
import com.futurecraft.mod.kernelcraft.tileentities.TileEntityKernelCPU;

public class BlockKernelCPU extends ColumnBlock implements ITileEntityProvider {
	public BlockKernelCPU(int par1) {
		super(par1, Material.iron, KernelCraftCore.toTextureName("cputop"), KernelCraftCore.toTextureName("cpubottom"), KernelCraftCore.toTextureName("cpuside"), "Kernel CPU");
	}
	
	public TileEntityKernelCPU createNewTileEntity(World w) {
		return new TileEntityKernelCPU();
	}
}
