package gwydion0917.gwycraft;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

/**
 * Mod configuration using ForgeConfigSpec (replaces the 1.12 net.minecraftforge.common.config.Configuration).
 * Values are read at runtime via .get() — never cache them at class-load time.
 */
public class ConfigGwycraft {

    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue GEN_GEMS_ENABLED;
    public static final ForgeConfigSpec.BooleanValue GEN_GEMS_NETHER;
    public static final ForgeConfigSpec.IntValue    GEN_GEMS_VEINS;
    public static final ForgeConfigSpec.IntValue    GEN_GEMS_NUMBER;
    public static final ForgeConfigSpec.BooleanValue TOOLS_ENABLED;
    public static final ForgeConfigSpec.BooleanValue TOOLS_HAVE_ENCHANTS;
    public static final ForgeConfigSpec.BooleanValue GEMS_CRAFTING_ENABLED;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

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

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }
}
