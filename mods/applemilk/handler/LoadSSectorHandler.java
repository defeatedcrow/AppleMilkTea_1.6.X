package mods.applemilk.handler;

import java.util.ArrayList;

import sextiarysector.stats.EntityPlayerManager;
import mods.applemilk.api.IceRecipe;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadSSectorHandler {
	
	public static ItemStack sakeBottle;
	public static ItemStack rumBottle;
	public static ItemStack ginBottle;
	public static ItemStack beerBottle;
	public static ItemStack emptyBottle;
	
	public void load()
	{
		ArrayList<ItemStack> sake = OreDictionary.getOres("drinkSake");
		ArrayList<ItemStack> rum = OreDictionary.getOres("drinkRum");
		ArrayList<ItemStack> gin = OreDictionary.getOres("drinkGin");
		ArrayList<ItemStack> beer = OreDictionary.getOres("drinkBeer");
		ArrayList<ItemStack> bottle = OreDictionary.getOres("craftingBottle");
		
		if (sake.size() > 0){
			sakeBottle = sake.get(0);
			if (sakeBottle != null) {
				LoadModHandler.registerModItems("drinkSake", new ItemStack(sakeBottle.itemID, 1, 0));
			}
		}
		if (rum.size() > 0){
			rumBottle = rum.get(0);
			if (rumBottle != null) {

				LoadModHandler.registerModItems("drinkRum", new ItemStack(rumBottle.itemID, 1, 0));
			}
		}
		if (gin.size() > 0){
			ginBottle = gin.get(0);
			if (ginBottle != null) {
				LoadModHandler.registerModItems("drinkGin", new ItemStack(ginBottle.itemID, 1, 0));
			}
		}
		if (beer.size() > 0){
			beerBottle = beer.get(0);
			if (beerBottle != null) {
				LoadModHandler.registerModItems("drinkBeer", new ItemStack(beerBottle.itemID, 1, 0));
			}
		}
		if (bottle.size() > 0){
			emptyBottle = bottle.get(0);
			if (emptyBottle != null) {
			}
		}

	}
	
	public static void addStatus(int par1, float par2, int par3, float par4, EntityPlayer par5EntityPlayer)
	{
		int prevMoist = EntityPlayerManager.getMoistureStats(par5EntityPlayer).getMoistureLevel();
		float prevSatMoist = EntityPlayerManager.getMoistureStats(par5EntityPlayer).getSaturationLevel();
		int prevStam = EntityPlayerManager.getStaminaStats(par5EntityPlayer).getStaminaLevel();
		float prevSatStam = EntityPlayerManager.getStaminaStats(par5EntityPlayer).getSaturationLevel();
		boolean flag1 = false;
		boolean flag2 = false;
		
		int m = prevMoist + par1 < 0 ? 0 : par1;
		float ms = prevSatMoist + par2 < 0 ? 0 : par2;
		int s = prevStam + par3 < 0 ? 0 : par3;
		float ss = prevSatStam + par4 < 0 ? 0 : par4;
		
		if (!par5EntityPlayer.worldObj.isRemote && DCsAppleMilk.allowMoisture)
		{
			EntityPlayerManager.getMoistureStats(par5EntityPlayer).addStats(m, ms);
			EntityPlayerManager.getStaminaStats(par5EntityPlayer).addStats(s, ss);
		}
		
	}

}
