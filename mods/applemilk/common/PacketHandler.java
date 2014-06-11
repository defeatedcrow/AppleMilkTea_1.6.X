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

import mods.applemilk.common.tile.*;
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
            else if (packet.channel.equals("DCsIceMaker")) {
    			ByteArrayDataInput data = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = data.readInt();
        			int y = data.readInt();
        			int z = data.readInt();
        			byte amount = data.readByte();
         
        			World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileentity = world.getBlockTileEntity(x, y, z);
         
        			if (tileentity != null)
        			{
        				if (tileentity instanceof TileIceMaker)
        				{
        					((TileIceMaker) tileentity).setChargeAmount(amount);
        					((TileIceMaker) tileentity).readToPacket(data);
        				}
        			}
    			}
    			catch (Exception e)
    			{
    				
    			}
    		}
            else if (packet.channel.equals("DCsRemain2"))
            {
    			ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				short Remaining = bis.readShort();
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileHasRemaining)
    				{
    					TileHasRemain2 tile = (TileHasRemain2)tileEntity;
    					tile.setRemainShort(Remaining);
    				}
    			}
    			catch (Exception e)
    			{
    				
    			}	
            }
            else if (packet.channel.equals("DCsCordial"))
            {
    			ByteArrayDataInput bis = ByteStreams.newDataInput(packet.data);
    			
    			try
    			{
    				int x = bis.readInt();
    				int y = bis.readInt();
    				int z = bis.readInt();
    				int Aging = bis.readInt();
    				boolean IsAged = bis.readBoolean();
    				
    				World world = DCsAppleMilk.proxy.getClientWorld();
    				if (world == null)
    				{
    					world = ((EntityPlayer) player).worldObj;
    				}
    				TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
     
    				if (tileEntity instanceof TileCordial)
    				{
    					TileCordial tile = (TileCordial)tileEntity;
    					tile.setAgingTime(Aging);
    					tile.setAged(IsAged);
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
        
        public static Packet getIcePacket(TileIceMaker tileentity)
    	{
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
    		DataOutputStream dos = new DataOutputStream(bos);
     
    		int x = tileentity.xCoord;
    		int y = tileentity.yCoord;
    		int z = tileentity.zCoord;
    		byte amount = (byte)tileentity.getChargeAmount();
     
    		try
    		{
    			dos.writeInt(x);
    			dos.writeInt(y);
    			dos.writeInt(z);
    			dos.writeByte(amount);
     
    			tileentity.writeToPacket(dos);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
     
    		Packet250CustomPayload packet = new Packet250CustomPayload();
     
    		packet.channel = "DCsIceMaker";
    		packet.data = bos.toByteArray();
    		packet.length = bos.size();
    		packet.isChunkDataPacket = true;
     
    		return packet;
    	}
        
        public static Packet getRemainShortPacket(TileHasRemain2 tile)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tile.xCoord;
                int y = tile.yCoord;
                int z = tile.zCoord;
                short Remaining = tile.getRemainShort();

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeShort(Remaining);
                }
                catch(Exception e)
                {
                        e.printStackTrace();
                }

                Packet250CustomPayload packet = new Packet250CustomPayload();
                packet.channel = "DCsRemain2";
                packet.data = bos.toByteArray();
                packet.length = bos.size();
                packet.isChunkDataPacket = true;

                return packet;
        }
        
        public static Packet getCordialPacket(TileCordial tile)
        {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);

                int x = tile.xCoord;
                int y = tile.yCoord;
                int z = tile.zCoord;
                int Aging = tile.getAgingTime();
                boolean IsAged = tile.getAged();

                try
                {
                        dos.writeInt(x);
                        dos.writeInt(y);
                        dos.writeInt(z);
                        dos.writeInt(Aging);
                        dos.writeBoolean(IsAged);
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
}
