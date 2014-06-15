package mods.applemilk.common;

import mods.applemilk.common.block.*;
import mods.applemilk.common.item.*;
import mods.applemilk.potion.*;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.registry.GameRegistry;

public class MaterialRegister {
	
	public void load()
	{
		DCsAppleMilk.bakedApple = (new ItemBakedApple(DCsConfig.itemIdBapple - 256, 7, false)).
				setUnlocalizedName("defeatedcrow.bakedApple").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.appleTart = (new ItemAppleTart(DCsConfig.itemIdAppleTart - 256, 8, false)).
				setUnlocalizedName("defeatedcrow.appleTart").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.toffyApple = (new ItemToffyApple(DCsConfig.itemIdToffyApple - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.toffyApple").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.icyToffyApple  = (new ItemIcyToffyApple(DCsConfig.itemIdIcyToffy - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.icyToffyApple").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.appleSandwich  = (new ItemAppleSandwich(DCsConfig.itemIdAppleSand - 256, 3, false)).
				setUnlocalizedName("defeatedcrow.appleSandwich").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chocolateFruits = (new ItemChocoFruits(DCsConfig.itemIdChoco - 256, 6, false)).
				setUnlocalizedName("defeatedcrow.fruitsChocolate").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//boxes
		DCsAppleMilk.woodBox = (new BlockWoodBox(DCsConfig.blockIdWoodBox)).
				setUnlocalizedName("defeatedcrow.WoodBox").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.appleBox = (new BlockAppleBox(DCsConfig.blockIdAppleBox)).
				setUnlocalizedName("defeatedcrow.appleBox").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.charcoalBox = (BlockCharcoalBox) (new BlockCharcoalBox(DCsConfig.blockIdCBox)).
				setUnlocalizedName("defeatedcrow.charcoalContainer").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.vegiBag = (new BlockVegiBag(DCsConfig.blockIdVegiBag)).
				setUnlocalizedName("defeatedcrow.vegiBag").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.gunpowderContainer = (new BlockGunpowderContainer(DCsConfig.blockIdGContainer)).
				setUnlocalizedName("defeatedcrow.gunpowderContainer").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.mushroomBox = (new BlockMushBox(DCsConfig.blockIdMushChair)).
				setUnlocalizedName("defeatedcrow.mushroomBox").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.eggBasket = (new BlockEggBasket(DCsConfig.blockIdEggBasket)).
				setUnlocalizedName("defeatedcrow.eggBasket").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.melonBomb = (new BlockMelonBomb(DCsConfig.blockIdMelonBomb)).
				setUnlocalizedName("defeatedcrow.compressedMelon").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.wipeBox = (new BlockWipeBox(DCsConfig.blockIdWipeBox)).
				setUnlocalizedName("defeatedcrow.wipeBox").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.wipeBox2 = (new BlockWipeBox2(DCsConfig.blockIdWipe2)).
				setUnlocalizedName("defeatedcrow.wipeBox2");
		
		//tea
		DCsAppleMilk.teaMaker = (new BlockTeaMaker(DCsConfig.blockIdMaker)).
				setUnlocalizedName("defeatedcrow.teaMaker");
		
		DCsAppleMilk.emptyTeaMaker = (new BlockEmptyTeaMaker(DCsConfig.blockIdEmptyTeaMaker)).
				setUnlocalizedName("defeatedcrow.teaMakerEmpty");
		
		DCsAppleMilk.teaMakerNext = (new BlockTeaMakerNext(DCsConfig.blockIdMakerNext)).
				setUnlocalizedName("defeatedcrow.teaMakerNext").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.autoMaker = (new BlockAutoMaker(DCsConfig.blockIdAutoMaker)).
				setUnlocalizedName("defeatedcrow.autoMaker").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.emptyCup = (new BlockEmptyCup(DCsConfig.blockIdECup)).
				setUnlocalizedName("defeatedcrow.emptyCup").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.teacupBlock = (new BlockFilledCup(DCsConfig.blockIdTeacupBlock)).
				setUnlocalizedName("defeatedcrow.filledCup");
		
		DCsAppleMilk.teaCup2 = (new BlockFilledCup2(DCsConfig.blockIdTeaCup2)).
				setUnlocalizedName("defeatedcrow.filledCup2");
		
		DCsAppleMilk.wallMug = (new ItemWallMug(DCsConfig.itemIdWallMug - 256)).
				setUnlocalizedName("defeatedcrow.wallMug").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//pan
		DCsAppleMilk.filledPan = (new BlockFilledPan(DCsConfig.blockIdFPan)).
				setUnlocalizedName("defeatedcrow.soupPan");
		
		DCsAppleMilk.filledPan2 = (new BlockFilledPan2(DCsConfig.blockIdFPan2)).
				setUnlocalizedName("defeatedcrow.soupPan_2");
		
		DCsAppleMilk.filledChocoPan = (new BlockFilledChocoPan(DCsConfig.blockIdChocoPan)).
				setUnlocalizedName("defeatedcrow.soupPan_3");
		
		DCsAppleMilk.emptyPan = (new BlockEmptyPan(DCsConfig.blockIdEPan)).
				setUnlocalizedName("defeatedcrow.soupPanEmpty").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.bowlBlock = (new BlockBowl(DCsConfig.blockIdBowlBlock)).
				setUnlocalizedName("defeatedcrow.bowlBlock").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.bowlJP = (new BlockBowlJP(DCsConfig.blockIdBowlJP)).
				setUnlocalizedName("defeatedcrow.bowlBlockJP").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//baskets
		DCsAppleMilk.bowlRack = (new BlockBowlRack(DCsConfig.blockIdBowlRack)).
				setUnlocalizedName("defeatedcrow.bowlRack").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.Basket = (new BlockBasket(DCsConfig.blockIdBasket)).
				setUnlocalizedName("defeatedcrow.basket").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chopsticksBox = (new BlockChopsticksBox(DCsConfig.blockIdChopsticks)).
				setUnlocalizedName("defeatedcrow.chopsticksBox").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chopsticks = (new ItemChopsticks(DCsConfig.itemIdChopsticks - 256)).
				setUnlocalizedName("defeatedcrow.chopsticks").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chocoBlock = (new BlockChocoGift(DCsConfig.blockIdChocoDC)).
				setUnlocalizedName("defeatedcrow.chocolateGift").
				setCreativeTab(DCsAppleMilk.applemilk);

		
		//foods and grater
		DCsAppleMilk.leafTea  = (new ItemLeafTea(DCsConfig.itemIdLeafT - 256)).
				setUnlocalizedName("defeatedcrow.leafTea").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.gratedApple  = (new ItemGratedApple(DCsConfig.itemIdGratedApple - 256, 4, false)).
				setUnlocalizedName("defeatedcrow.gratedApple").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.mincedFoods  = (new ItemMincedFoods(DCsConfig.itemIdMinced - 256)).
				setUnlocalizedName("defeatedcrow.mincedItem").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.DCgrater  = (ItemGrater)(new ItemGrater(DCsConfig.itemIdGrater - 256)).
				setUnlocalizedName("defeatedcrow.grater").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//teppan
		DCsAppleMilk.foodPlate = (new BlockFoodPlate(DCsConfig.blockIdFoodPlate)).
				setUnlocalizedName("defeatedcrow.foodPlate").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.teppann = (new BlockTeppann(DCsConfig.blockIdTeppann)).
				setUnlocalizedName("defeatedcrow.cookingIronPlate").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//IceMaker
		DCsAppleMilk.iceMaker = (new BlockIceMaker(DCsConfig.blockIdIceMaker)).
				setUnlocalizedName("defeatedcrow.iceMaker").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.blockIcecream = (new BlockIceCream(DCsConfig.blockIdIceBlock)).
				setUnlocalizedName("defeatedcrow.iceCreamBlock").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.icyCrystal = (new ItemIcyCrystal(DCsConfig.itemIdIcyCrystal - 256)).
				setUnlocalizedName("defeatedcrow.icyCrystal").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.cocktail = (new BlockCocktail(DCsConfig.blockIdCocktail)).
				setUnlocalizedName("defeatedcrow.cocktail").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.largeBottle = (new BlockLargeBottle(DCsConfig.blockIdLargeBottle)).
				setUnlocalizedName("defeatedcrow.largeBottle");
		
		DCsAppleMilk.itemLargeBottle = (ItemLargeBottle) (new ItemLargeBottle(DCsConfig.itemIdBottle - 256)).
				setUnlocalizedName("defeatedcrow.itemBottle").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.cordial = (new BlockCordial(DCsConfig.blockIdCordial)).
				setUnlocalizedName("defeatedcrow.blockCordial");
		
		DCsAppleMilk.itemCordial = (new ItemCordial(DCsConfig.itemIdCordial - 256)).
				setUnlocalizedName("defeatedcrow.itemCordial").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.alcoholCup = (new BlockAlcoholCup(DCsConfig.blockIdAlcohol)).
				setUnlocalizedName("defeatedcrow.alcoholCup").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//tree
		DCsAppleMilk.saplingTea = (new BlockSaplingTea(DCsConfig.blockIdSapT)).
				setUnlocalizedName("defeatedcrow.saplingTea").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.teaTree = (new BlockTeaTree(DCsConfig.blockIdTreeT)).
				setUnlocalizedName("defeatedcrow.teaTree").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.cassisTree = (new BlockCassisTree(DCsConfig.blockIdTreeC)).
				setUnlocalizedName("defeatedcrow.cassisTree").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//clam
		DCsAppleMilk.clam = (new ItemClam(DCsConfig.itemIdClam - 256)).
				setUnlocalizedName("defeatedcrow.clam").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.princessClam = (new ItemPrincessClam(DCsConfig.itemIdPClam - 256)).
				setUnlocalizedName("defeatedcrow.princessClam").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.clamSand = (new BlockClamSand(DCsConfig.blockIdClamSand)).
				setUnlocalizedName("defeatedcrow.clamSand").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//chalcedony
		DCsAppleMilk.flintBlock = (new BlockFlint(DCsConfig.blockIdFlint, Material.rock, false)).
				setUnlocalizedName("defeatedcrow.flintBlock").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chalcedony = (new BlockChalcedony(DCsConfig.blockIdChalcedony, Material.rock, false)).
				setUnlocalizedName("defeatedcrow.chalcedony").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.cLamp = (new BlockChalcedonyLamp(DCsConfig.blockIdCLamp, Material.glass, false)).
				setUnlocalizedName("defeatedcrow.chalcedonyLamp").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chalcedonyKnife = (new ItemChalcedonyKnife(DCsConfig.itemIdCKnife - 256, DCsAppleMilk.enumToolMaterialChalcedony)).
				setUnlocalizedName("defeatedcrow.chalcedonyKnife").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.firestarter = (new ItemFireStarter(DCsConfig.itemIdCFireStarter - 256)).
				setUnlocalizedName("defeatedcrow.firestarter").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.chalcedonyHammer = (new ItemChalcedonyHammer(DCsConfig.itemIdCHammer - 256, DCsAppleMilk.enumToolMaterialChalcedony)).
				setUnlocalizedName("defeatedcrow.chalcedonyStoneCutter").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//another
		DCsAppleMilk.EXItems  = (new ItemEXItem(DCsConfig.itemIdEX - 256)).
				setUnlocalizedName("defeatedcrow.extraItems").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.condensedMIlk  = (new ItemCondensedMilk(DCsConfig.itemIdCMilk - 256, 1, false)).
				setUnlocalizedName("defeatedcrow.condensedMilk").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.inkStick  = (new ItemInkStick(DCsConfig.itemIdInkStick - 256)).
				setUnlocalizedName("defeatedcrow.inkStick").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		DCsAppleMilk.rotaryDial = (new BlockRotaryDial(DCsConfig.blockIdDial)).
				setUnlocalizedName("defeatedcrow.rotaryDial").
				setCreativeTab(DCsAppleMilk.applemilk);
		
		//old foods
		if (DCsConfig.useOldItems)
		{
			DCsAppleMilk.DCStew  = (new ItemDCStew(DCsConfig.itemIdDCStew - 256, 8, false)).
					setUnlocalizedName("defeatedcrow.stewbowl");
			
			DCsAppleMilk.teaCup  = (new ItemTeaCup(DCsConfig.itemIdTeaCup - 256, 2, false)).
					setUnlocalizedName("defeatedcrow.teaCup");
			
			GameRegistry.registerItem(DCsAppleMilk.teaCup, "teaCup");
			GameRegistry.registerItem(DCsAppleMilk.DCStew,"DCStew");
		}
		
		GameRegistry.registerItem(DCsAppleMilk.bakedApple, "defeatedcrow.bakedApple");
		GameRegistry.registerItem(DCsAppleMilk.appleTart, "defeatedcrow.appleTart");
		GameRegistry.registerItem(DCsAppleMilk.appleSandwich, "defeatedcrow.appleSandwich");
		GameRegistry.registerItem(DCsAppleMilk.toffyApple, "defeatedcrow.toffyApple");
		GameRegistry.registerItem(DCsAppleMilk.icyToffyApple, "defeatedcrow.icyToffyApple");
		GameRegistry.registerItem(DCsAppleMilk.EXItems, "defeatedcrow.condensedMilk");
		GameRegistry.registerItem(DCsAppleMilk.condensedMIlk, "defeatedcrow.milkCandy");
		GameRegistry.registerItem(DCsAppleMilk.inkStick, "defeatedcrow.inkStick");
		GameRegistry.registerItem(DCsAppleMilk.leafTea, "defeatedcrow.leafTea");
		GameRegistry.registerItem(DCsAppleMilk.gratedApple,"defeatedcrow.gratedApple");
		GameRegistry.registerItem(DCsAppleMilk.mincedFoods,"defeatedcrow.mincedFoods");
		GameRegistry.registerItem(DCsAppleMilk.chalcedonyKnife,"defeatedcrow.chalcedonyKnife");
		GameRegistry.registerItem(DCsAppleMilk.firestarter,"defeatedcrow.firestarter");
		GameRegistry.registerItem(DCsAppleMilk.clam,"defeatedcrow.clam");
		GameRegistry.registerItem(DCsAppleMilk.chopsticks,"defeatedcrow.chopsticks");
		GameRegistry.registerItem(DCsAppleMilk.chalcedonyHammer,"defeatedcrow.chalcedonyStoneCutter");
		GameRegistry.registerItem(DCsAppleMilk.chocolateFruits,"defeatedcrow.chocolateFruits");
		GameRegistry.registerItem(DCsAppleMilk.icyCrystal,"defeatedcrow.icyCrystal");
		GameRegistry.registerItem(DCsAppleMilk.DCgrater,"defeatedcrow.grater");
		GameRegistry.registerItem(DCsAppleMilk.itemLargeBottle,"defeatedcrow.itemBottle");
		GameRegistry.registerItem(DCsAppleMilk.wallMug,"defeatedcrow.wallMug");
		GameRegistry.registerItem(DCsAppleMilk.princessClam,"defeatedcrow.princessClam");
		GameRegistry.registerItem(DCsAppleMilk.itemCordial,"defeatedcrow.itemCordial");
		
		GameRegistry.registerBlock(DCsAppleMilk.woodBox, ItemWoodBox.class, "defeatedcrow.WoodBox");
		GameRegistry.registerBlock(DCsAppleMilk.appleBox, "defeatedcrow.AppleBox");
		GameRegistry.registerBlock(DCsAppleMilk.vegiBag, ItemVegiBag.class, "defeatedcrow.VegiBag");
		GameRegistry.registerBlock(DCsAppleMilk.charcoalBox, "defeatedcrow.Charcoalcontainer");
		GameRegistry.registerFuelHandler(DCsAppleMilk.charcoalBox);
		GameRegistry.registerBlock(DCsAppleMilk.teaMaker, ItemTeaMaker.class, "defeatedcrow.teaMaker");
		GameRegistry.registerBlock(DCsAppleMilk.emptyCup, "defeatedcrow.emptyCup");
		GameRegistry.registerBlock(DCsAppleMilk.teacupBlock, ItemBlockTeaCup.class, "defeatedcrow.filledCup");
		GameRegistry.registerBlock(DCsAppleMilk.saplingTea, ItemTeaSapling.class, "defeatedcrow.saplingTea");
		GameRegistry.registerBlock(DCsAppleMilk.teaTree, ItemTeaTree.class, "defeatedcrow.teaTree");
		GameRegistry.registerBlock(DCsAppleMilk.cassisTree, ItemCassisTree.class, "defeatedcrow.cassisTree");
		GameRegistry.registerBlock(DCsAppleMilk.filledPan, ItemFilledPan.class, "defeatedcrow.SoupPan");
		GameRegistry.registerBlock(DCsAppleMilk.emptyPan, "defeatedcrow.emptyPan");
		GameRegistry.registerBlock(DCsAppleMilk.bowlBlock, ItemBowlBlock.class, "defeatedcrow.bowlBlock");
		GameRegistry.registerBlock(DCsAppleMilk.bowlRack, ItemBowlRack.class, "defeatedcrow.bowlRack");
		GameRegistry.registerBlock(DCsAppleMilk.flintBlock, "defeatedcrow.flintBlock");
		GameRegistry.registerBlock(DCsAppleMilk.chalcedony, ItemChalcedony.class, "defeatedcrow.chalcedony");
		GameRegistry.registerBlock(DCsAppleMilk.cLamp, ItemChalcedonyLamp.class, "defeatedcrow.chalcedonyLamp");
		GameRegistry.registerBlock(DCsAppleMilk.Basket, ItemBreadBasket.class, "defeatedcrow.basket");
		GameRegistry.registerBlock(DCsAppleMilk.gunpowderContainer, ItemGunpowderContainer.class, "defeatedcrow.GunpowderContainer");
		GameRegistry.registerBlock(DCsAppleMilk.emptyTeaMaker, "defeatedcrow.emptyTeaMaker");
		GameRegistry.registerBlock(DCsAppleMilk.teppann, ItemTeppann.class, "defeatedcrow.teppann");
		GameRegistry.registerBlock(DCsAppleMilk.foodPlate, ItemFoodPlate.class, "defeatedcrow.foodPlate");
		GameRegistry.registerBlock(DCsAppleMilk.filledPan2, ItemFilledPan2.class, "defeatedcrow.soupPan2");
		GameRegistry.registerBlock(DCsAppleMilk.bowlJP, ItemBowlJP.class, "defeatedcrow.bowlJP");
		GameRegistry.registerBlock(DCsAppleMilk.clamSand, ItemClamSand.class, "defeatedcrow.clamSand");
		GameRegistry.registerBlock(DCsAppleMilk.chopsticksBox, ItemChopsticksBox.class,  "defeatedcrow.chopsticksBox");
		GameRegistry.registerBlock(DCsAppleMilk.eggBasket, ItemEggBasket.class,  "defeatedcrow.eggBasket");
		GameRegistry.registerBlock(DCsAppleMilk.mushroomBox, ItemMushBox.class,  "defeatedcrow.mushroomBox");
		GameRegistry.registerBlock(DCsAppleMilk.melonBomb, ItemMelonBomb.class,  "defeatedcrow.melonBomb");
		GameRegistry.registerBlock(DCsAppleMilk.filledChocoPan, "defeatedcrow.soupPan3");
		GameRegistry.registerBlock(DCsAppleMilk.chocoBlock, ItemChocoGift.class,  "defeatedcrow.chocolateGift");
		GameRegistry.registerBlock(DCsAppleMilk.teaMakerNext, "defeatedcrow.teaMakerNext");
		GameRegistry.registerBlock(DCsAppleMilk.autoMaker, "defeatedcrow.autoMaker");
		GameRegistry.registerBlock(DCsAppleMilk.wipeBox, ItemWipeBox.class, "defeatedcrow.wipeBox");
		GameRegistry.registerBlock(DCsAppleMilk.wipeBox2, ItemWipeBox2.class, "defeatedcrow.wipeBox2");
		GameRegistry.registerBlock(DCsAppleMilk.iceMaker, "defeatedcrow.iceMaker");
		GameRegistry.registerBlock(DCsAppleMilk.blockIcecream, ItemIceBlock.class, "defeatedcrow.iceCreamBlock");
		GameRegistry.registerBlock(DCsAppleMilk.teaCup2, ItemBlockTeaCup2.class, "defeatedcrow.filledCup2");
		GameRegistry.registerBlock(DCsAppleMilk.rotaryDial, "defeatedcrow.rotaryDial");
		GameRegistry.registerBlock(DCsAppleMilk.cocktail, ItemCocktail.class, "defeatedcrow.cocktail");
		GameRegistry.registerBlock(DCsAppleMilk.largeBottle, "defeatedcrow.largeBottle");
		GameRegistry.registerBlock(DCsAppleMilk.cordial, ItemBlockCordial.class, "defeatedcrow.blockCordial");
		GameRegistry.registerBlock(DCsAppleMilk.alcoholCup, ItemAlcoholCup.class, "defeatedcrow.alcoholCup");
	}
	
	public void addPotion()
	{
		//ポーション効果の追加
		//コンフィグでIDが33~127の範囲内の時のみ追加する。
		if (Potion.potionTypes[DCsConfig.potionIDImmunity] == null && DCsConfig.potionIDImmunity < 128){
			DCsAppleMilk.Immunization = (new PotionImmunity(DCsConfig.potionIDImmunity, false, 7889559)).
					setPotionName("DCs.potion.immunization").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : Immunization of DCsAppleMilk");
        }
		if (Potion.potionTypes[DCsConfig.potionIDPrvExplode] == null && DCsConfig.potionIDPrvExplode < 128){
			DCsAppleMilk.prvExplode = (new PotionProtectionEX(DCsConfig.potionIDPrvExplode, false, 3237665,
					false, true, false, DamageSource.anvil)).
					setPotionName("DCs.potion.protectionExplode").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : Explode Protection of DCsAppleMilk");
        }
		if (Potion.potionTypes[DCsConfig.potionIDPrvProjectile] == null && DCsConfig.potionIDPrvProjectile < 128){
			DCsAppleMilk.prvProjectile = (new PotionProtectionEX(DCsConfig.potionIDPrvProjectile, false, 1151526,
					false, false, true, DamageSource.magic)).
					setPotionName("DCs.potion.protectionProjectile").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : Projectile Protection of DCsAppleMIlk");
        }
		if (Potion.potionTypes[DCsConfig.potionIDReflex] == null && DCsConfig.potionIDReflex < 128){
			DCsAppleMilk.reflex = (new PotionReflex(DCsConfig.potionIDReflex, false, 999999, false)).
					setPotionName("DCs.potion.reflex").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : Reflex of DCsAppleMilk");
        }
		if (Potion.potionTypes[DCsConfig.potionIDAbsEXP] == null && DCsConfig.potionIDAbsEXP < 128){
			DCsAppleMilk.absEXP = (new PotionReflex(DCsConfig.potionIDAbsEXP, false, 5599557, false)).
					setPotionName("DCs.potion.absorptionEXP").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : EXP Absorption of DCsAppleMilk");
        }
		if (Potion.potionTypes[DCsConfig.potionIDAbsHeal] == null && DCsConfig.potionIDAbsHeal < 128){
			DCsAppleMilk.absHeal = (new PotionReflex(DCsConfig.potionIDAbsHeal, false, 9933221, false)).
					setPotionName("DCs.potion.absorptionHeal").setIconIndex(6, 1);
		}
		else {
            throw new IllegalArgumentException("Failed to register new Potion : Damage Absorption of DCsAppleMilk");
        }
	}

}
