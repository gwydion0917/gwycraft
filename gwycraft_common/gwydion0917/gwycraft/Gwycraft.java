package gwydion0917.gwycraft;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.logging.Level;

import gwydion0917.gwycraft.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

@Mod(modid="GwyCraft", name="GwyCraft", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Gwycraft {

	// public static int glowyWoolID;
	private int glowyWoolID;

	private static final String[] glowyWoolNames = { "Glowy White Wool",
			"Glowy Orange Wool", "Glowy Magenta Wool", "Glowy Light Blue Wool",
			"Glowy Yellow Wool", "Glowy Light Green Wool", "Glowy Pink Wool",
			"Glowy Dark Grey Wool", "Glowy Light Grey Wool", "Glowy Cyan Wool",
			"Glowy Purple Wool", "Glowy Blue Wool", "Glowy Brown Wool",
			"Glowy Green Wool", "Glowy Red Wool", "Glowy Black Wool" };

	private int dyedStoneID;
	
	private static final String[] dyedStoneNames = { "White Stone",
		"Orange Stone", "Magenta Stone", "Light Blue Stone",
		"Yellow Stone", "Light Green Stone", "Pink Stone",
		"Dark Grey Stone", "Light Grey Stone", "Cyan Stone",
		"Purple Stone", "Blue Stone", "Brown Stone",
		"Green Stone", "Red Stone", "Black Stone" };
	
	private int dyedStoneSlabID;
	
	private static final String[] dyedStoneSlabNames = { "White Stone Slab",
		"Orange Stone Slab", "Magenta Stone Slab", "Light Blue Stone Slab",
		"Yellow Stone Slab", "Light Green Stone Slab", "Pink Stone Slab",
		"Dark Grey Stone Slab", "Light Grey Stone Slab", "Cyan Stone Slab",
		"Purple Stone Slab", "Blue Stone Slab", "Brown Stone Slab",
		"Green Stone Slab", "Red Stone Slab", "Black Stone Slab" };
	
	private int dyedBookcaseID;
	
	private static final String[] dyedBookcaseNames = { "White Bookcase",
		"Orange Bookcase", "Magenta Bookcase", "Light Blue Bookcase",
		"Yellow Bookcase", "Light Green Bookcase", "Pink Bookcase",
		"Dark Grey Bookcase", "Light Grey Bookcase", "Cyan Bookcase",
		"Purple Bookcase", "Blue Bookcase", "Brown Bookcase",
		"Green Bookcase", "Red Bookcase", "Black Bookcase" };
	
	private int dyedBrickID;
	
	private static final String[] dyedBrickNames = { "White Brick",
		"Orange Brick", "Magenta Brick", "Light Blue Brick",
		"Yellow Brick", "Light Green Brick", "Pink Brick",
		"Dark Grey Brick", "Light Grey Brick", "Cyan Brick",
		"Purple Brick", "Blue Brick", "Brown Brick",
		"Green Brick", "Red Brick", "Black Brick" };
	
	private int dyedClayblockID;
	
	private static final String[] dyedClayblockNames = { "White Clay Block",
		"Orange Clay Block", "Magenta Clay Block", "Light Blue Clay Block",
		"Yellow Clay Block", "Light Green Clay Block", "Pink Clay Block",
		"Dark Grey Clay Block", "Light Grey Clay Block", "Cyan Clay Block",
		"Purple Clay Block", "Blue Clay Block", "Brown Clay Block",
		"Green Clay Block", "Red Clay Block", "Black Clay Block" };
	
	private int dyedGlassID;
	
	private static final String[] dyedGlassNames = { "White Glass",
		"Orange Glass", "Magenta Glass", "Light Blue Glass",
		"Yellow Glass", "Light Green Glass", "Pink Glass",
		"Dark Grey Glass", "Light Grey Glass", "Cyan Glass",
		"Purple Glass", "Blue Glass", "Brown Glass",
		"Green Glass", "Red Glass", "Black Glass" };
	
	private int dyedLeafID;
	
	private static final String[] dyedLeafNames = { "White Leaf",
		"Orange Leaf", "Magenta Leaf", "Light Blue Leaf",
		"Yellow Leaf", "Light Green Leaf", "Pink Leaf",
		"Dark Grey Leaf", "Light Grey Leaf", "Cyan Leaf",
		"Purple Leaf", "Blue Leaf", "Brown Leaf",
		"Green Leaf", "Red Leaf", "Black Leaf" };
	
	private int dyedLogID;
	
	private static final String[] dyedLogNames = { "White Log",
		"Orange Log", "Magenta Log", "Light Blue Log",
		"Yellow Log", "Light Green Log", "Pink Log",
		"Dark Grey Log", "Light Grey Log", "Cyan Log",
		"Purple Log", "Blue Log", "Brown Log",
		"Green Log", "Red Log", "Black Log" };
	
	private int dyedMudbrickID;
	
	private static final String[] dyedMudbrickNames = { "White Mud Brick",
		"Orange Mud Brick", "Magenta Mud Brick", "Light Blue Mud Brick",
		"Yellow Mud Brick", "Light Green Mud Brick", "Pink Mud Brick",
		"Dark Grey Mud Brick", "Light Grey Mud Brick", "Cyan Mud Brick",
		"Purple Mud Brick", "Blue Mud Brick", "Brown Mud Brick",
		"Green Mud Brick", "Red Mud Brick", "Black Mud Brick" };
	
	private int dyedPlankID;
	
	private static final String[] dyedPlankNames = { "White Plank",
		"Orange Plank", "Magenta Plank", "Light Blue Plank",
		"Yellow Plank", "Light Green Plank", "Pink Plank",
		"Dark Grey Plank", "Light Grey Plank", "Cyan Plank",
		"Purple Plank", "Blue Plank", "Brown Plank",
		"Green Plank", "Red Plank", "Black Plank" };
	
	private int dyedSandID;
	
	private static final String[] dyedSandNames = { "White Sand",
		"Orange Sand", "Magenta Sand", "Light Blue Sand",
		"Yellow Sand", "Light Green Sand", "Pink Sand",
		"Dark Grey Sand", "Light Grey Sand", "Cyan Sand",
		"Purple Sand", "Blue Sand", "Brown Sand",
		"Green Sand", "Red Sand", "Black Sand" };
	
	private int dyedStonebrickID;
	
	private static final String[] dyedStonebrickNames = { "White Stone Brick",
		"Orange Stone Brick", "Magenta Stone Brick", "Light Blue Stone Brick",
		"Yellow Stone Brick", "Light Green Stone Brick", "Pink Stone Brick",
		"Dark Grey Stone Brick", "Light Grey Stone Brick", "Cyan Stone Brick",
		"Purple Stone Brick", "Blue Stone Brick", "Brown Stone Brick",
		"Green Stone Brick", "Red Stone Brick", "Black Stone Brick" };
	
	private int dyedStonecobbleID;
	
	private static final String[] dyedStonecobbleNames = { "White Cobblestone",
		"Orange Cobblestone", "Magenta Cobblestone", "Light Blue Cobblestone",
		"Yellow Cobblestone", "Light Green Cobblestone", "Pink Cobblestone",
		"Dark Grey Cobblestone", "Light Grey Cobblestone", "Cyan Cobblestone",
		"Purple Cobblestone", "Blue Cobblestone", "Brown Cobblestone",
		"Green Cobblestone", "Red Cobblestone", "Black Cobblestone" };
	
    @Instance("Gwycraft")
    public static Gwycraft instance;
   
    @SidedProxy(clientSide="gwydion0917.gwycraft.client.ClientProxy",
                    serverSide="gwydion0917.gwycraft.CommonProxy")
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
			dyedStoneSlabID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedStoneSlab", 1492).getInt(1492);
			dyedBookcaseID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedBookcase", 1493).getInt(1493);
			dyedBrickID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedBrick", 1494).getInt(1494);
			dyedClayblockID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedClayblock", 1495).getInt(1495);
			dyedGlassID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedGlass", 1496).getInt(1496);
			dyedLeafID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedLeaf", 1497).getInt(1497);
			dyedLogID = config.getBlock(Configuration.CATEGORY_BLOCK,
					"dyedLog", 1498).getInt(1498);
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
		Block dyedStoneSlab = new DyedStoneSlab(dyedStoneSlabID);
		Block dyedBookcase = new DyedBookcase(dyedBookcaseID);
		Block dyedBrick = new DyedBrick(dyedBrickID);
		Block dyedClayblock = new DyedClayblock(dyedClayblockID);
		Block dyedGlass = new DyedGlass(dyedGlassID);
		Block dyedLeaf = new DyedLeaf(dyedLeafID);
		Block dyedLog = new DyedLog(dyedLogID);
		Block dyedMudbrick = new DyedMudbrick(dyedMudbrickID);
		Block dyedPlank = new DyedPlank(dyedPlankID);
		Block dyedSand = new DyedSand(dyedSandID);
		Block dyedStonebrick = new DyedStonebrick(dyedStonebrickID);
		Block dyedStonecobble = new DyedStoneCobble(dyedStonecobbleID);

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
			LanguageRegistry.addName(glowyWoolStack,
					glowyWoolNames[glowyWoolStack.getItemDamage()]);
		}
			// dyedStone
			GameRegistry.registerBlock(dyedStone, dyedItemStone.class, "dyedStone");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedStoneStack = new ItemStack(dyedStone, 1, i);
				LanguageRegistry.addName(dyedStoneStack,
						dyedStoneNames[dyedStoneStack.getItemDamage()]);
		}
			// dyedStone Slab
			GameRegistry.registerBlock(dyedStoneSlab, dyedItemStoneSlab.class, "dyedStoneSlab");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedStoneSlabStack = new ItemStack(dyedStoneSlab, 1, i);
				LanguageRegistry.addName(dyedStoneSlabStack,
						dyedStoneSlabNames[dyedStoneSlabStack.getItemDamage()]);
		}
			// dyedBookcase
			GameRegistry.registerBlock(dyedBookcase, dyedItemBookcase.class, "dyedBookcase");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedBookcaseStack = new ItemStack(dyedBookcase, 1, i);
				LanguageRegistry.addName(dyedBookcaseStack,
						dyedBookcaseNames[dyedBookcaseStack.getItemDamage()]);
		}
			// dyedBrick
			GameRegistry.registerBlock(dyedBrick, dyedItemBrick.class, "dyedBrick");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedBrickStack = new ItemStack(dyedBrick, 1, i);
				LanguageRegistry.addName(dyedBrickStack,
						dyedBrickNames[dyedBrickStack.getItemDamage()]);
		}
			// dyedClayblock
			GameRegistry.registerBlock(dyedClayblock, dyedItemClayblock.class, "dyedClayblock");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedClayblockStack = new ItemStack(dyedClayblock, 1, i);
				LanguageRegistry.addName(dyedClayblockStack,
						dyedClayblockNames[dyedClayblockStack.getItemDamage()]);
		}
			// dyedGlass
			GameRegistry.registerBlock(dyedGlass, dyedItemGlass.class, "dyedGlass");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedGlassStack = new ItemStack(dyedGlass, 1, i);
				LanguageRegistry.addName(dyedGlassStack,
						dyedGlassNames[dyedGlassStack.getItemDamage()]);
		}
			// dyedLeaf
			GameRegistry.registerBlock(dyedLeaf, dyedItemLeaf.class, "dyedLeaf");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedLeafStack = new ItemStack(dyedLeaf, 1, i);
				LanguageRegistry.addName(dyedLeafStack,
						dyedLeafNames[dyedLeafStack.getItemDamage()]);
		}
			// dyedLog
			GameRegistry.registerBlock(dyedLog, dyedItemLog.class, "dyedLog");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedLogStack = new ItemStack(dyedLog, 1, i);
				LanguageRegistry.addName(dyedLogStack,
						dyedLogNames[dyedLogStack.getItemDamage()]);
		}
			// dyedMudbrick
			GameRegistry.registerBlock(dyedMudbrick, dyedItemMudbrick.class, "dyedMudbrick");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedMudbrickStack = new ItemStack(dyedMudbrick, 1, i);
				LanguageRegistry.addName(dyedMudbrickStack,
						dyedMudbrickNames[dyedMudbrickStack.getItemDamage()]);
		}
			// dyedPlank
			GameRegistry.registerBlock(dyedPlank, dyedItemPlank.class, "dyedPlank");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedPlankStack = new ItemStack(dyedPlank, 1, i);
				LanguageRegistry.addName(dyedPlankStack,
						dyedPlankNames[dyedPlankStack.getItemDamage()]);
		}
			// dyedSand
			GameRegistry.registerBlock(dyedSand, dyedItemSand.class, "dyedSand");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedSandStack = new ItemStack(dyedSand, 1, i);
				LanguageRegistry.addName(dyedSandStack,
						dyedSandNames[dyedSandStack.getItemDamage()]);
		}
			// dyedStonebrick
			GameRegistry.registerBlock(dyedStonebrick, dyedItemStonebrick.class, "dyedStonebrick");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedStonebrickStack = new ItemStack(dyedStonebrick, 1, i);
				LanguageRegistry.addName(dyedStonebrickStack,
						dyedStonebrickNames[dyedStonebrickStack.getItemDamage()]);
		}
			// dyedStonecobble
			GameRegistry.registerBlock(dyedStonecobble, dyedItemStonecobble.class, "dyedStonecobble");
			for (int i = 0; i < 16; i++) {
				ItemStack dyedStonecobbleStack = new ItemStack(dyedStonecobble, 1, i);
				LanguageRegistry.addName(dyedStonecobbleStack,
						dyedStonecobbleNames[dyedStonecobbleStack.getItemDamage()]);
		}
	}
  
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
}