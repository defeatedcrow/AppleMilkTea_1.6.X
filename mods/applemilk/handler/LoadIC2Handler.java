package mods.applemilk.handler;

import mods.applemilk.common.DCsAppleMilk;
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

	public void load() {
		
		//IC2apiの機能によりアイテムを取得している
		this.IC2Cell = Items.getItem("cell").itemID;
		this.IC2WaterCell = Items.getItem("waterCell").itemID;
        this.IC2Coffeepowder = Items.getItem("coffeePowder").itemID;
        this.IC2Mug = Items.getItem("mugEmpty").itemID;
        this.IC2MugCoffee = Items.getItem("mugCoffee").itemID;
        this.IC2dropRubber = Items.getItem("rubber").itemID;
        
        if (this.IC2Cell != 0) System.out.println("[AppleMilk]Succeeded to get IC2cell.");
        if (this.IC2WaterCell != 0) System.out.println("[AppleMilk]Succeeded to get IC2watercell.");
        if (this.IC2Coffeepowder != 0) System.out.println("[AppleMilk]Succeeded to get IC2dustcoffee.");
        if (this.IC2Mug != 0) System.out.println("[AppleMilk]Succeeded to get IC2mug.");
        if (this.IC2MugCoffee != 0) System.out.println("[AppleMilk]Succeeded to get IC2mugcoffee.");
        if (this.IC2dropRubber != 0) System.out.println("[AppleMilk]Succeeded to get IC2rubber.");
        
        //以下はexp版専用のメソッド
        if (DCsAppleMilk.IC2exp)
        {
        	try
            {
            	//NTGはnullのままでも別にいいのかもしれない
        		RecipeInputItemStack input = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.woodBox, 1, 4), 1);
                NBTTagCompound metadata = new NBTTagCompound();
                metadata.setInteger("extractor", 2000);
                ItemStack outputs = new ItemStack(this.IC2dropRubber, 9, 0);
                
                Recipes.extractor.addRecipe(input, metadata, outputs);
                System.out.println("[AppleMilk]Succeeded to register IC2machines recipe.");
                
                RecipeInputItemStack input2 = new RecipeInputItemStack(new ItemStack(DCsAppleMilk.leafTea, 1, 0), 1);
                NBTTagCompound metadata2 = new NBTTagCompound();
                metadata.setInteger("macerater", 2000);
                ItemStack outputs2 = new ItemStack(DCsAppleMilk.EXItems, 2, 2);
                
                Recipes.macerator.addRecipe(input2, metadata2, outputs2);
                System.out.println("[AppleMilk]Succeeded to register IC2machines recipe.");
            }
            catch (Exception e) {
              System.out.println("[AppleMilk]Failed to register IC2machines recipe.");
              e.printStackTrace(System.err);
            }
            
        }
		
	}

}
