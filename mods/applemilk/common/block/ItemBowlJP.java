package mods.applemilk.common.block;

import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.LoadBambooHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBowlJP extends EdibleItemBlock{
	
	private static final String[] type = new String[] {"_rice", "_mushroom", "_stew", "_zousui", "_kayaku", "_soi", "_pumpkin", "_BLTsoup"};
	
	public ItemBowlJP(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public ItemStack getReturnContainer(int meta) {
		
		return DCsAppleMilk.SuccessLoadBamboo ? new ItemStack(LoadBambooHandler.bambooBasket, 1, 0) : new ItemStack(Item.bowlEmpty, 1, 0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 8) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
