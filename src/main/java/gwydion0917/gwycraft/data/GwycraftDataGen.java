package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.worldgen.ModWorldGenProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

/**
 * Entry point for all GwyCraft data generators (1.20.1).
 * Key changes from 1.16.5:
 * - addProvider(boolean run, DataProvider) — run flag replaces includeServer/Client guard
 * - Providers take PackOutput (not DataGenerator) + optional CompletableFuture<HolderLookup.Provider>
 * - WorldGen data added via DatapackBuiltinEntriesProvider (ModWorldGenProvider)
 */
public class GwycraftDataGen {

    public static void gatherData(GatherDataEvent event) {
        var gen    = event.getGenerator();
        var output = gen.getPackOutput();
        var lookup = event.getLookupProvider();
        ExistingFileHelper efh = event.getExistingFileHelper();

        // Server-side providers
        gen.addProvider(event.includeServer(), new ModRecipeProvider(output, lookup));
        gen.addProvider(event.includeServer(), new ModLootTableProvider(output, lookup));

        var blockTagsProv = new ModTagsProvider.GwycraftBlockTags(output, lookup, efh);
        gen.addProvider(event.includeServer(), blockTagsProv);
        gen.addProvider(event.includeServer(),
                new ModTagsProvider.GwycraftItemTags(output, lookup, blockTagsProv.contentsGetter(), efh));

        // WorldGen data (ConfiguredFeatures, PlacedFeatures, BiomeModifier)
        gen.addProvider(event.includeServer(), new ModWorldGenProvider(output, lookup));

        // Client-side providers
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, efh));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, efh));
        gen.addProvider(event.includeClient(), new ModLanguageProvider(output));
    }
}
