package mods.applemilk.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.common.AMTLogger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class LoadFFMHandler {
	
	public void load()
	{
		ItemStack item = new ItemStack(Util.getModItem("Forestry", "waxCapsule"), 1);
		if (item != null) {
			ItemStack register = new ItemStack(item.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("emptyCapsule", register);
			}
		}
		ItemStack item2 = new ItemStack(Util.getModItem("Forestry", "refractoryEmpty"), 1);
		if (item2 != null) {
			ItemStack register = new ItemStack(item2.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("emptyRefractory", register);
			}
		}
		ItemStack item3 = new ItemStack(Util.getModItem("Forestry", "canEmpty"), 1);
		if (item3 != null) {
			ItemStack register = new ItemStack(item3.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("emptyCan", register);
			}
		}
		ItemStack item4 = new ItemStack(Util.getModItem("Forestry", "waxCapsuleWater"), 1);
		if (item4 != null) {
			ItemStack register = new ItemStack(item4.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("waterCapsule", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water capsule");
				}
			}
		}
		ItemStack item5 = new ItemStack(Util.getModItem("Forestry", "refractoryWater"), 1);
		if (item5 != null) {
			ItemStack register = new ItemStack(item5.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("waterRefractory", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water refractory");
				}
			}
		}
		ItemStack item6 = new ItemStack(Util.getModItem("Forestry", "waterCan"), 1);
		if (item6 != null) {
			ItemStack register = new ItemStack(item6.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("waterCan", register);
				if (LoadModHandler.registerModItems("containerWater", register)) {
					AMTLogger.debugInfo("Succeeded to get Forestry water can");
				}
			}
		}
		ItemStack item7 = new ItemStack(Util.getModItem("Forestry", "honeyedSlice"), 1);
		if (item7 != null) {
			ItemStack register = new ItemStack(item7.getItem());
			if (register != null) {
				LoadModHandler.registerModItems("honeyedSlice", register);
				GameRegistry.addRecipe(
						 new ShapedOreRecipe(
			    		  new ItemStack(register.getItem(), 4, register.getItemDamage()),
			    		  new Object[]{"XXX","XYX","XXX",
			    			  Character.valueOf('Y'), new ItemStack(Item.bread, 1, 0),
			    			  Character.valueOf('X'), "dropHoney"}));
			}
		}
	}

}
