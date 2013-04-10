package gwydion0917.gwycraft;

import java.io.File;
import java.io.IOException;

import gwydion0917.gwycraft.Gwycraft;

import net.minecraftforge.common.Configuration;

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
    
    public static int itemFlawedGemsID = 5001;
    public static int itemDyedClayID = 5002;
    public static int itemDyedClayBricksID = 5003;
    public static int itemDyedMudID = 5004;
    public static int itemDyedMudBricksID = 5005;

public static void initConfig()
    {

        //File fileDir = new File(GwyCraft.proxy.getMinecraftDir() + "/config/gwyCraft");
        //fileDir.mkdir();
        File cfgFile = new File(Gwycraft.proxy.getMinecraftDir() + "/config/gwycraft.cfg");
        
        try
        {
            cfgFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        Configuration config = new Configuration(cfgFile);
        config.load();

        glowyWoolID = config.getBlock("Glow Wool", glowyWoolID).getInt();
        dyedStoneID = config.getBlock("dyedStone", dyedStoneID ).getInt();
        dyedStoneSlab1ID = config.getBlock("dyedStoneSlab1", dyedStoneSlab1ID).getInt();
        dyedStoneSlab2ID = config.getBlock("dyedStoneSlab2", dyedStoneSlab2ID ).getInt();
        dyedBookcaseID = config.getBlock("dyedBookcase", dyedBookcaseID).getInt();
        dyedBrickID = config.getBlock("dyedBrick", dyedBrickID).getInt();
        dyedClayblockID = config.getBlock("dyedClayblock", dyedClayblockID).getInt();
        dyedGlassID = config.getBlock("dyedGlass", dyedGlassID).getInt();
        dyedLeafID = config.getBlock("dyedLeaf", dyedLeafID).getInt();
        dyedMudbrickID = config.getBlock("dyedMudbrick", dyedMudbrickID).getInt();
        dyedPlankID = config.getBlock("dyedPlank", dyedPlankID).getInt();
        dyedSandID = config.getBlock("dyedSand", dyedSandID).getInt();
        dyedStonebrickID = config.getBlock("dyedStonebrick", dyedStonebrickID).getInt();
        dyedStonecobbleID = config.getBlock("dyedStonecobble", dyedStonecobbleID).getInt();
        dyedMudbrickStairsID = config.getBlock("dyedMudbrickStairs", dyedMudbrickStairsID).getInt();
        dyedLog1ID = config.getBlock("dyedLog1", dyedLog1ID).getInt();
        dyedLog2ID = config.getBlock("dyedLog2", dyedLog2ID).getInt();
        dyedLog3ID = config.getBlock("dyedLog3", dyedLog3ID).getInt();
        dyedLog4ID = config.getBlock("dyedLog4", dyedLog4ID).getInt();
        dyedStoneDoubleSlab1ID = config.getBlock("dyedStoneDoubleSlab1", dyedStoneDoubleSlab1ID).getInt();
        dyedStoneDoubleSlab2ID = config.getBlock("dyedStoneDoubleSlab2", dyedStoneDoubleSlab2ID).getInt();
        blockGemOreID = config.getBlock("blockGemOre", blockGemOreID).getInt();
        blockGemCompressedID = config.getBlock("blockGemCompressed", blockGemCompressedID).getInt();
        blockDyedStonePaver1ID = config.getBlock("blockDyedStonePaver1", blockDyedStonePaver1ID).getInt();
        blockDyedStonePaver2ID = config.getBlock("blockDyedStonePaver2", blockDyedStonePaver2ID).getInt();


        itemFlawedGemsID = config.getItem("Flawed Gems", itemFlawedGemsID).getInt();
        itemDyedClayID = config.getItem("Dyed Clay", itemDyedClayID).getInt();
        itemDyedClayBricksID = config.getItem("Dyed Clay Bricks", itemDyedClayBricksID).getInt();
        itemDyedMudID = config.getItem("Dyed Mud", itemDyedMudID).getInt();
        itemDyedMudBricksID = config.getItem("Dyed Mud Bricks", itemDyedMudBricksID).getInt();
        
        config.save();
    }
}

