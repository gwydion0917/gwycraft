package gwydion0917.gwycraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;

/**
 * Gem pickaxe. Random enchant-on-craft is handled by GwycraftPlayerEvents.
 */
public class ItemGemPickaxe extends PickaxeItem {
    public ItemGemPickaxe(Item.Properties props) {
        super(GwyItemTier.INSTANCE, 1, -2.8F, props);
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
