package mods.applemilk.handler;

import mods.applemilk.api.recipe.RecipeRegisterManager;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.item.Items;
import ic2.api.recipe.*;

public class LoadIC2Handler {
	
	public static ItemStack IC2Cell;
	public static ItemStack IC2WaterCell;
	public static ItemStack IC2Coffeepowder;
	public static ItemStack IC2Mug;
	public static ItemStack IC2MugCoffee;
	public static ItemStack IC2MugCoffeeMilk;
	public static ItemStack IC2dropRubber;
	public static Item IC2Rum;
	
	public static ItemStack IC2Furnace;

	public void load() {
		
		//IC2apiの機能によりアイテムを取得している
		this.IC2Cell = new ItemStack(Items.getItem("cell").getItem(), 1, Items.getItem("cell").getItemDamage());
		this.IC2WaterCell = new ItemStack(Items.getItem("waterCell").getItem(), 1, Items.getItem("waterCell").getItemDamage());
        this.IC2Coffeepowder = new ItemStack(Items.getItem("coffeePowder").getItem(), 1, Items.getItem("coffeePowder").getItemDamage());
        this.IC2Mug = new ItemStack(Items.getItem("mugEmpty").getItem(), 1, 0);
        this.IC2MugCoffee = new ItemStack(Items.getItem("mugCoffee").getItem(), 1, 1);
        this.IC2MugCoffeeMilk = new ItemStack(Items.getItem("mugCoffee").getItem(), 1, 2);
        this.IC2dropRubber = new ItemStack(Items.getItem("rubber").getItem(), 1, Items.getItem("rubber").getItemDamage());
        this.IC2Furnace = new ItemStack(Items.getItem("ironFurnace").getItem(), 1, Items.getItem("ironFurnace").getItemDamage());
        
        //コーヒー粉をTeaMakerに登録
        if (IC2Coffeepowder != null)
        {
        	RecipeRegisterManager.teaRecipe.registerCanMilk(IC2Coffeepowder, new ItemStack(DCsAppleMilk.teacupBlock, 1, 12),
    	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 13),
    	    		new String("defeatedcrow:textures/blocks/contents_cocoa.png"),
    	    		new String("defeatedcrow:textures/blocks/contents_cocoa_milk.png"));
        }
        
        //インスタントティー用の水入り容器登録
        if (this.IC2WaterCell != null)
        {
        	if (LoadModHandler.registerModItems("containerWater", IC2WaterCell)) {
				AMTLogger.debugInfo("Succeeded to get IC2 water cell");
			}
        }
        
        if (this.IC2Furnace != null)
        {
        	if (LoadModHandler.registerModItems("furnaceBlock", IC2Furnace)) {
				AMTLogger.debugInfo("Succeeded to get IC2 Iron Furnace");
			}
        }
        
        //以下はexp版専用のメソッド
        if (DCsConfig.IC2exp)
        {
        	try
            {
            	//NTGはnullのままでも別にいいのかもしれない
        		RecipeInputItemStack input = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.woodBox, 1, 4), 1);
                NBTTagCompound metadata = new NBTTagCompound();
                metadata.setInteger("extractor", 2000);
                ItemStack outputs = new ItemStack(this.IC2dropRubber.getItem(), 9, 0);
                
                Recipes.extractor.addRecipe(input, metadata, outputs);
                
                RecipeInputItemStack input2 = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.leafTea, 1, 0), 1);
                NBTTagCompound metadata2 = new NBTTagCompound();
                metadata2.setInteger("macerater", 2000);
                ItemStack outputs2 = new ItemStack(DCsAppleMilk.EXItems, 2, 2);
                
                RecipeInputItemStack input3 = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.itemLargeBottle, 1, 0), 1);
                ItemStack outputs3 = new ItemStack(DCsAppleMilk.EXItems, 2, 11);
                
                RecipeInputItemStack input4 = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.clam, 1, 0), 1);
                ItemStack outputs4 = new ItemStack(DCsAppleMilk.EXItems, 2, 12);
                
                Recipes.macerator.addRecipe(input2, metadata2, outputs2);
                Recipes.macerator.addRecipe(input3, metadata2, outputs3);
                Recipes.macerator.addRecipe(input4, metadata2, outputs4);
                AMTLogger.debugInfo("Succeeded to register IC2machines recipe");
            }
            catch (Exception e) {
              AMTLogger.debugInfo("Failed to register IC2machines recipe");
              e.printStackTrace(System.err);
            }
            
        }
		
	}

}
