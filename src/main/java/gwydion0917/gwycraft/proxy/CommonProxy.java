package gwydion0917.gwycraft.proxy;

import java.io.File;

import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
public class CommonProxy implements IGuiHandler {
	protected static Logger log;

	public File getMinecraftDir() {
		return new File(".");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	// Client stuff
	public void registerRenderers() {
		// Nothing here as this is the server side proxy
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		//log.info("** proxy.registerBlocks");
		GwycraftBlocks.registerBlocks(event);
	}

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GwycraftBlocks.registerItems(event);
    }
}
