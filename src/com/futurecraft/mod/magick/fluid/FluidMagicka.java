package com.futurecraft.mod.magick.fluid;

import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.Fluid;

import com.futurecraft.mod.magick.lib.MagickLib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidMagicka extends Fluid {

	public FluidMagicka(String fluidName) {
		super("Magicka");
		setBlockID(MagickLib.getIdFor("FluidMagicka",899));
		setUnlocalizedName("Magick");
		setDensity(10); // How tick the fluid is, affects movement inside the liquid.
		setViscosity(1000); // How fast the fluid flows.
	}
	

	@Override
	 public int getColor()
    {
        return 0xFFFFFF;
    }

}
