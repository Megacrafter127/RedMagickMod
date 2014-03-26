package com.futurecraft.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.futurecraft.mod.handlers.ServerTickHandler;
import com.futurecraft.mod.magick.MagickHelper;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class CommonProxy implements IGuiHandler{

        public class FutureFuelHandler implements IFuelHandler {
        	Class c;
		@Override
		public int getBurnTime(ItemStack fuel) {
		if(fuel.itemID == MagickHelper.alchemyFuel.itemID) {
			return 37 * MagickHelper.alchemyFuel.itemID;
		}
			return 0;
		}

	}
		// Client stuff
        public void registerRenderers() {
                // Nothing here as the server doesn't render graphics or entities!
        }
        public void registerHandlers()
        {
        TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
        GameRegistry.registerFuelHandler(new FutureFuelHandler());
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