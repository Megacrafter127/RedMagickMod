package com.matt.mod.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.*;
import net.minecraft.util.Icon;

import com.matt.lib.Ref;
import com.matt.mod.blocks.tileentity.TileEntityDimensionalInfuser;

public class BlockDimensionalInfuser extends Block implements ITileEntityProvider {
	private Icon inactive;
	private Icon nether;
	private Icon end;
	
	public BlockDimensionalInfuser(int par1) {
		super(par1, Material.iron);
		setTextureName(Ref.NAME.toLowerCase() + ":diminfuser");
		setUnlocalizedName("Dimensional Infuser");
	}
	@Override
	public void registerIcons(IconRegister r) {
		super.registerIcons(r);
		inactive=r.registerIcon(Ref.NAME.toLowerCase() + ":diminfuser");
		nether=r.registerIcon(Ref.NAME.toLowerCase() + ":diminfusernether");
		end=r.registerIcon(Ref.NAME.toLowerCase() + ":diminfuserend");
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
	public Icon getBlockTexture(IBlockAccess a,int x,int y,int z,int side) {
		BiomeGenBase b=a.getBiomeGenForCoords(x, z);
		if(b instanceof BiomeGenHell) return nether;
		if(b instanceof BiomeGenEnd) return end;
		return inactive;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDimensionalInfuser();
	}

}
