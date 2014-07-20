package mods.applemilk.recipe;

import mods.applemilk.api.recipe.RecipeRegisterManager;

public class RegisterManager {
	
	public static void load()
	{
		RecipeRegisterManager.teaRecipe = new TeaRecipeRegister();
		RecipeRegisterManager.iceRecipe = new IceRecipeRegister();
	}
	
	private RegisterManager(){}

}
