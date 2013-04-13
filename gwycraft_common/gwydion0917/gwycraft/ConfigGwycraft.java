package gwydion0917.gwycraft;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigGwycraft {
	public static int glowyWoolID = 1901;
	public static int dyedStoneID = 1902;
	public static int dyedStoneSlab1ID = 1903;
	public static int dyedStoneDoubleSlab1ID = 1904;
	public static int dyedStoneSlab2ID = 1905;
	public static int dyedStoneDoubleSlab2ID = 1906;
	public static int dyedBookcaseID = 1907;
	public static int dyedBrickID = 1908;
	public static int dyedClayblockID = 1909;
	public static int dyedGlassID = 1910;
	public static int dyedLeafID = 1911;
	public static int dyedLog1ID = 1912;
	public static int dyedLog2ID = 1913;
	public static int dyedLog3ID = 1914;
	public static int dyedLog4ID = 1915;
	public static int dyedMudbrickID = 1916;
	public static int dyedPlankID = 1917;
	public static int dyedSandID = 1918;
	public static int dyedStonebrickID = 1919;
	public static int dyedStonecobbleID = 1920;
	public static int dyedMudbrickStairsID = 1921;
	public static int blockGemOreID = 1922;
	public static int blockGemCompressedID = 1923;
	public static int blockDyedStonePaver1ID = 1924;
	public static int blockDyedStonePaver2ID = 1925;
	public static int blockDyedStoneBrickSlab1ID = 1926;
	public static int blockDyedStoneBrickDoubleSlab1ID = 1927;
	// public static int blockDyedStoneBrickSlab2ID = 1928;
	// public static int blockDyedStoneBrickDoubleSlab2D = 1929;
	// public static int blockDyedSandstoneID = 1930;
	// public static int blockDyedSandstoneChiseledID = 1931;
	// public static int blockDyedSandstoneSmoothID = 1932;
	// public static int blockDyedCobbleSlab1ID = 1933;
	// public static int blockDyedCobbleDoubleSlab1ID = 1934;
	// public static int blockDyedCobbleSlab2ID = 1935;
	// public static int blockDyedCobbleDoubleSlab2D = 1936;
	// public static int blockDyedStoneBrickSlab1ID = 1937;
	// public static int blockDyedStoneBrickDoubleSlab1ID = 1938;
	// public static int blockDyedStoneBrickSlab2ID = 1939;
	// public static int blockDyedStoneBrickDoubleSlab2D = 1940;
	// public static int blockDyedLogSlab1ID = 1941;
	// public static int blockDyedLogDoubleSlab1ID = 1942;
	// public static int blockDyedLogSlab2ID = 1943;
	// public static int blockDyedLogDoubleSlab2D = 1944;
	// public static int blockDyedMudBrickSlab1ID = 1945;
	// public static int blockDyedMudBrickDoubleSlab1ID = 1946;
	// public static int blockDyedMudBrickSlab2ID = 1947;
	// public static int blockDyedMudBrickDoubleSlab2D = 1948;
	// public static int blockDyedPlankSlab1ID = 1949;
	// public static int blockDyedPlankDoubleSlab1ID = 1950;
	// public static int blockDyedPlankSlab2ID = 1951;
	// public static int blockDyedPlankDoubleSlab2D = 1952;
	// public static int blockGemCompressedSlab1ID = 1953;
	// public static int blockGemCompressedDoubleSlab1ID = 1954;
	// public static int blockGemCompressedSlab2ID = 1955;
	// public static int blockGemCompressedDoubleSlab2D = 1956;
	// public static int blockGlowyWoolSlab1ID = 1957;
	// public static int blockGlowyWoolDoubleSlab1ID = 1958;
	// public static int blockGlowyWoolSlab2ID = 1959;
	// public static int blockGlowyWoolDoubleSlab2D = 1960;
	// public static int blockDyedFencesID = 1961;
	// public static int blockDyedCobbleWallsID = 1962;

	public static int itemFlawedGemsID = 5001;
	public static int itemDyedClayID = 5002;
	public static int itemDyedClayBricksID = 5003;
	public static int itemDyedMudID = 5004;
	public static int itemDyedMudBricksID = 5005;

	// public static int itemDyedSticksID = 5006;
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

	public static void initConfig(FMLPreInitializationEvent event) {

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();

		glowyWoolID = config.getBlock("Glow Wool", glowyWoolID).getInt();
		dyedStoneID = config.getBlock("dyedStone", dyedStoneID).getInt();
		dyedStoneSlab1ID = config.getBlock("dyedStoneSlab1", dyedStoneSlab1ID)
				.getInt();
		dyedStoneSlab2ID = config.getBlock("dyedStoneSlab2", dyedStoneSlab2ID)
				.getInt();
		dyedBookcaseID = config.getBlock("dyedBookcase", dyedBookcaseID)
				.getInt();
		dyedBrickID = config.getBlock("dyedBrick", dyedBrickID).getInt();
		dyedClayblockID = config.getBlock("dyedClayblock", dyedClayblockID)
				.getInt();
		dyedGlassID = config.getBlock("dyedGlass", dyedGlassID).getInt();
		dyedLeafID = config.getBlock("dyedLeaf", dyedLeafID).getInt();
		dyedMudbrickID = config.getBlock("dyedMudbrick", dyedMudbrickID)
				.getInt();
		dyedPlankID = config.getBlock("dyedPlank", dyedPlankID).getInt();
		dyedSandID = config.getBlock("dyedSand", dyedSandID).getInt();
		dyedStonebrickID = config.getBlock("dyedStonebrick", dyedStonebrickID)
				.getInt();
		dyedStonecobbleID = config.getBlock("dyedStonecobble",
				dyedStonecobbleID).getInt();
		dyedMudbrickStairsID = config.getBlock("dyedMudbrickStairs",
				dyedMudbrickStairsID).getInt();
		dyedLog1ID = config.getBlock("dyedLog1", dyedLog1ID).getInt();
		dyedLog2ID = config.getBlock("dyedLog2", dyedLog2ID).getInt();
		dyedLog3ID = config.getBlock("dyedLog3", dyedLog3ID).getInt();
		dyedLog4ID = config.getBlock("dyedLog4", dyedLog4ID).getInt();
		dyedStoneDoubleSlab1ID = config.getBlock("dyedStoneDoubleSlab1",
				dyedStoneDoubleSlab1ID).getInt();
		dyedStoneDoubleSlab2ID = config.getBlock("dyedStoneDoubleSlab2",
				dyedStoneDoubleSlab2ID).getInt();
		blockGemOreID = config.getBlock("blockGemOre", blockGemOreID).getInt();
		blockGemCompressedID = config.getBlock("blockGemCompressed",
				blockGemCompressedID).getInt();
		blockDyedStonePaver1ID = config.getBlock("blockDyedStonePaver1",
				blockDyedStonePaver1ID).getInt();
		blockDyedStonePaver2ID = config.getBlock("blockDyedStonePaver2",
				blockDyedStonePaver2ID).getInt();
		blockDyedStoneBrickSlab1ID = config.getBlock(
				"blockDyedStoneBrickSlab1", blockDyedStoneBrickSlab1ID)
				.getInt();

		blockDyedStoneBrickDoubleSlab1ID = config.getBlock(
				"blockDyedStoneBrickDoubleSlab1",
				blockDyedStoneBrickDoubleSlab1ID).getInt();

		itemFlawedGemsID = config.getItem("Flawed Gems", itemFlawedGemsID)
				.getInt();
		itemDyedClayID = config.getItem("Dyed Clay", itemDyedClayID).getInt();
		itemDyedClayBricksID = config.getItem("Dyed Clay Bricks",
				itemDyedClayBricksID).getInt();
		itemDyedMudID = config.getItem("Dyed Mud", itemDyedMudID).getInt();
		itemDyedMudBricksID = config.getItem("Dyed Mud Bricks",
				itemDyedMudBricksID).getInt();

		config.save();
	}
}
