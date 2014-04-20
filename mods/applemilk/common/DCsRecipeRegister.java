package mods.applemilk.common;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class DCsRecipeRegister {
	
	private Item rubberWood;
	
	public void addRecipe()
	{
		OreDictionary.registerOre("dustSugar", new ItemStack(Item.sugar, 1, 0));
		OreDictionary.registerOre("cropWheat", new ItemStack(Item.wheat, 1, 0));
		OreDictionary.registerOre("cropApple", new ItemStack(Item.appleRed, 1, 0));
		OreDictionary.registerOre("bucketMilk", new ItemStack(Item.bucketMilk, 1, 0));
		
		this.addContainerRecipe();
		this.addTablewareRecipe();
		this.addGraterRecipe();
		this.addCocktailRecipe();
		this.addFoodRecipe();
		this.addMaterials();
		this.addChalcedony();
		this.addBottle();
		this.addSmelting();
		
		ArrayList<ItemStack> woodRubber = OreDictionary.getOres("woodRubber");
	    if (woodRubber.size() > 0){rubberWood = woodRubber.get(0).getItem();}
	      
	    if (rubberWood != null)
	    {
	    	GameRegistry.addRecipe(
					new ShapelessOreRecipe(
			    		new ItemStack(this.rubberWood, 9, 1),
			    		new Object[]{
			    		new ItemStack(DCsAppleMilk.woodBox, 1, 4),
			    		}));
		     
		    GameRegistry.addRecipe(
					new ShapedOreRecipe(
			    		new ItemStack(DCsAppleMilk.woodBox, 1, 4),
			    		new Object[]{"XXX","XXX","XXX",
			    		Character.valueOf('X'), "woodRubber"}));
	    }
	    
	    
	    //extra recipe
	    if (DCsAppleMilk.useEXRecipe)
	    {
	    	GameRegistry.addRecipe(
	 			new ItemStack(DCsAppleMilk.saplingTea,1),
	 			new Object[]{
	 					 "XXX",
	 					 "XYX",
	 					 "XXX",
	 					 Character.valueOf('X'), new ItemStack(Item.goldNugget, 1),
	 					 Character.valueOf('Y'), new ItemStack(Block.sapling, 1, 0)
	 			});
	    }
	      
	    //add extra recipe if nether is disabled.
	    if (!DCsAppleMilk.getServerPlop1)
	    {
	    	GameRegistry.addRecipe(
	 			new ItemStack(DCsAppleMilk.emptyTeaMaker, 1, 0),
	 			new Object[]{
	 					 "XYX",
	 					 "ZYZ",
	 					 "XWX",
	 					 Character.valueOf('X'), new ItemStack(Block.stainedClay, 1, 0),
	 					 Character.valueOf('Y'), new ItemStack(Item.bucketWater, 1),
	 					 Character.valueOf('Z'), new ItemStack(Block.glass, 1),
	 					 Character.valueOf('W'), new ItemStack(Item.bucketLava, 1)
	 			});
	 		 
	    	GameRegistry.addRecipe(
	 			new ShapedOreRecipe(
	 	    	new ItemStack(DCsAppleMilk.emptyTeaMaker, 1, 0),
	 	    	new Object[]{
	 						 "XYX",
	 						 "ZYZ",
	 						 "XWX",
	 						 Character.valueOf('X'), "ingotSilver",
	 						 Character.valueOf('Y'), new ItemStack(Item.bucketWater, 1),
	 						 Character.valueOf('Z'), new ItemStack(Block.glass, 1),
	 						 Character.valueOf('W'), new ItemStack(Item.bucketLava, 1)}));
	     }
	    
	     //old Items
	    if (DCsAppleMilk.useOldItems)
	    {
	    	GameRegistry.addShapelessRecipe(
		    		new ItemStack(DCsAppleMilk.bowlBlock, 1, 2),
		    			new ItemStack(DCsAppleMilk.DCStew, 1, 0));
		      
		    GameRegistry.addShapelessRecipe(
		    		new ItemStack(DCsAppleMilk.bowlBlock, 1, 3),
		    			new ItemStack(DCsAppleMilk.DCStew, 1, 1)); 
		      
		    for (int i = 1; i < 12 ; i++)
		    {
		    	GameRegistry.addShapelessRecipe(
			    	new ItemStack(DCsAppleMilk.teacupBlock, 1, i),
			    			new ItemStack(DCsAppleMilk.teaCup, 1, i));
		    }
	    }
	      
	    GameRegistry.addShapelessRecipe(
	    		new ItemStack(DCsAppleMilk.teaMakerNext, 1, 0),
	    			new ItemStack(DCsAppleMilk.emptyTeaMaker, 1, 0));
		 
	}
	
	static void addContainerRecipe() {
		
		for(int i = 0; i < 4; i++)
		 {
			 GameRegistry.addShapelessRecipe(
		    		  new ItemStack(Block.wood,9,i),
		    			  new ItemStack(DCsAppleMilk.woodBox,1,i));
			 
			 GameRegistry.addRecipe(
					 new ItemStack(DCsAppleMilk.woodBox,1,i),
					 new Object[]{
						 "UUU",
						 "UUU",
						 "UUU",
						 Character.valueOf('U'), new ItemStack(Block.wood,1,i)
					 });
		 }
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(Item.appleRed,9),
	    			  new ItemStack(DCsAppleMilk.appleBox,1));
		 
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(Item.coal,9,1),
	    			  new ItemStack(DCsAppleMilk.charcoalBox,1));
		 
		 for(int i = 0; i < 10; i++)
		 {
			 ItemStack itemStack = new ItemStack(DCsAppleMilk.leafTea,9);
			 if (i == 1) itemStack = new ItemStack(Item.potato,9);
			 else if (i == 2) itemStack = new ItemStack(Item.carrot,9);
			 else if (i == 3) itemStack = new ItemStack(Block.pumpkin,9);
			 else if (i == 4) itemStack = new ItemStack(Item.seeds,9);
			 else if (i == 5) itemStack = new ItemStack(Item.reed,9);
			 else if (i == 6) itemStack = new ItemStack(Block.cactus,9);
			 else if (i == 7) itemStack = new ItemStack(Item.dyePowder,9,3);
			 else if (i == 8) itemStack = new ItemStack(Item.netherStalkSeeds,9);
			 else if (i == 9) itemStack = new ItemStack(Item.sugar,9);
			 else itemStack = new ItemStack(DCsAppleMilk.leafTea,9);
			 
			 GameRegistry.addShapelessRecipe(
		    		  itemStack,
		    			  new ItemStack(DCsAppleMilk.vegiBag,1,i));
			 
			 if (i >= 0){
			 GameRegistry.addRecipe(
					 new ItemStack(DCsAppleMilk.vegiBag,1,i),
					 new Object[]{
						 "TTT",
						 "TTT",
						 "TTT",
						 Character.valueOf('T'), itemStack
					 });
			 }
		 }
		 
		 GameRegistry.addRecipe(
					new ShapedOreRecipe(
			    		new ItemStack(DCsAppleMilk.vegiBag, 1, 9),
			    		new Object[]{"XXX","XXX","XXX",
			    		Character.valueOf('X'), "dustSugar"}));
		 
		 
		 for(int i = 0; i < 3; i++)
		 {
			 ItemStack item = new ItemStack(Item.gunpowder, 9);
			 if (i == 1) item = new ItemStack(DCsAppleMilk.EXItems, 9, 5);
			 else if (i == 2) item = new ItemStack(Item.clay, 9);
			 else item = new ItemStack(Item.gunpowder,9);
			 
			 GameRegistry.addShapelessRecipe(
		    		  item,
		    			  new ItemStack(DCsAppleMilk.gunpowderContainer,1,i));
			 
			 if (i >= 0){
			 GameRegistry.addRecipe(
					 new ItemStack(DCsAppleMilk.gunpowderContainer,1,i),
					 new Object[]{
						 "TTT",
						 "TTT",
						 "TTT",
						 Character.valueOf('T'), item
					 });
			 }
		 }
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.appleBox,1),
				 new Object[]{
					 "UUU",
					 "UUU",
					 "UUU",
					 Character.valueOf('U'), Item.appleRed
				 });
		 
		 GameRegistry.addRecipe(
					new ShapedOreRecipe(
			    		new ItemStack(DCsAppleMilk.appleBox, 1, 0),
			    		new Object[]{"XXX","XXX","XXX",
			    		Character.valueOf('X'), "cropApple"}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.charcoalBox,1),
				 new Object[]{
					 "UUU",
					 "UUU",
					 "UUU",
					 Character.valueOf('U'), new ItemStack(Item.coal, 1, 1)
				 });
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(Item.egg, 8, 0),
				 new ItemStack(DCsAppleMilk.eggBasket, 1, 0));
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(DCsAppleMilk.clam, 8, 3),
				 new ItemStack(DCsAppleMilk.eggBasket, 1, 1));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.eggBasket, 1, 0),
	    		  new Object[]{"XXX","X X","XXX",
	    			  Character.valueOf('X'), new ItemStack(Item.egg, 1, 0)})); 
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.eggBasket, 1, 1),
	    		  new Object[]{"XXX","X X","XXX",
	    			  Character.valueOf('X'), new ItemStack(DCsAppleMilk.clam, 1, 3)})); 
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(Block.melon, 9, 0),
				 new ItemStack(DCsAppleMilk.melonBomb, 1, 0));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.melonBomb, 1, 0),
	    		  new Object[]{"XXX","XXX","XXX",
	    			  Character.valueOf('X'), new ItemStack(Block.melon, 1, 0)})); 
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chopsticksBox, 1, 4),
	    		  new Object[]{"XXX","XYX","XXX",
	    			  Character.valueOf('Y'), new ItemStack(DCsAppleMilk.Basket, 1, 0),
	    			  Character.valueOf('X'), "stickWood"})); 
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(Block.mushroomRed, 9),
				 new ItemStack(DCsAppleMilk.mushroomBox, 1, 0));
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(Block.mushroomBrown, 9),
				 new ItemStack(DCsAppleMilk.mushroomBox, 1, 1));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mushroomBox, 1, 0),
	    		  new Object[]{"XXX","XXX","XXX",
	    			  Character.valueOf('X'), new ItemStack(Block.mushroomRed, 1)})); 
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mushroomBox, 1, 1),
	    		  new Object[]{"XXX","XXX","XXX",
	    			  Character.valueOf('X'), new ItemStack(Block.mushroomBrown, 1)})); 
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chocoBlock, 1, 0),
	    		  new Object[]{"XXX","XYX","XXX",
	    			  Character.valueOf('Y'), new ItemStack(Item.ingotGold, 1),
	    			  Character.valueOf('X'), "foodFruitsChocolate"}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chocoBlock, 1, 1),
	    		  new Object[]{"XXX","XYX","XXX",
	    			  Character.valueOf('Y'), new ItemStack(Item.diamond, 1),
	    			  Character.valueOf('X'), "foodFruitsChocolate"}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.wipeBox,1,0),
				 new Object[]{
					 "UUU",
					 "UUU",
					 "UUU",
					 Character.valueOf('U'), Item.paper
				 });
		 
		 GameRegistry.addShapelessRecipe(
				 new ItemStack(Item.paper, 9),
				 new ItemStack(DCsAppleMilk.wipeBox, 1, 0));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.wipeBox,1,1),
				 new Object[]{
					 "UUU",
					 "UUU",
					 "UUU",
					 Character.valueOf('U'), new ItemStack(DCsAppleMilk.wipeBox, 1, 0)
				 });
	}
	
	static void addTablewareRecipe() {
		
		GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.emptyCup, 1),
	    		  new Object[]{"XXX","XX ",
	    			  Character.valueOf('X'), "ingotSilver"}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.emptyCup, 1),
	    		  new Object[]{"XXX","XX ",
	    			  Character.valueOf('X'), new ItemStack(Block.stainedClay, 1, 0)}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.teaMakerNext, 1),
				 new Object[]{
					 "XYX",
					 "ZYZ",
					 "XWX",
					 Character.valueOf('X'), new ItemStack(Block.stainedClay, 1, 0),
					 Character.valueOf('Y'), new ItemStack(Item.bucketWater, 1),
					 Character.valueOf('Z'), new ItemStack(Block.glass, 1),
					 Character.valueOf('W'), new ItemStack(Item.blazeRod, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.autoMaker, 1),
	    		  new Object[]{
						 "ZYZ",
						 "ZXZ",
						 Character.valueOf('Z'), new ItemStack(Block.stainedClay, 1, 0),
						 Character.valueOf('Y'), "gearIron",
						 Character.valueOf('X'), new ItemStack(Block.dispenser, 1)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.teaMakerNext, 1),
	    		  new Object[]{
						 "XYX",
						 "ZYZ",
						 "XWX",
						 Character.valueOf('X'), "ingotSilver",
						 Character.valueOf('Y'), new ItemStack(Item.bucketWater, 1),
						 Character.valueOf('Z'), new ItemStack(Block.glass, 1),
						 Character.valueOf('W'), new ItemStack(Item.blazeRod, 1)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.autoMaker, 1),
	    		  new Object[]{
						 "ZYZ",
						 "ZXZ",
						 Character.valueOf('Z'), "ingotSilver",
						 Character.valueOf('Y'), "gearIron",
						 Character.valueOf('X'), new ItemStack(Block.dispenser, 1)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.iceMaker, 1),
	    		  new Object[]{
						 " X ",
						 "ZYZ",
						 "Z Z",
						 Character.valueOf('X'), "gearIron",
						 Character.valueOf('Z'), new ItemStack(Item.ingotIron, 1),
						 Character.valueOf('Y'), new ItemStack(DCsAppleMilk.icyCrystal, 1)}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.emptyPan, 1),
				 new Object[]{
					 "X X",
					 "X X",
					 "XXX",
					 Character.valueOf('X'), new ItemStack(Block.hardenedClay, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.DCgrater, 1, 0),
				 new Object[]{
					 " X ",
					 "XYX",
					 "XYX",
					 Character.valueOf('X'), new ItemStack(Item.stick, 1),
					 Character.valueOf('Y'), new ItemStack(Block.fenceIron, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.bowlRack, 1),
	    		  new Object[]{"X X","X X","YYY",
	    			  Character.valueOf('X'), "stickWood",
	    			  Character.valueOf('Y'), "plankWood"}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.Basket, 1),
				 new Object[]{
					 "X X",
					 "X X",
					 "XXX",
					 Character.valueOf('X'), new ItemStack(Item.reed, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.teppann, 1, 0),
				 new Object[]{
					 "X X",
					 "XXX",
					 " Y ",
					 Character.valueOf('X'), new ItemStack(Item.ingotIron, 1),
					 Character.valueOf('Y'), new ItemStack(Block.furnaceIdle, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
				 new Object[]{
					 " Y ",
					 "X X",
					 " X ",
					 Character.valueOf('X'), new ItemStack(Block.glass, 1),
					 Character.valueOf('Y'), new ItemStack(Item.ingotIron, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    		  new Object[]{
	    			 " Y ",
					 "X X",
					 " X ",
					 Character.valueOf('X'), new ItemStack(Block.glass, 1),
					 Character.valueOf('Y'), "ingotTin"}));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.Basket, 1, 14),
				 new Object[]{
					 "XXX",
					 "XXX",
					 "XXX",
					 Character.valueOf('X'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.EXItems, 3, 10),
				 new Object[]{
					 " X ",
					 "XYX",
					 " X ",
					 Character.valueOf('X'), new ItemStack(Block.thinGlass, 1, 0),
					 Character.valueOf('Y'), new ItemStack(Item.slimeBall, 1, 0)
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 3, 10),
	    		  new Object[]{
	    			" X ",
					"XYX",
					" X ",
					Character.valueOf('X'), new ItemStack(Block.thinGlass, 1, 0),
					Character.valueOf('Y'), "dropSlime"}));
	}
	
	static void addGraterRecipe() {
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 0),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Item.appleRed, 1, 0)
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 0),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropApple"
					 }));
	    		  
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropPeach"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropBanana"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropOrange"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropPlum"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 2),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropLemon",
		    		  "dropHoney"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 3),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropCoffee",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropLime",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropYuzu",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropCitron",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 6),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropTomato",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 6),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "tomato",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropStrawberry",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropBlueberry",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropRaspberry",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropBlackberry",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "listAllberry",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "cropGrape",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "grape",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 3),
		    		  "cropOrange",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 3),
		    		  "cropCitron",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 9),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 3),
	    			  new ItemStack(Item.appleRed, 1, 0)
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 9),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 3),
	    			  "cropApple"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 0),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Block.mushroomBrown, 1, 0),
		    		  new ItemStack(Block.mushroomRed, 1, 0)
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Item.fishRaw, 1),
		    		  new ItemStack(Item.carrot, 1),
	    			  new ItemStack(Item.potato, 1),
	    			  "bucketMilk"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Item.fishRaw, 1, 0),
		    		  new ItemStack(Item.carrot, 1, 0),
	    			  new ItemStack(Item.potato, 1, 0),
	    			  "listAllmilk"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 2),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Item.egg, 1, 0),
		    		  new ItemStack(Item.chickenRaw, 1, 0),
	    			  "cropWheat"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 2),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  new ItemStack(Item.egg, 1, 0),
		    		  new ItemStack(Item.chickenRaw, 1, 0),
	    			  "cropRice"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 3),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  "cropRice","cropRice","cropRice"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 3),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  "cropWheat","cropWheat","cropWheat"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 5),
		    		  "cropRice"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(DCsAppleMilk.EXItems, 1, 5),
	    			  "cropWheat"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Item.chickenRaw, 1, 0),
	    			  "leek",
		    		  "bucketSoymilk",
		    		  "tofuKinu"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Item.chickenRaw, 1, 0),
	    			  "leek",
		    		  "bucketSoymilk",
		    		  "tofuMomen"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Item.chickenRaw, 1, 0),
	    			  "cropLeek",
		    		  "foodSoymilk",
		    		  "foodSilkentofu"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 6),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Block.pumpkin, 1, 0),
	    			  "bucketMilk"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 6),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Block.pumpkin, 1, 0),
	    			  "listAllmilk"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Item.porkCooked, 1, 0),
	    			  "cropLettuce",
		    		  "cropTomato",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
	    			  new ItemStack(Item.porkCooked, 1, 0),
	    			  "cabbage",
		    		  "tomato",
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "bucketMilk",
		    		  "dustSugar",
		    		  new ItemStack(Item.dyePowder,9,3),
		    		  new ItemStack(Item.dyePowder,9,3)
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.mincedFoods, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.DCgrater, 1, 32767),
		    		  "listAllmilk",
		    		  "dustSugar",
		    		  new ItemStack(Item.dyePowder,9,3),
		    		  new ItemStack(Item.dyePowder,9,3)
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.mincedFoods, 1, 8),
		    		  "bucketMilk"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.gratedApple, 1, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.mincedFoods, 1, 8),
		    		  "listAllmilk"
					 }));
		
	}
	
	static void addCocktailRecipe() {
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 0),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teaCup2, 1, 4),
	    			  "foodCrushedIce",
	    			  "dustSugar",
	    			  "bottleRum"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 0),
	    		  new Object[]{
	    			  "foodLimejuice",
	    			  "foodCrushedIce",
	    			  "dustSugar",
	    			  "bottleRum"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 2),
	    		  new Object[]{
	    			  "bottleGin",
	    			  "bottleSake"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 3),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teaCup2, 1, 4),
	    			  "dustSugar",
	    			  "bottleGin"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 3),
	    		  new Object[]{
	    			  "foodLimejuice",
	    			  "dustSugar",
	    			  "bottleGin"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teacupBlock, 1, 12),
	    			  "bottleRum"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 5),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teaCup2, 1, 5),
	    			  "bottleBeer"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 5),
	    		  new Object[]{
	    			  "foodTomatojuice",
	    			  "bottleBeer"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 6),
	    		  new Object[]{
	    			  "bottleRum",
	    			  "cropPineapple",
	    			  "cropCoconut",
	    			  "foodCrushedIce"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 7),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teacupBlock, 1, 10),
	    			  "bottleWine"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 7),
	    		  new Object[]{
	    			  "foodLemonaid",
	    			  "bottleWine"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teaCup2, 1, 4),
	    			  "bottleVodka",
	    			  "drinkCider"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 8),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.teaCup2, 1, 4),
	    			  "bottleVodka",
	    			  "foodGingersoda"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 8),
	    		  new Object[]{
	    			  "foodLimejuice",
	    			  "bottleVodka",
	    			  "foodGingersoda"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cocktail, 1, 9),
	    		  new Object[]{
	    			  "dustSugar",
	    			  "bottleWhiskey",
	    			  "cropSpiceleaf",
	    			  "foodCrushedIce"
					 }));
	}
	
	static void addFoodRecipe() {
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.appleTart, 1, 0),
	    		  new Object[]{
	    			  "cropApple",
	    			  "dustSugar",
	    			  "cropWheat"
					 }));
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.toffyApple, 1, 0),
	    		  new Object[]{
	    			  "cropApple",
	    			  "dustSugar",
	    			  "stickWood"
					 }));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.icyToffyApple,1,0),
	    			  new ItemStack(DCsAppleMilk.toffyApple,1),
	    			  new ItemStack(Item.snowball,1));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.icyToffyApple,1,1),
	    			  new ItemStack(DCsAppleMilk.toffyApple,1),
	    			  new ItemStack(Item.feather,1));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.icyToffyApple,1,2),
	    			  new ItemStack(DCsAppleMilk.toffyApple,1),
	    			  new ItemStack(Item.goldNugget,1));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.icyToffyApple,1,3),
	    			  new ItemStack(DCsAppleMilk.toffyApple,1),
	    			  new ItemStack(Block.leaves, 1, 32767)));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.icyToffyApple,1,3),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.toffyApple,1),
		    		  "leavesWood"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.condensedMIlk, 1, 0),
	    		  new Object[]{
	    			  "bucketMilk",
		    		  "dustSugar"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.condensedMIlk, 1, 0),
	    		  new Object[]{
	    			  "listAllmilk",
		    		  "dustSugar"
					 }));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems,1,3),
	    			  new ItemStack(DCsAppleMilk.EXItems,1,2));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems,1,4),
	    			  new ItemStack(DCsAppleMilk.EXItems,1,3));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.inkStick,1),
	    			  new ItemStack(DCsAppleMilk.EXItems,1,1),
	    			  new ItemStack(Item.coal,1,1));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.appleSandwich, 2, 0),
	    			  new ItemStack(Item.appleRed,1),
	    			  new ItemStack(Item.bread,1));
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.appleSandwich, 2, 0),
	    		  new Object[]{
	    			  "cropApple",
		    		  new ItemStack(Item.bread, 1)
					 }));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.appleSandwich,2,1),
	    			  new ItemStack(Item.egg,1),
	    			  new ItemStack(Item.bread,1));
	}
	
	static void addChalcedony() {
		
		GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.flintBlock,1),
				 new Object[]{
					 "UU",
					 "UU",
					 Character.valueOf('U'), Item.flint
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(Item.flint, 4),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.flintBlock, 1)
					 }));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chalcedonyKnife, 1),
	    		  new Object[]{"X","X","Y",
	    			  Character.valueOf('Y'), "stickWood",
	    			  Character.valueOf('X'), new ItemStack(DCsAppleMilk.chalcedony, 1, 0)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chalcedonyHammer, 1),
	    		  new Object[]{"XXX"," Y "," Y ",
	    			  Character.valueOf('Y'), "stickWood",
	    			  Character.valueOf('X'), new ItemStack(DCsAppleMilk.chalcedony, 1, 0)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 6),
	    		  new Object[]{" X ","X X"," X ",
	    			  Character.valueOf('X'), new ItemStack(DCsAppleMilk.chalcedony, 1, 0)}));
		 
		 if (!DCsAppleMilk.disableFireSteater)
		 {
			 GameRegistry.addRecipe(
					 new ShapelessOreRecipe(
		    		  new ItemStack(DCsAppleMilk.firestarter, 1),
		    		  new Object[]{
		    			  new ItemStack(DCsAppleMilk.chalcedony, 1, 0),
		    			  new ItemStack(Item.ingotIron, 1),
						 })); 
		 }
		 
		 GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.chalcedony, 1, 1),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.chalcedony, 1, 0),
	    			  "dyeOrange"
					 }));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.cLamp, 1, 0),
				 new Object[]{
					 " U ",
					 "UXU",
					 " U ",
					 Character.valueOf('U'), Item.redstone,
					 Character.valueOf('X'), new ItemStack(DCsAppleMilk.chalcedony, 1, 0)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.cLamp, 1, 1),
				 new Object[]{
					 " U ",
					 "UXU",
					 " U ",
					 Character.valueOf('U'), Item.redstone,
					 Character.valueOf('X'), new ItemStack(DCsAppleMilk.chalcedony, 1, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.cLamp, 1, 2),
				 new Object[]{
					 " U ",
					 "UXU",
					 " U ",
					 Character.valueOf('U'), Block.glass,
					 Character.valueOf('X'), new ItemStack(DCsAppleMilk.cLamp, 1, 0)
				 });
		 
		 GameRegistry.addRecipe(
				 new ItemStack(DCsAppleMilk.cLamp, 1, 3),
				 new Object[]{
					 " U ",
					 "UXU",
					 " U ",
					 Character.valueOf('U'), Block.glass,
					 Character.valueOf('X'), new ItemStack(DCsAppleMilk.cLamp, 1, 1)
				 });
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cLamp, 1, 4),
	    		  new Object[]{" X ","XYX"," X ",
	    			  Character.valueOf('Y'), new ItemStack(DCsAppleMilk.cLamp, 1, 0),
	    			  Character.valueOf('X'), "ingotSilver"}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.cLamp, 1, 5),
	    		  new Object[]{" X ","XYX"," X ",
	    			  Character.valueOf('Y'), new ItemStack(DCsAppleMilk.cLamp, 1, 1),
	    			  Character.valueOf('X'), "ingotLead"}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.rotaryDial, 1, 0),
	    		  new Object[]{"XXX","ZYZ","XXX",
	    			  Character.valueOf('X'), new ItemStack(Block.stainedClay, 1, 15),
	    			  Character.valueOf('Y'), "ingotGold",
	    			  Character.valueOf('Z'), new ItemStack(DCsAppleMilk.EXItems, 1, 6)}));
		 
		 GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.rotaryDial, 1, 0),
	    		  new Object[]{"XXX","ZYZ","XXX",
	    			  Character.valueOf('X'), new ItemStack(Block.stainedClay, 1, 15),
	    			  Character.valueOf('Y'), new ItemStack(Item.ingotGold, 1, 0),
	    			  Character.valueOf('Z'), new ItemStack(DCsAppleMilk.EXItems, 1, 6)}));
	}
	
	static void addBottle() {
		
		GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (48 + 1)),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    			  "drinkSake",
					 }));
     
     GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (48 + 2)),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    			  "drinkBeer",
					 }));
     
     GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (48 + 3)),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    			  "drinkWine",
					 }));
     
     GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (48 + 5)),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    			  "drinkRum",
					 }));
     
     GameRegistry.addRecipe(
				 new ShapelessOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (48 + 4)),
	    		  new Object[]{
	    			  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
	    			  "drinkGin",
					 }));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 8)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "bucketMilk"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 9)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "bucketSoymilk"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 9)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "foodSoymilk"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 10)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "dustSugar"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 12)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "dropHoney"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropAlmond"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropPeanut"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropWalnut"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropHazelnut"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropChestnut"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 13)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "marron"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 14)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "listAllberry"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 14)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropStrawberry"}));
     
     GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.itemLargeBottle, 1, (112 + 14)),
	    		  new Object[]{
						 "XXX",
						 "XZX",
						 "XXX",
						 Character.valueOf('Z'), new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0),
						 Character.valueOf('X'), "cropRaspberry"}));
	}
	
	static void addMaterials() {
		
		GameRegistry.addRecipe(
				 new ShapedOreRecipe(
	    		  new ItemStack(DCsAppleMilk.icyCrystal, 1),
	    		  new Object[]{
						 "XYX",
						 "YZY",
						 "XYX",
						 Character.valueOf('X'), new ItemStack(Item.snowball, 1),
						 Character.valueOf('Y'), new ItemStack(Block.ice, 1),
						 Character.valueOf('Z'), new ItemStack(Item.emerald, 1)}));
		 
		 //extended vanilla recipe
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(DCsAppleMilk.EXItems,1,1),
	    			  new ItemStack(Item.leather,1));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(Block.pistonStickyBase,1),
	    			  new ItemStack(DCsAppleMilk.EXItems,1,1),
	    			  new ItemStack(Block.pistonBase,1));
		 
		 GameRegistry.addShapelessRecipe(
	    		  new ItemStack(Item.dyePowder,1,2),
	    			  new ItemStack(DCsAppleMilk.DCgrater,1,32767),
	    			  new ItemStack(DCsAppleMilk.leafTea, 1));
		 
		 GameRegistry.addRecipe(
				 new ItemStack(Item.leash,1),
				 new Object[]{
					 "TT ",
					 "TS ",
					 "  T",
					 Character.valueOf('T'), Item.silk,
					 Character.valueOf('S'), new ItemStack(DCsAppleMilk.EXItems,1,1),
				 });
	}
	
	static void addSmelting() {
		
		GameRegistry.addSmelting(
	    		  Item.appleRed.itemID,
	    		  new ItemStack(DCsAppleMilk.bakedApple, 1),
	    		  0.3F);
	      
	      GameRegistry.addSmelting(
	    		  DCsAppleMilk.condensedMIlk.itemID,
	    		  new ItemStack(DCsAppleMilk.EXItems, 8, 0),
	    		  0.1F);
	      
	      
	      GameRegistry.addSmelting(
	    		  DCsAppleMilk.woodBox.blockID,
	    		  new ItemStack(DCsAppleMilk.charcoalBox, 1, 0),
	    		  0.1F);
	      
	      GameRegistry.addSmelting(
	    		  Item.rottenFlesh.itemID,
	    		  new ItemStack(Item.leather, 1),
	    		  0F);
	      
	      GameRegistry.addSmelting(
	    		  DCsAppleMilk.leafTea.itemID,
	    		  new ItemStack(DCsAppleMilk.EXItems, 1,2),
	    		  0.1F);
	      
	      GameRegistry.addSmelting(
	    		  DCsAppleMilk.flintBlock.blockID,
	    		  new ItemStack(DCsAppleMilk.chalcedony, 1, 0),
	    		  0.5F);
	      
	      GameRegistry.addSmelting(
	    		  DCsAppleMilk.icyCrystal.itemID,
	    		  new ItemStack(Item.netherQuartz, 1),
	    		  0.5F);
	      
	      FurnaceRecipes.smelting().addSmelting(DCsAppleMilk.clam.itemID, 0,
	    		  new ItemStack(DCsAppleMilk.clam, 1, 1), 0.2F);
	      
	      FurnaceRecipes.smelting().addSmelting(DCsAppleMilk.itemLargeBottle.itemID, 0,
	    		  new ItemStack(DCsAppleMilk.EXItems, 1, 11), 0.2F);
	      
	      FurnaceRecipes.smelting().addSmelting(DCsAppleMilk.EXItems.itemID, 11,
	    		  new ItemStack(Block.glass,1, 0), 0.2F);
	}
}
