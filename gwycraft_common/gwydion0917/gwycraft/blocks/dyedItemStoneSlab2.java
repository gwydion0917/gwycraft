package gwydion0917.gwycraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class dyedItemStoneSlab2 extends ItemBlock {

	private final static String[] subNames = { "lightGrey", "cyan", "purple", "blue", "brown", "green", "red",
			"black" };

	public dyedItemStoneSlab2(int id) {
		super(id);
		setHasSubtypes(true);
		setUnlocalizedName("dyedStoneSlab2");
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
