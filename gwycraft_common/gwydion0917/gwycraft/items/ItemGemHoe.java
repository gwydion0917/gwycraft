package gwydion0917.gwycraft.items;

import java.util.List;
import java.util.Random;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemHoe extends ItemHoe {

	public ItemGemHoe(ToolMaterial mat, String name) {
		super(mat);
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
		
		// TODO: Add a specific enchantment as you can't randomly enchant a hoe
		//EnchantmentHelper.addRandomEnchantment(new Random(), stack, new Random().nextInt(30) + 1, true);
		stack.addEnchantment(Enchantments.FORTUNE, 3);
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
	public void onCreated(ItemStack stack, World par2World, EntityPlayer par3EntityPlayer) {
		if (ConfigGwycraft.toolsHaveEnchants) {
			// TODO: Specify a specific enchant as you can't randomly enchant hoes
			//int level = new Random().nextInt(30) + 1;
			//stack = EnchantmentHelper.addRandomEnchantment(new Random(), stack, level, true);
		}
	}

}
