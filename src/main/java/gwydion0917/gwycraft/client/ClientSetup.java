package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.blocks.ITintedGwyBlock;
import gwydion0917.gwycraft.registration.ModBlocks;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Client-only setup — registers the config screen and block/item color handlers
 * for tinted blocks. Render layers are declared via "render_type" in the block
 * model JSONs (the modern replacement for ItemBlockRenderTypes.setRenderLayer).
 */
public class ClientSetup {

    /** Called from the mod constructor when running on the client dist. */
    public static void registerModBusListeners(IEventBus modBus, ModContainer container) {
        // NeoForge's built-in ConfigurationScreen auto-generates a config UI from ModConfigSpec
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modBus.addListener(ClientSetup::registerBlockColors);
        modBus.addListener(ClientSetup::registerItemColors);
    }

    // ── Tinted block color handlers ──────────────────────────────────────────

    /**
     * Collect every GwyTintedBlock instance from all registered tinted families.
     * Add new families here as they are implemented.
     */
    @SafeVarargs
    private static Block[] allTintedBlocks(Map<DyeColor, DeferredHolder<Block, Block>>... families) {
        List<Block> blocks = new ArrayList<>();
        for (Map<DyeColor, DeferredHolder<Block, Block>> family : families) {
            for (DeferredHolder<Block, Block> ro : family.values()) {
                blocks.add(ro.get());
            }
        }
        return blocks.toArray(new Block[0]);
    }

    private static int tintColor(DyeColor c) {
        // 1.20.5+: DyeColor exposes a packed ARGB int directly
        return 0xFF000000 | c.getTextureDiffuseColor();
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
}
