package mods.applemilk.event;

import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import mods.applemilk.common.block.*;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class DCsBonemealEvent
{
	@ForgeSubscribe
	public void useBoneMeal(BonemealEvent event)
	{
		int id = event.world.getBlockId(event.X, event.Y, event.Z);
		if(id == DCsConfig.blockIdCropMint)
		{
			if(((BlockMintCrop)DCsAppleMilk.cropMint).fertilize(event.world, event.X, event.Y, event.Z))
			{
				event.setResult(Result.ALLOW);
			}
		}
		else if (id == DCsConfig.blockIdTreeC)
		{
			if(((BlockCassisTree)DCsAppleMilk.cassisTree).fertilize(event.world, event.X, event.Y, event.Z))
			{
				event.setResult(Result.ALLOW);
			}
		}
		else if (id == DCsConfig.blockIdSapT)
		{
			if(((BlockSaplingTea)DCsAppleMilk.saplingTea).fertilize(event.world, event.X, event.Y, event.Z))
			{
				event.setResult(Result.ALLOW);
			}
		}
	}
 
}
