package gwydion0917.gwycraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGwyGeneric extends ItemBlock {

	private final static String[] subNames = { "white", "orange", "magenta",
			"lightBlue", "yellow", "lightGreen", "pink", "darkGrey",
			"lightGrey", "cyan", "purple", "blue", "brown", "green", "red",
			"black" };

	public ItemGwyGeneric(int id) {
		super(id);
		setHasSubtypes(true);
		// Can't pass string param from registerblock, may not be needed?
		//setUnlocalizedName("dyedStonecobble");
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
