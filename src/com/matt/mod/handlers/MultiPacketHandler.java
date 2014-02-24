package com.matt.mod.handlers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class MultiPacketHandler implements IPacketHandler {
	private static final HashMap<String,IPacketHandler> pluginHandlers=new HashMap<String,IPacketHandler>();
	private static boolean addPacketHandler(String channel,IPacketHandler handler) {
		if(pluginHandlers.containsKey(channel)) return false;
		pluginHandlers.put(channel, handler);
		return true;
	}
	public static boolean[] addPacketHandler(IPacketHandler handler,String... channels) {
		boolean[] ret=new boolean[channels.length];
		for(int i=0;i<ret.length;i++) {
			ret[i]=addPacketHandler(channels[i],handler);
		}
		return ret;
	}

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		pluginHandlers.get(packet.channel).onPacketData(manager, packet, player);
	}

}
