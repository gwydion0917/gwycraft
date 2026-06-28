package gwydion0917.gwycraft.worldgen;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Registry keys and bootstrap for GwyCraft ore ConfiguredFeatures and PlacedFeatures.
 * Datagen provider: ModWorldGenProvider.
 * Vein size = 7 (former GEN_GEMS_NUMBER default).
 * Vein count = 15 (former GEN_GEMS_VEINS default).
 * These are baked into the placed features; the BiomeModifier reads the
 * enable/nether config toggles at world-load time.
 */
public class ModWorldGen {

    // Default ore parameters matching the old config defaults
    public static final int VEIN_SIZE = 7;
    public static final int VEIN_COUNT = 15;

    // ── ResourceKey maps ─────────────────────────────────────────────────────

    /** ConfiguredFeature keys — one per gem, overworld (stone) version. */
    public static final Map<EnumGemType, ResourceKey<ConfiguredFeature<?, ?>>> CF_OVERWORLD =
            new EnumMap<>(EnumGemType.class);
    /** ConfiguredFeature keys — one per gem, nether (netherrack) version. */
    public static final Map<EnumGemType, ResourceKey<ConfiguredFeature<?, ?>>> CF_NETHER =
            new EnumMap<>(EnumGemType.class);
    /** PlacedFeature keys — one per gem, overworld. */
    public static final Map<EnumGemType, ResourceKey<PlacedFeature>> PF_OVERWORLD =
            new EnumMap<>(EnumGemType.class);
    /** PlacedFeature keys — one per gem, nether. */
    public static final Map<EnumGemType, ResourceKey<PlacedFeature>> PF_NETHER =
            new EnumMap<>(EnumGemType.class);

    static {
        for (EnumGemType gem : EnumGemType.values()) {
            String name = gem.getName();
            CF_OVERWORLD.put(gem, cfKey("ore_gem_" + name + "_overworld"));
            CF_NETHER.put(gem,    cfKey("ore_gem_" + name + "_nether"));
            PF_OVERWORLD.put(gem, pfKey("ore_gem_" + name + "_overworld"));
            PF_NETHER.put(gem,    pfKey("ore_gem_" + name + "_nether"));
        }
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> cfKey(String path) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(Gwycraft.MOD_ID, path));
    }

    private static ResourceKey<PlacedFeature> pfKey(String path) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(Gwycraft.MOD_ID, path));
    }

    // ── Bootstrap methods (called by DatapackBuiltinEntriesProvider) ──────────

    public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> ctx) {
        RuleTest stoneRule    = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherRule   = new BlockMatchTest(Blocks.NETHERRACK);

        for (EnumGemType gem : EnumGemType.values()) {
            BlockState oreState = ModBlocks.GEM_ORE.get(gem).get().defaultBlockState();

            // Overworld: replaces stone or deepslate
            List<OreConfiguration.TargetBlockState> overworldTargets = List.of(
                    OreConfiguration.target(stoneRule, oreState),
                    OreConfiguration.target(deepSlateRule, oreState)
            );
            ctx.register(CF_OVERWORLD.get(gem),
                    new ConfiguredFeature<>(Feature.ORE,
                            new OreConfiguration(overworldTargets, VEIN_SIZE)));

            // Nether: replaces netherrack
            ctx.register(CF_NETHER.get(gem),
                    new ConfiguredFeature<>(Feature.ORE,
                            new OreConfiguration(netherRule, oreState, VEIN_SIZE)));
        }
    }

    public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> ctx) {
        HolderGetter<ConfiguredFeature<?, ?>> cfLookup =
                ctx.lookup(Registries.CONFIGURED_FEATURE);

        for (EnumGemType gem : EnumGemType.values()) {
            // Overworld: uniform 0..64
            ctx.register(PF_OVERWORLD.get(gem), new PlacedFeature(
                    cfLookup.getOrThrow(CF_OVERWORLD.get(gem)),
                    List.of(
                            CountPlacement.of(VEIN_COUNT),
                            InSquarePlacement.spread(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(0),
                                    VerticalAnchor.absolute(64)),
                            BiomeFilter.biome()
                    )
            ));

            // Nether: uniform 0..120
            ctx.register(PF_NETHER.get(gem), new PlacedFeature(
                    cfLookup.getOrThrow(CF_NETHER.get(gem)),
                    List.of(
                            CountPlacement.of(VEIN_COUNT),
                            InSquarePlacement.spread(),
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.absolute(0),
                                    VerticalAnchor.absolute(120)),
                            BiomeFilter.biome()
                    )
            ));
        }
    }
}
