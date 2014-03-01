package mods.applemilk.common.item;

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
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import mods.applemilk.*;
import mods.applemilk.common.DCsAppleMilk;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemTeaCup extends ItemFood {
	
	 @SideOnly(Side.CLIENT)
     private Icon teaType[];
	 
	 private static final String[] contents = new String[] {"_empty", "_milk", "_tea", "_tea_milk", "_greentea", "_greentea_milk", "_cocoa", "_cocoa_milk", "_juice", "_juice_milk", "_lemon", "_lemon_milk"};
	
	
	public ItemTeaCup (int itemId,int reco, boolean flag){
		super (itemId, reco, flag);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
        this.setAlwaysEdible();

	}
	
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 11);
        return this.teaType[j];
    }

	@Override
	public int getMetadata(int par1) {
		return par1;
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
			else if (meta == 8 || meta == 9)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 0));
			}
			else if (meta == 10 || meta == 11)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 600, 1));
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
		
		return par1ItemStack.stackSize <= 0 ? new ItemStack(DCsAppleMilk.emptyCup,1) : par1ItemStack;
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
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = (par1ItemStack.getItemDamage());
		if (m < 13) return super.getUnlocalizedName() + contents[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		
		for(int i = 0; i < 11; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.teaType = new Icon[11];

        for (int i = 0; i < 11; ++i)
        {
            this.teaType[i] = par1IconRegister.registerIcon("applemilk:cup" + this.contents[i]);
        }
    }

}