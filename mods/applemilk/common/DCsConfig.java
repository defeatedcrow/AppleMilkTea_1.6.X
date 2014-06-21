package mods.applemilk.common;

import java.util.logging.Level;

import mods.applemilk.common.entity.VillagerCafe;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;

public class DCsConfig {
	
	public static int blockIdWoodBox = 600;
	public static int blockIdAppleBox = 601;
	public static int blockIdVegiBag = 602;
	public static int blockIdCBox = 603;
	public static int blockIdMaker = 604;//ブロックID節約のためボツ化。
	public static int blockIdECup = 605;
	public static int blockIdSapT = 606;
	public static int blockIdTreeT = 607;
	public static int blockIdFPan = 608;
	public static int blockIdEPan = 609;
	public static int blockIdBowlRack = 610;
	public static int blockIdTeacupBlock = 599;
	public static int blockIdBowlBlock = 598;
	public static int blockIdBasket = 597;
	public static int blockIdFlint = 596;
	public static int blockIdChalcedony = 595;
	public static int blockIdCLamp = 594;
	public static int blockIdGContainer = 593;
	public static int blockIdTeppann = 592;
	public static int blockIdFoodPlate = 591;
	public static int blockIdClamSand = 590;
	public static int blockIdEmptyTeaMaker = 589;
	public static int blockIdFPan2 = 588;
	public static int blockIdBowlJP = 587;
	public static int blockIdChopsticks = 611;
	public static int blockIdEggBasket = 612;
	public static int blockIdMushChair = 613;
	public static int blockIdMelonBomb = 614;
	public static int blockIdChocoPan = 586;
	public static int blockIdChocoDC = 585;
	public static int blockIdWipeBox = 584;
	public static int blockIdMakerNext = 580;
	public static int blockIdAutoMaker = 581;
	public static int blockIdTeppanNext = 582;
	public static int blockIdIceMaker = 583;
	public static int blockIdIceBlock = 615;
	public static int blockIdWipe2 = 616;
	public static int blockIdTeaCup2 = 617;
	public static int blockIdDial = 619;
	public static int blockIdCocktail = 618;
	public static int blockIdLargeBottle = 620;
	public static int blockIdCordial = 622;
	public static int blockIdTreeC = 621;
	public static int blockIdAlcohol = 623;
	public static int blockIdCropMint = 624;
	
	public static int itemIdBapple = 6000;
	public static int itemIdAppleTart = 6001;
	public static int itemIdToffyApple = 6002;
	public static int itemIdIcyToffy = 6003;
	public static int itemIdEX = 6004;
	public static int itemIdCMilk = 6005;
	public static int itemIdInkStick = 6006;
	public static int itemIdAppleSand = 6007;
	public static int itemIdLeafT = 6008;
	public static int itemIdTeaCup = 6009;
	public static int itemIdGratedApple = 5991;
	public static int itemIdMinced = 5992;
	public static int itemIdGrater = 5990;
	public static int itemIdDCStew = 5993;
	public static int itemIdCKnife = 5994;
	public static int itemIdCFireStarter = 5995;
	public static int itemIdClam = 5996;
	public static int itemIdChopsticks = 5997;
	public static int itemIdCHammer = 5998;
	public static int itemIdChoco = 5999;
	public static int itemIdIcyCrystal = 6010;
	public static int itemIdWallMug = 6012;
	public static int itemIdBottle = 6013;
	public static int itemIdMilkBottle = 6014;
	public static int itemIdPClam = 6015;
	public static int itemIdCordial = 6011;
	public static int itemIdSeedMint = 6016;
	
	//potionID
	public static int potionIDImmunity = 60;
	public static int potionIDPrvExplode = 61;
	public static int potionIDPrvProjectile = 62;
	public static int potionIDReflex = 63;
	public static int potionIDAbsEXP = 64;
	public static int potionIDAbsHeal = 65;
	public static int potionIDSuffocation = 66;
	public static int potionIDPrvSuffocation = 67;
	
	//entity
	public static int entityIdMelon = 0;
	
	//villager関連
	public static int villagerRecipeID = 15;
	
	//コンフィグ項目の初期設定
	public static int teaTreeGenValue = 5;
	public static int clamChanceValue = 5;
	public static int setCupTexture = 1;
	public static int setAltTexturePass = 1;
	public static int teppannReadyTime = 30;
	public static int cupStackSize = 1;
	public static int achievementShiftID = 600;
	
	public static boolean useEXRecipe = false;
	public static boolean notGenTeaTree = false;
	public static boolean allowSlimeBallDic = true;
	public static boolean noRenderFoodsSteam = false;
	public static boolean disableFireSteater = false;
	public static boolean disableClam = false;
	public static boolean noWetGContainer = false;
	public static boolean teppannHardMode = false;
	public static boolean noUseCupDirection = false;
	public static boolean useSummerRender = false;
	public static boolean teppannRandomCookTime = false;
	public static boolean canExplodeMelon = true;
	public static boolean useOldItems = false;
	public static boolean melonBreakBlock = false;
	public static boolean safetyChocolate = false;
	public static boolean allowInfinityWipes = true;
	public static boolean useJapaneseCup = false;
	public static boolean bonemealClam = true;
	
	public static boolean useIC2Items = true;
	public static boolean allowMoisture = true;
	
	public static boolean IC2exp = true;
	public static boolean TC4after405 = true;
	
	private final String BR = System.getProperty("line.separator");
	
	public void config(Configuration cfg)
	{
		
		try
		{
			cfg.load();
			
			Property blockWoodBox = cfg.getBlock("LogBox", blockIdWoodBox);
			Property blockAppleBox = cfg.getBlock("AppleBox", blockIdAppleBox);
			Property blockWheatBag = cfg.getBlock("WheatBag", blockIdVegiBag);
			Property blockCBox = cfg.getBlock("CharcoalContainer", blockIdCBox);
			Property blockMaker = cfg.getBlock("TeaMaker", blockIdMaker);
			Property blockECup = cfg.getBlock("EmptyCup", blockIdECup);
			Property blockSapT = cfg.getBlock("TeaSapling", blockIdSapT);
			Property blockTreeT = cfg.getBlock("TeaTree", blockIdTreeT);
			Property blockPan = cfg.getBlock("SoupPan", blockIdFPan);
			Property blockEPan = cfg.getBlock("EmptySoupPan", blockIdEPan);
			Property blockRack = cfg.getBlock("BowlRack", blockIdBowlRack);
			Property blockBowl = cfg.getBlock("BowlBlock", blockIdBowlBlock);
			Property blockFCup = cfg.getBlock("FilledCap", blockIdTeacupBlock);
			Property blockBasket = cfg.getBlock("BreadBasket", blockIdBasket);
			Property blockFlint = cfg.getBlock("FlintBlock", blockIdFlint);
			Property blockChalcedony = cfg.getBlock("Chalcedony", blockIdChalcedony);
			Property blockCLamp = cfg.getBlock("ChalcedonyLamp", blockIdCLamp);
			Property blockgunpawder = cfg.getBlock("GunpowderContainer", blockIdGContainer);
			Property blockteppann = cfg.getBlock("Teppann", blockIdTeppann);
			Property blockfoodPlate = cfg.getBlock("FoodPlate", blockIdFoodPlate);
			Property blockClamSand = cfg.getBlock("ClamSand", blockIdClamSand);
			Property blockemptyTeaMaker = cfg.getBlock("EmptyTeaMaker", blockIdEmptyTeaMaker);
			Property blockFPan2 = cfg.getBlock("SoupPan_2", blockIdFPan2);
			Property blockBowlJP = cfg.getBlock("BowlBlock_JP", blockIdBowlJP);
			Property blockChopsticks = cfg.getBlock("ChopstiksBox", blockIdChopsticks);
			Property blockEggs = cfg.getBlock("EggBasket", blockIdEggBasket);
			Property blockKinoko = cfg.getBlock("MushroomBlock", blockIdMushChair);
			Property blockMelonB = cfg.getBlock("CompressedMelon", blockIdMelonBomb);
			Property blockChocoPan = cfg.getBlock("SoupPan_3", blockIdChocoPan);
			Property blockChoco = cfg.getBlock("ChocolateGift", blockIdChocoDC);
			Property blockNext = cfg.getBlock("TeaMakerNext", blockIdMakerNext);
			Property blockAutoTea = cfg.getBlock("AutoTeaMaker", blockIdAutoMaker);
			Property blockIceMaker = cfg.getBlock("IceMaker", blockIdIceMaker);
			Property blockWipeBox = cfg.getBlock("WipesBox", blockIdWipeBox);
			Property blockIce = cfg.getBlock("IceCreamBlock", blockIdIceBlock);
			Property blockWipe2 = cfg.getBlock("PaperBox", blockIdWipe2);
			Property blockCup2 = cfg.getBlock("FilledCup2", blockIdTeaCup2);
			Property blockDial = cfg.getBlock("RoteryDial", blockIdDial);
			Property blockC = cfg.getBlock("Cocktail", blockIdCocktail);
			Property blockBottle = cfg.getBlock("LargeBottle", blockIdLargeBottle);
			Property blockCordial = cfg.getBlock("CordialBottle", blockIdCordial);
			Property blockCassisTree = cfg.getBlock("CassisTree", blockIdTreeC);
			Property blockAlcohol = cfg.getBlock("LiquorCup", blockIdAlcohol);
			Property blockCropMint = cfg.getBlock("MintCrop", blockIdCropMint);
			
			Property itemBapple = cfg.getItem("BakedApple", itemIdBapple);
			Property itemAppleT = cfg.getItem("AppleTart", itemIdAppleTart);
			Property itemToffyA  = cfg.getItem("ToffyApple", itemIdToffyApple);
			Property itemToffyI = cfg.getItem("IcyToffyApple", itemIdIcyToffy);
			Property itemEX = cfg.getItem("EXItems", itemIdEX);
			Property itemCMilk = cfg.getItem("CondensedMIlk", itemIdCMilk);
			Property itemInkStick = cfg.getItem("InkStick", itemIdInkStick);
			Property itemAppleSand = cfg.getItem("AppleSandwich", itemIdAppleSand);
			Property itemLeafT = cfg.getItem("TeaLeaf", itemIdLeafT);
			Property itemTCup = cfg.getItem("TeaCup", itemIdTeaCup);
			Property itemGrater = cfg.getItem("Grater", itemIdGrater);
			Property itemGratedA = cfg.getItem("GratedApple", itemIdGratedApple);
			Property itemMinced = cfg.getItem("MincedFoods", itemIdMinced);
			Property itemStew = cfg.getItem("StewBowl", itemIdDCStew);
			Property itemCKnife = cfg.getItem("ChalcedonyKnife", itemIdCKnife);
			Property itemCFStarter = cfg.getItem("Firestarter", itemIdCFireStarter);
			Property itemClam = cfg.getItem("Clam", itemIdClam);
			Property itemChopstick = cfg.getItem("Chopsticks", itemIdChopsticks);
			Property itemCHammer = cfg.getItem("ChalcedonyStoneCutter", itemIdCHammer);
			Property itemChoco = cfg.getItem("ChocolateFruits", itemIdChoco);
			Property itemIcyC = cfg.getItem("IcyCrystal", itemIdIcyCrystal);
			Property itemBottle = cfg.getItem("ItemLargeBottle", itemIdBottle);
			Property itemWallMug = cfg.getItem("FilledWallMug", itemIdWallMug);
			Property itemMilkBottle = cfg.getItem("MilkCan", itemIdMilkBottle);
			Property itemPrincess = cfg.getItem("PrincessClam", itemIdPClam);
			Property itemCordial = cfg.getItem("Cordial", itemIdCordial);
			Property itemSeedMint = cfg.getItem("MintSeed", itemIdSeedMint);
			
			Property DCpotionID = cfg.get("potionID", "Immunization", potionIDImmunity,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID2 = cfg.get("potionID", "Protection:Projectile", potionIDPrvProjectile,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID3 = cfg.get("potionID", "Protection:Explode", potionIDPrvExplode,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID4 = cfg.get("potionID", "Reflex", potionIDReflex,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID5 = cfg.get("potionID", "EXPAbsorption", potionIDAbsEXP,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID6 = cfg.get("potionID", "DamageAbsorption", potionIDAbsHeal,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID7 = cfg.get("potionID", "Suffocation", potionIDSuffocation,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			Property DCpotionID8 = cfg.get("potionID", "Protection:Suffocation", potionIDPrvSuffocation,
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");
			
			Property TeaTreeValue = cfg.get("world setting", "Tea Tree Gen Probability", teaTreeGenValue,
					"Set the generation probability of tea tree.(1-20) Default value is 5.");
			Property ClamValue = cfg.get("world setting", "Clam Gen Probability", clamChanceValue,
					"Set the generation probability and the increase probability of clam.(1-12) Default value is 5.");
			Property EXRecipe = cfg.get("setting", "Use Extra Recipe", useEXRecipe,
					"Add recipe for crafting tea tree sapling.");
			Property noTeaTree = cfg.get("world setting", "No Gen TeaTree", notGenTeaTree,
					"Not generating tea tree on overworld.");
			Property allowSlimeBall = cfg.get("setting", "Allow Slimeball OreDic",
					allowSlimeBallDic, "Allow to add SlimeBall and Animalglue to Oredictionary.");
			Property noSteam = cfg.get("render setting", "Not Render Foods Steam",
					noRenderFoodsSteam, "Not Render Steam on foods of this mod.");
			Property IC2Coffee = cfg.get("plugin setting", "Allow Use IC2 Coffee",
					useIC2Items, "Allow to use IC2coffee and cells in this mod.");
			Property noFirestarter = cfg.get("setting", "Disable Fierstarter",
					disableFireSteater, "Disable recipe for crafting firestarter.");
			Property noClam = cfg.get("world setting", "Disable Clams", disableClam,
					"Not generating clams on overworld.");
			Property nowetGC = cfg.get("Setting", "No Weathering Container",
					noWetGContainer, "Not weathering Gunpowdercontainer.");
			Property cupTex = cfg.get("render setting", "Set JPbowl Texture", setCupTexture,
					"Select the texture of the JP bowls."
					+ "1:cherry flowers, 2:blue pattern, 3:white porcelain");
			Property useSummer = cfg.get("render setting", "Use Summer Rendering", useSummerRender,
					"Use the Summer Rendering to the Cups.");
			Property useJPcup = cfg.get("render setting", "Use Japanese Style Cup", useJapaneseCup,
					"Use the Japanese style (Yunomi) Rendering to the Cups.");
			Property teppannHard = cfg.get("setting", "Teppann Hard Mode", teppannHardMode,
					"Enable time limit to get the food from the iron plate.");
			Property teppannTime = cfg.get("setting", "Teppann Ready Time", teppannReadyTime,
					"Set the length of time limit to get the food from the iron plate.(min 1 - max 60)");
			Property noCupDirection = cfg.get("setting", "Disable Cup Direction", noUseCupDirection,
					"Disable direction and TileEntity.(For example, the filled cups, the bread basket, and the JP bowls.)"
			        + BR + "If you wish to not put too many Entitys for reduce the load of your PC, please set true.");
			Property teppannRandom = cfg.get("setting", "Randomly Teppann Cooking Time", teppannRandomCookTime,
					"Enable randomly cooking time of iron plate.");
			Property entityMelon = cfg.get("entity", "EntityIDCompressedMelon", entityIdMelon,
					"If you want to use the Forge automatic setting, please set 0.");
			Property explodeMelon = cfg.get("entity", "EnableExplodeMelon", canExplodeMelon,
					"Allow the CompressedMelon explode.");
			Property oldFoods = cfg.get("setting", "Use Old Foods", useOldItems,
					"Enable old cupitems and bowlitems.");
			Property cupStackSizeInt = cfg.get("setting", "Cups Stack Size", cupStackSize,
					"Set stack seize of filled cups. Please choose from the 1/3/8.");
			Property melonBreak = cfg.get("entity", "Melon not Break Block", melonBreakBlock,
					"Disable destruction by explosion of melon.");
			Property safetyChoco = cfg.get("setting", "Safety Chocolate Gift", safetyChocolate,
					"Disable explosion of the heartfelt chocolate gift.");
			Property infinityWipes = cfg.get("setting", "Allow Infinity Wipes", allowInfinityWipes,
					"Allow the WipeBox generate a paper infinitely.");
			Property bonemealClams = cfg.get("setting", "Allow Clam Fertilizer", bonemealClam,
					"Allow to use the clam and the clam container as fertilizer.");
			Property achievementID = cfg.get("setting", "Shift Achivement ID", achievementShiftID,
					"Shift the ID of the achievement.");
			Property texPass = cfg.get("render setting", "Set Texture Type Number", setAltTexturePass,
					"Select the texture type number."
					+ "1:default(x16 tex), 2:use x32 tex");
			Property moisture = cfg.get("plugin setting", "Enable Moisture and Stamina", allowMoisture,
					"Allow healing (or damage) to the Moisture and the Stamina gauge, for SextiarySector.");
			Property cafeRecipe = cfg.get("entity", "New Villager ID", villagerRecipeID,
					"Set the number of new villager ID.");
			
			Property IC2ver = cfg.get("plugin setting", "Use version of IC2", IC2exp,
					"Please tell me version of IC2 you use. If you use IC2_exp, set true. If you use IC2_lf, set false.");
			Property TC4ver = cfg.get("plugin setting", "Use version of Thaumcraft4", TC4after405,
					"Please tell me version of Thaumcraft4 you use. If you use 4.0.4 or older, set false.");
			
			blockIdWoodBox = blockWoodBox.getInt();
			blockIdAppleBox = blockAppleBox.getInt();
			blockIdVegiBag = blockWheatBag.getInt();
			blockIdCBox = blockCBox.getInt();
			blockIdMaker = blockMaker.getInt();
			blockIdECup = blockECup.getInt();
			blockIdSapT = blockSapT.getInt();
			blockIdTreeT = blockTreeT.getInt();
			blockIdFPan = blockPan.getInt();
			blockIdEPan = blockEPan.getInt();
			blockIdBowlRack = blockRack.getInt();
			blockIdBowlBlock = blockBowl.getInt();
			blockIdTeacupBlock = blockFCup.getInt();
			blockIdBasket = blockBasket.getInt();
			blockIdFlint = blockFlint.getInt();
			blockIdChalcedony = blockChalcedony.getInt();
			blockIdCLamp = blockCLamp.getInt();
			blockIdGContainer = blockgunpawder.getInt();
			blockIdTeppann = blockteppann.getInt();
			blockIdFoodPlate = blockfoodPlate.getInt();
			blockIdClamSand = blockClamSand.getInt();
			blockIdEmptyTeaMaker = blockemptyTeaMaker.getInt();
			blockIdFPan2 = blockFPan2.getInt();
			blockIdBowlJP = blockBowlJP.getInt();
			blockIdChopsticks = blockChopsticks.getInt();
			blockIdEggBasket = blockEggs.getInt();
			blockIdMushChair = blockKinoko.getInt();
			blockIdMelonBomb = blockMelonB.getInt();
			blockIdChocoPan = blockChocoPan.getInt();
			blockIdChocoDC = blockChoco.getInt();
			blockIdMakerNext = blockNext.getInt();
			blockIdAutoMaker = blockAutoTea.getInt();
			blockIdIceMaker = blockIceMaker.getInt();
			blockIdWipeBox = blockWipeBox.getInt();
			blockIdWipe2 = blockWipe2.getInt();
			blockIdIceBlock = blockIce.getInt();
			blockIdTeaCup2 = blockCup2.getInt();
			blockIdDial = blockDial.getInt();
			blockIdCocktail = blockC.getInt();
			blockIdLargeBottle = blockBottle.getInt();
			blockIdCordial = blockCordial.getInt();
			blockIdTreeC = blockCassisTree.getInt();
			blockIdAlcohol = blockAlcohol.getInt();
			blockIdCropMint = blockCropMint.getInt();
			
			itemIdBapple = itemBapple.getInt();
			itemIdAppleTart = itemAppleT.getInt();
			itemIdToffyApple  = itemToffyA.getInt();
			itemIdIcyToffy  = itemToffyI.getInt();
			itemIdEX  = itemEX.getInt();
			itemIdCMilk  = itemCMilk.getInt();
			itemIdInkStick = itemInkStick.getInt();
			itemIdAppleSand = itemAppleSand.getInt();
			itemIdLeafT = itemLeafT.getInt();
			itemIdTeaCup = itemTCup.getInt();
			itemIdGratedApple = itemGratedA.getInt();
			itemIdMinced = itemMinced.getInt();
			itemIdGrater = itemGrater.getInt();
			itemIdDCStew = itemStew.getInt();
			itemIdCKnife = itemCKnife.getInt();
			itemIdCFireStarter = itemCFStarter.getInt();
			itemIdClam = itemClam.getInt();
			itemIdChopsticks = itemChopstick.getInt();
			itemIdCHammer = itemCHammer.getInt();
			itemIdChoco = itemChoco.getInt();
			itemIdIcyCrystal = itemIcyC.getInt();
			itemIdBottle = itemBottle.getInt();
			itemIdWallMug = itemWallMug.getInt();
			itemIdMilkBottle = itemMilkBottle.getInt();
			itemIdPClam = itemPrincess.getInt();
			itemIdCordial = itemCordial.getInt();
			itemIdSeedMint = itemSeedMint.getInt();
			
			potionIDImmunity = DCpotionID.getInt();
			potionIDPrvExplode = DCpotionID3.getInt();
			potionIDPrvProjectile = DCpotionID2.getInt();
			potionIDReflex = DCpotionID4.getInt();
			potionIDAbsEXP = DCpotionID5.getInt();
			potionIDAbsHeal = DCpotionID6.getInt();
			potionIDSuffocation = DCpotionID7.getInt();
			potionIDPrvSuffocation = DCpotionID8.getInt();
			
			teaTreeGenValue = TeaTreeValue.getInt();
			setCupTexture = cupTex.getInt();
			teppannReadyTime = teppannTime.getInt();
			cupStackSize = cupStackSizeInt.getInt();
			achievementShiftID = achievementID.getInt();
			setAltTexturePass = texPass.getInt();
			clamChanceValue = ClamValue.getInt();
			villagerRecipeID = cafeRecipe.getInt();
			
			useEXRecipe = EXRecipe.getBoolean(false);
			notGenTeaTree = noTeaTree.getBoolean(false);
			allowSlimeBallDic = allowSlimeBall.getBoolean(true);
			noRenderFoodsSteam = noSteam.getBoolean(false);
			useIC2Items = IC2Coffee.getBoolean(false);
			disableFireSteater = noFirestarter.getBoolean(false);
			disableClam = noClam.getBoolean(false);
			noWetGContainer = nowetGC.getBoolean(false);
			teppannHardMode = teppannHard.getBoolean(false);
			noUseCupDirection = noCupDirection.getBoolean(false);
			useSummerRender = useSummer.getBoolean(false);
			teppannRandomCookTime = teppannRandom.getBoolean(false);
			useOldItems = oldFoods.getBoolean(false);
			melonBreakBlock = melonBreak.getBoolean(false);
			safetyChocolate = safetyChoco.getBoolean(false);
			useJapaneseCup = useJPcup.getBoolean(false);
			allowMoisture = moisture.getBoolean(false);
			bonemealClam = bonemealClams.getBoolean(false);
			
			IC2exp = IC2ver.getBoolean(false);
			TC4after405 = TC4ver.getBoolean(false);
			
			entityIdMelon = entityMelon.getInt();
			canExplodeMelon = explodeMelon.getBoolean(false);
			
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Error Message");
			
		}
		finally
		{
			cfg.save();
		}
	}

}
