package mods.applemilk.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFilledPan extends ItemBlock{
	
	private static final String[] type = new String[] {"_rice", "_mushroom", "_stew", "_zousui"};
	
	public ItemFilledPan(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int i = par1ItemStack.getItemDamage() & 3;
		return super.getUnlocalizedName() + type[i];
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
