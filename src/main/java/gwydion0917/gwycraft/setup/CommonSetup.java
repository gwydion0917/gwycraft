package gwydion0917.gwycraft.setup;

import gwydion0917.gwycraft.InterModCommunication;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * Server/common setup — runs on both client and server during mod loading.
 * Replaces the 1.12 FMLInitializationEvent handler.
 */
public class CommonSetup {
    public static void init(FMLCommonSetupEvent event) {
        // IMC (inter-mod communication) is best sent in an enqueue step
        event.enqueueWork(InterModCommunication::sendMessages);
    }
}
