package com.futurecraft.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.lib.MagickLib;

public class BlockManaBomb extends Block{
	public BlockManaBomb() {
		super(MagickLib.getIdFor("Mana Bomb", 806), Material.tnt);
		setCreativeTab(MagickHelper.tabMagick);
	
	}
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		
		if( par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			
				par1World.createExplosion(null, par2,par3,par4,500, true);
				//par1World.spawnEntityInWorld(new MagicExplosion(par1World,null,par2,par3,par4,500));
				par1World.setBlockToAir(par2,par3,par4);
		}
    }
}
