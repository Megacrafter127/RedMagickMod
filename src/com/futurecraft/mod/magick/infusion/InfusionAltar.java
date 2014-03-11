package com.futurecraft.mod.magick.infusion;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.lib.IWandAble;

public class InfusionAltar extends Block implements IWandAble, ITileEntityProvider {

	public InfusionAltar() {
		super(FutureCraft.altarCoreID,Material.iron);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
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
	

}
