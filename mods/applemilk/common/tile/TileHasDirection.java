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

public class TileHasDirection extends TileEntity
{
    private byte direction = 0;

    //NBT
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);      
        this.direction = par1NBTTagCompound.getByte("Direction");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("Direction", this.direction);
    }
    
    @Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
 
	@Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        this.readFromNBT(pkt.data);
    }

    public byte getDirectionByte()
    {
        return this.direction;
    }
    
    public void setDirectionByte(byte par1)
    {
    	this.direction = par1;
    }
    
    public int setDirection()
    {
    	byte l = this.direction;
    	if (l == 0) return 0;//south
    	if (l == 1) return 180;//west
    	if (l == 2) return 90;//north
    	if (l == 4) return -90;//east
    	else return 0;
    }
    
    public int getMetadata()
    {
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
}
