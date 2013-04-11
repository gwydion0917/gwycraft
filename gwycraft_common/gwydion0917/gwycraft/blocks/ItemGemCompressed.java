package gwydion0917.gwycraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGemCompressed extends ItemBlock {

	private final static String[] subNames = { "Flawed Agate",
			"Flawed Amethyst", "Flawed Aquamarine", "Flawed Citrine",
			"Flawed Emerald", "Flawed Garnet", "Flawed Hematite",
			"Flawed Lapis Lazuli", "Flawed Onyx", "Flawed Quartz",
			"Flawed Ruby", "Flawed Sapphire", "Flawed Tanzanite",
			"Flawed Tigerseye", "Flawed Topaz", "Flawed Moonstone" };

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
