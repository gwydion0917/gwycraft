package gwydion0917.gwycraft.items;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * Gem shears - silk touch applied on craft via GwycraftPlayerEvents.
 * 1.20.5+: shears behaviour comes from the TOOL data component; Enchantments.*
 * are now ResourceKeys resolved through the registry.
 */
public class ItemGemShears extends ShearsItem {
    public ItemGemShears(Item.Properties props) {
        super(props.component(DataComponents.TOOL, ShearsItem.createToolProperties()));
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
        return false;
    }

    /** Called by GwycraftPlayerEvents on craft to add silk touch. */
    public static void enchantOnCraft(ItemStack stack, HolderLookup.Provider registries) {
        Holder<Enchantment> silkTouch = registries
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(Enchantments.SILK_TOUCH);
        stack.enchant(silkTouch, 1);
    }
}
