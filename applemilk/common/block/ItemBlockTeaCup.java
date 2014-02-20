package mods.applemilk.common.block;

import mods.applemilk.common.*;
import mods.applemilk.handler.Util;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBlockTeaCup extends ItemBlock{
	
	private static final String[] teaType = new String[] {"_empty", "_milk", "_tea", "_tea_milk", "_greentea", "_greentea_milk", "_cocoa", "_cocoa_milk", "_juice", "_fruitshakes", "_lemon", "_lemon_milk", "_coffee", "_coffee_milk"};
	
	private int healAmount = 0;
	
	public ItemBlockTeaCup(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
		this.setMaxStackSize(Util.getCupStacksize());
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        int meta = par1ItemStack.getItemDamage();
		
		if (!par2World.isRemote)
		{
			if(meta == 1)
			{
				par3EntityPlayer.clearActivePotions();
			}
			else if(meta == 4 || meta == 5)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 600, 0));
			}
			else if(meta == 6 || meta == 7)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 600, 0));
			}
			else if ((meta == 8 || meta == 9) && DCsAppleMilk.pothinIDImmunity != 0)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 0));
			}
			else if ((meta == 10 || meta == 11) && DCsAppleMilk.pothinIDImmunity != 0)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 1));
			}
			else if (meta == 12 || meta == 13)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 600, 0));
			}
			else
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
			}
			
			if ((meta & 1) == 1)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
			}
		}

        return par1ItemStack.stackSize <= 0 ? new ItemStack(DCsAppleMilk.emptyCup) : par1ItemStack;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 16;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.drink;
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 14) return super.getUnlocalizedName() + teaType[m];
		else return super.getUnlocalizedName() + m;
		
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
