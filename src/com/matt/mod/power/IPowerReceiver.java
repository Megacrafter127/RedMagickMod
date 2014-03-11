package com.matt.mod.power;

import net.minecraft.world.World;

public interface IPowerReceiver {
	int currentPower = 0;
	int powerUsage = 0;
	void receive(World w,int x,int y,int z);
	int consume(World w,int x,int y,int z);
	int consume(int ammountToConsume);
}
