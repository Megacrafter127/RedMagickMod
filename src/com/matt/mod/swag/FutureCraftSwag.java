package com.matt.mod.swag;

import com.matt.FutureCraft;
import com.matt.generic.helpers.IFutureCraftPlugin;
import com.matt.lib.Ref;

public class FutureCraftSwag implements IFutureCraftPlugin{

public void register() {
System.out.println("Registering FutureCraftSwag plugin!");
SwagHelper.register();
}
@Override
public String getName() {
	return "FutureCraft Swag";
}
public static String toTextureName(String name) {
	return Ref.NAME.toLowerCase()+":"+name;
}

}
