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
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.NonNullList;
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
		//GameRegistry.register(this);
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> itemList) {
		ItemStack stack = new ItemStack(this, 1, 0);
		
		stack.addEnchantment(Enchantments.EFFICIENCY, 3);
		
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
			stack.addEnchantment(Enchantments.EFFICIENCY, 3);
		}
	}
}
