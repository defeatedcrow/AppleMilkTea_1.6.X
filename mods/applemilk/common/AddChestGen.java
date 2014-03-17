package mods.applemilk.common;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class AddChestGen {
	
	public void addChestItems() {
		
		//追加したいチェストの種類を文字列で設定。ここでは村とジャングル寺院に追加する。
		String[] categoryA = new String[]{"villageBlacksmith", "pyramidJungleChest" };
		String[] categoryB = new String[]{"strongholdCorridor", "strongholdCrossing" };
		
		for (String category : categoryA)
		{
			//上記カテゴリーのお宝リストを取得
			ChestGenHooks dungeon = ChestGenHooks.getInfo(category);
			//addItemメソッドで新しいアイテムを追加
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.saplingTea),1,3,20));
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.rotaryDial),1,1,10));
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 3),1,1,10));
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 2),1,1,10));
			dungeon.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),1,1,20));
		}
		
		for (String category : categoryB)
		{
			//上記カテゴリーのお宝リストを取得
			ChestGenHooks dungeon2 = ChestGenHooks.getInfo(category);
			//addItemメソッドで新しいアイテムを追加
			dungeon2.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 6),1,1,10));
			dungeon2.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 7),1,1,10));
		}
		
		ChestGenHooks dungeon3 = ChestGenHooks.getInfo("dungeonChest");
		dungeon3.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 1),1,1,10));
		
		ChestGenHooks dungeon4 = ChestGenHooks.getInfo("mineshaftCorridor");
		dungeon4.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 4),1,1,10));
		dungeon4.addItem(new WeightedRandomChestContent(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 5),1,1,10));
	}
	
}
