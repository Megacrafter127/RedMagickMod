package com.matt.generic.helpers;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public interface IFutureCraftPlugin {

	public String getName();

	public void register();
	
	public void registerCommands(FMLServerStartingEvent e);
}
