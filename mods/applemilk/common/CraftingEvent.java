package mods.applemilk.common;

import java.util.ArrayList;

import mods.applemilk.handler.LoadModHandler;
import mods.applemilk.handler.LoadSSectorHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.FakePlayer;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingEvent implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		if (item != null)
		{
			if (item.itemID == DCsAppleMilk.teaMakerNext.blockID) {
				player.triggerAchievement(AchievementRegister.craftTeaMaker);
			}
			else if (item.itemID == DCsAppleMilk.emptyPan.blockID) {
				player.triggerAchievement(AchievementRegister.craftPan);
			}
			else if (item.itemID == DCsAppleMilk.teppann.blockID) {
				player.triggerAchievement(AchievementRegister.craftTeppan);
			}
			else if (item.itemID == DCsAppleMilk.iceMaker.blockID) {
				player.triggerAchievement(AchievementRegister.craftIceMaker);
			}
			else if (item.itemID == DCsAppleMilk.woodBox.blockID) {
				player.triggerAchievement(AchievementRegister.craftLogBox);
			}
			else if (item.itemID == DCsAppleMilk.chalcedonyKnife.itemID) {
				player.triggerAchievement(AchievementRegister.craftChalKnife);
			}
			else if (item.itemID == DCsAppleMilk.cLamp.blockID && item.getItemDamage() == 3) {
				player.triggerAchievement(AchievementRegister.craftGlassLamp);
			}
			else if (item.itemID == DCsAppleMilk.DCgrater.itemID) {
				player.triggerAchievement(AchievementRegister.craftGrater);
			}
			else if (item.itemID == DCsAppleMilk.autoMaker.blockID) {
				player.triggerAchievement(AchievementRegister.craftAutoMaker);
			}
			else if (item.itemID == DCsAppleMilk.vegiBag.blockID) {
				player.triggerAchievement(AchievementRegister.craftVegiBag);
			}
		}
		
		ArrayList<ItemStack> rets = new ArrayList<ItemStack>();
		
		for (int i = 0; i < 9 ; i++)
		{
			ItemStack m = craftMatrix.getStackInSlot(i);
			if (m != null && (m.itemID == DCsAppleMilk.teacupBlock.blockID || m.itemID == DCsAppleMilk.teaCup2.blockID)) {
				rets.add(new ItemStack(DCsAppleMilk.emptyCup,1,0));
			}
			else if (m != null && DCsAppleMilk.SuccessLoadSSector && 
					(m.itemID == LoadSSectorHandler.rumBottle.itemID || m.itemID == LoadSSectorHandler.ginBottle.itemID 
					|| m.itemID == LoadSSectorHandler.beerBottle.itemID || m.itemID == LoadSSectorHandler.sakeBottle.itemID)) {
				rets.add(new ItemStack(LoadSSectorHandler.emptyBottle.itemID, 1, 0));
			}
			else if (m != null && m.itemID == DCsAppleMilk.itemLargeBottle.itemID && m.getItemDamage() > 0) {
				int type = m.getItemDamage() & 15;
				int rem = (m.getItemDamage() >> 4) & 7;
				if (type > 0)
				{
					rem--;
					if (rem < 0){
						rem = 0;
						type = 0;
					}
					int next = (rem << 4) + type;
					rets.add(new ItemStack(DCsAppleMilk.itemLargeBottle.itemID, 1, next));
				}
			}
			else if (m != null && m.itemID == DCsAppleMilk.itemCordial.itemID) {
				int rem = m.getItemDamage() & 3;
				if (rem > 0)
				{
					rem--;
					if (rem == 0){
						rets.add(new ItemStack(DCsAppleMilk.itemLargeBottle.itemID, 1, 0));
					}
					else
					{
						int next = m.getItemDamage() - 1;
						rets.add(new ItemStack(DCsAppleMilk.itemCordial.itemID, 1, next));
					}
				}
				else
				{
					rets.add(new ItemStack(DCsAppleMilk.itemLargeBottle.itemID, 1, 0));
				}
			}
		}
		if (!rets.isEmpty()) {
			for (ItemStack ret : rets)
			{
				if (!(player instanceof FakePlayer) && !player.inventory.addItemStackToInventory(ret))
	        	{
	        		player.dropPlayerItem(ret);
	        	}
			}
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
		if (item != null)
		{
			if (item.itemID == DCsAppleMilk.charcoalBox.blockID) {
				player.triggerAchievement(AchievementRegister.craftCharcoalContainer);
			}
			else if (item.itemID == DCsAppleMilk.chalcedony.blockID) {
				player.triggerAchievement(AchievementRegister.craftChalcedony);
			}
			else if (item.itemID == DCsAppleMilk.EXItems.itemID && item.getItemDamage() == 2) {
				player.triggerAchievement(AchievementRegister.makeTeaLeaves);
			}
		}
	}

}
