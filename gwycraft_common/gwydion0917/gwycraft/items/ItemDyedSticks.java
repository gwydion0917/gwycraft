package gwydion0917.gwycraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemDyedSticks extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:stick_white",
			"Gwycraft:stick_orange", "Gwycraft:stick_magenta",
			"Gwycraft:stick_lblue", "Gwycraft:stick_yellow",
			"Gwycraft:stick_lime", "Gwycraft:stick_pink", "Gwycraft:stick_gray",
			"Gwycraft:stick_lgray", "Gwycraft:stick_cyan",
			"Gwycraft:stick_purple", "Gwycraft:stick_blue",
			"Gwycraft:stick_brown", "Gwycraft:stick_green", "Gwycraft:stick_red",
			"Gwycraft:stick_black" };
	public Icon[] icons;

	public int blockType;

	public ItemDyedSticks(int par1) {
		super(par1);
		setUnlocalizedName("Gwycraft:itemDyedSticks");
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.icons = new Icon[textureNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.registerIcon(textureNames[i]);
		}
	}

	@Override
	public void getSubItems(int id, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < 16; i++)
			list.add(new ItemStack(id, 1, i));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
		return "item." + textureNames[arr];
	}

}
