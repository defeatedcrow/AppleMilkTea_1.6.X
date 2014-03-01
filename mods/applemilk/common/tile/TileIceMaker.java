package mods.applemilk.common.tile;

import java.io.DataOutputStream;
import java.io.IOException;
 
import mods.applemilk.api.IceRecipe;
import mods.applemilk.common.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
 

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.google.common.io.ByteArrayDataInput;
 






import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileIceMaker extends TileEntity
{
 
	//現在のチャージ量
	public int chargeAmount;
	//燃料アイテムのチャージ量
	public int currentItemCharge;
	//調理時間はかまどと同じ
	public int cookTime;
	//チャージアイテムを溶かす際の判定発生間隔
	//温暖バイオームでのチャージ減少判定にも使用
	private int coolTime = 8;
 
	public InventoryIceMaker inventory;
 
	public TileIceMaker() {
		this.inventory = new InventoryIceMaker(this);
	}
 
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
 
		//アイテムの読み込み
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.inventory.iceItemStacks = new ItemStack[this.inventory.getSizeInventory()];
 
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
 
			if (b0 >= 0 && b0 < this.inventory.iceItemStacks.length)
			{
				this.inventory.iceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
 
		this.chargeAmount = par1NBTTagCompound.getByte("ChargeAmount");
		this.cookTime = par1NBTTagCompound.getShort("CookTime");
		this.coolTime = par1NBTTagCompound.getByte("CoolTime");
 
	}
 
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
 
		//燃焼時間や調理時間などの書き込み
		par1NBTTagCompound.setByte("ChargeAmount", (byte)this.chargeAmount);
		par1NBTTagCompound.setShort("CookTime", (short)this.cookTime);
		par1NBTTagCompound.setByte("CoolTime", (byte)this.coolTime);
 
		//アイテムの書き込み
		NBTTagList nbttaglist = new NBTTagList();
 
		for (int i = 0; i < this.inventory.iceItemStacks.length; ++i)
		{
			if (this.inventory.iceItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.inventory.iceItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
 
		par1NBTTagCompound.setTag("Items", nbttaglist);
 
	}
 
	public void readToPacket(ByteArrayDataInput data) {
		//アイテムの読み込み
		for (int i = 0; i < this.inventory.getSizeInventory(); i++) {
			int id = data.readInt();
			int stacksize = data.readByte();
			int metadata = data.readInt();
 
			if (id != 0 && stacksize != 0) {
				this.inventory.setInventorySlotContents(i, new ItemStack(id, stacksize, metadata));
			} else {
				this.inventory.setInventorySlotContents(i, null);
			}
		}
	}
 
	public void writeToPacket(DataOutputStream dos) {
		try {
			//アイテムの書き込み
			for (int i = 0; i < this.inventory.getSizeInventory(); i++) {
				int id = this.inventory.iceItemStacks[i] != null ? this.inventory.iceItemStacks[i].itemID : 0;
				int stacksize = this.inventory.iceItemStacks[i] != null ? this.inventory.iceItemStacks[i].stackSize : 0;
				int metadata = this.inventory.iceItemStacks[i] != null ? this.inventory.iceItemStacks[i].getItemDamage() : 0;
 
				dos.writeInt(id);
				dos.writeByte(stacksize);
				dos.writeInt(metadata);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public Packet getDescriptionPacket()
	{
		//パケットの取得
		return PacketHandler.getIcePacket(this);
	}
 
	//調理中の矢印の描画
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return this.cookTime * par1 / 150;
	}
 
	//チャージゲージの描画
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1)
	{
		return this.chargeAmount * par1 / 127;
	}
 
	//調理中
	public boolean isBurning()
	{
		return this.cookTime > 0;
	}
	
	//調理中
	public boolean isCharged()
	{
		return this.chargeAmount > 0;
	}
	
	//以下はパケット送受信用メソッド
	public void setChargeAmount(int par1)
	{
		this.chargeAmount = par1;
	}
	
	public int getChargeAmount()
	{
		return this.chargeAmount;
	}
 
	/**
	 * Tick毎のアイスメーカーの処理。ほぼバニラかまどのパクリ。
	 */
	public void updateEntity()
	{
		boolean flag = this.isCharged();
		boolean flag1 = false;
 
		//まず燃料を溶かす処理
		
		//硬直時間：燃料の消費及び温暖バイオームでのチャージ減少に利用
		if (this.coolTime > 0)
		{
			--this.coolTime;
		}
 
		if (!this.worldObj.isRemote)
		{
			if (this.coolTime == 0)
			{
				//チャージが満タンではないか？
				if (this.chargeAmount < 127 && this.isItemFuel(this.inventory.iceItemStacks[1]))
				{
					//チャージ残量＋アイテムのチャージ量
					int i = this.chargeAmount += getItemBurnTime(this.inventory.iceItemStacks[1]);
	 
					if (i < 128)//128未満ならOK
					{
						this.chargeAmount = i;
						flag1 = true;
	 
						//スロット1のアイテムを減らす
						if (this.inventory.iceItemStacks[1] != null)
						{
							--this.inventory.iceItemStacks[1].stackSize;
	 
							if (this.inventory.iceItemStacks[1].stackSize == 0)
							{
								this.inventory.iceItemStacks[1] = this.inventory.iceItemStacks[1].getItem().getContainerItemStack(this.inventory.iceItemStacks[1]);
							}
						}
					}
				}
	 
				//暑いバイオームではチャージを1減らす
				if (this.isHotBiome() == 2 && this.isCharged())
				{
					--this.chargeAmount;
					if (!this.isCharged()) flag1 = false;
				}
				
				//最後に硬直時間を8tickに設定
				this.coolTime = 8;
			}
			
			//調理の待ち時間を設定（バニラかまどよりは早い）
			if (this.isCharged() && this.canSmelt())
			{
				++this.cookTime;

				if (this.cookTime == 150)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}

			if (flag != this.isCharged())
			{
				flag1 = true;
			}
	 
			if (flag1)
			{
				this.onInventoryChanged();
			}
		}
	}
 
	/**
	 * アイテムがIceMakerにレシピ登録された材料かどうか
	 * レシピ登録はTeaMakerと類似の登録制を使用
	 */
	private boolean canSmelt()
	{
		if (this.inventory.iceItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = IceRecipe.getOutput(IceRecipe.getID(this.inventory.iceItemStacks[0]));
			if (itemstack == null) return false;
			if (this.inventory.iceItemStacks[2] == null) return true;
			if (!this.inventory.iceItemStacks[2].isItemEqual(itemstack)) return false;
			int result = this.inventory.iceItemStacks[2].stackSize + itemstack.stackSize;
			return (result <= this.inventory.getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
 
	/**
	 * 実際に材料を消費して、完成スロットにアウトプットを返すためのメソッド
	 */
	public void smeltItem()
	{
		if (this.canSmelt())
		{
			int id = IceRecipe.getID(this.inventory.iceItemStacks[0]);
			ItemStack itemstack = IceRecipe.getOutput(id);
			ItemStack leave = IceRecipe.getLeaveStack(id);
 
			if (this.inventory.iceItemStacks[2] == null)
			{
				this.inventory.iceItemStacks[2] = itemstack.copy();
			}
			else if (this.inventory.iceItemStacks[2].isItemEqual(itemstack))
			{
				this.inventory.iceItemStacks[2].stackSize += itemstack.stackSize;
			}
 
			if (IceRecipe.canLeave(id) && leave != null)
			{
				this.inventory.iceItemStacks[0] = leave.copy();
			}
			else
			{
				--this.inventory.iceItemStacks[0].stackSize;
				 
				if (this.inventory.iceItemStacks[0].stackSize <= 0)
				{
					this.inventory.iceItemStacks[0] = null;
				}
			}
			
			//チャージを消費
			if (this.isHotBiome() == 0)
			{
				--this.chargeAmount;
			}
			else
			{
				this.chargeAmount -= this.isHotBiome()*2;
			}
			if (this.chargeAmount < 0) this.chargeAmount = 0;
		}
	}
	
	/**
	 * 現在のチャージ残量が、稼働に必要な分だけあるか。バイオームごとに異なるため専用メソッドで判定。
	 */
	public boolean enoughCharge()
	{
		int biome = this.isHotBiome();
		if (biome == 0)
		{
			return this.isCharged();
		}
		else if (biome == 2)
		{
			return (this.chargeAmount > 3);
		}
		else
		{
			return (this.chargeAmount > 1);
		}
	}
 
	/**
	 * このアイテムのチャージ量
	 * @param par0ItemStack チェック対象アイテム
	 */
	public static int getItemBurnTime(ItemStack par0ItemStack)
	{
		if (par0ItemStack == null)
		{
			return 0;
		}
		else
		{
			int i = par0ItemStack.getItem().itemID;
			Item item = par0ItemStack.getItem();
 
			if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
			{
				Block block = Block.blocksList[i];
 
				if (block.blockMaterial == Material.craftedSnow)
				{
					return 4;
				}
 
				if (block.blockMaterial == Material.ice)
				{
					return 8;
				}
			}
			if (i == Item.snowball.itemID) return 1;
			
			if (IceRecipe.getChargeAmount(par0ItemStack) > 0)
			{
				return IceRecipe.getChargeAmount(par0ItemStack);
			}
			return 0;
		}
	}
 
	/**
	 * このアイテムがIceMakerにチャージできる冷媒であるかどうか
	 * @param par0ItemStack チェック対象アイテム
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack)
	{
		return getItemBurnTime(par0ItemStack) > 0;
	}
	
	/**
	 * 暑いバイオームかどうか
	 * 砂漠系・ジャングル系バイオームでは2、普通・温暖なバイオームでは1、寒冷バイオームでは0を返す。
	 * （BiomeDictionaryを利用しているため他MODの追加バイオームでも正常に機能するはず。）
	 * どれにも属さない（BiomeDictionaryに登録していない）場合は一律で1。
	 */
	public int isHotBiome()
	{
		int l = 1;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(xCoord, zCoord);
		
		if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DESERT)
				|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.JUNGLE)
				|| BiomeDictionary.isBiomeOfType(biome, Type.NETHER))
		{
			l = 2;
		}
		else if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FROZEN))
		{
			l = 0;
		}
		else
		{
			l = 1;
		}
		
		return l;
	}
 
}
