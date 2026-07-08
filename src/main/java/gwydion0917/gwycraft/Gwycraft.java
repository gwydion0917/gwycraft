package gwydion0917.gwycraft;

import gwydion0917.gwycraft.client.ClientSetup;
import gwydion0917.gwycraft.data.GwycraftDataGen;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import gwydion0917.gwycraft.worldgen.GemOreBiomeModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Main mod class for GwyCraft 1.21.1 (NeoForge).
 * The @Mod constructor now receives the mod event bus and ModContainer directly;
 * FMLJavaModLoadingContext is gone. DistExecutor is deprecated - client-only
 * listeners are gated on FMLEnvironment.dist instead.
 */
@Mod(Gwycraft.MOD_ID)
public class Gwycraft {

    public static final String MOD_ID = "gwycraft";
    public static final String MOD_NAME = "GwyCraft";

    // Creative-mode tab registry
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = TABS.register("gwycraft",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.gwycraft"))
                    .icon(() -> new ItemStack(ModBlocks.COMPRESSED_GEM
                            .get(EnumGemType.QUARTZ).get()))
                    .displayItems((params, output) ->
                            ModItems.ITEMS.getEntries().forEach(h -> output.accept(h.get())))
                    .build());

    public Gwycraft(IEventBus modBus, ModContainer container) {
        // Register config (COMMON type -> gwycraft-common.toml)
        ConfigGwycraft.register(container);

        // Register DeferredRegisters
        TABS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);

        // Worldgen: codec serializer for our custom BiomeModifier
        GemOreBiomeModifier.MODIFIER_SERIALIZERS.register(modBus);

        // Lifecycle hooks on the mod bus
        modBus.addListener(GwycraftDataGen::gatherData);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientSetup.registerModBusListeners(modBus, container);
        }

        // Game event bus (player events only - worldgen is handled by BiomeModifier)
        NeoForge.EVENT_BUS.register(GwycraftPlayerEvents.class);
    }
}
