package com.matt.mod.magick.tick;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.matt.mod.magick.ArmorHelper;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ArmorTickHandler implements ITickHandler {

	public ArmorTickHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
			onPlayerTick(Minecraft.getMinecraft());
		

	}

	private void onPlayerTick(Minecraft minecraft) {
		System.out.println("Player Tick on " +  getLabel());
		EntityPlayer player = minecraft.thePlayer;
		ItemStack helm = player.getCurrentArmor(0);
		ItemStack chest = player.getCurrentArmor(1);
		ItemStack legs = player.getCurrentArmor(2);
		ItemStack boots = player.getCurrentArmor(3);
		if(helm != null && helm.itemID == ArmorHelper.manaHelm.itemID) {
			//We've got a mana armor!!
			System.out.println("Got mana helmet in " + player.getDisplayName());
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
		return "com.matt.magick.FutureCraftMagick.tickHandlers.Armor";
	}

}
