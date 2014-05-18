package gwydion0917.gwycraft;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigGwycraft {

    // General Settings
	public static boolean genGemsEnabled = true;
	public static int genGemsVeins = 15; //was 9
	public static int genGemsNumber = 7; //was 5

	public static void initConfig(FMLPreInitializationEvent event) {

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();
		
// General Section
		Property genGemsEnabledProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsEnabled", true);
		genGemsEnabledProperty.comment = "Should gems generate in the world";
		genGemsEnabled = genGemsEnabledProperty.getBoolean(true);
		
		Property genGemsVeinsProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsVeins", 15);
		genGemsVeinsProperty.comment = "Attempt to generate X veins per chunk";
		genGemsVeins = genGemsVeinsProperty.getInt(8);
		
		Property genGemsNumberProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsNumber", 7);
		genGemsNumberProperty.comment = "Attemp to generate X ores per vein";
		genGemsNumber = genGemsNumberProperty.getInt(4);
		
		if (config.hasChanged()) {
			config.save();
		}
	}
}
