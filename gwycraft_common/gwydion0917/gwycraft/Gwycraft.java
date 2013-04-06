package gwydion0917.gwycraft;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.Arrays;
import java.util.logging.Level;

import gwydion0917.gwycraft.CommonProxy;
import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.blocks.BlockGemCompressed;
import gwydion0917.gwycraft.blocks.BlockGemOre;
import gwydion0917.gwycraft.blocks.DyedBookcase;
import gwydion0917.gwycraft.blocks.DyedBrick;
import gwydion0917.gwycraft.blocks.DyedClayblock;
import gwydion0917.gwycraft.blocks.DyedGlass;
import gwydion0917.gwycraft.blocks.DyedLeaf;
import gwydion0917.gwycraft.blocks.DyedLog1;
import gwydion0917.gwycraft.blocks.DyedLog2;
import gwydion0917.gwycraft.blocks.DyedLog3;
import gwydion0917.gwycraft.blocks.DyedLog4;
import gwydion0917.gwycraft.blocks.DyedMudbrick;
import gwydion0917.gwycraft.blocks.DyedMudbrickStairs;
import gwydion0917.gwycraft.blocks.DyedPlank;
import gwydion0917.gwycraft.blocks.DyedSand;
import gwydion0917.gwycraft.blocks.DyedStone;
import gwydion0917.gwycraft.blocks.DyedStoneCobble;
import gwydion0917.gwycraft.blocks.DyedStoneSlab1;
import gwydion0917.gwycraft.blocks.DyedStoneSlab2;
import gwydion0917.gwycraft.blocks.DyedStonebrick;
import gwydion0917.gwycraft.blocks.GlowyWool;
import gwydion0917.gwycraft.blocks.dyedItemBookcase;
import gwydion0917.gwycraft.blocks.dyedItemBrick;
import gwydion0917.gwycraft.blocks.dyedItemClayblock;
import gwydion0917.gwycraft.blocks.dyedItemGlass;
import gwydion0917.gwycraft.blocks.dyedItemLeaf;
import gwydion0917.gwycraft.blocks.dyedItemLog1;
import gwydion0917.gwycraft.blocks.dyedItemLog2;
import gwydion0917.gwycraft.blocks.dyedItemLog3;
import gwydion0917.gwycraft.blocks.dyedItemLog4;
import gwydion0917.gwycraft.blocks.dyedItemMudbrick;
import gwydion0917.gwycraft.blocks.dyedItemPlank;
import gwydion0917.gwycraft.blocks.dyedItemSand;
import gwydion0917.gwycraft.blocks.dyedItemStone;
import gwydion0917.gwycraft.blocks.dyedItemStonebrick;
import gwydion0917.gwycraft.blocks.dyedItemStonecobble;
import gwydion0917.gwycraft.blocks.glowyItemWool;
import gwydion0917.gwycraft.items.ItemFlawedAgate;
import gwydion0917.gwycraft.items.ItemFlawedAmethyst;
import gwydion0917.gwycraft.items.ItemFlawedAquamarine;
import gwydion0917.gwycraft.items.ItemFlawedCitrine;
import gwydion0917.gwycraft.items.ItemFlawedEmerald;
import gwydion0917.gwycraft.items.ItemFlawedGarnet;
import gwydion0917.gwycraft.items.ItemFlawedHematite;
import gwydion0917.gwycraft.items.ItemFlawedLapis;
import gwydion0917.gwycraft.items.ItemFlawedMoonstone;
import gwydion0917.gwycraft.items.ItemFlawedOnyx;
import gwydion0917.gwycraft.items.ItemFlawedQuartz;
import gwydion0917.gwycraft.items.ItemFlawedRuby;
import gwydion0917.gwycraft.items.ItemFlawedSapphire;
import gwydion0917.gwycraft.items.ItemFlawedTanzanite;
import gwydion0917.gwycraft.items.ItemFlawedTigerseye;
import gwydion0917.gwycraft.items.ItemFlawedTopaz;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "GwyCraft", name = "GwyCraft", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Gwycraft {

	public static final String[] gwyColorNames = { "White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey", "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };
    public static final String[] gwyColorLog1Names = { "White", "Orange", "Magenta", "Light Blue" };
    public static final String[] gwyColorLog2Names = { "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorLog3Names = { "Light Grey", "Cyan", "Purple", "Blue"};
    public static final String[] gwyColorLog4Names = { "Brown", "Green", "Red", "Black" };
    public static final String[] gwyColorSlab1Names = { "White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorSlab2Names = { "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

    public static Block glowyWool;
    public static Block dyedStone;
    public static DyedStoneSlab1 dyedStoneSlab1;
    public static DyedStoneSlab1 dyedStoneDoubleSlab1;
    public static DyedStoneSlab2 dyedStoneSlab2;
    public static DyedStoneSlab2 dyedStoneDoubleSlab2;
    public static BlockBookshelf dyedBookcase;
    public static Block dyedBrick;
    public static Block dyedClayblock;
    public static Block dyedGlass;
    public static Block dyedLeaf;
    public static Block dyedLog1;
    public static Block dyedLog2;
    public static Block dyedLog3;
    public static Block dyedLog4;
    public static Block dyedMudbrick;
    public static Block dyedPlank;
    public static Block dyedSand;
    public static Block dyedStonebrick;
    public static Block dyedStonecobble;
    public static Block dyedMudbrickStairs;
    public static Block blockGemOre;
    public static Block blockGemCompressed;

    public static Item flawedAgate;
    public static Item flawedAmethyst;
    public static Item flawedAquamarine;
    public static Item flawedCitrine;
    public static Item flawedEmerald;
    public static Item flawedGarnet;
    public static Item flawedHematite;
    public static Item flawedLapis;
    public static Item flawedOnyx;
    public static Item flawedQuartz;
    public static Item flawedRuby;
    public static Item flawedSapphire;
    public static Item flawedTanzanite;
    public static Item flawedTigerseye;
    public static Item flawedTopaz;
    public static Item flawedMoonstone;

	@Instance("Gwycraft")
	public static Gwycraft instance;

	@SidedProxy(clientSide = "gwydion0917.gwycraft.client.ClientProxy", serverSide = "gwydion0917.gwycraft.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

	}
	@Init
	public void init(FMLInitializationEvent event) {
		glowyWool = new GlowyWool(ConfigGwycraft.glowyWoolID, Material.cloth).setHardness(0.8F).setStepSound(Block.cloth.stepSound).setUnlocalizedName("Gwycraft:glowyWool").setLightValue(1f).setCreativeTab(CreativeTabs.tabBlock);
		dyedStone = new DyedStone(ConfigGwycraft.dyedStoneID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:dyedStone").setCreativeTab(CreativeTabs.tabBlock);
		dyedStoneSlab1 = (DyedStoneSlab1) new DyedStoneSlab1(ConfigGwycraft.dyedStoneSlab1ID, false, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneSlab1").setHardness(2.0F).setCreativeTab(CreativeTabs.tabBlock);
		dyedStoneDoubleSlab1 = (DyedStoneSlab1) new DyedStoneSlab1(ConfigGwycraft.dyedStoneDoubleSlab1ID, true, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab1").setHardness(2.0F);
		dyedStoneSlab2 = (DyedStoneSlab2) new DyedStoneSlab2(ConfigGwycraft.dyedStoneSlab2ID, false, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneSlab2").setHardness(2.0F).setCreativeTab(CreativeTabs.tabBlock);
		dyedStoneDoubleSlab2 = (DyedStoneSlab2) new DyedStoneSlab2(ConfigGwycraft.dyedStoneDoubleSlab2ID, true, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab2").setHardness(2.0F);
		dyedBookcase = (BlockBookshelf) new DyedBookcase(ConfigGwycraft.dyedBookcaseID, Material.wood).setHardness(1.5F).setStepSound(Block.wood.stepSound).setUnlocalizedName("Gwycraft:dyedBookcase");
		dyedBrick = new DyedBrick(ConfigGwycraft.dyedBrickID);
		dyedClayblock = new DyedClayblock(ConfigGwycraft.dyedClayblockID);
		dyedGlass = new DyedGlass(ConfigGwycraft.dyedGlassID);
		dyedLeaf = new DyedLeaf(ConfigGwycraft.dyedLeafID);
		dyedMudbrick = new DyedMudbrick(ConfigGwycraft.dyedMudbrickID);
		dyedPlank = new DyedPlank(ConfigGwycraft.dyedPlankID).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Gwycraft:dyedPlank");
		dyedSand = new DyedSand(ConfigGwycraft.dyedSandID);
		dyedStonebrick = new DyedStonebrick(ConfigGwycraft.dyedStonebrickID);
		dyedStonecobble = new DyedStoneCobble(ConfigGwycraft.dyedStonecobbleID, Material.rock).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Gwycraft:dyedStonecobble").setCreativeTab(CreativeTabs.tabBlock);
		dyedMudbrickStairs = new DyedMudbrickStairs(ConfigGwycraft.dyedMudbrickStairsID, dyedMudbrick, 0).setUnlocalizedName("Gwycraft:DyedMudbrickStairs");
        dyedLog1 = new DyedLog1(ConfigGwycraft.dyedLog1ID);
        dyedLog2 = new DyedLog2(ConfigGwycraft.dyedLog2ID);
        dyedLog3 = new DyedLog3(ConfigGwycraft.dyedLog3ID);
        dyedLog4 = new DyedLog4(ConfigGwycraft.dyedLog4ID);
        blockGemOre = new BlockGemOre(ConfigGwycraft.blockGemOreID).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("gemOre");
        blockGemCompressed = new BlockGemCompressed(ConfigGwycraft.blockGemOreID).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("gemOreCompressed");
        
        flawedAgate = new ItemFlawedAgate(ConfigGwycraft.flawedAgateID).setUnlocalizedName("Gwycraft:flawedAgate").setCreativeTab(CreativeTabs.tabMaterials);
        flawedAmethyst = new ItemFlawedAmethyst(ConfigGwycraft.flawedAmethystID).setUnlocalizedName("Gwycraft:flawedAmethyst").setCreativeTab(CreativeTabs.tabMaterials);
        flawedAquamarine = new ItemFlawedAquamarine(ConfigGwycraft.flawedAquamarineID).setUnlocalizedName("Gwycraft:flawedAquamarine").setCreativeTab(CreativeTabs.tabMaterials);
        flawedCitrine = new ItemFlawedCitrine(ConfigGwycraft.flawedCitrineID).setUnlocalizedName("Gwycraft:flawedCitrine").setCreativeTab(CreativeTabs.tabMaterials);
        flawedEmerald = new ItemFlawedEmerald(ConfigGwycraft.flawedEmeraldID).setUnlocalizedName("Gwycraft:flawedEmerald").setCreativeTab(CreativeTabs.tabMaterials);
        flawedGarnet = new ItemFlawedGarnet(ConfigGwycraft.flawedGarnetID).setUnlocalizedName("Gwycraft:flawedGarnet").setCreativeTab(CreativeTabs.tabMaterials);
        flawedHematite = new ItemFlawedHematite(ConfigGwycraft.flawedHematiteID).setUnlocalizedName("Gwycraft:flawedHematite").setCreativeTab(CreativeTabs.tabMaterials);
        flawedLapis = new ItemFlawedLapis(ConfigGwycraft.flawedLapisID).setCreativeTab(CreativeTabs.tabMaterials);
        flawedOnyx = new ItemFlawedOnyx(ConfigGwycraft.flawedOnyxID).setUnlocalizedName("Gwycraft:flawedOnyx").setCreativeTab(CreativeTabs.tabMaterials);
        flawedQuartz = new ItemFlawedQuartz(ConfigGwycraft.flawedQuartzID).setUnlocalizedName("Gwycraft:flawedQuartz").setCreativeTab(CreativeTabs.tabMaterials);
        flawedRuby = new ItemFlawedRuby(ConfigGwycraft.flawedRubyID).setUnlocalizedName("Gwycraft:flawedRuby").setCreativeTab(CreativeTabs.tabMaterials);
        flawedSapphire = new ItemFlawedSapphire(ConfigGwycraft.flawedSapphireID).setUnlocalizedName("Gwycraft:flawedSapphire").setCreativeTab(CreativeTabs.tabMaterials);
        flawedTanzanite = new ItemFlawedTanzanite(ConfigGwycraft.flawedTanzaniteID).setUnlocalizedName("Gwycraft:flawedTanzanite").setCreativeTab(CreativeTabs.tabMaterials);
        flawedTigerseye = new ItemFlawedTigerseye(ConfigGwycraft.flawedTigerseyeID).setUnlocalizedName("Gwycraft:flawedTigerseye").setCreativeTab(CreativeTabs.tabMaterials);
        flawedTopaz = new ItemFlawedTopaz(ConfigGwycraft.flawedTopazID).setUnlocalizedName("Gwycraft:flawedTopaz").setCreativeTab(CreativeTabs.tabMaterials);
        flawedMoonstone = new ItemFlawedMoonstone(ConfigGwycraft.flawedMoonstoneID).setUnlocalizedName("Gwycraft:flawedMoonstone").setCreativeTab(CreativeTabs.tabMaterials);


        CommonProxy.registerRenderers();

        //  GameRegistry Register Blocks
        GameRegistry.registerBlock(glowyWool, glowyItemWool.class, "glowyWool");
        GameRegistry.registerBlock(dyedStone, dyedItemStone.class, "dyedStone");
        GameRegistry.registerBlock(dyedStoneSlab1, "dyedStoneSlab1");
        GameRegistry.registerBlock(dyedStoneSlab2, "dyedStoneSlab2");
        GameRegistry.registerBlock(dyedBookcase, dyedItemBookcase.class, "dyedBookcase");
        GameRegistry.registerBlock(dyedPlank, dyedItemPlank.class, "dyedPlank");
        GameRegistry.registerBlock(dyedBrick, dyedItemBrick.class, "dyedBrick");
        GameRegistry.registerBlock(dyedClayblock, dyedItemClayblock.class, "dyedClayblock");
        GameRegistry.registerBlock(dyedGlass, dyedItemGlass.class, "dyedGlass");
        GameRegistry.registerBlock(dyedLeaf, dyedItemLeaf.class, "dyedLeaf");
        GameRegistry.registerBlock(dyedLog1, dyedItemLog1.class, "dyedLog1");
        GameRegistry.registerBlock(dyedLog2, dyedItemLog2.class, "dyedLog2");
        GameRegistry.registerBlock(dyedLog3, dyedItemLog3.class, "dyedLog3");
        GameRegistry.registerBlock(dyedLog4, dyedItemLog4.class, "dyedLog4");
        GameRegistry.registerBlock(dyedMudbrick, dyedItemMudbrick.class, "dyedMudbrick");
        GameRegistry.registerBlock(dyedSand, dyedItemSand.class, "dyedSand");
        GameRegistry.registerBlock(dyedStonebrick, dyedItemStonebrick.class,"dyedStonebrick");
        GameRegistry.registerBlock(dyedStonecobble, dyedItemStonecobble.class, "dyedStonecobble");
		
        Item.itemsList[ConfigGwycraft.dyedStoneSlab1ID] = (new ItemSlab (ConfigGwycraft.dyedStoneSlab1ID - 256, dyedStoneSlab1, dyedStoneDoubleSlab1, false)).setUnlocalizedName("woodSlab");
        Item.itemsList[dyedStoneDoubleSlab1.blockID] = (new ItemSlab (ConfigGwycraft.dyedStoneDoubleSlab1ID - 256, dyedStoneSlab1, dyedStoneDoubleSlab1, true)).setUnlocalizedName("woodSlab");
        Item.itemsList[ConfigGwycraft.dyedStoneSlab2ID] = (new ItemSlab (ConfigGwycraft.dyedStoneSlab2ID - 256, dyedStoneSlab2, dyedStoneDoubleSlab2, false)).setUnlocalizedName("woodSlab");
        Item.itemsList[dyedStoneDoubleSlab2.blockID] = (new ItemSlab (ConfigGwycraft.dyedStoneDoubleSlab2ID - 256, dyedStoneSlab2, dyedStoneDoubleSlab2, true)).setUnlocalizedName("woodSlab");


        // Language Registry
        // 16 Meta
        for (int i = 0; i < 16; i++) {
			ItemStack cloth = new ItemStack(Block.cloth, 1, i);
			ItemStack glowyWoolStack = new ItemStack(glowyWool, 1, i);
			ItemStack gsDust = new ItemStack(Item.lightStoneDust, 1);
            ItemStack dyedStoneStack = new ItemStack(dyedStone, 1, i);
            ItemStack dyedBookcaseStack = new ItemStack(dyedBookcase, 1, i);
            ItemStack dyedPlankStack = new ItemStack(dyedPlank, 1, i);
            ItemStack dyedBrickStack = new ItemStack(dyedBrick, 1, i);
            ItemStack dyedClayblockStack = new ItemStack(dyedClayblock, 1, i);
            ItemStack dyedGlassStack = new ItemStack(dyedGlass, 1, i);
            ItemStack dyedLeafStack = new ItemStack(dyedLeaf, 1, i);
            ItemStack dyedMudbrickStack = new ItemStack(dyedMudbrick, 1, i);
            ItemStack dyedSandStack = new ItemStack(dyedSand, 1, i);
            ItemStack dyedStonebrickStack = new ItemStack(dyedStonebrick, 1, i);
            ItemStack dyedStonecobbleStack = new ItemStack(dyedStonecobble, 1, i);
			
            // Language Registry
			LanguageRegistry.addName(glowyWoolStack, "Glowy " + gwyColorNames[glowyWoolStack.getItemDamage()] + " Wool");
			LanguageRegistry.addName(dyedStoneStack, gwyColorNames[dyedStoneStack.getItemDamage()] + " Stone");
		    LanguageRegistry.addName(dyedBookcaseStack, gwyColorNames[dyedBookcaseStack.getItemDamage()] + " Bookcase");
            LanguageRegistry.addName(dyedPlankStack, gwyColorNames[dyedPlankStack.getItemDamage()] + " Plank");
			LanguageRegistry.addName(dyedBrickStack, gwyColorNames[dyedBrickStack.getItemDamage()] + " Brick");
			LanguageRegistry.addName(dyedClayblockStack, gwyColorNames[dyedClayblockStack.getItemDamage()] + " Clay Block");
			LanguageRegistry.addName(dyedGlassStack, gwyColorNames[dyedGlassStack.getItemDamage()] + " Glass");
			LanguageRegistry.addName(dyedLeafStack, gwyColorNames[dyedLeafStack.getItemDamage()] + " Leaf");
            LanguageRegistry.addName(dyedMudbrickStack, gwyColorNames[dyedMudbrickStack.getItemDamage()] + " Mud Brick");
            LanguageRegistry.addName(dyedSandStack, gwyColorNames[dyedSandStack.getItemDamage()] + " Sand");
            LanguageRegistry.addName(dyedStonebrickStack, gwyColorNames[dyedStonebrickStack.getItemDamage()] + " Stone Brick");
            LanguageRegistry.addName(dyedStonecobbleStack, gwyColorNames[dyedStonecobbleStack.getItemDamage()] + " Cobblestone");

            //  Add Recipes
            GameRegistry.addRecipe(new ItemStack(dyedBookcase, 1, i), "###", "XXX", "###", '#', dyedPlankStack, 'X', Item.book);
            GameRegistry.addRecipe(new ItemStack(dyedStonebrick, 4, i), "xx", "xx", 'x', dyedStoneStack);
            GameRegistry.addRecipe(glowyWoolStack, " x ", "xyx", " x ", 'y', cloth, 'x', gsDust);
            GameRegistry.addShapelessRecipe(glowyWoolStack, new ItemStack(Block.glowStone), cloth);
            FurnaceRecipes.smelting().addSmelting(dyedStonecobble.blockID, i, new ItemStack(dyedStone, 1, i ), 0.1F);
            FurnaceRecipes.smelting().addSmelting(dyedSand.blockID, i, new ItemStack(dyedGlass, 1, i ), 0.1F);
        }
        
        // 8 Meta
        for (int i = 0; i < 8; i++) {

            // Item Stacks
            ItemStack dyedStoneSlab1Stack = new ItemStack(dyedStoneSlab1, 1, i);
            ItemStack dyedStoneSlab2Stack = new ItemStack(dyedStoneSlab2, 1, i);
            ItemStack dyedStone1Stack = new ItemStack(dyedStone, 8, i);
            ItemStack dyedStone2Stack = new ItemStack(dyedStone, 8, i+8);

            // Language Registry
            LanguageRegistry.addName(dyedStoneSlab1Stack, gwyColorSlab1Names[dyedStoneSlab1Stack.getItemDamage()] + " Stone Slab");
            LanguageRegistry.addName(dyedStoneSlab2Stack, gwyColorSlab2Names[dyedStoneSlab2Stack.getItemDamage()] + " Stone Slab");

            //  Add Recipes
            GameRegistry.addRecipe(new ItemStack(dyedStoneSlab1, 6, i), "XXX", 'X', dyedStone1Stack);
            GameRegistry.addRecipe(new ItemStack(dyedStoneSlab2, 6, i), "XXX", 'X', dyedStone2Stack);
        }        
   
        // 4 Meta
        for (int i = 0; i < 4; i++) {

            // Item Stacks
            ItemStack dyedLog1Stack = new ItemStack(dyedLog1, 1, i);
            ItemStack dyedLog2Stack = new ItemStack(dyedLog2, 1, i);
            ItemStack dyedLog3Stack = new ItemStack(dyedLog3, 1, i);
            ItemStack dyedLog4Stack = new ItemStack(dyedLog4, 1, i);

            // Language Registry
            LanguageRegistry.addName(dyedLog1Stack, gwyColorLog1Names[dyedLog1Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog2Stack, gwyColorLog2Names[dyedLog2Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog3Stack, gwyColorLog3Names[dyedLog3Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog4Stack, gwyColorLog4Names[dyedLog4Stack.getItemDamage()] + " Log");

            //  Add Recipes
            GameRegistry.addShapelessRecipe(new ItemStack(dyedPlank, 4, i), dyedLog1Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(dyedPlank, 4, i+4), dyedLog2Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(dyedPlank, 4, i+8), dyedLog3Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(dyedPlank, 4, i+12), dyedLog4Stack);
        }

        // Items
        // Language Registry
        LanguageRegistry.addName(flawedAgate, "Flawed Agate");
        LanguageRegistry.addName(flawedAmethyst, "Flawed Amethyst");
        LanguageRegistry.addName(flawedAquamarine, "Flawed Aquamarine");
        LanguageRegistry.addName(flawedCitrine, "Flawed Citrine");
        LanguageRegistry.addName(flawedEmerald, "Flawed Emerald");
        LanguageRegistry.addName(flawedGarnet, "Flawed Garnet");
        LanguageRegistry.addName(flawedHematite, "Flawed Hematite");
        LanguageRegistry.addName(flawedLapis, "Flawed Lapis");
        LanguageRegistry.addName(flawedOnyx, "Flawed Onyx");
        LanguageRegistry.addName(flawedQuartz, "Flawed Quartz");
        LanguageRegistry.addName(flawedRuby, "Flawed Ruby");
        LanguageRegistry.addName(flawedSapphire, "Flawed Sapphire");
        LanguageRegistry.addName(flawedTanzanite, "Flawed Tanzanite");
        LanguageRegistry.addName(flawedTigerseye, "Flawed Tigerseye");
        LanguageRegistry.addName(flawedTopaz, "Flawed Topaz");
        LanguageRegistry.addName(flawedMoonstone, "Flawed Moonstone");	
        }

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}