package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.matt.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagickWand extends Item {
	/**
	 * @author Megacrafter127
	 * @param damage - the damage value of the wand
	 * @return the level of the wand
	 */
	public static int getLevel(int damage) {
		int level=0;
		for(;0>=damage||levelMax[level]<damage;level++) {
			try{
				damage-=levelMax[level];
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				level++;
				break;
			}
		}
		return level;
	}
	/**
	 * @author Megacrafter127
	 * @param level - the level of the wand
	 * @return the damage of an empty wand of this level
	 */
	public static int getDamageForEmpty(int level) {
		int dmg=0;
		for(int i=0;i<level;i++) {
			try{
				dmg+=levelMax[i];
			}
			catch(ArrayIndexOutOfBoundsException ex) {}
		}
		return dmg;
	}
	/**
	 * @author Megacrafter127
	 * @param damage - the damage value of the wand
	 * @return the charge of the wand
	 */
	public static int getCharge(int damage) {
		for(int level=0;true;level++) {
			try{
				if(0<=damage&&damage<levelMax[level]) {
					return damage;
				}
				else {
					damage-=levelMax[level];
				}
				
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				return damage;
			}
		}
	}
	/**
	 * the level maximum charges(the index is the level)
	 * @author Megacrafter127
	 */
	public static int[] levelMax=new int[]{100,1000,10000};
	@Deprecated
	public static int currentCharge = 1;
	public static String[] names=new String[10];
	/**
	 * @author Megacrafter127
	 */
	static{
		names[0] = "Iron-Cored Birch Magical Staff";
		names[1] = "Golden-Cored Oak Magical Staff";
		names[2] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";
	}
	public static final String[] stnames = new String[]{"Lesser","Medium","Greater"};
	public ItemMagickWand(int par1) {
		super(par1);
		//names = new String[10]; why should the static variable be overritten by a constructor, that might be called multiple times
		/*names[0] = "Iron-Cored Birch Magical Staff";
		names[1] = "Golden-Cored Oak Magical Staff";
		names[2] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";*/
		
		this.setUnlocalizedName(getUnlocalizedName(new ItemStack(this)));
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(Ref.getRecommendedTab("block"));
	}
	@SideOnly(Side.CLIENT)
	Icon[] icons;
	@SideOnly(Side.CLIENT)
	
	/**
	 * @author Matheus
	 * @param par1 - The item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		//return this.icons[par1];
		return this.icons[getLevel(par1)];
	}
	
	public String getUnlocalizedName(ItemStack par1ItemStack){
		int i = MathHelper.clamp_int(getLevel(par1ItemStack.getItemDamage()),0,15);
		return super.getUnlocalizedName() + "." + names[i];
	}
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tabs, List list){
		
		for(int i = 0; i < 3; ++i){
			list.add(new ItemStack(itemID, 1, getDamageForEmpty(i)));
		}
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r) {
		icons = new Icon[4];
		for(int i = 0;i < icons.length; i++) {
			String[] texturenames = new String[]{"iron","gold","nethend","shizzle"};
			Icon ic = r.registerIcon(Ref.NAME.toLowerCase() + ":" + texturenames[i]);
			icons[i] = ic;
			
		}
	}
	@SideOnly(Side.CLIENT)
	public Icon getItemIconFromDamage(int par1IconIndex) {
		return this.getIconFromDamage(par1IconIndex);
	}
	public int getMagickStorage(int par1ItemDamage) {
		par1ItemDamage=getLevel(par1ItemDamage);
		if(par1ItemDamage == 0 ) {
			return 100;
		} else if(par1ItemDamage == 1) {
			return 1000;
		} else if(par1ItemDamage == 2 ) {
			return 10000;
		}
		return par1ItemDamage;
		
	}
	/* @Override
	        @SideOnly(Side.CLIENT)
	        public void addInformation(ItemStack par1ItemStack,
	                  EntityPlayer par2EntityPlayer,
	                  List par3List,
	                  boolean par4) {
	        	 super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	        	 NBTTagList nbttaglist = (NBTTagList)par1ItemStack.stackTagCompound.getTag("info");
	             if (nbttaglist != null)
	             {
	                 for (int i = 0; i < nbttaglist.tagCount(); ++i)
	                 {
	                     short short1 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("id");
	                     short short2 = ((NBTTagCompound)nbttaglist.tagAt(i)).getShort("lvl");

	                     if (Enchantment.enchantmentsList[short1] != null)
	                     {
	                         par3List.add(Enchantment.enchantmentsList[short1].getTranslatedName(short2));
	                     }
	                 
	            	 int i = (((NBTTagCompound) nbttaglist.tagAt(1)).getInteger("storage"));
	            	 par3List.add(stnames[i]);
	             }
	        }*/
	        @Override
	        public boolean hasEffect(ItemStack par1ItemStack) {
	        	return true;
	        }
	        @Override
	        public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
	        {
				return bFull3D;
	        	/*try {
	        	//The pokemon master!
	        	writeToNBT(par1ItemStack);
	        	readFromNBT(par1ItemStack);
	        	return true;
	        	}catch(Throwable t) {
	        		t.printStackTrace();
	        		return false;
	        	} */
	        }
	        public  void writeToNBT(ItemStack par1ItemStack) { 
	        	if(par1ItemStack.stackTagCompound.getTag("charge") != null) {
	        		par1ItemStack.stackTagCompound.setInteger("charge", currentCharge);
	        		System.out.println("NBT CHARGE + " +  par1ItemStack.stackTagCompound.getInteger("charge") );
	        	} else {
	        		par1ItemStack.stackTagCompound.setTag("charge",par1ItemStack.stackTagCompound);
	        		par1ItemStack.stackTagCompound.setInteger("charge", currentCharge);
	        		System.out.println("NBT CHARGE + " +  par1ItemStack.stackTagCompound.getInteger("charge") );
	        	}
	        }
	        public void readFromNBT(ItemStack par1ItemStack) {
	        	if(par1ItemStack.stackTagCompound.getTag("charge") != null) {
	        		currentCharge = par1ItemStack.stackTagCompound.getInteger("charge");
	        	} else {
	        		par1ItemStack.stackTagCompound.setTag("charge",par1ItemStack.stackTagCompound);
	        		currentCharge = par1ItemStack.stackTagCompound.getInteger("charge");
	        	}
	        }
}
