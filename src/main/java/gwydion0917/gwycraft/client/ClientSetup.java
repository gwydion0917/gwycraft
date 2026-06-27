package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.blocks.GwyGlassBlock;
import gwydion0917.gwycraft.blocks.GwyLeafBlock;
import gwydion0917.gwycraft.registration.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.DyeColor;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.RegistryObject;

/**
 * Client-only setup — sets render layers for transparent/non-opaque blocks.
 * Replaces the old @SideOnly proxy and BlockGlass.setBlockLayer calls.
 */
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        ModLoadingContext.get().registerExtensionPoint(
            ExtensionPoint.CONFIGGUIFACTORY,
            () -> (mc, screen) -> new ConfigScreen(screen)
        );
        event.enqueueWork(() -> setRenderLayers());
    }

    private static void setRenderLayers() {
        // Glass → cutout (so panes look correct)
        for (RegistryObject<Block> ro : ModBlocks.DYED_GLASS.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutout());
        }
        for (RegistryObject<Block> ro : ModBlocks.GLOWY_DYED_GLASS.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutout());
        }

        // Leaves → cutout_mipped (mipmapped transparency)
        for (RegistryObject<Block> ro : ModBlocks.DYED_LEAF.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutoutMipped());
        }
        for (RegistryObject<Block> ro : ModBlocks.GLOWY_DYED_LEAF.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutoutMipped());
        }

        // Torches → cutout
        for (RegistryObject<Block> ro : ModBlocks.TORCH.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutout());
        }
        for (RegistryObject<Block> ro : ModBlocks.WALL_TORCH.values()) {
            RenderTypeLookup.setRenderLayer(ro.get(), RenderType.cutout());
        }
    }
}
