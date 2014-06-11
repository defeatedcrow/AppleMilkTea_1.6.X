package mods.applemilk.common.tile;

import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.DCsConfig;
import mods.applemilk.common.PacketHandler;
import mods.applemilk.handler.Util;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;

public class TileTeppann extends TileEntity
{
    private ItemStack cookingItem;
    private int cookingTime = 0;
    private boolean finishedCooking = false;
    private int readyTime = 0;
    private boolean tooLate = false;

    //NBT
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.hasKey("CookingItem"))
        {
            this.getItemstack(ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("CookingItem")));
        }
        
        this.cookingTime = par1NBTTagCompound.getShort("CookingTime");
        
        this.finishedCooking = par1NBTTagCompound.getBoolean("FinishedCooking");
        
        this.readyTime = par1NBTTagCompound.getShort("ReadyTime");
        
        this.tooLate = par1NBTTagCompound.getBoolean("TooLate");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("CookingTime", (short)this.cookingTime);
        par1NBTTagCompound.setBoolean("FinishedCooking", this.finishedCooking);
        par1NBTTagCompound.setShort("ReadyTime", (short)this.readyTime);
        par1NBTTagCompound.setBoolean("TooLate", this.tooLate);

        if (this.setItemstack() != null)
        {
            par1NBTTagCompound.setCompoundTag("CookingItem", this.setItemstack().writeToNBT(new NBTTagCompound()));
        }
    }
    
    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.getPacket(this);
    }

    public ItemStack setItemstack()
    {
        return this.cookingItem;
    }
    
    public int setCookingTime()
    {
    	return this.cookingTime;
    }
    
    public int setReadyTime()
    {
    	return this.readyTime;
    }
    
    public boolean isCooking()
    {
    	return this.cookingTime > 0;
    }
    
    public boolean isCookingFinished()
    {
    	return this.finishedCooking;
    }
    
    public boolean isTooLate()
    {
    	return this.tooLate;
    }

    public void getItemstack(ItemStack par1ItemStack)
    {
        this.cookingItem = par1ItemStack;
        this.onInventoryChanged();
    }
    
    public void getCookingTime(int par1)
    {
    	this.cookingTime = par1;
    }
    
    public void getReadyTime(int par1)
    {
    	this.readyTime = par1;
    }
    
    //update tileentity
    public void updateEntity()
    {
    	if (this.cookingTime > 0)
    	{
    		--this.cookingTime;
    		
    		if (this.cookingTime == 0)
    		{
    			this.finishedCooking = true;
    			this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, "random.fizz", 1.0F, 1.0F);
    			this.onInventoryChanged();
    			this.updateTeppannMeta();
    			this.readyTime = Util.getTeppannReadyTime();
    		}
    		else if (this.cookingItem == null)
    		{
    			this.cookingTime = 0;
    			this.onInventoryChanged();
    			this.updateTeppannMeta();
    		}
    	}
    	else if (this.cookingItem != null && !this.finishedCooking)
    	{
    		this.cookingTime = this.getCookingTime();
    		this.readyTime = 0;
    		this.tooLate = false;
    		this.onInventoryChanged();
    		this.updateTeppannMeta();
    	}
    	else if (this.cookingItem == null && this.finishedCooking)
    	{
    		this.finishedCooking = false;
    		this.updateTeppannMeta();
    	}
    	
    	if (this.readyTime > 0)
    	{
    		--this.readyTime;
    		
    		if (this.readyTime == 0)
    		{
    			if (this.cookingItem != null || this.finishedCooking)
    			{
    				if (DCsConfig.teppannHardMode)
    				{
    					this.tooLate = true;
    					this.worldObj.playSoundEffect(xCoord, yCoord, zCoord, "random.fizz", 1.0F, 1.0F);
    					this.updateTeppannMeta();
    					this.onInventoryChanged();
    				}
    				else
    				{
    					this.tooLate = false;
    				}
    			}
    			else
    			{
    				this.tooLate = false;
    			}
    		}
    		else if (this.cookingItem == null || !this.finishedCooking)
    		{
    			this.tooLate = false;
    			this.readyTime = 0;
    			this.updateTeppannMeta();
    			this.onInventoryChanged();
    		}
    	}
    	
    }
    
    private int getCookingTime()
    {
    	int l = 1;
    	
    	if (DCsConfig.teppannRandomCookTime) l += this.worldObj.rand.nextInt(100);
    	else l = 100;
    	
    	return l;
    }
    
    private int getMetadata()
    {
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
    
    private void updateTeppanFoods()
    {
    	int meta = this.getMetadata();
    	int ItemCount = this.cookingItem.stackSize;
    	
    	if (meta == 2) this.cookingItem = (new ItemStack(DCsAppleMilk.foodPlate.blockID, ItemCount, 0));
    	else if (meta == 4) this.cookingItem = (new ItemStack(DCsAppleMilk.foodPlate.blockID, ItemCount, 1));
    	else if (meta == 6) this.cookingItem = (new ItemStack(DCsAppleMilk.foodPlate.blockID, ItemCount, 2));
    	else if (meta == 8) this.cookingItem = (new ItemStack(DCsAppleMilk.foodPlate.blockID, ItemCount, 3));
    }
    
    public void updateTeppannMeta()
    {
    	int meta = 0;
    	
    	if (this.cookingItem != null)
    	{
    		if (!this.isTooLate())
    		{
    			if (this.cookingItem.itemID == Item.beefRaw.itemID)
        		{
        			meta = this.finishedCooking ?  2 : 1;
        		}
        		else if (this.cookingItem.itemID == Item.porkRaw.itemID)
        		{
        			meta = this.finishedCooking ?  4 : 3;
        		}
        		else if (this.cookingItem.itemID == Item.chickenRaw.itemID)
        		{
        			meta = this.finishedCooking ?  6 : 5;
        		}
        		else if (this.cookingItem.itemID == DCsAppleMilk.clam.itemID)
        		{
        			meta = this.finishedCooking ?  8 : 7;
        		}
    		}
    		else
    		{
    			meta = 9;
    		}
    		
    	}
    	
    	
    	this.worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, meta, 3);
    }
}
