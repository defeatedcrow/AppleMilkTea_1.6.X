/**
 * this class was fixed by RazzleberryFox.
 */

package mods.applemilk.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import mods.applemilk.common.tile.ContainerAutoMaker;
import mods.applemilk.common.tile.TileAutoMaker;
import mods.applemilk.common.tile.TileCupHandle;
import mods.applemilk.common.tile.TileHasDirection;
import mods.applemilk.common.tile.TileHasRemaining;
import mods.applemilk.common.tile.TileMakerNext;
import mods.applemilk.common.tile.TileTeppann;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
        {
            if (packet.channel.equals("DCsTeppan"))
            {
    			ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
                ItemStack item = null;
                try
                {
                     int x = bis.readInt();
                     int y = bis.readInt();
                     int z = bis.readInt();
                     short CookingTime = bis.readShort();
                     short ReadyTime = bis.readShort();
                     boolean FinishedCooking = bis.readBoolean();
                     boolean TooLate = bis.readBoolean();
                     boolean hasStacks = bis.readByte() != 0;
                     if (hasStacks)
                     {
                         item = Packet.readItemStack(bis);
                     }
                }
                catch (IOException e)
                {
                 
                }
            }
            else if (packet.channel.equals("DCsDirection"))
            {
    			ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				byte Direction = bis.readByte();
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileHasDirection)
    				{
    					TileHasDirection tile = (TileHasDirection)tileEntity;
    					tile.setDirectionByte(Direction);
    				}
    			}
    			catch (Exception e)
    			{
    				
    			}	
            }
            else if (packet.channel.equals("DCsRemaining"))
            {
    			ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				byte Remaining = bis.readByte();
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileHasRemaining)
    				{
    					TileHasRemaining tile = (TileHasRemaining)tileEntity;
    					tile.setRemainByte(Remaining);
    				}
    			}
    			catch (Exception e)
    			{
    				
    			}	
            }
            else if (packet.channel.equals("DCsTeaMaker"))
            {
            	ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				byte Remaining = bis.readByte();
    				byte ContentsID = bis.readByte();
    				boolean Milk = bis.readBoolean();
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileMakerNext)
    				{
    					TileMakerNext tile = (TileMakerNext)tileEntity;
    					tile.setRemainByte(Remaining);
    					tile.setID(ContentsID);
    					tile.setMilk(Milk);
    				}
    				
    				
    			}
    			catch (Exception e)
    			{
    				
    			}
            }
            else if (packet.channel.equals("DCsAutoMaker"))
            {
            	ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
            	ItemStack item = null;
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				byte Mode = bis.readByte();
    				short CoolTime = bis.readShort();
    				boolean hasStacks = bis.readByte() != 0;
                    if (hasStacks)
                    {
                        item = Packet.readItemStack(bis);
                    }
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileAutoMaker)
    				{
    					TileAutoMaker tile = (TileAutoMaker)tileEntity;
    					tile.setCoolTime(CoolTime);
    					tile.setMode(Mode);
    					tile.setItemstack(item);
    				}
    			}
    			catch (Exception e)
    			{
    				
    			}
            }
            else if (packet.channel.equals("DCsAutoMode"))
            {
            	ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
            	
    			try
    			{
    				Container container = ((EntityPlayerMP)player).openContainer;
    				if(container != null && container instanceof ContainerAutoMaker)
    				{
    					((ContainerAutoMaker)container).readPacketData(bis);
    				}
    			}
    			catch (Exception e)
    			{
    				
    			}
            }
        }

        public static Packet getPacket(TileTeppann tileTeppann)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tileTeppann.xCoord;
                int y = tileTeppann.yCoord;
                int z = tileTeppann.zCoord;
                short cooking = (short) tileTeppann.setCookingTime();
                short ready = (short) tileTeppann.setReadyTime();
                boolean FinishedCooking = tileTeppann.isCookingFinished();
                boolean TooLate = tileTeppann.isTooLate();
                ItemStack item = tileTeppann.setItemstack();
                boolean hasStacks = (item != null);

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeShort(cooking);
                        dos.writeShort(ready);
                        dos.writeBoolean(FinishedCooking);
                        dos.writeBoolean(TooLate);
                        dos.writeByte(hasStacks? 1 : 0);
                        if (hasStacks)
                        {
                        	Packet.writeItemStack(item, dos);
                        }
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsTeppan";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
        public static Packet getDirectionPacket(TileHasDirection tileHasDirection)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tileHasDirection.xCoord;
                int y = tileHasDirection.yCoord;
                int z = tileHasDirection.zCoord;
                byte Direction = tileHasDirection.getDirectionByte();

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeByte(Direction);
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsDirection";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
        public static Packet getRemainingPacket(TileHasRemaining tile)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tile.xCoord;
                int y = tile.yCoord;
                int z = tile.zCoord;
                byte Remaining = tile.getRemainByte();

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeByte(Remaining);
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsRemaining";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
        public static Packet getMakerPacket(TileMakerNext tile)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tile.xCoord;
                int y = tile.yCoord;
                int z = tile.zCoord;
                byte Remaining = tile.getRemainByte();
                byte ContentsID = tile.getID();
                boolean Milk = tile.getMilked();

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeByte(Remaining);
                        dos.writeByte(ContentsID);
                        dos.writeBoolean(Milk);
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsTeaMaker";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
        public static Packet getAutoPacket(TileAutoMaker tile)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tile.xCoord;
                int y = tile.yCoord;
                int z = tile.zCoord;
                short CoolTime = (short) tile.getCoolTime();
                byte Mode = (byte) tile.getMode();
                ItemStack item = tile.getItemstack();
                boolean hasStacks = (item != null);

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeShort(CoolTime);
                        dos.writeByte(Mode);
                        dos.writeByte(hasStacks? 1 : 0);
                        if (hasStacks)
                        {
                        	Packet.writeItemStack(item, dos);
                        }
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsAutoMaker";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
    	public static Packet getModePacket(ContainerAutoMaker container)
    	{
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bos);

            byte Mode = (byte) container.getMode();

            try
            {
                    dos.writeByte(Mode);
            }
            catch(Exception e)
            {
                    e.printStackTrace();
            }

    		Packet250CustomPayload packet = new Packet250CustomPayload();
    		packet.channel = "DCsAutoMode";
    		packet.data = bos.toByteArray();
    		packet.length = bos.size();
    		packet.isChunkDataPacket = true;

    		return packet;
    	}
        
}
