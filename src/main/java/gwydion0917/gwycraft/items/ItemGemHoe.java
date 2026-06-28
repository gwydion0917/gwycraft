package gwydion0917.gwycraft.items;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Gem hoe. Random enchant-on-craft is handled by GwycraftPlayerEvents.
 */
public class ItemGemHoe extends HoeItem {
    public ItemGemHoe(Item.Properties props) {
        super(GwyItemTier.INSTANCE, -2, -1.0F, props);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return GwyItemTier.INSTANCE.getEnchantmentValue();
    }
}
