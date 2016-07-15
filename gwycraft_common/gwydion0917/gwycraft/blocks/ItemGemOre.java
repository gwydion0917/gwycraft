package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGemOre extends ItemBlock {

	private final static String[] subNames = { "Enchanted Quartz", "Enchanted Citrine", "Enchanted Tanzanite", "Enchanted Sapphire", "Enchanted Topaz", "Enchanted Agate", "Enchanted Garnet", "Enchanted Moonstone", "Enchanted Hematite", "Enchanted Aquamarine", "Enchanted Amethyst", "Enchanted Lapis Lazuli", "Enchanted Tigerseye", "Enchanted Emerald",
			"Enchanted Ruby", "Enchanted Onyx" };

	public ItemGemOre(Block block) {
		super(block);
		setHasSubtypes(true);
		setUnlocalizedName("blockGemOre");
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
