package com.matt.mod.kernelcraft;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class KernelCoreUpdatePacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player player) {
		if(packet.channel.equals("KernelCoreUpdate")) {
			DataInputStream in=new DataInputStream(new ByteArrayInputStream(packet.data));
			try{
				int x=in.readInt();
				int y=in.readInt();
				int z=in.readInt();
				byte[] b=new byte[in.readInt()];
				int h=0;
				while(h<b.length) {
					h+=in.read(b,h,b.length-h);
				}
				NBTTagCompound nbt=CompressedStreamTools.decompress(b);
				World w=MinecraftServer.getServer().getEntityWorld();
				w.getBlockTileEntity(x, y, z).readFromNBT(nbt);
				w.markBlockForUpdate(x, y, z);
			}
			catch(IOException ex) {
				System.err.println(ex);
			}
			catch(NullPointerException ex) {
				ex.printStackTrace(System.err);
			}
		}

	}

}
