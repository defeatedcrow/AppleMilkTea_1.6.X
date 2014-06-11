package mods.applemilk.handler;

import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ic2.api.item.Items;
import ic2.api.recipe.*;

public class LoadIC2Handler {
	
	public static int IC2Cell = 0;
	public static int IC2WaterCell = 0;
	public static int IC2Coffeepowder = 0;
	public static int IC2Mug = 0;
	public static int IC2MugCoffee = 0;
	public static int IC2dropRubber = 0;
	public static int IC2Rum = 0;
	
	public static ItemStack IC2Furnace;

	public void load() {
		
		//IC2apiの機能によりアイテムを取得している
		this.IC2Cell = Items.getItem("cell").itemID;
		this.IC2WaterCell = Items.getItem("waterCell").itemID;
        this.IC2Coffeepowder = Items.getItem("coffeePowder").itemID;
        this.IC2Mug = Items.getItem("mugEmpty").itemID;
        this.IC2MugCoffee = Items.getItem("mugCoffee").itemID;
        this.IC2dropRubber = Items.getItem("rubber").itemID;
        this.IC2Furnace = new ItemStack(Items.getItem("ironFurnace").itemID, 1, Items.getItem("ironFurnace").getItemDamage());
        
        //インスタントティー用の水入り容器登録
        if (this.IC2WaterCell != 0)
        {
        	if (LoadModHandler.registerModItems("containerWater", new ItemStack(IC2WaterCell, 1, 1))) {
				AMTLogger.debugInfo("Succeeded to get IC2 water cell");
			}
        }
        
        if (this.IC2Furnace != null)
        {
        	if (LoadModHandler.registerModItems("furnaceBlock", this.IC2Furnace)) {
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
                ItemStack outputs = new ItemStack(this.IC2dropRubber, 9, 0);
                
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
