package mods.applemilk.handler.economy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mceconomy.api.MCEconomyAPI;
import mods.applemilk.common.DCsAppleMilk;

/**
 * MOD本体で他MODのクラスをインポートしないためのクッション用クラス
 * MCEconomy導入済みかどうかの判定も行う
 */
public class DCsShopGui {
	
	/**
	 * 当MODのショップGuiを開く。未導入時には何もしない。
	 * @param player Guiを開いたプレイヤー
	 * @param world 現在のワールド
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void openShopGui(EntityPlayer player, World world, int x, int y, int z)
	{
		if (DCsAppleMilk.SuccessLoadEconomy && MCEconomyHandler.DCshopId > 0) {
			MCEconomyAPI.openShopGui(MCEconomyHandler.DCshopId, player, world, x, y, z);
		}
	}
	
	/**
	 * MPの加算用メソッド
	 * @param player 対象プレイヤー
	 * @param amount 量
	 */
	public static void addMP(EntityPlayer player, int amount)
	{
		if (DCsAppleMilk.SuccessLoadEconomy && amount > 0) {
			MCEconomyAPI.addPlayerMP(player, amount);
		}
	}
	
	/**
	 * MPの減算用メソッド
	 * @param player 対象プレイヤー
	 * @param amount 量
	 */
	public static void reduceMP(EntityPlayer player, int amount)
	{
		if (DCsAppleMilk.SuccessLoadEconomy && amount > 0) {
			MCEconomyAPI.reducePlayerMP(player, amount);
		}
	}

}
