package com.matt.mod.swag.block;



import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.mod.blocks.ColumnBlock;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelIOFace;

public class SwagDecoBlock extends ColumnBlock implements ITileEntityProvider {
	public SwagDecoBlock(int par1) {
		super(par1, Material.iron, KernelCraftCore.toTextureName("iofacetop"), KernelCraftCore.toTextureName("iofacebottom"), KernelCraftCore.toTextureName("iofaceside"), "Kernel IOFace");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
