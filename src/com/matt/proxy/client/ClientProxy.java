package com.matt.proxy.client;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.matt.gui.LoreBookGui;
import com.matt.mod.ModHelper;
import com.matt.proxy.CommonProxy;

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
        		return new LoreBookGui();
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
}