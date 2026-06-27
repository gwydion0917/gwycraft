package gwydion0917.gwycraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;

/**
 * Gem shovel. Random enchant-on-craft is handled by GwycraftPlayerEvents.
 */
public class ItemGemShovel extends ShovelItem {
    public ItemGemShovel(Item.Properties props) {
        super(GwyItemTier.INSTANCE, 1.5F, -3.0F, props);
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
