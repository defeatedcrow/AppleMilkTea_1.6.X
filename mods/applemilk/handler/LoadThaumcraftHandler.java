package mods.applemilk.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class LoadThaumcraftHandler {
	
	public static int thaumicSilverwood = 0;
	public static int thaumicGreatwood = 0;
	
	public void load()
	{
		//TC4apiの機能でアイテムを取得
		this.thaumicGreatwood = ItemApi.getBlock("blockMagicalLog", 0).itemID;
		this.thaumicSilverwood = ItemApi.getBlock("blockMagicalLog", 1).itemID;
		
		//相の設定。4.0.5以降にしか対応していない。
		if (DCsAppleMilk.TC4after405)
		{
			ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 5, new AspectList().add(Aspect.TREE, 9).add(Aspect.MAGIC, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 6, new AspectList().add(Aspect.TREE, 9).add(Aspect.MAGIC, 3).add(Aspect.ORDER, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 0, new AspectList().add(Aspect.TREE, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 1, new AspectList().add(Aspect.TREE, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 2, new AspectList().add(Aspect.TREE, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 3, new AspectList().add(Aspect.TREE, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.woodBox.blockID, 4, new AspectList().add(Aspect.TREE, 8).add(Aspect.SLIME, 3));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.appleBox.blockID, 0, new AspectList().add(Aspect.PLANT, 8).add(Aspect.CROP, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.charcoalBox.blockID, 0, new AspectList().add(Aspect.FIRE, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.gunpowderContainer.blockID, 0, new AspectList().add(Aspect.FIRE, 8).add(Aspect.ENTROPY, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.gunpowderContainer.blockID, 1, new AspectList().add(Aspect.HUNGER, 8).add(Aspect.ENTROPY, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.gunpowderContainer.blockID, 2, new AspectList().add(Aspect.EARTH, 8).add(Aspect.WATER, 3));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 0, new AspectList().add(Aspect.CROP, 8).add(Aspect.PLANT, 4));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 1, new AspectList().add(Aspect.CROP, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 2, new AspectList().add(Aspect.CROP, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 3, new AspectList().add(Aspect.CROP, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 4, new AspectList().add(Aspect.CROP, 8).add(Aspect.SEED, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 5, new AspectList().add(Aspect.CROP, 8).add(Aspect.AIR, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 6, new AspectList().add(Aspect.CROP, 8).add(Aspect.WATER, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 7, new AspectList().add(Aspect.CROP, 8));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.vegiBag.blockID, 8, new AspectList().add(Aspect.CROP, 8).add(Aspect.MAGIC, 3));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.flintBlock.blockID, 0, new AspectList().add(Aspect.STONE, 3).add(Aspect.FIRE, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.chalcedony.blockID, -1, new AspectList().add(Aspect.STONE, 3).add(Aspect.CRYSTAL, 3));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 0, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 1, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 2, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3).add(Aspect.VOID, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 3, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3).add(Aspect.VOID, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 4, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3).add(Aspect.MIND, 2).add(Aspect.ENERGY, 2));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.cLamp.blockID, 5, new AspectList().add(Aspect.LIGHT, 2).add(Aspect.CRYSTAL, 3).add(Aspect.BEAST, 2).add(Aspect.UNDEAD, 2));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.Basket.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.HUNGER, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.eggBasket.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.SEED, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.bowlRack.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.TREE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.chopsticksBox.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.TREE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.clamSand.blockID, 0, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.SEED, 1));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.emptyTeaMaker.blockID, 0, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 1).add(Aspect.FIRE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.emptyPan.blockID, 0, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.VOID, 1).add(Aspect.HUNGER, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.teaMaker.blockID, -1, new AspectList().add(Aspect.WATER, 2).add(Aspect.HEAL, 1).add(Aspect.FIRE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.filledPan.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.HUNGER, 1).add(Aspect.FIRE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.filledPan2.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.HUNGER, 1).add(Aspect.FIRE, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.teppann.blockID, -1, new AspectList().add(Aspect.CRAFT, 2).add(Aspect.HUNGER, 1).add(Aspect.FIRE, 1));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.emptyCup.blockID, 0, new AspectList().add(Aspect.WATER, 2).add(Aspect.VOID, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.teacupBlock.blockID, -1, new AspectList().add(Aspect.WATER, 2).add(Aspect.HEAL, 1));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.bowlBlock.blockID, -1, new AspectList().add(Aspect.HUNGER, 2));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.bowlJP.blockID, -1, new AspectList().add(Aspect.HUNGER, 2));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.foodPlate.blockID, -1, new AspectList().add(Aspect.HUNGER, 2).add(Aspect.FLESH, 2));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.saplingTea.blockID, 0, new AspectList().add(Aspect.PLANT, 2).add(Aspect.SEED, 2));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.teaTree.blockID, -1, new AspectList().add(Aspect.PLANT, 2).add(Aspect.AIR, 2));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.melonBomb.blockID, 0, new AspectList().add(Aspect.CROP, 8).add(Aspect.ENTROPY, 3).add(Aspect.WATER, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.mushroomBox.blockID, -1, new AspectList().add(Aspect.PLANT, 8).add(Aspect.DARKNESS, 3).add(Aspect.MAGIC, 1));
		    
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.chocoBlock.blockID, 0, new AspectList().add(Aspect.HEAL, 3).add(Aspect.MIND, 3).add(Aspect.SENSES, 3));
		    ThaumcraftApi.registerObjectTag(DCsAppleMilk.chocoBlock.blockID, 1, new AspectList().add(Aspect.HEAL, 3).add(Aspect.MIND, 3).add(Aspect.MAGIC, 3));
		    
		    System.out.println("[AppleMilk]Succeeded to register aspects for Thaumcraft.");
		}
		
		if (this.thaumicGreatwood != 0){
			System.out.println("[AppleMilk]Succeeded to get thaumicGreatwood.");
			
			//取得したアイテムを使ったレシピの登録。こちらは恐らく旧版でも動作する
			GameRegistry.addShapelessRecipe(
		    		  new ItemStack(LoadThaumcraftHandler.thaumicGreatwood, 9, 0),
		    			  new ItemStack(DCsAppleMilk.woodBox,1,5));
			 
			  GameRegistry.addRecipe(
					 new ItemStack(DCsAppleMilk.woodBox,1,5),
					 new Object[]{
						 "UUU",
						 "UUU",
						 "UUU",
						 Character.valueOf('U'), new ItemStack(LoadThaumcraftHandler.thaumicGreatwood, 1, 0)
					 });
		}
		
		if (this.thaumicSilverwood != 0){
			System.out.println("[AppleMilk]Succeeded to get thaumicSilverwood.");
			
			GameRegistry.addShapelessRecipe(
		    		  new ItemStack(LoadThaumcraftHandler.thaumicSilverwood, 9, 1),
		    			  new ItemStack(DCsAppleMilk.woodBox,1,6));
			 
			  GameRegistry.addRecipe(
					 new ItemStack(DCsAppleMilk.woodBox,1,6),
					 new Object[]{
						 "UUU",
						 "UUU",
						 "UUU",
						 Character.valueOf('U'), new ItemStack(LoadThaumcraftHandler.thaumicSilverwood, 1, 1)
					 });
		}  
	}
}
