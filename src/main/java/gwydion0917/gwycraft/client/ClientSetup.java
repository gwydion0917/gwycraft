package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.blocks.ITintedGwyBlock;
import gwydion0917.gwycraft.registration.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Client-only setup — sets render layers for transparent/non-opaque blocks
 * and registers block/item color handlers for tinted blocks.
 */
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (mc, screen) -> new ConfigScreen(screen)));

        event.enqueueWork(ClientSetup::setRenderLayers);
    }

    // ── Tinted block color handlers ──────────────────────────────────────────

    /**
     * Collect every GwyTintedBlock instance from all registered tinted families.
     * Add new families here as they are implemented.
     */
    @SafeVarargs
    private static Block[] allTintedBlocks(Map<DyeColor, RegistryObject<Block>>... families) {
        List<Block> blocks = new ArrayList<>();
        for (Map<DyeColor, RegistryObject<Block>> family : families) {
            for (RegistryObject<Block> ro : family.values()) {
                blocks.add(ro.get());
            }
        }
        return blocks.toArray(new Block[0]);
    }

    private static int tintColor(DyeColor c) {
        float[] rgb = c.getTextureDiffuseColors();
        return 0xFF000000
                | ((int) (rgb[0] * 255) << 16)
                | ((int) (rgb[1] * 255) << 8)
                | (int) (rgb[2] * 255);
    }

    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, level, pos, tintIndex) -> {
                    if (state.getBlock() instanceof ITintedGwyBlock t) {
                        return tintColor(t.getDyeColor());
                    }
                    return -1;
                },
                allTintedBlocks(
                        ModBlocks.PLAIN_GREEK_BOTTOM,
                        ModBlocks.PLAIN_GREEK_PILLAR,
                        ModBlocks.PLAIN_GREEK_TOP,
                        ModBlocks.PLAIN_PILLAR_BOTTOM,
                        ModBlocks.PLAIN_PILLAR,
                        ModBlocks.PLAIN_PILLAR_TOP,
                        ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM,
                        ModBlocks.PLAIN_WIDE_PILLAR,
                        ModBlocks.PLAIN_WIDE_PILLAR_TOP,
                        ModBlocks.GREEK_PILLAR_BOTTOM,
                        ModBlocks.GREEK_PILLAR_TOP,
                        ModBlocks.GREEK_WIDE_PILLAR_BOTTOM,
                        ModBlocks.GREEK_WIDE_PILLAR_TOP,
                        ModBlocks.GREEK2_PILLAR_BOTTOM,
                        ModBlocks.GREEK2_PILLAR_TOP,
                        ModBlocks.PLAIN_SLAB,
                        ModBlocks.GREEK_SLAB,
                        ModBlocks.FANCY_BOTTOM,
                        ModBlocks.FANCY_TOP,
                        ModBlocks.FANCY_GREEK_BOTTOM,
                        ModBlocks.FANCY_GREEK_TOP,
                        ModBlocks.FANCY_WIDE_BOTTOM,
                        ModBlocks.FANCY_WIDE_TOP,
                        ModBlocks.FANCY_SLAB,
                        ModBlocks.GLOWY_PLAIN_GREEK_BOTTOM,
                        ModBlocks.GLOWY_PLAIN_GREEK_PILLAR,
                        ModBlocks.GLOWY_PLAIN_GREEK_TOP,
                        ModBlocks.GLOWY_PLAIN_PILLAR_BOTTOM,
                        ModBlocks.GLOWY_PLAIN_PILLAR,
                        ModBlocks.GLOWY_PLAIN_PILLAR_TOP,
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_BOTTOM,
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR,
                        ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_TOP,
                        ModBlocks.GLOWY_GREEK_PILLAR_BOTTOM,
                        ModBlocks.GLOWY_GREEK_PILLAR_TOP,
                        ModBlocks.GLOWY_GREEK_WIDE_PILLAR_BOTTOM,
                        ModBlocks.GLOWY_GREEK_WIDE_PILLAR_TOP,
                        ModBlocks.GLOWY_GREEK2_PILLAR_BOTTOM,
                        ModBlocks.GLOWY_GREEK2_PILLAR_TOP,
                        ModBlocks.GLOWY_PLAIN_SLAB,
                        ModBlocks.GLOWY_GREEK_SLAB,
                        ModBlocks.GLOWY_FANCY_BOTTOM,
                        ModBlocks.GLOWY_FANCY_TOP,
                        ModBlocks.GLOWY_FANCY_GREEK_BOTTOM,
                        ModBlocks.GLOWY_FANCY_GREEK_TOP,
                        ModBlocks.GLOWY_FANCY_WIDE_BOTTOM,
                        ModBlocks.GLOWY_FANCY_WIDE_TOP,
                        ModBlocks.GLOWY_FANCY_SLAB
                )
        );
    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        for (DyeColor c : DyeColor.values()) {
            int color = tintColor(c);
            event.register(
                    (stack, tintIndex) -> color,
                    ModBlocks.PLAIN_GREEK_BOTTOM.get(c).get().asItem(),
                    ModBlocks.PLAIN_GREEK_PILLAR.get(c).get().asItem(),
                    ModBlocks.PLAIN_GREEK_TOP.get(c).get().asItem(),
                    ModBlocks.PLAIN_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.PLAIN_PILLAR.get(c).get().asItem(),
                    ModBlocks.PLAIN_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.PLAIN_WIDE_PILLAR.get(c).get().asItem(),
                    ModBlocks.PLAIN_WIDE_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GREEK_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GREEK_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GREEK_WIDE_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GREEK_WIDE_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GREEK2_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GREEK2_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.PLAIN_SLAB.get(c).get().asItem(),
                    ModBlocks.GREEK_SLAB.get(c).get().asItem(),
                    ModBlocks.FANCY_BOTTOM.get(c).get().asItem(),
                    ModBlocks.FANCY_TOP.get(c).get().asItem(),
                    ModBlocks.FANCY_GREEK_BOTTOM.get(c).get().asItem(),
                    ModBlocks.FANCY_GREEK_TOP.get(c).get().asItem(),
                    ModBlocks.FANCY_WIDE_BOTTOM.get(c).get().asItem(),
                    ModBlocks.FANCY_WIDE_TOP.get(c).get().asItem(),
                    ModBlocks.FANCY_SLAB.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_GREEK_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_GREEK_PILLAR.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_GREEK_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_PILLAR.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_WIDE_PILLAR.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK_WIDE_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK_WIDE_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK2_PILLAR_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK2_PILLAR_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_PLAIN_SLAB.get(c).get().asItem(),
                    ModBlocks.GLOWY_GREEK_SLAB.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_GREEK_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_GREEK_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_WIDE_BOTTOM.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_WIDE_TOP.get(c).get().asItem(),
                    ModBlocks.GLOWY_FANCY_SLAB.get(c).get().asItem()
            );
        }
    }

    // ── Render layers ────────────────────────────────────────────────────────

    private static void setRenderLayers() {
        // Glass → translucent (alpha=128 center pixels need real transparency)
        for (RegistryObject<Block> ro : ModBlocks.DYED_GLASS.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.translucent());
        }
        for (RegistryObject<Block> ro : ModBlocks.GLOWY_DYED_GLASS.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.translucent());
        }

        // Leaves → cutout_mipped (mipmapped transparency)
        for (RegistryObject<Block> ro : ModBlocks.DYED_LEAF.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.cutoutMipped());
        }
        for (RegistryObject<Block> ro : ModBlocks.GLOWY_DYED_LEAF.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.cutoutMipped());
        }

        // Torches → cutout
        for (RegistryObject<Block> ro : ModBlocks.TORCH.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.cutout());
        }
        for (RegistryObject<Block> ro : ModBlocks.WALL_TORCH.values()) {
            ItemBlockRenderTypes.setRenderLayer(ro.get(), RenderType.cutout());
        }
    }
}
