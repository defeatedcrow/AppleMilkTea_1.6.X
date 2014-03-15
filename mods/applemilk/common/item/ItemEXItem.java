package mods.applemilk.common.item;

import java.util.List;

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

public class ItemEXItem extends Item {
	
	private static final String[] leefType = new String[] {"_greentea", "_tea", "_oxidized"};
	@SideOnly(Side.CLIENT)
    private Icon iconItemType[];
	
	public ItemEXItem (int itemId){
		super (itemId);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		maxStackSize = 64;

	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 11);
        return this.iconItemType[j];
    }

	@Override
	public int getMetadata(int par1) {
		return par1;
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
		par3List.add(new ItemStack(this, 1, 6));
		par3List.add(new ItemStack(this, 1, 7));
		par3List.add(new ItemStack(this, 1, 8));
		par3List.add(new ItemStack(this, 1, 9));
		par3List.add(new ItemStack(this, 1, 10));
		par3List.add(new ItemStack(this, 1, 11));
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (!par3EntityPlayer.capabilities.isCreativeMode && --par1ItemStack.stackSize <= 0)
        {
            par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, (ItemStack)null);
        }
		if (!par2World.isRemote)
        {
			par3EntityPlayer.clearActivePotions();
        }
		
		return par1ItemStack;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 16;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.eat;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (par1ItemStack.getItemDamage() == 0)
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}
        return par1ItemStack;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconItemType = new Icon[12];

        for (int i = 0; i < 12; ++i)
        {
            
        	if (i == 0)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:milkcandy");
        	}
        	else if (i == 1)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:animalglue");
        	}
        	else if (i > 1 && i < 5)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:leaf" + leefType[i - 2]);
        	}
        	else if (i == 5)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:mincedfoods_kayaku");
        	}
        	else if (i == 6)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:gear_chalcedony");
        	}
        	else if (i == 7)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:crushedice");
        	}
        	else if (i == 8)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:leaf_earlgray");
        	}
        	else if (i == 9)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:leaf_appletea");
        	}
        	else if (i == 10)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:wallmug");
        	}
        	else if (i == 11)
        	{
        		this.iconItemType[i] = par1IconRegister.registerIcon("applemilk:dustGlass");
        	}
        	
        }
	}

}
