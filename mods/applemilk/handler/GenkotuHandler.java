package mods.applemilk.handler;

import java.lang.reflect.Method;

import mods.applemilk.common.AMTLogger;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**グーで殴る*/
public class GenkotuHandler {
	
	public static ItemStack getMobsDrop(EntityLivingBase entity)
	{
		Method method;
		ItemStack ret = null;
		if (entity instanceof EntityLiving)
		{
			EntityLiving living = (EntityLiving) entity;
			String packageName = entity.getClass().getName();
			
			try {
				method = entity.getClass().getDeclaredMethod("getDropItemId");
				method.setAccessible(true);
				Object obj = method.invoke(entity);
				if (obj != null && obj instanceof Integer)
				{
					int ID = (Integer)obj;
					if (ID > 0)
					{
						ret = new ItemStack(ID, 1, 0);
						AMTLogger.debugInfo("Item name : " + ret.getDisplayName());
					}
				}
				
			} catch (Exception e) {
				AMTLogger.info("Failed to get drop : " + entity.getEntityName());
				return null;
			}
		}
		return ret;
	}

}
