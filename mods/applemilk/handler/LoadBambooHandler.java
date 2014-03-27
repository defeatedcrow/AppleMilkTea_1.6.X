package mods.applemilk.handler;

import java.util.ArrayList;

import mods.applemilk.common.AMTLogger;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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

}
