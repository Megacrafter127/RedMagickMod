package com.matt.mod.magick.items.runic;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.matt.mod.magick.items.IMagickObject;
import com.matt.mod.magick.lib.MagickLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRune extends Item implements IMagickObject {

	String[] magickTypes = new String[]{"dull","magic","null","fire","water","air","earth"};
	Icon dullIcon;
	Icon magicIcon;
	Icon nullIcon = dullIcon;
	Icon fireIcon;
	Icon waterIcon;
	Icon airIcon;
	Icon earthIcon;
	public ItemRune() {
		super(MagickLib.getIdFor("Rune", 30001));
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return MagickLib.getIdFor("Rune", 30001);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "item";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Rune";
	}
	public String getMagickType() {
		return "dull";
	}
	@Override
	  public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if(stack.getItem() instanceof ItemRune) {
        	ItemRune r = (ItemRune)stack.getItem();
        	if(r.getMagickType(stack) == "dull") {
        		return dullIcon;
        	}
        }
		return nullIcon;
    }

	private String getMagickType(ItemStack stack) {
		
		if(stack.getItemDamage() < 6) {
			return magickTypes[0];
		}
		return magickTypes[stack.getItemDamage()];
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
	
	//blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.tutBlock_unlocalizedName);
		dullIcon = icon.registerIcon(MagickLib.toTextureName("dullRune"));
		magicIcon = icon.registerIcon(MagickLib.toTextureName("runeMagic"));
		fireIcon = icon.registerIcon(MagickLib.toTextureName("runeFire"));
		waterIcon = icon.registerIcon(MagickLib.toTextureName("runeWater"));
		earthIcon = icon.registerIcon(MagickLib.toTextureName("runeEarth"));
		airIcon = icon.registerIcon(MagickLib.toTextureName("runeAir"));
		
	}
}
