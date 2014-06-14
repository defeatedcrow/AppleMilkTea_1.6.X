package mods.applemilk.common.tile;

import mods.applemilk.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
 
public class InventoryIceMaker implements ISidedInventory {
 
	private static final int[] slots_top = new int[] {0};
	private static final int[] slots_bottom = new int[] {2, 3, 1};
	private static final int[] slots_sides = new int[] {1};
 
	public ItemStack[] iceItemStacks = new ItemStack[4];
 
	private TileIceMaker tileentity;
 
	public InventoryIceMaker(TileIceMaker tileentity) {
		this.tileentity = tileentity;
	}
 
	// スロット数
	@Override
	public int getSizeInventory() {
		return this.iceItemStacks.length;
	}
 
	// インベントリ内の任意のスロットにあるアイテムを取得
	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.iceItemStacks[par1];
	}
 
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.iceItemStacks[par1] != null)
		{
			ItemStack itemstack;
 
			if (this.iceItemStacks[par1].stackSize <= par2)
			{
				itemstack = this.iceItemStacks[par1];
				this.iceItemStacks[par1] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.iceItemStacks[par1].splitStack(par2);
 
				if (this.iceItemStacks[par1].stackSize == 0)
				{
					this.iceItemStacks[par1] = null;
				}
 
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}
 
	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.iceItemStacks[par1] != null)
		{
			ItemStack itemstack = this.iceItemStacks[par1];
			this.iceItemStacks[par1] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}
 
	// インベントリ内のスロットにアイテムを入れる
	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		
		if (par1 > 2) par1 = 0;//存在しないスロットに入れようとすると強制的に材料スロットに変更される。
		
		this.iceItemStacks[par1] = par2ItemStack;
 
		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}
 
	// インベントリの名前
	@Override
	public String getInvName() {
		return "Ice Maker";
	}
 
	// 多言語対応かどうか
	@Override
	public boolean isInvNameLocalized() {
		return true;
	}
 
	// インベントリ内のスタック限界値
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
 
	@Override
	public void onInventoryChanged() {
		this.tileentity.onInventoryChanged();
	}
 
	// par1EntityPlayerがTileEntityを使えるかどうか
	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.tileentity.worldObj.getBlockTileEntity(this.tileentity.xCoord, this.tileentity.yCoord, this.tileentity.zCoord) != this.tileentity ? false : par1EntityPlayer.getDistanceSq((double) this.tileentity.xCoord + 0.5D, (double) this.tileentity.yCoord + 0.5D, (double) this.tileentity.zCoord + 0.5D) <= 64.0D;
	}
 
	@Override
	public void openChest() {}
 
	@Override
	public void closeChest() {}
 
	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		return par1 == 2 ? false : (par1 == 1 ? this.tileentity.isItemFuel(par2ItemStack) : true);
	}
 
	//ホッパーにアイテムの受け渡しをする際の優先度
	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}
 
	//ホッパーからアイテムを入れられるかどうか
	@Override
	public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
		return this.isItemValidForSlot(par1, par2ItemStack);
	}
 
	//隣接するホッパーにアイテムを送れるかどうか
	@Override
	public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
		return par3 != 0 || par1 != 1 || par2ItemStack.itemID == DCsAppleMilk.emptyCup.blockID;
	}
 
}
