package mods.applemilk.handler.economy;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import mceconomy.api.MCEconomyAPI;
import mceconomy.api.shop.IProductItem;
import mceconomy.api.shop.ProductItem;
import mceconomy.api.shop.ProductList;
import mods.applemilk.common.DCsAppleMilk;

public class MCEconomyHandler extends ProductList{
	
	ArrayList<IProductItem> DCsProduct = new ArrayList<IProductItem>();
	public static int DCshopId = -1;
	
	public void registerSellable()
	{
		//無限化手段があるものは無価値又は安値。
		//container
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.appleBox, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 1), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 2), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 3), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 3), 24);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 3), 32);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.woodBox, 1, 3), 32);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.charcoalBox, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 1), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.gunpowderContainer, 1, 2), 0);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 1), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 2), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 3), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 4), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 5), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 6), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 7), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.vegiBag, 1, 8), 18);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.eggBasket, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.eggBasket, 1, 1), 12);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.mushroomBox, 1, 0), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.mushroomBox, 1, 1), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.melonBomb, 1, 0), 12);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.wipeBox, 1, 0), 6);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.wipeBox, 1, 1), 18);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.wipeBox2, 1, 0), 40);
		
		//baskets
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.Basket), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chopsticksBox), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chocoBlock, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chocoBlock, 1, 1), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.bowlRack), 5);
		
		//chalcedony
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chalcedony, 1, 0), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chalcedony, 1, 1), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.flintBlock), 25);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 0), 60);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 1), 60);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 2), 75);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 3), 75);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 4), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.cLamp, 1, 5), -1);
		
		//Maker
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teaMakerNext), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teaMaker), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.emptyTeaMaker), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.emptyCup), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.emptyPan), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.autoMaker), 40);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.iceMaker), 200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teppann), 150);
		
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.filledPan), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.filledPan2), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.filledChocoPan), -1);
		
		//foodblock
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teacupBlock), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teaCup2), 12);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.bowlBlock), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.bowlJP), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.blockIcecream), 15);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.foodPlate), 8);
		
		//tree
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.saplingTea), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teaTree, 1, 0), 30);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.teaTree, 1, 1), 40);
		
		//fooditem
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.bakedApple), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.appleTart), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.appleSandwich), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.toffyApple), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.icyToffyApple), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.clam), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.condensedMIlk), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chocolateFruits), 5);
		
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.EXItems), 4);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.gratedApple), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.leafTea), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.inkStick), 8);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.mincedFoods), 5);
		
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chopsticks), -1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.icyCrystal), 150);
		
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chalcedonyKnife), 80);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.chalcedonyHammer), 120);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.firestarter), 50);
		MCEconomyAPI.addPurchaseItem(new ItemStack(DCsAppleMilk.DCgrater), 20);
		
		System.out.println("[AppleMilk]Succeeded to register the price for MCEconomy.");
		
		DCshopId = MCEconomyAPI.registerProductList(this);
		
		System.out.println("[AppleMilk]Succeeded to register the shop ID. ID: " + DCshopId);
	}
	
	public void registerProducts()
	{
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.saplingTea, 1, 0), 50));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.EXItems, 1, 2), 15));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.EXItems, 1, 3), 15));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.EXItems, 1, 8), 50));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.EXItems, 1, 9), 30));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.gratedApple, 1, 2), 40));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.gratedApple, 1, 3), 40));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.gratedApple, 1, 5), 40));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.gratedApple, 1, 6), 40));
		DCsProduct.add(new ProductItem(new ItemStack(DCsAppleMilk.gratedApple, 1, 7), 40));
	}

	@Override
	public String getProductListName() {
		
		return "AppleMilkTea's Delivery Service";
	}
	
	@Override
	public void addItemProduct(IProductItem item) {
		DCsProduct.add(item);
	}

	@Override
	public int getItemProductSize() {
		return DCsProduct.size();
	}

	@Override
	public ArrayList<IProductItem> getProductList() {
		return DCsProduct;
	}

}
