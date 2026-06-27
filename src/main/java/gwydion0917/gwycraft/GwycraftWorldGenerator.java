package gwydion0917.gwycraft;

import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Ore worldgen using the 1.16.5 BiomeLoadingEvent / ConfiguredFeature API.
 * Replaces the 1.12 IWorldGenerator + GameRegistry.registerWorldGenerator.
 *
 * Config values are read at biome-load time (each world), so they reflect
 * the current config without restarting the game.
 */
@Mod.EventBusSubscriber(modid = Gwycraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GwycraftWorldGenerator {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        Biome.Category cat = event.getCategory();
        if (cat == Biome.Category.THEEND) return;

        boolean isNether = cat == Biome.Category.NETHER;

        if (isNether && !ConfigGwycraft.GEN_GEMS_NETHER.get()) return;
        if (!isNether && !ConfigGwycraft.GEN_GEMS_ENABLED.get()) return;

        int veinSize  = ConfigGwycraft.GEN_GEMS_NUMBER.get();
        int veinCount = ConfigGwycraft.GEN_GEMS_VEINS.get();

        RuleTest filler = isNether
                ? new BlockMatchRuleTest(Blocks.NETHERRACK)
                : OreFeatureConfig.FillerBlockType.NATURAL_STONE;

        for (EnumGemType gem : EnumGemType.values()) {
            Block oreBlock = ModBlocks.GEM_ORE.get(gem).get();
            event.getGeneration()
                    .getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(() -> Feature.ORE
                            .configured(new OreFeatureConfig(filler, oreBlock.defaultBlockState(), veinSize))
                            .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 64)))
                            .squared()
                            .count(veinCount));
        }
    }
}
