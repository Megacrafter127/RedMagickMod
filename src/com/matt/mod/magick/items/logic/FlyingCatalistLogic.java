package com.matt.mod.magick.items.logic;

import net.minecraft.entity.player.EntityPlayer;

public class FlyingCatalistLogic extends ItemLogic {
	public static boolean isFlying;
	public static boolean canFly;
	public static int mana;
	public static  boolean run(EntityPlayer p) {
		System.out.println(p.getDisplayName() +" right clicked ItemCatalist");
		canFly = p.capabilities.allowFlying;
		isFlying = p.isAirBorne;
		/* if(canFly == false && isFlying == false) {
			p.capabilities.allowFlying = true;
			canFly = p.capabilities.allowFlying;
			isFlying = p.isAirBorne;
			return canFly == isFlying;
		} else if(canFly == true && isFlying == true) {
			p.addChatMessage("You can't set if you are flying when you ARE flying! You could've died!");
			canFly = p.capabilities.allowFlying;
			isFlying = p.isAirBorne;
			return canFly == isFlying;
		} else if(canFly == false && isFlying == true) {
			canFly = p.capabilities.allowFlying;
			isFlying = p.isAirBorne;
			p.addChatMessage("You must wait until landing to take off again.");
			return canFly == isFlying;
		}else if(canFly == true && isFlying == false) {
			canFly = p.capabilities.allowFlying;
			isFlying = p.isAirBorne;
			p.addChatMessage("You believe you can fly.. And surprisingly, now, you can!");
			return canFly == isFlying;
		}
		return canFly == isFlying; */
		if(p.capabilities.allowFlying) {
			p.capabilities.allowFlying = false;
		}
		p.capabilities.allowFlying = true;
		return true;

	}
	public int getMana() {
		return mana;
	}
	public void setMana(int i) {
		mana = i;
	}

}
