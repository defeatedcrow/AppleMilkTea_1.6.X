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
        int j = MathHelper.clamp_int(par1, 0, 15);
        return this.iconToffyType[j];
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
		
		if(par1ItemStack.getItemDamage() == 1)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 600, 1));
		}
		if(par1ItemStack.getItemDamage() == 2)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 600, 0));
		}
		if(par1ItemStack.getItemDamage() == 3)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600, 0));
		}
		if((par1ItemStack.getItemDamage() == 0) || (par1ItemStack.getItemDamage() > 3))
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 600, 0));
		}
		
		return par1ItemStack.stackSize <= 0 ? new ItemStack(Item.stick) : par1ItemStack;
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
	}	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconToffyType = new Icon[4];

        for (int i = 0; i < 4; ++i)
        {
            this.iconToffyType[i] = par1IconRegister.registerIcon("applemilk:icytoffyapple" + i);
        }
    }

}
