package com.futurecraft.mod.magick.infusion;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.futurecraft.FutureCraft;
import com.futurecraft.mod.magick.MagickHelper;
import com.futurecraft.mod.magick.lib.IWandAble;

public class InfusionAltar extends Block implements IWandAble, ITileEntityProvider {
	static InventoryCrafting thisCraftingInventory;
	public InfusionAltar() {
		super(FutureCraft.altarCoreID,Material.iron);
		
	}

	@Override	
	public TileEntity createNewTileEntity(World world) {
		
		return new TileInfuser();
	}

	@Override
	public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z) {
		// TODO Auto-generated method stub
		
	}

	
	 public boolean onBlockActivated(World world, int x, int y, int z,
             EntityPlayer player, int metadata, float what, float these, float are) {
		thisCraftingInventory = new InventoryCrafting(new ContainerInfuser(Minecraft.getMinecraft().thePlayer.inventory,(TileInfuser)world.getBlockTileEntity(x,y,z)),3,3);
		 world.markBlockForUpdate(x,y,z);
     TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     if (tileEntity == null || player.isSneaking()) {
             return false;
     }
     
    	 onWandSneakRightClick(player,world,x,y,z);
     
//code to open gui explained later
     	player.openGui(FutureCraft.instance, 1, world, x, y, z);
     return true;
}

@Override
public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
     dropItems(world, x, y, z);
     super.breakBlock(world, x, y, z, par5, par6);
}

private void dropItems(World world, int x, int y, int z){
     Random rand = new Random();

     TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     if (!(tileEntity instanceof IInventory)) {
             return;
     }
     IInventory inventory = (IInventory) tileEntity;

     for (int i = 0; i < inventory.getSizeInventory(); i++) {
             ItemStack item = inventory.getStackInSlot(i);

             if (item != null && item.stackSize > 0) {
                     float rx = rand.nextFloat() * 0.8F + 0.1F;
                     float ry = rand.nextFloat() * 0.8F + 0.1F;
                     float rz = rand.nextFloat() * 0.8F + 0.1F;

                     EntityItem entityItem = new EntityItem(world,
                                     x + rx, y + ry, z + rz,
                                     new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                     if (item.hasTagCompound()) {
                             entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                     }

                     float factor = 0.05F;
                     entityItem.motionX = rand.nextGaussian() * factor;
                     entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                     entityItem.motionZ = rand.nextGaussian() * factor;
                     world.spawnEntityInWorld(entityItem);
                     item.stackSize = 0;
             }
     }
}
@Override
public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	((TileInfuser)par1World.getBlockTileEntity(par2,par3,par4)).run(Minecraft.getMinecraft().thePlayer);
}

@Override
public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y, int z) {
	// TODO Auto-generated method stub
	
}
	

}
