package com.matt.mod.tweaks;

import net.minecraft.block.Block;

import com.matt.generic.helpers.IFutureCraftPlugin;

public class FutureCraftTweaks implements IFutureCraftPlugin {
	
	public static FutureCraftTweaks instance = new FutureCraftTweaks();
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FutureCraft Tweaks";
	}

	@Override
	public void register() {
		Block.bedrock.setHardness(99.5F);
	}

}
