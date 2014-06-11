package mods.applemilk.event;

import mods.applemilk.potion.PotionImmunity;
import mods.applemilk.api.potion.PotionImmunityBase;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
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
			
			if(player != null)
			{
				if(player.isPotionActive(DCsAppleMilk.Immunization))
				{
					//プレイヤーに現在かかっているポーション効果
					PotionEffect effect = player.getActivePotionEffect(DCsAppleMilk.Immunization);
					//かかっているポーション効果のレベル
					int amp = effect.getAmplifier();
					Potion potion = Potion.potionTypes[effect.getPotionID()];
					
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
