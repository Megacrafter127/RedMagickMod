package com.futurecraft.mod.magick.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.lib.IWandAble;

public class BlockEnhancer extends Block implements ITileEntityProvider,
		IWandAble {
	public BlockEnhancer() {
		super(FutureCraft.blockEnhancerId, Material.iron);
	}
	@Override
	public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y,
			int z) {
		// TODO Auto-generated method stub

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
