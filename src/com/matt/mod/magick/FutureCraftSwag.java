package com.matt.mod.magick;

import com.matt.generic.helpers.IFutureCraftPlugin;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class FutureCraftSwag implements IFutureCraftPlugin{

public void register() {
System.out.println("Registering FutureCraftMagick plugin!");
MagickHelper.register();
}
@Override
public String getName() {
	return "FutureCraft Magick";
}

@Override
public void registerCommands(FMLServerStartingEvent e) {}

}
