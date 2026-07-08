package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * Tag constants for GwyCraft. Used for recipes, tool repair, and tag queries.
 * In 1.20.1, ITag.INamedTag replaced by TagKey<T>.
 */
public class ModTags {

    public static class Items {
        /** All 16 enchanted gem items (replaces 1.12 OreDict "gemGwycraft"). */
        public static final TagKey<Item> GEMS =
                ItemTags.create(ResourceLocation.fromNamespaceAndPath(Gwycraft.MOD_ID, "gems"));
    }
}
