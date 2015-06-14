package gwydion0917.gwycraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gwydion0917.gwycraft.blocks.*;
import gwydion0917.gwycraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;


@Mod(modid = "gwycraft", name = "GwyCraft", version = "0.1.9a", guiFactory = "gwydion0917.gwycraft.client.GwyCraftGuiFactory")
public class Gwycraft {

    public static final String[] gwyColorNames = {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey", "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] gwyColorLog1Names = {"White", "Orange", "Magenta", "Light Blue"};
    public static final String[] gwyColorLog2Names = {"Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorLog3Names = {"Light Grey", "Cyan", "Purple", "Blue"};
    public static final String[] gwyColorLog4Names = {"Brown", "Green", "Red", "Black"};
    public static final String[] gwyColorSlab1Names = {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorSlab2Names = {"Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] gwyGemNames = {"Enchanted Quartz", "Enchanted Citrine", "Enchanted Tanzanite", "Enchanted Sapphire", "Enchanted Topaz", "Enchanted Agate", "Enchanted Garnet", "Enchanted Moonstone", "Enchanted Hematite", "Enchanted Aquamarine", "Enchanted Amethyst", "Enchanted Lapis Lazuli", "Enchanted Tigerseye", "Enchanted Emerald", "Enchanted Ruby", "Enchanted Onyx"};

    public static GwycraftWorldGenerator worldGen = new GwycraftWorldGenerator();
    public static GwycraftTab tabs = new GwycraftTab("GwyCraft");

    @Instance("Gwycraft")
    public static Gwycraft instance;

    @SidedProxy(clientSide = "gwydion0917.gwycraft.client.ClientProxy", serverSide = "gwydion0917.gwycraft.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Starting Pre-Init");
        FMLCommonHandler.instance().bus().register(new ConfigGwycraft());
        ConfigGwycraft.initConfig(event);

        GwycraftBlocks.init();
        
        GwycraftItems.init();

        CommonProxy.registerRenderers();

        // Any kind
        ItemStack anyCloth = new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE);
        ItemStack anyPlank = new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE);

        // Language Registry
        // 16 Meta
        for (int i = 0; i < 16; i++) {
            // Dye is inverted compared to wool
            ItemStack dye = new ItemStack(Items.dye, 1, 15 - i);
            ItemStack cloth = new ItemStack(Blocks.wool, 1, i);
            ItemStack glowyWoolStack = new ItemStack(GwycraftBlocks.glowyWool, 4, i);
            ItemStack blockglowyWool = new ItemStack(GwycraftBlocks.glowyWool, 1, i);
            ItemStack blockDyedStoneStack = new ItemStack(GwycraftBlocks.blockDyedStone, 1, i);
            ItemStack glowyblockDyedStoneStack = new ItemStack(GwycraftBlocks.glowyblockDyedStone, 1, i);
            ItemStack blockDyedBookcaseStack = new ItemStack(GwycraftBlocks.blockDyedBookcase, 1, i);
            ItemStack glowyblockDyedBookcaseStack = new ItemStack(GwycraftBlocks.glowyblockDyedBookcase, 1, i);
            ItemStack blockDyedPlankStack = new ItemStack(GwycraftBlocks.blockDyedPlank, 1, i);
            ItemStack glowyblockDyedPlankStack = new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 1, i);
            ItemStack blockDyedBrickStack = new ItemStack(GwycraftBlocks.blockDyedBrick, 1, i);
            ItemStack glowyblockDyedBrickStack = new ItemStack(GwycraftBlocks.glowyblockDyedBrick, 1, i);
            ItemStack blockDyedClayblockStack = new ItemStack(GwycraftBlocks.blockDyedClayblock, 1, i);
            ItemStack glowyblockDyedClayblockStack = new ItemStack(GwycraftBlocks.glowyblockDyedClayblock, 1, i);
            ItemStack blockDyedGlassStack = new ItemStack(GwycraftBlocks.blockDyedGlass, 1, i);
            ItemStack glowyblockDyedGlassStack = new ItemStack(GwycraftBlocks.glowyblockDyedGlass, 1, i);
            ItemStack blockDyedLeafStack = new ItemStack(GwycraftBlocks.blockDyedLeaf, 1, i);
            ItemStack glowyblockDyedLeafStack = new ItemStack(GwycraftBlocks.glowyblockDyedLeaf, 1, i);
            ItemStack blockDyedMudBrickStack = new ItemStack(GwycraftBlocks.blockDyedMudBrick, 1, i);
            ItemStack glowyblockDyedMudBrickStack = new ItemStack(GwycraftBlocks.glowyblockDyedMudBrick, 1, i);
            ItemStack blockDyedSandStack = new ItemStack(GwycraftBlocks.blockDyedSand, 1, i);
            ItemStack glowyblockDyedSandStack = new ItemStack(GwycraftBlocks.glowyblockDyedSand, 1, i);
            ItemStack blockDyedSandstoneStack = new ItemStack(GwycraftBlocks.blockDyedSandstone, 1, i);
            ItemStack glowyblockDyedSandstoneStack = new ItemStack(GwycraftBlocks.glowyblockDyedSandstone, 1, i);
            ItemStack blockDyedStoneBrickStack = new ItemStack(GwycraftBlocks.blockDyedStoneBrick, 1, i);
            ItemStack glowyblockDyedStoneBrickStack = new ItemStack(GwycraftBlocks.glowyblockDyedStoneBrick, 1, i);
            ItemStack blockDyedStonecobbleStack = new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 1, i);
            ItemStack glowyblockDyedStonecobbleStack = new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 1, i);
            ItemStack blockGemCompressedStack = new ItemStack(GwycraftBlocks.blockGemCompressed, 1, i);
            ItemStack blockGemOreStack = new ItemStack(GwycraftBlocks.blockGemOre, 1, i);
            ItemStack itemEnchantedGemsStack = new ItemStack(GwycraftItems.itemEnchantedGems, 1, i);
            ItemStack itemDyedClayStack = new ItemStack(GwycraftItems.itemDyedClay, 1, i);
            ItemStack itemDyedClayBricksStack = new ItemStack(GwycraftItems.itemDyedClayBricks, 1, i);
            ItemStack itemDyedMudStack = new ItemStack(GwycraftItems.itemDyedMud, 1, i);
            ItemStack itemDyedMudBricksStack = new ItemStack(GwycraftItems.itemDyedMudBricks, 1, i);
            ItemStack blockDyedFencesStack = new ItemStack(GwycraftBlocks.blockDyedFences, 1, i);
            ItemStack glowyblockDyedFencesStack = new ItemStack(GwycraftBlocks.glowyblockDyedFences, 1, i);
            ItemStack blockDyedCobbleWallsStack = new ItemStack(GwycraftBlocks.blockDyedCobbleWalls, 1, i);
            ItemStack glowyblockDyedCobbleWallsStack = new ItemStack(GwycraftBlocks.glowyblockDyedCobbleWalls, 1, i);
            ItemStack itemDyedSticksStack = new ItemStack(GwycraftItems.itemDyedSticks, 1, i);
            ItemStack blockDyedStonePaverStack = new ItemStack(GwycraftBlocks.blockDyedStonePaver, 1, i);
            ItemStack blockDyedBrickPaverStack = new ItemStack(GwycraftBlocks.blockDyedBrickPaver, 1, i);
            ItemStack blockDyedMudBrickPaverStack = new ItemStack(GwycraftBlocks.blockDyedMudBrickPaver, 1, i);
            ItemStack blockDyedStoneBrickPaverStack = new ItemStack(GwycraftBlocks.blockDyedStoneBrickPaver, 1, i);
            ItemStack blockDyedStoneCobblePaverStack = new ItemStack(GwycraftBlocks.blockDyedStoneCobblePaver, 1, i);

            //  Add Recipes
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedBookcase, 1, i), "###", "XXX", "###", '#', blockDyedPlankStack, 'X', Items.book);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedBookcase, 1, i), "###", "XXX", "###", '#', glowyblockDyedPlankStack, 'X', Items.book);
            GameRegistry.addRecipe(new ItemStack(GwycraftItems.itemDyedSticks, 4, i), "X", "X", 'X', blockDyedPlankStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockGemCompressed, 1, i), "XX", "XX", 'X', itemEnchantedGemsStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftItems.itemEnchantedGems, 4, i), "X", 'X', blockGemCompressedStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedStoneBrick, 4, i), "xx", "xx", 'x', blockDyedStoneStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedStoneBrick, 4, i), "XX", "XX", 'X', glowyblockDyedStoneStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedFences, 2, i), "XXX", "XXX", 'X', itemDyedSticksStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedMudBrick, 4, i), "XX", "XX", 'X', itemDyedMudBricksStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedClayblock, 1, i), "XX", "XX", 'X', itemDyedClayStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedBrick, 1, i), "XX", "XX", 'X', itemDyedClayBricksStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedCobbleWalls, 6, i), "XXX", "XXX", 'X', blockDyedStonecobbleStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedCobbleWalls, 6, i), "XXX", "XXX", 'X', glowyblockDyedStonecobbleStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedStonePaver, 3, i), "XX", 'X', blockDyedStoneStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedBrickPaver, 3, i), "XX", 'X', blockDyedBrickStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedStoneBrickPaver, 3, i), "XX", 'X', blockDyedStoneBrickStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedMudBrickPaver, 3, i), "XX", 'X', blockDyedMudBrickStack);
            GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDyedStoneCobblePaver, 3, i), "XX", 'X', blockDyedStonecobbleStack);

            // Add Shapeless Recipes
            GameRegistry.addShapelessRecipe(glowyWoolStack, new ItemStack(Blocks.glowstone), cloth, cloth, cloth, cloth);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyWool, 8, i), itemEnchantedGemsStack, anyCloth, anyCloth, anyCloth, anyCloth, anyCloth, anyCloth, anyCloth, anyCloth);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedSand, 8, i), dye, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedSand, 8, i), itemEnchantedGemsStack, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand, Blocks.sand);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedSandstone, 8, i), dye, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedSandstone, 8, i), itemEnchantedGemsStack, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone, Blocks.sandstone);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedPlank, 8, i), dye, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 8, i), itemEnchantedGemsStack, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank, anyPlank);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 4, 15 - i), itemEnchantedGemsStack, Items.gunpowder, Items.glass_bottle);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftItems.itemDyedMud, 16, i), Blocks.dirt, Blocks.dirt, Blocks.dirt, Blocks.dirt, Blocks.dirt, Blocks.dirt, Items.clay_ball, Items.potionitem, dye);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftItems.itemDyedClay, 8, i), Items.clay_ball, Items.clay_ball, Items.clay_ball, Items.clay_ball, Items.clay_ball, Items.clay_ball, Items.clay_ball, Items.clay_ball, dye);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedClayblock, 8, i), itemEnchantedGemsStack, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay, Blocks.clay);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedBrick, 8, i), itemEnchantedGemsStack, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block, Blocks.brick_block);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedFences, 8, i), itemEnchantedGemsStack, Blocks.fence, Blocks.fence, Blocks.fence, Blocks.fence, Blocks.fence, Blocks.fence, Blocks.fence, Blocks.fence);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedMudBrick, 8, i), Blocks.glowstone, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack);

            // Add Furnace Recipes
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 1, i), new ItemStack(GwycraftBlocks.blockDyedStone, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 1, i), new ItemStack(GwycraftBlocks.glowyblockDyedStone, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.blockDyedSand, 1, i), new ItemStack(GwycraftBlocks.blockDyedGlass, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftBlocks.glowyblockDyedSand, 1, i), new ItemStack(GwycraftBlocks.glowyblockDyedGlass, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftItems.itemDyedMud, 1, i), new ItemStack(GwycraftItems.itemDyedMudBricks, 1, i), 0.1F);
            GameRegistry.addSmelting(new ItemStack(GwycraftItems.itemDyedClay, 1, i), new ItemStack(GwycraftItems.itemDyedClayBricks, 1, i), 0.1F);

            // Ore Dictionary
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 8, i), dye, "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 8, i), itemEnchantedGemsStack, "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone", "cobblestone"));

            // Recipes for Dyed Leaves
            for (int j = 0; j < 4; j++) {
                ItemStack leaf = new ItemStack(Blocks.leaves, 1, j);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedLeaf, 8, i), dye, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedLeaf, 8, i), itemEnchantedGemsStack, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);
            }

            // Recipes for Dyed Torches
            if (i == 0)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockWhiteDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 1)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockOrangeDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 2)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockMagentaDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 3)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockLBlueDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 4)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockYellowDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 5)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockLGreenDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 6)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockPinkDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 7)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockDGrayDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 8)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockLGrayDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 9)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockCyanDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 10)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockPurpleDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 11)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockBlueDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 12)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockBrownDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 13)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockGreenDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 14)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockRedDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
            else if (i == 15)
                GameRegistry.addRecipe(new ItemStack(GwycraftBlocks.blockBlackDyedTorch, 4), "X", "#", 'X', Items.coal, '#', itemDyedSticksStack);
        }

        // 4 Meta
        for (int i = 0; i < 4; i++) {

            // Item Stacks
            ItemStack blockDyedLog1Stack = new ItemStack(GwycraftBlocks.blockDyedLog1, 1, i);
            ItemStack blockDyedLog2Stack = new ItemStack(GwycraftBlocks.blockDyedLog2, 1, i);
            ItemStack blockDyedLog3Stack = new ItemStack(GwycraftBlocks.blockDyedLog3, 1, i);
            ItemStack blockDyedLog4Stack = new ItemStack(GwycraftBlocks.blockDyedLog4, 1, i);
            ItemStack dye1 = new ItemStack(Items.dye, 1, 15 - i);
            ItemStack dye2 = new ItemStack(Items.dye, 1, 11 - i);
            ItemStack dye3 = new ItemStack(Items.dye, 1, 7 - i);
            ItemStack dye4 = new ItemStack(Items.dye, 1, 3 - i);
            ItemStack glowyblockDyedLog1Stack = new ItemStack(GwycraftBlocks.glowyblockDyedLog1, 1, i);
            ItemStack glowyblockDyedLog2Stack = new ItemStack(GwycraftBlocks.glowyblockDyedLog2, 1, i);
            ItemStack glowyblockDyedLog3Stack = new ItemStack(GwycraftBlocks.glowyblockDyedLog3, 1, i);
            ItemStack glowyblockDyedLog4Stack = new ItemStack(GwycraftBlocks.glowyblockDyedLog4, 1, i);
            ItemStack itemEnchantedGemsStack1 = new ItemStack(GwycraftItems.itemEnchantedGems, 1, i);
            ItemStack itemEnchantedGemsStack2 = new ItemStack(GwycraftItems.itemEnchantedGems, 1, i + 4);
            ItemStack itemEnchantedGemsStack3 = new ItemStack(GwycraftItems.itemEnchantedGems, 1, i + 8);
            ItemStack itemEnchantedGemsStack4 = new ItemStack(GwycraftItems.itemEnchantedGems, 1, i + 12);

            //  Add Recipes
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedPlank, 4, i), blockDyedLog1Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedPlank, 4, i + 4), blockDyedLog2Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedPlank, 4, i + 8), blockDyedLog3Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedPlank, 4, i + 12), blockDyedLog4Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 4, i), glowyblockDyedLog1Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 4, i + 4), glowyblockDyedLog2Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 4, i + 8), glowyblockDyedLog3Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 4, i + 12), glowyblockDyedLog4Stack);

            // Recipes for Dyed Leaves
            for (int j = 0; j < 4; j++) {
                ItemStack log = new ItemStack(Blocks.log, 1, j);

                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedLog1, 8, i), dye1, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedLog2, 8, i), dye2, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedLog3, 8, i), dye3, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.blockDyedLog4, 8, i), dye4, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedLog1, 8, i), itemEnchantedGemsStack1, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedLog2, 8, i), itemEnchantedGemsStack2, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedLog3, 8, i), itemEnchantedGemsStack3, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(GwycraftBlocks.glowyblockDyedLog4, 8, i), itemEnchantedGemsStack4, log, log, log, log, log, log, log, log);
            }
        }

        // Ore Dictionary
        OreDictionary.registerOre("gemGwycraft", new ItemStack(GwycraftItems.itemEnchantedGems, 1, OreDictionary.WILDCARD_VALUE));

        // Recipes
        if (ConfigGwycraft.toolsEnabled) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemShears, 1), " X", "X ", 'X', "gemGwycraft"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemHatchet, 1), "XX ", "XY ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemHatchet, 1), " XX", " YX", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemHoe, 1), "XX ", " Y ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemHoe, 1), " XX", " Y ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemPickaxe, 1), "XXX", " Y ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemShovel, 1), " X ", " Y ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemSword, 1), "X  ", "X  ", "Y  ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemSword, 1), " X ", " X ", " Y ", 'X', "gemGwycraft", 'Y', "stickWood"));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GwycraftItems.itemGemSword, 1), "  X", "  X", "  Y", 'X', "gemGwycraft", 'Y', "stickWood"));
        }
        LogHelper.info("Pre-Init Complete");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.info("Starting Init");
        GameRegistry.registerWorldGenerator(worldGen, 0);
        LogHelper.info("Doing IMC");
        InterModCommunication.initIMC();
        LogHelper.info("Init Complete");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
        LogHelper.info("Starting Post-Init");
        LogHelper.info("Post-Init Complete");
    }


}