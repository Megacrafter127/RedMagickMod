package com.futurecraft.mod.witchery;

import net.minecraft.creativetab.CreativeTabs;

import com.futurecraft.generic.helpers.IFutureCraftPlugin;
import com.futurecraft.mod.witchery.block.BlockWorkshop;
import com.futurecraft.mod.witchery.block.TileEntityWorkshop;
import com.futurecraft.mod.witchery.item.ItemManaOverload;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Witchery implements IFutureCraftPlugin {
	public final CreativeTabs tab=new CreativeTabs(CreativeTabs.getNextID(),"Witchery"); 
	public final int WorkshopID=2050;
	public final int OverloadID=2051;
	public final BlockWorkshop workshop=new BlockWorkshop(WorkshopID);
	public final ItemManaOverload overload=new ItemManaOverload(OverloadID);
	@Override
	public String getName() {
		return "Witchery, a magick upgrade";
	}

	@Override
	public void register() {
		workshop.setCreativeTab(tab);
		GameRegistry.registerBlock(workshop, "Workshop");
		LanguageRegistry.addName(workshop, "Workshop");
		overload.setCreativeTab(tab);
		GameRegistry.registerItem(overload, "Overload");
		LanguageRegistry.addName(overload, "Overload");
		
		GameRegistry.registerTileEntity(TileEntityWorkshop.class, TileEntityWorkshop.class.getName());
	}

	@Override
	public void registerCommands(FMLServerStartingEvent e) {
		// TODO Auto-generated method stub

	}

}