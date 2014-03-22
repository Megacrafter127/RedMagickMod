package com.futurecraft.mod.witchery.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.mod.generic.helpers.ChatHelper;
import com.futurecraft.mod.magick.alchemy.IManaContainer;
import com.futurecraft.mod.magick.lib.MagickLib;

public class BlockWorkshop extends Block implements ITileEntityProvider {

	public BlockWorkshop(int par1) {
		super(par1, Material.wood);
		super.setUnlocalizedName("Workshop");
		super.setTextureName(MagickLib.toTextureName("Workshop"));
		super.setLightValue(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWorkshop();
	}
	
	@Override
	public boolean onBlockActivated(World w,int x,int y,int z,EntityPlayer p,int side,float hitx,float hity,float hitz) {
		System.out.println("Activated Workshop");
		TileEntityWorkshop t=(TileEntityWorkshop) w.getBlockTileEntity(x, y, z);
		if(t.canSpend(p)) {
			t.claim(p);
			ItemStack s=p.inventory.getCurrentItem();
			if(s==null) return false;
			Item it=s.getItem();
			if(it instanceof IManaContainer) {
				int mana=0,m=((IManaContainer) it).getManaTypeCount(s);
				for(int i=0;i<m;i++) {
					mana+=((IManaContainer) it).useMana(s, i, ((IManaContainer) it).getMana(s, i));
				}
				t.spend(mana);
				p.inventory.inventoryChanged=true;
				p.addChatMessage("Transmitted "+ChatHelper.acf(""+mana, ChatHelper.ENUMARRAY_NUMBER)+"to the Workshop");
				p.addChatMessage("This Workshop contains "+ChatHelper.acf(""+t.getMana(), ChatHelper.ENUMARRAY_NUMBER)+" mana.");
				return true;
			}
		}
		p.addChatMessage("This Workshop contains "+ChatHelper.acf(""+t.getMana(), ChatHelper.ENUMARRAY_NUMBER)+" mana.");
		return false;
		
	}
}
