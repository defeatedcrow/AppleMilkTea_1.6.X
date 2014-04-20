package mods.applemilk.common.block;

import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.LoadSSectorHandler;
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
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        int meta = par1ItemStack.getItemDamage();
        int heal = (meta == 3) ? 1 : 2;
		
		if (!par2World.isRemote)
		{
			this.addStamina(heal, 1.5F, par3EntityPlayer);
		}

        return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
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
	
	private void addStamina(int par1, float par2, EntityPlayer par3EntityPlayer)
	{
		int heal = par1;
		float saturation = par2;
		if (DCsAppleMilk.SuccessLoadSSector)
		{
			LoadSSectorHandler.addStatus(-1, 0.0F, heal, saturation, par3EntityPlayer);
		}
	}

}
