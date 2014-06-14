package mods.applemilk.common.block;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.*;
import mods.applemilk.handler.LoadSSectorHandler;
import mods.applemilk.handler.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemCocktail extends EdibleItemBlock{
	
	private static final String[] type = new String[] {"_frozen_daiquiri", "_frozen_sake", "_saketini", "_gimlet", "_blackrose", "_redeye", "_pinacolada", "_americanlemonade",
		"_moscowmule", "_mintjulep", "_kir", "_cassismilk", "_bloodymary", "_cassistea"};
	
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
		if (m < 14) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
    		this.setPotionWithIce(par3EntityPlayer, par1ItemStack.getItemDamage());
    		this.addSSMoisture(4, 3F, par3EntityPlayer);
		}
		par3EntityPlayer.triggerAchievement(AchievementRegister.drinkCocktail);
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}
	
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return new PotionEffect(Potion.hunger.id, 300, 1);
	}
	
	protected static ArrayList<PotionEffect> getPotionWithIce (EntityPlayer par1EntityPlayer, int meta)
	{
		PotionEffect potion = new PotionEffect(Potion.digSpeed.id, 2400, 2);
		int tick = 2400;
		boolean flag = false;
		
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		
		if(meta == 0)//frozen daiquiri
		{
			if (par1EntityPlayer.isPotionActive(Potion.invisibility.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.invisibility).getDuration() + 2400;
				potion = new PotionEffect(Potion.invisibility.id, tick, 0);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.invisibility.id, 2400, 0);
			}
		}
		else if(meta == 1 && DCsAppleMilk.succeedAddPotion)//frozen sake
		{
			if (par1EntityPlayer.isPotionActive(DCsConfig.potionIDReflex)) {
				tick = par1EntityPlayer.getActivePotionEffect(DCsAppleMilk.reflex).getDuration() + 2400;
				potion = new PotionEffect(DCsConfig.potionIDReflex, tick, 2);
				flag = false;
			}
			else {
				potion = new PotionEffect(DCsConfig.potionIDReflex, 2400, 2);
			}
		}
		else if (meta == 2)//sake-tini
		{
			if (par1EntityPlayer.isPotionActive(Potion.field_76434_w.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.field_76434_w).getDuration() + 2400;
				potion = new PotionEffect(Potion.field_76434_w.id, tick, 1);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.field_76434_w.id, 2400, 1);
			}
		}
		else if (meta == 3)//gimlet
		{
			if (par1EntityPlayer.isPotionActive(Potion.resistance.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.resistance).getDuration() + 600;
				potion = new PotionEffect(Potion.resistance.id, tick, 4);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.resistance.id, 600, 4);
			}
		}
		else if (meta == 4 && DCsAppleMilk.succeedAddPotion)//black rose
		{
			if (par1EntityPlayer.isPotionActive(DCsConfig.potionIDPrvProjectile)) {
				tick = par1EntityPlayer.getActivePotionEffect(DCsAppleMilk.prvProjectile).getDuration() + 2400;
				potion = new PotionEffect(DCsConfig.potionIDPrvProjectile, tick, 0);
				flag = false;
			}
			else {
				potion = new PotionEffect(DCsConfig.potionIDPrvProjectile, 2400, 0);
			}
		}
		else if (meta == 5)//red eye
		{
			if (par1EntityPlayer.isPotionActive(Potion.digSpeed.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.digSpeed).getDuration() + 2400;
				potion = new PotionEffect(Potion.digSpeed.id, tick, 1);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.digSpeed.id, 2400, 1);
			}
		}
		else if (meta == 6 && DCsAppleMilk.succeedAddPotion)//pina colada
		{
			if (par1EntityPlayer.isPotionActive(DCsConfig.potionIDPrvExplode)) {
				tick = par1EntityPlayer.getActivePotionEffect(DCsAppleMilk.prvExplode).getDuration() + 2400;
				potion = new PotionEffect(DCsConfig.potionIDPrvExplode, tick, 0);
				flag = false;
			}
			else {
				potion = new PotionEffect(DCsConfig.potionIDPrvExplode, 2400, 0);
			}
		}
		else if (meta == 7 && DCsAppleMilk.succeedAddPotion)//american lemonade
		{
			if (par1EntityPlayer.isPotionActive(DCsConfig.potionIDAbsHeal)) {
				tick = par1EntityPlayer.getActivePotionEffect(DCsAppleMilk.absHeal).getDuration() + 2400;
				potion = new PotionEffect(DCsConfig.potionIDAbsHeal, tick, 2);
				flag = true;
			}
			else {
				potion = new PotionEffect(DCsConfig.potionIDAbsHeal, 2400, 2);
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
		else if (meta == 10 && DCsAppleMilk.succeedAddPotion)//kir
		{
			if (par1EntityPlayer.isPotionActive(DCsConfig.potionIDAbsEXP)) {
				tick = par1EntityPlayer.getActivePotionEffect(DCsAppleMilk.absEXP).getDuration() + 2400;
				potion = new PotionEffect(DCsConfig.potionIDAbsEXP, tick, 2);
				flag = false;
			}
			else {
				potion = new PotionEffect(DCsConfig.potionIDAbsEXP, 2400, 2);
			}
		}
		else if (meta == 11)//cassis milk
		{
			if (par1EntityPlayer.isPotionActive(Potion.waterBreathing.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.waterBreathing).getDuration() + 2400;
				potion = new PotionEffect(Potion.waterBreathing.id, tick, 0);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.waterBreathing.id, 2400, 0);
			}
		}
		else if (meta == 12)//bloody mary
		{
			if (par1EntityPlayer.isPotionActive(Potion.damageBoost.id)) {
				tick = par1EntityPlayer.getActivePotionEffect(Potion.damageBoost).getDuration() + 600;
				potion = new PotionEffect(Potion.damageBoost.id, tick, 6);
				flag = true;
			}
			else {
				potion = new PotionEffect(Potion.damageBoost.id, 600, 6);
			}
		}
		else//cassis tea cocktail
		{
			potion = new PotionEffect(Potion.heal.id, 2, 2);
		}
		
		ret.add(potion);
		if (flag) {
			ret.add(new PotionEffect(Potion.confusion.id, 300, 1));
		}
		
		return ret;
	}
	
	public static void setPotionWithIce(EntityPlayer par1EntityPlayer, int meta)
	{
		ArrayList<PotionEffect> effect = getPotionWithIce(par1EntityPlayer, meta);
		for(PotionEffect potions : effect)
		{
			par1EntityPlayer.addPotionEffect(potions);
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
	
	@SideOnly(Side.CLIENT)
    //マウスオーバー時の表示情報
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		ArrayList<PotionEffect> effects = this.getPotionWithIce(par2EntityPlayer, l);
		for (PotionEffect effect : effects)
		{
			String s = StatCollector.translateToLocal(effect.getEffectName()).trim();
			if (effect.getAmplifier() > 0)
	        {
				if (effect.getAmplifier() < 4){
					s = s + " " + StatCollector.translateToLocal("potion.potency." + effect.getAmplifier()).trim();
				}
				else {
					s = s + " " + effect.getAmplifier();
				}
	        }

	        if (effect.getDuration() > 20)
	        {
	            s = s + " (" + Potion.getDurationString(effect) + ")";
	        }
			par3List.add(EnumChatFormatting.GRAY + s);
		}
	}
	
	private void addSSMoisture(int par1, float par2, EntityPlayer par3EntityPlayer)
	{
		int heal = par1;
		float saturation = par2;
		if (DCsAppleMilk.SuccessLoadSSector)
		{
			LoadSSectorHandler.addStatus(heal, saturation, 0, 0.0F, par3EntityPlayer);
		}
	}

}
