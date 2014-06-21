package mods.applemilk.common.item;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import org.bouncycastle.util.Strings;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import mods.applemilk.*;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.LoadSSectorHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemIcyToffyApple extends ItemFood {
	
	 @SideOnly(Side.CLIENT)
     private Icon iconToffyType[];
	
	
	public ItemIcyToffyApple (int itemId,int reco, boolean flag){
		super (itemId, reco, flag);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
        this.setAlwaysEdible();

	}
	
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 5);
        return this.iconToffyType[j];
    }

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
	
	@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		boolean alt = false;
		switch(par1ItemStack.getItemDamage())
		{
		case 0:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 600, 0));
			break;
		case 1:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 600, 1));
			break;
		case 2:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 600, 0));
			break;
		case 3:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600, 0));
			break;
		case 4:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 0));
			break;
		case 5:
			alt = true;
			break;
		default:
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 600, 0));
			break;
			
		}
		
		if (alt)
		{
			Iterator current = par3EntityPlayer.getActivePotionEffects().iterator();
			int increase = 600;
			
			while (current.hasNext())
	        {
	            PotionEffect potioneffect = (PotionEffect)current.next();
	            boolean flag = potioneffect.getPotionID() != Potion.heal.id && potioneffect.getPotionID() !=  Potion.harm.id
	            		&& potioneffect.getPotionID() != Potion.regeneration.id;
	            if (flag) par3EntityPlayer.addPotionEffect(new PotionEffect(potioneffect.getPotionID(), potioneffect.getDuration() + increase, potioneffect.getAmplifier()));
	        }
		}
		
		if (par2World.isRemote && par1ItemStack.getItemDamage() < 4)
		{
			this.reduceMoisture(-1, 0.0F, par3EntityPlayer);
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
		par3List.add(new ItemStack(this, 1, 3));
		par3List.add(new ItemStack(this, 1, 4));
		par3List.add(new ItemStack(this, 1, 5));
	}	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconToffyType = new Icon[6];

        for (int i = 0; i < 4; ++i)
        {
            this.iconToffyType[i] = par1IconRegister.registerIcon("applemilk:icytoffyapple" + i);
        }
        this.iconToffyType[4] = par1IconRegister.registerIcon("applemilk:candy_cassis");
        this.iconToffyType[5] = par1IconRegister.registerIcon("applemilk:candy_mint");
    }
	
	private void reduceMoisture(int par1, float par2, EntityPlayer par3EntityPlayer)
	{
		if (DCsAppleMilk.SuccessLoadSSector)
		{
			LoadSSectorHandler.addStatus(par1, par2, 0, 0.0F, par3EntityPlayer);
		}
	}

}
