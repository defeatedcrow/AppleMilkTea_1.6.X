package mods.applemilk.common.block;

import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodPlate extends EdibleItemBlock{
	
	private static final String[] type = new String[] {"_beef", "_pork", "_chicken", "_clam"};
	
	public ItemFoodPlate(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 4) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return meta == 3 ? new PotionEffect(Potion.field_76443_y.id, 3, 2) : new PotionEffect(Potion.field_76443_y.id, 3, 3);
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
