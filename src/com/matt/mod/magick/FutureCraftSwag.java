package com.matt.mod.magick;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;

public class FutureCraftSwag implements IFutureCraftPlugin{

public void register() {
System.out.println("Registering FutureCraftMagick plugin!");
SwagHelper.register();
}
@Override
public String getName() {
	return "FutureCraft Magick";
}


}
