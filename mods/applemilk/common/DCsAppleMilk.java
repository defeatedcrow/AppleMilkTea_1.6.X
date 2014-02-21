package mods.applemilk.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import mods.applemilk.client.*;
import mods.applemilk.common.block.*;
import mods.applemilk.common.entity.EntityMelonBomb;
import mods.applemilk.common.item.*;
import mods.applemilk.common.tile.*;
import mods.applemilk.handler.*;
import mods.applemilk.handler.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.src.*;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = "DCsAppleMilk",
		name = "Apple&Milk&Tea!",
		version = "1.6.2_1.8a_dev",
		dependencies = "required-after:Forge@[9.10,);required-after:FML@[6.2,);after:IC2;after:Thaumcraft;after:BambooMod;after:pamharvestcraft;after:Forestry"
		)
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false,
		channels = {"DCsTeppan","DCsDirection","DCsRemaining","DCsTeaMaker","DCsIceMaker","DCsAutoMaker","DCsAutoMode"}, packetHandler = PacketHandler.class
		)

public class DCsAppleMilk{
	
	//プロキシの登録
	@SidedProxy(clientSide = "mods.applemilk.client.ClientProxy", serverSide = "mods.applemilk.common.CommonProxy")
	public static CommonProxy proxy;
	
	//インスタンスの生成
	@Instance("DCsAppleMilk")
    public static DCsAppleMilk instance;
	
	//クリエイティブタブの追加
	public static final CreativeTabs applemilk = new CreativeTabDCAM("applemilk");
	
	//ブロックのインスタンス
	public static Block  woodBox;
	public static Block  appleBox;
	public static Block  vegiBag;
	public static BlockCharcoalBox  charcoalBox;
	public static Block  teaMaker;
	public static Block  emptyCup;
	public static Block  saplingTea;
	public static Block  teaTree;
	public static Block  filledPan;
	public static Block  emptyPan;
	public static Block  bowlRack;
	public static Block  teacupBlock;
	public static Block  bowlBlock;
	public static Block  Basket;
	public static Block  flintBlock;
	public static Block  chalcedony;
	public static Block  cLamp;
	public static Block  gunpowderContainer;
	public static Block  teppann;
	public static Block  foodPlate;
	public static Block  clamSand;
	public static Block  emptyTeaMaker;
	public static Block  filledPan2;
	public static Block  bowlJP;
	public static Block  chopsticksBox;
	public static Block  eggBasket;
	public static Block  mushroomBox;
	public static Block  melonBomb;
	public static Block  filledChocoPan;
	public static Block  chocoBlock;
	public static Block  teaMakerNext;
	public static Block  autoMaker;
	public static Block  iceMaker;
	public static Block  wipeBox;
	
	//アイテムのインスタンス
	public static Item  bakedApple;
	public static Item  appleTart;
	public static Item  toffyApple;
	public static Item  icyToffyApple;
	public static Item  EXItems;
	public static Item  condensedMIlk;
	public static Item  inkStick;
	public static Item  appleSandwich;
	public static Item  leafTea;
	public static Item  teaCup;
	public static Item  gratedApple;
	public static Item  mincedFoods;
	public static Item  DCStew;
	public static ItemGrater  DCgrater;
	public static Item  chalcedonyKnife;
	public static Item  firestarter;
	public static Item  clam;
	public static Item  chopsticks;
	public static Item  chalcedonyHammer;
	public static Item  chocolateFruits;
	
	//ポーションのインスタンス
	public static Potion Immunization;
 
	//IDの初期設定
	public int blockIdWoodBox = 600;
	public int blockIdAppleBox = 601;
	public int blockIdVegiBag = 602;
	public int blockIdCBox = 603;
	public int blockIdMaker = 604;
	public int blockIdECup = 605;
	public int blockIdSapT = 606;
	public int blockIdTreeT = 607;
	public int blockIdFPan = 608;
	public int blockIdEPan = 609;
	public int blockIdBowlRack = 610;
	public int blockIdTeacupBlock = 599;
	public int blockIdBowlBlock = 598;
	public int blockIdBasket = 597;
	public int blockIdFlint = 596;
	public int blockIdChalcedony = 595;
	public int blockIdCLamp = 594;
	public int blockIdGContainer = 593;
	public int blockIdTeppann = 592;
	public int blockIdFoodPlate = 591;
	public int blockIdClamSand = 590;
	public int blockIdEmptyTeaMaker = 589;
	public int blockIdFPan2 = 588;
	public int blockIdBowlJP = 587;
	public int blockIdChopsticks = 611;
	public int blockIdEggBasket = 612;
	public int blockIdMushChair = 613;
	public int blockIdMelonBomb = 614;
	public int blockIdChocoPan = 586;
	public int blockIdChocoDC = 585;
	public int blockIdWipeBox = 584;
	public int blockIdMakerNext = 583;
	public int blockIdAutoMaker = 582;
	public int blockIdTeppanNext = 581;
	public int blockIdIceMaker = 580;
	
	public int itemIdBapple = 6000;
	public int itemIdAppleTart = 6001;
	public int itemIdToffyApple = 6002;
	public int itemIdIcyToffy = 6003;
	public int itemIdEX = 6004;
	public int itemIdCMilk = 6005;
	public int itemIdInkStick = 6006;
	public int itemIdAppleSand = 6007;
	public int itemIdLeafT = 6008;
	public int itemIdTeaCup = 6009;
	public int itemIdGratedApple = 5991;
	public int itemIdMinced = 5992;
	public int itemIdGrater = 5990;
	public int itemIdDCStew = 5993;
	public int itemIdCKnife = 5994;
	public int itemIdCFireStarter = 5995;
	public int itemIdClam = 5996;
	public int itemIdChopsticks = 5997;
	public int itemIdCHammer = 5998;
	public int itemIdChoco = 5999;
	
	public static int pothinIDImmunity = 25;
	public int entityIdMelon = 0;
	public int guiIdAutoMaker = 1;
	
	//コンフィグ項目の初期設定
	public static int teaTreeGenValue = 5;
	public static int setCupTexture = 1;
	public static int teppannReadyTime = 30;
	public static int cupStackSize = 1;
	
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
	
	public static boolean useIC2Items = true;
	public static boolean SuccessLoadIC2 = false;
	public static boolean SuccessLoadBamboo = false;
	public static boolean SuccessLoadBoP = false;
	public static boolean SuccessLoadTofu = false;
	public static boolean SuccessLoadThaumcraft = false;
	
	public static boolean IC2exp = true;
	public static boolean TC4after405 = true;
	
	//内部処理用
	public static boolean fanc_78842dcs = false;
	public static boolean fanc_78853dcs = false;
	public static boolean getServerPlop1 = true;
	public static boolean getServerPlop2 = false;
	public static boolean inClient = false;
	public static boolean inServer = false;
	public static boolean thirdParty = false;
	public static boolean debugMode = true;
	
	//新ツール属性の追加
	public static EnumToolMaterial enumToolMaterialChalcedony;
	
	//レンダー登録用ID
	public static int modelTeaMaker;
	public static int modelCup;
	public static int modelPan;
	public static int modelTeaTree;
	public static int modelFilledCup;
	public static int modelBowl;
	public static int modelRack;
	public static int modelCLamp;
	public static int modelBasket;
	public static int modelFoodPlate;
	public static int modelTeppann;
	public static int modelBowlJP;
	public static int modelCupSummer;
	public static int modelChopsticks;
	public static int modelKinoko;
	public static int modelEggBasket;
	public static int modelMelonBomb;
	public static int modelChocoPan;
	public static int modelMakerNext;
	public static int modelAutoMaker;
	
	//コンフィグファイル内で使う改行の記号
	private final String BR = System.getProperty("line.separator");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Configuration setting
		//コンフィグを生成する
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
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
			
			Property DCpotionID = cfg.get("potionID", "Immunization", pothinIDImmunity,
					"Set new potion ID for this mod. If you set 0, disable new potion effect.");
			
			Property TeaTreeValue = cfg.get("world setting", "Tea Tree Gen Probability", teaTreeGenValue,
					"Set the generation probability of tea tree.(1-20) Default value is 5.");
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
			
			pothinIDImmunity = DCpotionID.getInt();
			teaTreeGenValue = TeaTreeValue.getInt();
			setCupTexture = cupTex.getInt();
			teppannReadyTime = teppannTime.getInt();
			cupStackSize = cupStackSizeInt.getInt();
			
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
		
		//Registering
		//Material
		//ツール属性の内容を登録する
		enumToolMaterialChalcedony = EnumHelper.addToolMaterial("CHALCEDONY", 2, 128, 5.0F, 2.0F, 18);
		
		//ブロックやアイテムの読み込みと登録
		//foods
		bakedApple = (new ItemBakedApple(itemIdBapple - 256, 7, false)).
				setUnlocalizedName("defeatedcrow.bakedApple").
				setCreativeTab(applemilk);
		
		appleTart = (new ItemAppleTart(itemIdAppleTart - 256, 8, false)).
				setUnlocalizedName("defeatedcrow.appleTart").
				setCreativeTab(applemilk);
		
		toffyApple = (new ItemToffyApple(itemIdToffyApple - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.toffyApple").
				setCreativeTab(applemilk);
		
		icyToffyApple  = (new ItemIcyToffyApple(itemIdIcyToffy - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.icyToffyApple").
				setCreativeTab(applemilk);
		
		appleSandwich  = (new ItemAppleSandwich(itemIdAppleSand - 256, 3, false)).
				setUnlocalizedName("defeatedcrow.appleSandwich").
				setCreativeTab(applemilk);
		
		chocolateFruits = (new ItemChocoFruits(itemIdChoco - 256, 6, false)).
				setUnlocalizedName("defeatedcrow.fruitsChocolate").
				setCreativeTab(applemilk);
		
		//boxes
		woodBox = (new BlockWoodBox(blockIdWoodBox)).
				setUnlocalizedName("defeatedcrow.WoodBox").
				setCreativeTab(applemilk);
		
		appleBox = (new BlockAppleBox(blockIdAppleBox)).
				setUnlocalizedName("defeatedcrow.appleBox").
				setCreativeTab(applemilk);
		
		charcoalBox = (BlockCharcoalBox) (new BlockCharcoalBox(blockIdCBox)).
				setUnlocalizedName("defeatedcrow.charcoalContainer").
				setCreativeTab(applemilk);
		
		vegiBag = (new BlockVegiBag(blockIdVegiBag)).
				setUnlocalizedName("defeatedcrow.vegiBag").
				setCreativeTab(applemilk);
		
		gunpowderContainer = (new BlockGunpowderContainer(blockIdGContainer)).
				setUnlocalizedName("defeatedcrow.gunpowderContainer").
				setCreativeTab(applemilk);
		
		mushroomBox = (new BlockMushBox(blockIdMushChair)).
				setUnlocalizedName("defeatedcrow.mushroomBox").
				setCreativeTab(applemilk);
		
		eggBasket = (new BlockEggBasket(blockIdEggBasket)).
				setUnlocalizedName("defeatedcrow.eggBasket").
				setCreativeTab(applemilk);
		
		melonBomb = (new BlockMelonBomb(blockIdMelonBomb)).
				setUnlocalizedName("defeatedcrow.compressedMelon").
				setCreativeTab(applemilk);
		
		//tea
		teaMaker = (new BlockTeaMaker(blockIdMaker)).
				setUnlocalizedName("defeatedcrow.teaMaker");
		
		emptyTeaMaker = (new BlockEmptyTeaMaker(blockIdEmptyTeaMaker)).
				setUnlocalizedName("defeatedcrow.teaMakerEmpty");
		
		teaMakerNext = (new BlockTeaMakerNext(blockIdMakerNext)).
				setUnlocalizedName("defeatedcrow.teaMakerNext").
				setCreativeTab(applemilk);
		
		autoMaker = (new BlockAutoMaker(blockIdAutoMaker)).
				setUnlocalizedName("defeatedcrow.autoMaker").
				setCreativeTab(applemilk);
		
		emptyCup = (new BlockEmptyCup(blockIdECup)).
				setUnlocalizedName("defeatedcrow.emptyCup").
				setCreativeTab(applemilk);
		
		teacupBlock = (new BlockFilledCup(blockIdTeacupBlock)).
				setUnlocalizedName("defeatedcrow.filledCup");
		
		//pan
		filledPan = (new BlockFilledPan(blockIdFPan)).
				setUnlocalizedName("defeatedcrow.soupPan");
		
		filledPan2 = (new BlockFilledPan2(blockIdFPan2)).
				setUnlocalizedName("defeatedcrow.soupPan_2");
		
		filledChocoPan = (new BlockFilledChocoPan(blockIdChocoPan)).
				setUnlocalizedName("defeatedcrow.soupPan_3");
		
		emptyPan = (new BlockEmptyPan(blockIdEPan)).
				setUnlocalizedName("defeatedcrow.soupPanEmpty").
				setCreativeTab(applemilk);
		
		bowlBlock = (new BlockBowl(blockIdBowlBlock)).
				setUnlocalizedName("defeatedcrow.bowlBlock").
				setCreativeTab(applemilk);
		
		bowlJP = (new BlockBowlJP(blockIdBowlJP)).
				setUnlocalizedName("defeatedcrow.bowlBlockJP").
				setCreativeTab(applemilk);
		
		//baskets
		bowlRack = (new BlockBowlRack(blockIdBowlRack)).
				setUnlocalizedName("defeatedcrow.bowlRack").
				setCreativeTab(applemilk);
		
		Basket = (new BlockBasket(blockIdBasket)).
				setUnlocalizedName("defeatedcrow.basket").
				setCreativeTab(applemilk);
		
		chopsticksBox = (new BlockChopsticksBox(blockIdChopsticks)).
				setUnlocalizedName("defeatedcrow.chopsticksBox").
				setCreativeTab(applemilk);
		
		chopsticks = (new ItemChopsticks(itemIdChopsticks - 256)).
				setUnlocalizedName("defeatedcrow.chopsticks").
				setCreativeTab(applemilk);
		
		chocoBlock = (new BlockChocoGift(blockIdChocoDC)).
				setUnlocalizedName("defeatedcrow.chocolateGift").
				setCreativeTab(applemilk);

		
		//foods and grater
		leafTea  = (new ItemLeafTea(itemIdLeafT - 256)).
				setUnlocalizedName("defeatedcrow.leafTea").
				setCreativeTab(applemilk);
		
		gratedApple  = (new ItemGratedApple(itemIdGratedApple - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.gratedApple").
				setCreativeTab(applemilk);
		
		mincedFoods  = (new ItemMincedFoods(itemIdMinced - 256)).
				setUnlocalizedName("defeatedcrow.mincedItem").
				setCreativeTab(applemilk);
		
		DCgrater  = (ItemGrater)(new ItemGrater(itemIdGrater - 256)).
				setUnlocalizedName("defeatedcrow.grater").
				setCreativeTab(applemilk);
		
		//teppan
		foodPlate = (new BlockFoodPlate(blockIdFoodPlate)).
				setUnlocalizedName("defeatedcrow.foodPlate").
				setCreativeTab(applemilk);
		
		teppann = (new BlockTeppann(blockIdTeppann)).
				setUnlocalizedName("defeatedcrow.cookingIronPlate").
				setCreativeTab(applemilk);
		
		//tree
		saplingTea = (new BlockSaplingTea(blockIdSapT)).
				setUnlocalizedName("defeatedcrow.saplingTea").
				setCreativeTab(applemilk);
		
		teaTree = (new BlockTeaTree(blockIdTreeT)).
				setUnlocalizedName("defeatedcrow.teaTree").
				setCreativeTab(applemilk);
		
		//clam
		clam = (new ItemClam(itemIdClam - 256)).
				setUnlocalizedName("defeatedcrow.clam").
				setCreativeTab(applemilk);
		
		clamSand = (new BlockClamSand(blockIdClamSand)).
				setUnlocalizedName("defeatedcrow.clamSand").
				setCreativeTab(applemilk);
		
		//chalcedony
		flintBlock = (new BlockFlint(blockIdFlint, Material.rock, false)).
				setUnlocalizedName("defeatedcrow.flintBlock").
				setCreativeTab(applemilk);
		
		chalcedony = (new BlockChalcedony(blockIdChalcedony, Material.rock, false)).
				setUnlocalizedName("defeatedcrow.chalcedony").
				setCreativeTab(applemilk);
		
		cLamp = (new BlockChalcedonyLamp(blockIdCLamp, Material.glass, false)).
				setUnlocalizedName("defeatedcrow.chalcedonyLamp").
				setCreativeTab(applemilk);
		
		chalcedonyKnife = (new ItemChalcedonyKnife(itemIdCKnife - 256, enumToolMaterialChalcedony)).
				setUnlocalizedName("defeatedcrow.chalcedonyKnife").
				setCreativeTab(applemilk);
		
		firestarter = (new ItemFireStarter(itemIdCFireStarter - 256)).
				setUnlocalizedName("defeatedcrow.firestarter").
				setCreativeTab(applemilk);
		
		chalcedonyHammer = (new ItemChalcedonyHammer(itemIdCHammer - 256, enumToolMaterialChalcedony)).
				setUnlocalizedName("defeatedcrow.chalcedonyStoneCutter").
				setCreativeTab(applemilk);
		
		//another
		EXItems  = (new ItemEXItem(itemIdEX - 256)).
				setUnlocalizedName("defeatedcrow.extraItems").
				setCreativeTab(applemilk);
		
		condensedMIlk  = (new ItemCondensedMilk(itemIdCMilk - 256, 1, false)).
				setUnlocalizedName("defeatedcrow.condensedMilk").
				setCreativeTab(applemilk);
		
		inkStick  = (new ItemInkStick(itemIdInkStick - 256)).
				setUnlocalizedName("defeatedcrow.inkStick").
				setCreativeTab(applemilk);
		
		//ポーション効果の追加
		//コンフィグでIDに0を入れてある時は登録しない
		if (this.pothinIDImmunity != 0){
			Immunization = (new PotionImmunity(pothinIDImmunity, false, 7889559)).
					setPotionName("DCs.potion.immunization").setIconIndex(6, 1);
		}
		
		//old foods
		if (this.useOldItems)
		{
			DCStew  = (new ItemDCStew(itemIdDCStew - 256, 8, false)).
					setUnlocalizedName("defeatedcrow.stewbowl");
			
			teaCup  = (new ItemTeaCup(itemIdTeaCup - 256, 2, false)).
					setUnlocalizedName("defeatedcrow.teaCup");
			
			GameRegistry.registerItem(teaCup, "teaCup");
			GameRegistry.registerItem(DCStew,"DCStew");
		}
		
		GameRegistry.registerItem(bakedApple, "defeatedcrow.bakedApple");
		GameRegistry.registerItem(appleTart, "defeatedcrow.appleTart");
		GameRegistry.registerItem(appleSandwich, "defeatedcrow.appleSandwich");
		GameRegistry.registerItem(toffyApple, "defeatedcrow.toffyApple");
		GameRegistry.registerItem(icyToffyApple, "defeatedcrow.icyToffyApple");
		GameRegistry.registerItem(EXItems, "defeatedcrow.condensedMilk");
		GameRegistry.registerItem(condensedMIlk, "defeatedcrow.milkCandy");
		GameRegistry.registerItem(inkStick, "defeatedcrow.inkStick");
		GameRegistry.registerItem(leafTea, "defeatedcrow.leafTea");
		GameRegistry.registerItem(gratedApple,"defeatedcrow.gratedApple");
		GameRegistry.registerItem(mincedFoods,"defeatedcrow.mincedFoods");
		GameRegistry.registerItem(chalcedonyKnife,"defeatedcrow.chalcedonyKnife");
		GameRegistry.registerItem(firestarter,"defeatedcrow.firestarter");
		GameRegistry.registerItem(clam,"defeatedcrow.clam");
		GameRegistry.registerItem(chopsticks,"defeatedcrow.chopsticks");
		GameRegistry.registerItem(chalcedonyHammer,"defeatedcrow.chalcedonyStoneCutter");
		GameRegistry.registerItem(chocolateFruits,"defeatedcrow.chocolateFruits");
		
		GameRegistry.registerBlock(woodBox, ItemWoodBox.class, "defeatedcrow.WoodBox");
		GameRegistry.registerBlock(appleBox, "defeatedcrow.AppleBox");
		GameRegistry.registerBlock(vegiBag, ItemVegiBag.class, "defeatedcrow.VegiBag");
		GameRegistry.registerBlock(charcoalBox, "defeatedcrow.Charcoalcontainer");
		GameRegistry.registerFuelHandler(charcoalBox);
		GameRegistry.registerBlock(teaMaker, ItemTeaMaker.class, "defeatedcrow.teaMaker");
		GameRegistry.registerBlock(emptyCup, "defeatedcrow.emptyCup");
		GameRegistry.registerBlock(teacupBlock, ItemBlockTeaCup.class, "defeatedcrow.filledCup");
		GameRegistry.registerBlock(saplingTea, "defeatedcrow.saplingTea");
		GameRegistry.registerBlock(teaTree, ItemTeaTree.class, "defeatedcrow.teaTree");
		GameRegistry.registerBlock(filledPan, ItemFilledPan.class, "defeatedcrow.SoupPan");
		GameRegistry.registerBlock(emptyPan, "defeatedcrow.emptyPan");
		GameRegistry.registerBlock(bowlBlock, ItemBowlBlock.class, "defeatedcrow.bowlBlock");
		GameRegistry.registerBlock(bowlRack, ItemBowlRack.class, "defeatedcrow.bowlRack");
		GameRegistry.registerBlock(flintBlock, "defeatedcrow.flintBlock");
		GameRegistry.registerBlock(chalcedony, ItemChalcedony.class, "defeatedcrow.chalcedony");
		GameRegistry.registerBlock(cLamp, ItemChalcedonyLamp.class, "defeatedcrow.chalcedonyLamp");
		GameRegistry.registerBlock(Basket, ItemBreadBasket.class, "defeatedcrow.basket");
		GameRegistry.registerBlock(gunpowderContainer, ItemGunpowderContainer.class, "defeatedcrow.GunpowderContainer");
		GameRegistry.registerBlock(emptyTeaMaker, "defeatedcrow.emptyTeaMaker");
		GameRegistry.registerBlock(teppann, ItemTeppann.class, "defeatedcrow.teppann");
		GameRegistry.registerBlock(foodPlate, ItemFoodPlate.class, "defeatedcrow.foodPlate");
		GameRegistry.registerBlock(filledPan2, ItemFilledPan2.class, "defeatedcrow.soupPan2");
		GameRegistry.registerBlock(bowlJP, ItemBowlJP.class, "defeatedcrow.bowlJP");
		GameRegistry.registerBlock(clamSand, "defeatedcrow.clamSand");
		GameRegistry.registerBlock(chopsticksBox, ItemChopsticksBox.class,  "defeatedcrow.chopsticksBox");
		GameRegistry.registerBlock(eggBasket, ItemEggBasket.class,  "defeatedcrow.eggBasket");
		GameRegistry.registerBlock(mushroomBox, ItemMushBox.class,  "defeatedcrow.mushroomBox");
		GameRegistry.registerBlock(melonBomb, ItemMelonBomb.class,  "defeatedcrow.melonBomb");
		GameRegistry.registerBlock(filledChocoPan, "defeatedcrow.soupPan3");
		GameRegistry.registerBlock(chocoBlock, ItemChocoGift.class,  "defeatedcrow.chocolateGift");
		GameRegistry.registerBlock(teaMakerNext, "defeatedcrow.teaMakerNext");
		GameRegistry.registerBlock(autoMaker, "defeatedcrow.autoMaker");
		
		//クラフトで耐久が減るアイテムの登録
		GameRegistry.registerCraftingHandler(DCgrater);
		
	}

	
	@EventHandler
	public void init(FMLInitializationEvent event) throws IOException
	{
		//Registering TileEntity
		//TileEntityの登録はプロキシクラスに任せる
		proxy.registerTileEntity();
		
		//Registering Entity
		//Entityの登録
		if (this.entityIdMelon == 0) this.entityIdMelon = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityMelonBomb.class, "compressedMelon", this.entityIdMelon);
		EntityRegistry.registerModEntity(EntityMelonBomb.class, "compressedMelon", this.entityIdMelon, this, 250, 5, true);
		
		LanguageRegistry.instance().addStringLocalization("entity.compressedMelon.name", "Compressed Melon");
		LanguageRegistry.instance().addStringLocalization("entity.compressedMelon.name", "ja_JP", "圧縮メロン");
		
		//Checking Server Prop.
		//サーバーのプロパティを取得しようとして失敗した跡
		System.out.println("[AppleMilk]Checking server propaty.");
		proxy.networkUtil();
		
		//Registering new Recipe
		//レシピや言語の登録は長くなるので専用クラスに任せる
		(new DCsRecipeRegister()).addRecipe();
		
		(new AddChestGen()).addChestItems();
		
		(new DCsLangRegister()).registerLang();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		//地形生成イベントの登録
		//コンフィグでONのときだけ読み込まれる
		if (!notGenTeaTree)
		{
			if (this.teaTreeGenValue < 0) this.teaTreeGenValue = 1;
			if (this.teaTreeGenValue > 20) this.teaTreeGenValue = 20;
			
			GameRegistry.registerWorldGenerator(new WorldgenTeaTree());
		}
		
		if (!disableClam)
		{
			GameRegistry.registerWorldGenerator(new WorldgenClam());
		}
		
		//Registering new event
		//ポーション効果の内容をLivingEventで作ったのでそれの読み込み
		MinecraftForge.EVENT_BUS.register(new DCsLivingEvent());
		
		//Registering new Render
		//新しいレンダーIDの登録もプロキシクラス内でやる
		//サーバ側で誤ってクライアント専用のクラス（レンダー関係）を読み込ませないため
		this.modelTeaMaker = proxy.getRenderID();
		this.modelCup = proxy.getRenderID();
		this.modelPan = proxy.getRenderID();
		this.modelTeaTree = proxy.getRenderID();
		this.modelFilledCup = proxy.getRenderID();
		this.modelBowl = proxy.getRenderID();
		this.modelRack = proxy.getRenderID();
		this.modelCLamp = proxy.getRenderID();
		this.modelBasket = proxy.getRenderID();
		this.modelFoodPlate = proxy.getRenderID();
		this.modelTeppann = proxy.getRenderID();
		this.modelBowlJP = proxy.getRenderID();
		this.modelCupSummer = proxy.getRenderID();
		this.modelChopsticks = proxy.getRenderID();
		this.modelEggBasket = proxy.getRenderID();
		this.modelKinoko = proxy.getRenderID();
		this.modelMelonBomb = proxy.getRenderID();
		this.modelChocoPan = proxy.getRenderID();
		this.modelMakerNext = proxy.getRenderID();
		this.modelAutoMaker = proxy.getRenderID();
		proxy.registerRenderers();
	      
	    //Registering OreDictionary  
		//ForgeのOreDicyionaryの登録部分
	    OreDictionary.registerOre("dyeBlack", new ItemStack(this.inkStick));
	    OreDictionary.registerOre("dyeOrange", new ItemStack(this.EXItems,1,4));
	    OreDictionary.registerOre("treeSapling", new ItemStack(this.saplingTea));
	    OreDictionary.registerOre("saplingTea", new ItemStack(this.saplingTea));
	    OreDictionary.registerOre("foodClam", new ItemStack(this.clam, 1, 0));
	    OreDictionary.registerOre("cropTea", new ItemStack(this.leafTea));
	    OreDictionary.registerOre("foodCondencedMilk", new ItemStack(this.condensedMIlk,1));
	    OreDictionary.registerOre("foodGreenTea", new ItemStack(this.EXItems,1,2));
	    OreDictionary.registerOre("foodTea", new ItemStack(this.EXItems,1,3));
	    OreDictionary.registerOre("foodCoffee", new ItemStack(this.gratedApple,1,3));
	    OreDictionary.registerOre("cropRice", new ItemStack(this.mincedFoods,1,3));
	    
	    OreDictionary.registerOre("foodToffyApple", new ItemStack(this.toffyApple));
	    OreDictionary.registerOre("foodAppleTart", new ItemStack(this.appleTart));
	    OreDictionary.registerOre("foodBakedApple", new ItemStack(this.bakedApple));
	    OreDictionary.registerOre("foodAppleSandwich", new ItemStack(this.appleSandwich,1,0));
	    OreDictionary.registerOre("foodEggSandwich", new ItemStack(this.appleSandwich,1,1));
	    OreDictionary.registerOre("foodCookedClam", new ItemStack(this.clam, 1, 1));
	    OreDictionary.registerOre("wheatRice", new ItemStack(this.bowlJP, 1, 0));
	    
	    OreDictionary.registerOre("blockChalcedony", new ItemStack(this.chalcedony, 1, 0));
	    OreDictionary.registerOre("toolGrater", new ItemStack(this.DCgrater));
	    OreDictionary.registerOre("blockTeaMaker", new ItemStack(this.teaMakerNext));
	    OreDictionary.registerOre("blockEmptyCup", new ItemStack(this.emptyCup));
	    OreDictionary.registerOre("blockEmptyPan", new ItemStack(this.emptyPan));
	    
	    if (this.allowSlimeBallDic)
	    {
	    	OreDictionary.registerOre("dropSlime", new ItemStack(Item.slimeBall));
		    OreDictionary.registerOre("dropSlime", new ItemStack(this.EXItems,1,1));
	    }
	    
	    for(int i = 0; i < 13 ; i++){
	    	OreDictionary.registerOre("foodFruitsChocolate", new ItemStack(this.chocolateFruits, 1, i));
	    }
	    
	    //registering TeaMaker recipe, It's still in testing yet.
	    //ティーメーカーのレシピ数の無限化のため、専用のレシピ登録クラスを用意した
	    System.out.println("[AppleMilk]Registering new tea maker recipe.");
	    (new RegisterMakerRecipe()).registerTea();
	    
	}
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		
		//Checking another mods
		//他のMODのブロック・アイテム登録クラスに先行しないよう、postInitメソッドでロードする
		(new LoadOreDicHandler()).load();
		
	    if (Loader.isModLoaded("IC2") && DCsAppleMilk.useIC2Items)
	    {
	        try
	        {
	          this.SuccessLoadIC2 = true;
	          (new LoadIC2Handler()).load();
	        }
	        catch (Exception e) {
	          System.out.println("[AppleMilk]Failed to check IC2");
	          e.printStackTrace(System.err);
	        }
	    }
	    
	    if (Loader.isModLoaded("BambooMod"))
	    {
	        try
	        {
	          this.SuccessLoadBamboo = true;
	          (new LoadBambooHandler()).load();
	          
	        }
	        catch (Exception e) {
	          System.out.println("[AppleMilk]Failed to check BambooMod");
	          e.printStackTrace(System.err);
	        }
	    }
	    
	    if (Loader.isModLoaded("TofuCraft"))
	    {
	        try
	        {
	          this.SuccessLoadTofu = true;
	          (new LoadTofuHandler()).load();
	          
	        }
	        catch (Exception e) {
	          System.out.println("[AppleMilk]Failed to check TofuCraft");
	          e.printStackTrace(System.err);
	        }
	    }
	    
	    if (Loader.isModLoaded("Thaumcraft"))
	    {
	        try
	        {
	          this.SuccessLoadThaumcraft = true;
	          (new LoadThaumcraftHandler()).load();
	          
	        }
	        catch (Exception e) {
	          System.out.println("[AppleMilk]Failed to check Thaumcraft");
	          e.printStackTrace(System.err);
	        }
	    }
    }
	
}
