package gwydion0917.gwycraft.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Gem axe (hatchet). Random enchant-on-craft is handled by GwycraftPlayerEvents.
 */
public class ItemGemHatchet extends AxeItem {
    public ItemGemHatchet(Item.Properties props) {
        super(GwyItemTier.INSTANCE, 5.0F, -3.0F, props);
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
