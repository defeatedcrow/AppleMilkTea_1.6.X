package mods.applemilk.handler.recipe;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RegisterMakerRecipe {
	
	public void registerTea()
	{
		try
        {
		    //登録メソッド
		    TeaRecipe.register(new ItemStack(Item.bucketMilk, 1), new ItemStack(DCsAppleMilk.teacupBlock, 1, 1),
		    		new String("applemilk:textures/blocks/contents_milk.png"));
		    
		    //牛乳を追加投入できるものは下記のメソッドで登録
		    TeaRecipe.registerCanMilk(new ItemStack(Item.dyePowder, 1, 3), new ItemStack(DCsAppleMilk.teacupBlock, 1, 6),
		    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 7),
		    		new String("applemilk:textures/blocks/contents_cocoa.png"));
		    
		    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 2), new ItemStack(DCsAppleMilk.teacupBlock, 1, 4),
		    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 5),
		    		new String("applemilk:textures/blocks/contents_greentea.png"));
		    
		    TeaRecipe.registerCanMilk(new ItemStack(DCsAppleMilk.EXItems, 1, 3), new ItemStack(DCsAppleMilk.teacupBlock, 1, 2),
		    		new ItemStack(DCsAppleMilk.teacupBlock, 1, 3),
		    		new String("applemilk:textures/blocks/contents_tea.png"));
		    
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
		    		new String("applemilk:textures/blocks/contents_cocoa.png"));
		    
		    //デバッグモードがONの時に確認用メッセージを出す
		    if (DCsAppleMilk.debugMode)
		    {
		    	ItemStack input = new ItemStack(DCsAppleMilk.gratedApple, 1, 1);
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
        catch (Exception e) {
          System.out.println("[AppleMilk]Failed to register new TeaMaker recipe");
          e.printStackTrace(System.err);
        }
	}

}
