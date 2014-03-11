package com.futurecraft.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.futurecraft.mod.handlers.ServerTickHandler;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class CommonProxy implements IGuiHandler{

        // Client stuff
        public void registerRenderers() {
                // Nothing here as the server doesn't render graphics or entities!
        }
        public void registerServerTickHandler()
        {
        TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
        }
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player,
				World world, int x, int y, int z) {
			// TODO Auto-generated method stub
			return null;
		}
}