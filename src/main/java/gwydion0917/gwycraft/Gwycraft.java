package gwydion0917.gwycraft;

import gwydion0917.gwycraft.client.ClientSetup;
import gwydion0917.gwycraft.data.GwycraftDataGen;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import gwydion0917.gwycraft.setup.CommonSetup;
import gwydion0917.gwycraft.worldgen.GemOreBiomeModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * Main mod class for GwyCraft 1.20.1.
 * Creative tabs are now a registry (changed in 1.19.3).
 * ItemGroup / Item.Properties.tab() are gone; items join the tab via
 * BuildCreativeModeTabContentsEvent listener (see ModItems.buildCreativeTab).
 */
@Mod(Gwycraft.MOD_ID)
public class Gwycraft {

    public static final String MOD_ID = "gwycraft";
    public static final String MOD_NAME = "GwyCraft";

    // Creative-mode tab registry — replaces the old ItemGroup anonymous class
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("gwycraft",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.gwycraft"))
                    .icon(() -> new ItemStack(ModBlocks.COMPRESSED_GEM
                            .get(EnumGemType.QUARTZ).get()))
                    .displayItems((params, output) -> {
                        // Content populated via BuildCreativeModeTabContentsEvent in ModItems
                    })
                    .build());

    public Gwycraft() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register config (COMMON type → gwycraft-common.toml)
        ConfigGwycraft.register();

        // Register DeferredRegisters
        TABS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);

        // Worldgen: codec serializer for our custom BiomeModifier
        GemOreBiomeModifier.MODIFIER_SERIALIZERS.register(modBus);

        // Lifecycle hooks on the mod bus
        modBus.addListener(CommonSetup::init);
        modBus.addListener(GwycraftDataGen::gatherData);
        modBus.addListener(ModItems::buildCreativeTab);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            modBus.addListener(ClientSetup::init);
            modBus.addListener(ClientSetup::registerBlockColors);
            modBus.addListener(ClientSetup::registerItemColors);
        });

        // Forge event bus (player events only — worldgen is now handled by BiomeModifier)
        MinecraftForge.EVENT_BUS.register(GwycraftPlayerEvents.class);
    }
}
