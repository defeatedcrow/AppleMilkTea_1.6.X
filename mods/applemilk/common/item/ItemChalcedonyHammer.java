package mods.applemilk.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class ItemChalcedonyHammer extends ItemTool
{
    /** an array of the blocks this pickaxe is effective against */
    public static final Block[] blocksEffectiveAgainst = ItemPickaxe.blocksEffectiveAgainst;

    public ItemChalcedonyHammer(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 2.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
    }

    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if (par3 != Block.ice.blockID)
        {
        	return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
        }
        else
        {
            return true;
        }
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);
        int damage = par1ItemStack.getItemDamage();
        boolean check = false;

        if (i1 == Block.stone.blockID || i1 == Block.ice.blockID || i1 == Block.stoneBrick.blockID)
        {
            check =  true;
        }
        else
        {
            check =  false;
        }
        
        if (check)
        {
        	
        	if (i1 == Block.stone.blockID)
        	{
        		if (par2EntityPlayer.isSneaking())
        		{
        			int i2 = Block.stoneBrick.blockID;
            		int j1 = 0;
                    
                    par3World.setBlock(par4, par5, par6, i2, j1, 3);
                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), Block.blocksList[i2].stepSound.getPlaceSound(), (Block.blocksList[i2].stepSound.getVolume() + 1.0F) / 2.0F, Block.blocksList[i2].stepSound.getPitch() * 0.8F);
                    par1ItemStack.damageItem(2, par2EntityPlayer);
        		}
        		else
        		{
        			par3World.setBlockToAir(par4, par5, par6);
            		par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), Block.stone.stepSound.getBreakSound(), (Block.stone.stepSound.getVolume() + 1.0F) / 2.0F, Block.stone.stepSound.getPitch() * 0.8F);
            		
            		if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Block.stone.blockID, 1, 0)))
                    {
            			par2EntityPlayer.dropPlayerItem(new ItemStack(Block.stone.blockID, 1, 0));
                    }
            		
            		par1ItemStack.damageItem(2, par2EntityPlayer);
        		}
        		return true;
        	}
        	else if (i1 == Block.stoneBrick.blockID && par2EntityPlayer.isSneaking())
        	{
        		int i2 = Block.stoneBrick.blockID;
        		int j1 = 3;
                
                par3World.setBlock(par4, par5, par6, i2, j1, 3);
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), Block.blocksList[i2].stepSound.getPlaceSound(), (Block.blocksList[i2].stepSound.getVolume() + 1.0F) / 2.0F, Block.blocksList[i2].stepSound.getPitch() * 0.8F);
                par1ItemStack.damageItem(2, par2EntityPlayer);
                return true;
        	}
        	else if (i1 == Block.ice.blockID)
        	{
        		par3World.setBlockToAir(par4, par5, par6);
        		par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), Block.ice.stepSound.getBreakSound(), (Block.ice.stepSound.getVolume() + 1.0F) / 2.0F, Block.ice.stepSound.getPitch() * 0.8F);
        		
        		if (!par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Block.ice.blockID, 1, 0)))
                {
        			par2EntityPlayer.dropPlayerItem(new ItemStack(Block.ice.blockID, 1, 0));
                }
        		
        		par1ItemStack.damageItem(2, par2EntityPlayer);
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }
        else
        {
        	return false;
        }
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	this.itemIcon = par1IconRegister.registerIcon("applemilk:chalcedonyhammer");
	}
}
