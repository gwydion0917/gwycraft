package gwydion0917.gwycraft.registration;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.blocks.*;
import gwydion0917.gwycraft.enums.EnumGemType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

/**
 * All block registrations for GwyCraft 1.20.1.
 * Material was removed in 1.20. BlockBehaviour.Properties.of() replaces
 * AbstractBlock.Properties.of(Material.*). MapColor replaces MaterialColor.
 * Mining-tool gating that was implicit in Material is now expressed via
 * mineable/* block tags (generated in ModTagsProvider) +
 * requiresCorrectToolForDrops().
 */
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Gwycraft.MOD_ID);

    // ── Helpers ─────────────────────────────────────────────────────────────

    /** Register 16 plain Block variants, one per DyeColor. */
    private static Map<DyeColor, RegistryObject<Block>> dyeBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new Block(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyGlassBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeGlassBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyGlassBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyLeafBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeLeafBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyLeafBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyFallingBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeFallingBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyFallingBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyPaverBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyePaverBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyPaverBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyTintedBlock variants (single shared model, color via tintindex). */
    private static Map<DyeColor, RegistryObject<Block>> dyeTintedBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            final DyeColor color = c;
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyTintedBlock(color, props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyTintedSlabBlock variants (single shared model set, color via tintindex). */
    private static Map<DyeColor, RegistryObject<Block>> dyeTintedSlabBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            final DyeColor color = c;
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyTintedSlabBlock(color, props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 RotatedPillarBlock variants (logs). */
    private static Map<DyeColor, RegistryObject<Block>> dyeRotatedPillarBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new RotatedPillarBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 WallBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeWallBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new WallBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 dyed bookcase variants (plain Block). */
    private static Map<DyeColor, RegistryObject<Block>> dyeBookcaseBlocks(
            String base, BlockBehaviour.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new Block(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    // ── Common property builders ─────────────────────────────────────────────

    private static BlockBehaviour.Properties stoneProps(float hardness, float resistance) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(hardness, resistance)
                .sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties glowyStoneProps(float hardness, float resistance) {
        return stoneProps(hardness, resistance).lightLevel(s -> 15);
    }

    private static BlockBehaviour.Properties woodProps(float hardness, float resistance) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(hardness, resistance)
                .sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties glowyWoodProps(float hardness, float resistance) {
        return woodProps(hardness, resistance).lightLevel(s -> 15);
    }

    private static BlockBehaviour.Properties woolProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOL)
                .strength(0.8F)
                .sound(SoundType.WOOL)
                .lightLevel(s -> 15);
    }

    private static BlockBehaviour.Properties clayProps(float hardness) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.CLAY)
                .strength(hardness)
                .sound(SoundType.GRAVEL);
    }

    private static BlockBehaviour.Properties sandProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.SAND)
                .strength(0.5F)
                .sound(SoundType.SAND);
    }

    private static BlockBehaviour.Properties glassProps(float hardness) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.NONE)
                .strength(hardness)
                .sound(SoundType.GLASS)
                .noOcclusion();
    }

    private static BlockBehaviour.Properties leafProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .sound(SoundType.GRASS)
                .noOcclusion();
    }

    private static BlockBehaviour.Properties torchProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.NONE)
                .noCollission()
                .instabreak()
                .lightLevel(s -> 14)
                .sound(SoundType.WOOD);
    }

    // ── Wool ─────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_WOOL =
            dyeBlocks("glowy_wool", woolProps());

    // ── Stone ─────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_STONE =
            dyeBlocks("dyed_stone", stoneProps(1.5F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_STONE =
            dyeBlocks("glowy_dyed_stone", glowyStoneProps(1.5F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_STONE_PAVER =
            dyePaverBlocks("dyed_stone_paver", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_STONE_PAVER =
            dyePaverBlocks("glowy_dyed_stone_paver", glowyStoneProps(2.0F, 6.0F));

    // ── Bookshelves ──────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_BOOKCASE =
            dyeBookcaseBlocks("dyed_bookcase",
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                            .strength(1.5F).sound(SoundType.WOOD));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_BOOKCASE =
            dyeBookcaseBlocks("glowy_dyed_bookcase",
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                            .strength(1.5F).sound(SoundType.WOOD).lightLevel(s -> 15));

    // ── Brick ─────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_BRICK =
            dyeBlocks("dyed_brick", stoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_BRICK =
            dyeBlocks("glowy_dyed_brick", glowyStoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_BRICK_PAVER =
            dyePaverBlocks("dyed_brick_paver", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_BRICK_PAVER =
            dyePaverBlocks("glowy_dyed_brick_paver", glowyStoneProps(2.0F, 6.0F));

    // ── Clay ──────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_CLAY =
            dyeBlocks("dyed_clay", clayProps(0.6F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_CLAY =
            dyeBlocks("glowy_dyed_clay", clayProps(0.6F).lightLevel(s -> 15));

    // ── Glass ──────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_GLASS =
            dyeGlassBlocks("dyed_glass", glassProps(0.3F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_GLASS =
            dyeGlassBlocks("glowy_dyed_glass", glassProps(0.3F).lightLevel(s -> 15));

    // ── Leaves ────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_LEAF =
            dyeLeafBlocks("dyed_leaf", leafProps());
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_LEAF =
            dyeLeafBlocks("glowy_dyed_leaf", leafProps().lightLevel(s -> 15));

    // ── Mud Brick ────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_MUD_BRICK =
            dyeBlocks("dyed_mud_brick", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_MUD_BRICK =
            dyeBlocks("glowy_dyed_mud_brick", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_MUD_BRICK_PAVER =
            dyePaverBlocks("dyed_mud_brick_paver", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_MUD_BRICK_PAVER =
            dyePaverBlocks("glowy_dyed_mud_brick_paver", glowyStoneProps(2.0F, 6.0F));

    // ── Logs ─────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_LOG =
            dyeRotatedPillarBlocks("dyed_log", woodProps(2.0F, 5.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_LOG =
            dyeRotatedPillarBlocks("glowy_dyed_log", glowyWoodProps(2.0F, 5.0F));

    // ── Planks ───────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_PLANK =
            dyeBlocks("dyed_plank", woodProps(2.0F, 5.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_PLANK =
            dyeBlocks("glowy_dyed_plank", glowyWoodProps(2.0F, 5.0F));

    // ── Sand & Sandstone ─────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_SAND =
            dyeFallingBlocks("dyed_sand", sandProps());
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_SAND =
            dyeFallingBlocks("glowy_dyed_sand", sandProps().lightLevel(s -> 15));

    public static final Map<DyeColor, RegistryObject<Block>> DYED_SANDSTONE =
            dyeBlocks("dyed_sandstone", stoneProps(0.8F, 4.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_SANDSTONE =
            dyeBlocks("glowy_dyed_sandstone", glowyStoneProps(0.8F, 4.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_SMOOTH_SANDSTONE =
            dyeBlocks("dyed_smooth_sandstone", stoneProps(0.8F, 4.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_SMOOTH_SANDSTONE =
            dyeBlocks("glowy_dyed_smooth_sandstone", glowyStoneProps(0.8F, 4.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_CHISELED_SANDSTONE =
            dyeBlocks("dyed_chiseled_sandstone", stoneProps(0.8F, 4.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_CHISELED_SANDSTONE =
            dyeBlocks("glowy_dyed_chiseled_sandstone", glowyStoneProps(0.8F, 4.0F));

    // ── Stone Brick ──────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_STONE_BRICK =
            dyeBlocks("dyed_stone_brick", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_STONE_BRICK =
            dyeBlocks("glowy_dyed_stone_brick", glowyStoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_STONE_BRICK_PAVER =
            dyePaverBlocks("dyed_stone_brick_paver", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_STONE_BRICK_PAVER =
            dyePaverBlocks("glowy_dyed_stone_brick_paver", glowyStoneProps(2.0F, 6.0F));

    // ── Cobblestone ──────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE =
            dyeBlocks("dyed_cobblestone", stoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_COBBLESTONE =
            dyeBlocks("glowy_dyed_cobblestone", glowyStoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE_PAVER =
            dyePaverBlocks("dyed_cobblestone_paver", stoneProps(2.0F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_COBBLESTONE_PAVER =
            dyePaverBlocks("glowy_dyed_cobblestone_paver", glowyStoneProps(2.0F, 6.0F));

    // ── Cobblestone Walls ────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE_WALL =
            dyeWallBlocks("dyed_cobblestone_wall", stoneProps(2.0F, 10.0F).noOcclusion());
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_COBBLESTONE_WALL =
            dyeWallBlocks("glowy_dyed_cobblestone_wall", glowyStoneProps(2.0F, 10.0F).noOcclusion());

    // ── Tinted pillar blocks ──────────────────────────────────────────────────
    // Three shaft textures (pillar, pillar_wide, pillar_greek) each have matching
    // plain caps. Greek and wide-greek caps can mix with any shaft.

    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_GREEK_BOTTOM =
            dyeTintedBlocks("plain_greek_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_GREEK_PILLAR =
            dyeTintedBlocks("plain_greek_pillar", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_GREEK_TOP =
            dyeTintedBlocks("plain_greek_top", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_PILLAR_BOTTOM =
            dyeTintedBlocks("plain_pillar_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_PILLAR =
            dyeTintedBlocks("plain_pillar", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_PILLAR_TOP =
            dyeTintedBlocks("plain_pillar_top", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_WIDE_PILLAR_BOTTOM =
            dyeTintedBlocks("plain_wide_pillar_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_WIDE_PILLAR =
            dyeTintedBlocks("plain_wide_pillar", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_WIDE_PILLAR_TOP =
            dyeTintedBlocks("plain_wide_pillar_top", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GREEK_PILLAR_BOTTOM =
            dyeTintedBlocks("greek_pillar_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GREEK_PILLAR_TOP =
            dyeTintedBlocks("greek_pillar_top", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GREEK_WIDE_PILLAR_BOTTOM =
            dyeTintedBlocks("greek_wide_pillar_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GREEK_WIDE_PILLAR_TOP =
            dyeTintedBlocks("greek_wide_pillar_top", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GREEK2_PILLAR_BOTTOM =
            dyeTintedBlocks("greek2_pillar_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GREEK2_PILLAR_TOP =
            dyeTintedBlocks("greek2_pillar_top", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> PLAIN_SLAB =
            dyeTintedSlabBlocks("plain_slab", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GREEK_SLAB =
            dyeTintedSlabBlocks("greek_slab", stoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> FANCY_BOTTOM =
            dyeTintedBlocks("fancy_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_TOP =
            dyeTintedBlocks("fancy_top", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_GREEK_BOTTOM =
            dyeTintedBlocks("fancy_greek_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_GREEK_TOP =
            dyeTintedBlocks("fancy_greek_top", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_WIDE_BOTTOM =
            dyeTintedBlocks("fancy_wide_bottom", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_WIDE_TOP =
            dyeTintedBlocks("fancy_wide_top", stoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> FANCY_SLAB =
            dyeTintedSlabBlocks("fancy_slab", stoneProps(1.5F, 6.0F));

    // ── Glowing tinted pillar blocks ─────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_GREEK_BOTTOM =
            dyeTintedBlocks("glowy_plain_greek_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_GREEK_PILLAR =
            dyeTintedBlocks("glowy_plain_greek_pillar", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_GREEK_TOP =
            dyeTintedBlocks("glowy_plain_greek_top", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_PILLAR_BOTTOM =
            dyeTintedBlocks("glowy_plain_pillar_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_PILLAR =
            dyeTintedBlocks("glowy_plain_pillar", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_PILLAR_TOP =
            dyeTintedBlocks("glowy_plain_pillar_top", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_WIDE_PILLAR_BOTTOM =
            dyeTintedBlocks("glowy_plain_wide_pillar_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_WIDE_PILLAR =
            dyeTintedBlocks("glowy_plain_wide_pillar", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_WIDE_PILLAR_TOP =
            dyeTintedBlocks("glowy_plain_wide_pillar_top", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK_PILLAR_BOTTOM =
            dyeTintedBlocks("glowy_greek_pillar_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK_PILLAR_TOP =
            dyeTintedBlocks("glowy_greek_pillar_top", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK_WIDE_PILLAR_BOTTOM =
            dyeTintedBlocks("glowy_greek_wide_pillar_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK_WIDE_PILLAR_TOP =
            dyeTintedBlocks("glowy_greek_wide_pillar_top", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK2_PILLAR_BOTTOM =
            dyeTintedBlocks("glowy_greek2_pillar_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK2_PILLAR_TOP =
            dyeTintedBlocks("glowy_greek2_pillar_top", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_PLAIN_SLAB =
            dyeTintedSlabBlocks("glowy_plain_slab", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_GREEK_SLAB =
            dyeTintedSlabBlocks("glowy_greek_slab", glowyStoneProps(1.5F, 6.0F));

    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_BOTTOM =
            dyeTintedBlocks("glowy_fancy_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_TOP =
            dyeTintedBlocks("glowy_fancy_top", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_GREEK_BOTTOM =
            dyeTintedBlocks("glowy_fancy_greek_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_GREEK_TOP =
            dyeTintedBlocks("glowy_fancy_greek_top", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_WIDE_BOTTOM =
            dyeTintedBlocks("glowy_fancy_wide_bottom", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_WIDE_TOP =
            dyeTintedBlocks("glowy_fancy_wide_top", glowyStoneProps(1.5F, 6.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_FANCY_SLAB =
            dyeTintedSlabBlocks("glowy_fancy_slab", glowyStoneProps(1.5F, 6.0F));

    // ── Torches ──────────────────────────────────────────────────────────────
    // Each color: one floor TorchBlock + one WallTorchBlock. One item per color.

    public static final Map<DyeColor, RegistryObject<Block>> TORCH =
            new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, RegistryObject<Block>> WALL_TORCH =
            new EnumMap<>(DyeColor.class);

    static {
        for (DyeColor c : DyeColor.values()) {
            RegistryObject<Block> floor = BLOCKS.register("torch_" + c.getName(),
                    () -> new TorchBlock(torchProps(), ParticleTypes.FLAME));
            RegistryObject<Block> wall  = BLOCKS.register("wall_torch_" + c.getName(),
                    () -> new WallTorchBlock(torchProps(), ParticleTypes.FLAME));
            ((EnumMap<DyeColor, RegistryObject<Block>>) TORCH).put(c, floor);
            ((EnumMap<DyeColor, RegistryObject<Block>>) WALL_TORCH).put(c, wall);
        }
    }

    // ── Gem Ore & Compressed Gem ─────────────────────────────────────────────

    public static final Map<EnumGemType, RegistryObject<Block>> GEM_ORE =
            new EnumMap<>(EnumGemType.class);
    public static final Map<EnumGemType, RegistryObject<Block>> COMPRESSED_GEM =
            new EnumMap<>(EnumGemType.class);

    static {
        // DropExperienceBlock replaces OreBlock (removed in 1.17).
        // XP range: UniformInt.of(3, 7) matches old OreBlock behaviour.
        BlockBehaviour.Properties oreProps = BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 5.0F)
                .sound(SoundType.STONE);
        BlockBehaviour.Properties compressedProps = BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 5.0F)
                .sound(SoundType.STONE)
                .lightLevel(s -> 15);

        for (EnumGemType gem : EnumGemType.values()) {
            ((EnumMap<EnumGemType, RegistryObject<Block>>) GEM_ORE).put(gem,
                    BLOCKS.register("ore_gem_" + gem.getName(),
                            () -> new GwyGemOreBlock(oreProps)));
            ((EnumMap<EnumGemType, RegistryObject<Block>>) COMPRESSED_GEM).put(gem,
                    BLOCKS.register("compressed_gem_" + gem.getName(),
                            () -> new Block(compressedProps)));
        }
    }
}
