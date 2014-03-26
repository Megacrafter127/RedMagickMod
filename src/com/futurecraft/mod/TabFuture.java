package com.futurecraft.mod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.MagickRecipes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFuture extends CreativeTabs {
	String str;
	public TabFuture(int i, String label, String type) {
		super(i,label);
		str = type;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
		
	if(str == "block") {
		return FutureCraft.bFutureStack;	
	} else if(str == "item") {
		return ModHelper.enderiumStack;
	
	}else if(str == "magick") {
		return  MagickRecipes.foscos;
	}else {
		return new ItemStack(Block.blockDiamond); }
		
	}
	 
	
	public String getTranslatedTabLabel(){
		if(str == "block") {
			return "FutureCraft Blocks";	
		} else if(str == "item") {
			return "FutureCraft Items";
		
		}else if(str == "magick") { 
			return "FutureCraft Magick";
		}else {
			return "Either mat or mega derped up somewhere";
		}
			
		
		}
	
} 

