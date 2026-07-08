package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

/**
 * Tag providers for GwyCraft 1.20.1.
 * Key changes from 1.16.5:
 * - Constructors take PackOutput + CompletableFuture<HolderLookup.Provider>
 * - addTags() → addTags(HolderLookup.Provider)
 * - TagsProvider.Builder<Block/Item> still works but import paths differ
 * - Added mineable/* + needs_*_tool tags (required since 1.17 for correct tool gating)
 */
public class ModTagsProvider {

    // ── Block tags ────────────────────────────────────────────────────────────

    public static class GwycraftBlockTags extends BlockTagsProvider {

        public GwycraftBlockTags(PackOutput output,
                                  CompletableFuture<HolderLookup.Provider> lookupProvider,
                                  ExistingFileHelper efh) {
            super(output, lookupProvider, Gwycraft.MOD_ID, efh);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // ── Planks tag ──────────────────────────────────────────────────
            var planks = tag(BlockTags.PLANKS);
            for (DyeColor c : DyeColor.values()) {
                planks.add(ModBlocks.DYED_PLANK.get(c).get());
            }

            // ── Wall tag ────────────────────────────────────────────────────
            var walls = tag(BlockTags.WALLS);
            for (DyeColor c : DyeColor.values()) {
                walls.add(ModBlocks.DYED_COBBLESTONE_WALL.get(c).get());
                walls.add(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL.get(c).get());
            }

            // ── Leaves tag ──────────────────────────────────────────────────
            var leaves = tag(BlockTags.LEAVES);
            for (DyeColor c : DyeColor.values()) {
                leaves.add(ModBlocks.DYED_LEAF.get(c).get());
                leaves.add(ModBlocks.GLOWY_DYED_LEAF.get(c).get());
            }

            // ── Mineable with pickaxe (stone, brick, sandstone, cobblestone, gem) ─
            var pickaxe = tag(BlockTags.MINEABLE_WITH_PICKAXE);
            for (DyeColor c : DyeColor.values()) {
                pickaxe.add(ModBlocks.DYED_STONE.get(c).get(),
                        ModBlocks.GLOWY_DYED_STONE.get(c).get(),
                        ModBlocks.DYED_STONE_PAVER.get(c).get(),
                        ModBlocks.GLOWY_DYED_STONE_PAVER.get(c).get(),
                        ModBlocks.DYED_BRICK.get(c).get(),
                        ModBlocks.GLOWY_DYED_BRICK.get(c).get(),
                        ModBlocks.DYED_BRICK_PAVER.get(c).get(),
                        ModBlocks.GLOWY_DYED_BRICK_PAVER.get(c).get(),
                        ModBlocks.DYED_MUD_BRICK.get(c).get(),
                        ModBlocks.GLOWY_DYED_MUD_BRICK.get(c).get(),
                        ModBlocks.DYED_MUD_BRICK_PAVER.get(c).get(),
                        ModBlocks.GLOWY_DYED_MUD_BRICK_PAVER.get(c).get(),
                        ModBlocks.DYED_SANDSTONE.get(c).get(),
                        ModBlocks.GLOWY_DYED_SANDSTONE.get(c).get(),
                        ModBlocks.DYED_SMOOTH_SANDSTONE.get(c).get(),
                        ModBlocks.GLOWY_DYED_SMOOTH_SANDSTONE.get(c).get(),
                        ModBlocks.DYED_CHISELED_SANDSTONE.get(c).get(),
                        ModBlocks.GLOWY_DYED_CHISELED_SANDSTONE.get(c).get(),
                        ModBlocks.DYED_STONE_BRICK.get(c).get(),
                        ModBlocks.GLOWY_DYED_STONE_BRICK.get(c).get(),
                        ModBlocks.DYED_STONE_BRICK_PAVER.get(c).get(),
                        ModBlocks.GLOWY_DYED_STONE_BRICK_PAVER.get(c).get(),
                        ModBlocks.DYED_COBBLESTONE.get(c).get(),
                        ModBlocks.GLOWY_DYED_COBBLESTONE.get(c).get(),
                        ModBlocks.DYED_COBBLESTONE_PAVER.get(c).get(),
                        ModBlocks.GLOWY_DYED_COBBLESTONE_PAVER.get(c).get(),
                        ModBlocks.DYED_COBBLESTONE_WALL.get(c).get(),
                        ModBlocks.GLOWY_DYED_COBBLESTONE_WALL.get(c).get(),
                        ModBlocks.PLAIN_GREEK_BOTTOM.get(c).get(),
                        ModBlocks.PLAIN_GREEK_PILLAR.get(c).get(),
                        ModBlocks.PLAIN_GREEK_TOP.get(c).get(),
                        ModBlocks.PLAIN_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.PLAIN_PILLAR.get(c).get(),
                        ModBlocks.PLAIN_PILLAR_TOP.get(c).get(),
                        ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.PLAIN_WIDE_PILLAR.get(c).get(),
                        ModBlocks.PLAIN_WIDE_PILLAR_TOP.get(c).get(),
                        ModBlocks.GREEK_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GREEK_PILLAR_TOP.get(c).get(),
                        ModBlocks.GREEK_WIDE_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GREEK_WIDE_PILLAR_TOP.get(c).get(),
                        ModBlocks.GREEK2_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GREEK2_PILLAR_TOP.get(c).get(),
                        ModBlocks.PLAIN_SLAB.get(c).get(),
                        ModBlocks.GREEK_SLAB.get(c).get(),
                        ModBlocks.FANCY_BOTTOM.get(c).get(),
                        ModBlocks.FANCY_TOP.get(c).get(),
                        ModBlocks.FANCY_GREEK_BOTTOM.get(c).get(),
                        ModBlocks.FANCY_GREEK_TOP.get(c).get(),
                        ModBlocks.FANCY_WIDE_BOTTOM.get(c).get(),
                        ModBlocks.FANCY_WIDE_TOP.get(c).get(),
                        ModBlocks.FANCY_SLAB.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_GREEK_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_GREEK_PILLAR.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_GREEK_TOP.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_PILLAR.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_PILLAR_TOP.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_TOP.get(c).get(),
                        ModBlocks.GLOWY_GREEK_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_GREEK_PILLAR_TOP.get(c).get(),
                        ModBlocks.GLOWY_GREEK_WIDE_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_GREEK_WIDE_PILLAR_TOP.get(c).get(),
                        ModBlocks.GLOWY_GREEK2_PILLAR_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_GREEK2_PILLAR_TOP.get(c).get(),
                        ModBlocks.GLOWY_PLAIN_SLAB.get(c).get(),
                        ModBlocks.GLOWY_GREEK_SLAB.get(c).get(),
                        ModBlocks.GLOWY_FANCY_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_FANCY_TOP.get(c).get(),
                        ModBlocks.GLOWY_FANCY_GREEK_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_FANCY_GREEK_TOP.get(c).get(),
                        ModBlocks.GLOWY_FANCY_WIDE_BOTTOM.get(c).get(),
                        ModBlocks.GLOWY_FANCY_WIDE_TOP.get(c).get(),
                        ModBlocks.GLOWY_FANCY_SLAB.get(c).get());
            }

            // ── Slabs ───────────────────────────────────────────────────────
            var slabs = tag(BlockTags.SLABS);
            for (DyeColor c : DyeColor.values()) {
                slabs.add(ModBlocks.PLAIN_SLAB.get(c).get(),
                           ModBlocks.GREEK_SLAB.get(c).get(),
                           ModBlocks.FANCY_SLAB.get(c).get(),
                           ModBlocks.GLOWY_PLAIN_SLAB.get(c).get(),
                           ModBlocks.GLOWY_GREEK_SLAB.get(c).get(),
                           ModBlocks.GLOWY_FANCY_SLAB.get(c).get());
            }
            for (EnumGemType gem : EnumGemType.values()) {
                pickaxe.add(ModBlocks.GEM_ORE.get(gem).get(),
                        ModBlocks.COMPRESSED_GEM.get(gem).get());
            }

            // ── Mineable with axe (logs, planks, bookcase) ─────────────────
            var axe = tag(BlockTags.MINEABLE_WITH_AXE);
            for (DyeColor c : DyeColor.values()) {
                axe.add(ModBlocks.DYED_LOG.get(c).get(),
                        ModBlocks.GLOWY_DYED_LOG.get(c).get(),
                        ModBlocks.DYED_PLANK.get(c).get(),
                        ModBlocks.GLOWY_DYED_PLANK.get(c).get(),
                        ModBlocks.DYED_BOOKCASE.get(c).get(),
                        ModBlocks.GLOWY_DYED_BOOKCASE.get(c).get());
            }

            // ── Mineable with hoe (leaves) ──────────────────────────────────
            var hoe = tag(BlockTags.MINEABLE_WITH_HOE);
            for (DyeColor c : DyeColor.values()) {
                hoe.add(ModBlocks.DYED_LEAF.get(c).get(),
                        ModBlocks.GLOWY_DYED_LEAF.get(c).get());
            }

            // ── Mineable with shovel (sand, clay) ───────────────────────────
            var shovel = tag(BlockTags.MINEABLE_WITH_SHOVEL);
            for (DyeColor c : DyeColor.values()) {
                shovel.add(ModBlocks.DYED_SAND.get(c).get(),
                        ModBlocks.GLOWY_DYED_SAND.get(c).get(),
                        ModBlocks.DYED_CLAY.get(c).get(),
                        ModBlocks.GLOWY_DYED_CLAY.get(c).get());
            }

            // ── Needs stone tool (stone-tier blocks) ────────────────────────
            // Gem ores need at least a stone pick to drop the gem
            var needsStone = tag(BlockTags.NEEDS_STONE_TOOL);
            for (EnumGemType gem : EnumGemType.values()) {
                needsStone.add(ModBlocks.GEM_ORE.get(gem).get());
                needsStone.add(ModBlocks.COMPRESSED_GEM.get(gem).get());
            }
        }

        @Override
        public String getName() {
            return "GwyCraft Block Tags";
        }
    }

    // ── Item tags ─────────────────────────────────────────────────────────────

    public static class GwycraftItemTags extends ItemTagsProvider {

        public GwycraftItemTags(PackOutput output,
                                 CompletableFuture<HolderLookup.Provider> lookupProvider,
                                 CompletableFuture<TagLookup<Block>> blockTags,
                                 ExistingFileHelper efh) {
            super(output, lookupProvider, blockTags, Gwycraft.MOD_ID, efh);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            // gwycraft:gems — all 16 gem items
            var gems = tag(ModTags.Items.GEMS);
            for (EnumGemType gem : EnumGemType.values()) {
                gems.add(ModItems.GEM.get(gem).get());
            }

            // Vanilla tool-type tags — the minecraft:enchantable/* tags are built
            // from these, so without them EnchantmentHelper.enchantItem finds no
            // applicable enchantments for the gem tools.
            tag(ItemTags.SWORDS).add(ModItems.GEM_SWORD.get());
            tag(ItemTags.AXES).add(ModItems.GEM_HATCHET.get());
            tag(ItemTags.PICKAXES).add(ModItems.GEM_PICKAXE.get());
            tag(ItemTags.SHOVELS).add(ModItems.GEM_SHOVEL.get());
            tag(ItemTags.HOES).add(ModItems.GEM_HOE.get());

            // Copy block tags to item tags
            copy(BlockTags.PLANKS, ItemTags.PLANKS);
            copy(BlockTags.WALLS, ItemTags.WALLS);
            copy(BlockTags.LEAVES, ItemTags.LEAVES);
            copy(BlockTags.SLABS, ItemTags.SLABS);

            // ── Stone crafting materials ────────────────────────────────────
            // Allows dyed stone/cobblestone in standard recipes (furnaces, tools, etc.)
            var stoneCrafting = tag(ItemTags.STONE_CRAFTING_MATERIALS);
            for (DyeColor c : DyeColor.values()) {
                stoneCrafting.add(ModBlocks.DYED_STONE.get(c).get().asItem());
                stoneCrafting.add(ModBlocks.DYED_COBBLESTONE.get(c).get().asItem());
            }

        }

        @Override
        public String getName() {
            return "GwyCraft Item Tags";
        }
    }
}
