package gwydion0917.gwycraft;

import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreIngredient;

public class GwycraftRecipes {

    public static void init() {
        for (int i = 0; i < 16; i++) {
            // Dye item: inverted from wool (i=0 white → dye damage 15 = bone meal)
            Ingredient dye       = Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 15 - i));
            Ingredient gem       = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemEnchantedGems, 1, i));
            Ingredient gemBlock  = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockGemCompressed, 1, i));
            Ingredient dyedCobble       = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 1, i));
            Ingredient glowyDyedCobble  = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 1, i));
            Ingredient dyedStone        = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedStone, 1, i));
            Ingredient glowyDyedStone   = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.glowyblockDyedStone, 1, i));
            Ingredient dyedStoneBrick   = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedStoneBrick, 1, i));
            Ingredient dyedMudBrick     = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedMudBrick, 1, i));
            Ingredient dyedBrick        = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedBrick, 1, i));
            Ingredient dyedPlank        = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.blockDyedPlank, 1, i));
            Ingredient glowyDyedPlank   = Ingredient.fromStacks(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 1, i));
            Ingredient dyedSticks       = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemDyedSticks, 1, i));
            Ingredient dyedClayItem     = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemDyedClay, 1, i));
            Ingredient dyedClayBricks   = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemDyedClayBricks, 1, i));
            Ingredient dyedMudItem      = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemDyedMud, 1, i));
            Ingredient dyedMudBrickItem = Ingredient.fromStacks(new ItemStack(GwycraftItems.itemDyedMudBricks, 1, i));
            Ingredient glowstone        = Ingredient.fromStacks(new ItemStack(Blocks.GLOWSTONE));
            Ingredient glowDust         = Ingredient.fromStacks(new ItemStack(Items.GLOWSTONE_DUST));
            Ingredient diamond          = Ingredient.fromStacks(new ItemStack(Items.DIAMOND));
            Ingredient gunpowder        = Ingredient.fromStacks(new ItemStack(Items.GUNPOWDER));
            Ingredient bottle           = Ingredient.fromStacks(new ItemStack(Items.GLASS_BOTTLE));
            Ingredient potion           = Ingredient.fromStacks(new ItemStack(Items.POTIONITEM));
            Ingredient coal             = Ingredient.fromStacks(new ItemStack(Items.COAL));
            Ingredient cobble           = new OreIngredient("cobblestone");
            Ingredient plank            = new OreIngredient("plankWood");
            Ingredient wool             = Ingredient.fromStacks(new ItemStack(Blocks.WOOL, 1, i));
            Ingredient anyWool          = new OreIngredient("wool");
            Ingredient sand             = Ingredient.fromStacks(new ItemStack(Blocks.SAND));
            Ingredient clayBall         = Ingredient.fromStacks(new ItemStack(Items.CLAY_BALL));
            Ingredient dirt             = Ingredient.fromStacks(new ItemStack(Blocks.DIRT));
            Ingredient clayBlock        = Ingredient.fromStacks(new ItemStack(Blocks.CLAY));
            Ingredient brickBlock         = Ingredient.fromStacks(new ItemStack(Blocks.BRICK_BLOCK));
            Ingredient sandstone          = Ingredient.fromStacks(new ItemStack(Blocks.SANDSTONE));
            Ingredient chiseledSandstone  = Ingredient.fromStacks(new ItemStack(Blocks.SANDSTONE, 1, 1));
            Ingredient book               = Ingredient.fromStacks(new ItemStack(Items.BOOK));
            Ingredient fence              = Ingredient.fromStacks(new ItemStack(Blocks.OAK_FENCE));
            Ingredient leaf               = new OreIngredient("treeLeaves");

            Block dyedLogBlock     = i < 4  ? GwycraftBlocks.blockDyedLog1 :
                                     i < 8  ? GwycraftBlocks.blockDyedLog2 :
                                     i < 12 ? GwycraftBlocks.blockDyedLog3 :
                                              GwycraftBlocks.blockDyedLog4;
            Block glowyDyedLogBlock = i < 4  ? GwycraftBlocks.glowyblockDyedLog1 :
                                      i < 8  ? GwycraftBlocks.glowyblockDyedLog2 :
                                      i < 12 ? GwycraftBlocks.glowyblockDyedLog3 :
                                               GwycraftBlocks.glowyblockDyedLog4;
            int logMeta = i % 4;

            String s = String.valueOf(i);

            // --- Gem block <-> enchanted gems ---
            GameRegistry.addShapedRecipe(rl("gem_block_" + s), null,
                    new ItemStack(GwycraftBlocks.blockGemCompressed, 1, i),
                    "XX", "XX", 'X', gem);
            GameRegistry.addShapelessRecipe(rl("gem_unpack_" + s), null,
                    new ItemStack(GwycraftItems.itemEnchantedGems, 4, i), gemBlock);

            // Gem -> dye (+ gunpowder + bottle)
            GameRegistry.addShapelessRecipe(rl("gem_to_dye_" + s), null,
                    new ItemStack(Items.DYE, 4, 15 - i), gem, gunpowder, bottle);

            // Gem ore (with config)
            if (ConfigGwycraft.gemsCraftingEnabled) {
                GameRegistry.addShapelessRecipe(rl("gem_ore_craft_" + s), null,
                        new ItemStack(GwycraftBlocks.blockGemOre, 1, i),
                        dye, dye, dye, dye, glowDust, glowDust, glowDust, glowDust, diamond);
            }

            // --- Dyed cobblestone from vanilla cobble + dye ---
            GameRegistry.addShapelessRecipe(rl("dyed_cobble_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 8, i),
                    dye, cobble, cobble, cobble, cobble, cobble, cobble, cobble, cobble);

            // --- Dyed plank from vanilla planks + dye ---
            GameRegistry.addShapelessRecipe(rl("dyed_plank_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedPlank, 8, i),
                    dye, plank, plank, plank, plank, plank, plank, plank, plank);
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_plank_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 8, i),
                    gem, plank, plank, plank, plank, plank, plank, plank, plank);

            // Dyed plank -> dyed sticks (4 per plank)
            GameRegistry.addShapelessRecipe(rl("dyed_sticks_" + s), null,
                    new ItemStack(GwycraftItems.itemDyedSticks, 4, i), dyedPlank);

            // --- Stone brick from dyed stone ---
            GameRegistry.addShapedRecipe(rl("dyed_stone_brick_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedStoneBrick, 4, i),
                    "XX", "XX", 'X', dyedStone);
            GameRegistry.addShapedRecipe(rl("glowy_dyed_stone_brick_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedStoneBrick, 4, i),
                    "XX", "XX", 'X', glowyDyedStone);

            // --- Cobble walls ---
            GameRegistry.addShapedRecipe(rl("dyed_cobble_wall_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedCobbleWalls, 6, i),
                    "XXX", "XXX", 'X', dyedCobble);
            GameRegistry.addShapedRecipe(rl("glowy_dyed_cobble_wall_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedCobbleWalls, 6, i),
                    "XXX", "XXX", 'X', glowyDyedCobble);

            // --- Pavers (2 blocks in a row -> 3 pavers) ---
            GameRegistry.addShapedRecipe(rl("dyed_stone_paver_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedStonePaver, 3, i), "XX", 'X', dyedStone);
            GameRegistry.addShapedRecipe(rl("dyed_brick_paver_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedBrickPaver, 3, i), "XX", 'X', dyedBrick);
            GameRegistry.addShapedRecipe(rl("dyed_stone_brick_paver_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedStoneBrickPaver, 3, i), "XX", 'X', dyedStoneBrick);
            GameRegistry.addShapedRecipe(rl("dyed_mud_brick_paver_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedMudBrickPaver, 3, i), "XX", 'X', dyedMudBrick);
            GameRegistry.addShapedRecipe(rl("dyed_cobble_paver_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedStoneCobblePaver, 3, i), "XX", 'X', dyedCobble);

            // --- Clay/mud crafting items ---
            // 8 clay balls + dye -> 8 colored clay items
            GameRegistry.addShapelessRecipe(rl("dyed_clay_item_" + s), null,
                    new ItemStack(GwycraftItems.itemDyedClay, 8, i),
                    dye, clayBall, clayBall, clayBall, clayBall,
                    clayBall, clayBall, clayBall, clayBall);
            // 8 dirt + clay ball + water bottle + dye -> 16 colored mud items
            GameRegistry.addShapelessRecipe(rl("dyed_mud_item_" + s), null,
                    new ItemStack(GwycraftItems.itemDyedMud, 16, i),
                    dye, potion, clayBall,
                    dirt, dirt, dirt, dirt, dirt, dirt, dirt, dirt);
            // 4 colored clay items -> 1 clay block
            GameRegistry.addShapedRecipe(rl("dyed_clay_block_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedClayblock, 1, i),
                    "XX", "XX", 'X', dyedClayItem);
            // 4 colored clay bricks -> 1 colored brick block
            GameRegistry.addShapedRecipe(rl("dyed_brick_block_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedBrick, 1, i),
                    "XX", "XX", 'X', dyedClayBricks);
            // 4 colored mud bricks -> 1 mud brick block
            GameRegistry.addShapedRecipe(rl("dyed_mud_brick_block_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedMudBrick, 4, i),
                    "XX", "XX", 'X', dyedMudBrickItem);

            // --- Glowy variants via enchanted gems ---
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_clay_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedClayblock, 8, i),
                    gem, clayBlock, clayBlock, clayBlock, clayBlock,
                    clayBlock, clayBlock, clayBlock, clayBlock);
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_brick_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedBrick, 8, i),
                    gem, brickBlock, brickBlock, brickBlock, brickBlock,
                    brickBlock, brickBlock, brickBlock, brickBlock);
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_mud_brick_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedMudBrick, 8, i),
                    glowstone, dyedMudBrick, dyedMudBrick, dyedMudBrick, dyedMudBrick,
                    dyedMudBrick, dyedMudBrick, dyedMudBrick, dyedMudBrick);

            // --- Furnace recipes ---
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 1, i),
                    new ItemStack(GwycraftBlocks.blockDyedStone, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 1, i),
                    new ItemStack(GwycraftBlocks.glowyblockDyedStone, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftItems.itemDyedClay, 1, i),
                    new ItemStack(GwycraftItems.itemDyedClayBricks, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftItems.itemDyedMud, 1, i),
                    new ItemStack(GwycraftItems.itemDyedMudBricks, 1, i), 0.1F);

            // --- Dyed torches: coal + dyed stick -> 4 torches ---
            Block torch = torchForColor(i);
            if (torch != null) {
                GameRegistry.addShapedRecipe(rl("dyed_torch_" + s), null,
                        new ItemStack(torch, 4), "X", "#", 'X', coal, '#', dyedSticks);
            }

            // --- Glowy wool ---
            GameRegistry.addShapelessRecipe(rl("glowy_wool_glowstone_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyWool, 4, i),
                    glowstone, wool, wool, wool, wool);
            GameRegistry.addShapelessRecipe(rl("glowy_wool_gem_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyWool, 8, i),
                    gem, anyWool, anyWool, anyWool, anyWool, anyWool, anyWool, anyWool, anyWool);

            // --- Dyed sand ---
            GameRegistry.addShapelessRecipe(rl("dyed_sand_" + s), null,
                    new ItemStack(GwycraftBlocks.blockDyedSand, 8, i),
                    dye, sand, sand, sand, sand, sand, sand, sand, sand);
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_sand_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedSand, 8, i),
                    gem, sand, sand, sand, sand, sand, sand, sand, sand);

            // --- Glowy cobblestone ---
            GameRegistry.addShapelessRecipe(rl("glowy_dyed_cobble_" + s), null,
                    new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 8, i),
                    gem, cobble, cobble, cobble, cobble, cobble, cobble, cobble, cobble);

            // --- Dyed glass (smelting dyed/glowy sand) ---
            if (GwycraftBlocks.blockDyedGlass != null)
                GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.blockDyedSand, 1, i),
                        new ItemStack(GwycraftBlocks.blockDyedGlass, 1, i), 0.1F);
            if (GwycraftBlocks.glowyblockDyedGlass != null)
                GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.glowyblockDyedSand, 1, i),
                        new ItemStack(GwycraftBlocks.glowyblockDyedGlass, 1, i), 0.1F);

            // --- Dyed sandstone (dye/gem + 8 vanilla sandstone → 8 dyed) ---
            if (GwycraftBlocks.blockDyedSandstone != null)
                GameRegistry.addShapelessRecipe(rl("dyed_sandstone_" + s), null,
                        new ItemStack(GwycraftBlocks.blockDyedSandstone, 8, i),
                        dye, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone);
            if (GwycraftBlocks.glowyblockDyedSandstone != null)
                GameRegistry.addShapelessRecipe(rl("glowy_dyed_sandstone_" + s), null,
                        new ItemStack(GwycraftBlocks.glowyblockDyedSandstone, 8, i),
                        gem, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone, sandstone);
            if (GwycraftBlocks.blockDyedChiseledSandstone != null)
                GameRegistry.addShapelessRecipe(rl("dyed_chiseled_sandstone_" + s), null,
                        new ItemStack(GwycraftBlocks.blockDyedChiseledSandstone, 8, i),
                        dye, chiseledSandstone, chiseledSandstone, chiseledSandstone, chiseledSandstone,
                        chiseledSandstone, chiseledSandstone, chiseledSandstone, chiseledSandstone);
            if (GwycraftBlocks.glowyblockDyedChiseledSandstone != null)
                GameRegistry.addShapelessRecipe(rl("glowy_dyed_chiseled_sandstone_" + s), null,
                        new ItemStack(GwycraftBlocks.glowyblockDyedChiseledSandstone, 8, i),
                        gem, chiseledSandstone, chiseledSandstone, chiseledSandstone, chiseledSandstone,
                        chiseledSandstone, chiseledSandstone, chiseledSandstone, chiseledSandstone);
            if (GwycraftBlocks.blockDyedSandstone != null && GwycraftBlocks.blockDyedSmoothSandstone != null)
                GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.blockDyedSandstone, 1, i),
                        new ItemStack(GwycraftBlocks.blockDyedSmoothSandstone, 1, i), 0.1F);
            if (GwycraftBlocks.glowyblockDyedSandstone != null && GwycraftBlocks.glowyblockDyedSmoothSandstone != null)
                GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.glowyblockDyedSandstone, 1, i),
                        new ItemStack(GwycraftBlocks.glowyblockDyedSmoothSandstone, 1, i), 0.1F);

            // --- Dyed bookcase (dyed planks + books) ---
            if (GwycraftBlocks.blockDyedBookcase != null)
                GameRegistry.addShapedRecipe(rl("dyed_bookcase_" + s), null,
                        new ItemStack(GwycraftBlocks.blockDyedBookcase, 1, i),
                        "###", "XXX", "###", '#', dyedPlank, 'X', book);
            if (GwycraftBlocks.glowyblockDyedBookcase != null)
                GameRegistry.addShapedRecipe(rl("glowy_dyed_bookcase_" + s), null,
                        new ItemStack(GwycraftBlocks.glowyblockDyedBookcase, 1, i),
                        "###", "XXX", "###", '#', glowyDyedPlank, 'X', book);

            // --- Dyed fences ---
            if (GwycraftBlocks.blockDyedFences != null)
                GameRegistry.addShapedRecipe(rl("dyed_fence_" + s), null,
                        new ItemStack(GwycraftBlocks.blockDyedFences, 2, i),
                        "XXX", "XXX", 'X', dyedSticks);
            if (GwycraftBlocks.glowyblockDyedFences != null)
                GameRegistry.addShapelessRecipe(rl("glowy_dyed_fence_" + s), null,
                        new ItemStack(GwycraftBlocks.glowyblockDyedFences, 8, i),
                        gem, fence, fence, fence, fence, fence, fence, fence, fence);

            // --- Dyed leaves (any vanilla leaf type + dye/gem) ---
            if (GwycraftBlocks.blockDyedLeaf != null)
                GameRegistry.addShapelessRecipe(rl("dyed_leaf_" + s), null,
                        new ItemStack(GwycraftBlocks.blockDyedLeaf, 8, i),
                        dye, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);
            if (GwycraftBlocks.glowyblockDyedLeaf != null)
                GameRegistry.addShapelessRecipe(rl("glowy_dyed_leaf_" + s), null,
                        new ItemStack(GwycraftBlocks.glowyblockDyedLeaf, 8, i),
                        gem, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);

            // --- Dyed logs (each of 4 vanilla log types → dyed log, log → dyed planks) ---
            if (dyedLogBlock != null || glowyDyedLogBlock != null) {
                for (int j = 0; j < 4; j++) {
                    Ingredient log = Ingredient.fromStacks(new ItemStack(Blocks.LOG, 1, j));
                    if (dyedLogBlock != null)
                        GameRegistry.addShapelessRecipe(rl("dyed_log_" + s + "_" + j), null,
                                new ItemStack(dyedLogBlock, 8, logMeta),
                                dye, log, log, log, log, log, log, log, log);
                    if (glowyDyedLogBlock != null)
                        GameRegistry.addShapelessRecipe(rl("glowy_dyed_log_" + s + "_" + j), null,
                                new ItemStack(glowyDyedLogBlock, 8, logMeta),
                                gem, log, log, log, log, log, log, log, log);
                }
                if (dyedLogBlock != null)
                    GameRegistry.addShapelessRecipe(rl("dyed_plank_from_log_" + s), null,
                            new ItemStack(GwycraftBlocks.blockDyedPlank, 4, i),
                            Ingredient.fromStacks(new ItemStack(dyedLogBlock, 1, logMeta)));
                if (glowyDyedLogBlock != null)
                    GameRegistry.addShapelessRecipe(rl("glowy_dyed_plank_from_log_" + s), null,
                            new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 4, i),
                            Ingredient.fromStacks(new ItemStack(glowyDyedLogBlock, 1, logMeta)));
            }
        }

        // --- Gem tools ---
        if (ConfigGwycraft.toolsEnabled) {
            Ingredient gemAny = new OreIngredient("gemGwycraft");
            Ingredient stick  = new OreIngredient("stickWood");
            GameRegistry.addShapedRecipe(rl("gem_shears"), null,
                    new ItemStack(GwycraftItems.itemGemShears),
                    " X", "X ", 'X', gemAny);
            GameRegistry.addShapedRecipe(rl("gem_hatchet_left"), null,
                    new ItemStack(GwycraftItems.itemGemHatchet),
                    "XX ", "XY ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_hatchet_right"), null,
                    new ItemStack(GwycraftItems.itemGemHatchet),
                    " XX", " YX", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_hoe_left"), null,
                    new ItemStack(GwycraftItems.itemGemHoe),
                    "XX ", " Y ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_hoe_right"), null,
                    new ItemStack(GwycraftItems.itemGemHoe),
                    " XX", " Y ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_pickaxe"), null,
                    new ItemStack(GwycraftItems.itemGemPickaxe),
                    "XXX", " Y ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_shovel"), null,
                    new ItemStack(GwycraftItems.itemGemShovel),
                    " X ", " Y ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_sword_left"), null,
                    new ItemStack(GwycraftItems.itemGemSword),
                    "X  ", "X  ", "Y  ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_sword_center"), null,
                    new ItemStack(GwycraftItems.itemGemSword),
                    " X ", " X ", " Y ", 'X', gemAny, 'Y', stick);
            GameRegistry.addShapedRecipe(rl("gem_sword_right"), null,
                    new ItemStack(GwycraftItems.itemGemSword),
                    "  X", "  X", "  Y", 'X', gemAny, 'Y', stick);
        }
    }

    private static ResourceLocation rl(String name) {
        return new ResourceLocation("gwycraft", name);
    }

    private static Block torchForColor(int i) {
        switch (i) {
            case  0: return GwycraftBlocks.blockWhiteDyedTorch;
            case  1: return GwycraftBlocks.blockOrangeDyedTorch;
            case  2: return GwycraftBlocks.blockMagentaDyedTorch;
            case  3: return GwycraftBlocks.blockLBlueDyedTorch;
            case  4: return GwycraftBlocks.blockYellowDyedTorch;
            case  5: return GwycraftBlocks.blockLGreenDyedTorch;
            case  6: return GwycraftBlocks.blockPinkDyedTorch;
            case  7: return GwycraftBlocks.blockDGrayDyedTorch;
            case  8: return GwycraftBlocks.blockLGrayDyedTorch;
            case  9: return GwycraftBlocks.blockCyanDyedTorch;
            case 10: return GwycraftBlocks.blockPurpleDyedTorch;
            case 11: return GwycraftBlocks.blockBlueDyedTorch;
            case 12: return GwycraftBlocks.blockBrownDyedTorch;
            case 13: return GwycraftBlocks.blockGreenDyedTorch;
            case 14: return GwycraftBlocks.blockRedDyedTorch;
            case 15: return GwycraftBlocks.blockBlackDyedTorch;
            default: return null;
        }
    }
}
