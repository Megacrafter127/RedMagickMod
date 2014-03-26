package com.futurecraft.mod.magick.multiblock;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.futurecraft.mod.magick.lib.IWandAble;
import com.futurecraft.mod.magick.lib.MagickLib;

public class BlockAltar extends Block implements ITileEntityProvider, IWandAble {
	public BlockAltar() {
		super(MagickLib.getIdFor("ALTARCORE",810),Material.iron);
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
