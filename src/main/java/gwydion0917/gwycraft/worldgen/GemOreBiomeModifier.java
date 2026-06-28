package gwydion0917.gwycraft.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.Gwycraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Custom Forge BiomeModifier that adds gem ore features to biomes at world load.
 * Reads ConfigGwycraft enable/nether toggles at world-load time, preserving runtime config.
 * The codec carries two HolderSet<PlacedFeature> fields — overworld and nether variants.
 * The biome_modifier JSON (written by ModWorldGenProvider) specifies all 16 feature IDs.
 * Biome.Category is gone in 1.20; nether/end detection uses biome tags.
 */
public record GemOreBiomeModifier(
        HolderSet<PlacedFeature> overworldFeatures,
        HolderSet<PlacedFeature> netherFeatures
) implements BiomeModifier {

    // ── Codec + DeferredRegister ──────────────────────────────────────────────

    public static final Codec<GemOreBiomeModifier> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    PlacedFeature.LIST_CODEC.fieldOf("overworld_features")
                            .forGetter(GemOreBiomeModifier::overworldFeatures),
                    PlacedFeature.LIST_CODEC.fieldOf("nether_features")
                            .forGetter(GemOreBiomeModifier::netherFeatures)
            ).apply(instance, GemOreBiomeModifier::new));

    public static final DeferredRegister<Codec<? extends BiomeModifier>> MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Gwycraft.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<Codec<? extends BiomeModifier>> CODEC_ENTRY =
            MODIFIER_SERIALIZERS.register("gem_ore_biome_modifier", () -> CODEC);

    // ── BiomeModifier implementation ──────────────────────────────────────────

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase != Phase.ADD) return;

        boolean isNether = biome.is(BiomeTags.IS_NETHER);
        boolean isEnd    = biome.is(BiomeTags.IS_END);

        if (isEnd) return;

        if (isNether) {
            if (!ConfigGwycraft.GEN_GEMS_NETHER.get()) return;
            for (Holder<PlacedFeature> feature : netherFeatures) {
                builder.getGenerationSettings().addFeature(
                        GenerationStep.Decoration.UNDERGROUND_ORES, feature);
            }
        } else {
            if (!ConfigGwycraft.GEN_GEMS_ENABLED.get()) return;
            for (Holder<PlacedFeature> feature : overworldFeatures) {
                builder.getGenerationSettings().addFeature(
                        GenerationStep.Decoration.UNDERGROUND_ORES, feature);
            }
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}
