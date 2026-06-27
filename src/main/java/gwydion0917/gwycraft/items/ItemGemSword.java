package gwydion0917.gwycraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

/**
 * Gem sword. Random enchant-on-craft is handled by GwycraftPlayerEvents.ItemCraftedEvent.
 */
public class ItemGemSword extends SwordItem {
    public ItemGemSword(Item.Properties props) {
        super(GwyItemTier.INSTANCE, 3, -2.4F, props);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
        return false; // Repaired via gem tag in tier
    }

    @Override
    public int getEnchantmentValue() {
        return GwyItemTier.INSTANCE.getEnchantmentValue();
    }
}
