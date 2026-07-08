package gwydion0917.gwycraft.worldgen;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Data generator for GwyCraft worldgen data (ConfiguredFeatures, PlacedFeatures,
 * and the biome_modifier JSON).
 * Output: data/gwycraft/worldgen/ + data/gwycraft/forge/biome_modifier/
 */
public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModWorldGen::bootstrapConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, ModWorldGen::bootstrapPlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModWorldGenProvider::bootstrapBiomeModifiers);

    public ModWorldGenProvider(PackOutput output,
                               CompletableFuture<net.minecraft.core.HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Gwycraft.MOD_ID));
    }

    /**
     * Bootstrap the single biome_modifier entry that references all gem ore placed features.
     * The modifier checks config at world-load time; the JSON just wires the feature sets.
     */
    private static void bootstrapBiomeModifiers(
            net.minecraft.data.worldgen.BootstrapContext<BiomeModifier> ctx) {
        var pfLookup = ctx.lookup(Registries.PLACED_FEATURE);

        // Collect overworld and nether holders
        var overworldHolders = new java.util.ArrayList<net.minecraft.core.Holder<net.minecraft.world.level.levelgen.placement.PlacedFeature>>();
        var netherHolders    = new java.util.ArrayList<net.minecraft.core.Holder<net.minecraft.world.level.levelgen.placement.PlacedFeature>>();

        for (EnumGemType gem : EnumGemType.values()) {
            overworldHolders.add(pfLookup.getOrThrow(ModWorldGen.PF_OVERWORLD.get(gem)));
            netherHolders.add(   pfLookup.getOrThrow(ModWorldGen.PF_NETHER.get(gem)));
        }

        ctx.register(
                net.minecraft.resources.ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                        ResourceLocation.fromNamespaceAndPath(Gwycraft.MOD_ID, "add_gem_ores")),
                new GemOreBiomeModifier(
                        HolderSet.direct(overworldHolders),
                        HolderSet.direct(netherHolders)
                )
        );
    }

    @Override
    public String getName() {
        return "GwyCraft WorldGen";
    }
}
