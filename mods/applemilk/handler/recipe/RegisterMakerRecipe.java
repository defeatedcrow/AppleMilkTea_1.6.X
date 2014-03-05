package mods.applemilk.handler.recipe;

import mods.applemilk.api.IceRecipe;
import mods.applemilk.api.TeaRecipe;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RegisterMakerRecipe {
	
	public void registerTea()
	{
		//登録メソッド
		//teacup1
	    TeaRecipe.register(new ItemStack(Item.bucketMilk, 1), new ItemStack(DCsAppleMilk.teacupBlock, 1, 1),
	    		new String("applemilk:textures/blocks/contents_milk.png"));
	    
	    //牛乳を追加投入できるものは下記のメソッドで登録
	    TeaRecipe.registerCanMilk(new ItemStack(Item.dyePowder, 1, 3), new ItemStack(DCsAppleMilk.teacupBlock, 1, 6),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 7),
	    		new String("applemilk:textures/blocks/contents_cocoa.png"),
	    		new String("applemilk:textures/blocks/contents_cocoa_milk.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 2), new ItemStack(DCsAppleMilk.teacupBlock, 1, 4),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 5),
	    		new String("applemilk:textures/blocks/contents_greentea.png"),
	    		new String("applemilk:textures/blocks/contents_greentea_milk.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 3), new ItemStack(DCsAppleMilk.teacupBlock, 1, 2),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 3),
	    		new String("applemilk:textures/blocks/contents_tea.png"),
	    		new String("applemilk:textures/blocks/contents_tea_milk.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.gratedApple, 1, 0), new ItemStack(DCsAppleMilk.teacupBlock, 1, 8),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 9),
	    		new String("applemilk:textures/blocks/contents_juice.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.gratedApple, 1, 1), new ItemStack(DCsAppleMilk.teacupBlock, 1, 8),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 9),
	    		new String("applemilk:textures/blocks/contents_juice.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.gratedApple, 1, 2), new ItemStack(DCsAppleMilk.teacupBlock, 1, 10),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 11),
	    		new String("applemilk:textures/blocks/contents_lemon.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.gratedApple, 1, 3), new ItemStack(DCsAppleMilk.teacupBlock, 1, 12),
	    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 13),
	    		new String("applemilk:textures/blocks/contents_cocoa.png"),
	    		new String("applemilk:textures/blocks/contents_cocoa_milk.png"));
	    
	    //teacup2
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 8), new ItemStack(DCsAppleMilk.teaCup2, 1, 0),
	    		new ItemStack(DCsAppleMilk.teaCup2, 1, 1),
	    		new String("applemilk:textures/blocks/contents_earlgray.png"),
	    		new String("applemilk:textures/blocks/contents_tea_milk.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 9), new ItemStack(DCsAppleMilk.teaCup2, 1, 2),
	    		new ItemStack(DCsAppleMilk.teaCup2, 1, 3),
	    		new String("applemilk:textures/blocks/contents_appletea.png"),
	    		new String("applemilk:textures/blocks/contents_tea_milk.png"));
	    
	    TeaRecipe.register(new ItemStack(DCsAppleMilk.gratedApple, 1, 5), new ItemStack(DCsAppleMilk.teaCup2, 1, 4),
	    		new String("applemilk:textures/blocks/contents_lime.png"));
	    
	    TeaRecipe.register(new ItemStack(DCsAppleMilk.gratedApple, 1, 6), new ItemStack(DCsAppleMilk.teaCup2, 1, 5),
	    		new String("applemilk:textures/blocks/contents_tomato.png"));
	    
	    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.gratedApple, 1, 7), new ItemStack(DCsAppleMilk.teaCup2, 1, 6),
	    		new ItemStack(DCsAppleMilk.teaCup2, 1, 7),
	    		new String("applemilk:textures/blocks/contents_berry.png"));
	    
	    TeaRecipe.register(new ItemStack(DCsAppleMilk.gratedApple, 1, 8), new ItemStack(DCsAppleMilk.teaCup2, 1, 8),
	    		new String("applemilk:textures/blocks/contents_grape.png"));
	    
	    //デバッグモードがONの時に確認用メッセージを出す
	    if (DCsAppleMilk.debugMode)
	    {
	    	ItemStack input = new ItemStack(DCsAppleMilk.gratedApple, 1, 6);
	    	int id = TeaRecipe.getID(input);
	    	System.out.println("[AppleMilk]Cheking registered new TeaMaker recipe");
	    	ItemStack output2 = TeaRecipe.getOutput(id);
	    	System.out.println("[AppleMilk]TeaMaker recipe ID is " + id);
	    	String outputName = output2.getDisplayName();
	    	System.out.println("[AppleMilk]Output: " + outputName);
	    	String textureName = TeaRecipe.getTex(id);
	    	System.out.println("[AppleMilk]Texture: " + textureName);
	    }
	}
	
	public void registerIce()
	{
		IceRecipe.register(new ItemStack(DCsAppleMilk.condensedMIlk, 1, 0), new ItemStack(DCsAppleMilk.blockIcecream, 1, 0));
		
		IceRecipe.register(new ItemStack(Block.gravel, 1, 0), new ItemStack(Item.flint, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 3), new ItemStack(DCsAppleMilk.blockIcecream, 1, 1),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 5), new ItemStack(DCsAppleMilk.blockIcecream, 1, 2),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 7), new ItemStack(DCsAppleMilk.blockIcecream, 1, 3),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 9), new ItemStack(DCsAppleMilk.blockIcecream, 1, 5),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 11), new ItemStack(DCsAppleMilk.blockIcecream, 1, 6),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teacupBlock, 1, 13), new ItemStack(DCsAppleMilk.blockIcecream, 1, 4),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(Item.bucketWater, 1, 0), new ItemStack(DCsAppleMilk.EXItems, 1, 7),
				new ItemStack(Item.bucketEmpty, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teaCup2, 1, 4), new ItemStack(DCsAppleMilk.blockIcecream, 1, 7),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teaCup2, 1, 5), new ItemStack(DCsAppleMilk.blockIcecream, 1, 8),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCanLeave(new ItemStack(DCsAppleMilk.teaCup2, 1, 7), new ItemStack(DCsAppleMilk.blockIcecream, 1, 9),
				new ItemStack(DCsAppleMilk.emptyCup, 1, 0));
		
		IceRecipe.registerCharger(new ItemStack(DCsAppleMilk.icyCrystal, 1, 0), 64);
		
	}

}
