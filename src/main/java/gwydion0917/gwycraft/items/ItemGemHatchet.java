package gwydion0917.gwycraft.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Gem axe (hatchet). Random enchant-on-craft is handled by GwycraftPlayerEvents.
 * 1.20.5+: attack damage/speed move into Item.Properties via createAttributes().
 */
public class ItemGemHatchet extends AxeItem {
    public ItemGemHatchet(Item.Properties props) {
        super(GwyItemTier.INSTANCE,
                props.attributes(AxeItem.createAttributes(GwyItemTier.INSTANCE, 5.0F, -3.0F)));
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
