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
	public IIcon[] icons;

	public int blockType;

	public ItemDyedMudBricks() {
		super();
		setUnlocalizedName("Gwycraft:itemDyedMudBrick");
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
