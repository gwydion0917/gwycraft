package gwydion0917.gwycraft.client;

import net.minecraftforge.fml.client.DefaultGuiFactory;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

public class GwyCraftGuiFactory extends DefaultGuiFactory {
    protected GwyCraftGuiFactory(String modid, String title) {
        super(modid, title);
    }
}
