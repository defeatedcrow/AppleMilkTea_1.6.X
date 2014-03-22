package mods.applemilk.api;

import java.util.HashMap;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;

public class RegisteredRecipeGet {
	
	public static HashMap<ItemStack, ItemStack> teaRecipeList = new HashMap<ItemStack, ItemStack>();
	public static HashMap<ItemStack, ItemStack> iceRecipeList = new HashMap<ItemStack, ItemStack>();
	public static HashMap<ItemStack, ItemStack> panRecipeList = new HashMap<ItemStack, ItemStack>();
	
	public void setRecipeList() {
		
		for (int i = 0 ; i <= TeaRecipe.outputs.size() ; i++) {
			ItemStack input = TeaRecipe.getInput(i);
			ItemStack output = TeaRecipe.getOutput(i);
			
			if (input != null && output != null) {
				teaRecipeList.put(input, output);
				
				if (DCsAppleMilk.debugMode)
				{
					System.out.println("[AppleMilk]Checking TeaMaker recipe for NEI. No. " + i);
					System.out.println("[AppleMilk]input is " + input.getDisplayName());
					System.out.println("[AppleMilk]output is " + output.getDisplayName());
				}
			}
		}
		
		for (int i = 0 ; i <= IceRecipe.recipeID.size() ; i++) {
			ItemStack input = IceRecipe.getInput(i);
			ItemStack output = IceRecipe.getOutput(i);
			
			if (input != null && output != null) {
				iceRecipeList.put(input, output);
				
				if (DCsAppleMilk.debugMode)
				{
					System.out.println("[AppleMilk]Checking IceMaker recipe for NEI. No. " + i);
					System.out.println("[AppleMilk]input is " + input.getDisplayName());
					System.out.println("[AppleMilk]output is " + output.getDisplayName());
				}
			}
		}
		
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 3), new ItemStack(DCsAppleMilk.filledPan, 1, 0));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 0), new ItemStack(DCsAppleMilk.filledPan, 1, 1));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 1), new ItemStack(DCsAppleMilk.filledPan, 1, 2));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 2), new ItemStack(DCsAppleMilk.filledPan, 1, 3));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 4), new ItemStack(DCsAppleMilk.filledPan2, 1, 0));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 5), new ItemStack(DCsAppleMilk.filledPan2, 1, 1));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 6), new ItemStack(DCsAppleMilk.filledPan2, 1, 2));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 7), new ItemStack(DCsAppleMilk.filledPan2, 1, 3));
		panRecipeList.put(new ItemStack(DCsAppleMilk.mincedFoods, 1, 8), new ItemStack(DCsAppleMilk.filledChocoPan, 1, 0));
	}

}
