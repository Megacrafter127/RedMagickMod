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
	setTextureName(MagickLib.toTextureName("oldwood"));
	}

	private static int getRecommendedID() {
		return FutureCraft.blockOldwoodID;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    { 
		
    }
	

}
