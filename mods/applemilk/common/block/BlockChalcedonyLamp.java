package mods.applemilk.common.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.UP;
import mods.applemilk.client.particle.EntityDCCloudFX;
import mods.applemilk.client.particle.EntityOrbFX;
import mods.applemilk.client.particle.ParticleTex;
import mods.applemilk.common.*;
import mods.applemilk.common.tile.TileCLamp;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockChalcedonyLamp extends BlockContainer{
	
	@SideOnly(Side.CLIENT)
    private Icon[] color;
	@SideOnly(Side.CLIENT)
    private Icon[] burst;
	@SideOnly(Side.CLIENT)
    private Icon[] force;
	@SideOnly(Side.CLIENT)
    private Icon inner;
	
	public BlockChalcedonyLamp  (int blockid, Material material, boolean flag)
	{
		super(blockid, Material.glass);
		this.setHardness(0.5F);
		this.setResistance(1.0F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setLightValue(1.0F);
		this.setTickRandomly(true);
	}
	
	@Override
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return this.blockID;
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.LampBoundingBox(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }
	
	public void LampBoundingBox (int par1)
	{
		float f = 0.125F;
		if ((par1 < 4) || (par1 > 5 && par1 < 10))
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		else
		{
			this.setBlockBounds(0.0F + f, 0.0F, 0.0F + f, 1.0F - f, 1.0F, 1.0F - f);
		}
		
	}
	
	public int getMobilityFlag()
    {
        return 0;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return DCsConfig.setAltTexturePass == 1 ? null : new TileCLamp();
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (!DCsConfig.noUseCupDirection && DCsConfig.setAltTexturePass > 1)
		{
			TileCLamp tile = (TileCLamp)world.getBlockTileEntity(x, y, z);
			
			if (!world.isRemote && tile != null)
			{
				int var5 = world.getBlockId(x, y, z - 1);
				int var6 = world.getBlockId(x, y, z + 1);
				int var7 = world.getBlockId(x - 1, y, z);
				int var8 = world.getBlockId(x + 1, y, z);
				byte var9 = 0;
	 
				if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
				{
					var9 = 0;
				}
	 
				if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
				{
					var9 = 1;
				}
	 
				if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
				{
					var9 = 2;
				}
	 
				if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
				{
					var9 = 4;
				}
	 
				tile.setDirectionByte(var9);
			}
		}
	}
 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int playerFacing = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
 
		if (!DCsConfig.noUseCupDirection && DCsConfig.setAltTexturePass > 1)
		{
			byte facing = 0;
			if (playerFacing == 0)
			{
				facing = 0;
			}
			if (playerFacing == 1)
			{
				facing = 1;
			}
			if (playerFacing == 2)
			{
				facing = 2;
			}
			if (playerFacing == 3)
			{
				facing = 4;
			}
	 
			TileEntity tileEntity = par1World.getBlockTileEntity(par2, par3, par4);
			if (tileEntity != null && tileEntity instanceof TileCLamp)
			{
				((TileCLamp)tileEntity).setDirectionByte(facing);
				par1World.markBlockForRenderUpdate(par2, par3, par4);
			}
		}
	}
	
	//rendering
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		if (par2 == 0 || par2 == 2)
		{
			return par1 == 1 ? this.color[0] : this.inner;
		}
		else if (par2 == 1 || par2 == 3)
		{
			return par1 == 1 ? this.color[1] : this.inner;
		}
		else if (par2 == 4)
		{
			return par1 == 1? this.color[0] : (par1 == 0 ? this.burst[0] : (par1 == 2 ? this.burst[1] : this.burst[2]));
		}
		else if (par2 == 5)
		{
			return par1 == 1? this.color[1] : (par1 == 0 ? this.force[0] : this.force[1]);
		}
		else
		{
			return this.color[2];
		}
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		for(int i = 0; i < 6; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
		par3List.add(new ItemStack(this, 1, 6));
		par3List.add(new ItemStack(this, 1, 8));
		par3List.add(new ItemStack(this, 1, 10));
    }
	
	@Override
	public int getRenderType()
	{
		return DCsAppleMilk.modelCLamp;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        int i = par1World.getBlockId(par2, par3 - 1, par2);
        double d0 = (double)((float)par2 + 0.45F + par5Random.nextFloat()/10);
        double d1 = (double)((float)par3 + 0.25 + par5Random.nextFloat()/10);
        double d2 = (double)((float)par4 + 0.45F + par5Random.nextFloat()/10);
        double d3 = 0.0159999988079071D;
        double d4 = 0.27000001072883606D;

        if (!DCsConfig.noRenderFoodsSteam && DCsConfig.setAltTexturePass == 1) {
        	
        	if (l == 4 || l == 10)
        	{
        		EntityOrbFX cloud = new EntityOrbFX(par1World, d0, d1, d2, 0.0D, d3, 0.0D);
            	cloud.setParticleIcon(ParticleTex.getInstance().getIcon("applemilk:particle_orb"));
    			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
        	}
        	
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.color = new Icon[3];
        for (int i = 0; i < 3; ++i)
        {
            if (i == 0) this.color[i] = par1IconRegister.registerIcon("applemilk:chalcedony");
            else if (i == 1) this.color[i] = par1IconRegister.registerIcon("applemilk:chalcedony_orange");
            else this.color[i] = par1IconRegister.registerIcon("applemilk:chalcedony_white");
        	
        }
        this.force = new Icon[2];
        for (int i = 0; i < 2; ++i)
        {
            this.force[i] = par1IconRegister.registerIcon("applemilk:lampside_force_" + i);
        	
        }
        this.burst = new Icon[3];
        for (int i = 0; i < 3; ++i)
        {
            this.burst[i] = par1IconRegister.registerIcon("applemilk:lampside_burst_" + i);
        	
        }
        this.inner = par1IconRegister.registerIcon("applemilk:whitepanel");
	}

}
