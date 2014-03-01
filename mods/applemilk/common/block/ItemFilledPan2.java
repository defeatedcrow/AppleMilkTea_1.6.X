package mods.applemilk.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemFilledPan2 extends ItemBlock{
	
	private static final String[] type = new String[] {"_kayaku", "_tofu", "_pumpkin", "_BLTsoup"};
	
	public ItemFilledPan2(int itemId)
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
