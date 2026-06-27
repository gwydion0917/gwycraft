package gwydion0917.gwycraft.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.DefaultGuiFactory;

public class GwyCraftGuiFactory extends DefaultGuiFactory {
    public GwyCraftGuiFactory() {
        super("gwycraft", "GwyCraft Configuration");
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GwyCraftConfigGUI(parentScreen);
    }
}
