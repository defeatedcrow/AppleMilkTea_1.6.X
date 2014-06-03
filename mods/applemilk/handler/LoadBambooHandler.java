package mods.applemilk.handler;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class LoadBambooHandler {
	
	public static Item bambooBasket;
	public static Item bambooMugimeshi;

	public void load() {
		
		//やっていることはOreDictionaryから辞書登録名で検索してくるだけ
		//なので本当は、竹MOD様のロードを確認しなくてもエラーは起こらない
		ArrayList<ItemStack> basket = OreDictionary.getOres("bambooBasket");
		ArrayList<ItemStack> mugimeshi = OreDictionary.getOres("wheatRice");
		
		if (basket.size() > 0){
			bambooBasket = basket.get(0).getItem();
		}
		if (mugimeshi.size() > 0){
			bambooMugimeshi = mugimeshi.get(0).getItem();
		}
	}
	
	//専用クラスにお引っ越し
	public void loadBambooItems()//BambooMod様のアイテムのうち、鉱石辞書登録されていないものはココを使う
	{
		try
		{
			Item item = Util.getModItem("BambooMod", "BambooMod:rawrice");
			Object obj = Class.forName("ruby.bamboo.BambooInit").getField("rawriceIID").get(null);
			AMTLogger.debugInfo("Current get Number : " + obj.toString());
			if (obj != null && obj instanceof Integer ) {
				ItemStack registerItem = new ItemStack((Integer)obj, 1, 0);
				if (LoadModHandler.registerModItems("rice", registerItem)) {
					OreDictionary.registerOre("cropRice", registerItem);
					OreDictionary.registerOre("cookingRice", registerItem);
					AMTLogger.debugInfo("Succeeded to get rawrice");
				}
			}
//			Item item2 = Util.getModItem("BambooMod", "bamboo:straw");
			Object obj2 = Class.forName("ruby.bamboo.BambooInit").getField("strawIID").get(null);
			AMTLogger.debugInfo("Current get Number : " + obj2.toString());
			if (obj2 != null && obj2 instanceof Integer) {
//			if (item2 != null) {
				ItemStack registerItem2 = new ItemStack((Integer)obj2, 1, 0);
				if (LoadModHandler.registerModItems("straw", registerItem2)) {
					OreDictionary.registerOre("cropStraw", registerItem2);
					AMTLogger.debugInfo("Succeeded to get straw");
					
					GameRegistry.addRecipe(
						 new ItemStack(DCsAppleMilk.Basket, 1),
						 new Object[]{
							 "X X",
							 "X X",
							 "XXX",
							 Character.valueOf('X'), registerItem2
						 });
				}
			}
			Item item3 = Util.getModItem("BambooMod", "decoCarpet");
			if (item3 != null) {
				ItemStack registerItem3 = new ItemStack(item3, 1, 0);
				if (LoadModHandler.registerModItems("strawCarpet", registerItem3)) {
					AMTLogger.debugInfo("Succeeded to get decoCarpet");
				}
				
				if (LoadModHandler.getItem("straw") != null)
				{
					GameRegistry.addRecipe(
							 registerItem3,
							 new Object[]{
								 "XXX",
								 Character.valueOf('X'), LoadModHandler.getItem("straw")
							 });
				}
			}
			Item item4 = Util.getModItem("BambooMod", "sakuraLog");
			if (item4 != null) {
				ItemStack registerItem4 = new ItemStack(item4, 1, 0);
				if (LoadModHandler.registerModItems("sakuraWood", registerItem4)) {
					AMTLogger.debugInfo("Succeeded to get sakuraLog");
				}
				
				if (registerItem4 != null)
				{
					GameRegistry.addRecipe(
							 new ShapedOreRecipe(
				    		  new ItemStack(DCsAppleMilk.woodBox, 1, 8),
				    		  new Object[]{
									 "XXX",
									 "XXX",
									 "XXX",
									 Character.valueOf('X'), registerItem4}));
					
					GameRegistry.addRecipe(
							 new ShapelessOreRecipe(
									 new ItemStack(item4, 9, 0),
				    		  new Object[]{
							  new ItemStack(DCsAppleMilk.woodBox, 1, 8)
								 }));
				}
			}
			Item item5 = Util.getModItem("BambooMod", "campfire");
			if (item5 != null) {
				ItemStack registerItem5 = new ItemStack(item5, 1, 0);
				if (LoadModHandler.registerModItems("furneceBlock", registerItem5)) {
					AMTLogger.debugInfo("Succeeded to get campfire");
				}
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}

}
