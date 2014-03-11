package com.futurecraft.mod.kernelcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.futurecraft.mod.blocks.ColumnBlock;
import com.futurecraft.mod.kernelcraft.KernelCraftCore;
import com.futurecraft.mod.kernelcraft.tileentities.TileEntityKernelModule;

public class BlockKernelModule extends ColumnBlock implements ITileEntityProvider {

	public BlockKernelModule(int id) {
		super(id, Material.iron,KernelCraftCore.toTextureName("moduletop"),KernelCraftCore.toTextureName("modulebottom"),KernelCraftCore.toTextureName("moduleside"),"Kernel Module");
	}
	
	public TileEntityKernelModule createNewTileEntity(World w) {
		return new TileEntityKernelModule();
	}
}