package com.matt.mod.magick.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.mod.magick.lib.IWandAble;

public class BlockAltar extends Block implements ITileEntityProvider, IWandAble {
	public BlockAltar() {
		super(FutureCraft.altarCoreID,Material.iron);
	}
	@Override
	public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z) {
		

	}

	@Override
	public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y,
			int z) {
		// TODO Auto-generated method stub

	}
@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityAltar();
	}
	  @Override
	    public boolean isOpaqueCube(){
	        return false;
	    }

}
