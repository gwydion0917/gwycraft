package gwydion0917.gwycraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

/**
 * Gem sword. Random enchant-on-craft is handled by GwycraftPlayerEvents.
 */
public class ItemGemSword extends SwordItem {
    public ItemGemSword(Item.Properties props) {
        super(GwyItemTier.INSTANCE,
                props.attributes(SwordItem.createAttributes(GwyItemTier.INSTANCE, 3, -2.4F)));
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
