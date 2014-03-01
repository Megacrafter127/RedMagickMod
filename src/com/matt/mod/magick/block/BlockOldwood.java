package com.matt.mod.magick.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import com.matt.FutureCraft;
import com.matt.mod.magick.lib.MagickLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOldwood extends Block {
	Icon top;
	Icon norm;
	public BlockOldwood() {
	super(getRecommendedID(),Material.wood);

	}

	private static int getRecommendedID() {
		return FutureCraft.blockOldwoodID;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    { 
		norm = par1IconRegister.registerIcon(MagickLib.toTextureName("oldwood"));
		top = par1IconRegister.registerIcon(MagickLib.toTextureName("oldwoodtop"));
    }
	  @SideOnly(Side.CLIENT)

	    /**
	     * The icon for the side of the block.
	     */
	    protected Icon getSideIcon(int par1)
	    {
	        return this.norm;
	    }

	    @SideOnly(Side.CLIENT)

	    /**
	     * The icon for the tops and bottoms of the block.
	     */
	    protected Icon getEndIcon(int par1)
	    {
	        return this.top;
	    }

}
