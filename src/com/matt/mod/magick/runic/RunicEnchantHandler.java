package com.matt.mod.magick.runic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.matt.generic.helpers.EntityPlayerHelper;
import com.matt.mod.magick.ArmorHelper;

public class RunicEnchantHandler {
	@ForgeSubscribe
	public void onLivingHurtEvent(LivingHurtEvent event)
	{
		LivingEvent e = (LivingEvent)event;
		if(e.entity instanceof EntityPlayer) {
			try {
			if(EntityPlayerHelper.isArmorEquipped((EntityPlayer)e.entity,ArmorHelper.manaChest.itemID,2))  {
			{
				System.out.println("Has armor!");
				if(event.source == DamageSource.inFire) {
					event.ammount-=5;
				}else if(event.source == DamageSource.magic) {
					event.ammount-=10;
				}else if(event.source == DamageSource.wither) {
					event.ammount = 5;
				}
			
		}
			}
			}catch(Throwable t) {
				t.printStackTrace();
			}
		
		
	} 
	}
}


