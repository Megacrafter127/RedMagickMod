
package com.matt.mod.item;

import java.awt.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.matt.lib.Ref;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnderium extends Item {
	
	public ItemEnderium(int id, String unlocalizedName, CreativeTabs creativetab,String textureNameC) {
		super(id);
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(creativetab);
		setTextureName(Ref.NAME + ":" + textureNameC);
	}
	public void addInformation(ItemStack par1ItemStack, List par2List)
	{
	         par2List.add("Lore Line #1");
	         par2List.add("Lore Line #2");
	         // etc ...
	}	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
	}
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
	
}
