package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.matt.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagickWand extends Item{
	public static int currentCharge;
	public static String[] names;
	public static final String[] stnames = new String[]{"Lesser","Medium","Greater"};
	public ItemMagickWand(int par1) {
		super(par1);
		names = new String[10];
		names[0] = "Iron-Cored Birch Magical Staff";
		names[1] = "Golden-Cored Oak Magical Staff";
		names[2] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";
		
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
	        return this.icons[par1];
	    }
	    
	        public String getUnlocalizedName(ItemStack par1ItemStack){
	                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(),0,15);
					return super.getUnlocalizedName() + "." + names[i];
	        }
	        @SideOnly(Side.CLIENT)
	        public void getSubItems(int itemID, CreativeTabs tabs, List list){
	             
	                for(int i = 0; i < 3; ++i){
	                        list.add(new ItemStack(itemID, 1, i));
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
	        	return icons[par1IconIndex];
	        }
	        public int getMagickStorage(int par1ItemDamage) {
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
}
