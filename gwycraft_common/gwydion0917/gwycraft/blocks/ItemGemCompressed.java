package gwydion0917.gwycraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGemCompressed extends ItemBlock {

	private final static String[] subNames = { "Enchanted Quartz", "Enchanted Citrine", "Enchanted Tanzanite", "Enchanted Sapphire", 
        "Enchanted Topaz", "Enchanted Agate", "Enchanted Garnet",  "Enchanted Moonstone", "Enchanted Hematite", "Enchanted Aquamarine",
        "Enchanted Amethyst",  "Enchanted Lapis Lazuli",  "Enchanted Tigerseye",  "Enchanted Emerald", "Enchanted Ruby", "Enchanted Onyx"};

	public ItemGemCompressed(int id) {
		super(id);
		setHasSubtypes(true);
		setUnlocalizedName("blockGemCompressed");
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
