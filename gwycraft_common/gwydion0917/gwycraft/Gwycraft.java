package gwydion0917.gwycraft;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.logging.Level;

import gwydion0917.gwycraft.CommonProxy;
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
import gwydion0917.gwycraft.blocks.dyedItemStoneSlab1;
import gwydion0917.gwycraft.blocks.dyedItemStoneSlab2;
import gwydion0917.gwycraft.blocks.dyedItemStonebrick;
import gwydion0917.gwycraft.blocks.dyedItemStonecobble;
import gwydion0917.gwycraft.blocks.glowyItemWool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.FMLLog;
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

	public static final String[] gwyColorNames = { "White", "Orange",
			"Magenta", "Light Blue", "Yellow", "Light Green", "Pink",
			"Dark Grey", "Light Grey", "Cyan", "Purple", "Blue", "Brown",
			"Green", "Red", "Black" };
    public static final String[] gwyColorLog1Names = { "White", "Orange", "Magenta", "Light Blue" };
    public static final String[] gwyColorLog2Names = { "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorLog3Names = { "Light Grey", "Cyan", "Purple", "Blue"};
    public static final String[] gwyColorLog4Names = { "Brown", "Green", "Red", "Black" };
    public static final String[] gwyColorSlab1Names = { "White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorSlab2Names = { "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

    public static int glowyWoolID;
    public static int dyedStoneID;
    public static int dyedStoneSlab1ID;
    public static int dyedStoneSlab2ID;
    public static int dyedStoneDoubleSlab1ID;
    public static int dyedBookcaseID;
    public static int dyedBrickID;
    public static int dyedClayblockID;
    public static int dyedGlassID;
    public static int dyedLeafID;
    public static int dyedLog1ID;
    public static int dyedLog2ID;
    public static int dyedLog3ID;
    public static int dyedLog4ID;
    public static int dyedMudbrickID;
    public static int dyedPlankID;
    public static int dyedSandID;
    public static int dyedStonebrickID;
	public static int dyedStonecobbleID;
	public static int dyedMudbrickStairsID;

	@Instance("Gwycraft")
	public static Gwycraft instance;

	@SidedProxy(clientSide = "gwydion0917.gwycraft.client.ClientProxy", serverSide = "gwydion0917.gwycraft.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		try {

			config.load();

			glowyWoolID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"glowyWool", 1490).getInt(1490);
			dyedStoneID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedStone", 1491).getInt(1491);
            dyedStoneSlab1ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedStoneSlab1", 1492).getInt(1492);
            dyedStoneSlab2ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedStoneSlab2", 1493).getInt(1493);
			dyedBookcaseID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedBookcase", 1494).getInt(1494);
			dyedBrickID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedBrick", 1495).getInt(1495);
			dyedClayblockID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedClayblock", 1496).getInt(1496);
			dyedGlassID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedGlass", 1497).getInt(1497);
			dyedLeafID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedLeaf", 1498).getInt(1498);
			dyedMudbrickID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedMudbrick", 1499).getInt(1499);
			dyedPlankID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedPlank", 1500).getInt(1500);
			dyedSandID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedSand", 1501).getInt(1501);
			dyedStonebrickID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedStonebrick", 1502).getInt(1502);
			dyedStonecobbleID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedStonecobble", 1503).getInt(1503);
            dyedMudbrickStairsID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedMudbrickStairs", 1504).getInt(1504);
            dyedLog1ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedLog1", 1505).getInt(1505);
            dyedLog2ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedLog2", 1506).getInt(1506);
            dyedLog3ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedLog3", 1507).getInt(1507);
            dyedLog4ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedLog4", 1508).getInt(1508);
            dyedStoneDoubleSlab1ID = config.getBlock(Configuration.CATEGORY_BLOCK,
                    "dyedStoneDoubleSlab1", 1509).getInt(1509);

            
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "GlowyBlocks can't load its config.");
		} finally {
			config.save();
		}

	}

	@Init
	public void init(FMLInitializationEvent event) {
		Block glowyWool = new GlowyWool(glowyWoolID);
		Block dyedStone = new DyedStone(dyedStoneID);
		BlockHalfSlab dyedStoneSlab1 = (DyedStoneSlab1) new DyedStoneSlab1(dyedStoneSlab1ID, false, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneSlab1").setHardness(2.0F).setCreativeTab(CreativeTabs.tabBlock);;
		BlockHalfSlab dyedStoneSlab2 = new DyedStoneSlab2(dyedStoneSlab2ID, false);
		BlockHalfSlab dyedStoneDoubleSlab1 = (DyedStoneSlab1) new DyedStoneSlab1(dyedStoneDoubleSlab1ID, true, Material.rock).setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab1").setHardness(2.0F);
		Block dyedBookcase = new DyedBookcase(dyedBookcaseID);
		Block dyedBrick = new DyedBrick(dyedBrickID);
		Block dyedClayblock = new DyedClayblock(dyedClayblockID);
		Block dyedGlass = new DyedGlass(dyedGlassID);
		Block dyedLeaf = new DyedLeaf(dyedLeafID);
		Block dyedMudbrick = new DyedMudbrick(dyedMudbrickID);
		Block dyedPlank = new DyedPlank(dyedPlankID);
		Block dyedSand = new DyedSand(dyedSandID);
		Block dyedStonebrick = new DyedStonebrick(dyedStonebrickID);
		Block dyedStonecobble = new DyedStoneCobble(dyedStonecobbleID);
//        Block dyedMudbrickStairs = new DyedMudbrickStairs(dyedMudbrickStairsID);
        Block dyedLog1 = new DyedLog1(dyedLog1ID);
        Block dyedLog2 = new DyedLog2(dyedLog2ID);
        Block dyedLog3 = new DyedLog3(dyedLog3ID);
        Block dyedLog4 = new DyedLog4(dyedLog4ID);

        CommonProxy.registerRenderers();

		// glowyWool
		GameRegistry.registerBlock(glowyWool, glowyItemWool.class, "glowyWool");
		for (int i = 0; i < 16; i++) {
			ItemStack cloth = new ItemStack(Block.cloth, 1, i);
			ItemStack glowyWoolStack = new ItemStack(glowyWool, 1, i);
			ItemStack gsDust = new ItemStack(Item.lightStoneDust, 1);
			GameRegistry.addRecipe(glowyWoolStack, " x ", "xyx", " x ", 'y',
					cloth, 'x', gsDust);
			GameRegistry.addShapelessRecipe(glowyWoolStack, new ItemStack(
					Block.glowStone), cloth);
			LanguageRegistry.addName(glowyWoolStack, "Glowy "
					+ gwyColorNames[glowyWoolStack.getItemDamage()] + " Wool");
		}
		// dyedStone
		GameRegistry.registerBlock(dyedStone, dyedItemStone.class, "dyedStone");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedStoneStack = new ItemStack(dyedStone, 1, i);
			LanguageRegistry.addName(dyedStoneStack,
					gwyColorNames[dyedStoneStack.getItemDamage()] + " Stone");
		}
		// dyedStone Slab
		GameRegistry.registerBlock(dyedStoneSlab1, "dyedStoneSlab1");
		Item.itemsList[dyedStoneSlab1ID] = (new ItemSlab (dyedStoneSlab1ID - 256, dyedStoneSlab1, dyedStoneDoubleSlab1, false)).setUnlocalizedName("woodSlab");
	    Item.itemsList[dyedStoneDoubleSlab1ID] = (new ItemSlab(dyedStoneDoubleSlab1ID - 256, dyedStoneSlab1, dyedStoneDoubleSlab1, true)).setUnlocalizedName("woodSlab");

		for (int i = 0; i < 8; i++) {
			ItemStack dyedStoneSlab1Stack = new ItemStack(dyedStoneSlab1, 1, i);
			LanguageRegistry.addName(dyedStoneSlab1Stack,
					gwyColorSlab1Names[dyedStoneSlab1Stack.getItemDamage()]
							+ " Stone Slab");
		}
        GameRegistry.registerBlock(dyedStoneSlab2, dyedItemStoneSlab2.class,
                "dyedStoneSlab2");
        for (int i = 0; i < 8; i++) {
            ItemStack dyedStoneSlab2Stack = new ItemStack(dyedStoneSlab2, 1, i);
            LanguageRegistry.addName(dyedStoneSlab2Stack,
                    gwyColorSlab2Names[dyedStoneSlab2Stack.getItemDamage()]
                            + " Stone Slab");
        }
		// dyedBookcase
		GameRegistry.registerBlock(dyedBookcase, dyedItemBookcase.class,
				"dyedBookcase");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedBookcaseStack = new ItemStack(dyedBookcase, 1, i);
			LanguageRegistry.addName(dyedBookcaseStack,
					gwyColorNames[dyedBookcaseStack.getItemDamage()]
							+ " Bookcase");
		}
		// dyedBrick
		GameRegistry.registerBlock(dyedBrick, dyedItemBrick.class, "dyedBrick");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedBrickStack = new ItemStack(dyedBrick, 1, i);
			LanguageRegistry.addName(dyedBrickStack,
					gwyColorNames[dyedBrickStack.getItemDamage()] + " Brick");
		}
		// dyedClayblock
		GameRegistry.registerBlock(dyedClayblock, dyedItemClayblock.class,
				"dyedClayblock");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedClayblockStack = new ItemStack(dyedClayblock, 1, i);
			LanguageRegistry.addName(dyedClayblockStack,
					gwyColorNames[dyedClayblockStack.getItemDamage()]
							+ " Clay Block");
		}
		// dyedGlass
		GameRegistry.registerBlock(dyedGlass, dyedItemGlass.class, "dyedGlass");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedGlassStack = new ItemStack(dyedGlass, 1, i);
			LanguageRegistry.addName(dyedGlassStack,
					gwyColorNames[dyedGlassStack.getItemDamage()] + " Glass");
		}
		// dyedLeaf
		GameRegistry.registerBlock(dyedLeaf, dyedItemLeaf.class, "dyedLeaf");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedLeafStack = new ItemStack(dyedLeaf, 1, i);
			LanguageRegistry.addName(dyedLeafStack,
					gwyColorNames[dyedLeafStack.getItemDamage()] + " Leaf");
		}
        // dyedLog1
        GameRegistry.registerBlock(dyedLog1, dyedItemLog1.class, "dyedLog1");
        for (int i = 0; i < 4; i++) {
            ItemStack dyedLog1Stack = new ItemStack(dyedLog1, 1, i);
            LanguageRegistry.addName(dyedLog1Stack,
                    gwyColorLog1Names[dyedLog1Stack.getItemDamage()] + " Log");
        }
        // dyedLog2
        GameRegistry.registerBlock(dyedLog2, dyedItemLog2.class, "dyedLog2");
        for (int i = 0; i < 4; i++) {
            ItemStack dyedLog2Stack = new ItemStack(dyedLog2, 1, i);
            LanguageRegistry.addName(dyedLog2Stack,
                    gwyColorLog2Names[dyedLog2Stack.getItemDamage()] + " Log");
        }
        // dyedLog3
        GameRegistry.registerBlock(dyedLog3, dyedItemLog3.class, "dyedLog3");
        for (int i = 0; i < 4; i++) {
            ItemStack dyedLog3Stack = new ItemStack(dyedLog3, 1, i);
            LanguageRegistry.addName(dyedLog3Stack,
                    gwyColorLog3Names[dyedLog3Stack.getItemDamage()] + " Log");
        }
        // dyedLog4
        GameRegistry.registerBlock(dyedLog4, dyedItemLog4.class, "dyedLog4");
        for (int i = 0; i < 4; i++) {
            ItemStack dyedLog4Stack = new ItemStack(dyedLog4, 1, i);
            LanguageRegistry.addName(dyedLog4Stack,
                    gwyColorLog4Names[dyedLog4Stack.getItemDamage()] + " Log");
        }
		// dyedMudbrick
		GameRegistry.registerBlock(dyedMudbrick, dyedItemMudbrick.class,
				"dyedMudbrick");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedMudbrickStack = new ItemStack(dyedMudbrick, 1, i);
			LanguageRegistry.addName(dyedMudbrickStack,
					gwyColorNames[dyedMudbrickStack.getItemDamage()]
							+ " Mud Brick");
		}
		// dyedPlank
		GameRegistry.registerBlock(dyedPlank, dyedItemPlank.class, "dyedPlank");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedPlankStack = new ItemStack(dyedPlank, 1, i);
			LanguageRegistry.addName(dyedPlankStack,
					gwyColorNames[dyedPlankStack.getItemDamage()] + " Plank");
		}
		// dyedSand
		GameRegistry.registerBlock(dyedSand, dyedItemSand.class, "dyedSand");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedSandStack = new ItemStack(dyedSand, 1, i);
			LanguageRegistry.addName(dyedSandStack,
					gwyColorNames[dyedSandStack.getItemDamage()] + " Sand");
		}
		// dyedStonebrick
		GameRegistry.registerBlock(dyedStonebrick, dyedItemStonebrick.class,
				"dyedStonebrick");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedStonebrickStack = new ItemStack(dyedStonebrick, 1, i);
			LanguageRegistry.addName(dyedStonebrickStack,
					gwyColorNames[dyedStonebrickStack.getItemDamage()]
							+ " Stone Brick");
		}
		// dyedStonecobble
		GameRegistry.registerBlock(dyedStonecobble, dyedItemStonecobble.class,
				"dyedStonecobble");
		for (int i = 0; i < 16; i++) {
			ItemStack dyedStonecobbleStack = new ItemStack(dyedStonecobble, 1,
					i);
			LanguageRegistry.addName(dyedStonecobbleStack,
					gwyColorNames[dyedStonecobbleStack.getItemDamage()]
							+ " Cobblestone");
		}
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}