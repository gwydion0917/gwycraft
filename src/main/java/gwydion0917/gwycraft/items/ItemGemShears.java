package gwydion0917.gwycraft.items;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;

/**
 * Gem shears — silk touch applied on craft via GwycraftPlayerEvents.
 * ShearsItem uses a fixed durability (238); no IItemTier.
 */
public class ItemGemShears extends ShearsItem {
    public ItemGemShears(Item.Properties props) {
        super(props);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
        return false;
    }

    /** Called by GwycraftPlayerEvents on craft to add silk touch. */
    public static void enchantOnCraft(ItemStack stack) {
        stack.enchant(Enchantments.SILK_TOUCH, 1);
    }
}
