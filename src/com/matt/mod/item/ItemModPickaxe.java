package com.matt.mod.item;

import com.matt.lib.Ref;
import com.matt.mod.ModItems;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.common.EnumHelper;

public class ItemModPickaxe extends ItemPickaxe {
	public static final EnumToolMaterial enderium=EnumHelper.addToolMaterial("Enderium",3,1024,10.0F,4.0F,40);
	public static final EnumToolMaterial netherium=EnumHelper.addToolMaterial("Netherium",0,4096,10.0F,3.0F,2);
	public static final EnumToolMaterial indium=EnumHelper.addToolMaterial("Indium",4,2048,5.0F,3.0F,0);
	static{
		enderium.customCraftingMaterial=ModItems.endh;
		netherium.customCraftingMaterial=ModItems.neth;
		indium.customCraftingMaterial=ModItems.ingotIndium;
	}

	public ItemModPickaxe(int par1,EnumToolMaterial material) {
		super(par1, material);
		if(material==enderium) {
			setTextureName(Ref.NAME.toLowerCase() + ":pickaxeenderium");
			setUnlocalizedName("Enderium Pickaxe");
		}
		else if(material==netherium) {
			setTextureName(Ref.NAME.toLowerCase() + ":pickaxenetherium");
			setUnlocalizedName("Netherium Pickaxe");
		}else if(material==indium) {
			setTextureName(Ref.NAME.toLowerCase() + ":pickaxeindium");
			setUnlocalizedName("Indium Pickaxe");
		}
	}
	
	@Override
	public boolean hasEffect(ItemStack s) {
		return true;
	}
	
	public EnumRarity getRarity(ItemStack s) {
		if(((ItemPickaxe)s.getItem()).getToolMaterialName().equals("Enderium")) {
			return EnumRarity.epic;
		}
		else if(((ItemPickaxe)s.getItem()).getToolMaterialName().equals("Netherium")) {
			return EnumRarity.rare;
		}
		else if(((ItemPickaxe)s.getItem()).getToolMaterialName().equals("Indium")) {
			return EnumRarity.epic;
		}
		return EnumRarity.common;
	}

}
