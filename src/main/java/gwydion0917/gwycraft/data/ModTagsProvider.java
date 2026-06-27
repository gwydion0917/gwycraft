package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * Tag providers for GwyCraft.
 *
 * gwycraft:gems tag replaces the 1.12 OreDict "gemGwycraft" entry.
 * Note: NEEDS_STONE_TOOL BlockTag was added in 1.17, so not available here.
 */
public class ModTagsProvider {

    // ── Block tags ────────────────────────────────────────────────────────────

    public static class GwycraftBlockTags extends BlockTagsProvider {

        public GwycraftBlockTags(DataGenerator gen, ExistingFileHelper efh) {
            super(gen, Gwycraft.MOD_ID, efh);
        }

        @Override
        protected void addTags() {
            // Mark all dyed cobblestone walls as walls
            TagsProvider.Builder<Block> walls = tag(BlockTags.WALLS);
            for (DyeColor c : DyeColor.values()) {
                walls.add(ModBlocks.DYED_COBBLESTONE_WALL.get(c).get());
                walls.add(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL.get(c).get());
            }

            // Mark dyed leaves as leaves
            TagsProvider.Builder<Block> leaves = tag(BlockTags.LEAVES);
            for (DyeColor c : DyeColor.values()) {
                leaves.add(ModBlocks.DYED_LEAF.get(c).get());
                leaves.add(ModBlocks.GLOWY_DYED_LEAF.get(c).get());
            }
        }

        @Override
        public String getName() {
            return "GwyCraft Block Tags";
        }
    }

    // ── Item tags ─────────────────────────────────────────────────────────────

    public static class GwycraftItemTags extends ItemTagsProvider {

        public GwycraftItemTags(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper efh) {
            super(gen, blockTags, Gwycraft.MOD_ID, efh);
        }

        @Override
        protected void addTags() {
            // gwycraft:gems — all 16 gem items (replaces OreDict "gemGwycraft")
            TagsProvider.Builder<Item> gems = tag(ModTags.Items.GEMS);
            for (EnumGemType gem : EnumGemType.values()) {
                gems.add(ModItems.GEM.get(gem).get());
            }

            // Copy block tags to item tags
            copy(BlockTags.WALLS, ItemTags.WALLS);
            copy(BlockTags.LEAVES, ItemTags.LEAVES);
        }

        @Override
        public String getName() {
            return "GwyCraft Item Tags";
        }
    }
}
