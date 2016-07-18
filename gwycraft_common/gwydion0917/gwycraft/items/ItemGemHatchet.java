package gwydion0917.gwycraft.items;

import java.util.List;
import java.util.Random;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemHatchet extends ItemAxe {

	public ItemGemHatchet(Item.ToolMaterial mat, String name) {
		super(mat, mat.getDamageVsEntity(), mat.getEfficiencyOnProperMaterial());
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Register the item
		GameRegistry.register(this);
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List itemList) {
		ItemStack stack = new ItemStack(item, 1, 0);
		
		//Add the random enchant to the stack
		EnchantmentHelper.addRandomEnchantment(new Random(), stack, new Random().nextInt(30) + 1, true);
		
		itemList.add(stack);
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		// FIXME: This needs work
		return false;
	}

	@Override
	public int getItemEnchantability() {
		// FIXME: This never gets called, and can't figure it out
		return this.toolMaterial.getEnchantability();
	}

	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (ConfigGwycraft.toolsHaveEnchants) {
			int level = new Random().nextInt(30) + 1;
			par1ItemStack = EnchantmentHelper.addRandomEnchantment(new Random(), par1ItemStack, level, true);
		}
	}

}
