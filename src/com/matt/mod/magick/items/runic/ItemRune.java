package com.matt.mod.magick.items.runic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.matt.mod.generic.helpers.ChatHelper;
import com.matt.mod.magick.items.IMagickObject;
import com.matt.mod.magick.items.INBTItem;
import com.matt.mod.magick.lib.MagickLib;

public class ItemRune extends Item implements IMagickObject, INBTItem{

	public static final String STRING_RUNIC_TYPE = "Runic Type : ";
	String[] magickTypes = new String[]{"dull","magic","null","fire","water","air","earth"};
	int currentManaType;
	public ItemRune() {
		super(MagickLib.getIdFor("Rune", 30001));
		setTextureName(MagickLib.toTextureName("dullRune"));
		setUnlocalizedName("rune");
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
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List inflist, boolean par4) {
		if(magickTypes[currentManaType] == "air") {
			inflist.add(STRING_RUNIC_TYPE + ChatHelper.acf("Aera",EnumChatFormatting.YELLOW));
		}else if(magickTypes[currentManaType] == "fire") {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Fotia",EnumChatFormatting.RED));
		}else if(magickTypes[currentManaType] == "water") {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Nero",EnumChatFormatting.DARK_AQUA));
		}else if(magickTypes[currentManaType] == "magic") {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Mageia",EnumChatFormatting.DARK_PURPLE));
		}else if(magickTypes[currentManaType] == "earth") {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Gaias",EnumChatFormatting.GREEN));
		}else if(magickTypes[currentManaType] == "dull" ) {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Thampo",EnumChatFormatting.DARK_GRAY));
		} else if(magickTypes[currentManaType] == "null") {
			inflist.add(STRING_RUNIC_TYPE  + ChatHelper.acf("Miden",EnumChatFormatting.DARK_GRAY));
		}
		
	}
	@Override
	public void writeToNbt(ItemStack stack) {
		if(stack.stackTagCompound != null) {
			if(currentManaType <= 6) {
			stack.stackTagCompound.setInteger("manaType",currentManaType);
			}else{
				currentManaType = 0;
				stack.stackTagCompound.setInteger("manaType",currentManaType);
			}
		}else{
			stack.stackTagCompound = new NBTTagCompound();
			if(currentManaType <= 6) {
				stack.stackTagCompound.setInteger("manaType",currentManaType);
				}else{
					currentManaType = 0;
					stack.stackTagCompound.setInteger("manaType",currentManaType);
				}
		}
	}
	@Override
	public void readFromNbt(ItemStack stack) {
		currentManaType = stack.stackTagCompound.getInteger("manaType");
	}
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		writeToNbt(par1ItemStack);
		readFromNbt(par1ItemStack);
		
	}
	
	@Override
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		
		if(par2EntityPlayer.isSneaking()) {
			writeToNbt(par1ItemStack);
			if(currentManaType <= 6) {
				
				currentManaType++;
				return false;
			}else{
				currentManaType = 0;
			}
		}
		readFromNbt(par1ItemStack);
        return false;
    }
}
