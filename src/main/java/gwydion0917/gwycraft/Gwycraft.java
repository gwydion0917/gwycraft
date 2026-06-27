package gwydion0917.gwycraft;

import gwydion0917.gwycraft.client.ClientSetup;
import gwydion0917.gwycraft.data.GwycraftDataGen;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import gwydion0917.gwycraft.setup.CommonSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main mod class for GwyCraft 1.16.5.
 *
 * Replaces the 1.12 @SidedProxy / @EventHandler / FMLCommonHandler pattern
 * with constructor-based DeferredRegister and event-bus listeners.
 */
@Mod(Gwycraft.MOD_ID)
public class Gwycraft {

    public static final String MOD_ID = "gwycraft";
    public static final String MOD_NAME = "GwyCraft";

    /** Creative tab — icon is the quartz compressed gem block. */
    public static final ItemGroup TAB = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.COMPRESSED_GEM
                    .get(gwydion0917.gwycraft.enums.EnumGemType.QUARTZ).get());
        }
    };

    public Gwycraft() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register config (COMMON type → gwycraft-common.toml)
        ConfigGwycraft.register();

        // Register DeferredRegisters (blocks first, items second — order matters)
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);

        // Lifecycle hooks on the mod bus
        modBus.addListener(CommonSetup::init);
        modBus.addListener(GwycraftDataGen::gatherData);
        DistExecutor.unsafeRunWhenOn(net.minecraftforge.api.distmarker.Dist.CLIENT,
                () -> () -> modBus.addListener(ClientSetup::init));

        // Forge event bus (player events, worldgen biome loading)
        MinecraftForge.EVENT_BUS.register(GwycraftPlayerEvents.class);
        MinecraftForge.EVENT_BUS.register(GwycraftWorldGenerator.class);
    }
}
