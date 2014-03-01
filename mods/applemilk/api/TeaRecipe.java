package mods.applemilk.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;

public class TeaRecipe {
	
	//内部用。登録できるレシピの上限を設定している。
	//ティーメーカーはレシピIDをbyte型で管理しているため、byte型の上限値である127以上は登録できないようにする
	private static int maxID = 0;
	private static final int limitID = 127;
	
	//ダメージ値の上限判定用
	private static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
	//以下のマップ登録はほぼForgeOreDictionaryのパクリ。
	//インプットとID、及びIDとその他もろもろを紐付けしている。
	private static HashMap<ItemStack, Integer> recipeID = new HashMap<ItemStack, Integer>();
	private static HashMap<Integer, ItemStack> outputs = new HashMap<Integer, ItemStack>();
	private static HashMap<Integer, String> contentsTex = new HashMap<Integer, String>();
	private static HashMap<Integer, Integer> canMilk = new HashMap<Integer, Integer>(); 
	
	/**
     * ティーメーカーの中身の液体に用いるテクスチャをStringで取得する。
     * テクスチャがない場合、当MODのミルク用のテクスチャを返す。
     */
	public static String getTex(int id)
	{
		String val = contentsTex.get(id);
		if (val != null && val.length() > 0)
		{
			return val;
		}
		return "applemilk:textures/blocks/contents_milk.png";
	}
	
	/**
     * そのティーメーカーのレシピにミルク追加が許可されているかを返す。
     * ミルクを追加した場合のレシピIDは自動的に、ミルク無しID+1になることに注意。
     */
	public static boolean getCanMilk(int id)
	{
		Integer val = canMilk.get(id);
		if (val != null && val > 0)
		{
			return true;
		}
		return false;
	}
	
	/**
     * 内部でのみ使用。すでにID登録したインプットの二重登録を禁止するためのもの。
     */
	private static boolean dupe(ItemStack input)
	{
		Integer val = recipeID.get(input);
		if (val != null) return true;
		else return false;
	}
	
	/**
     * インプットを引数にして、そのインプットのレシピIDを返す。未登録時には -1 を返す。
     */
	private static int getRecipeID(ItemStack input)
	{
		if (input == null)
		{
			return -1;
		}
		else
		{
			for(Entry<ItemStack, Integer> check : recipeID.entrySet())
	        {
				ItemStack target = check.getKey();
				if(input.itemID == target.itemID && (target.getItemDamage() == WILDCARD_VALUE || input.getItemDamage() == target.getItemDamage()))
                {
                    return check.getValue();
                }
	        }
			return -1;
		}
	}
	
	/**
     * インプットを引数にして、そのインプットのレシピIDを返す。未登録時には -1 を返す。
     * getRecipeIDと異なり、inputの個数を無視したチェックを行う。
     * 外部からの参照時にメインで使うメソッド。
     */
	public static int getID(ItemStack input)
	{
		Integer val = -1;
		if (input == null)
		{
			val = -1;
		}
		else
		{
			ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
			val = getRecipeID(inputs);
			if (DCsAppleMilk.debugMode) System.out.println("[AppleMilk]ID: " + val);
		}
		
		return val;
	}
	
	/**
     * IDからインプットを返す。
     * 失敗判定時など、入れたものを取り戻したい時に使う。
     */
	public static ItemStack getInput(int id)
	{
		for (Map.Entry<ItemStack, Integer> entry : recipeID.entrySet())
        {
            if (id == entry.getValue())
            {
                return entry.getKey();
            }
        }
        return (ItemStack)null;
	}
	
	/**
     * IDに紐付けされたアウトプットを返す。
     * 未登録の場合にぬるぽを吐くので、使用時には別途で例外処理が必要。
     */
	public static ItemStack getOutput(int id)
	{
		ItemStack val = outputs.get(id);
		if (val != null)
		{
			return val;
		}
		else
		{
			return (ItemStack)null;
		}
	}
	
	/**
     * 新規にレシピIDを登録するメソッド。
     * 上限に達している時は-1を返す。
     */
	private static int setMaxID()
	{
		if (maxID < limitID){
			maxID++;
			return maxID;
		}
		else
		{
			return -1;
		}
	}
	
	/**
     * 新レシピの登録メソッド。成功するとtrueを返す。
     * newIDを取得したあと、そのIDにアウトプット、ティメーカー用のテクスチャのパスを登録する。
     */
	private static boolean newRecipeID(ItemStack input, ItemStack output, String tex)
	{
		Integer val = recipeID.get(input);
		if (input != null && output != null)
		{
			if (val == null)
			{
				int newID = setMaxID();
				
				if (newID != -1)
				{
					recipeID.put(input, newID);
					outputs.put(newID, output);
					contentsTex.put(newID, tex);
					canMilk.put(newID, 0);
					if (DCsAppleMilk.debugMode)
					{
						System.out.println("[AppleMilk]new Tea ID is " + newID);
						System.out.println("[AppleMilk]new input is " + input.itemID);
						System.out.println("[AppleMilk]new output is " + output.itemID);
					}
					
					
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean newMilkRecipeID(ItemStack input, ItemStack output, ItemStack output2, boolean milk, String tex, String tex2)
	{
		Integer val = recipeID.get(input);
		if (input != null && output != null)
		{
			if (val == null)
			{
				int newID = setMaxID();
				
				if (newID != -1)
				{
					recipeID.put(input, newID);
					outputs.put(newID, output);
					contentsTex.put(newID, tex);
					if (DCsAppleMilk.debugMode)
					{
						System.out.println("[AppleMilk]new Tea ID is " + newID);
						System.out.println("[AppleMilk]new input is " + input.itemID);
						System.out.println("[AppleMilk]new output is " + output.itemID);
					}
					
					if(milk)
					{
						int newID2 = setMaxID();
						outputs.put(newID2, output2);
						contentsTex.put(newID2, tex2);
						canMilk.put(newID, 1);
						canMilk.put(newID2, 0);
						if (DCsAppleMilk.debugMode)
						{
							System.out.println("[AppleMilk]new Tea ID (milk) is " + newID2);
							System.out.println("[AppleMilk]new output (milk) is " + output2.itemID);
						}
						
					}
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
     * 新しいレシピを登録する際に呼び出すメソッド。
     * postInit以降のメソッドでの登録を推奨。
     * <br>inputのメタデータに32767（shortの上限値）を入れた場合、異なるメタデータでも同じアウトプットを登録するレシピになります。
     * @param input (ItemStack) 投入するアイテム
     * @param output (ItemStack) ティーメーカーから得られるアイテム
     * @param tex (String) テクスチャへのパス 例："applemilk:textures/blocks/contents_milk.png"
     */
	public static void register(ItemStack input, ItemStack output, String tex)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newRecipeID(inputs,output,tex))
		{
			
		}
	}
	
	/**
     * ミルクを追加投入できる場合のレシピ登録メソッドその1。
     * postInit以降のメソッドでの登録を推奨。
     * @param input (ItemStack) 投入するアイテム
     * @param output (ItemStack) ティーメーカーから得られるアイテム
     * @param output2 (ItemStack) ミルク追加時に得られるアイテム
     * @param tex (String) テクスチャへのパス 例："applemilk:textures/blocks/contents_milk.png"
     */
	public static void registerCanMilk(ItemStack input, ItemStack output, ItemStack output2, String tex)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newMilkRecipeID(inputs,output,output2,true,tex,tex))
		{
			
		}
	}
	
	/**
     * ミルクを追加投入できる場合のレシピ登録メソッドその2。
     * ミルク入り飲料に専用のテクスチャを登録したい場合に使用。
     * <br>（テクスチャの用意が手間だという方は、その1の方を使用して下さい。）
     * <br>postInit以降のメソッドでの登録を推奨。
     * @param input (ItemStack) 投入するアイテム
     * @param output (ItemStack) ティーメーカーから得られるアイテム
     * @param output2 (ItemStack) ミルク追加時に得られるアイテム
     * @param tex (String) テクスチャへのパス 例："applemilk:textures/blocks/contents_tea.png"
     * @param milktex (String) テクスチャへのパス 例："applemilk:textures/blocks/contents_tea_milk.png"
     */
	public static void registerCanMilk(ItemStack input, ItemStack output, ItemStack output2, String tex, String milktex)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newMilkRecipeID(inputs,output,output2,true,tex,milktex))
		{
			
		}
	}

}
