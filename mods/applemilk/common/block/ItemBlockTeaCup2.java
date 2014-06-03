package mods.applemilk.common.block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.*;
import mods.applemilk.handler.LoadSSectorHandler;
import mods.applemilk.handler.Util;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBlockTeaCup2 extends EdibleItemBlock{
	
	private static final String[] teaType = new String[] {"_earlgray", "_earlgray_milk", "_appletea", "_appletea_milk", "_lime", "_tomato", "_berry", "_berry_milk", "_grape", "_mint"};
	
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
        int meta = par1ItemStack.getItemDamage();
		
		if (!par2World.isRemote)
		{
			this.setPotionWithTea(par3EntityPlayer, meta);
			
		}
        this.addSSMoisture(4, 1.5F, par3EntityPlayer);
        return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
    }
	
	@Override
	public ItemStack getReturnContainer(int meta) {
		
		return new ItemStack(DCsAppleMilk.emptyCup, 1, 0);
	}
	
	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		if((meta == 0 || meta == 1) && DCsAppleMilk.pothinIDImmunity != 0)
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 600, 1);
		}
		else if((meta == 2 || meta == 3) && DCsAppleMilk.pothinIDImmunity != 0)
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 600, 0);
		}
		else if (meta == 5)
		{
			return new PotionEffect(Potion.damageBoost.id, 600, 0);
		}
		else if (meta == 6 || meta == 7)
		{
			return new PotionEffect(Potion.resistance.id, 600, 1);
		}
		else if (meta == 8)
		{
			return new PotionEffect(Potion.moveSpeed.id, 600, 1);
		}
		else
		{
			return new PotionEffect(Potion.heal.id, 1, 1);
		}
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
	
	protected static void increaseDuration(EntityLivingBase living)
	{
		Iterator current = living.getActivePotionEffects().iterator();
		int increase = 6000;
		
		while (current.hasNext())
        {
            PotionEffect potioneffect = (PotionEffect)current.next();
            boolean flag = potioneffect.getPotionID() != Potion.heal.id && potioneffect.getPotionID() !=  Potion.harm.id
            		&& potioneffect.getPotionID() != Potion.regeneration.id;
            if (flag) living.addPotionEffect(new PotionEffect(potioneffect.getPotionID(), potioneffect.getDuration() + increase, potioneffect.getAmplifier()));
        }
	}
	
	protected void setPotionWithTea (EntityPlayer par1EntityPlayer, int meta)
	{
		if ((meta < 4) && DCsAppleMilk.pothinIDImmunity != 0)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
		}
		
		if (meta == 4)
		{
			clearNegativePotion(par1EntityPlayer);
		}
		
		if (meta == 9)
		{
			increaseDuration(par1EntityPlayer);
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
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
        if (entity.worldObj.isRemote || entity == null)
        {
            return false;
        }
        else
        {
        	int meta = itemstack.getItemDamage();
        	PotionEffect effect = this.effectOnEaten(meta);
        	ItemStack ret = this.getReturnContainer(meta);
        	
        	entity.addPotionEffect(effect);
        	if (meta == 4) entity.clearActivePotions();
        	if (meta == 9) increaseDuration(entity);
        	entity.worldObj.playSoundAtEntity(entity, "random.pop", 0.4F, 1.8F);
        	
        	if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }
        	if (!player.inventory.addItemStackToInventory(ret))
	    	{
	    		player.entityDropItem(ret, 1);
	    	}
        	return true;
        }
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 10) return super.getUnlocalizedName() + teaType[m];
		else return super.getUnlocalizedName() + m;
		
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
		PotionEffect effect = this.effectOnEaten(l);
		String s = StatCollector.translateToLocal(effect.getEffectName()).trim();
		if (effect.getAmplifier() > 0)
        {
            s = s + " " + StatCollector.translateToLocal("potion.potency." + effect.getAmplifier()).trim();
        }

        if (effect.getDuration() > 20)
        {
            s = s + " (" + Potion.getDurationString(effect) + ")";
        }
		
        if (l == 4)//ライムジュースのみ
        {
        	par3List.add("Clear negative potion effect.");
        }
        else if (l == 9)//ミントティーのみ
        {
        	par3List.add("Increase duration of current potion effect. (+5 min)");
        }
        else
        {
        	par3List.add(s);
        }
		
	}
	
	private void addSSMoisture(int par1, float par2, EntityPlayer par3EntityPlayer)
	{
		int heal = par1;
		float satuation = par2;
		if (DCsAppleMilk.SuccessLoadSSector)
		{
			AMTLogger.debugInfo("Trying add status.");
			LoadSSectorHandler.addStatus(heal, satuation, 0, 0.0F, par3EntityPlayer);
		}
	}

}
