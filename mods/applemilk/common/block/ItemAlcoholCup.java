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

public class ItemAlcoholCup extends EdibleItemBlock{
	
	private static final String[] type = new String[] {"_sake", "_beer", "_wine", "_rum", "_gin", "_vodka", "_whiskey",
		"_apple", "_tea", "_cassis", "_plum"};
	
	public ItemAlcoholCup(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 11) return super.getUnlocalizedName() + type[m];
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
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}
	
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		return new PotionEffect(Potion.hunger.id, 100, 1);
	}
	
	@Override
	public ItemStack getReturnContainer(int meta) {
		
		return new ItemStack(DCsAppleMilk.emptyCup, 1, 0);
	}
	
	protected static ArrayList<PotionEffect> getPotionWithIce (EntityPlayer par1EntityPlayer, int meta)
	{
		PotionEffect potion = new PotionEffect(Potion.heal.id, 1, 1);
		int tick = 2400;
		boolean flag = false;
		
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		
		if(meta == 0 && DCsAppleMilk.reflex != null)//sake
		{
			potion = new PotionEffect(DCsAppleMilk.reflex.id, 2400, 0);
		}
		else if(meta == 1)//beer
		{
			potion = new PotionEffect(Potion.digSpeed.id, 2400, 0);
		}
		else if (meta == 2 && DCsAppleMilk.absHeal != null)//wine
		{
			potion = new PotionEffect(DCsAppleMilk.absHeal.id, 2400, 0);
		}
		else if (meta == 3)//rum
		{
			potion = new PotionEffect(Potion.resistance.id, 2400, 1);
		}
		else if (meta == 4)//gin
		{
			potion = new PotionEffect(Potion.damageBoost.id, 2400, 0);
		}
		else if (meta == 5)//vodka
		{
			potion = new PotionEffect(Potion.damageBoost.id, 2400, 1);
		}
		else if (meta == 6)//wiskey
		{
			potion = new PotionEffect(Potion.digSpeed.id, 2400, 1);
		}
		else if (meta == 7)//apple
		{
			potion = new PotionEffect(Potion.jump.id, 2400, 1);
		}
		else if (meta == 8)//tea
		{
			potion = new PotionEffect(Potion.heal.id, 1, 1);
		}
		else if (meta == 9)//cassis
		{
			potion = new PotionEffect(Potion.fireResistance.id, 2400, 0);
		}
		else if (meta == 10 && DCsAppleMilk.prvSuffocation != null)//plum
		{
			potion = new PotionEffect(DCsAppleMilk.prvSuffocation.id, 2400, 0);
		}
		else
		{
			potion = new PotionEffect(Potion.heal.id, 1, 1);
		}
		
		ret.add(potion);
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
