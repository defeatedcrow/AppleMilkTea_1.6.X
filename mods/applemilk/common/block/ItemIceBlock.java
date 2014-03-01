package mods.applemilk.common.block;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ItemIceBlock extends ItemBlock{
	
	private static final String[] type = new String[] {"_milk", "_tea", "_greentea", "_cocoa", "_coffee", "_fruit", "_lemon", "_lime", "_tomato", "_berry"};
	
	public ItemIceBlock(int itemId)
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
		if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		
		if (!par2World.isRemote)
		{
    		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 2));
    		this.setPotionWithIce(par3EntityPlayer, par1ItemStack.getItemDamage());
		}
		
		return par1ItemStack;
	}
	
	protected static void setPotionWithIce (EntityPlayer par1EntityPlayer, int meta)
	{
		if(meta == 0)//milk
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 900, 0));
		}
		else if(meta == 1)//tea
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
		}
		else if(meta == 2)//greentea
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 900, 0));
		}
		else if (meta == 3 || meta == 4)//cocoa,coffee
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 900, 0));
		}
		else if ((meta == 5) && DCsAppleMilk.pothinIDImmunity != 0)//fruit
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 900, 0));
		}
		else if ((meta == 6) && DCsAppleMilk.pothinIDImmunity != 0)//lemon
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(DCsAppleMilk.Immunization.id, 900, 1));
		}
		else if (meta == 7)//lime
		{
			ItemBlockTeaCup2.clearNegativePotion(par1EntityPlayer);
		}
		else if (meta == 8)//tomato
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 900, 0));
		}
		else if (meta == 9)//berry
		{
			par1EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 900, 1));
		}
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.eat;
    }
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
	
	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

}
