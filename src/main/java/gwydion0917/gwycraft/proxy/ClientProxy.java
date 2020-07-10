package gwydion0917.gwycraft.proxy;

import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import gwydion0917.gwycraft.GwycraftItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		GwycraftBlocks.registerRenders();
		//GwycraftItems.registerBlockRenders();
	}
}