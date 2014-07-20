package mods.applemilk.event;

import java.util.Iterator;

import mods.applemilk.potion.PotionImmunity;
import mods.applemilk.api.potion.PotionImmunityBase;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;

public class DCsLivingEvent {
	
	private int remain = 0;//カウントダウン用
	private int type = 0;
	private static boolean remaining;
	
	@ForgeSubscribe
	  public void onLivingUpdate(LivingEvent.LivingUpdateEvent event)
	  {
		Entity entity = event.entity;
		
		//やっつけ仕事なので、プレイヤーを常時監視して、抵抗力ポーションが働いているかを見張っている
		if ((entity instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			if(player != null && !player.worldObj.isRemote)
			{
				//PotionEffectのリスト
				Iterator iterator = player.getActivePotionEffects().iterator();
				
				while (iterator.hasNext())
				{
					PotionEffect effect = (PotionEffect)iterator.next();
					
					int b = 256;
					int newID = effect.getPotionID();
					if (newID < 0)
					{
						newID = newID + b;
					}
					
					Potion potion = Potion.potionTypes[newID];
					int amp = effect.getAmplifier();
					int dur = effect.getDuration();
					
					if(potion != null && potion instanceof PotionImmunityBase)
					{
						PotionImmunityBase immunity = (PotionImmunityBase) potion;
						
						if (immunity.preventPotion(amp, immunity.id, player)) {
							AMTLogger.debugInfo("Succeeded to prevent bad status by PotionImmunity effect.");
						}
					}
				}
				
				if (this.remain > 0 && this.remaining)
				{
					this.remain--;
					
					if (this.remain == 0)
					{
						player.addChatMessage("remain : 0");
						this.remaining = false;
					}
				}
				
				if (!player.isEntityAlive())//生存確認
				{
					this.remain = 0;
					this.remaining = false;
				}
			}
		}
	  }
}
