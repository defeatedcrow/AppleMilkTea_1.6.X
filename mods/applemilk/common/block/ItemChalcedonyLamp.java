package mods.applemilk.common.block;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemChalcedonyLamp extends ItemBlock{
	
	private static final String[] type = new String[] {"_optionBlue", "_option", "_yazukaBlue", "_yazuka", "_legendBurst", "_force",
		"_optionWhite", "optionWhite2", "_yazukaWhite", "_yazukaWhite2", "_cube", "_cube2"};
	
	public ItemChalcedonyLamp(int itemId)
	{
		super(itemId);
		setMaxDamage(0);
		setHasSubtypes(true);
		
	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
        
        int i = par2World.rand.nextInt(5);
        int i2 = par2World.rand.nextInt(3);

        int meta = par1ItemStack.getItemDamage();
		
		if (!par2World.isRemote)
		{
			if(meta == 5)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.blindness.id, 600*i2, 0));
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 600*i2, i));
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600*i2, i));
			}
			if(meta == 4)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600*i2, 0));
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 600*i2, i));
			}
		}

        return par1ItemStack.stackSize <= 0 ? new ItemStack(Item.flint, 1, 0) : par1ItemStack;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.eat;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        int meta = par1ItemStack.getItemDamage();
        if (meta == 4 || meta == 5) par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		int m = (par1ItemStack.getItemDamage());
		if (m < 12) return super.getUnlocalizedName() + type[m];
		else return super.getUnlocalizedName() + m;
	}
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
