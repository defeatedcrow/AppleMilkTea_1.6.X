package mods.applemilk.common;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.applemilk.*;
import mods.applemilk.common.tile.TileAutoMaker;

public class DCsLangRegister {
	
	public void registerLang()
	{
		LanguageRegistry.addName(DCsAppleMilk.bakedApple, "Baked Apple");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.bakedApple, "ja_JP", "焼きリンゴ");
 
		LanguageRegistry.addName(DCsAppleMilk.appleTart, "Apple Tart");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.appleTart, "ja_JP", "リンゴのタルト");
		
		LanguageRegistry.addName(DCsAppleMilk.toffyApple, "Toffy Apple");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.toffyApple, "ja_JP", "りんご飴");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.appleSandwich, 1, 0), "Apple Sandwich");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.appleSandwich, 1, 0), "ja_JP", "りんごサンド");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.appleSandwich, 1, 1), "Egg Sandwich");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.appleSandwich, 1, 1), "ja_JP", "たまごサンド");
 
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 0), "Icy Toffy Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 0), "ja_JP", "氷結りんご飴");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 1), "Airy Toffy Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 1), "ja_JP", "風のりんご飴");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 2), "Golden Toffy Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 2), "ja_JP", "黄金りんご飴");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 3), "Green Toffy Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.icyToffyApple, 1, 3), "ja_JP", "葉緑素りんご飴");
		
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 0), "Oak Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 0), "ja_JP", "樫の丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 1), "Spruse Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 1), "ja_JP", "松の丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 2), "Birch Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 2), "ja_JP", "白樺の丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 3), "Jangle Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 3), "ja_JP", "ジャングルの丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 4), "Rubberwood Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 4), "ja_JP", "ゴムの木の丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 5), "Greatwood Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 5), "ja_JP", "グレートウッドの丸太箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.woodBox, 1, 6), "Silverwood Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.woodBox, 1, 6), "ja_JP", "シルバーウッドの丸太箱");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mushroomBox, 1, 0), "Red Mushroom Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mushroomBox, 1, 0), "ja_JP", "赤キノコブロック");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mushroomBox, 1, 1), "Brown Mushroom Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mushroomBox, 1, 1), "ja_JP", "茶キノコブロック");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.melonBomb, 1, 0), "Compressed Melon Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.melonBomb, 1, 0), "ja_JP", "圧縮されたメロン");
		
		LanguageRegistry.addName(DCsAppleMilk.appleBox, "Apple Box");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.appleBox, "ja_JP", "りんご箱");
		
		LanguageRegistry.addName(DCsAppleMilk.charcoalBox, "Charcoal Container");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.charcoalBox, "ja_JP", "木炭コンテナ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 0), "Tea Maker");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 0), "ja_JP", "ティーメイカー(空)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 1), "Tea Maker(Milk)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 1), "ja_JP", "ティーメイカー(ミルク)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 2), "Tea Maker(Coffee)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 2), "ja_JP", "ティーメイカー(ホットコーヒー)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 3), "Tea Maker(MilkCoffee)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 3), "ja_JP", "ティーメイカー(ミルクコーヒー)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 4), "Tea Maker(Tea)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 4), "ja_JP", "ティーメイカー(紅茶)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 5), "Tea Maker(MilkTea)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 5), "ja_JP", "ティーメイカー(ミルクティー)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 6), "Tea Maker(GreenTea)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 6), "ja_JP", "ティーメイカー(緑茶)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 7), "Tea Maker(MilkGreenTea)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 7), "ja_JP", "ティーメイカー(ミルク抹茶)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 8), "Tea Maker(Cocoa)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 8), "ja_JP", "ティーメイカー(ブラックココア)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 9), "Tea MakerMilkCocoa)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 9), "ja_JP", "ティーメイカー(ミルクココア)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 10), "Tea Maker(FruitJuice)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 10), "ja_JP", "ティーメイカー(ジュース)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 11), "Tea Maker(FruitShake)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 11), "ja_JP", "ティーメイカー(フルーツセーキ)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 12), "Tea Maker(Hot Lemonade)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 12), "ja_JP", "ティーメイカー(はちみつレモン)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaMaker, 1, 13), "Tea Maker(Milk Lemonade)");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaMaker, 1, 13), "ja_JP", "ティーメイカー(レモン牛乳)");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlRack,1,0), "Bowl Rack");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlRack,1,0), "ja_JP", "ボウルラック");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlRack,1,1), "Bowl Rack");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlRack,1,1), "ja_JP", "ボウルラック");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlRack,1,2), "Bowl Rack");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlRack,1,2), "ja_JP", "ボウルラック");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlRack,1,3), "Bowl Rack");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlRack,1,3), "ja_JP", "ボウルラック");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,0), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,0), "ja_JP", "ブレッドバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,1), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,1), "ja_JP", "ブレッドバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,2), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,2), "ja_JP", "ブレッドバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,3), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,3), "ja_JP", "ブレッドバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,4), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,4), "ja_JP", "ブレッドバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.Basket,1,5), "Bread Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.Basket,1,5), "ja_JP", "ブレッドバスケット");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.eggBasket,1,0), "Egg Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.eggBasket,1,0), "ja_JP", "タマゴバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.eggBasket,1,1), "Black Egg Basket");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.eggBasket,1,1), "ja_JP", "黒タマゴバスケット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.eggBasket,1,2), "Egg Cage");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.eggBasket,1,2), "ja_JP", "タマゴケージ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.eggBasket,1,3), "Black Egg Cage");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.eggBasket,1,3), "ja_JP", "黒タマゴケージ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticksBox,1,0), "Chopsticks Holder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticksBox,1,0), "ja_JP", "箸立て");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticksBox,1,1), "Chopsticks Holder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticksBox,1,1), "ja_JP", "箸立て");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticksBox,1,2), "Chopsticks Holder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticksBox,1,2), "ja_JP", "箸立て");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticksBox,1,3), "Chopsticks Holder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticksBox,1,3), "ja_JP", "箸立て");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticksBox,1,4), "Chopsticks Holder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticksBox,1,4), "ja_JP", "箸立て");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox,1,0), "Wipe Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox,1,0), "ja_JP", "ティッシュ箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox,1,1), "KixWipe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox,1,1), "ja_JP", "キムワイプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox,1,2), "Opened Wipe Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox,1,2), "ja_JP", "開封済みティッシュ箱");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox,1,3), "Opened KixWipe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox,1,3), "ja_JP", "開封済みキムワイプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox,1,4), "Infinity KixWipe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox,1,4), "ja_JP", "無限キムワイプ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.wipeBox2,1,0), "Large paper Box");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.wipeBox2,1,0), "ja_JP", "A4用紙箱");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticks,1,0), "Chopsticks");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticks,1,0), "ja_JP", "箸");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chopsticks,1,1), "Wood Spoon");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chopsticks,1,1), "ja_JP", "木のスプーン");
		
		LanguageRegistry.addName(DCsAppleMilk.emptyPan, "Empty Pan");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.emptyPan, "ja_JP", "空の鍋");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan, 1, 0), "Boiled Rice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan, 1, 0), "ja_JP", "御飯");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan, 1, 1), "Mashroom Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan, 1, 1), "ja_JP", "キノコシチュー鍋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan, 1, 2), "Saimon Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan, 1, 2), "ja_JP", "鮭のシチュー鍋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan, 1, 3), "Zousui");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan, 1, 3), "ja_JP", "とりたま雑炊鍋");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan2, 1, 0), "Kayakumeshi");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan2, 1, 0), "ja_JP", "かやく御飯");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan2, 1, 1), "Tofu-Nabe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan2, 1, 1), "ja_JP", "豆乳鍋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan2, 1, 2), "Pumpkin Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan2, 1, 2), "ja_JP", "かぼちゃポタージュ鍋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.filledPan2, 1, 3), "BLT Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.filledPan2, 1, 3), "ja_JP", "BLTスープ鍋");
		
		LanguageRegistry.addName(DCsAppleMilk.filledChocoPan, "Chocolate Fondue");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.filledChocoPan, "ja_JP", "チョコフォンデュ鍋");
		
		LanguageRegistry.addName(DCsAppleMilk.emptyCup, "Empty Tea Cup");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.emptyCup, "ja_JP", "空のティーカップ");
		
		LanguageRegistry.addName(DCsAppleMilk.saplingTea, "Tea Sapling");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.saplingTea, "ja_JP", "茶の苗");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaTree, 1 ,0), "Tea Tree");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaTree, 1, 0), "ja_JP", "茶の木");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaTree, 1 ,1), "Grown Tea Tree");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaTree, 1, 1), "ja_JP", "成長した茶の木");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 0), "Tea Leaves Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 0), "ja_JP", "茶葉袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 1), "Potato Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 1), "ja_JP", "じゃがいも袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 2), "Carrot Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 2), "ja_JP", "にんじん袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 3), "Pumpkin Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 3), "ja_JP", "かぼちゃ袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 4), "Seed Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 4), "ja_JP", "種袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 5), "Reed Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 5), "ja_JP", "サトウキビ袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 6), "Cactus Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 6), "ja_JP", "サボテン袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 7), "Cocoa Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 7), "ja_JP", "カカオ袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 8), "NetherWart Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 8), "ja_JP", "ネザーウォート袋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.vegiBag, 1, 9), "Sugar Bag");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.vegiBag, 1, 9), "ja_JP", "砂糖袋");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 0), "Milk Candy");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 0), "ja_JP", "ミルク飴");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 1), "Animal Glue");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 1), "ja_JP", "膠");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 2), "Green Tea Leaves");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 2), "ja_JP", "緑茶の茶葉");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 3), "Tea Leaves");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 3), "ja_JP", "紅茶の茶葉");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 4), "Oxidized Tea Leaves");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 4), "ja_JP", "酸化した茶葉");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 5), "Kayaku");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 5), "ja_JP", "かやく");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 6), "Chalcedony Gear");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 6), "ja_JP", "玉髄の歯車");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 7), "Crushed Ice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 7), "ja_JP", "ロックアイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 8), "Earl Gray Leaves");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 8), "ja_JP", "アールグレイの茶葉");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.EXItems, 1, 9), "Appletea Leaves");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.EXItems, 1, 9), "ja_JP", "アップルティーの茶葉");
		
		LanguageRegistry.addName(DCsAppleMilk.condensedMIlk, "Condensed MIlk");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.condensedMIlk, "ja_JP", "加糖練乳");
		LanguageRegistry.addName(DCsAppleMilk.inkStick, "Inkstick");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.inkStick, "ja_JP", "墨");
		LanguageRegistry.addName(DCsAppleMilk.leafTea, "Raw Tea Leaves");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.leafTea, "ja_JP", "生の茶葉");
		
		LanguageRegistry.addName(DCsAppleMilk.DCgrater, "Grater");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.DCgrater, "ja_JP", "おろし金");
		
		LanguageRegistry.addName(DCsAppleMilk.teaMakerNext, "Tea Maker");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.teaMakerNext, "ja_JP", "ティーメーカー");
		
		LanguageRegistry.addName(DCsAppleMilk.autoMaker, "Auto Tea Attachmant");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.autoMaker, "ja_JP", "ティーメーカー・アタッチメント");
		
		LanguageRegistry.addName(DCsAppleMilk.iceMaker, "Ice Maker");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.iceMaker, "ja_JP", "かき氷機");
		
		LanguageRegistry.addName(DCsAppleMilk.icyCrystal, "Icy Crystal");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.icyCrystal, "ja_JP", "氷結クリスタル");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 0), "Milk Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 0), "ja_JP", "アイスクリン");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 1), "Tea Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 1), "ja_JP", "紅茶アイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 2), "Greentea Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 2), "ja_JP", "抹茶アイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 3), "Cocoa Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 3), "ja_JP", "チョコチップアイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 4), "Coffee Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 4), "ja_JP", "コーヒーアイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 5), "Fruit Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 5), "ja_JP", "フルーツアイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 6), "Lemon Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 6), "ja_JP", "レモンアイス");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 7), "Lime Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 7), "ja_JP", "ライムシャーベット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 8), "Tomato Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 8), "ja_JP", "トマトシャーベット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.blockIcecream, 1, 9), "Berry Icecream");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.blockIcecream, 1, 9), "ja_JP", "ベリーアイス");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 0), "Frozen Diquiri");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 0), "ja_JP", "フローズン・ダイキリ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 1), "Frozen Sake");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 1), "ja_JP", "みぞれ酒");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 2), "Sake-tini");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 2), "ja_JP", "サケティーニ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 3), "Gimlet");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 3), "ja_JP", "ギムレット");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 4), "Black Rose");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 4), "ja_JP", "ブラックローズ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cocktail, 1, 5), "Red Eye");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cocktail, 1, 5), "ja_JP", "レッドアイ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 0), "Minced Mushrooms");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 0), "ja_JP", "キノコシチューの材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 1), "Minced Fish and Vegitables");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 1), "ja_JP", "鮭シチューの材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 2), "Minced Chikin and rice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 2), "ja_JP", "雑炊の材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 3), "Washed Rice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 3), "ja_JP", "搗いた米");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 4), "Materials of Kayakumeshi");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 4), "ja_JP", "かやく御飯の材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 5), "Materials of Tofu-Nabe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 5), "ja_JP", "豆乳鍋の材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 6), "Minced pumpkin");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 6), "ja_JP", "かぼちゃポタージュの材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 7), "Minced BLT");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 7), "ja_JP", "BLTスープの材料");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.mincedFoods, 1, 8), "Minced Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.mincedFoods, 1, 8), "ja_JP", "チョコフォンデュの材料");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 0), "Grated Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 0), "ja_JP", "すりリンゴ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 1), "Grated Fruit");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 1), "ja_JP", "フルーツペースト");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 2), "Honey Lemon Slices");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 2), "ja_JP", "蜂蜜漬けレモン");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 3), "Coffee Powder");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 3), "ja_JP", "コーヒー粉");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 4), "Ganache");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 4), "ja_JP", "ガナッシュ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 5), "Grated Lime");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 5), "ja_JP", "ライムペースト");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 6), "Grated Tomato");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 6), "ja_JP", "トマトペースト");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 7), "Grated Berry");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 7), "ja_JP", "ベリーペースト");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gratedApple, 1, 8), "Grated Grape");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gratedApple, 1, 8), "ja_JP", "ぶどうペースト");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 0), "Boiled Rice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 0), "ja_JP", "御飯");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 1), "Mashroom Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 1), "ja_JP", "キノコシチュー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 2), "Salmon Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 2), "ja_JP", "鮭のクリームシチュー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 3), "Torizousui");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 3), "ja_JP", "とりたま雑炊");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 4), "Kayakumeshi");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 4), "ja_JP", "かやくご飯");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 5), "Tofu-Nabe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 5), "ja_JP", "豆乳鍋");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 6), "Pumpkin Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 6), "ja_JP", "かぼちゃポタージュ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlBlock, 1, 7), "BLT Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlBlock, 1, 7), "ja_JP", "BLTスープ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 0), "JP Boiled Rice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 0), "ja_JP", "御飯(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 1), "JP Mashroom Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 1), "ja_JP", "キノコシチュー(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 2), "JP Salmon Stew");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 2), "ja_JP", "鮭のクリームシチュー(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 3), "JP Torizousui");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 3), "ja_JP", "とりたま雑炊(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 4), "JP Kayakumeshi");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 4), "ja_JP", "かやくご飯(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 5), "JP Tofu-Nabe");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 5), "ja_JP", "豆乳鍋(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 6), "JP Pumpkin Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 6), "ja_JP", "かぼちゃポタージュ(和風)");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.bowlJP, 1, 7), "JP BLT Soup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.bowlJP, 1, 7), "ja_JP", "BLTスープ(和風)");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 0), "Empty Tea Cup");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 0), "ja_JP", "空のティーカップ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 0), "Hot Milk");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 1), "ja_JP", "ホットミルク");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 2), "Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 2), "ja_JP", "紅茶");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 3), "Milk Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 3), "ja_JP", "ミルクティー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 4), "Green Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 4), "ja_JP", "緑茶");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 5), "Milk Green Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 5), "ja_JP", "抹茶ラテ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 6), "Black Cocoa");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 6), "ja_JP", "ブラックココア");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 7), "Milk Cocoa");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 7), "ja_JP", "ミルクココア");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 8), "Fruits Juice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 8), "ja_JP", "フルーツジュース");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 9), "Fruit Shakes");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 9), "ja_JP", "フルーツセーキ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 10), "Hot Lemonade");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 10), "ja_JP", "はちみつレモン");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 11), "Milk Lemonade");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 11), "ja_JP", "レモン牛乳");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 12), "Coffee");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 12), "ja_JP", "コーヒー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teacupBlock, 1, 13), "Milk Coffee");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teacupBlock, 1, 13), "ja_JP", "ミルクコーヒー");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 0), "Earl Gray Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 0), "ja_JP", "アールグレイ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 1), "Earl Gray Milk Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 1), "ja_JP", "アールグレイミルクティー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 2), "Apple Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 2), "ja_JP", "アップルティー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 3), "Apple Milk Tea");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 3), "ja_JP", "アップルミルクティー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 4), "Lime Juice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 4), "ja_JP", "ライムジュース");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 5), "Tomato Juice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 5), "ja_JP", "トマトジュース");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 6), "Berry Juice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 6), "ja_JP", "ベリージュース");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 7), "Berry Shakes");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 7), "ja_JP", "ベリーミルクセーキ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup2, 1, 8), "Grape juice");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup2, 1, 8), "ja_JP", "グレープジュース");
		
		LanguageRegistry.addName(DCsAppleMilk.flintBlock, "Flint Block");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.flintBlock, "ja_JP", "フリントブロック");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chalcedony, 1, 0), "Chalcedony Block");
		LanguageRegistry.instance().addNameForObject((new ItemStack(DCsAppleMilk.chalcedony, 1, 0)), "ja_JP", "玉髄ブロック");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chalcedony, 1, 1), "Orange Chalcedony Block");
		LanguageRegistry.instance().addNameForObject((new ItemStack(DCsAppleMilk.chalcedony, 1, 1)), "ja_JP", "黄玉髄ブロック");
		
		LanguageRegistry.addName(DCsAppleMilk.chalcedonyKnife, "Chalcedony Knife");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.chalcedonyKnife, "ja_JP", "玉髄のナイフ");
		LanguageRegistry.addName(DCsAppleMilk.firestarter, "Fire Starter");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.firestarter, "ja_JP", "上質な着火具");
		LanguageRegistry.addName(DCsAppleMilk.chalcedonyHammer, "Chalcedony Stone Cutter");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.chalcedonyHammer, "ja_JP", "玉髄の石切り槌");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 0), "Bluechalcedony GlowBlock");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 0), "ja_JP", "青玉髄のランプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 1), "Orangechalcedony GlowBlock");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 1), "ja_JP", "黄玉髄のランプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 2), "Bluechalcedony Glass Lamp");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 2), "ja_JP", "青玉髄のガラスランプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 3), "Orangechalcedony Glass Lamp");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 3), "ja_JP", "黄玉髄のガラスランプ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 4), "Chalcedony Candlestick");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 4), "ja_JP", "玉髄の燭台");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.cLamp, 1, 5), "Chalcedony Desk Lamp");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.cLamp, 1, 5), "ja_JP", "玉髄の卓上ランプ");
		
		LanguageRegistry.addName(DCsAppleMilk.rotaryDial, "Rotary Dial");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.rotaryDial, "ja_JP", "黒電話");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 0), "Gunpowder Container");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 0), "ja_JP", "火薬コンテナ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 1), "Kayaku Container");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 1), "ja_JP", "かやくコンテナ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 2), "Clay Container");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 2), "ja_JP", "粘土コンテナ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teppann, 1, 0), "Cooking Iron Plate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teppann, 1, 0), "ja_JP", "調理用鉄板");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.foodPlate, 1, 0), "Beef Steak Plate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.foodPlate, 1, 0), "ja_JP", "ビフテキプレート");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.foodPlate, 1, 1), "Pork Steak Plate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.foodPlate, 1, 1), "ja_JP", "トンテキプレート");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.foodPlate, 1, 2), "Roasted Chicken Plate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.foodPlate, 1, 2), "ja_JP", "鶏の丸焼きプレート");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.foodPlate, 1, 3), "Roasted Clam Plate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.foodPlate, 1, 3), "ja_JP", "焼きハマグリプレート");
		
		LanguageRegistry.addName(DCsAppleMilk.clamSand, "Clam in Sand");
		LanguageRegistry.instance().addNameForObject(DCsAppleMilk.clamSand, "ja_JP", "ハマグリ入りの砂");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.clam, 1, 0), "Clam");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.clam, 1, 0), "ja_JP", "ハマグリ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.clam, 1, 1), "Cooked Clam");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.clam, 1, 1), "ja_JP", "焼きハマグリ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.clam, 1, 2), "Burnt Meat");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.clam, 1, 2), "ja_JP", "焦げた肉片");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.clam, 1, 3), "Black Egg");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.clam, 1, 3), "ja_JP", "黒たまご");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 0), "Almond Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 0), "ja_JP", "アーモンドチョコ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 1), "Peanut Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 1), "ja_JP", "ピーナッツチョコ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 2), "Crushed Nuts Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 2), "ja_JP", "ナッツクランチチョコ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 3), "Strawberry Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 3), "ja_JP", "チョコいちご");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 4), "Cherry Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 4), "ja_JP", "チョコさくらんぼ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 5), "Berry Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 5), "ja_JP", "ベリーチョコ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 6), "Banana Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 6), "ja_JP", "チョコバナナ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 7), "Cereal Chocolate Bar");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 7), "ja_JP", "シリアルチョコバー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 8), "Chocolate Bread");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 8), "ja_JP", "チョコがけパン");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 9), "Cookie Chocolate");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 9), "ja_JP", "チョコがけクッキー");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 10), "Chocolate Truffles");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 10), "ja_JP", "トリュフチョコ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 11), "Chocolate Candy");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 11), "ja_JP", "チョコキャンディ");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 12), "Chocolate Apple");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocolateFruits, 1, 12), "ja_JP", "チョコがけリンゴ");
		
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocoBlock, 1, 0), "Chocolate Gift");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocoBlock, 1, 0), "ja_JP", "チョコの贈り物");
		LanguageRegistry.addName(new ItemStack(DCsAppleMilk.chocoBlock, 1, 1), "Heartfelt Chocolate Gift");
		LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.chocoBlock, 1, 1), "ja_JP", "心をこめたチョコの贈り物");
		
		LanguageRegistry.instance().addStringLocalization("DCs.potion.immunization", "Immunization");
		LanguageRegistry.instance().addStringLocalization("DCs.potion.immunization", "ja_JP", "免疫力");
		
		if (DCsAppleMilk.useOldItems)
		{
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 0), "Empty Tea Cup");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 0), "ja_JP", "空のティーカップ");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 1), "Hot Milk");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 1), "ja_JP", "ホットミルク");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 2), "Tea");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 2), "ja_JP", "紅茶");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 3), "Milk Tea");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 3), "ja_JP", "ミルクティー");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 4), "Green Tea");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 4), "ja_JP", "緑茶");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 5), "Milk Green Tea");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 5), "ja_JP", "抹茶ラテ");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 6), "Black Cocoa");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 6), "ja_JP", "ブラックココア");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 7), "Milk Cocoa");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 7), "ja_JP", "ミルクココア");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 8), "Fruits Juice");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 8), "ja_JP", "フルーツジュース");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 9), "Fruit Shakes");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 9), "ja_JP", "フルーツセーキ");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.teaCup, 1, 10), "Hot Lemonade");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.teaCup, 1, 10), "ja_JP", "はちみつレモン");
			
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.DCStew, 1, 0), "Saimon Stew");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.DCStew, 1, 0), "ja_JP", "鮭のシチュー");
			LanguageRegistry.addName(new ItemStack(DCsAppleMilk.DCStew, 1, 1), "Zousui");
			LanguageRegistry.instance().addNameForObject(new ItemStack(DCsAppleMilk.DCStew, 1, 1), "ja_JP", "とりたま雑炊");
		}
	}

}
