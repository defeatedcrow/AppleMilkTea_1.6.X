package mods.applemilk.handler;

import java.util.HashMap;

import mods.applemilk.api.ItemAPI;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
