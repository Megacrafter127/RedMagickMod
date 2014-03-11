package com.futurecraft.mod.magick.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IWandAble {
public void onWandRightClick(EntityPlayer p, World w, int x, int y, int z);
public void onWandSneakRightClick(EntityPlayer p, World w, int x, int y, int z);

}
