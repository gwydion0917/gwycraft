package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDyedSticks extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:stick_white",
			"Gwycraft:stick_orange", "Gwycraft:stick_magenta",
			"Gwycraft:stick_lblue", "Gwycraft:stick_yellow",
			"Gwycraft:stick_lime", "Gwycraft:stick_pink", "Gwycraft:stick_gray",
			"Gwycraft:stick_lgray", "Gwycraft:stick_cyan",
			"Gwycraft:stick_purple", "Gwycraft:stick_blue",
			"Gwycraft:stick_brown", "Gwycraft:stick_green", "Gwycraft:stick_red",
			"Gwycraft:stick_black" };
	public IIcon[] icons;

	public int blockType;

	public ItemDyedSticks() {
		super();
		setUnlocalizedName("Gwycraft:itemDyedSticks");
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[textureNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.registerIcon(textureNames[i]);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < 16; i++)
			list.add(new ItemStack(this, 1, i));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
		return icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
		return "item." + textureNames[arr];
	}

}
