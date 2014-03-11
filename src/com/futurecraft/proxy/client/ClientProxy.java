package com.futurecraft.proxy.client;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.gui.LoreBookGui;
import com.futurecraft.mod.ModHelper;
import com.futurecraft.mod.magick.multiblock.TileEntityAltar;
import com.futurecraft.mod.magick.multiblock.TileEntityAltarRender;
import com.futurecraft.proxy.CommonProxy;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {
                // This is for rendering entities and so forth later on
        }
        //DERP : HOW DID I MESS THIS UP!?
        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
        {
        	if(player.inventory.getCurrentItem().itemID == ModHelper.loreBook.itemID && ID == 0) {
        		return new LoreBookGui("Welcome to the /n beautiful world of /n futurecraft!");
        	}
        	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        	if (tileEntity != null)
        	{
        	switch(ID)
        	{
        		case 0: /* your GUIs go here */
        			
        	}
        	}
        	return null;
        } 
        
        public static void registerTESR(){
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TileEntityAltarRender());
        }
}