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

public class ItemDyedMudBricks extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:mudbrick_white",
			"Gwycraft:mudbrick_orange", "Gwycraft:mudbrick_magenta",
			"Gwycraft:mudbrick_lblue", "Gwycraft:mudbrick_yellow",
			"Gwycraft:mudbrick_lime", "Gwycraft:mudbrick_pink",
			"Gwycraft:mudbrick_gray", "Gwycraft:mudbrick_lgray",
			"Gwycraft:mudbrick_cyan", "Gwycraft:mudbrick_purple",
			"Gwycraft:mudbrick_blue", "Gwycraft:mudbrick_brown",
			"Gwycraft:mudbrick_green", "Gwycraft:mudbrick_red",
			"Gwycraft:mudbrick_black" };
	public Icon[] icons;

	public int blockType;

	public ItemDyedMudBricks(int par1) {
		super(par1);
		setUnlocalizedName("Gwycraft:itemDyedMudBrick");
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
