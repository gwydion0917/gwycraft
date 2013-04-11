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

public class ItemDyedMud extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:mud_white",
			"Gwycraft:mud_orange", "Gwycraft:mud_magenta",
			"Gwycraft:mud_lblue", "Gwycraft:mud_yellow", "Gwycraft:mud_lime",
			"Gwycraft:mud_pink", "Gwycraft:mud_gray", "Gwycraft:mud_lgray",
			"Gwycraft:mud_cyan", "Gwycraft:mud_purple", "Gwycraft:mud_blue",
			"Gwycraft:mud_brown", "Gwycraft:mud_green", "Gwycraft:mud_red",
			"Gwycraft:mud_black" };
	public Icon[] icons;

	public int blockType;

	public ItemDyedMud(int par1) {
		super(par1);
		setUnlocalizedName("Gwycraft:itemDyedMud");
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
