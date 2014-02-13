package com.matt.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.heneric.helpers.IFutureCraft;

public class BlockEnchantmentAltarCore extends Block implements
		ITileEntityProvider, IFutureCraft {

	public BlockEnchantmentAltarCore() {
		super(FutureCraft.altarCoreID, Material.dragonEgg);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityAltar();
	}


}
