package gwydion0917.gwycraft.registration;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.blocks.*;
import gwydion0917.gwycraft.enums.EnumGemType;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

/**
 * All block registrations for GwyCraft 1.16.5.
 *
 * Architecture: each 1.12.2 16-metadata block becomes 16 separate Block objects,
 * registered in loops over DyeColor or EnumGemType.  Maps are EnumMaps for O(1) lookup.
 *
 * Naming convention:
 *   dye-color blocks  → {color}_{base}  (e.g. "black_dyed_brick")
 *   gem blocks        → {base}_{gem}    (e.g. "ore_gem_quartz")
 */
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Gwycraft.MOD_ID);

    // ── Helpers ─────────────────────────────────────────────────────────────

    /** Register 16 plain Block variants, one per DyeColor. */
    private static Map<DyeColor, RegistryObject<Block>> dyeBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new Block(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyGlassBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeGlassBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyGlassBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyLeafBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeLeafBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyLeafBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyFallingBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeFallingBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyFallingBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 GwyPaverBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyePaverBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new GwyPaverBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 WallBlock variants. */
    private static Map<DyeColor, RegistryObject<Block>> dyeWallBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new WallBlock(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    /** Register 16 dyed bookcase variants (plain Block — bookshelf is just a block in 1.16). */
    private static Map<DyeColor, RegistryObject<Block>> dyeBookcaseBlocks(
            String base, AbstractBlock.Properties props) {
        Map<DyeColor, RegistryObject<Block>> m = new EnumMap<>(DyeColor.class);
        for (DyeColor c : DyeColor.values()) {
            m.put(c, BLOCKS.register(c.getName() + "_" + base,
                    () -> new Block(props)));
        }
        return Collections.unmodifiableMap(m);
    }

    // ── Common property builders ─────────────────────────────────────────────

    private static AbstractBlock.Properties stoneProps(float hardness, float resistance) {
        return AbstractBlock.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops().strength(hardness, resistance).sound(SoundType.STONE);
    }

    private static AbstractBlock.Properties glowyStoneProps(float hardness, float resistance) {
        return stoneProps(hardness, resistance).lightLevel(s -> 15);
    }

    private static AbstractBlock.Properties woodProps(float hardness, float resistance) {
        return AbstractBlock.Properties.of(Material.WOOD)
                .strength(hardness, resistance).sound(SoundType.WOOD);
    }

    private static AbstractBlock.Properties glowyWoodProps(float hardness, float resistance) {
        return woodProps(hardness, resistance).lightLevel(s -> 15);
    }

    private static AbstractBlock.Properties woolProps() {
        return AbstractBlock.Properties.of(Material.WOOL)
                .strength(0.8F).sound(SoundType.WOOL).lightLevel(s -> 15);
    }

    private static AbstractBlock.Properties clayProps(float hardness) {
        return AbstractBlock.Properties.of(Material.CLAY)
                .strength(hardness).sound(SoundType.GRAVEL);
    }

    private static AbstractBlock.Properties sandProps() {
        return AbstractBlock.Properties.of(Material.SAND)
                .strength(0.5F).sound(SoundType.SAND);
    }

    private static AbstractBlock.Properties glassProps(float hardness) {
        return AbstractBlock.Properties.of(Material.GLASS)
                .strength(hardness).sound(SoundType.GLASS).noOcclusion();
    }

    private static AbstractBlock.Properties leafProps() {
        return AbstractBlock.Properties.of(Material.LEAVES)
                .strength(0.2F).sound(SoundType.GRASS).noOcclusion();
    }

    private static AbstractBlock.Properties torchProps() {
        return AbstractBlock.Properties.of(Material.DECORATION)
                .noCollission().instabreak().lightLevel(s -> 14).sound(SoundType.WOOD);
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

    // ── Bookshelves ──────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_BOOKCASE =
            dyeBookcaseBlocks("dyed_bookcase",
                    AbstractBlock.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_BOOKCASE =
            dyeBookcaseBlocks("glowy_dyed_bookcase",
                    AbstractBlock.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD).lightLevel(s -> 15));

    // ── Brick ─────────────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_BRICK =
            dyeBlocks("dyed_brick", stoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_BRICK =
            dyeBlocks("glowy_dyed_brick", glowyStoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_BRICK_PAVER =
            dyePaverBlocks("dyed_brick_paver", stoneProps(2.0F, 6.0F));

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

    // ── Cobblestone ──────────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE =
            dyeBlocks("dyed_cobblestone", stoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_COBBLESTONE =
            dyeBlocks("glowy_dyed_cobblestone", glowyStoneProps(2.0F, 10.0F));
    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE_PAVER =
            dyePaverBlocks("dyed_cobblestone_paver", stoneProps(2.0F, 6.0F));

    // ── Cobblestone Walls ────────────────────────────────────────────────────

    public static final Map<DyeColor, RegistryObject<Block>> DYED_COBBLESTONE_WALL =
            dyeWallBlocks("dyed_cobblestone_wall", stoneProps(2.0F, 10.0F).noOcclusion());
    public static final Map<DyeColor, RegistryObject<Block>> GLOWY_DYED_COBBLESTONE_WALL =
            dyeWallBlocks("glowy_dyed_cobblestone_wall", glowyStoneProps(2.0F, 10.0F).noOcclusion());

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
        AbstractBlock.Properties oreProps = AbstractBlock.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops().strength(3.0F, 5.0F).sound(SoundType.STONE);
        AbstractBlock.Properties compressedProps = AbstractBlock.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops().strength(3.0F, 5.0F).sound(SoundType.STONE)
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
