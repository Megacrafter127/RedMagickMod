package com.matt.mod.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.matt.FutureCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFutureNote extends Item {

	public ItemFutureNote() {
	super(FutureCraft.loreBookId);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		player.openGui(FutureCraft.instance, 0, w, x, y, z);
		return true;
	}
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if( par1ItemStack.stackTagCompound == null )
                par1ItemStack.setTagCompound( new NBTTagCompound( ) );
        par1ItemStack.stackTagCompound.setString("futurecraftdesc","true");
        System.out.println("Created tagCompound for Lorebook!");
}
	 // @SideOnly(Side.CLIENT)
	  @Override
	    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	    {
		 
		  if( par1ItemStack.stackTagCompound == null ) {
              par1ItemStack.setTagCompound( new NBTTagCompound( )); 
	        if (par1ItemStack.hasTagCompound())
	        {
	            NBTTagCompound nbt= par1ItemStack.getTagCompound();
	           if(par1ItemStack.stackTagCompound.getString("futurecraftdesc") == "true") {
	            	par3List.add(EnumChatFormatting.GRAY + "FutureCraft!");
	           }
	       
		  }
	    }


	    }
	  }
