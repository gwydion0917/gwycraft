package gwydion0917.gwycraft.registration;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

/**
 * All item registrations for GwyCraft 1.20.1.
 * Block items are registered here with the same name as their block.
 * Standalone items (gems, dyed clay/mud/sticks, tools) are also here.
 * Tab assignment is handled by buildCreativeTab() via BuildCreativeModeTabContentsEvent
 * (Item.Properties.tab() was removed in 1.19.3).
 */
public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Gwycraft.MOD_ID);

    // ── Common properties ────────────────────────────────────────────────────

    private static Item.Properties blockItemProps() {
        return new Item.Properties();
    }

    // ── Block item helpers ───────────────────────────────────────────────────

    /** Register BlockItems for every entry in a block family map. */
    private static <K extends Enum<K>> void registerBlockItems(
            Map<K, RegistryObject<net.minecraft.world.level.block.Block>> family) {
        for (Map.Entry<K, RegistryObject<net.minecraft.world.level.block.Block>> e : family.entrySet()) {
            RegistryObject<net.minecraft.world.level.block.Block> ro = e.getValue();
            ITEMS.register(ro.getId().getPath(),
                    () -> new BlockItem(ro.get(), blockItemProps()));
        }
    }

    // ── Torch items (one item per color places floor OR wall block) ───────────

    public static final Map<DyeColor, RegistryObject<Item>> TORCH_ITEMS =
            new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor c : DyeColor.values()) {
            RegistryObject<net.minecraft.world.level.block.Block> floorRO = ModBlocks.TORCH.get(c);
            RegistryObject<net.minecraft.world.level.block.Block> wallRO  = ModBlocks.WALL_TORCH.get(c);
            String name = "torch_" + c.getName();
            RegistryObject<Item> item = ITEMS.register(name, () ->
                    new GwyTorchItem(floorRO.get(), wallRO.get(), blockItemProps()));
            ((EnumMap<DyeColor, RegistryObject<Item>>) TORCH_ITEMS).put(c, item);
        }
    }

    // ── Gem items ─────────────────────────────────────────────────────────────

    /** 16 enchanted gem items, one per EnumGemType. */
    public static final Map<EnumGemType, RegistryObject<Item>> GEM =
            new EnumMap<>(EnumGemType.class);

    // ── Dyed standalone items ─────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Item>> CLAY_BALL  = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, RegistryObject<Item>> CLAY_BRICK  = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, RegistryObject<Item>> MUD_BALL    = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, RegistryObject<Item>> MUD_BRICK   = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, RegistryObject<Item>> DYED_STICK  = new EnumMap<>(DyeColor.class);

    static {
        for (EnumGemType gem : EnumGemType.values()) {
            String name = "gem_" + gem.getName();
            ((EnumMap<EnumGemType, RegistryObject<Item>>) GEM).put(gem,
                    ITEMS.register(name, () -> new Item(new Item.Properties())));
        }
        for (DyeColor c : DyeColor.values()) {
            final String col = c.getName();
            Item.Properties p = new Item.Properties();
            ((EnumMap<DyeColor, RegistryObject<Item>>) CLAY_BALL).put(c,
                    ITEMS.register(col + "_clay_ball",  () -> new Item(p)));
            ((EnumMap<DyeColor, RegistryObject<Item>>) CLAY_BRICK).put(c,
                    ITEMS.register(col + "_clay_brick", () -> new Item(p)));
            ((EnumMap<DyeColor, RegistryObject<Item>>) MUD_BALL).put(c,
                    ITEMS.register(col + "_mud_ball",   () -> new Item(p)));
            ((EnumMap<DyeColor, RegistryObject<Item>>) MUD_BRICK).put(c,
                    ITEMS.register(col + "_mud_brick",  () -> new Item(p)));
            ((EnumMap<DyeColor, RegistryObject<Item>>) DYED_STICK).put(c,
                    ITEMS.register(col + "_dyed_stick", () -> new Item(p)));
        }
    }

    // ── Tools ────────────────────────────────────────────────────────────────

    public static final RegistryObject<Item> GEM_SHEARS  = ITEMS.register("gem_shears",
            () -> new ItemGemShears(new Item.Properties().durability(500)));
    public static final RegistryObject<Item> GEM_HATCHET = ITEMS.register("gem_hatchet",
            () -> new ItemGemHatchet(new Item.Properties()));
    public static final RegistryObject<Item> GEM_HOE     = ITEMS.register("gem_hoe",
            () -> new ItemGemHoe(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PICKAXE = ITEMS.register("gem_pickaxe",
            () -> new ItemGemPickaxe(new Item.Properties()));
    public static final RegistryObject<Item> GEM_SHOVEL  = ITEMS.register("gem_shovel",
            () -> new ItemGemShovel(new Item.Properties()));
    public static final RegistryObject<Item> GEM_SWORD   = ITEMS.register("gem_sword",
            () -> new ItemGemSword(new Item.Properties()));

    // ── Register block items for all families ────────────────────────────────
    // Wall-torch blocks are NOT given block items (handled by GwyTorchItem above).

    static {
        registerBlockItems(ModBlocks.GLOWY_WOOL);

        registerBlockItems(ModBlocks.DYED_STONE);
        registerBlockItems(ModBlocks.GLOWY_DYED_STONE);
        registerBlockItems(ModBlocks.DYED_STONE_PAVER);
        registerBlockItems(ModBlocks.GLOWY_DYED_STONE_PAVER);

        registerBlockItems(ModBlocks.DYED_BOOKCASE);
        registerBlockItems(ModBlocks.GLOWY_DYED_BOOKCASE);

        registerBlockItems(ModBlocks.DYED_BRICK);
        registerBlockItems(ModBlocks.GLOWY_DYED_BRICK);
        registerBlockItems(ModBlocks.DYED_BRICK_PAVER);
        registerBlockItems(ModBlocks.GLOWY_DYED_BRICK_PAVER);

        registerBlockItems(ModBlocks.DYED_CLAY);
        registerBlockItems(ModBlocks.GLOWY_DYED_CLAY);

        registerBlockItems(ModBlocks.DYED_GLASS);
        registerBlockItems(ModBlocks.GLOWY_DYED_GLASS);

        registerBlockItems(ModBlocks.DYED_LEAF);
        registerBlockItems(ModBlocks.GLOWY_DYED_LEAF);

        registerBlockItems(ModBlocks.DYED_MUD_BRICK);
        registerBlockItems(ModBlocks.GLOWY_DYED_MUD_BRICK);
        registerBlockItems(ModBlocks.DYED_MUD_BRICK_PAVER);
        registerBlockItems(ModBlocks.GLOWY_DYED_MUD_BRICK_PAVER);

        registerBlockItems(ModBlocks.DYED_LOG);
        registerBlockItems(ModBlocks.GLOWY_DYED_LOG);

        registerBlockItems(ModBlocks.DYED_PLANK);
        registerBlockItems(ModBlocks.GLOWY_DYED_PLANK);

        registerBlockItems(ModBlocks.DYED_SAND);
        registerBlockItems(ModBlocks.GLOWY_DYED_SAND);

        registerBlockItems(ModBlocks.DYED_SANDSTONE);
        registerBlockItems(ModBlocks.GLOWY_DYED_SANDSTONE);
        registerBlockItems(ModBlocks.DYED_SMOOTH_SANDSTONE);
        registerBlockItems(ModBlocks.GLOWY_DYED_SMOOTH_SANDSTONE);
        registerBlockItems(ModBlocks.DYED_CHISELED_SANDSTONE);
        registerBlockItems(ModBlocks.GLOWY_DYED_CHISELED_SANDSTONE);

        registerBlockItems(ModBlocks.DYED_STONE_BRICK);
        registerBlockItems(ModBlocks.GLOWY_DYED_STONE_BRICK);
        registerBlockItems(ModBlocks.DYED_STONE_BRICK_PAVER);
        registerBlockItems(ModBlocks.GLOWY_DYED_STONE_BRICK_PAVER);

        registerBlockItems(ModBlocks.DYED_COBBLESTONE);
        registerBlockItems(ModBlocks.GLOWY_DYED_COBBLESTONE);
        registerBlockItems(ModBlocks.DYED_COBBLESTONE_PAVER);
        registerBlockItems(ModBlocks.GLOWY_DYED_COBBLESTONE_PAVER);

        registerBlockItems(ModBlocks.DYED_COBBLESTONE_WALL);
        registerBlockItems(ModBlocks.GLOWY_DYED_COBBLESTONE_WALL);

        registerBlockItems(ModBlocks.PLAIN_GREEK_BOTTOM);
        registerBlockItems(ModBlocks.PLAIN_GREEK_PILLAR);
        registerBlockItems(ModBlocks.PLAIN_GREEK_TOP);

        registerBlockItems(ModBlocks.PLAIN_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.PLAIN_PILLAR);
        registerBlockItems(ModBlocks.PLAIN_PILLAR_TOP);

        registerBlockItems(ModBlocks.PLAIN_WIDE_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.PLAIN_WIDE_PILLAR);
        registerBlockItems(ModBlocks.PLAIN_WIDE_PILLAR_TOP);

        registerBlockItems(ModBlocks.GREEK_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GREEK_PILLAR_TOP);
        registerBlockItems(ModBlocks.GREEK_WIDE_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GREEK_WIDE_PILLAR_TOP);
        registerBlockItems(ModBlocks.GREEK2_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GREEK2_PILLAR_TOP);
        registerBlockItems(ModBlocks.PLAIN_SLAB);
        registerBlockItems(ModBlocks.GREEK_SLAB);
        registerBlockItems(ModBlocks.FANCY_BOTTOM);
        registerBlockItems(ModBlocks.FANCY_TOP);
        registerBlockItems(ModBlocks.FANCY_GREEK_BOTTOM);
        registerBlockItems(ModBlocks.FANCY_GREEK_TOP);
        registerBlockItems(ModBlocks.FANCY_WIDE_BOTTOM);
        registerBlockItems(ModBlocks.FANCY_WIDE_TOP);
        registerBlockItems(ModBlocks.FANCY_SLAB);

        registerBlockItems(ModBlocks.GLOWY_PLAIN_GREEK_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_GREEK_PILLAR);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_GREEK_TOP);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_PILLAR);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_PILLAR_TOP);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_WIDE_PILLAR_TOP);
        registerBlockItems(ModBlocks.GLOWY_GREEK_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_GREEK_PILLAR_TOP);
        registerBlockItems(ModBlocks.GLOWY_GREEK_WIDE_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_GREEK_WIDE_PILLAR_TOP);
        registerBlockItems(ModBlocks.GLOWY_GREEK2_PILLAR_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_GREEK2_PILLAR_TOP);
        registerBlockItems(ModBlocks.GLOWY_PLAIN_SLAB);
        registerBlockItems(ModBlocks.GLOWY_GREEK_SLAB);
        registerBlockItems(ModBlocks.GLOWY_FANCY_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_FANCY_TOP);
        registerBlockItems(ModBlocks.GLOWY_FANCY_GREEK_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_FANCY_GREEK_TOP);
        registerBlockItems(ModBlocks.GLOWY_FANCY_WIDE_BOTTOM);
        registerBlockItems(ModBlocks.GLOWY_FANCY_WIDE_TOP);
        registerBlockItems(ModBlocks.GLOWY_FANCY_SLAB);

        registerBlockItems(ModBlocks.GEM_ORE);
        registerBlockItems(ModBlocks.COMPRESSED_GEM);
    }

    // ── Creative tab population ──────────────────────────────────────────────

    /**
     * Called via modBus.addListener in Gwycraft constructor.
     * Adds all mod items to the GwyCraft creative tab.
     */
    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (!event.getTabKey().equals(Gwycraft.TAB.getKey())) return;
        for (RegistryObject<Item> ro : ITEMS.getEntries()) {
            event.accept(ro.get());
        }
    }
}
