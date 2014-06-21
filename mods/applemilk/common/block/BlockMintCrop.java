package mods.applemilk.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Random;

import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockMintCrop extends BlockFlower
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public BlockMintCrop(int par1)
    {
        super(par1);
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
        this.setHardness(0.0F);
        this.setStepSound(soundGrassFootstep);
        this.disableStats();
    }

    /*
     * 真下のブロックに植えることが出来るかをブロックIDで判定するメソッド。
     * バニラではpar1 == Block.tilledField.blockID;で判定しているが、これでは拡張性がなさすぎるので、
     * 他の条件を追加してみる。
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        if (par1 == Block.tilledField.blockID) return true;
        
        /*
         * 今回は、バニラの耕地ブロックを継承しているかで判定している。
         * 他のModで追加された耕地ブロックに対応できる可能性がある。
         * */
        Block block = Block.blocksList[par1];
        return (block != null && block instanceof BlockFarmland);
    }

    /*
     * ブロックのアップデート時に呼ばれるメソッド。
     * superでBlockFlowerのメソッド（この場所にブロックとして存在できるかの判定）を呼び、
     * 次にこのブロックの成長判定を行っている。
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);

            if (l < 3)
            {
                float f = this.getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    ++l;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
                }
            }
        }
    }

    /*
     * 骨粉による成長メソッド。
     */
    public boolean fertilize(World par1World, int par2, int par3, int par4)
    {
        return (par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2));
    }

    /*
     * 周囲のブロックから、成長しやすさを判定しているところ。
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float f = 1.0F;
        int l = par1World.getBlockId(par2, par3, par4 - 1);
        int i1 = par1World.getBlockId(par2, par3, par4 + 1);
        int j1 = par1World.getBlockId(par2 - 1, par3, par4);
        int k1 = par1World.getBlockId(par2 + 1, par3, par4);
        int l1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int i2 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int j2 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int k2 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        
        boolean flag = j1 == this.blockID || k1 == this.blockID;
        boolean flag1 = l == this.blockID || i1 == this.blockID;
        boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

        for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2)
        {
            for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3)
            {
                int j3 = par1World.getBlockId(l2, par3 - 1, i3);
                float f1 = 0.0F;

                if (blocksList[j3] != null && blocksList[j3].canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this))
                {
                    f1 = 1.0F;
                }

                if (l2 != par2 || i3 != par4)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        /*
         * バニラだと下記条件（隣接して同じ作物を植えている）では成長速度が下がっている。
         * ミントの場合は逆になる。
         * */
        if (flag2 || flag && flag1)
        {
            f *= 2.0F;
        }

        return f;
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
    	int j = MathHelper.clamp_int(par1, 0, 3);
        return this.iconArray[par2];
    }

    /*
     * ブロックのレンダータイプ。6はバニラの小麦のように、井型に表示される。
     */
    public int getRenderType()
    {
        return 6;
    }

    /*
     * 対応するタネアイテムのID。
     */
    protected int getSeedItem()
    {
        return DCsAppleMilk.itemMintSeed.itemID;
    }

    /*
     * 得られる作物アイテムのID。
     */
    protected int getCropItem()
    {
        return DCsAppleMilk.leafTea.itemID;
    }

    /*
     * 複数の種類のアイテムをドロップさせる場合のメソッド。
     * ドロップするアイテムの種類は、getBlockDroppedで設定する。
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);
        
        if (metadata >= 3)
        {
        	ret.add(new ItemStack(this.getCropItem(), 1, 1));
            for (int n = 0; n < 1 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                	ret.add(new ItemStack(this.getCropItem(), 1, 1));
                    ret.add(new ItemStack(this.getCropItem(), 1, 1));
                }
            }
        }

        return ret;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.getSeedItem();
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public int damageDropped(int par1)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.getSeedItem();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(Util.getTexturePassNoAlt() + "crop_mint" + "_stage_" + i);
        }
    }
}
