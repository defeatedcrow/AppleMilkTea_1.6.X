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
          System.out.println("[AppleMilk]Failed to register ModItems.");
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
