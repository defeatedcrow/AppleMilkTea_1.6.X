package mods.applemilk.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemChopsticksBox extends ItemBlock{
	
	
	public ItemChopsticksBox(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int i = par1ItemStack.getItemDamage();
		return super.getUnlocalizedName() + i;
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
