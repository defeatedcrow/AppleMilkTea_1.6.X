package mods.applemilk.common.tile;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.common.PacketHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileMakerNext extends TileEntity
{
    private byte remain = 1;
    private byte contentsID = 0;
    private boolean isMilk = false;

    //NBT
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);      
        this.remain = par1NBTTagCompound.getByte("Remaining");
        this.contentsID = par1NBTTagCompound.getByte("ContentsID");
        this.isMilk = par1NBTTagCompound.getBoolean("Milk");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("Remaining", this.remain);
        par1NBTTagCompound.setByte("ContentsID", this.contentsID);
        par1NBTTagCompound.setBoolean("Milk", this.isMilk);
    }
    
    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.getMakerPacket(this);
    }

    public byte getRemainByte()
    {
        return this.remain;
    }
    
    public void setRemainByte(byte par1)
    {
    	this.remain = par1;
    }
    
    public byte getID()
    {
        return this.contentsID;
    }
    
    public void setID(byte par1)
    {
    	this.contentsID = par1;
    }
    
    public boolean getMilked()
    {
    	return this.isMilk;
    }
    
    public void setMilk(boolean flag)
    {
    	this.isMilk = flag;
    }
    
    public int getMetadata()
    {
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
}
