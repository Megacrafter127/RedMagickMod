package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.lib.Ref;
import com.matt.mod.blocks.tileentity.TileEntityDimensionalInfuser;

public class BlockDimensionalTransmutator extends Block implements ITileEntityProvider {
	public BlockDimensionalTransmutator(int par1) {
		super(par1, Material.iron);
		setTextureName(Ref.NAME.toLowerCase() + ":diminfuser");
		
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
		if(world.getBlockTileEntity(x, y, z) instanceof TileEntityDimensionalInfuser) {
			TileEntityDimensionalInfuser a = (TileEntityDimensionalInfuser)world.getBlockTileEntity(x, y, z);
			a.run(world, player, x, y, z);
		}
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityDimensionalInfuser();
	}

}
