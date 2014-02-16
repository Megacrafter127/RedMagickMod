package com.matt.mod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.matt.FutureCraft;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.swag.SwagHelper;

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
	} else if(str == "kernel") {
		return new ItemStack(KernelCraftCore.Kernel);
	}
		return new ItemStack(Block.blockDiamond);
	}
	 
	
	public String getTranslatedTabLabel(){
		if(str == "block") {
			return "FutureCraft Blocks";	
		} else if(str == "item") {
			return "FutureCraft Items";
		} else if(str == "kernel") 
			{
			return "Kernel Craft";
		}else {
			return "Either mat or mega derped up somewhere";
		}
		}
	
} 

