package com.matt.mod.handlers;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

import com.matt.FutureCraft;
import com.matt.mod.ModHelper;
import com.matt.mod.item.GenericItem;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	public ServerTickHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER))) {
			playerTick((EntityPlayer)tickData[0]);
		}
	}

	private void playerTick(EntityPlayer entityPlayer) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
