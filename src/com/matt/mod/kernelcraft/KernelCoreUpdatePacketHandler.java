package com.matt.mod.kernelcraft;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class KernelCoreUpdatePacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player player) {
		DataInputStream in=new DataInputStream(new ByteArrayInputStream(packet.data));
		try{
			int dim=in.readInt();
			int x=in.readInt();
			int y=in.readInt();
			int z=in.readInt();
			byte[] b=new byte[in.readInt()];
			int h=0;
			while(h<b.length) {
				h+=in.read(b,h,b.length-h);
			}
			NBTTagCompound nbt=CompressedStreamTools.decompress(b);
			World w;
			w=FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
			try{
				w.getBlockTileEntity(x, y, z).readFromNBT(nbt);
				w.markBlockForUpdate(x, y, z);
			}
			catch(NullPointerException ex) {}
		}
		catch(IOException ex) {
			System.err.println(ex.toString());
		}
		catch(NullPointerException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
}
