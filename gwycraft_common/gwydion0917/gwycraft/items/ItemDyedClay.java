package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDyedClay extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:clay_white", "Gwycraft:clay_orange", "Gwycraft:clay_magenta", "Gwycraft:clay_lblue", "Gwycraft:clay_yellow", "Gwycraft:clay_lime", "Gwycraft:clay_pink", "Gwycraft:clay_gray", "Gwycraft:clay_lgray", "Gwycraft:clay_cyan", "Gwycraft:clay_purple", "Gwycraft:clay_blue", "Gwycraft:clay_brown",
			"Gwycraft:clay_green", "Gwycraft:clay_red", "Gwycraft:clay_black" };

	public int blockType;
	private final String name = "itemDyedClay";

	public ItemDyedClay() {
		super();
		setUnlocalizedName("Gwycraft:itemDyedClay");
		this.setHasSubtypes(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < 16; i++)
			list.add(new ItemStack(this, 1, i));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int arr = net.minecraft.util.math.MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
		return "item." + textureNames[arr];
	}

	public String getName() {
		return name;
	}
}
