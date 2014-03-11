package com.futurecraft.mod.kernelcraft;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

import com.futurecraft.mod.kernelcraft.tileentities.TileEntityKernelCore;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
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
			if(FMLCommonHandler.instance().getEffectiveSide()==Side.SERVER) {
				w=FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dim);
			}
			else {
				w=Minecraft.getMinecraft().theWorld;
			}
			if(packet.channel.equals("KernelCoreTaskUpdate")) {
				updateTasks(w,x,y,z,nbt);
			}
			else if(packet.channel.equals("KernelCoreEffectUpdate")) {
				updateEffects(w,x,y,z,nbt);
			}
			else if(packet.channel.equals("KernelCoreUpdate")) {
				w.getBlockTileEntity(x, y, z).readFromNBT(nbt);
			}
			else return;
			if(w.isRemote) return;
			PacketDispatcher.sendPacketToAllInDimension(packet, dim);
		}
		catch(IOException ex) {
			System.err.println(ex.toString());
		}
		catch(NullPointerException ex) {	
			ex.printStackTrace(System.err);
		}
	}
	
	private void updateTasks(World w,int x,int y,int z,NBTTagCompound nbt) {
		try{
			((TileEntityKernelCore)w.getBlockTileEntity(x, y, z)).readTasksFromNBT(nbt);
			w.markBlockForUpdate(x, y, z);
		}
		catch(ClassCastException ex) {}
		catch(NullPointerException ex) {}
	}
	
	private void updateEffects(World w,int x,int y,int z,NBTTagCompound nbt) {
		try{
			((TileEntityKernelCore)w.getBlockTileEntity(x, y, z)).readEffectsFromNBT(nbt);
			w.markBlockForUpdate(x, y, z);
		}
		catch(ClassCastException ex) {}
		catch(NullPointerException ex) {}
	}
}
