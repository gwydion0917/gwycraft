package gwydion0917.gwycraft;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigGwycraft {

	public static Configuration config;

	// General Settings
	public static boolean genGemsEnabled = true;
	public static boolean genGemsNether = true;
	public static boolean toolsEnabled = true;
	public static boolean toolsHaveEnchants = true;
	public static boolean gemsCraftingEnabled = true;
	public static int genGemsVeins = 15; // was 9
	public static int genGemsNumber = 7; // was 5

	public static void initConfig(FMLPreInitializationEvent event) {

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		syncConfig();

	}

	public static void syncConfig() {
		genGemsEnabled = config.getBoolean("genGemsEnabled", Configuration.CATEGORY_GENERAL, true, "Should gems generate in the world");
		genGemsNether = config.getBoolean("genGemsNether", Configuration.CATEGORY_GENERAL, true, "Should gems generate in the nether");
		genGemsVeins = config.getInt("genGemsVeins", Configuration.CATEGORY_GENERAL, 15, 0, 256, "Attempt to generate X veins per chunk");
		genGemsNumber = config.getInt("genGemsNumber", Configuration.CATEGORY_GENERAL, 7, 0, 256, "Attemp to generate X ores per vein");
		toolsEnabled = config.getBoolean("toolsEnabled", Configuration.CATEGORY_GENERAL, true, "Should gem tools be craftable");
		toolsHaveEnchants = config.getBoolean("toolsHaveEnchants", Configuration.CATEGORY_GENERAL, true, "Should gem tools have enchants");
		gemsCraftingEnabled = config.getBoolean("gemsCraftingEnabled", Configuration.CATEGORY_GENERAL, true, "Should gems be craftable");

		if (config.hasChanged()) {
			config.save();
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equalsIgnoreCase("gwycraft")) {
			syncConfig();
		}
	}

}
