package mods.applemilk.potion;

import mods.applemilk.api.potion.PotionReflexBase;
import mods.applemilk.common.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

/**
 * 当て身ポーション。
 * このポーションは効果時間中にダメージを受けると発動し、Amplifierが一段階下がる。
 * */
public class PotionReflex extends PotionReflexBase{
	
	public PotionReflex(int par1, boolean par2, int par3, boolean par4)
    {
        super(par1, par2, par3, par4);
    }
	
	@Override
	public boolean effectFormer(EntityLivingBase target, DamageSource source, int id, float amount)
	{
		boolean succeed = false;
		
		if (amount < 5.0F){
			amount = 5.0F;
		}
		
		if (id == DCsConfig.potionIDReflex)//反射
		{
			/* 攻撃元のエンティティがいない場合は何もしない*/
			if (source instanceof EntityDamageSource)
			{
				EntityDamageSource source2 = (EntityDamageSource) source;
				Entity attacker = source2.getEntity();
				
				if (attacker != null)
				{
					if (attacker instanceof EntityLivingBase)//生き物の時はダメージやノックバック処理を行う
					{
						EntityLivingBase livingAttacker = (EntityLivingBase) attacker;
						//ノックバック
						float range = livingAttacker.rotationYaw;
						livingAttacker.addVelocity(livingAttacker.motionX * (-1.0D) / (double)range, 0.1D, livingAttacker.motionZ * (-1.0D) / (double)range);
						//magic属性のダメージ
						livingAttacker.attackEntityFrom(DamageSource.magic, amount*2);
						//プレイヤーには鈴の音が聞こえる（暫定）
						target.worldObj.playSoundAtEntity(target, "applemilk:suzu", 1.0F, 1.2F);
						succeed = true;
					}
					else
					{
						//生き物でない場合はとりあえずsetDead
						attacker.setDead();
						target.worldObj.playSoundAtEntity(target, "applemilk:suzu", 1.0F, 1.2F);
						succeed = true;
					}
				}
				
			}
		}
		
		if (id == DCsConfig.potionIDAbsEXP)
		{
			if (target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) target;
				int get = Math.round(Math.abs(amount));
				player.addExperience(get);
				succeed = true;
			}
		}
		
		if (id == DCsConfig.potionIDAbsHeal)
		{
			if (target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) target;
				player.heal(amount*2);
				succeed = true;
			}
		}
		
		return succeed;
	}

}
