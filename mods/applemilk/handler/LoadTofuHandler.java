package mods.applemilk.handler;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class LoadTofuHandler {
	
	public static Item tofuKinu;
	public static Item backetTounyu;
	public static Item negi;

	public void load() {
		
		//ここでもOreDicの機能でアイテムを取得しているので、専用クラスにする意味は薄い。
		//強いて言えば、豆腐クラフト様の未導入時に間違って読み込んでしまうミスを減らす程度か。
		ArrayList<ItemStack> kinu = OreDictionary.getOres("tofuKinu");
		ArrayList<ItemStack> tounyu = OreDictionary.getOres("bucketSoymilk");
		ArrayList<ItemStack> naganegi = OreDictionary.getOres("leek");
		
		if (kinu.size() > 0){
			tofuKinu = kinu.get(0).getItem();
			if (tofuKinu != null) System.out.println("[AppleMilk]Succeeded to get tofuKinu.");
		}
		if (tounyu.size() > 0){
			backetTounyu = tounyu.get(0).getItem();
			if (backetTounyu != null) System.out.println("[AppleMilk]Succeeded to get bucketSoyMilk.");
		}
		if (naganegi.size() > 0){
			negi = naganegi.get(0).getItem();
			if (negi != null) System.out.println("[AppleMilk]Succeeded to get leek.");
		}
	}
	
	

}
