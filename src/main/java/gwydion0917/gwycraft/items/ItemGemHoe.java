package gwydion0917.gwycraft.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Gem hoe. Random enchant-on-craft is handled by GwycraftPlayerEvents.
 * In 1.16.5, HoeItem constructor takes (tier, attackDamage, attackSpeed, properties).
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
