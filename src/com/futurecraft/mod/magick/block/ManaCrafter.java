package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;

public class ManaCrafter extends Block implements ITileEntityProvider {

	public ManaCrafter() {
		super(FutureCraft.manaBlockCrafter,Material.wood);
	}
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	  return false;
	    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
}
