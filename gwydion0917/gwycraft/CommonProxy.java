package gwydion0917.gwycraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	public static String BLOCKS_PNG = "gwydion0917/mods/GwyCraft/res/blocks.png";
	public static String ITEMS_PNG = "gwydion0917/mods/GwyCraft/res/items.png";

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	// Client stuff
	public static void registerRenderers() {
		// Nothing here as this is the server side proxy
	}

}
