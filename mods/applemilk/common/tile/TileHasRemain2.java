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

public class TileHasRemain2 extends TileEntity
{
    private short remain = 1;

    //NBT
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);      
        this.remain = par1NBTTagCompound.getShort("Remaining");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Remaining", this.remain);
    }
    
    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.getRemainShortPacket(this);
    }

    public short getRemainShort()
    {
        return this.remain;
    }
    
    public void setRemainShort(short par1)
    {
    	this.remain = par1;
    }
    
    
    public int getMetadata()
    {
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
}
