package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GwyCraftConfigGUI extends GuiConfig {
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public GwyCraftConfigGUI(GuiScreen parent) {
	        super(parent,
	                new ConfigElement(ConfigGwycraft.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
	                "gwycraft", false, false, GuiConfig.getAbridgedConfigPath(ConfigGwycraft.config.toString()));
	    }
}
