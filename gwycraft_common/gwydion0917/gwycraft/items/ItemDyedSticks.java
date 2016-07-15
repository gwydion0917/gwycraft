package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDyedSticks extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:stick_white", "Gwycraft:stick_orange", "Gwycraft:stick_magenta", "Gwycraft:stick_lblue", "Gwycraft:stick_yellow", "Gwycraft:stick_lime", "Gwycraft:stick_pink", "Gwycraft:stick_gray", "Gwycraft:stick_lgray", "Gwycraft:stick_cyan", "Gwycraft:stick_purple", "Gwycraft:stick_blue",
			"Gwycraft:stick_brown", "Gwycraft:stick_green", "Gwycraft:stick_red", "Gwycraft:stick_black" };

	public int blockType;
	private final String name = "itemDyedSticks";

	public ItemDyedSticks() {
		super();
		setUnlocalizedName("Gwycraft:itemDyedSticks");
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
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
		return "item." + textureNames[arr];
	}

	public String getName() {
		return name;
	}
}
