package com.matt.mod.power;

import net.minecraft.world.World;

public interface IPowerProvider {

	int powerToProvide = 0;
	void provide(World w,int x,int y,int z);
	void receive(World w,int x,int y,int z);
}
