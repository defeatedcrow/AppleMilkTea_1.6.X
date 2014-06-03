package mods.applemilk.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;
import mods.applemilk.common.*;
import mods.applemilk.handler.Util;

public class BlockGunpowderContainer extends Block{
	
	private static final String[] boxType = new String[] {"Gunpowder", "Kayaku", "Clay", "Clam"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] boxTex;
	@SideOnly(Side.CLIENT)
    private Icon boxSideTex;
	
	
	public BlockGunpowderContainer (int blockid)
	{
		super(blockid, Material.ground);
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setTickRandomly(true);
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    { 
		int i = par2;
		if (i > 3) i = 3;
		if (par1 == 1)
        {
        	return this.boxTex[i];
        }
        else
        {
        	return this.boxSideTex;
        }
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			
			int meta = par1World.getBlockMetadata(par2, par3, par4);
			
			if (!DCsAppleMilk.noWetGContainer && meta < 2 && (par1World.isRaining()) && par1World.canBlockSeeTheSky(par2, par3 + 1, par4))
			{
				if (meta == 0) par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
				else if (meta == 1) par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			}
			
			if (meta == 3 && DCsAppleMilk.bonemealClam)
			{
				boolean flag = false;
				int y = 0;
				//2,3,4マス上についてチェックする
				for (int i = 0 ; i < 3 ; i++)
				{
					if (this.likeBonemeal(par1World, par2, par3 + 2 + i, par4))
					{
						flag = true;
						y = par3 + 2 + i;
						break;
					}
				}
				
				if (flag)
				{
					par1World.playAuxSFX(2005, par2, y + 1, par4, 0);
					
					if (par1World.rand.nextInt(10) == 0)
					{
						par1World.setBlock(par2, par3, par4, Block.dirt.blockID);
					}
				}
			}
		}
	}
	
	public static boolean likeBonemeal(World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockId(par2, par3, par4);
		FakePlayer faker = new FakePlayer(par1World, "faker");

        BonemealEvent event = new BonemealEvent(faker, par1World, l, par2, par3, par4);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            return true;
        }

        if (l == Block.sapling.blockID)
        {
            if (!par1World.isRemote)
            {
                if ((double)par1World.rand.nextFloat() < 0.45D)
                {
                    ((BlockSapling)Block.sapling).markOrGrowMarked(par1World, par2, par3, par4, par1World.rand);
                }
            }

            return true;
        }
        else if (l != Block.mushroomBrown.blockID && l != Block.mushroomRed.blockID)
        {
            if (l != Block.melonStem.blockID && l != Block.pumpkinStem.blockID)
            {
                if (l > 0 && Block.blocksList[l] instanceof BlockCrops)
                {
                    if (par1World.getBlockMetadata(par2, par3, par4) == 7)
                    {
                        return false;
                    }
                    else
                    {
                        if (!par1World.isRemote)
                        {
                            ((BlockCrops)Block.blocksList[l]).fertilize(par1World, par2, par3, par4);
                        }

                        return true;
                    }
                }
                else
                {
                    int i1;
                    int j1;
                    int k1;

                    if (l == Block.cocoaPlant.blockID)
                    {
                        i1 = par1World.getBlockMetadata(par2, par3, par4);
                        j1 = BlockDirectional.getDirection(i1);
                        k1 = BlockCocoa.func_72219_c(i1);

                        if (k1 >= 2)
                        {
                            return false;
                        }
                        else
                        {
                            if (!par1World.isRemote)
                            {
                                ++k1;
                                par1World.setBlockMetadataWithNotify(par2, par3, par4, k1 << 2 | j1, 2);
                            }

                            return true;
                        }
                    }
                    else if (l != Block.grass.blockID)
                    {
                        return false;
                    }
                    else
                    {
                        if (!par1World.isRemote)
                        {
                            label102:

                            for (i1 = 0; i1 < 128; ++i1)
                            {
                                j1 = par2;
                                k1 = par3 + 1;
                                int l1 = par4;

                                for (int i2 = 0; i2 < i1 / 16; ++i2)
                                {
                                    j1 += par1World.rand.nextInt(3) - 1;
                                    k1 += (par1World.rand.nextInt(3) - 1) * par1World.rand.nextInt(3) / 2;
                                    l1 += par1World.rand.nextInt(3) - 1;

                                    if (par1World.getBlockId(j1, k1 - 1, l1) != Block.grass.blockID || par1World.isBlockNormalCube(j1, k1, l1))
                                    {
                                        continue label102;
                                    }
                                }

                                if (par1World.getBlockId(j1, k1, l1) == 0)
                                {
                                    if (par1World.rand.nextInt(10) != 0)
                                    {
                                        if (Block.tallGrass.canBlockStay(par1World, j1, k1, l1))
                                        {
                                            par1World.setBlock(j1, k1, l1, Block.tallGrass.blockID, 1, 3);
                                        }
                                    }
                                    else
                                    {
                                        ForgeHooks.plantGrass(par1World, j1, k1, l1);
                                    }
                                }
                            }
                        }

                        return true;
                    }
                }
            }
            else if (par1World.getBlockMetadata(par2, par3, par4) == 7)
            {
                return false;
            }
            else
            {
                if (!par1World.isRemote)
                {
                    ((BlockStem)Block.blocksList[l]).fertilizeStem(par1World, par2, par3, par4);
                }

                return true;
            }
        }
        else
        {
            if (!par1World.isRemote)
            {
                if ((double)par1World.rand.nextFloat() < 0.4D)
                {
                    ((BlockMushroom)Block.blocksList[l]).fertilizeMushroom(par1World, par2, par3, par4, par1World.rand);
                }
            }

            return true;
        }
	}
	
	public int tickRate(World par1World)
    {
        return 20;
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
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
		this.boxSideTex = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "Container_S");
		this.boxTex = new Icon[4];
		
        for (int i = 0; i < 4; ++i)
        {
            this.boxTex[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + boxType[i] + "Container_T");
        }
	}

}