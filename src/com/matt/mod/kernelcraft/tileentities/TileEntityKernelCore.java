package com.matt.mod.kernelcraft.tileentities;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntityBeacon;

public class TileEntityKernelCore extends TileEntityBeacon {
	static{
		TileEntityRenderer.instance.specialRendererMap.put(TileEntityKernelCore.class, TileEntityRenderer.instance.getSpecialRendererForClass(TileEntityBeacon.class));
	}

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
