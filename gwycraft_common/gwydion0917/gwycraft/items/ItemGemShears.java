package gwydion0917.gwycraft.items;

import java.util.List;

import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemShears extends ItemShears {

	public ItemGemShears(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Register the tool with the game
		GameRegistry.register(this);
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List par3List) {
		ItemStack stack = new ItemStack(item, 1, 0);
		stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
		par3List.add(stack);
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
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if (ConfigGwycraft.toolsHaveEnchants) {
			stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
		}
	}
}
