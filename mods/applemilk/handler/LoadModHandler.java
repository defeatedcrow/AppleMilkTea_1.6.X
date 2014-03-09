package mods.applemilk.handler;

import java.util.HashMap;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.api.ItemAPI;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class LoadModHandler {
	
	private static HashMap<String, ItemStack> modItems = new HashMap<String, ItemStack>();
	
	public void loadAppleMilk() //動作確認用
	{
		try
		{
			Item item = Util.getModItem("DCsAppleMilk", "defeatedcrow.bakedApple");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("DCsBakedApple", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get bakedApple.");
				}
			}
			
			ItemStack api = ItemAPI.getItem("appleSandwich", 0);
			if (api != null) {
				System.out.println("[AppleMilk]Succeeded to get "+ api.getDisplayName() + ".");
			}
		}
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register ModItems.");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGummi()//GummiMod様のアイテムを読み込む
	{
		try
		{
			Item item = Util.getModItem("AndanteMod_Gummi", "Peach");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("gummiPeach", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get gummiPeach.");
				}
			}
			Item item2 = Util.getModItem("AndanteMod_Gummi", "Grape");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 0);
				if (this.registerModItems("gummiGrape", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get gummiGrape.");
				}
			}
			
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
			    		  new ItemStack(item, 1)
						 }));
			
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 8),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
			    		  new ItemStack(item2, 1)
						 }));
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
			Item item = Util.getModItem("GrowthCraft|Grapes", "grc.grapeWine");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("grcWine", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcWine.");
				}
			}
			Item item2 = Util.getModItem("GrowthCraft|Grapes", "grc.grapeWine_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 0);
				if (this.registerModItems("grcWineBucket", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcWineBucket.");
				}
			}
			
			//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 19),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item, 1, 32767)
						 }));
			
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 51),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item2, 1, 32767)
						 }));
		}
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register ModItems : GrowthCraft");
          e.printStackTrace(System.err);
        }
	}
	
	public void loadGrowthHops()//GrowthCraft様のアイテムを読み込む。
	{
		try
		{
			Item item = Util.getModItem("GrowthCraft|Hops", "grc.hopAle");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("grcAle", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcAle.");
				}
			}
			Item item2 = Util.getModItem("GrowthCraft|Hops", "grc.hopAle_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 0);
				if (this.registerModItems("grcAleBucket", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcAleBucket.");
				}
			}
			
			//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 18),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item, 1, 32767)
						 }));
			
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 50),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item2, 1, 32767)
						 }));
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
			Item item = Util.getModItem("GrowthCraft|Rice", "grc.riceSake");
			if (item != null) {
				ItemStack registerItem = new ItemStack(item, 1, 0);
				if (this.registerModItems("grcSake", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcSake.");
				}
			}
			Item item2 = Util.getModItem("GrowthCraft|Rice", "grc.riceSake_bucket");
			if (item2 != null) {
				ItemStack registerItem = new ItemStack(item2, 1, 0);
				if (this.registerModItems("grcSakeBucket", registerItem)) {
					System.out.println("[AppleMilk]Succeeded to get grcSakeBucket.");
				}
			}
			
			//当MODのビンに一旦詰める。ガラス瓶は残量2、バケツ入りは残量4になる。
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 17),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item, 1, 32767)
						 }));
			
			GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 49),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
			    		  new ItemStack(item2, 1, 32767)
						 }));
		}
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register ModItems : GrowthCraft");
          e.printStackTrace(System.err);
        }
	}
	
	/**
     * Stringを引数にしてアイテムを取得。
     * Stringは他MOD様とは無関係な当MOD専用の登録名。
     */
	public static ItemStack getItem(String name)
	{
		ItemStack ret = modItems.get(name);
		if (ret != null) return ret;
		else return (ItemStack)null;
	}
	
	/**
     * 内部でのみ使用。すでにID登録したインプットの二重登録を禁止するためのもの。
     */
	private static boolean dupe(String name)
	{
		ItemStack val = modItems.get(name);
		if (val != null) return true;
		else return false;
	}
	
	/**
     * HashMapに突っ込む。
     */
	private static boolean registerModItems(String name, ItemStack item)
	{
		if (name != null && item != null && !dupe(name))
		{
			modItems.put(name, item);
			return true;
		}
		return false;
	}

}
