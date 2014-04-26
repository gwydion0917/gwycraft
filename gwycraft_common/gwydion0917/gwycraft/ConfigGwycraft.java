package gwydion0917.gwycraft;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigGwycraft {
	/* ID's be gone
	
	// Glow blocks start at 1800 (100 less than standard)
	public static int glowyWoolID = 1801;
	public static int glowyblockDyedStoneID = 1802;
	public static int glowyblockDyedBookcaseID = 1807;
	public static int glowyblockDyedBrickID = 1808;
	public static int glowyblockDyedClayblockID = 1809;
	public static int glowyblockDyedGlassID = 1810;
	public static int glowyblockDyedLeafID = 1811;
	public static int glowyblockDyedLog1ID = 1812;
	public static int glowyblockDyedLog2ID = 1813;
	public static int glowyblockDyedLog3ID = 1814;
	public static int glowyblockDyedLog4ID = 1815;
	public static int glowyblockDyedMudBrickID = 1816;
	public static int glowyblockDyedPlankID = 1817;
	public static int glowyblockDyedSandID = 1818;
	public static int glowyblockDyedStoneBrickID = 1819;
	public static int glowyblockDyedStoneCobbleID = 1820;
	public static int glowyblockDyedSandstoneID = 1830;
	public static int glowyblockDyedFencesID = 1861;
	public static int glowyblockDyedStoneCobbleWallsID = 1862;

	// Standard (non-glow) Blocks
	public static int blockDyedStoneID = 1902;
	public static int blockDyedBookcaseID = 1907;
	public static int blockDyedBrickID = 1908;
	public static int blockDyedClayblockID = 1909;
	public static int blockDyedGlassID = 1910;
	public static int blockDyedLeafID = 1911;
	public static int blockDyedLog1ID = 1912;
	public static int blockDyedLog2ID = 1913;
	public static int blockDyedLog3ID = 1914;
	public static int blockDyedLog4ID = 1915;
	public static int blockDyedMudBrickID = 1916;
	public static int blockDyedPlankID = 1917;
	public static int blockDyedSandID = 1918;
	public static int blockDyedStoneBrickID = 1919;
	public static int blockDyedStoneCobbleID = 1920;
	// 1921?
	public static int blockGemOreID = 1922;
	public static int blockGemCompressedID = 1923;
	public static int blockDyedStonePaverID = 1924;
	public static int blockDyedBrickPaverID = 1925;
	public static int blockDyedSandstoneID = 1930;
	// public static int blockDyedSandstoneChiseledID = 1931;
	// public static int blockDyedSandstoneSmoothID = 1932;
	// gap
	public static int blockDyedFencesID = 1961;
	public static int blockDyedStoneCobbleWallsID = 1962;
	public static int blockWhiteDyedTorchID = 1963;
	public static int blockOrangeDyedTorchID = 1964;
	public static int blockMagentaDyedTorchID = 1965;
	public static int blockLBlueDyedTorchID = 1966;
	public static int blockYellowDyedTorchID = 1967;
	public static int blockLGreenDyedTorchID = 1968;
	public static int blockPinkDyedTorchID = 1969;
	public static int blockDGrayDyedTorchID = 1970;
	public static int blockLGrayDyedTorchID = 1971;
	public static int blockCyanDyedTorchID = 1972;
	public static int blockPurpleDyedTorchID = 1973;
	public static int blockBlueDyedTorchID = 1974;
	public static int blockBrownDyedTorchID = 1975;
	public static int blockGreenDyedTorchID = 1976;
	public static int blockRedDyedTorchID = 1977;
	public static int blockBlackDyedTorchID = 1978;
	public static int blockDyedStoneBrickPaverID = 1979;
	public static int blockDyedStoneCobblePaverID = 1980;
	public static int blockDyedMudBrickPaverID = 1981;
	
	// Items
	public static int itemEnchantedGemsID = 5001;
	public static int itemDyedClayID = 5002;
	public static int itemDyedClayBricksID = 5003;
	public static int itemDyedMudID = 5004;
	public static int itemDyedMudBricksID = 5005;
	public static int itemDyedSticksID = 5006;

	// public static int itemIronSawBladeID = 5007;
	// public static int itemDiamondSawBladeID = 5008;
	// public static int itemIronRouterTipID = 5009;
	// public static int itemDiamondRouterTipID = 5010;
	// public static int itemDyedFuel1ID = 5011;
	// public static int itemDyedFuel2ID = 5012;
	// public static int itemDyedFuel3ID = 5013;
	// public static int itemDyedFuel4ID = 5014;
	// public static int itemDyedFuel5ID = 5015;
	// public static int itemDyedFuel6ID = 5016;
	// public static int itemDyedFuel7ID = 5017;
	// public static int itemDyedFuel8ID = 5018;
	// public static int itemDyedFuel9ID = 5019;
	// public static int itemDyedFuel10ID = 5020;
	// public static int itemDyedFuel11ID = 5021;
	// public static int itemDyedFuel12ID = 5022;
	// public static int itemDyedFuel13ID = 5023;
	// public static int itemDyedFuel14ID = 5024;
	// public static int itemDyedFuel15ID = 5025;
	// public static int itemDyedFuel16ID = 5026;
    public static int itemGemShearsID = 5011;
    // public static int itemPick2ID = 5012;
    // public static int itemPick3ID = 5013;
    // public static int itemPick4ID = 5014;
    // public static int itemPick5ID = 5015;
    // public static int itemPick6ID = 5016;
    // public static int itemPick7ID = 5017;
    // public static int itemPick8ID = 5018;
    // public static int itemPick9ID = 5019;
    // public static int itemPick10ID = 5020;
    // public static int itemPick11ID = 5021;
    // public static int itemPick12ID = 5022;
    // public static int itemPick13ID = 5023;
    // public static int itemPick14ID = 5024;
    // public static int itemPick15ID = 5025;
    // public static int itemPick16ID = 5026;
    // public static int itemShovel1ID = 5011;
    // public static int itemShovel2ID = 5012;
    // public static int itemShovel3ID = 5013;
    // public static int itemShovel4ID = 5014;
    // public static int itemShovel5ID = 5015;
    // public static int itemShovel6ID = 5016;
    // public static int itemShovel7ID = 5017;
    // public static int itemShovel8ID = 5018;
    // public static int itemShovel9ID = 5019;
    // public static int itemShovel10ID = 5020;
    // public static int itemShovel11ID = 5021;
    // public static int itemShovel12ID = 5022;
    // public static int itemShovel13ID = 5023;
    // public static int itemShovel14ID = 5024;
    // public static int itemShovel15ID = 5025;
    // public static int itemShovel16ID = 5026;
    // public static int itemAxe1ID = 5011;
    // public static int itemAxe2ID = 5012;
    // public static int itemAxe3ID = 5013;
    // public static int itemAxe4ID = 5014;
    // public static int itemAxe5ID = 5015;
    // public static int itemAxe6ID = 5016;
    // public static int itemAxe7ID = 5017;
    // public static int itemAxe8ID = 5018;
    // public static int itemAxe9ID = 5019;
    // public static int itemAxe10ID = 5020;
    // public static int itemAxe11ID = 5021;
    // public static int itemAxe12ID = 5022;
    // public static int itemAxe13ID = 5023;
    // public static int itemAxe14ID = 5024;
    // public static int itemAxe15ID = 5025;
    // public static int itemAxe16ID = 5026;
    // public static int itemHoe1ID = 5011;
    // public static int itemHoe2ID = 5012;
    // public static int itemHoe3ID = 5013;
    // public static int itemHoe4ID = 5014;
    // public static int itemHoe5ID = 5015;
    // public static int itemHoe6ID = 5016;
    // public static int itemHoe7ID = 5017;
    // public static int itemHoe8ID = 5018;
    // public static int itemHoe9ID = 5019;
    // public static int itemHoe10ID = 5020;
    // public static int itemHoe11ID = 5021;
    // public static int itemHoe12ID = 5022;
    // public static int itemHoe13ID = 5023;
    // public static int itemHoe14ID = 5024;
    // public static int itemHoe15ID = 5025;
    // public static int itemHoe16ID = 5026;
    // public static int itemSword1ID = 5011;
    // public static int itemSword2ID = 5012;
    // public static int itemSword3ID = 5013;
    // public static int itemSword4ID = 5014;
    // public static int itemSword5ID = 5015;
    // public static int itemSword6ID = 5016;
    // public static int itemSword7ID = 5017;
    // public static int itemSword8ID = 5018;
    // public static int itemSword9ID = 5019;
    // public static int itemSword10ID = 5020;
    // public static int itemSword11ID = 5021;
    // public static int itemSword12ID = 5022;
    // public static int itemSword13ID = 5023;
    // public static int itemSword14ID = 5024;
    // public static int itemSword15ID = 5025;
    // public static int itemSword16ID = 5026;
*/
    // General Settings
	public static boolean genGemsEnabled = true;
	public static int genGemsVeins = 9;
	public static int genGemsNumber = 5;

	public static void initConfig(FMLPreInitializationEvent event) {

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();
/* Poof
// Wool
		glowyWoolID = config.getBlock("Glow Wool", glowyWoolID).getInt();
		
		blockDyedStoneID = config.getBlock("blockDyedStone", blockDyedStoneID).getInt();
		glowyblockDyedStoneID = config.getBlock("glowyblockDyedStone", glowyblockDyedStoneID).getInt();
        blockDyedStonePaverID = config.getBlock("blockDyedStonePaver", blockDyedStonePaverID).getInt();
// Bookshelves
        blockDyedBookcaseID = config.getBlock("blockDyedBookcase", blockDyedBookcaseID).getInt();
        glowyblockDyedBookcaseID = config.getBlock("glowyblockDyedBookcase", glowyblockDyedBookcaseID).getInt();
// Brick
        blockDyedBrickID = config.getBlock("blockDyedBrick", blockDyedBrickID).getInt();
		glowyblockDyedBrickID = config.getBlock("glowyblockDyedBrick", glowyblockDyedBrickID).getInt();
        blockDyedBrickPaverID = config.getBlock("blockDyedBrickPaver", blockDyedBrickPaverID).getInt();
// Clay
        blockDyedClayblockID = config.getBlock("blockDyedClayblock", blockDyedClayblockID).getInt();
		glowyblockDyedClayblockID = config.getBlock("glowyblockDyedClayblock", glowyblockDyedClayblockID).getInt();
// Glass
		blockDyedGlassID = config.getBlock("blockDyedGlass", blockDyedGlassID).getInt();
        glowyblockDyedGlassID = config.getBlock("glowyblockDyedGlass", glowyblockDyedGlassID).getInt();
// Leaf
        blockDyedLeafID = config.getBlock("blockDyedLeaf", blockDyedLeafID).getInt();
        glowyblockDyedLeafID = config.getBlock("glowyblockDyedLeaf", glowyblockDyedLeafID).getInt();
// Mud Brick
        blockDyedMudBrickID = config.getBlock("blockDyedMudBrick", blockDyedMudBrickID).getInt();
		glowyblockDyedMudBrickID = config.getBlock("glowyblockDyedMudBrick", glowyblockDyedMudBrickID).getInt();
        blockDyedMudBrickPaverID = config.getBlock("blockDyedMudBrickPaver", blockDyedMudBrickPaverID).getInt();
// Plank
		blockDyedPlankID = config.getBlock("blockDyedPlank", blockDyedPlankID).getInt();
		glowyblockDyedPlankID = config.getBlock("glowyblockDyedPlank", glowyblockDyedPlankID).getInt();
        blockDyedFencesID = config.getBlock("blockDyedFences", blockDyedFencesID).getInt();
        glowyblockDyedFencesID = config.getBlock("glowyblockDyedFences", glowyblockDyedFencesID).getInt();
// Sand
		blockDyedSandID = config.getBlock("blockDyedSand", blockDyedSandID).getInt();
		glowyblockDyedSandID = config.getBlock("glowyblockDyedSand", glowyblockDyedSandID).getInt();
		blockDyedSandstoneID = config.getBlock("blockDyedSandstone", blockDyedSandstoneID).getInt();
		glowyblockDyedSandstoneID = config.getBlock("glowyblockDyedSandstone", glowyblockDyedSandstoneID).getInt();
// Stone Brick
		blockDyedStoneBrickID = config.getBlock("blockDyedStoneBrick", blockDyedStoneBrickID).getInt();
		glowyblockDyedStoneBrickID = config.getBlock("glowyblockDyedStoneBrick", glowyblockDyedStoneBrickID).getInt();
        blockDyedStoneBrickPaverID = config.getBlock("blockDyedStoneBrickPaver", blockDyedStoneBrickPaverID).getInt();
// Stone Cobble
        blockDyedStoneCobbleID = config.getBlock("blockDyedStoneCobble", blockDyedStoneCobbleID).getInt();
		glowyblockDyedStoneCobbleID = config.getBlock("glowyblockDyedStoneCobble", glowyblockDyedStoneCobbleID).getInt();
        blockDyedStoneCobbleWallsID = config.getBlock("blockDyedCobbleWalls", blockDyedStoneCobbleWallsID).getInt();
        glowyblockDyedStoneCobbleWallsID = config.getBlock("glowyblockDyedCobbleWalls", glowyblockDyedStoneCobbleWallsID).getInt();
        blockDyedStoneCobblePaverID = config.getBlock("blockDyedCobblePaver", blockDyedStoneCobblePaverID).getInt();
// Torch
		blockWhiteDyedTorchID = config.getBlock("blockWhiteDyedTorch", blockWhiteDyedTorchID).getInt();
		blockOrangeDyedTorchID = config.getBlock("blockOrangeDyedTorch", blockOrangeDyedTorchID).getInt();
		blockMagentaDyedTorchID = config.getBlock("blockMagentaDyedTorch", blockMagentaDyedTorchID).getInt();
		blockLBlueDyedTorchID = config.getBlock("blockLBlueDyedTorch", blockLBlueDyedTorchID).getInt();
		blockYellowDyedTorchID = config.getBlock("blockYellowDyedTorch", blockYellowDyedTorchID).getInt();
		blockLGreenDyedTorchID = config.getBlock("blockLGreenDyedTorch", blockLGreenDyedTorchID).getInt();
		blockPinkDyedTorchID = config.getBlock("blockPinkDyedTorch", blockPinkDyedTorchID).getInt();
		blockDGrayDyedTorchID = config.getBlock("blockDGrayDyedTorch", blockDGrayDyedTorchID).getInt();
		blockLGrayDyedTorchID = config.getBlock("blockLGrayDyedTorch", blockLGrayDyedTorchID).getInt();
		blockCyanDyedTorchID = config.getBlock("blockCyanDyedTorch", blockCyanDyedTorchID).getInt();
		blockPurpleDyedTorchID = config.getBlock("blockPurpleDyedTorch", blockPurpleDyedTorchID).getInt();
		blockBlueDyedTorchID = config.getBlock("blockBlueDyedTorch", blockBlueDyedTorchID).getInt();
		blockBrownDyedTorchID = config.getBlock("blockBrownDyedTorch", blockBrownDyedTorchID).getInt();
		blockGreenDyedTorchID = config.getBlock("blockGreenDyedTorch", blockGreenDyedTorchID).getInt();
		blockRedDyedTorchID = config.getBlock("blockRedDyedTorch", blockRedDyedTorchID).getInt();
		blockBlackDyedTorchID = config.getBlock("blockBlackDyedTorch", blockBlackDyedTorchID).getInt();
// Logs		
		blockDyedLog1ID = config.getBlock("blockDyedLog1", blockDyedLog1ID).getInt(); 
		blockDyedLog2ID = config.getBlock("blockDyedLog2", blockDyedLog2ID).getInt();
		blockDyedLog3ID = config.getBlock("blockDyedLog3", blockDyedLog3ID).getInt();
		blockDyedLog4ID = config.getBlock("blockDyedLog4", blockDyedLog4ID).getInt();
        glowyblockDyedLog1ID = config.getBlock("glowyblockDyedLog1", glowyblockDyedLog1ID).getInt();
        glowyblockDyedLog2ID = config.getBlock("glowyblockDyedLog2", glowyblockDyedLog2ID).getInt();
        glowyblockDyedLog3ID = config.getBlock("glowyblockDyedLog3", glowyblockDyedLog3ID).getInt();
        glowyblockDyedLog4ID = config.getBlock("glowyblockDyedLog4", glowyblockDyedLog4ID).getInt();
// Gem		
        blockGemOreID = config.getBlock("blockGemOre", blockGemOreID).getInt();
		blockGemCompressedID = config.getBlock("blockGemCompressed", blockGemCompressedID).getInt();

// Item
		itemEnchantedGemsID = config.getItem("Enchanted Gems", itemEnchantedGemsID).getInt();
		itemDyedClayID = config.getItem("Dyed Clay", itemDyedClayID).getInt();
		itemDyedClayBricksID = config.getItem("Dyed Clay Bricks",
				itemDyedClayBricksID).getInt();
		itemDyedMudID = config.getItem("Dyed Mud", itemDyedMudID).getInt();
		itemDyedMudBricksID = config.getItem("Dyed Mud Bricks",
				itemDyedMudBricksID).getInt();
        itemDyedSticksID = config.getItem("Dyed Sticks", itemDyedSticksID).getInt();
        itemGemShearsID = config.getItem("Gem Shears", itemGemShearsID).getInt();*/
		
// General Section
		Property genGemsEnabledProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsEnabled", true);
		genGemsEnabledProperty.comment = "Should gems generate in the world";
		genGemsEnabled = genGemsEnabledProperty.getBoolean(true);
		
		Property genGemsVeinsProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsVeins", 9);
		genGemsVeinsProperty.comment = "Attempt to generate X veins per chunk";
		genGemsVeins = genGemsVeinsProperty.getInt(8);
		
		Property genGemsNumberProperty = config.get(Configuration.CATEGORY_GENERAL, "genGemsNumber", 5);
		genGemsNumberProperty.comment = "Attemp to generate X ores per vein";
		genGemsNumber = genGemsNumberProperty.getInt(4);
		
		if (config.hasChanged()) {
			config.save();
		}
	}
}
