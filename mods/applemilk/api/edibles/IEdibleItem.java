package mods.applemilk.api.edibles;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public interface IEdibleItem {
	
	/**
     * 飲食後に返ってくる空容器
     */
	public ItemStack getReturnContainer(int meta);
	
	/**
     * 飲食時のポーション効果
     */
	public PotionEffect effectOnEaten(int meta);

}
