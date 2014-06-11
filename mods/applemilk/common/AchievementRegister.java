package mods.applemilk.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchievementRegister {
	
	//実績追加
	public static Achievement craftTeaMaker;
	public static Achievement craftPan;
	public static Achievement craftIceMaker;
	public static Achievement craftTeppan;
	public static Achievement craftAutoMaker;
	public static Achievement craftLogBox;
	public static Achievement craftGrater;
	public static Achievement craftChalcedony;
	public static Achievement craftChalKnife;
	public static Achievement craftGlassLamp;
	public static Achievement getTeaLeaves;
	public static Achievement makeTeaLeaves;
	public static Achievement getTea;
	public static Achievement getAppleMilkTea;
	public static Achievement getSoup;
	public static Achievement getHamaguri;
	public static Achievement eatChocoGift;
	public static Achievement eatIcecream;
	public static Achievement crashMelon;
	public static Achievement craftCharcoalContainer;
	public static Achievement craftVegiBag;
	public static Achievement drinkCocktail;
	public static Achievement burnOnTeppan;
	public static Achievement makeRice;
	
	static Achievement[] DCachievementsList;
	public static AchievementPage DCachievementPage;
	public static final String newAchievement = "Apple&Milk&Tea!";
	
	
	
	public static void register()
	{
		int ID = DCsConfig.achievementShiftID;
		
		getTeaLeaves = (new Achievement((ID), "getTeaLeaves", 0, 1, new ItemStack(DCsAppleMilk.leafTea, 1, 0), AchievementList.openInventory))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(getTeaLeaves.statName, "en_US", "The eighty-eight night");
		LanguageRegistry.instance().addStringLocalization(getTeaLeaves.statName, "ja_JP", "八十八夜");
		LanguageRegistry.instance().addStringLocalization(getTeaLeaves.statName + ".desc", "en_US", "Get some tea leaves from the tea tree.");
		LanguageRegistry.instance().addStringLocalization(getTeaLeaves.statName + ".desc", "ja_JP", "茶の木から茶葉を摘む");
 
		
		craftTeaMaker = (new Achievement((ID + 1), "craftTeaMaker", 0, -1, new ItemStack(DCsAppleMilk.teaMakerNext, 1, 0), AchievementList.blazeRod))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftTeaMaker.statName, "en_US", "High Performance tea maker");
		LanguageRegistry.instance().addStringLocalization(craftTeaMaker.statName, "ja_JP", "高性能ティーメーカー");
		LanguageRegistry.instance().addStringLocalization(craftTeaMaker.statName + ".desc", "en_US", "Craft a tea maker.");
		LanguageRegistry.instance().addStringLocalization(craftTeaMaker.statName + ".desc", "ja_JP", "ティーメーカーを作る");
		
		craftPan = (new Achievement((ID + 2), "craftPan", -2, 0, new ItemStack(DCsAppleMilk.emptyPan, 1, 0), AchievementList.buildFurnace))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftPan.statName, "en_US", "Earthenwere pan");
		LanguageRegistry.instance().addStringLocalization(craftPan.statName, "ja_JP", "不思議な土鍋");
		LanguageRegistry.instance().addStringLocalization(craftPan.statName + ".desc", "en_US", "Craft a empty pan from hardened clay.");
		LanguageRegistry.instance().addStringLocalization(craftPan.statName + ".desc", "ja_JP", "堅焼き粘土から空の鍋を作る");
		
		craftTeppan = (new Achievement((ID + 3), "craftTeppan", -2, 2, new ItemStack(DCsAppleMilk.teppann, 1, 0), AchievementList.acquireIron))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftTeppan.statName, "en_US", "BBQ party!");
		LanguageRegistry.instance().addStringLocalization(craftTeppan.statName, "ja_JP", "バーベキュー！");
		LanguageRegistry.instance().addStringLocalization(craftTeppan.statName + ".desc", "en_US", "Craft a cooking iron plate.");
		LanguageRegistry.instance().addStringLocalization(craftTeppan.statName + ".desc", "ja_JP", "調理用鉄板を作る");
		
		craftIceMaker = (new Achievement((ID + 4), "craftIceMaker", 2, 0, new ItemStack(DCsAppleMilk.iceMaker, 1, 0), AchievementList.acquireIron))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftIceMaker.statName, "en_US", "Nostalgia of Showa days");
		LanguageRegistry.instance().addStringLocalization(craftIceMaker.statName, "ja_JP", "昭和の香り");
		LanguageRegistry.instance().addStringLocalization(craftIceMaker.statName + ".desc", "en_US", "Craft a ice maker..");
		LanguageRegistry.instance().addStringLocalization(craftIceMaker.statName + ".desc", "ja_JP", "かき氷機を作る");
		
		craftChalcedony = (new Achievement((ID + 5), "craftChalcedony", 2, 2, new ItemStack(DCsAppleMilk.chalcedony, 1, 0), AchievementList.buildFurnace))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftChalcedony.statName, "en_US", "Roadside jewel");
		LanguageRegistry.instance().addStringLocalization(craftChalcedony.statName, "ja_JP", "道端の宝石");
		LanguageRegistry.instance().addStringLocalization(craftChalcedony.statName + ".desc", "en_US", "Burn a flint block in furnace.");
		LanguageRegistry.instance().addStringLocalization(craftChalcedony.statName + ".desc", "ja_JP", "かまどでフリントブロックを焼く");
		
		craftLogBox = (new Achievement((ID + 6), "craftLogbox", 0, 3, new ItemStack(DCsAppleMilk.woodBox, 1, 0), AchievementList.buildWorkBench))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftLogBox.statName, "en_US", "Tidy neat");
		LanguageRegistry.instance().addStringLocalization(craftLogBox.statName, "ja_JP", "整理整頓");
		LanguageRegistry.instance().addStringLocalization(craftLogBox.statName + ".desc", "en_US", "Craft a log box of any type.");
		LanguageRegistry.instance().addStringLocalization(craftLogBox.statName + ".desc", "ja_JP", "原木から原木箱を作る");
		
		craftGrater = (new Achievement((ID + 7), "craftGrater", -3, -2, new ItemStack(DCsAppleMilk.DCgrater, 1, 0), craftPan))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftGrater.statName, "en_US", "Grate them all!");
		LanguageRegistry.instance().addStringLocalization(craftGrater.statName + ".desc", "en_US", "Craft a grater.");
		LanguageRegistry.instance().addStringLocalization(craftGrater.statName + ".desc", "ja_JP", "おろし金を作る");
		
		makeTeaLeaves = (new Achievement((ID + 8), "makeTeaLeaves", -1, -3, new ItemStack(DCsAppleMilk.EXItems, 1, 2), getTeaLeaves))
				.setIndependent().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(makeTeaLeaves.statName, "en_US", "Green tea leaves");
		LanguageRegistry.instance().addStringLocalization(makeTeaLeaves.statName, "ja_JP", "緑茶の茶葉");
		LanguageRegistry.instance().addStringLocalization(makeTeaLeaves.statName + ".desc", "en_US", "Roast the tea leaves in furnace.");
		LanguageRegistry.instance().addStringLocalization(makeTeaLeaves.statName + ".desc", "ja_JP", "茶の葉をかまどで焼く");
		
		makeRice = (new Achievement((ID + 23), "makeRice", -5, 0, new ItemStack(DCsAppleMilk.filledPan, 1, 0), craftGrater))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(makeRice.statName, "en_US", "Hot meals");
		LanguageRegistry.instance().addStringLocalization(makeRice.statName, "ja_JP", "温かい食卓");
		LanguageRegistry.instance().addStringLocalization(makeRice.statName + ".desc", "en_US", "Place the pan on top of the furnace, use the minced foods.");
		LanguageRegistry.instance().addStringLocalization(makeRice.statName + ".desc", "ja_JP", "鍋をかまどの上に置き、材料を持って右クリックする");
		
		getSoup = (new Achievement((ID + 9), "getSoup", -7, -2, new ItemStack(DCsAppleMilk.bowlBlock, 1, 2), makeRice))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(getSoup.statName, "en_US", "Homemade taste");
		LanguageRegistry.instance().addStringLocalization(getSoup.statName, "ja_JP", "温かいスープ");
		LanguageRegistry.instance().addStringLocalization(getSoup.statName + ".desc", "en_US", "Right click the filled pan while hold a bowl.");
		LanguageRegistry.instance().addStringLocalization(getSoup.statName + ".desc", "ja_JP", "ボウルを持って満たされた鍋を右クリック");
		
		eatChocoGift = (new Achievement((ID + 10), "eatChocoGift", -8, 1, new ItemStack(DCsAppleMilk.chocoBlock, 1, 1), makeRice))
				.setSpecial().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(eatChocoGift.statName, "en_US", "Youthful indiscretion...");
		LanguageRegistry.instance().addStringLocalization(eatChocoGift.statName, "ja_JP", "若気の至り");
		LanguageRegistry.instance().addStringLocalization(eatChocoGift.statName + ".desc", "en_US", "Eat the heartfelt chocolate gift.");
		LanguageRegistry.instance().addStringLocalization(eatChocoGift.statName + ".desc", "ja_JP", "心のこもったチョコの贈り物を食べる");
		
		getTea = (new Achievement((ID + 11), "getTea", 1, -3, new ItemStack(DCsAppleMilk.teacupBlock, 1, 2), craftTeaMaker))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(getTea.statName, "en_US", "Leisurely tea break");
		LanguageRegistry.instance().addStringLocalization(getTea.statName, "ja_JP", "ゆったりティーブレイク");
		LanguageRegistry.instance().addStringLocalization(getTea.statName + ".desc", "en_US", "Right click the filled tea maker while hold a empty cup.");
		LanguageRegistry.instance().addStringLocalization(getTea.statName + ".desc", "ja_JP", "空のカップを持ってティーメーカーを右クリック");
		
		getAppleMilkTea = (new Achievement((ID + 12), "getAppleMilkTea", 0, -5, new ItemStack(DCsAppleMilk.teaCup2, 1, 3), getTea))
				.setSpecial().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(getAppleMilkTea.statName, "en_US", "Apple Milk Tea!");
		LanguageRegistry.instance().addStringLocalization(getAppleMilkTea.statName, "ja_JP", "アップルミルクティー!");
		LanguageRegistry.instance().addStringLocalization(getAppleMilkTea.statName + ".desc", "en_US", "Get a apple milk tea.");
		LanguageRegistry.instance().addStringLocalization(getAppleMilkTea.statName + ".desc", "ja_JP", "アップルミルクティーを手に入れる");
		
		getHamaguri = (new Achievement((ID + 13), "getHamaguri", -3, 4, new ItemStack(DCsAppleMilk.foodPlate, 1, 3), craftTeppan))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(getHamaguri.statName, "en_US", "Specialty of the Kuroshio");
		LanguageRegistry.instance().addStringLocalization(getHamaguri.statName, "ja_JP", "黒潮の恵み");
		LanguageRegistry.instance().addStringLocalization(getHamaguri.statName + ".desc", "en_US", "Burn a clam on the cooking iron plate.");
		LanguageRegistry.instance().addStringLocalization(getHamaguri.statName + ".desc", "ja_JP", "ハマグリを調理用鉄板で焼く");
		
		craftCharcoalContainer = (new Achievement((ID + 14), "craftCharcoalContainer", -1, 5, new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), craftLogBox))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftCharcoalContainer.statName, "en_US", "Long life fuel");
		LanguageRegistry.instance().addStringLocalization(craftCharcoalContainer.statName, "ja_JP", "ロングライフ燃料");
		LanguageRegistry.instance().addStringLocalization(craftCharcoalContainer.statName + ".desc", "en_US", "Burn a log box in furnace.");
		LanguageRegistry.instance().addStringLocalization(craftCharcoalContainer.statName + ".desc", "ja_JP", "かまどで原木箱を焼く");
		
		craftVegiBag = (new Achievement((ID + 15), "craftVegiBag", 1, 5, new ItemStack(DCsAppleMilk.vegiBag, 1, 1), craftLogBox))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftVegiBag.statName, "en_US", "Vegetable storage");
		LanguageRegistry.instance().addStringLocalization(craftVegiBag.statName, "ja_JP", "野菜の貯蔵");
		LanguageRegistry.instance().addStringLocalization(craftVegiBag.statName + ".desc", "en_US", "Craft a Vegetable bag of any type.");
		LanguageRegistry.instance().addStringLocalization(craftVegiBag.statName + ".desc", "ja_JP", "作物袋を一種類作る");
		
		crashMelon = (new Achievement((ID + 16), "crashMelon", 1, 8, new ItemStack(DCsAppleMilk.melonBomb, 1, 0), craftVegiBag))
				.setSpecial().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(crashMelon.statName, "en_US", "Water melon rafting");
		LanguageRegistry.instance().addStringLocalization(crashMelon.statName, "ja_JP", "スイカの川流れ");
		LanguageRegistry.instance().addStringLocalization(crashMelon.statName + ".desc", "en_US", "Ride a compressed melon on water, and crash it.");
		LanguageRegistry.instance().addStringLocalization(crashMelon.statName + ".desc", "ja_JP", "圧縮されたメロンに乗って壁に衝突する");
		
		eatIcecream = (new Achievement((ID + 17), "eatIcecream", 5, -1, new ItemStack(DCsAppleMilk.blockIcecream, 1, 0), craftIceMaker))
				.setSpecial().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(eatIcecream.statName, "en_US", "Cool your body");
		LanguageRegistry.instance().addStringLocalization(eatIcecream.statName, "ja_JP", "冷たい食べ物");
		LanguageRegistry.instance().addStringLocalization(eatIcecream.statName + ".desc", "en_US", "Eat a ice cream block on the nether.");
		LanguageRegistry.instance().addStringLocalization(eatIcecream.statName + ".desc", "ja_JP", "ネザーでアイスクリームを食べる");
		
		craftChalKnife = (new Achievement((ID + 18), "craftChalKnife", 5, 2, new ItemStack(DCsAppleMilk.chalcedonyKnife, 1, 0), craftChalcedony))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftChalKnife.statName, "en_US", "New material");
		LanguageRegistry.instance().addStringLocalization(craftChalKnife.statName, "ja_JP", "新しい素材");
		LanguageRegistry.instance().addStringLocalization(craftChalKnife.statName + ".desc", "en_US", "Craft a chalcedony knife.");
		LanguageRegistry.instance().addStringLocalization(craftChalKnife.statName + ".desc", "ja_JP", "玉髄のナイフを作る");
		
		craftGlassLamp = (new Achievement((ID + 19), "craftGlassLamp", 4, 4, new ItemStack(DCsAppleMilk.cLamp, 1, 3), craftChalcedony))
				.setSpecial().registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftGlassLamp.statName, "en_US", "Infinite combo prevention");
		LanguageRegistry.instance().addStringLocalization(craftGlassLamp.statName, "ja_JP", "永パ防止キャラ");
		LanguageRegistry.instance().addStringLocalization(craftGlassLamp.statName + ".desc", "en_US", "Craft a orange chalcedony glass lamp.");
		LanguageRegistry.instance().addStringLocalization(craftGlassLamp.statName + ".desc", "ja_JP", "玉髄のグラスランプ(黄)を作る");
		
		craftAutoMaker = (new Achievement((ID + 20), "craftAutoMaker", 7, 3, new ItemStack(DCsAppleMilk.autoMaker, 1, 0), craftChalKnife))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(craftAutoMaker.statName, "en_US", "Convenient automation");
		LanguageRegistry.instance().addStringLocalization(craftAutoMaker.statName, "ja_JP", "自動化の波");
		LanguageRegistry.instance().addStringLocalization(craftAutoMaker.statName + ".desc", "en_US", "Craft a tea maker attachment.");
		LanguageRegistry.instance().addStringLocalization(craftAutoMaker.statName + ".desc", "ja_JP", "ティーメーカー・アタッチメントを作る");
		
		drinkCocktail = (new Achievement((ID + 21), "drinkCocktail", 3, -2, new ItemStack(DCsAppleMilk.cocktail, 1, 0), craftIceMaker))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(drinkCocktail.statName, "en_US", "Fryday night");
		LanguageRegistry.instance().addStringLocalization(drinkCocktail.statName, "ja_JP", "花の金曜日");
		LanguageRegistry.instance().addStringLocalization(drinkCocktail.statName + ".desc", "en_US", "Drink a glass of cocktail of any type.");
		LanguageRegistry.instance().addStringLocalization(drinkCocktail.statName + ".desc", "ja_JP", "カクテルを一杯飲む");
		
		burnOnTeppan = (new Achievement((ID + 22), "burnOnTeppan", -4, 2, new ItemStack(Block.fire, 1, 0), craftTeppan))
				.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(burnOnTeppan.statName, "en_US", "Be carefull!");
		LanguageRegistry.instance().addStringLocalization(burnOnTeppan.statName, "ja_JP", "やけどに注意！");
		LanguageRegistry.instance().addStringLocalization(burnOnTeppan.statName + ".desc", "en_US", "Touch the cooking iron plate on fire.");
		LanguageRegistry.instance().addStringLocalization(burnOnTeppan.statName + ".desc", "ja_JP", "炎の上に置いた調理用鉄板に触れる");
		
		DCachievementsList = new Achievement[] { getTeaLeaves, craftTeaMaker, craftPan, craftTeppan, craftIceMaker, craftChalcedony, craftLogBox, craftGrater,
				makeTeaLeaves, getSoup, eatChocoGift, getTea, getAppleMilkTea, getHamaguri, craftCharcoalContainer, craftVegiBag, crashMelon, eatIcecream,
				craftChalKnife, craftGlassLamp, craftAutoMaker, drinkCocktail, burnOnTeppan, makeRice};
		DCachievementPage = new AchievementPage(newAchievement, DCachievementsList);
		AchievementPage.registerAchievementPage(DCachievementPage);
		
		DCsAppleMilk.proxy.init();
	}

}
