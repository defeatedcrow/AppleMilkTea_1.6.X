package mods.applemilk.common.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.api.edibles.EdibleItemBlock;
import mods.applemilk.common.*;
import mods.applemilk.handler.LoadSSectorHandler;
import mods.applemilk.handler.Util;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
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

public class ItemBlockTeaCup extends EdibleItemBlock{
	
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
        int meta = par1ItemStack.getItemDamage();
		
		if (!par2World.isRemote)
		{
			this.setPotionWithTea(par3EntityPlayer, meta);
			this.addSSMoisture(3, 1.5F, par3EntityPlayer);
		}

        return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
    }
	
	@Override
	public ItemStack getReturnContainer(int meta) {
		
		return new ItemStack(DCsAppleMilk.emptyCup, 1, 0);
	}

	@Override
	public PotionEffect effectOnEaten(int meta) {
		
		if(meta == 4 || meta == 5)
		{
			return new PotionEffect(Potion.digSpeed.id, 600, 0);
		}
		else if(meta == 6 || meta == 7)
		{
			return new PotionEffect(Potion.nightVision.id, 600, 0);
		}
		else if ((meta == 8 || meta == 9) && DCsAppleMilk.succeedAddPotion)
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 600, 0);
		}
		else if ((meta == 10 || meta == 11) && DCsAppleMilk.succeedAddPotion)
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 600, 1);
		}
		else if (meta == 12 || meta == 13)
		{
			return new PotionEffect(Potion.nightVision.id, 600, 0);
		}
		else
		{
			return new PotionEffect(Potion.heal.id, 1, 0);
		}
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
        	PotionEffect effect = this.effectOnEaten(itemstack.getItemDamage());
        	ItemStack ret = this.getReturnContainer(itemstack.getItemDamage());
        	
        	entity.addPotionEffect(effect);
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
	
	protected void setPotionWithTea (EntityPlayer par1EntityPlayer, int meta)
	{
		if(meta == 1)
		{
			par1EntityPlayer.clearActivePotions();
		}
		
		if ((meta & 1) == 1)
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
		}
		
		if (DCsAppleMilk.suffocation != null && par1EntityPlayer.isPotionActive(DCsAppleMilk.suffocation))
		{
			par1EntityPlayer.removePotionEffect(DCsAppleMilk.suffocation.id);
		}
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 16;
    }

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
		
		par3List.add(s);
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
