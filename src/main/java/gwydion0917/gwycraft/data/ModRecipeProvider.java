package gwydion0917.gwycraft.data;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.registration.ModBlocks;
import gwydion0917.gwycraft.registration.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

/**
 * Data generator for GwyCraft recipes (1.20.1).
 * Key changes from 1.16.5:
 * - RecipeProvider(DataGenerator) → RecipeProvider(PackOutput)
 * - buildShapelessRecipes() → buildRecipes()
 * - IFinishedRecipe → FinishedRecipe
 * - ShapedRecipeBuilder/ShapelessRecipeBuilder/CookingRecipeBuilder now require
 *   a leading RecipeCategory argument
 * - Tags.Items.COBBLESTONE → Tags.Items.COBBLESTONE (renamed in 1.18)
 */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> out) {

        for (DyeColor c : DyeColor.values()) {
            Item  dye        = dyeFor(c);
            Block cobble     = ModBlocks.DYED_COBBLESTONE.get(c).get();
            Block gCobble    = ModBlocks.GLOWY_DYED_COBBLESTONE.get(c).get();
            Block cobWall    = ModBlocks.DYED_COBBLESTONE_WALL.get(c).get();
            Block gCobWall   = ModBlocks.GLOWY_DYED_COBBLESTONE_WALL.get(c).get();
            Block cobPaver   = ModBlocks.DYED_COBBLESTONE_PAVER.get(c).get();
            Block gCobPav    = ModBlocks.GLOWY_DYED_COBBLESTONE_PAVER.get(c).get();
            Block stone      = ModBlocks.DYED_STONE.get(c).get();
            Block gStone     = ModBlocks.GLOWY_DYED_STONE.get(c).get();
            Block stonePav   = ModBlocks.DYED_STONE_PAVER.get(c).get();
            Block gStonePav  = ModBlocks.GLOWY_DYED_STONE_PAVER.get(c).get();
            Block stoneBr    = ModBlocks.DYED_STONE_BRICK.get(c).get();
            Block gStoneBr   = ModBlocks.GLOWY_DYED_STONE_BRICK.get(c).get();
            Block sBrPav     = ModBlocks.DYED_STONE_BRICK_PAVER.get(c).get();
            Block gSBrPav    = ModBlocks.GLOWY_DYED_STONE_BRICK_PAVER.get(c).get();
            Block brick      = ModBlocks.DYED_BRICK.get(c).get();
            Block gBrick     = ModBlocks.GLOWY_DYED_BRICK.get(c).get();
            Block brickPav   = ModBlocks.DYED_BRICK_PAVER.get(c).get();
            Block gBrickPav  = ModBlocks.GLOWY_DYED_BRICK_PAVER.get(c).get();
            Block mudBrick   = ModBlocks.DYED_MUD_BRICK.get(c).get();
            Block gMudBr     = ModBlocks.GLOWY_DYED_MUD_BRICK.get(c).get();
            Block mudBrPav   = ModBlocks.DYED_MUD_BRICK_PAVER.get(c).get();
            Block gMudBrPav  = ModBlocks.GLOWY_DYED_MUD_BRICK_PAVER.get(c).get();
            Block log        = ModBlocks.DYED_LOG.get(c).get();
            Block gLog       = ModBlocks.GLOWY_DYED_LOG.get(c).get();
            Block plank      = ModBlocks.DYED_PLANK.get(c).get();
            Block gPlank     = ModBlocks.GLOWY_DYED_PLANK.get(c).get();
            Block sand       = ModBlocks.DYED_SAND.get(c).get();
            Block gSand      = ModBlocks.GLOWY_DYED_SAND.get(c).get();
            Block sandSt     = ModBlocks.DYED_SANDSTONE.get(c).get();
            Block gSandSt    = ModBlocks.GLOWY_DYED_SANDSTONE.get(c).get();
            Block smSandSt   = ModBlocks.DYED_SMOOTH_SANDSTONE.get(c).get();
            Block gSmSandSt  = ModBlocks.GLOWY_DYED_SMOOTH_SANDSTONE.get(c).get();
            Block chisSandSt = ModBlocks.DYED_CHISELED_SANDSTONE.get(c).get();
            Block gChisSandSt= ModBlocks.GLOWY_DYED_CHISELED_SANDSTONE.get(c).get();
            Block bookcase   = ModBlocks.DYED_BOOKCASE.get(c).get();
            Block gBookcase  = ModBlocks.GLOWY_DYED_BOOKCASE.get(c).get();
            Block clay       = ModBlocks.DYED_CLAY.get(c).get();
            Block gClay      = ModBlocks.GLOWY_DYED_CLAY.get(c).get();
            Block glass      = ModBlocks.DYED_GLASS.get(c).get();
            Block gGlass     = ModBlocks.GLOWY_DYED_GLASS.get(c).get();
            Block leaf       = ModBlocks.DYED_LEAF.get(c).get();
            Block gLeaf      = ModBlocks.GLOWY_DYED_LEAF.get(c).get();
            Block gWool      = ModBlocks.GLOWY_WOOL.get(c).get();

            Item  clayBall     = ModItems.CLAY_BALL.get(c).get();
            Item  clayBrick    = ModItems.CLAY_BRICK.get(c).get();
            Item  mudBall      = ModItems.MUD_BALL.get(c).get();
            Item  mudBrickItem = ModItems.MUD_BRICK.get(c).get();
            Item  dStick       = ModItems.DYED_STICK.get(c).get();

            EnumGemType gem    = EnumGemType.values()[c.ordinal() % EnumGemType.values().length];
            Item        gemItem= ModItems.GEM.get(gem).get();
            Block       compGem= ModBlocks.COMPRESSED_GEM.get(gem).get();

            String s = c.getName();

            // ── Compressed gem block: 4 gems → block, block → 4 gems ───────
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, compGem)
                    .pattern("XX").pattern("XX").define('X', gemItem)
                    .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                    .save(out, grl("gem_block_" + gem.getName()));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, gemItem, 4)
                    .requires(compGem)
                    .unlockedBy("has_gem_block", has(compGem))
                    .save(out, grl("gem_unpack_" + gem.getName()));

            // ── Dyed cobblestone (8 vanilla cobble + dye) ──────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, cobble, 8)
                    .requires(dye).requires(Ingredient.of(Tags.Items.COBBLESTONE), 8)
                    .unlockedBy("has_cobble", has(Tags.Items.COBBLESTONE))
                    .save(out, grl("dyed_cobble_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gCobble, 8)
                    .requires(Blocks.GLOWSTONE).requires(cobble, 8)
                    .unlockedBy("has_cobble", has(cobble))
                    .save(out, grl("glowy_dyed_cobble_" + s));

            // ── Cobblestone wall (2 rows of 3 dyed cobble → 6 walls) ───────
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cobWall, 6)
                    .pattern("XXX").pattern("XXX").define('X', cobble)
                    .unlockedBy("has_cobble", has(cobble))
                    .save(out, grl("dyed_cobble_wall_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gCobWall, 6)
                    .pattern("XXX").pattern("XXX").define('X', gCobble)
                    .unlockedBy("has_cobble", has(gCobble))
                    .save(out, grl("glowy_dyed_cobble_wall_" + s));

            // ── Pavers (2 blocks in a row → 3 pavers) ─────────────────────
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stonePav, 3)
                    .pattern("XX").define('X', stone)
                    .unlockedBy("has_stone", has(stone)).save(out, grl("dyed_stone_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gStonePav, 3)
                    .pattern("XX").define('X', gStone)
                    .unlockedBy("has_g_stone", has(gStone)).save(out, grl("glowy_dyed_stone_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, brickPav, 3)
                    .pattern("XX").define('X', brick)
                    .unlockedBy("has_brick", has(brick)).save(out, grl("dyed_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gBrickPav, 3)
                    .pattern("XX").define('X', gBrick)
                    .unlockedBy("has_g_brick", has(gBrick)).save(out, grl("glowy_dyed_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, sBrPav, 3)
                    .pattern("XX").define('X', stoneBr)
                    .unlockedBy("has_stone_brick", has(stoneBr)).save(out, grl("dyed_stone_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gSBrPav, 3)
                    .pattern("XX").define('X', gStoneBr)
                    .unlockedBy("has_g_stone_brick", has(gStoneBr)).save(out, grl("glowy_dyed_stone_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, mudBrPav, 3)
                    .pattern("XX").define('X', mudBrick)
                    .unlockedBy("has_mud_brick", has(mudBrick)).save(out, grl("dyed_mud_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gMudBrPav, 3)
                    .pattern("XX").define('X', gMudBr)
                    .unlockedBy("has_g_mud_brick", has(gMudBr)).save(out, grl("glowy_dyed_mud_brick_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cobPaver, 3)
                    .pattern("XX").define('X', cobble)
                    .unlockedBy("has_cobble", has(cobble)).save(out, grl("dyed_cobble_paver_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gCobPav, 3)
                    .pattern("XX").define('X', gCobble)
                    .unlockedBy("has_g_cobble", has(gCobble)).save(out, grl("glowy_dyed_cobble_paver_" + s));

            // ── Dyed log (8 logs + dye → 8 dyed logs) ─────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, log, 8)
                    .requires(dye).requires(Ingredient.of(ItemTags.LOGS_THAT_BURN), 8)
                    .unlockedBy("has_log", has(ItemTags.LOGS_THAT_BURN))
                    .save(out, grl("dyed_log_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gLog, 8)
                    .requires(Blocks.GLOWSTONE).requires(log, 8)
                    .unlockedBy("has_log", has(log))
                    .save(out, grl("glowy_dyed_log_" + s));

            // ── Log → planks (1 log → 4 planks) ───────────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank, 4)
                    .requires(log)
                    .unlockedBy("has_log", has(log))
                    .save(out, grl("dyed_log_to_plank_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gPlank, 4)
                    .requires(gLog)
                    .unlockedBy("has_g_log", has(gLog))
                    .save(out, grl("glowy_dyed_log_to_plank_" + s));

            // ── Dyed plank (8 planks + dye) ────────────────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank, 8)
                    .requires(dye).requires(Ingredient.of(ItemTags.PLANKS), 8)
                    .unlockedBy("has_planks", has(ItemTags.PLANKS))
                    .save(out, grl("dyed_plank_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gPlank, 8)
                    .requires(Blocks.GLOWSTONE).requires(plank, 8)
                    .unlockedBy("has_plank", has(plank))
                    .save(out, grl("glowy_dyed_plank_" + s));

            // ── Dyed sticks (2 dyed planks → 4 sticks) ────────────────────
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, dStick, 4)
                    .pattern("X").pattern("X").define('X', plank)
                    .unlockedBy("has_plank", has(plank)).save(out, grl("dyed_sticks_" + s));

            // ── Stone brick (2×2 dyed stone → 4 stone brick) ──────────────
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stoneBr, 4)
                    .pattern("XX").pattern("XX").define('X', stone)
                    .unlockedBy("has_stone", has(stone)).save(out, grl("dyed_stone_brick_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gStoneBr, 4)
                    .pattern("XX").pattern("XX").define('X', gStone)
                    .unlockedBy("has_g_stone", has(gStone)).save(out, grl("glowy_dyed_stone_brick_" + s));

            // ── Clay ball → clay brick (smelt) → clay block ────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, clayBall, 8)
                    .requires(dye).requires(Items.CLAY_BALL, 8)
                    .unlockedBy("has_clay", has(Items.CLAY_BALL))
                    .save(out, grl("dyed_clay_ball_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, clay)
                    .pattern("XX").pattern("XX").define('X', clayBall)
                    .unlockedBy("has_clay_ball", has(clayBall)).save(out, grl("dyed_clay_block_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, brick)
                    .pattern("XX").pattern("XX").define('X', clayBrick)
                    .unlockedBy("has_clay_brick", has(clayBrick)).save(out, grl("dyed_brick_block_" + s));

            // ── Mud ball (smelt → mud brick) → mud brick block ─────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, mudBall, 16)
                    .requires(dye).requires(Items.WATER_BUCKET).requires(Items.CLAY_BALL)
                    .requires(Ingredient.of(Blocks.DIRT), 6)
                    .unlockedBy("has_dirt", has(Blocks.DIRT))
                    .save(out, grl("dyed_mud_ball_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, mudBrick)
                    .pattern("XX").pattern("XX").define('X', mudBrickItem)
                    .unlockedBy("has_mud_brick_item", has(mudBrickItem))
                    .save(out, grl("dyed_mud_brick_block_" + s));

            // ── Glowy clay, brick, mud brick ──────────────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gClay, 8)
                    .requires(Blocks.GLOWSTONE).requires(clay, 8)
                    .unlockedBy("has_clay", has(clay))
                    .save(out, grl("glowy_dyed_clay_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gBrick, 8)
                    .requires(Blocks.GLOWSTONE).requires(brick, 8)
                    .unlockedBy("has_brick", has(brick))
                    .save(out, grl("glowy_dyed_brick_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gMudBr, 8)
                    .requires(Ingredient.of(Blocks.GLOWSTONE))
                    .requires(mudBrick, 8)
                    .unlockedBy("has_mud_brick", has(mudBrick))
                    .save(out, grl("glowy_dyed_mud_brick_" + s));

            // ── Dyed torch (coal + dyed stick → 4 torches) ────────────────
            Item torchItem = ModItems.TORCH_ITEMS.get(c).get();
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, torchItem, 4)
                    .pattern("X").pattern("#").define('X', Items.COAL).define('#', dStick)
                    .unlockedBy("has_stick", has(dStick))
                    .save(out, grl("dyed_torch_" + s));

            // ── Glowy wool (1 glowstone + 8 wool → 8 glowy wool) ──────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gWool, 8)
                    .requires(Blocks.GLOWSTONE).requires(coloredWoolItem(c), 8)
                    .unlockedBy("has_wool", has(coloredWoolItem(c)))
                    .save(out, grl("glowy_wool_glowstone_" + s));

            // ── Dyed sand & sandstone ──────────────────────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, sand, 8)
                    .requires(dye).requires(Ingredient.of(Blocks.SAND), 8)
                    .unlockedBy("has_sand", has(Blocks.SAND))
                    .save(out, grl("dyed_sand_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gSand, 8)
                    .requires(Blocks.GLOWSTONE).requires(sand, 8)
                    .unlockedBy("has_sand", has(sand))
                    .save(out, grl("glowy_dyed_sand_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, sandSt, 8)
                    .requires(dye).requires(Ingredient.of(Blocks.SANDSTONE), 8)
                    .unlockedBy("has_sandstone", has(Blocks.SANDSTONE))
                    .save(out, grl("dyed_sandstone_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gSandSt, 8)
                    .requires(Blocks.GLOWSTONE).requires(sandSt, 8)
                    .unlockedBy("has_sandstone", has(sandSt))
                    .save(out, grl("glowy_dyed_sandstone_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, chisSandSt, 8)
                    .requires(dye).requires(Ingredient.of(Blocks.CHISELED_SANDSTONE), 8)
                    .unlockedBy("has_chiseled_sandstone", has(Blocks.CHISELED_SANDSTONE))
                    .save(out, grl("dyed_chiseled_sandstone_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, gChisSandSt, 8)
                    .requires(Blocks.GLOWSTONE).requires(chisSandSt, 8)
                    .unlockedBy("has_chiseled_sandstone", has(chisSandSt))
                    .save(out, grl("glowy_dyed_chiseled_sandstone_" + s));

            // ── Dyed bookcase ──────────────────────────────────────────────
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bookcase)
                    .pattern("###").pattern("XXX").pattern("###")
                    .define('#', plank).define('X', Items.BOOK)
                    .unlockedBy("has_book", has(Items.BOOK))
                    .save(out, grl("dyed_bookcase_" + s));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, gBookcase)
                    .pattern("###").pattern("XXX").pattern("###")
                    .define('#', gPlank).define('X', Items.BOOK)
                    .unlockedBy("has_book", has(Items.BOOK))
                    .save(out, grl("glowy_dyed_bookcase_" + s));

            // ── Dyed leaves ────────────────────────────────────────────────
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, leaf, 8)
                    .requires(dye).requires(Ingredient.of(ItemTags.LEAVES), 8)
                    .unlockedBy("has_leaves", has(ItemTags.LEAVES))
                    .save(out, grl("dyed_leaf_" + s));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, gLeaf, 8)
                    .requires(Blocks.GLOWSTONE).requires(leaf, 8)
                    .unlockedBy("has_leaf", has(leaf))
                    .save(out, grl("glowy_dyed_leaf_" + s));

            // ── Smelting ───────────────────────────────────────────────────
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobble), RecipeCategory.BUILDING_BLOCKS, stone, 0.1F, 200)
                    .unlockedBy("has_cobble", has(cobble)).save(out, grl("smelt_cobble_to_stone_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(gCobble), RecipeCategory.BUILDING_BLOCKS, gStone, 0.1F, 200)
                    .unlockedBy("has_g_cobble", has(gCobble)).save(out, grl("smelt_g_cobble_to_g_stone_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(clayBall), RecipeCategory.MISC, clayBrick, 0.1F, 200)
                    .unlockedBy("has_clay_ball", has(clayBall)).save(out, grl("smelt_clay_ball_to_brick_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(mudBall), RecipeCategory.MISC, mudBrickItem, 0.1F, 200)
                    .unlockedBy("has_mud_ball", has(mudBall)).save(out, grl("smelt_mud_ball_to_mud_brick_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(sand), RecipeCategory.BUILDING_BLOCKS, glass, 0.1F, 200)
                    .unlockedBy("has_sand", has(sand)).save(out, grl("smelt_sand_to_glass_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(gSand), RecipeCategory.BUILDING_BLOCKS, gGlass, 0.1F, 200)
                    .unlockedBy("has_g_sand", has(gSand)).save(out, grl("smelt_g_sand_to_g_glass_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(sandSt), RecipeCategory.BUILDING_BLOCKS, smSandSt, 0.1F, 200)
                    .unlockedBy("has_sandstone", has(sandSt)).save(out, grl("smelt_sandstone_to_smooth_" + s));
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(gSandSt), RecipeCategory.BUILDING_BLOCKS, gSmSandSt, 0.1F, 200)
                    .unlockedBy("has_g_sandstone", has(gSandSt)).save(out, grl("smelt_g_sandstone_to_g_smooth_" + s));
        }

        // ── Per-gem: gem-to-dye and ore crafting ──────────────────────────────
        for (EnumGemType gem : EnumGemType.values()) {
            Item  gemItem  = ModItems.GEM.get(gem).get();
            Block oreBlock = ModBlocks.GEM_ORE.get(gem).get();
            DyeColor matchColor = DyeColor.values()[gem.getIndex() % DyeColor.values().length];
            Item matchDye = dyeFor(matchColor);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, matchDye, 4)
                    .requires(gemItem).requires(Items.GUNPOWDER).requires(Items.GLASS_BOTTLE)
                    .unlockedBy("has_gem", has(gemItem))
                    .save(out, grl("gem_to_dye_" + gem.getName()));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, oreBlock)
                    .requires(matchDye, 4).requires(Items.GLOWSTONE_DUST, 4).requires(Items.DIAMOND)
                    .unlockedBy("has_gem", has(gemItem))
                    .save(out, grl("gem_ore_craft_" + gem.getName()));
        }

        // ── Gem tools ─────────────────────────────────────────────────────────
        Ingredient gemAny = Ingredient.of(ModTags.Items.GEMS);
        Ingredient stick  = Ingredient.of(Tags.Items.RODS_WOODEN);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_SHEARS.get())
                .pattern(" X").pattern("X ").define('X', gemAny)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_shears"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_HATCHET.get())
                .pattern("XX ").pattern("XY ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_hatchet_left"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_HATCHET.get())
                .pattern(" XX").pattern(" YX").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_hatchet_right"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_HOE.get())
                .pattern("XX ").pattern(" Y ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_hoe_left"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_HOE.get())
                .pattern(" XX").pattern(" Y ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_hoe_right"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_PICKAXE.get())
                .pattern("XXX").pattern(" Y ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_SHOVEL.get())
                .pattern(" X ").pattern(" Y ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GEM_SWORD.get())
                .pattern("X  ").pattern("X  ").pattern("Y  ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_sword_left"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GEM_SWORD.get())
                .pattern(" X ").pattern(" X ").pattern(" Y ")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_sword_center"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GEM_SWORD.get())
                .pattern("  X").pattern("  X").pattern("  Y")
                .define('X', gemAny).define('Y', stick)
                .unlockedBy("has_gem", has(ModTags.Items.GEMS))
                .save(out, grl("gem_sword_right"));
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private static ResourceLocation grl(String path) {
        return new ResourceLocation(Gwycraft.MOD_ID, path);
    }

    private static Item dyeFor(DyeColor c) {
        return switch (c) {
            case WHITE      -> Items.WHITE_DYE;
            case ORANGE     -> Items.ORANGE_DYE;
            case MAGENTA    -> Items.MAGENTA_DYE;
            case LIGHT_BLUE -> Items.LIGHT_BLUE_DYE;
            case YELLOW     -> Items.YELLOW_DYE;
            case LIME       -> Items.LIME_DYE;
            case PINK       -> Items.PINK_DYE;
            case GRAY       -> Items.GRAY_DYE;
            case LIGHT_GRAY -> Items.LIGHT_GRAY_DYE;
            case CYAN       -> Items.CYAN_DYE;
            case PURPLE     -> Items.PURPLE_DYE;
            case BLUE       -> Items.BLUE_DYE;
            case BROWN      -> Items.BROWN_DYE;
            case GREEN      -> Items.GREEN_DYE;
            case RED        -> Items.RED_DYE;
            case BLACK      -> Items.BLACK_DYE;
        };
    }

    private static Item coloredWoolItem(DyeColor c) {
        return switch (c) {
            case WHITE      -> Item.byBlock(Blocks.WHITE_WOOL);
            case ORANGE     -> Item.byBlock(Blocks.ORANGE_WOOL);
            case MAGENTA    -> Item.byBlock(Blocks.MAGENTA_WOOL);
            case LIGHT_BLUE -> Item.byBlock(Blocks.LIGHT_BLUE_WOOL);
            case YELLOW     -> Item.byBlock(Blocks.YELLOW_WOOL);
            case LIME       -> Item.byBlock(Blocks.LIME_WOOL);
            case PINK       -> Item.byBlock(Blocks.PINK_WOOL);
            case GRAY       -> Item.byBlock(Blocks.GRAY_WOOL);
            case LIGHT_GRAY -> Item.byBlock(Blocks.LIGHT_GRAY_WOOL);
            case CYAN       -> Item.byBlock(Blocks.CYAN_WOOL);
            case PURPLE     -> Item.byBlock(Blocks.PURPLE_WOOL);
            case BLUE       -> Item.byBlock(Blocks.BLUE_WOOL);
            case BROWN      -> Item.byBlock(Blocks.BROWN_WOOL);
            case GREEN      -> Item.byBlock(Blocks.GREEN_WOOL);
            case RED        -> Item.byBlock(Blocks.RED_WOOL);
            case BLACK      -> Item.byBlock(Blocks.BLACK_WOOL);
        };
    }
}
