package mods.applemilk.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;

public class IceRecipe {
	
	//内部用。登録できるレシピの上限を設定している。
	//ティーメーカーはレシピIDをbyte型で管理しているため、byte型の上限値である127以上は登録できないようにする
	private static int maxID = 0;
	private static final int limitID = 127;
	
	//ダメージ値の上限判定用
	private static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
	/**
     * ティーメーカーのレシピ登録とほとんど同じ。
     * 異なる点はミルク版がないこと、テクスチャが不要なこと、容器を材料スロットに残す場合の登録方法があるくらい。
     */
	protected static HashMap<ItemStack, Integer> recipeID = new HashMap<ItemStack, Integer>();
	protected static HashMap<Integer, ItemStack> outputs = new HashMap<Integer, ItemStack>();
	private static HashMap<Integer, ItemStack> leaveStack = new HashMap<Integer, ItemStack>();
	private static HashMap<Integer, Boolean> leave = new HashMap<Integer, Boolean>();
	
	/**
     * アイスメーカーの燃料に登録したいアイテム、チャージ量を登録する。
     */
	private static HashMap<ItemStack, Integer> charger = new HashMap<ItemStack, Integer>();
	
	/**
     * 内部でのみ使用。すでにID登録したインプットの二重登録を禁止するためのもの。
     */
	private static boolean dupe(ItemStack input)
	{
		Integer val = recipeID.get(input);
		if (val != null) return true;
		else return false;
	}

	private static boolean dupeCharge(ItemStack input)
	{
		Integer val = charger.get(input);
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
			AMTLogger.debugInfo("ID: " + val);
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
     * IDに紐付けされた空容器を返す。
     * 未登録の場合にぬるぽを吐くので、使用時には別途で例外処理が必要。
     */
	public static ItemStack getLeaveStack(int id)
	{
		ItemStack val = leaveStack.get(id);
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
     * そのIDのレシピが空容器返却可能かを返す。
     */
	public static boolean canLeave(int id)
	{
		boolean val = leave.get(id);
		return val;
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
     * インプットに対して、登録されたチャージ量を返す。
     */
	public static int getChargeAmount(ItemStack input)
	{
		Integer val = -1;
		if (input == null)
		{
			val = -1;
		}
		else
		{
			ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
			for(Entry<ItemStack, Integer> check : charger.entrySet())
	        {
				ItemStack target = check.getKey();
				if(input.itemID == target.itemID && (target.getItemDamage() == WILDCARD_VALUE || input.getItemDamage() == target.getItemDamage()))
                {
                    return check.getValue();
                }
	        }
			return -1;
		}
		
		return val;
	}
	
	/**
     * 新レシピの登録メソッド。成功するとtrueを返す。
     */
	private static boolean newRecipeID(ItemStack input, ItemStack output)
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
					leave.put(newID, false);
					AMTLogger.debugInfo("newID(ice): " + newID);
					AMTLogger.debugInfo("input: " + input.getDisplayName());
					AMTLogger.debugInfo("output: " + output.getDisplayName());
					
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
     * 新レシピの登録メソッド。成功するとtrueを返す。
     * こちらは空容器返却可能なレシピを登録する。
     */
	private static boolean newLeaveRecipeID(ItemStack input, ItemStack output, ItemStack leaveItem)
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
					
					if (input.getMaxStackSize() > 1)
					{
						leave.put(newID, false);
						leaveStack.put(newID, leaveItem);
					}
					else
					{
						leave.put(newID, true);
						leaveStack.put(newID, leaveItem);
					}
					
					AMTLogger.debugInfo("newID(ice): " + newID);
					AMTLogger.debugInfo("input: " + input.getDisplayName());
					AMTLogger.debugInfo("output: " + output.getDisplayName());
					AMTLogger.debugInfo("Leaves: " + leaveItem.getDisplayName());
					
					
					return true;
				}
			}
		}
		return false;
	}
	
	/**
     * 新レシピの登録メソッド。成功するとtrueを返す。
     */
	private static boolean newChargeAmount(ItemStack input, int value)
	{
		Integer val = value;
		if (input != null)
		{
			if (val > 0)
			{
				charger.put(input, val);
				AMTLogger.debugInfo("newChargeItem(ice): " + input.getDisplayName());
				AMTLogger.debugInfo("amount: " + val);
				return true;
			}
		}
		return false;
	}
	
	/**
     * 新しいレシピを登録する際に呼び出すメソッド。
     * postInit以降のメソッドでの登録を推奨。
     * @param input (ItemStack) 投入するアイテム
     * @param output (ItemStack) アイスメーカーから得られるアイテム
     */
	public static void register(ItemStack input, ItemStack output)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newRecipeID(inputs,output))
		{
			
		}
	}
	
	/**
     * 新しいレシピを登録する際に呼び出すメソッド。
     * postInit以降のメソッドでの登録を推奨。
     * 材料スロットにアイテムを残す場合、材料となるアイテムのスタックサイズが1でなければならない。
     * （完成時に材料スロットに空きが無いと空容器を残せないため）
     * そのため、スタックサイズが2以上のアイテムを登録した場合は強制的に残らない設定になる。
     * （但し、空容器自体はリストに登録されるため、getLeaveStack(int id)で呼び出すことは出来る。）
     * @param input (ItemStack) 材料スロットに入れるアイテム
     * @param output (ItemStack) アイスメーカーから得られるアイテム
     * @param leaveStack (ItemStack) 材料スロットに残る空容器
     */
	public static void registerCanLeave(ItemStack input, ItemStack output, ItemStack leaveStack)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newLeaveRecipeID(inputs,output,leaveStack))
		{
			
		}
	}
	
	/**
     * 新しいチャージアイテムを登録する。
     * postInit以降のメソッドでの登録を推奨。
     * @param input (ItemStack) アイスメーカーの燃料スロットに投入するアイテム
     * @param val (int) チャージ量（上限127）
     */
	public static void registerCharger(ItemStack input, int val)
	{
		ItemStack inputs = new ItemStack(input.itemID, 1, input.getItemDamage());
		if (!dupe(inputs) && newChargeAmount(inputs,val))
		{
			
		}
	}

}
