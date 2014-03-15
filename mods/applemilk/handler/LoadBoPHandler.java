package mods.applemilk.handler;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import biomesoplenty.api.Items;

public class LoadBoPHandler {
	
	public static ItemStack bopHoney;
	public static ItemStack bopBerry;
	
	public void load() {
		
		bopHoney = new ItemStack(Items.food.get(), 1, 9);
		bopBerry = new ItemStack(Items.food.get(), 1, 0);
		
		if (bopHoney != null) {
			System.out.println("[AppleMilk]Succeeded to get BoP honey");
			OreDictionary.registerOre("dropHoney", bopHoney);
			LoadModHandler.registerModItems("honey", bopHoney);
		}
		
		if (bopBerry != null) {
			System.out.println("[AppleMilk]Succeeded to get BoP berry");
			OreDictionary.registerOre("cropRaspberry", bopBerry);
			LoadModHandler.registerModItems("berry", bopBerry);
		}
	}

}
