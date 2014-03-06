package com.matt.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.matt.mod.generic.helpers.ChatHelper;
import com.matt.mod.magick.lib.MagickLib;

public class BlockManaBomb extends Block{
	public BlockManaBomb() {
		super(MagickLib.getIdFor("Mana Bomb", 805), Material.tnt);
		setCreativeTab(CreativeTabs.tabMisc);
	
	}
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		
		if( par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			
				par1World.createExplosion(null, par2,par3,par4,500, true);
				par1World.setBlockToAir(par2,par3,par4);
			
		}
    }
}
