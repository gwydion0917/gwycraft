package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.ConfigGwycraft;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGemHatchet extends ItemAxe {

	public ItemGemHatchet(ToolMaterial mat) {
		super(mat);

		setUnlocalizedName("Gwycraft:hatchet");
		setHasSubtypes(true);
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		ItemStack stack = new ItemStack(par1, 1, 0);
		par3List.add(stack);
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon("Gwycraft:hatchet");
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
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
    	if (ConfigGwycraft.toolsHaveEnchants){
    		int level = new Random().nextInt(30) + 1;
    		par1ItemStack = EnchantmentHelper.addRandomEnchantment(new Random(), par1ItemStack, level);
    	}
    }

}
