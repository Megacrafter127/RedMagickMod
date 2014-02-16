package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.tileentity.TileEntityBeacon;

public class TileEntityKernelCore extends TileEntityBeacon {

	public TileEntityKernelCore() {
		super.setLevels(1);
	}
	@Override
	public void updateEntity() {
		try{
			getClass().getDeclaredField("isBeaconActive").setBoolean(this, true);
		}
		catch(NoSuchFieldException ex) {}
		catch(IllegalAccessException ex) {
			System.err.println(ex);
		}
		setLevels(1);
	}
	@Override
	public boolean canUpdate() {
		return true;
	}
}
