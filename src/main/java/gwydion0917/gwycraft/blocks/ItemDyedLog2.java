package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDyedLog2 extends ItemBlock {

	private final static String[] subNames = { "yellow", "lightGreen", "pink", "darkGrey" };

	public ItemDyedLog2(Block block) {
		super(block);
		setHasSubtypes(true);
		setUnlocalizedName("dyedLog2");
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		if (itemstack.getItemDamage() < subNames.length) {
			return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
		} else {
			return getUnlocalizedName() + ".ERROR";
		}
	}

}
