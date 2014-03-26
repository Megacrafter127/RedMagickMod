package com.futurecraft.mod.magick.block;



import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.mod.blocks.ColumnBlock;
import com.futurecraft.mod.magick.lib.MagickLib;

public class SwagDecoBlock extends ColumnBlock implements ITileEntityProvider {
	public SwagDecoBlock(int par1) {
		super(par1, Material.iron, MagickLib.toTextureName("iofacetop"), MagickLib.toTextureName("iofacebottom"), MagickLib.toTextureName("iofaceside"), "Kernel IOFace");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
