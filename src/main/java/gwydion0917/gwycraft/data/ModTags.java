package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

/**
 * Tag constants for GwyCraft. Used for recipes, tool repair, and ore dictionary equivalents.
 */
public class ModTags {

    public static class Items {
        /** All 16 enchanted gem items (replaces 1.12 OreDict "gemGwycraft"). */
        public static final ITag.INamedTag<Item> GEMS =
                ItemTags.createOptional(new ResourceLocation(Gwycraft.MOD_ID, "gems"));
    }
}
