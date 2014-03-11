package com.futurecraft.mod.magick.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.futurecraft.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWandCore  extends Item{
	private static String[] names;
	public ItemWandCore(int par1) {
		super(par1);
		 setNames(new String[10]);
		getNames()[0] = "Iron-Core";
		getNames()[1] = "Golden-Core";
		getNames()[2] = "Enderium-Core";
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
					return super.getUnlocalizedName() + "." + getNames()[i];
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
	        		String[] texturenames = new String[]{"ironc","goldc","endc","shizzlec"};
					Icon ic = r.registerIcon(Ref.NAME.toLowerCase() + ":" + texturenames[i]);
					icons[i] = ic;
	        	}
	        }
	        @SideOnly(Side.CLIENT)
	        public Icon getItemIconFromDamage(int par1IconIndex) {
	        	return icons[par1IconIndex];
	        }

			/**
			 * @return the names
			 */
			public static String[] getNames() {
				return names;
			}

			/**
			 * @param names the names to set
			 */
			public void setNames(String[] names) {
				this.names = names;
			}

}
