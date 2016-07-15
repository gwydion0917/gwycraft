package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDyedMud extends ItemDye {

	public String[] textureNames = new String[] { "Gwycraft:mud_white", "Gwycraft:mud_orange", "Gwycraft:mud_magenta", "Gwycraft:mud_lblue", "Gwycraft:mud_yellow", "Gwycraft:mud_lime", "Gwycraft:mud_pink", "Gwycraft:mud_gray", "Gwycraft:mud_lgray", "Gwycraft:mud_cyan", "Gwycraft:mud_purple", "Gwycraft:mud_blue", "Gwycraft:mud_brown", "Gwycraft:mud_green",
			"Gwycraft:mud_red", "Gwycraft:mud_black" };

	public int blockType;
	private final String name = "itemDyedMud";

	public ItemDyedMud() {
		super();
		setUnlocalizedName("Gwycraft:itemDyedMud");
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
