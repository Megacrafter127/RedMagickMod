package com.matt.mod.magick.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.matt.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagickWand extends Item{

	String[] names;
	public ItemMagickWand(int par1) {
		super(par1);
		names = new String[10];
		names[1] = "Iron-Cored Birch Magical Staff";
		names[2] = "Golden-Cored Oak Magical Staff";
		names[3] = "Netherium-Adorned Enderium-Cored Oldwood Magical Staff";
		this.setUnlocalizedName(getUnlocalizedName(new ItemStack(this)));
		setHasSubtypes(true);
		setMaxDamage(100);
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
	        return this.itemIcon;
	    }
	    
	        public String getUnlocalizedName(ItemStack par1ItemStack){
	                int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(),0,15);
					return super.getUnlocalizedName() + "." + names[i];
	        }
	        @SideOnly(Side.CLIENT)
	        public void getSubItems(int itemID, CreativeTabs tabs, List list){
	             
	                for(int i = 0; i <= 3; ++i){
	                        list.add(new ItemStack(itemID, 1, i));
	                 }
	         }
	        @SideOnly(Side.CLIENT)
	        public void registerIcons(IconRegister r) {
	        icons = new Icon[3];
	        	for(int i = 0;i <= icons.length; i++) {
	        		String[] texturenames = new String[]{"iron","gold","nethend"};
					r.registerIcon(Ref.NAME.toLowerCase() + texturenames[i]);
	        	}
	        }
	        @SideOnly(Side.CLIENT)
	        public Icon getItemFromDamage(int gotFromWuppy) {
	        	return icons[gotFromWuppy];
	        }
}
