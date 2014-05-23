package mods.applemilk.common.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.applemilk.common.AchievementRegister;
import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWallMug extends Item{
	
	private static final String[] contents = new String[] {"_tea", "_green", "_cocoa", "_coffee"};
	private static final String[] contentsFruit = new String[] {"_foam", "_foam", "_nuts", "_berry"};
	
	private static final String[] drinkType = new String[] {"Tea", "Green Tea", "Cocoa", "Coffee"};
	private static final String[] milkType = new String[] {"None", "Milk", "Condenced Milk", "Soy"};
	private static final String[] sugarType = new String[] {"None", "Sugar", "Maple", "Honey"};
	private static final String[] fruitType = new String[] {"None", "Foam", "Nuts", "Berry"};
	private static final String[] potionType = new String[] {"Regeneration", "Dig Speed", "Resistance", "Damage Boost"};
	private static final String[] timeType = new String[] {"(60sec)", "(2min)", "(4min)", "(5min)"};
	
	@SideOnly(Side.CLIENT)
    private Icon[] thisTex;
	@SideOnly(Side.CLIENT)
    private Icon[] topTex;
	
	public ItemWallMug(int itemId)
	{
		super(itemId);
		this.setMaxStackSize(8);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	//ブロックとして設置する機能は未実装。
//	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
//    {
//        int i1 = par3World.getBlockId(par4, par5, par6);
//
//        if (i1 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
//        {
//            par7 = 1;
//        }
//        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID
//                && (Block.blocksList[i1] == null || !Block.blocksList[i1].isBlockReplaceable(par3World, par4, par5, par6)))
//        {
//            if (par7 == 0)
//            {
//                --par5;
//            }
//
//            if (par7 == 1)
//            {
//                ++par5;
//            }
//
//            if (par7 == 2)
//            {
//                --par6;
//            }
//
//            if (par7 == 3)
//            {
//                ++par6;
//            }
//
//            if (par7 == 4)
//            {
//                --par4;
//            }
//
//            if (par7 == 5)
//            {
//                ++par4;
//            }
//        }
//
//        if (par1ItemStack.stackSize == 0)
//        {
//            return false;
//        }
//        else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
//        {
//            return false;
//        }
//        else if (par5 == 255)
//        {
//            return false;
//        }
//        else if (par3World.canPlaceEntityOnSide(thisBlockID, par4, par5, par6, false, par7, par2EntityPlayer, par1ItemStack))
//        {
//            Block block = Block.blocksList[thisBlockID];
//            int j1 = this.getMetadata(par1ItemStack.getItemDamage());//ダメージは16以上なので、ブロックのメタデータに入れてはいけない
//            int type = this.checkType(j1);//種類
//            int k1 = Block.blocksList[thisBlockID].onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, type);
//            //onBlockPlacedで改めて返ってくるメタデータ値
//            
//            if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10, k1))
//            {
//                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
//                --par1ItemStack.stackSize;
//            }
//            
//            TileLargeBottle tile = (TileLargeBottle) par3World.getBlockTileEntity(par4, par5, par6);
//            if (tile != null) {
//            	tile.setRemainShort((short)j1);//ダメージ値をTileに渡す
//            }//Block側のonBlockPlacedByでも同じことをやっているため、処理が重複している
//            
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//
//    /**
//     * Returns true if the given ItemBlock can be placed on the given side of the given block position.
//     */
//    public boolean canPlaceItemBlockOnSide(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer, ItemStack par7ItemStack)
//    {
//        int i1 = par1World.getBlockId(par2, par3, par4);
//
//        if (i1 == Block.snow.blockID)
//        {
//            par5 = 1;
//        }
//        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID
//                && (Block.blocksList[i1] == null || !Block.blocksList[i1].isBlockReplaceable(par1World, par2, par3, par4)))
//        {
//            if (par5 == 0)
//            {
//                --par3;
//            }
//
//            if (par5 == 1)
//            {
//                ++par3;
//            }
//
//            if (par5 == 2)
//            {
//                --par4;
//            }
//
//            if (par5 == 3)
//            {
//                ++par4;
//            }
//
//            if (par5 == 4)
//            {
//                --par2;
//            }
//
//            if (par5 == 5)
//            {
//                ++par2;
//            }
//        }
//
//        return par1World.canPlaceEntityOnSide(thisBlockID, par2, par3, par4, false, par5, (Entity)null, par7ItemStack);
//    }
//    
//    //このメソッドでのmetadataは呼び出し元で &15を掛けてある
//    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
//    {
//    	if (!world.setBlock(x, y, z, thisBlockID, metadata, 3))
//       {
//           return false;
//       }
//
//       if (world.getBlockId(x, y, z) == thisBlockID)
//       {
//           Block.blocksList[thisBlockID].onBlockPlacedBy(world, x, y, z, player, stack);
//           Block.blocksList[thisBlockID].onPostBlockPlaced(world, x, y, z, metadata);
//       }
//
//       return true;
//    }
	
	//飲食時の処理
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
		if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(DCsAppleMilk.EXItems,1,10)))
    	{
    		par3EntityPlayer.entityDropItem(new ItemStack(DCsAppleMilk.EXItems,1,10), 1);
    	}
		
		int meta = par1ItemStack.getItemDamage();
		int type = checkType(meta);
		int milk = checkMilkType(meta);
		int sugar = checkSugarType(meta);
		int fruit = checkFruitType(meta);
		int[] time = {600, 1800, 3000, 5400};
		int m = 600 + time[milk];
		
		if (!par2World.isRemote)
		{
    		if (type == 0)//Tea
    		{
    			if (par3EntityPlayer.isPotionActive(Potion.regeneration.id)) {
    				int d = par3EntityPlayer.getActivePotionEffect(Potion.regeneration).getDuration();
    				
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, (d + m), sugar));
    			}
    			else {
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, m, sugar));
    			}
    		}
    		else if (type == 1)//Green Tea
    		{
    			if (par3EntityPlayer.isPotionActive(Potion.digSpeed.id)) {
    				int d = par3EntityPlayer.getActivePotionEffect(Potion.digSpeed).getDuration();
    				
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, (d + m), sugar));
    			}
    			else {
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, m, sugar));
    			}
    		}
    		else if (type == 2)//Cocoa
    		{
    			if (par3EntityPlayer.isPotionActive(Potion.resistance.id)) {
    				int d = par3EntityPlayer.getActivePotionEffect(Potion.resistance).getDuration();
    				
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, (d + m), sugar));
    			}
    			else {
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, m, sugar));
    			}
    		}
    		else if (type == 3)//Coffee
    		{
    			if (par3EntityPlayer.isPotionActive(Potion.damageBoost.id)) {
    				int d = par3EntityPlayer.getActivePotionEffect(Potion.damageBoost).getDuration();
    				
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, (d + m), sugar));
    			}
    			else {
    				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, m, sugar));
    			}
    		}
		}
		
		return par1ItemStack;
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	return EnumAction.drink;
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
	
	@SideOnly(Side.CLIENT)
    //マウスオーバー時の表示情報
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		String data = new String("customize: ");
		int type = checkType(l);
		if (l < 0) l = 0;
		
		int milk = checkMilkType(l);
		if (milk > 0) data = data + milkType[milk] + ", ";
		
		int sugar = checkSugarType(l);
		if (sugar > 0) data = data + sugarType[sugar] + ", ";
		
		int fruit = checkFruitType(l);
		if (fruit > 0) data = data + fruitType[fruit];
		
		if (l < 4) data = data + "Black";
		par3List.add(new String("type: " + drinkType[type]));
		par3List.add(data);
		String[] num = new String[] {"I", "II", "III", "IV"};
		par3List.add(new String(potionType[type] + " " +num[sugar] + " " + timeType[milk]));
	}
	
	private int checkType(int par1)
	{
		int m = par1 & 3;//中身の種類
		return m;
	}
	
	private int checkMilkType(int par1)//効果時間延長＆上書き化
	{
		int m = par1 >> 2;//右にシフト。4から1へ。
        m = (m & 3);//4、8の桁をチェック。無、牛乳、練乳、豆乳の順。
		return m;
	}
	
	private int checkSugarType(int par1)//効果レベル上昇
	{
		int m = par1 >> 4;//右にシフト。16から1へ。
        m = (m & 3);//16、32の桁をチェック。無、砂糖、メイプル、ハチミツ
		return m;
	}
	
	private int checkFruitType(int par1)
	{
		int m = par1 >> 6;//右にシフト。64から1へ。
        m = (m & 3);//64、128の桁をチェック。無、ミルクフォームのみ、ナッツ、ベリージャム
		return m;
	}
	
	//以下はサブタイプやアイコン登録など
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = par1 & 7;
        return this.thisTex[j];
    }
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamageForRenderPass(int par1, int par2)
	{
		 int type = this.checkFruitType(par1);
		 
		 return par2 == 0 ? this.topTex[type] : super.getIconFromDamageForRenderPass(par1, par2);
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int pass)
    {
    	int m = stack.getMaxDamage();
    	int type = m & 7;
    	int fruit = this.checkFruitType(m);
    	if (pass == 0) {
    		return this.topTex[fruit];
    	}
    	else {
    		return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
    	}
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
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
		par3List.add(new ItemStack(this, 1, 3));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	
		this.thisTex = new Icon[8];
		this.topTex = new Icon[4];

        for (int i = 0; i < 4; ++i)
        {
            this.thisTex[i] = par1IconRegister.registerIcon("applemilk:wallmug" + contents[i]);
            this.thisTex[i + 4] = par1IconRegister.registerIcon("applemilk:wallmug" + contents[i] + "_milk");
        }
        
        for (int i = 0; i < 4; ++i)
        {
            this.topTex[i] = par1IconRegister.registerIcon("applemilk:wallmug" + contents[i]);
        }
	}

}
