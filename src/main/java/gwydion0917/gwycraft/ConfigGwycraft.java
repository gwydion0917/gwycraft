package gwydion0917.gwycraft;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Mod configuration using ModConfigSpec (NeoForge rename of ForgeConfigSpec).
 * Values are read at runtime via .get() - never cache them at class-load time.
 */
public class ConfigGwycraft {

    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue GEN_GEMS_ENABLED;
    public static final ModConfigSpec.BooleanValue GEN_GEMS_NETHER;
    public static final ModConfigSpec.IntValue    GEN_GEMS_VEINS;
    public static final ModConfigSpec.IntValue    GEN_GEMS_NUMBER;
    public static final ModConfigSpec.BooleanValue TOOLS_ENABLED;
    public static final ModConfigSpec.BooleanValue TOOLS_HAVE_ENCHANTS;
    public static final ModConfigSpec.BooleanValue GEMS_CRAFTING_ENABLED;

    static {
        ModConfigSpec.Builder b = new ModConfigSpec.Builder();

        b.comment("GwyCraft general settings").push("general");
        GEN_GEMS_ENABLED     = b.comment("Should enchanted gem ores generate in the overworld").define("genGemsEnabled", true);
        GEN_GEMS_NETHER      = b.comment("Should enchanted gem ores generate in the nether").define("genGemsNether", true);
        GEN_GEMS_VEINS       = b.comment("Ore vein attempts per chunk").defineInRange("genGemsVeins", 15, 0, 256);
        GEN_GEMS_NUMBER      = b.comment("Blocks per vein attempt").defineInRange("genGemsNumber", 7, 0, 256);
        TOOLS_ENABLED        = b.comment("Should gem tools have crafting recipes").define("toolsEnabled", true);
        TOOLS_HAVE_ENCHANTS  = b.comment("Should gem tools be enchanted when crafted").define("toolsHaveEnchants", true);
        GEMS_CRAFTING_ENABLED = b.comment("Should gems themselves be craftable (dye + glowstone + diamond)").define("gemsCraftingEnabled", true);
        b.pop();

        SPEC = b.build();
    }

    public static void register(ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
