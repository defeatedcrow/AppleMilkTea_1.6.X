package mods.applemilk.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.api.ItemAPI;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * 他MOD様のアイテムの収集・管理用クラス。
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
					System.out.println("[AppleMilk]Succeeded to get bakedApple");
				}
			}
			
			ItemStack api = ItemAPI.getItem("appleSandwich", 0);
			if (api != null) {
				System.out.println("[AppleMilk]Succeeded to get "+ api.getDisplayName() + ".");
			}
		}
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register ModItems");
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
					System.out.println("[AppleMilk]Succeeded to get Peach");
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
					System.out.println("[AppleMilk]Succeeded to get Grape");
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
					System.out.println("[AppleMilk]Succeeded to get Pineapple");
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
          System.out.println("[AppleMilk]Failed to register ModItems : GummiMod");
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
					System.out.println("[AppleMilk]Succeeded to get grcWine");
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
					System.out.println("[AppleMilk]Succeeded to get grcWineBucket");
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
          System.out.println("[AppleMilk]Failed to register ModItems : Growthcraft");
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
					System.out.println("[AppleMilk]Succeeded to get grcAle");
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
					System.out.println("[AppleMilk]Succeeded to get grcAleBucket");
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
          System.out.println("[AppleMilk]Failed to register ModItems : GrowthCraft");
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
					System.out.println("[AppleMilk]Succeeded to get grcSake");
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
					System.out.println("[AppleMilk]Succeeded to get grcSakeBucket");
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
          System.out.println("[AppleMilk]Failed to register ModItems : Growthcraft");
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
					System.out.println("[AppleMilk]Succeeded to get mapleSyrup");
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
		}
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register ModItems : mod_ecru_MapleTree_Forge");
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
