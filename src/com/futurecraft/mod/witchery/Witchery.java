package com.futurecraft.mod.witchery;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.futurecraft.generic.helpers.IFutureCraftPlugin;
import com.futurecraft.mod.witchery.block.BlockWorkshop;
import com.futurecraft.mod.witchery.block.TileEntityWorkshop;
import com.futurecraft.mod.witchery.item.ItemManaOverload;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Witchery implements IFutureCraftPlugin {
	private static class CustomTabs extends CreativeTabs {
		private ItemStack s;
		public CustomTabs(String name,ItemStack i) {
			super(CreativeTabs.getNextID(), name);
			s=i;
		}
		public CustomTabs(String name,Block b) {
			this(name,new ItemStack(b,1));
		}
		public CustomTabs(String name,Item i) {
			this(name,new ItemStack(i,1));
		}
		
		@Override
		public ItemStack getIconItemStack() {
			return s;
		}
		
		@Override
		public Item getTabIconItem() {
			return s.getItem();
		}
	}

	public final int WorkshopID=2050;
	public final int OverloadID=2051;
	public final BlockWorkshop workshop=new BlockWorkshop(WorkshopID);
	public final ItemManaOverload overload=new ItemManaOverload(OverloadID);
	public final CustomTabs tab=new CustomTabs("Witchery", workshop); 
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
