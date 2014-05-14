package mods.applemilk.event;

import java.util.ArrayList;
import java.util.Random;

import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.GenkotuHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EntityMoreDropEvent {
	
	@ForgeSubscribe
	public void EntityDropEvent(LivingDropsEvent event)
	{
		EntityLivingBase entity = event.entityLiving;
		DamageSource thisSource = event.source;
		ArrayList<EntityItem> items = event.drops;
		
		//以下、死んだモブの位置情報
		World world = entity.worldObj;
		double posX = entity.posX;
		double posY = entity.posY;
		double posZ = entity.posZ;
		
		if (thisSource instanceof EntityDamageSource)
		{
			EntityDamageSource entityDamage = (EntityDamageSource) thisSource;
			Entity destroyer = entityDamage.getEntity();
			
			/**
			 * EntityPlayerによる攻撃の時に判定する。
			 * 間接攻撃でも大丈夫だと思う
			 * */
			if (destroyer instanceof EntityPlayer)
			{
				int radenID = DCsAppleMilk.princessClam.itemID;
				EntityPlayer player = (EntityPlayer) destroyer;
				
				if (player.inventory.hasItemStack(new ItemStack(radenID, 1, 1)))
				{
					//まずは作ってみたリフレクションクラスで叩く
					ItemStack get = GenkotuHandler.getMobsDrop(entity);
					if (get != null && world.rand.nextInt(2) == 0)
					{
						AMTLogger.debugInfo("Genkotu!");
						world.spawnEntityInWorld(new EntityItem(world, posX, posY, posZ, get));
					}
//					else if (items != null && items.size() > 1 && world.rand.nextInt(2) == 0)
//					{
//						EntityItem item = items.get(world.rand.nextInt(items.size()));
//						ItemStack drops = item.getEntityItem().copy();
//						if (drops != null) AMTLogger.debugInfo("daden (item)");
//						world.spawnEntityInWorld(new EntityItem(world, posX, posY, posZ, drops));
//					}
				}
				
				if (player.inventory.hasItemStack(new ItemStack(radenID, 1, 2)))
				{
					AMTLogger.debugInfo("daden (exp)");
					int exp = 1 + world.rand.nextInt(5);//1~5
					world.spawnEntityInWorld(new EntityXPOrb(world, posX, posY, posZ, exp));
				}
			}
		}
	}

}
