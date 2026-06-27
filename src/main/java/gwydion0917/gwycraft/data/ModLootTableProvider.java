package gwydion0917.gwycraft.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.*;
import java.util.function.*;

/**
 * Block loot table generator for GwyCraft 1.16.5.
 * BlockLootTables is in net.minecraft.data.loot (not net.minecraft.data).
 */
public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(DataGenerator gen) {
        super(gen);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>,
            LootParameterSet>> getTables() {
        Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet> pair =
                Pair.of(GwycraftBlockLoot::new, LootParameterSets.BLOCK);
        return ImmutableList.of(pair);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker tracker) {
        map.forEach((loc, table) -> LootTableManager.validate(tracker, loc, table));
    }

    // ── Inner block loot table class ─────────────────────────────────────────

    public static class GwycraftBlockLoot extends BlockLootTables {

        @Override
        protected void addTables() {
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
            selfDropDyeMap(ModBlocks.DYED_BOOKCASE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_BOOKCASE);
            selfDropDyeMap(ModBlocks.DYED_BRICK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_BRICK);
            selfDropDyeMap(ModBlocks.DYED_BRICK_PAVER);
            selfDropDyeMap(ModBlocks.DYED_CLAY);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_CLAY);
            selfDropDyeMap(ModBlocks.DYED_GLASS);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_GLASS);
            selfDropDyeMap(ModBlocks.DYED_LEAF);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_LEAF);
            selfDropDyeMap(ModBlocks.DYED_MUD_BRICK);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_MUD_BRICK);
            selfDropDyeMap(ModBlocks.DYED_MUD_BRICK_PAVER);
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
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_COBBLESTONE);
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE_PAVER);
            selfDropDyeMap(ModBlocks.DYED_COBBLESTONE_WALL);
            selfDropDyeMap(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL);

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
