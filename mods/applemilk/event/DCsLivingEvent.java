package mods.applemilk.event;

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
					PotionEffect potion = player.getActivePotionEffect(DCsAppleMilk.Immunization);
					//かかっているポーション効果のレベル
					int amp = potion.getAmplifier();
					
					if(potion != null && amp == 0)
					{
						//レベル0の時
						//食あたりに掛かったのを検知すると食あたりを消す
						if(player.isPotionActive(Potion.hunger))
						{
							player.removePotionEffect(Potion.hunger.id);
						}
					}
					else if (potion != null && amp == 1)
					{
						//レベル1の時
						//同じことを毒とウィザーで行う
						if(player.isPotionActive(Potion.poison))
						{
							player.removePotionEffect(Potion.poison.id);
						}
						if(player.isPotionActive(Potion.wither))
						{
							player.removePotionEffect(Potion.wither.id);
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
