package mods.applemilk.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.api.ItemAPI;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * 他MOD様のアイテムの収集・管理用クラス。
 * FMLのfindItem、又はリフレクションを使用する場合はここに集める。
 * 各ModのAPI、あるいは単に鉱石辞書を使う場合は別のクラスを使う。
 */
public class LoadModHandler {
	
	//ArrayList型に変更。複数のModのアイテムを共通名で管理するため。
	private static HashMap<String, ArrayList<ItemStack>> modItems = new HashMap<String, ArrayList<ItemStack>>();
	
	private static Random rand = new Random();
	
	public void loadAppleMilk() //動作確認用
	{
		try
		{
			Item item = Util.getModItem("DCsAppleMilk", "defeatedcrow.bakedApple");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("DCsBakedApple", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get bakedApple");
				}
			}
			
			ItemStack api = ItemAPI.getItem("appleSandwich", 0);
			if (api != null) {
				AMTLogger.debugInfo("Succeeded to get " + api.getDisplayName());
			}
		}
        catch (Exception e) {
          AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGummi()//GummiMod様のアイテムを読み込む
	{
		try
		{
			Item item = Util.getModItem("AndanteMod_Gummi", "Gummi:Peach");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("peach", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get peach");
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
				    		  new ItemStack(item, 1)
							 }));
			}
			Item item2 = Util.getModItem("AndanteMod_Gummi", "Gummi:Grape");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 0);
				if (this.registerModItems("grape", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grape");
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 8),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
				    		  new ItemStack(item2, 1)
							 }));
			}
			Item item3 = Util.getModItem("AndanteMod_Gummi", "Gummi:Pineapple");
			if (item3 != null) {
				ItemStack registerItem = new ItemStack(item3, 1, 0);
				if (this.registerModItems("pineapple", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get pineapple");
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
				    		  new ItemStack(item3, 1)
							 }));
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.cocktail, 1, 6),
			    		  new Object[]{
			    			  "bottleRum",
				    		  new ItemStack(item3, 1),
				    		  "cropCoconut",
				    		  "foodCrushedIce"
							 }));
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.cocktail, 1, 6),
			    		  new Object[]{
			    			  "bottleRum",
				    		  new ItemStack(item3, 1),
				    		  new ItemStack(Item.bucketMilk, 1),
				    		  "foodCrushedIce"
							 }));
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGrowthGrape()//GrowthCraft様のアイテムを読み込む。
	{
		try
		{
			Item item = Util.getModItem("Growthcraft|Grapes", "grc.grapeWine");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 1);
				if (this.registerModItems("smallWine", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc wine");
				}
				
				//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 19),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item, 1, 32767)
							 }));
			}
			Item item2 = Util.getModItem("Growthcraft|Grapes", "grc.grapeWine_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 1);
				if (this.registerModItems("drinkWine", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc wine bucket");
					this.registerModItems("bucketWine", registerItem);
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 51),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item2, 1, 32767)
							 }));
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGrowthHops()//GrowthCraft様のアイテムを読み込む。
	{
		try
		{
			Item item = Util.getModItem("Growthcraft|Hops", "grc.hopAle");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 1);
				if (this.registerModItems("smallBeer", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc ale");
				}
				
				//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 18),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item, 1, 32767)
							 }));
			}
			Item item2 = Util.getModItem("Growthcraft|Hops", "grc.hopAle_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 1);
				if (this.registerModItems("drinkBeer", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc ale bucket");
					this.registerModItems("bucketBeer", registerItem);
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 50),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item2, 1, 32767)
							 }));
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGrowthRice()//GrowthCraft様のアイテムを読み込む。
	{
		try
		{
			Item item = Util.getModItem("Growthcraft|Rice", "grc.riceSake");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 1);
				if (this.registerModItems("smallSake", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc sake");
				}
				
				//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 17),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item, 1, 32767)
							 }));
			}
			Item item2 = Util.getModItem("Growthcraft|Rice", "grc.riceSake_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 1);
				if (this.registerModItems("drinkSake", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get grc sake bucket");
					this.registerModItems("bucketSake", registerItem);
				}
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 49),
			    		  new Object[]{
			    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				    		  new ItemStack(item2, 1, 32767)
							 }));
			}	
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadMaple() { //モミジMOD様のアイテム。
		
		try
		{
			//Gameregistry.registerItem()を通していない場合FMLの機能が使えないため、仕方なしにリフレクションで殴っている
			//Item item = Util.getModItem("mod_ecru_MapleTree_Forge", "mapletree:mapleSyrup");
			Object obj = Class.forName("ecru.MapleTree.mod_ecru_MapleTree").getField("Item_mapleSyrup").get(null);
			if (obj instanceof Item) {
				ItemStack registerItem = new ItemStack((Item)obj, 1, 0);
				if (this.registerModItems("maple", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get maplesyrup");
				}
				
				GameRegistry.addRecipe(
						 new ShapedOreRecipe(
			    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 11)),
			    		  new Object[]{
								 "XXX",
								 "XZX",
								 "XXX",
								 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
								 Character.valueOf('X'), registerItem}));
			}
			Object obj2 = Class.forName("ecru.MapleTree.mod_ecru_MapleTree").getField("mapleWood").get(null);
			if (obj2 instanceof Block) {
				Block maplewood = (Block)obj2;
				ItemStack registerItem2 = new ItemStack(maplewood.blockID, 1, 0);
				if (this.registerModItems("mapleWood", registerItem2)) {
					AMTLogger.debugInfo("Succeeded to get mapleWood");
				}
				
				GameRegistry.addRecipe(
						 new ShapedOreRecipe(
			    		  new ItemStack(DCsAppleMilk.woodBox, 1, 9),
			    		  new Object[]{
								 "XXX",
								 "XXX",
								 "XXX",
								 Character.valueOf('X'), registerItem2}));
				
				GameRegistry.addRecipe(
						 new ShapelessOreRecipe(
								 new ItemStack(maplewood.blockID, 9, 0),
			    		  new Object[]{
						  new ItemStack(DCsAppleMilk.woodBox, 1, 9)
							 }));
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadSugi()//SugiForest様の杉
	{
		try
		{
			Block block = Util.getModBlock("kegare.sugiforest", "woodSugi");
			if (block != null)
			{
				ItemStack registerItem = new ItemStack(block, 1, 0);
				if (this.registerModItems("sugiWood", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get woodSugi");
				}
				
				if (registerItem != null)
				{
					GameRegistry.addRecipe(
							 new ShapedOreRecipe(
				    		  new ItemStack(DCsAppleMilk.woodBox, 1, 10),
				    		  new Object[]{
									 "XXX",
									 "XXX",
									 "XXX",
									 Character.valueOf('X'), registerItem}));
					
					GameRegistry.addRecipe(
							 new ShapelessOreRecipe(
									 new ItemStack(block, 9, 0),
				    		  new Object[]{
							  new ItemStack(DCsAppleMilk.woodBox, 1, 10)
								 }));
				}
			}
		}
		catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadForce()//DartCraft様のアイテム取得
	{
		try
		{
			Block block = Util.getModBlock("DartCraft", "forceLog");
			if (block != null)
			{
				ItemStack registerItem = new ItemStack(block, 1, 0);
				if (this.registerModItems("forceWood", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get forceLog");
				}
				
				if (registerItem != null)
				{
					GameRegistry.addRecipe(
							 new ShapedOreRecipe(
				    		  new ItemStack(DCsAppleMilk.woodBox, 1, 7),
				    		  new Object[]{
									 "XXX",
									 "XXX",
									 "XXX",
									 Character.valueOf('X'), registerItem}));
					
					GameRegistry.addRecipe(
							 new ShapelessOreRecipe(
									 new ItemStack(block, 9, 0),
				    		  new Object[]{
							  new ItemStack(DCsAppleMilk.woodBox, 1, 7)
								 }));
				}
			}
		}
		catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadExtraTrees() { //ExtraTree様のアイテム。
		
		try
		{
			Object obj = Class.forName("binnie.extratrees.ExtraTrees").getField("itemFood").get(null);
			//binniemods様の食材アイテムは同じIDでメタデータ違いなので、メタデータ毎に取得。
			if (obj instanceof Item) {
				Item item = (Item) obj;
				
				ItemStack cassis = new ItemStack(item, 1, 41);
				if (this.registerModItems("binnieCassis", cassis)) {
					OreDictionary.registerOre("cropCassis", cassis);
				}
				ItemStack black = new ItemStack(item, 1, 43);
				if (this.registerModItems("binnieBlackberry", black)) {
					OreDictionary.registerOre("cropBlackberry", black);
				}
				ItemStack rasp = new ItemStack(item, 1, 44);
				if (this.registerModItems("binnieRasp", rasp)) {
					OreDictionary.registerOre("cropRaspberry", rasp);
				}
				ItemStack blue = new ItemStack(item, 1, 45);
				if (this.registerModItems("binnieBlue", blue)) {
					OreDictionary.registerOre("cropBlueberry", blue);
				}
				ItemStack cran = new ItemStack(item, 1, 46);
				if (this.registerModItems("binnieCran", cran)) {
					OreDictionary.registerOre("cropCranberry", cran);
				}
				ItemStack coco = new ItemStack(item, 1, 50);
				if (this.registerModItems("binnieCoco", coco)) {
					OreDictionary.registerOre("cropCoconut", coco);
				}
				ItemStack chili = new ItemStack(item, 1, 55);
				if (this.registerModItems("binnieChili", chili)) {
					OreDictionary.registerOre("cropChilipepper", chili);
				}
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
		
	}
	
	public void loadWa() { //和風MOD様のアイテム。
		
		try
		{
			//Gameregistry.registerItem()を通していない場合FMLの機能が使えないため、仕方なしにリフレクションで殴っている。(二回目)
			Object obj = Class.forName("wa.Items").getField("梅の実").get(null);
			if (obj instanceof Item) {
				ItemStack registerItem = new ItemStack((Item)obj, 1, 0);
				if (this.registerModItems("plum", registerItem)) {
					AMTLogger.debugInfo("Succeeded to get wa_plum");
				}
				//まずは辞書登録
				OreDictionary.registerOre("cropPlum", registerItem);
			}
			Object obj2 = Class.forName("wa.Items").getField("米").get(null);
			if (obj2 instanceof Item) {
				Item rice = (Item)obj2;
				ItemStack registerItem2 = new ItemStack(rice, 1, 0);
				if (this.registerModItems("rice", registerItem2)) {
					AMTLogger.debugInfo("Succeeded to get wa_rice");
				}
				OreDictionary.registerOre("cropRice", registerItem2);
			}
		}
        catch (Exception e) {
        	AMTLogger.debugInfo("Failed to register ModItems");
          e.printStackTrace(System.err);
        }
	}
	
	/**
     * Stringを引数にしてアイテムを取得。
     * Stringは他MOD様とは無関係な当MOD専用の登録名。
     * 失敗時にはnullを返す。
     */
	public static ItemStack getItem(String name)
	{
		ArrayList<ItemStack> ret = modItems.get(name);
		if (ret != null && !ret.isEmpty()) return ret.get(0);
		else return (ItemStack)null;
	}
	
	/**
     * Stringを引数にしてアイテムを取得。
     * Stringは他MOD様とは無関係な当MOD専用の登録名。
     * 失敗時にはnullを返す。
     */
	public static ArrayList<ItemStack> getArray(String name)
	{
		ArrayList<ItemStack> ret = modItems.get(name);
		if (ret != null && !ret.isEmpty()) return ret;
		else return null;
	}
	
	/**
     * Stringを引数にしてアイテムを取得。
     * こちらは登録されたItemStackのうち一つをランダムに返す。
     * 失敗時にはnullを返す。
     */
	public static ItemStack getRandomItem(String name)
	{
		ArrayList<ItemStack> ret = modItems.get(name);
		if (ret != null && !ret.isEmpty()) {
			int random = rand.nextInt(ret.size());
			return ret.get(random);
		}
		else return (ItemStack)null;
	}
	
	/**
     * Stringを引数にしてアイテムを取得し、
     * targetのアイテムと同一かどうかを返すメソッド。
     * 登録済みアイテムのいずれかと一致すればtrueを返す。
     */
	public static boolean matchItem(String name, ItemStack target)
	{
		ArrayList<ItemStack> ret = modItems.get(name);
		boolean flag = false;
		
		if (ret == null || ret.isEmpty()) return false;
		
		for (ItemStack items : ret)
		{
			if (items.itemID == target.itemID && (items.getItemDamage() == target.getItemDamage())) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	/**
     * このクラスのHashMapを使って他MOD様のアイテムを独自名に紐付け、一括管理する。
     * OreDictionaryのみでは右クリック時の取得メソッドが煩雑になるため。
     * @param name 独自名
     * @param item　登録対象
     */
	public static boolean registerModItems(String name, ItemStack item)
	{
		if (name != null && item != null)
		{
			ArrayList<ItemStack> list = modItems.get(name);
			if (list != null) {
				list.add(item.copy());
				modItems.put(name, list);
			}
			else {
				ArrayList<ItemStack> val = new ArrayList<ItemStack>();
				val.add(item.copy());
				modItems.put(name, val);
			}
			return true;
		}
		return false;
	}
	
	/**
     * このクラスのHashMapを使って他MOD様のアイテムを独自名に紐付け、一括管理する。
     * ArrayList型で登録する場合に使用するメソッド。
     * @param name 独自名
     * @param newList　登録対象
     */
	public static boolean registerArray(String name, ArrayList<ItemStack> newList)
	{
		if (name != null && !newList.isEmpty())
		{
			ArrayList<ItemStack> list = modItems.get(name);
			if (list != null) {
				list.addAll(newList);
				modItems.put(name, list);
			}
			else {
				ArrayList<ItemStack> val = new ArrayList<ItemStack>();
				val.addAll(newList);
				modItems.put(name, val);
			}
			return true;
		}
		return false;
	}

}
