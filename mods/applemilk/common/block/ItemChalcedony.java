package mods.applemilk.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemChalcedony extends ItemBlock{
	
	private static final String[] type = new String[] {"", "_orange"};
	
	public ItemChalcedony(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 2) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}