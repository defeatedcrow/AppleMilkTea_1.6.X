package mods.applemilk.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.tile.TileLargeBottle;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class ItemLargeBottle extends Item{
	
	private static final String[] contents = new String[] {"empty", "sake", "beer", "wine", "gin", "rum", "vodka", "whiskey",
		"milk", "soy", "sugar", "maple", "honey", "nuts", "berryjam", "berryjam"};
	
	private boolean repair;
	private static final int thisBlockID = DCsAppleMilk.largeBottle.blockID;
	
	@SideOnly(Side.CLIENT)
    private Icon[] thisTex;
	
	public ItemLargeBottle(int itemId)
	{
		super(itemId);
		this.setMaxStackSize(8);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setNoRepair();
	}
	
	//ItemBlockのように振る舞う。設置するのはブロック版の酒瓶、TileEntityに渡すのは残量のみに変更。種類はメタデータに渡される。
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);

        if (i1 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
        {
            par7 = 1;
        }
        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID
                && (Block.blocksList[i1] == null || !Block.blocksList[i1].isBlockReplaceable(par3World, par4, par5, par6)))
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }
        }

        if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else if (par5 == 255)
        {
            return false;
        }
        else if (par3World.canPlaceEntityOnSide(thisBlockID, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack))
        {
            Block block = Block.blocksList[thisBlockID];
            int j1 = this.getMetadata(par1ItemStack.getItemDamage());//ダメージは16以上なので、ブロックのメタデータに入れてはいけない
            int type = this.checkType(j1);//種類
            int k1 = Block.blocksList[thisBlockID].onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, type);
            //onBlockPlacedで改めて返ってくるメタデータ値
            
            if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, k1))
            {
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                --par1ItemStack.stackSize;
            }
            
            TileLargeBottle tile = (TileLargeBottle) par3World.getBlockTileEntity(par4, par5, par6);
            if (tile != null) {
            	int j2 = j1 >> 4;
                j2 = j2 & 7;
            	tile.setRemainShort((short)j2);//ダメージ値から残量だけ取り出してTileに渡す
            }//Block側のonBlockPlacedByでも同じことをやっているため、処理が重複している
            
            return true;
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given ItemBlock can be placed on the given side of the given block position.
     */
    public boolean canPlaceItemBlockOnSide(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer, ItemStack par7ItemStack)
    {
        int i1 = par1World.getBlockId(par2, par3, par4);

        if (i1 == Block.snow.blockID)
        {
            par5 = 1;
        }
        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID
                && (Block.blocksList[i1] == null || !Block.blocksList[i1].isBlockReplaceable(par1World, par2, par3, par4)))
        {
            if (par5 == 0)
            {
                --par3;
            }

            if (par5 == 1)
            {
                ++par3;
            }

            if (par5 == 2)
            {
                --par4;
            }

            if (par5 == 3)
            {
                ++par4;
            }

            if (par5 == 4)
            {
                --par2;
            }

            if (par5 == 5)
            {
                ++par2;
            }
        }

        return par1World.canPlaceEntityOnSide(thisBlockID, par2, par3, par4, false, par5, (Entity)null, par7ItemStack);
    }
    
    //このメソッドでのmetadataは呼び出し元で &15を掛けてある
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	if (!world.setBlock(x, y, z, thisBlockID, metadata, 3))
       {
           return false;
       }

       if (world.getBlockId(x, y, z) == thisBlockID)
       {
           Block.blocksList[thisBlockID].onBlockPlacedBy(world, x, y, z, player, stack);
           Block.blocksList[thisBlockID].onPostBlockPlaced(world, x, y, z, metadata);
       }

       return true;
    }
    
    //牛から牛乳を汲む
    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
        if (itemstack != null && itemstack.getItemDamage() == 0 && entity instanceof EntityCow)
        {
            EntityCow target = (EntityCow)entity;
            if (!target.isChild())
            {
            	player.worldObj.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
            	if (!player.capabilities.isCreativeMode)
                {
                    --itemstack.stackSize;
                }
        		if (!player.inventory.addItemStackToInventory(new ItemStack(this,1,120)))
            	{
            		player.entityDropItem(new ItemStack(this,1,120), 1);
            	}
            }
            return true;
        }
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    //マウスオーバー時の表示情報
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		int type = checkType(l);
		int rem = checkRemain(l);
		if (l < 0) l = 0;
		if (l > 0) rem++;
		par3List.add(new String("type: " + contents[type]));
		if (l != 0) par3List.add(new String("count: " + rem));
	}
	
	private int checkType(int par1)
	{
		int m = par1 & 15;//やってることはブロッククラスのものと同じ
		return m;
	}
	
	private int checkRemain(int par1)
	{
		int m = par1 >> 4;//右にシフト。16から1へ。
        m = (m & 7);//16、32、64の桁をチェック
		return m;
	}
	
	//以下はサブタイプやアイコン登録など
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = (par1 & 15);
        return this.thisTex[j];
    }

	@Override
	public int getMetadata(int par1) {
		return par1;//ここではダメージ値通りのものを返す
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		for (int i = 1 ; i < 8 ; i++) {
			par3List.add(new ItemStack(this, 1, 48 + i));
		}
		for (int i = 8 ; i < 15 ; i++) {
			par3List.add(new ItemStack(this, 1, 112 + i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	
		this.thisTex = new Icon[15];

        for (int i = 0; i < 15; ++i)
        {
            this.thisTex[i] = par1IconRegister.registerIcon("applemilk:bottle_" + contents[i]);
        }
	}

}
