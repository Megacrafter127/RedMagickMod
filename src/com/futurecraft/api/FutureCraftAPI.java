package com.futurecraft.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.futurecraft.FutureCraft;
import com.futurecraft.generic.helpers.IFutureCraftPlugin;
import com.futurecraft.lib.Ref;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class FutureCraftAPI implements IFutureCraftPlugin {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FCraftAPI";
	}

	@Override
	public void register() {
	FutureCraft.bookHelperInstance = BookHelper.instance;
	FutureCraft.apiInstance = new FutureCraftAPI();
	}
	public void registerArrayOfBlocks(Block[] b) {
		for(Block block : b) {
			if(b != null ) {
			GameRegistry.registerBlock(block,Ref.toBlockName(block.getUnlocalizedName()));
			}
		}
		
	}
	public void registerArrayOfItems(Item[] b) {
		for(Item block : b) {
			if(b != null ) {
			GameRegistry.registerItem(block,Ref.toItemName(block.getUnlocalizedName()));
			}
		}
		
	}
	
	public void registerCommands(FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandAPI());
	}
}
