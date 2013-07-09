package gwydion0917.gwycraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemDyedClay extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:clay_white",
			"Gwycraft:clay_orange", "Gwycraft:clay_magenta",
			"Gwycraft:clay_lblue", "Gwycraft:clay_yellow",
			"Gwycraft:clay_lime", "Gwycraft:clay_pink", "Gwycraft:clay_gray",
			"Gwycraft:clay_lgray", "Gwycraft:clay_cyan",
			"Gwycraft:clay_purple", "Gwycraft:clay_blue",
			"Gwycraft:clay_brown", "Gwycraft:clay_green", "Gwycraft:clay_red",
			"Gwycraft:clay_black" };
	public Icon[] icons;

	public int blockType;

	public ItemDyedClay(int par1) {
		super(par1);
		setUnlocalizedName("Gwycraft:itemDyedClay");
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
