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
		PotionEffect potion = new PotionEffect(Potion.digSpeed.id, 2400, 2);
		int tick = 2400;
		boolean flag = false;
		
		if(meta == 0)//frozen daiquiri
		{
			if (par1EntityPlayer.isPotionActive(Potion.digSpeed.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.digSpeed).getDuration() + 2400;
				potion = new PotionEffect(Potion.digSpeed.id, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.digSpeed.id, 2400, 2);
			}
		}
		else if(meta == 1)//frozen sake
		{
			if (par1EntityPlayer.isPotionActive(Potion.fireResistance.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.fireResistance).getDuration() + 2400;
				potion = new PotionEffect(Potion.fireResistance.id, tick, 2);
				flag = false;
			}
			else {
				potion = new PotionEffect(Potion.fireResistance.id, 2400, 2);
			}
		}
		else if (meta == 2)//sake-tini
		{
			if (par1EntityPlayer.isPotionActive(Potion.damageBoost.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.damageBoost).getDuration() + 2400;
				potion = new PotionEffect(Potion.damageBoost.id, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.damageBoost.id, 2400, 2);
			}
		}
		else if (meta == 3)//gimlet
		{
			if (par1EntityPlayer.isPotionActive(Potion.resistance.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.resistance).getDuration() + 2400;
				potion = new PotionEffect(Potion.resistance.id, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.resistance.id, 2400, 2);
			}
		}
		else if (meta == 4)//black rose
		{
			if (par1EntityPlayer.isPotionActive(Potion.invisibility.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.invisibility).getDuration() + 2400;
				potion = new PotionEffect(Potion.invisibility.id, tick, 2);
				flag = false;
			}
			else {
				potion = new PotionEffect(Potion.invisibility.id, 2400, 2);
			}
		}
		else if (meta == 5)//red eye
		{
			if (par1EntityPlayer.isPotionActive(Potion.field_76434_w.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.field_76434_w).getDuration() + 2400;
				potion = new PotionEffect(Potion.field_76434_w.id, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.field_76434_w.id, 2400, 2);
			}
		}
		else if (meta == 6)//pina colada
		{
			if (par1EntityPlayer.isPotionActive(Potion.waterBreathing.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.waterBreathing).getDuration() + 2400;
				potion = new PotionEffect(Potion.waterBreathing.id, tick, 2);
				flag = false;
			}
			else {
				potion = new PotionEffect(Potion.waterBreathing.id, 2400, 2);
			}
		}
		else if (meta == 7)//american lemonade
		{
			if (par1EntityPlayer.isPotionActive(Potion.jump.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.jump).getDuration() + 2400;
				potion = new PotionEffect(Potion.jump.id, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.jump.id, 2400, 2);
			}
		}
		else if (meta == 8)//moscow mule
		{
			if (par1EntityPlayer.isPotionActive(Potion.damageBoost.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.damageBoost).getDuration() + 2400;
				potion = new PotionEffect(Potion.damageBoost.id, tick, 3);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.damageBoost.id, 2400, 3);
			}
		}
		else if (meta == 9)//mint julep
		{
			if (par1EntityPlayer.isPotionActive(Potion.digSpeed.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.digSpeed).getDuration() + 2400;
				potion = new PotionEffect(Potion.digSpeed.id, tick, 3);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.digSpeed.id, 2400, 3);
			}
		}
		
		par1EntityPlayer.addPotionEffect(potion);
		if (flag) {
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 150, 1));
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
