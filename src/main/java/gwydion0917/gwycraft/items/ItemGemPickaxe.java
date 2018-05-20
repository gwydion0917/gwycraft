package gwydion0917.gwycraft.items;

import java.util.List;
import java.util.Random;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemPickaxe extends ItemPickaxe {

	public ItemGemPickaxe(ToolMaterial mat, String name) {
		super(mat);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Add the tool to the registry
		//GameRegistry.register(this);
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		ItemStack stack = new ItemStack(this, 1, 0);
		
		//Add the random enchant to the stack
		EnchantmentHelper.addRandomEnchantment(new Random(), stack, new Random().nextInt(30) + 1, true);
		
		subItems.add(stack);
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
		return this.toolMaterial.getEnchantability();
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer plater) {
		if (ConfigGwycraft.toolsHaveEnchants) {
			int level = new Random().nextInt(30) + 1;
			itemStack = EnchantmentHelper.addRandomEnchantment(new Random(), itemStack, level, true);
		}
	}
}
