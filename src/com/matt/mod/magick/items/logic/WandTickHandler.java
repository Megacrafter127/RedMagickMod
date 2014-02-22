package com.matt.mod.magick.items.logic;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class WandTickHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		System.out.println("Tick ended!");
		for(Object o : tickData) {
			System.out.println("Tick data report : ");
			System.out.println(o.toString());
		}

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Logic - Wand saving and loading";
	}

}
