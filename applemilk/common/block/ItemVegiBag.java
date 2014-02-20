package mods.applemilk.common.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemVegiBag extends ItemBlock{
	
	private static final String[] bagVegi = new String[] {"_Leaves", "_Potato", "_Carrot", "_Pumpkin", "_Seed", "_Reed", "_Cactus", "Cocoa", "_Wart"};
	
	public ItemVegiBag(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 9) return super.getUnlocalizedName() + bagVegi[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
