package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Block loot table generator for GwyCraft 1.20.1.
 * Key changes from 1.16.5:
 * - BlockLootTables → BlockLootSubProvider
 * - BlockLootSubProvider(Set<Item>, FeatureFlagSet) constructor
 * - LootTableProvider(PackOutput, Set<ResourceLocation>, List<SubProviderEntry>)
 * - addTables() → generate() — the protected method is now generate()
 * - LootParameterSets → LootContextParamSets
 */
public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(
                new SubProviderEntry(GwycraftBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }

    // ── Inner block loot table class ─────────────────────────────────────────

    public static class GwycraftBlockLoot extends BlockLootSubProvider {

        public GwycraftBlockLoot() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            // Gem ores drop their gem (silk touch drops the ore block)
            for (EnumGemType gem : EnumGemType.values()) {
                Block oreBlock = ModBlocks.GEM_ORE.get(gem).get();
                Item  gemItem  = ModItems.GEM.get(gem).get();
                add(oreBlock, createOreDrop(oreBlock, gemItem));
            }

            // All other blocks: self-drop
            selfDropGemMap(ModBlocks.COMPRESSED_GEM);
            selfDropDyeMap(ModBlocks.GLOWY_WOOL);
            selfDropDyeMap(ModBlocks.DYED_STONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_STONE);
            selfDropDyeMap(ModBlocks.DYED_STONE_PAVER);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_STONE_PAVER);
            selfDropDyeMap(ModBlocks.DYED_BOOKCASE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_BOOKCASE);
            selfDropDyeMap(ModBlocks.DYED_BRICK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_BRICK);
            selfDropDyeMap(ModBlocks.DYED_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.DYED_CLAY);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_CLAY);
            selfDropDyeMap(ModBlocks.DYED_GLASS);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_GLASS);
            selfDropDyeMap(ModBlocks.DYED_LEAF);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_LEAF);
            selfDropDyeMap(ModBlocks.DYED_MUD_BRICK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_MUD_BRICK);
            selfDropDyeMap(ModBlocks.DYED_MUD_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_MUD_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.DYED_LOG);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_LOG);
            selfDropDyeMap(ModBlocks.DYED_PLANK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_PLANK);
            selfDropDyeMap(ModBlocks.DYED_SAND);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_SAND);
            selfDropDyeMap(ModBlocks.DYED_SANDSTONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_SANDSTONE);
            selfDropDyeMap(ModBlocks.DYED_SMOOTH_SANDSTONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_SMOOTH_SANDSTONE);
            selfDropDyeMap(ModBlocks.DYED_CHISELED_SANDSTONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_CHISELED_SANDSTONE);
            selfDropDyeMap(ModBlocks.DYED_STONE_BRICK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_STONE_BRICK);
            selfDropDyeMap(ModBlocks.DYED_STONE_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_STONE_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_COBBLESTONE);
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE_PAVER);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_COBBLESTONE_PAVER);
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE_WALL);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL);
            selfDropDyeMap(ModBlocks.PLAIN_GREEK_BOTTOM);
            selfDropDyeMap(ModBlocks.PLAIN_GREEK_PILLAR);
            selfDropDyeMap(ModBlocks.PLAIN_GREEK_TOP);
            selfDropDyeMap(ModBlocks.PLAIN_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.PLAIN_PILLAR);
            selfDropDyeMap(ModBlocks.PLAIN_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.PLAIN_WIDE_PILLAR);
            selfDropDyeMap(ModBlocks.PLAIN_WIDE_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GREEK_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GREEK_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GREEK_WIDE_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GREEK_WIDE_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GREEK2_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GREEK2_PILLAR_TOP);
            slabDropDyeMap(ModBlocks.PLAIN_SLAB);
            slabDropDyeMap(ModBlocks.GREEK_SLAB);
            selfDropDyeMap(ModBlocks.FANCY_BOTTOM);
            selfDropDyeMap(ModBlocks.FANCY_TOP);
            selfDropDyeMap(ModBlocks.FANCY_GREEK_BOTTOM);
            selfDropDyeMap(ModBlocks.FANCY_GREEK_TOP);
            selfDropDyeMap(ModBlocks.FANCY_WIDE_BOTTOM);
            selfDropDyeMap(ModBlocks.FANCY_WIDE_TOP);
            slabDropDyeMap(ModBlocks.FANCY_SLAB);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_GREEK_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_GREEK_PILLAR);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_GREEK_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_PILLAR);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR);
            selfDropDyeMap(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK_WIDE_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK_WIDE_PILLAR_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK2_PILLAR_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_GREEK2_PILLAR_TOP);
            slabDropDyeMap(ModBlocks.GLOWY_PLAIN_SLAB);
            slabDropDyeMap(ModBlocks.GLOWY_GREEK_SLAB);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_GREEK_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_GREEK_TOP);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_WIDE_BOTTOM);
            selfDropDyeMap(ModBlocks.GLOWY_FANCY_WIDE_TOP);
            slabDropDyeMap(ModBlocks.GLOWY_FANCY_SLAB);

            // Torches: floor drops itself; wall torch drops floor torch item
            for (DyeColor c : DyeColor.values()) {
                Block floor = ModBlocks.TORCH.get(c).get();
                Block wall  = ModBlocks.WALL_TORCH.get(c).get();
                dropSelf(floor);
                add(wall, createSingleItemTable(floor));
            }
        }

        private void selfDropDyeMap(Map<DyeColor, RegistryObject<Block>> family) {
            for (RegistryObject<Block> ro : family.values()) {
                dropSelf(ro.get());
            }
        }

        private void slabDropDyeMap(Map<DyeColor, RegistryObject<Block>> family) {
            for (RegistryObject<Block> ro : family.values()) {
                add(ro.get(), createSlabItemTable(ro.get()));
            }
        }

        private void selfDropGemMap(Map<EnumGemType, RegistryObject<Block>> family) {
            for (RegistryObject<Block> ro : family.values()) {
                dropSelf(ro.get());
            }
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            List<Block> all = new ArrayList<>();
            for (RegistryObject<Block> ro : ModBlocks.BLOCKS.getEntries()) {
                all.add(ro.get());
            }
            return all;
        }
    }
}
