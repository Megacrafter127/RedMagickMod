package com.futurecraft.mod.magick;

import com.futurecraft.generic.helpers.IFutureCraftPlugin;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class FutureCraftMagick implements IFutureCraftPlugin {

	public void register() {
		System.out.println("Registering FutureCraftMagick plugin!");
		MagickHelper.register();
	}

	@Override
	public String getName() {
		return "FutureCraft Magick";
	}

	@Override
	public void registerCommands(FMLServerStartingEvent e) {
	
	}

}
