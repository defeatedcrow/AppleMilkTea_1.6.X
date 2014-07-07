package mods.applemilk.common.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import mods.applemilk.client.particle.EntityBlinkFX;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileIceCream;

public class BlockIceCream extends BlockContainer{
	
	private static final String[] contents = new String[] {"_milk", "_tea_milk", "_greentea_milk", "_cocoa", "_cocoa_milk", "_juice", "_lemon", "_lime", "_tomato", "_berry", "_grape", "_mint"};
	
	@SideOnly(Side.CLIENT)
    private Icon boxTex;
	@SideOnly(Side.CLIENT)
    private Icon[] contentsTex;
	
	
	public BlockIceCream (int blockid)
	{
		super(blockid, Material.glass);
		this.setStepSound(Block.soundGlassFootstep);
		this.setHardness(0.2F);
		this.setResistance(1.0F);
		this.setTickRandomly(true);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
        int currentMeta = par1World.getBlockMetadata(par2, par3, par4);
        int bottomBlockID = par1World.getBlockId(par2, par3 - 1, par4);
        
        if (itemstack == null)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == DCsAppleMilk.chopsticks.itemID)
        {
        	if (!par1World.isRemote)
    		{
        		if (this.effectOnEaten(currentMeta) != null) {
        			par5EntityPlayer.addPotionEffect(this.effectOnEaten(currentMeta));
        		}
        		else if (currentMeta == 4) {
        			ItemBlockTeaCup2.clearNegativePotion(par5EntityPlayer);
        		}
        		else if (currentMeta == 11) {
        			this.increaseAmplifier(par5EntityPlayer);
        		}
    		}
        	
        	par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else if (itemstack.itemID == this.blockID)
        {
        	if (!par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(this,1,currentMeta)))
        	{
        		par5EntityPlayer.entityDropItem(new ItemStack(this,1,currentMeta), 1);
        	}
    		
    		par1World.setBlockToAir(par2, par3, par4);
    		par1World.playSoundAtEntity(par5EntityPlayer, "random.pop", 0.4F, 1.8F);
    		return true;
        }
        else
        {
        	return false;
        }
    }
	
	protected static void increaseAmplifier(EntityLivingBase living)
	{
		Iterator current = living.getActivePotionEffects().iterator();
		int increase = 1;
		
		while (current.hasNext())
        {
            PotionEffect potioneffect = (PotionEffect)current.next();
            boolean flag = potioneffect.getPotionID() != Potion.regeneration.id && potioneffect.getAmplifier() < 10;
            if (flag) living.addPotionEffect(new PotionEffect(potioneffect.getPotionID(), potioneffect.getDuration(), potioneffect.getAmplifier() + increase));
        }
	}
	
	public PotionEffect effectOnEaten(int meta) {
		
		if(meta == 0)//milk
		{
			return new PotionEffect(Potion.fireResistance.id, 900, 0);
		}
		else if(meta == 1)//tea
		{
			return new PotionEffect(Potion.heal.id, 1, 0);
		}
		else if(meta == 2)//greentea
		{
			return new PotionEffect(Potion.digSpeed.id, 900, 0);
		}
		else if (meta == 3 || meta == 4)//cocoa,coffee
		{
			return new PotionEffect(Potion.nightVision.id, 900, 0);
		}
		else if ((meta == 5) && DCsAppleMilk.Immunization != null)//fruit
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 900, 0);
		}
		else if ((meta == 6) && DCsAppleMilk.Immunization != null)//lemon
		{
			return new PotionEffect(DCsAppleMilk.Immunization.id, 900, 1);
		}
		else if (meta == 7)//lime
		{
			return null;
		}
		else if (meta == 8)//tomato
		{
			return new PotionEffect(Potion.damageBoost.id, 900, 0);
		}
		else if (meta == 9)//berry
		{
			return new PotionEffect(Potion.resistance.id, 900, 1);
		}
		else if (meta == 10)//grape
		{
			return new PotionEffect(Potion.moveSpeed.id, 900, 0);
		}
		else//mint
		{
			return null;
		}
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}
 
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelIceCream;
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.thisBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void thisBoundingBox (int par1)
	{
		float f = 0.25F;
		this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 0.5F, 1.0F - f);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par1 == 1)
		{
			return this.contentsTex[par2];
		}
		else
		{
			return this.boxTex;
		}
		
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 12; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
    }
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.boxTex = par1IconRegister.registerIcon("applemilk:blueglass");
		this.contentsTex = new Icon[12];
        for (int i = 0; i < 12; ++i)
        {
        	this.contentsTex[i] = par1IconRegister.registerIcon("applemilk:contents" + contents[i]);
        }
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileIceCream();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        
        double d0 = (double)((float)par2 + par5Random.nextFloat());
        double d1 = (double)((float)par3 + 0.2F + par5Random.nextFloat());
        double d2 = (double)((float)par4 + par5Random.nextFloat());
        double d3 = 0.0099999988079071D;
        double d4 = 0.0099999988079071D;
        double d5 = 0.0099999988079071D;

        if (!DCsConfig.noRenderFoodsSteam) {
        	EntityBlinkFX cloud = new EntityBlinkFX(par1World, d0, d1, d2, 0.0D, d4, 0.0D);
        	cloud.setParticleIcon(ParticleTex.getInstance().getIcon("applemilk:particle_blink"));
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
        }
    }
	
}
