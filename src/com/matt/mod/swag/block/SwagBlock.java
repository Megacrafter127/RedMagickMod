package com.matt.mod.swag.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.matt.FutureCraft;
import com.matt.lib.Ref;
import com.matt.mod.swag.SwagHelper;
import com.matt.mod.swag.lib.SwagLib;

public class SwagBlock extends Block {

	public SwagBlock(int id, String str) {
		super(id, Material.sand);
		setTextureName(Ref.NAME.toLowerCase() + ":" + str);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
		try {
				if(player.inventory.getCurrentItem().itemID == SwagHelper.swaggishWand.itemID) {
					System.out.println("Swaggish wand clicked on a SwagBlock!");
					world.setBlockToAir(x, y, z);
					player.inventory.addItemStackToInventory(new ItemStack(this));
					return true;
				} else {
					return false;
				}
		}catch(NullPointerException e) {
			e.printStackTrace();
			return false;
		}
		
		 
	}


}
