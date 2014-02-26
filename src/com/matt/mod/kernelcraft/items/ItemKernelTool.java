package com.matt.mod.kernelcraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.matt.mod.generic.helpers.ChatHelper;
import com.matt.mod.kernelcraft.KernelCraftCore;
import com.matt.mod.kernelcraft.tasks.KernelFillingTask;
import com.matt.mod.kernelcraft.tasks.KernelMiningTask;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * 
 * @author Megacrafter127
 *
 */
public class ItemKernelTool extends Item {
	public static final int commandToolMeta=0;
	public static final int mineToolMeta=1;
	public static final int fillToolMeta=2;
	public static final int hoeToolMeta=3;
	public static final int harvestToolMeta=4;
	public static final int countToolMeta=5;
	
	
	@SideOnly(Side.CLIENT)
	private Icon commandTool;
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
		commandTool=r.registerIcon(KernelCraftCore.toTextureName("commandkerneltool"));
		mineTool=r.registerIcon(KernelCraftCore.toTextureName("minekerneltool"));
		fillTool=r.registerIcon(KernelCraftCore.toTextureName("fillkerneltool"));
		hoeTool=r.registerIcon(KernelCraftCore.toTextureName("hoekerneltool"));
		harvestTool=r.registerIcon(KernelCraftCore.toTextureName("harvestkerneltool"));
		countTool=r.registerIcon(KernelCraftCore.toTextureName("countkerneltool"));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int dmg) {
		switch(dmg) {
		case commandToolMeta: return commandTool;
		case mineToolMeta: return mineTool;
		case fillToolMeta: return fillTool;
		case hoeToolMeta: return hoeTool;
		case harvestToolMeta: return harvestTool;
		case countToolMeta: return countTool;
		default: return super.getIconFromDamage(dmg);
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch(stack.getItemDamage()) {
		case commandToolMeta: return "Kernel Command Tool";
		case mineToolMeta: return "Kernel Mining Tool";
		case fillToolMeta: return "Kernel Filling Tool";
		case hoeToolMeta: return "Kernel Hoeing Tool";
		case harvestToolMeta: return "Kernel Harvesting Tool";
		case countToolMeta: return "Kernel Counting Tool";
		default: return super.getUnlocalizedName(stack);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack stack,int pass) {
		return getIconFromDamage(stack.getItemDamage());
	}
	
	@Override
	public void addInformation(ItemStack stack,EntityPlayer player,List list, boolean b) {
		super.addInformation(stack, player, list, b);
		boolean shift=Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)||Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		NBTTagCompound nbt=stack.stackTagCompound;
		if(nbt==null) {
			nbt=stack.stackTagCompound=new NBTTagCompound();
			player.inventory.inventoryChanged=true;
		}
		EnumChatFormatting[] stdformat=new EnumChatFormatting[]{EnumChatFormatting.GRAY};
		EnumChatFormatting[] hintformat=new EnumChatFormatting[]{EnumChatFormatting.GREEN};
		EnumChatFormatting[] numberformat=new EnumChatFormatting[]{EnumChatFormatting.AQUA};
		EnumChatFormatting[] errorformat=new EnumChatFormatting[]{EnumChatFormatting.BOLD,EnumChatFormatting.RED,EnumChatFormatting.UNDERLINE};
		switch(stack.getItemDamage()) {
		case commandToolMeta:
			list.add(stdformat+nbt.toString());
			break;
		case mineToolMeta:
			if(nbt.hasKey("1coord")) {
				int[] c=nbt.getIntArray("1coord");
				list.add(ChatHelper.acf("1st coords: ",stdformat)+ChatHelper.acf(""+c[0], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[1], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[2], numberformat));
				if(nbt.hasKey("2coord")) {
					c=nbt.getIntArray("2coord");
					list.add(ChatHelper.acf("2nd coords: ",stdformat)+ChatHelper.acf(""+c[0], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[1], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[2], numberformat));
					list.add(ChatHelper.acf("Right-click on a Kernel-Core", hintformat));
					list.add(ChatHelper.acf("to enqueue this task.", hintformat));
				}
				else {list.add(ChatHelper.acf("mark the end of area to fill in",hintformat));list.add(ChatHelper.acf("by right-clicking on the block,",hintformat));list.add(ChatHelper.acf("that shall limit it.",hintformat));}
			}
			else {list.add(ChatHelper.acf("mark the area to fill in",hintformat));list.add(ChatHelper.acf("by right-clicking on the blocks,",hintformat));list.add(ChatHelper.acf("that shall limit it.",hintformat));}
			break;
		case fillToolMeta:
			if(nbt.hasKey("fillID")&&nbt.hasKey("fillMeta")) {
				list.add(ChatHelper.acf("BlockID: ", stdformat)+ChatHelper.acf(""+nbt.getInteger("fillID"), numberformat));
				list.add(ChatHelper.acf("BlockMeta: ", stdformat)+ChatHelper.acf(""+nbt.getInteger("fillMeta"), numberformat));
				if(nbt.hasKey("1coord")) {
					int[] c=nbt.getIntArray("1coord");
					list.add(ChatHelper.acf("1st coords: ",stdformat)+ChatHelper.acf(""+c[0], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[1], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[2], numberformat));
					if(nbt.hasKey("2coord")) {
						c=nbt.getIntArray("2coord");
						list.add(ChatHelper.acf("2nd coords: ",stdformat)+ChatHelper.acf(""+c[0], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[1], numberformat)+ChatHelper.acf(", ", stdformat)+ChatHelper.acf(""+c[2], numberformat));
						list.add(ChatHelper.acf("Right-click on a Kernel-Core", hintformat));
						list.add(ChatHelper.acf("to enqueue this task.", hintformat));
					}
					else {list.add(ChatHelper.acf("mark the end of area to fill in",hintformat));list.add(ChatHelper.acf("by right-clicking on the block,",hintformat));list.add(ChatHelper.acf("that shall limit it.",hintformat));}
				}
				else {list.add(ChatHelper.acf("mark the area to fill in",hintformat));list.add(ChatHelper.acf("by right-clicking on the blocks,",hintformat));list.add(ChatHelper.acf("that shall limit it.",hintformat));}
			}
			else {list.add(ChatHelper.acf("select the block,",hintformat));list.add(ChatHelper.acf(" to fill an area with.",hintformat));}
			break;
		default:
			list.add(ChatHelper.acf("Unknown Tool, no data available",errorformat));
			break;
		}
	}
	
	@Override
	public boolean getShareTag() {
		return true;
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack item,EntityPlayer player,World w,int x,int y,int z,int side,float hitx,float hity,float hitz) {
		if(w.isRemote) return false;
		if(!item.hasTagCompound()) item.stackTagCompound=new NBTTagCompound();
		boolean enqueued=false;
		TileEntity t=w.getBlockTileEntity(x, y, z);
		int[] coord1,coord2;
		switch(item.getItemDamage()) {
		case commandToolMeta:
			t=w.getBlockTileEntity(x, y, z);
			if(t!=null && t instanceof TileEntityKernelCore) {
				NBTTagCompound newtasks=new NBTTagCompound();
				TileEntityKernelCore c=(TileEntityKernelCore)t;
				c.writeTasksToNBT(newtasks);
				c.readTasksFromNBT(item.stackTagCompound);
				item.stackTagCompound=newtasks;
				player.addChatMessage("Tasklist exchanged");
			}
			break;
		case mineToolMeta:
			coord1=item.stackTagCompound.getIntArray("1coord");
			if(coord1==null || coord1.length!=3) {
				item.stackTagCompound.setIntArray("1coord", new int[]{x,y,z});
				return true;
			}
			coord2=item.stackTagCompound.getIntArray("2coord");
			if(coord2==null || coord2.length!=3) {
				item.stackTagCompound.setIntArray("2coord", new int[]{x,y,z});
				return true;
			}
			if(t!=null && t instanceof TileEntityKernelCore) {
				((TileEntityKernelCore)t).enqueueTask(new KernelMiningTask(coord1[0],coord1[1],coord1[2],coord2[0],coord2[1],coord2[2],1));
				enqueued=true;
			}
			break;
		case fillToolMeta:
			int fillid,fillmeta;
			if(item.stackTagCompound.hasKey("fillID")&&item.stackTagCompound.hasKey("fillMeta")) {
				fillid=item.stackTagCompound.getInteger("fillID");
				fillmeta=item.stackTagCompound.getInteger("fillMeta");
			}
			else {
				item.stackTagCompound.setInteger("fillID", w.getBlockId(x, y, z));
				item.stackTagCompound.setInteger("fillMeta", w.getBlockMetadata(x, y, z));
				return true;
			}
			coord1=item.stackTagCompound.getIntArray("1coord");
			if(coord1==null || coord1.length!=3) {
				item.stackTagCompound.setIntArray("1coord", new int[]{x,y,z});
				return true;
			}
			coord2=item.stackTagCompound.getIntArray("2coord");
			if(coord2==null || coord2.length!=3) {
				item.stackTagCompound.setIntArray("2coord", new int[]{x,y,z});
				return true;
			}
			if(t!=null && t instanceof TileEntityKernelCore) {
				((TileEntityKernelCore)t).enqueueTask(new KernelFillingTask(fillid,fillmeta,coord1[0],coord1[1],coord1[2],coord2[0],coord2[1],coord2[2],1));
				enqueued=true;
			}
			break;
		}
		if(enqueued) {
			item.stackTagCompound=null;
			player.inventory.inventoryChanged=true;
			player.addChatMessage("Task enqueued! Resetting Kerneltool");
			return true;
		}
		return false;
	}
}
