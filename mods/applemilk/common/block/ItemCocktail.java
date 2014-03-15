package mods.applemilk.common.block;

import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.AchievementRegister;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCocktail extends EdibleItemBlock{
	
	private static final String[] type = new String[] {"_frozen_daiquiri", "_frozen_sake", "_saketini", "_gimlet", "_blackrose", "_redeye",
		"_pinacolada", "_americanlemonade", "_moscowmule", "_mintjulep"};
	
	public ItemCocktail(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 10) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
    		this.setPotionWithIce(par3EntityPlayer, par1ItemStack.getItemDamage());
		}
		par3EntityPlayer.triggerAchievement(AchievementRegister.drinkCocktail);
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}
	
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return new PotionEffect(Potion.hunger.id, 300, 1);
	}
	
	protected static void setPotionWithIce (EntityPlayer par1EntityPlayer, int meta)
	{
		if(meta == 0)//frozen daiquiri
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2400, 2));
		}
		else if(meta == 1)//frozen sake
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2400, 0));
		}
		else if (meta == 2)//sake-tini
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2400, 2));
		}
		else if ((meta == 3) && DCsAppleMilk.pothinIDImmunity != 0)//gimlet
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 2400, 2));
		}
		else if ((meta == 4) && DCsAppleMilk.pothinIDImmunity != 0)//black rose
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2400, 0));
		}
		else if (meta == 5)//red eye
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 2400, 2));
		}
		else if (meta == 6)//pina colada
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2400, 0));
		}
		else if (meta == 7)//american lemonade
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 2400, 3));
		}
		else if (meta == 8)//moscow mule
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2400, 3));
		}
		else if (meta == 9)//mint julep
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2400, 3));
		}
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.drink;
    }
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
