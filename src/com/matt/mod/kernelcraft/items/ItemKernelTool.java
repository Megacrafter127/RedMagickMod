package com.matt.mod.kernelcraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemKernelTool extends Item {
	public static final int mineToolMeta=0;
	public static final int fillToolMeta=1;
	public static final int hoeToolMeta=2;
	public static final int harvestToolMeta=3;
	public static final int countToolMeta=4;
	
	@SideOnly(Side.CLIENT)
	private Icon mineTool;
	@SideOnly(Side.CLIENT)
	private Icon fillTool;
	@SideOnly(Side.CLIENT)
	private Icon hoeTool;
	@SideOnly(Side.CLIENT)
	private Icon harvestTool;
	@SideOnly(Side.CLIENT)
	private Icon countTool;
	
	public ItemKernelTool(int par1) {
		super(par1);
		super.setHasSubtypes(true);
		super.setTextureName(KernelCraftCore.toTextureName("unknownkerneltool"));
		super.setUnlocalizedName("Unknown Kernel Tool");
		super.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister r) {
		super.registerIcons(r);
		mineTool=r.registerIcon(KernelCraftCore.toTextureName("minekerneltool"));
		fillTool=r.registerIcon(KernelCraftCore.toTextureName("fillkerneltool"));
		hoeTool=r.registerIcon(KernelCraftCore.toTextureName("hoekerneltool"));
		harvestTool=r.registerIcon(KernelCraftCore.toTextureName("harvestkerneltool"));
		countTool=r.registerIcon(KernelCraftCore.toTextureName("countkerneltool"));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg) {
		if(dmg==mineToolMeta) return mineTool;
		if(dmg==fillToolMeta) return fillTool;
		if(dmg==hoeToolMeta) return hoeTool;
		if(dmg==harvestToolMeta) return harvestTool;
		if(dmg==countToolMeta) return countTool;
		return super.getIconFromDamage(dmg);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int dmg=stack.getItemDamage();
		if(dmg==mineToolMeta) return "Kernel Mining Tool";
		if(dmg==fillToolMeta) return "Kernel Filling Tool";
		if(dmg==hoeToolMeta) return "Kernel Hoeing Tool";
		if(dmg==harvestToolMeta) return "Kernel Harvesting Tool";
		if(dmg==countToolMeta) return "Kernel Counting Tool";
		return super.getUnlocalizedName(stack);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack stack,int pass) {
		return getIconFromDamage(stack.getItemDamage());
	}
	
	@Override
	public boolean getShareTag() {
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack item,EntityPlayer player,World w,int x,int y,int z,int side,float hitx,float hity,float hitz) {
		if(w.isRemote) return false;
		if(!item.hasTagCompound()) {
			TileEntity t=w.getBlockTileEntity(x, y, z);
			if(t!=null && t instanceof TileEntityKernelCore) {
				item.stackTagCompound=new NBTTagCompound();
				item.stackTagCompound.setIntArray("coords", new int[]{x,y,z});
				player.addChatMessage("Tool-Link established");
				return true;
			}
			player.addChatMessage("Tool-Links can only be established to active kernel-cores");
			return false;
		}
		int dmg=item.getItemDamage();
		int[] coord=item.stackTagCompound.getIntArray("coords");
		TileEntityKernelCore t=null;
		try{
			t=(TileEntityKernelCore)w.getBlockTileEntity(coord[0],coord[1],coord[2]);
		}
		catch(NullPointerException ex) {}
		catch(ArrayIndexOutOfBoundsException ex) {}
		catch(ClassCastException ex) {}
		if(t==null) {
			item.stackTagCompound=null;
			return onItemUse(item,player,w,x,y,z,side,hitx,hity,hitz);
		}
		if(dmg==mineToolMeta) {
			coord=item.stackTagCompound.getIntArray("1coord");
			if(coord==null) {
				item.stackTagCompound.setIntArray("1coord", new int[]{x,y,z});
				return true;
			}
			
		}
		return false;
	}
}
