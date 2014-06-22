package mods.applemilk.event;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import mods.applemilk.potion.*;
import mods.applemilk.api.potion.PotionReflexBase;
import mods.applemilk.common.AMTLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class DCsHurtEvent {
	
	@ForgeSubscribe
	public void onHurtEvent(LivingHurtEvent event)
	{
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;
		
		boolean canPrevent = false;
		int reduceAmp = 0;
		
		//遠隔クライアントサイドでは何もしない
		if (target != null && !target.worldObj.isRemote)
		{
			//PotionEffectのリスト
			Iterator iterator = target.getActivePotionEffects().iterator();
			
			while (iterator.hasNext())
			{
				PotionEffect effect = (PotionEffect)iterator.next();
				Potion potion = Potion.potionTypes[effect.getPotionID()];
				int amp = effect.getAmplifier();
				int dur = effect.getDuration();
				
				//その1：無効化ポーションの時
				//無効化ポーションは、APIを作っていない
				if (potion instanceof PotionProtectionEX)
				{
					PotionProtectionEX potionEX = (PotionProtectionEX) potion;
					
					if (potionEX.getAllProtection()) canPrevent = true;//Allなら無条件でダメージを無くす
					else if (potionEX.getExplodeProtection())//爆発無効。
					{
						canPrevent = (source.isExplosion() || source == DamageSource.anvil);
					}
					else if (potionEX.getProjProtection())//飛び道具無効。magic属性も遠隔攻撃とみなす。
					{
						if (source instanceof EntityDamageSource)
						{
							if (source instanceof EntityDamageSourceIndirect)
							{
								canPrevent = true;
							}
							else if (source.isProjectile() || source.isMagicDamage())
							{
								canPrevent = true;
							}
						}
					}
					
					//その他、DamageSource名指しで設定した無効化条件
					if (potionEX.getPreventSource() == source)
					{
						canPrevent = true;
					}
				}
				
				//その2：反射ポーションのとき
				if (potion instanceof PotionReflexBase)
				{
					PotionReflexBase reflex = (PotionReflexBase) potion;
					if (reflex.effectFormer(target, source, reflex.getId(), damage))//反射処理に成功した時
					{
						reduceAmp = reflex.getId();
						canPrevent = true;
					}
				}
				
				//せっかくなので、ジャンプ力増加ポーション効果で落下ダメージを受けるのをなくすことにした
				if (potion.id == potion.jump.id && source == DamageSource.fall)
				{
					canPrevent = true;
				}
			}
			
			if (canPrevent)//無効化成功フラグが立ったらダメージが無効化される。
			{
				AMTLogger.debugInfo("potioneffect cancel huet event.");
				event.ammount = 0.0F;
				event.setCanceled(true);
			}
			
			if (reduceAmp > 0)//Amplifierを減らす処理を、while処理の中から外に出した
			{
				PotionEffect potion = target.getActivePotionEffect(Potion.potionTypes[reduceAmp]);
				target.removePotionEffect(reduceAmp);
				if (potion != null && potion.getAmplifier() > 0){
					target.addPotionEffect(new PotionEffect(reduceAmp, potion.getDuration(), (potion.getAmplifier() - 1)));
				}
			}
			
		}
	}

}
