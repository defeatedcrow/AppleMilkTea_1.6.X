package mods.applemilk.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
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
