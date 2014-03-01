package mods.applemilk.common.block;

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

public class ItemBowlJP extends ItemBlock{
	
	private static final String[] type = new String[] {"_rice", "_mushroom", "_stew", "_zousui", "_kayaku", "_soi", "_pumpkin", "_BLTsoup"};
	
	public ItemBowlJP(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 8) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		
		int meta = par1ItemStack.getItemDamage();
		
		if (!par2World.isRemote)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 2, 2));
		}
		
		if (DCsAppleMilk.SuccessLoadBamboo)
		{
			if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(LoadBambooHandler.bambooBasket,1)))
        	{
        		par3EntityPlayer.entityDropItem(new ItemStack(LoadBambooHandler.bambooBasket,1), 1);
        	}
		}
		else
		{
			if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bowlEmpty,1)))
	    	{
				par3EntityPlayer.entityDropItem(new ItemStack(Item.bowlEmpty,1), 1);
	    	}
		}
		
		return par1ItemStack;
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.eat;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
