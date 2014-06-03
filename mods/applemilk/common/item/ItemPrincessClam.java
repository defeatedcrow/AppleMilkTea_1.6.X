package mods.applemilk.common.item;

import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.ForgeDirection;
import mods.applemilk.*;
import mods.applemilk.common.AMTLogger;
import mods.applemilk.common.DCsAppleMilk;
import mods.applemilk.handler.LoadSSectorHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPrincessClam extends Item {
	
	private static final String[] clamType = new String[] {"princessclam", "raden_flower", "raden_butterfly", "raden_wing", "raden_moon"};
	
	@SideOnly(Side.CLIENT)
    private Icon iconclamType[];
	
	public ItemPrincessClam (int itemId){
		super (itemId);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
	}
	
	//ブロックに使った
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);
        int meta = par1ItemStack.getItemDamage();
        Block block = Block.sand;
        if (i1 == Block.sand.blockID && meta == 0)//ハマグリを植えるときの処理
        {
        	par3World.setBlock(par4, par5, par6, DCsAppleMilk.clamSand.blockID, 2, 3);
        	par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
            --par1ItemStack.stackSize;
        	return true;
        }
        else if (meta == 3)//風のチャーム
        {
        	if (par3World.isRemote)
            {
                return true;
            }
            else
            {
            	if (par3World.isAirBlock(par4, par5 + 1, par6) && par3World.isAirBlock(par4, par5 + 2, par6)
            			&& par3World.isBlockSolidOnSide(par4, par5, par6, ForgeDirection.UP))//2ブロックの空間がある
            	{
            		NBTTagCompound nbt = par1ItemStack.getTagCompound();
            		
            		if (nbt == null)
            		{
            			nbt = new NBTTagCompound();
            			
        				nbt.setByte("mode", (byte)2);
        				nbt.setInteger("posX", par4);
        				nbt.setInteger("posY", par5);
        				nbt.setInteger("posZ", par6);
        				
        				par1ItemStack.setTagCompound(nbt);
        				par3World.playSoundAtEntity(par2EntityPlayer, "random.pop", 0.4F, 1.8F);
        				par2EntityPlayer.addChatMessage("Registered warp pos : " + par4 + ", " + (par5 + 1) + ", " + par6);
        				return true;
            		}
            	}
            	return false;
            }
        }
        else
        {
        	return false;
        }
    }
	
	//右クリ使用時
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		int meta = itemstack.getItemDamage();
		NBTTagCompound nbt = itemstack.getTagCompound();
		
		if (!world.isRemote && entityplayer instanceof EntityPlayerMP)
		{
			EntityPlayerMP thisPlayer = (EntityPlayerMP) entityplayer;
			
			if (meta == 3 && nbt != null)//wing
			{
				byte mode = nbt.getByte("mode");
				AMTLogger.debugInfo("mode:" + mode);
				
				if (mode == 2)//posモード
				{
					int X = nbt.getInteger("posX");
					int Y = nbt.getInteger("posY");
					int Z = nbt.getInteger("posZ");
					AMTLogger.debugInfo(X + "," + Y + "," + Z);
					
					if (!thisPlayer.playerNetServerHandler.connectionClosed && thisPlayer.worldObj == world
							&& world.isBlockSolidOnSide(X, Y, Z, ForgeDirection.UP))
	                {
						AMTLogger.debugInfo("warp");
						
						thisPlayer.setPositionAndUpdate(X, Y + 1, Z);
						thisPlayer.fallDistance = 0.0F;
						world.playSoundAtEntity(thisPlayer, "applemilk:suzu", 1.0F, 1.2F);
						return itemstack;
	                }
				}
				
				if (mode == 1)//playerモード
				{
					String name = nbt.getString("targetName");
					EntityPlayer target = world.getPlayerEntityByName(name);
					
					if (target != null)
					{
						int X = (int) target.posX;
						int Y = (int) target.posY;
						int Z = (int) target.posZ;
						String DimName = target.worldObj.provider.getDimensionName();
						AMTLogger.debugInfo(DimName + " : " + X + "," + Y + "," + Z);
						
						int x1 = 0;
						int y1 = 0;
						int z1 = 0;
						boolean flag = false;
						
						for (int i = 0 ; i < 3 ; i++)
						{
							for (int k = 0 ; k < 3 ; k++)
							{
								if (world.isAirBlock(X + i - 1, Y, Z + k - 1) && world.isAirBlock(X + i - 1, Y + 1, Z + k - 1)
										&& world.isBlockSolidOnSide(X + i - 1, Y - 1, Z + k - 1, ForgeDirection.UP))
								{
									x1 = X + i - 1;
									z1 = Z + k - 1;
									y1 = Y;
									flag = true;
								}
							}
						}
						
						if (flag)
						{
							AMTLogger.debugInfo("Checking... " + DimName + " : " + x1 + "," + y1 + "," + z1);
							
							boolean connected = !thisPlayer.playerNetServerHandler.connectionClosed;
							boolean thisWorld = thisPlayer.worldObj == world;
							boolean sameDim = target.worldObj.provider.getDimensionName().equalsIgnoreCase(world.provider.getDimensionName());
							
							if (connected && thisWorld && sameDim)
			                {
								AMTLogger.debugInfo("warp");
								
								thisPlayer.setPositionAndUpdate(x1, y1, z1);
								thisPlayer.fallDistance = 0.0F;
								world.playSoundAtEntity(thisPlayer, "applemilk:suzu", 1.0F, 1.2F);
								thisPlayer.addChatMessage("Succeeded to warp near the registered player : " + target.getDisplayName());
								return itemstack;
			                }
							else if (!sameDim)
							{
								thisPlayer.addChatMessage("Fail to warp near the registered player : " + target.getDisplayName() + " is not alive in this dimention.");
							}
							else
							{
								thisPlayer.addChatMessage("Fail to get position of the registered player.");
							}
						}
						else
						{
							thisPlayer.addChatMessage("Fail to warp near the registered player : " + "Fail to get position of around " + target.getDisplayName() + ".");
						}
						
					}
					else
					{
						thisPlayer.addChatMessage("Fail to get position of the registered player.");
					}
				}
			}
			else if (meta == 4)//moon
			{
				int X = (int) thisPlayer.posX;
				int Y = (int) thisPlayer.posY;
				int Z = (int) thisPlayer.posZ;
				
				int y1 = Y;
				
				boolean flag = false;
				
				for (int i = 1 ; i < 128 ; i++)
				{
					if (Y + i < 1 || Y + i > 255)
					{
						break;
					}
					
					if (world.isBlockSolidOnSide(X, Y + i, Z, ForgeDirection.UP) && world.isAirBlock(X, Y + i + 1, Z) && world.isAirBlock(X, Y + i + 2, Z)
							&& this.moonCanWarp(world, X, Y + i, Z))
					{
						y1 = Y + i;
						flag = true;
					}
				}
				
				AMTLogger.debugInfo(X + "," + y1 + "," + Z);
				
				if (flag && y1 > Y)
				{
					if (!thisPlayer.playerNetServerHandler.connectionClosed && thisPlayer.worldObj == world)
	                {
						AMTLogger.debugInfo("warp");
						
						thisPlayer.setPositionAndUpdate(X, y1 + 1, Z);
						thisPlayer.fallDistance = 0.0F;
						world.playSoundAtEntity(thisPlayer, "applemilk:suzu", 1.0F, 1.2F);
						return itemstack;
	                }
				}
			}
		}
		
		return itemstack;
	}
	
	//月チャームのワープ可能判定
	private boolean moonCanWarp(World world, int X, int Y, int Z)
	{
		return (world.canBlockSeeTheSky(X, Y + 1, Z) && !world.provider.hasNoSky) ? true : ((Y < 128 && world.getBlockId(X, Y, Z) == Block.grass.blockID) ? true : false);
	}
	
	//プレイヤーに使った（マルチのみ）
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
		if (player.worldObj.isRemote || entity == null || itemstack.getItemDamage() != 3)
        {
            return true;
        }
        else
        {
        	NBTTagCompound nbt = itemstack.getTagCompound();
        	int meta = itemstack.getItemDamage();
        	
        	if (entity instanceof EntityPlayer && entity.isEntityAlive() && nbt == null)
        	{
        		EntityPlayer target = (EntityPlayer)entity;
        		String name = target.username;
        		
        		ItemStack targetItem = player.inventory.getCurrentItem();
        		
        		if (targetItem.itemID == this.itemID)
        		{
        			nbt = new NBTTagCompound();
    				
    				nbt.setByte("mode", (byte)1);
    				nbt.setString("targetName", name);
    				targetItem.setTagCompound(nbt);
    				
    				player.worldObj.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);
    				player.addChatMessage("Registered player name : " + name);
    				target.addChatMessage(player.getDisplayName() + " registered you to the Raden Charm");
        		}
        		
				return true;
        	}
        	
        	return false;
        }
    }
	
	@SideOnly(Side.CLIENT)
    //マウスオーバー時の表示情報
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		if (l == 1)
		{
			par3List.add(new String("Increase loot mobs drop"));
		}
		else if (l == 2)
		{
			par3List.add(new String("Increase EXP mobs drop"));
		}
		else if (l == 3)
		{
			NBTTagCompound nbt = par1ItemStack.getTagCompound();
			String s = "None";
			if (nbt != null)
			{
				byte mode = nbt.getByte("mode");
				if (mode == 1)
				{
					s = nbt.getString("targetName");
				}
				else if (mode == 2)
				{
					int X = nbt.getInteger("posX");
					int Y = nbt.getInteger("posY");
					int Z = nbt.getInteger("posZ");
					s = X + ", " + Y + ", " + Z;
				}
			}
			par3List.add(new String("Registered pos : " + s));
		}
		else if (l == 4)
		{
			par3List.add(new String("Warp on the ground"));
		}
	}
	
	//文字色
	public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItemDamage() == 0 ? EnumRarity.uncommon : EnumRarity.rare;
    }
	
	@SideOnly(Side.CLIENT)
	//エフェクト
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItemDamage() > 0;
    }
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 4);
        return this.iconclamType[j];
    }

	@Override
	public int getMetadata(int par1) {
		return par1;
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
		par3List.add(new ItemStack(this, 1, 4));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister){
	
		this.iconclamType = new Icon[5];

        for (int i = 0; i < 5; ++i)
        {
            this.iconclamType[i] = par1IconRegister.registerIcon("applemilk:" + clamType[i]);
        }
	}

}
