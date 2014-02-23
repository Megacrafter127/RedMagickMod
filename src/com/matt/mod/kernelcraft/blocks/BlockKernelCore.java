package com.matt.mod.kernelcraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

public class BlockKernelCore extends Block implements ITileEntityProvider {

	public BlockKernelCore(int par1) {
		super(par1,Material.dragonEgg);
		setBlockUnbreakable();
		setTextureName(KernelCraftCore.toTextureName("kernelcore"));
		setUnlocalizedName("Kernel Core");
	}
	
	@Override
	public int getLightValue(IBlockAccess access,int x,int y,int z) {
		return 15;
	}
	
	@Override
	public TileEntityKernelCore createNewTileEntity(World w) {
		return new TileEntityKernelCore();
	}
	
	@Override
	public boolean canPlaceBlockAt(World w,int x,int y,int z) {
		return w.getBlockId(x, y-1, z)==KernelCraftCore.Module.blockID;
	}
	
	@Override
	public int idDropped(int x,Random r,int z) {
		return 0;
	}
	
	@Override
	public int idPicked(World w,int x,int y,int z) {
		return 0;
	}
}
