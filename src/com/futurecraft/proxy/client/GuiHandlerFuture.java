package com.futurecraft.proxy.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.mod.magick.infusion.ContainerInfuser;
import com.futurecraft.mod.magick.infusion.GuiInfuser;
import com.futurecraft.mod.magick.infusion.TileInfuser;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerFuture implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		 TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
         if(tileEntity instanceof TileInfuser){
                 return new ContainerInfuser(player, (TileInfuser)tileEntity);
         }
         return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		 TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
         if(tileEntity instanceof TileInfuser){
                 return new GuiInfuser(new ContainerInfuser(player, (TileInfuser)tileEntity));
         }
         return null;
	}

}
