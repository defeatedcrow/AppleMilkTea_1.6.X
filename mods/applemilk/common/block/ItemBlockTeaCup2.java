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

public class ItemBlockTeaCup2 extends ItemBlock{
	
	private static final String[] teaType = new String[] {"_earlgray", "_earlgray_milk", "_appletea", "_appletea_milk", "_lime", "_tomato", "_berry", "_berry_milk"};
	
	private int healAmount = 0;
	
	public ItemBlockTeaCup2(int itemId)
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
			this.setPotionWithTea(par3EntityPlayer, meta);
		}

        return par1ItemStack.stackSize <= 0 ? new ItemStack(DCsAppleMilk.emptyCup) : par1ItemStack;
    }
	
	protected static void clearNegativePotion(EntityPlayer player)
	{
		if (player.isPotionActive(Potion.blindness)){
			player.removePotionEffect(Potion.blindness.id);
		}
		if (player.isPotionActive(Potion.confusion)){
			player.removePotionEffect(Potion.confusion.id);
		}
		if (player.isPotionActive(Potion.hunger)){
			player.removePotionEffect(Potion.hunger.id);
		}
		if (player.isPotionActive(Potion.poison)){
			player.removePotionEffect(Potion.poison.id);
		}
		if (player.isPotionActive(Potion.weakness)){
			player.removePotionEffect(Potion.weakness.id);
		}
	}
	
	protected void setPotionWithTea (EntityPlayer par1EntityPlayer, int meta)
	{
		if ((meta == 0 || meta == 1) && DCsAppleMilk.pothinIDImmunity != 0)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
			par1EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 1));
		}
		else if ((meta == 2 || meta == 3) && DCsAppleMilk.pothinIDImmunity != 0)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
			par1EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 0));
		}
		else if (meta == 4)
		{
			clearNegativePotion(par1EntityPlayer);
		}
		else if (meta == 5)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600, 0));
		}
		else if (meta == 6)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 600, 1));
		}
		else
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
		}
		
		if ((meta & 1) == 1) {
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
		}
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
		if (m < 8) return super.getUnlocalizedName() + teaType[m];
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
