package mods.applemilk.common;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class AddChestGen {
	
	public void addChestItems() {
		
		//追加したいチェストの種類を文字列で設定。ここでは村とジャングル寺院に追加する。
		String[] categoryA = new String[]{"villageBlacksmith", "pyramidJungleChest" };
		
		for (String category : categoryA)
		{
			//上記カテゴリーのお宝リストを取得
			ChestGenHooks dungeon = ChestGenHooks.getInfo(category);
			//addItemメソッドで新しいアイテムを追加
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.saplingTea),1,3,20));
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.rotaryDial),1,1,20));
		}
	}
	
}
