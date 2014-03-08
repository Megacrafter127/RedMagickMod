package com.matt.mod.magick.items.runic;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class RunicEnchantHandler {
	@ForgeSubscribe
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		if(event.source == DamageSource.inFire) {
			event.ammount-=5;
		}else if(event.source == DamageSource.magic) {
			event.ammount-=10;
		}else if(event.source == DamageSource.wither) {
			event.ammount = 5;
		}
		
	} 
}
