package gwydion0917.gwycraft;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class dyedItemStonebrick extends ItemBlock {

	private final static String[] subNames = { "white", "orange", "magenta",
			"lightBlue", "yellow", "lightGreen", "pink", "darkGrey",
			"lightGrey", "cyan", "purple", "blue", "brown", "green", "red",
			"black" };

	public dyedItemStonebrick(int id) {
		super(id);
		setHasSubtypes(true);
		setUnlocalizedName("dyedStonebrick");
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
	}

}
