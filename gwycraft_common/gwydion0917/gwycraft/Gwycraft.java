package gwydion0917.gwycraft;

import gwydion0917.gwycraft.blocks.BlockDyedBookcase;
import gwydion0917.gwycraft.blocks.BlockDyedCobbleWalls;
import gwydion0917.gwycraft.blocks.BlockDyedFences;
import gwydion0917.gwycraft.blocks.BlockDyedGlass;
import gwydion0917.gwycraft.blocks.BlockDyedLeaf;
import gwydion0917.gwycraft.blocks.BlockDyedLog1;
import gwydion0917.gwycraft.blocks.BlockDyedLog2;
import gwydion0917.gwycraft.blocks.BlockDyedLog3;
import gwydion0917.gwycraft.blocks.BlockDyedLog4;
import gwydion0917.gwycraft.blocks.BlockDyedSand;
import gwydion0917.gwycraft.blocks.BlockDyedTorch;
import gwydion0917.gwycraft.blocks.BlockGemCompressed;
import gwydion0917.gwycraft.blocks.BlockGemOre;
import gwydion0917.gwycraft.blocks.BlockGlowyDyedGlass;
import gwydion0917.gwycraft.blocks.BlockGlowyWool;
import gwydion0917.gwycraft.blocks.BlockGwyGenericBlock;
import gwydion0917.gwycraft.blocks.BlockGwyGenericPaver;
import gwydion0917.gwycraft.blocks.BlockGwyGenericSlab1;
import gwydion0917.gwycraft.blocks.BlockGwyGenericSlab2;
import gwydion0917.gwycraft.blocks.ItemDyedBookshelf;
import gwydion0917.gwycraft.blocks.ItemDyedCobbleWalls;
import gwydion0917.gwycraft.blocks.ItemDyedFences;
import gwydion0917.gwycraft.blocks.ItemDyedGlass;
import gwydion0917.gwycraft.blocks.ItemDyedLeaf;
import gwydion0917.gwycraft.blocks.ItemDyedLog1;
import gwydion0917.gwycraft.blocks.ItemDyedLog2;
import gwydion0917.gwycraft.blocks.ItemDyedLog3;
import gwydion0917.gwycraft.blocks.ItemDyedLog4;
import gwydion0917.gwycraft.blocks.ItemDyedPlank;
import gwydion0917.gwycraft.blocks.ItemGemCompressed;
import gwydion0917.gwycraft.blocks.ItemGemOre;
import gwydion0917.gwycraft.blocks.ItemGlowyDyedGlass;
import gwydion0917.gwycraft.blocks.ItemGlowyWool;
import gwydion0917.gwycraft.blocks.ItemGwyGeneric;
import gwydion0917.gwycraft.items.ItemDyedClay;
import gwydion0917.gwycraft.items.ItemDyedClayBricks;
import gwydion0917.gwycraft.items.ItemDyedMud;
import gwydion0917.gwycraft.items.ItemDyedMudBricks;
import gwydion0917.gwycraft.items.ItemDyedSticks;
import gwydion0917.gwycraft.items.ItemEnchantedGems;
import gwydion0917.gwycraft.items.ItemGemShears;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "GwyCraft", name = "GwyCraft", version = "0.1.3", dependencies = "required-after:Forge@[7.7.1.650,)" )
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Gwycraft {

	public static final String[] gwyColorNames = { "White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey", "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };
    public static final String[] gwyColorLog1Names = { "White", "Orange", "Magenta", "Light Blue" };
    public static final String[] gwyColorLog2Names = { "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorLog3Names = { "Light Grey", "Cyan", "Purple", "Blue"};
    public static final String[] gwyColorLog4Names = { "Brown", "Green", "Red", "Black" };
    public static final String[] gwyColorSlab1Names = { "White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] gwyColorSlab2Names = { "Light Grey", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] gwyGemNames = { "Enchanted Quartz", "Enchanted Citrine", "Enchanted Tanzanite", "Enchanted Sapphire", "Enchanted Topaz", "Enchanted Agate", "Enchanted Garnet",  "Enchanted Moonstone", "Enchanted Hematite", "Enchanted Aquamarine", "Enchanted Amethyst",  "Enchanted Lapis Lazuli",  "Enchanted Tigerseye",  "Enchanted Emerald", "Enchanted Ruby", "Enchanted Onyx"};

    public static GwycraftWorldGenerator worldGen = new GwycraftWorldGenerator();
    
    public static GwycraftTab tabs = new GwycraftTab("GwyCraft");
    
    public static Block glowyWool;
    public static Block blockDyedStone;
    public static Block glowyblockDyedStone;
    public static BlockHalfSlab blockDyedStoneSlab1;
    public static BlockHalfSlab blockDyedStoneDoubleSlab1;
    public static BlockHalfSlab blockDyedStoneSlab2;
    public static BlockHalfSlab blockDyedStoneDoubleSlab2;
    public static BlockBookshelf blockDyedBookcase;
    public static BlockBookshelf glowyblockDyedBookcase;
    public static Block blockDyedBrick;
    public static Block glowyblockDyedBrick;
    public static Block blockDyedClayblock;
    public static Block glowyblockDyedClayblock;
    public static Block blockDyedGlass;
    public static Block glowyblockDyedGlass;
    public static Block blockDyedLeaf;
    public static Block glowyblockDyedLeaf;
    public static Block blockDyedLog1;
    public static Block blockDyedLog2;
    public static Block blockDyedLog3;
    public static Block blockDyedLog4;
    public static Block glowyblockDyedLog1;
    public static Block glowyblockDyedLog2;
    public static Block glowyblockDyedLog3;
    public static Block glowyblockDyedLog4;
    public static Block blockDyedMudBrick;
    public static Block glowyblockDyedMudBrick;
    public static BlockHalfSlab blockDyedMudBrickSlab1;
    public static BlockHalfSlab blockDyedMudBrickDoubleSlab1;
    public static BlockHalfSlab blockDyedMudBrickSlab2;
    public static BlockHalfSlab blockDyedMudBrickDoubleSlab2;
    public static Block blockDyedMudBrickPaver;
    public static Block blockDyedPlank;
    public static Block glowyblockDyedPlank;
    public static Block blockDyedSand;
    public static Block glowyblockDyedSand;
    public static Block blockDyedStoneBrick;
    public static Block glowyblockDyedStoneBrick;    
    public static Block blockDyedStoneCobble;
    public static Block glowyblockDyedStoneCobble;
    public static Block blockDyedStoneCobblePaver;
    public static BlockHalfSlab blockDyedStoneCobbleSlab1;
    public static BlockHalfSlab blockDyedStoneCobbleDoubleSlab1;
    public static BlockHalfSlab blockDyedStoneCobbleSlab2;
    public static BlockHalfSlab blockDyedStoneCobbleDoubleSlab2;
    public static Block blockGemOre;
    public static Block blockGemCompressed;
    public static Block blockDyedStonePaver;
    public static BlockHalfSlab blockDyedBrickSlab1;
    public static BlockHalfSlab blockDyedBrickDoubleSlab1;
    public static BlockHalfSlab blockDyedBrickSlab2;
    public static BlockHalfSlab blockDyedBrickDoubleSlab2;
    public static Block blockDyedBrickPaver;
    public static BlockHalfSlab blockDyedStoneBrickSlab1;
    public static BlockHalfSlab blockDyedStoneBrickDoubleSlab1;
    public static BlockHalfSlab blockDyedStoneBrickSlab2;
    public static BlockHalfSlab blockDyedStoneBrickDoubleSlab2;
    public static Block blockDyedStoneBrickPaver;
    public static Block blockDyedFences;
    public static Block glowyblockDyedFences;
    public static Block blockDyedCobbleWalls;
    public static Block glowyblockDyedCobbleWalls;
    public static Block blockWhiteDyedTorch;
    public static Block blockOrangeDyedTorch;
    public static Block blockMagentaDyedTorch;
    public static Block blockLBlueDyedTorch;
    public static Block blockYellowDyedTorch;
    public static Block blockLGreenDyedTorch;
    public static Block blockPinkDyedTorch;
    public static Block blockDGrayDyedTorch;
    public static Block blockLGrayDyedTorch;
    public static Block blockCyanDyedTorch;
    public static Block blockPurpleDyedTorch;
    public static Block blockBlueDyedTorch;
    public static Block blockBrownDyedTorch;
    public static Block blockGreenDyedTorch;
    public static Block blockRedDyedTorch;
    public static Block blockBlackDyedTorch;
    
    public static Item itemEnchantedGems;
    public static Item itemDyedClay;
    public static Item itemDyedClayBricks;
    public static Item itemDyedMud;
    public static Item itemDyedMudBricks;
    public static Item itemDyedSticks;
    public static Item itemGemShears;
    
	@Instance("Gwycraft")
	public static Gwycraft instance;

	@SidedProxy(clientSide = "gwydion0917.gwycraft.client.ClientProxy", serverSide = "gwydion0917.gwycraft.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
        ConfigGwycraft.initConfig(event);
// Wool        
		glowyWool = new BlockGlowyWool(ConfigGwycraft.glowyWoolID, Material.cloth).setHardness(0.8F).setStepSound(Block.cloth.stepSound).setUnlocalizedName("Gwycraft:glowyWool").setLightValue(1f).setCreativeTab(tabs);
// Stone
		blockDyedStone = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedStoneID, Material.rock, "stone").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:blockDyedStone").setCreativeTab(tabs);
        glowyblockDyedStone = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedStoneID, Material.rock, "stone").setLightValue(1F).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedStone").setCreativeTab(tabs);
        blockDyedStoneSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneSlab1ID, false, Material.rock, "stone").setUnlocalizedName("Gwycraft:DyedStoneSlab1").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneDoubleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneDoubleSlab1ID, true, Material.rock, "stone").setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab1").setHardness(2.0F);
        blockDyedStoneSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneSlab2ID, false, Material.rock, "stone").setUnlocalizedName("Gwycraft:DyedStoneSlab2").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneDoubleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneDoubleSlab2ID, true, Material.rock, "stone").setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab2").setHardness(2.0F);
        blockDyedStonePaver = new BlockGwyGenericPaver(ConfigGwycraft.blockDyedStonePaverID, "stone").setUnlocalizedName("Gwycraft:BlockDyedStonePaver1").setHardness(2.0F).setCreativeTab(tabs);
// Bookshelves
        blockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(ConfigGwycraft.blockDyedBookcaseID, Material.wood).setHardness(1.5F).setStepSound(Block.wood.stepSound).setUnlocalizedName("Gwycraft:blockDyedBookcase").setCreativeTab(tabs);
        glowyblockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(ConfigGwycraft.glowyblockDyedBookcaseID, Material.wood).setLightValue(1F).setHardness(1.5F).setStepSound(Block.wood.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedBookcase").setCreativeTab(tabs);
// Brick
        blockDyedBrick = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedBrickID, Material.rock, "brick").setHardness(2F).setStepSound(Block.stone.stepSound).setResistance(10F).setUnlocalizedName("Gwycraft:blockDyedBrick").setCreativeTab(tabs);
		glowyblockDyedBrick = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedBrickID, Material.rock, "brick").setLightValue(1F).setHardness(2F).setStepSound(Block.stone.stepSound).setResistance(10F).setUnlocalizedName("Gwycraft:glowyblockDyedBrick").setCreativeTab(tabs);
        blockDyedBrickSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedBrickSlab1ID, false, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedBrickSlab1").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedBrickDoubleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedBrickDoubleSlab1ID, true, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedBrickDoubleSlab1").setHardness(2.0F);
        blockDyedBrickSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedBrickSlab2ID, false, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedBrickSlab2").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedBrickDoubleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedBrickDoubleSlab2ID, true, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedBrickDoubleSlab2").setHardness(2.0F);
        blockDyedBrickPaver = new BlockGwyGenericPaver(ConfigGwycraft.blockDyedBrickPaverID, "brick").setUnlocalizedName("Gwycraft:BlockDyedBrickPaver1").setHardness(2.0F).setCreativeTab(tabs);
// Clay
		blockDyedClayblock = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedClayblockID, Material.rock, "clayblock").setHardness(0.6F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:blockDyedClayblock").setCreativeTab(tabs);
		glowyblockDyedClayblock = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedClayblockID, Material.rock, "clayblock").setLightValue(1F).setHardness(0.6F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedClayblock").setCreativeTab(tabs);
// Glass
		blockDyedGlass = new BlockDyedGlass(ConfigGwycraft.blockDyedGlassID).setHardness(0.6F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:blockDyedGlass").setCreativeTab(tabs);
        glowyblockDyedGlass = new BlockGlowyDyedGlass(ConfigGwycraft.glowyblockDyedGlassID).setLightValue(1F).setHardness(0.6F).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedGlass").setCreativeTab(tabs);
// Leaf
        blockDyedLeaf = new BlockDyedLeaf(ConfigGwycraft.blockDyedLeafID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:blockDyedLeaf");
        glowyblockDyedLeaf = new BlockDyedLeaf(ConfigGwycraft.glowyblockDyedLeafID).setCreativeTab(tabs).setLightValue(1F).setUnlocalizedName("Gwycraft:glowyblockDyedLeaf");
// Mud Brick
        blockDyedMudBrick = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedMudBrickID, Material.rock, "mudbrick").setHardness(1.5f).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:blockDyedMudBrick").setCreativeTab(tabs);
		glowyblockDyedMudBrick = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedMudBrickID, Material.rock, "mudbrick").setLightValue(1F).setHardness(1.5f).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedMudBrick").setCreativeTab(tabs);
        blockDyedMudBrickSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedMudBrickSlab1ID, false, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedMudBrickSlab1").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedMudBrickDoubleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedMudBrickDoubleSlab1ID, true, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedMudBrickDoubleSlab1").setHardness(2.0F);
        blockDyedMudBrickSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedMudBrickSlab2ID, false, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedMudBrickSlab2").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedMudBrickDoubleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedMudBrickDoubleSlab2ID, true, Material.rock, "brick").setUnlocalizedName("Gwycraft:DyedBrickMudDoubleSlab2").setHardness(2.0F);
        blockDyedMudBrickPaver = new BlockGwyGenericPaver(ConfigGwycraft.blockDyedMudBrickPaverID, "brick").setUnlocalizedName("Gwycraft:BlockDyedMudBrickPaver").setHardness(2.0F).setCreativeTab(tabs);
// Planks
		blockDyedPlank = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedPlankID, Material.wood, "plank").setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Gwycraft:blockDyedPlank").setCreativeTab(tabs);
		glowyblockDyedPlank = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedPlankID, Material.wood, "plank").setLightValue(1F).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Gwycraft:glowyblockDyedPlank").setCreativeTab(tabs);
        blockDyedFences = new BlockDyedFences(ConfigGwycraft.blockDyedFencesID, null , Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Gwycraft:blockDyedFence").setCreativeTab(tabs);
        glowyblockDyedFences = new BlockDyedFences(ConfigGwycraft.glowyblockDyedFencesID, null , Material.wood).setLightValue(1F).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Gwycraft:glowyblockDyedFence").setCreativeTab(tabs);
// Sand
		blockDyedSand = new BlockDyedSand(ConfigGwycraft.blockDyedSandID).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("Gwycraft:blockDyedSand").setCreativeTab(tabs);
		glowyblockDyedSand = new BlockDyedSand(ConfigGwycraft.glowyblockDyedSandID).setLightValue(1F).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("Gwycraft:glowyblockDyedSand").setCreativeTab(tabs);
// Stone Brick
		blockDyedStoneBrick = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedStoneBrickID, Material.rock, "stonebrick").setLightValue(1F).setHardness(2f).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:blockDyedStoneBrick").setCreativeTab(tabs);
		glowyblockDyedStoneBrick = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedStoneBrickID, Material.rock, "stonebrick").setLightValue(1F).setHardness(2f).setStepSound(Block.stone.stepSound).setUnlocalizedName("Gwycraft:glowyblockDyedStoneBrick").setCreativeTab(tabs);
        blockDyedStoneBrickSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneBrickSlab1ID, false, Material.rock, "stonebrick").setUnlocalizedName("Gwycraft:DyedStoneBrickSlab1").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneBrickDoubleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneBrickDoubleSlab1ID, true, Material.rock, "stonebrick").setUnlocalizedName("Gwycraft:DyedStoneBrickDoubleSlab1").setHardness(2.0F);
        blockDyedStoneBrickSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneBrickSlab2ID, false, Material.rock, "stonebrick").setUnlocalizedName("Gwycraft:DyedStoneBrickSlab2").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneBrickDoubleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneBrickDoubleSlab2ID, true, Material.rock, "stonebrick").setUnlocalizedName("Gwycraft:DyedStoneBrickDoubleSlab2").setHardness(2.0F);
        blockDyedStoneBrickPaver = new BlockGwyGenericPaver(ConfigGwycraft.blockDyedStoneBrickPaverID, "stonebrick").setUnlocalizedName("Gwycraft:BlockDyedStoneBrickPaver").setHardness(2.0F).setCreativeTab(tabs);
// Stone Cobble
		blockDyedStoneCobble = new BlockGwyGenericBlock(ConfigGwycraft.blockDyedStoneCobbleID, Material.rock, "stonecobble").setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Gwycraft:blockDyedStonecobble").setCreativeTab(tabs);
		glowyblockDyedStoneCobble = new BlockGwyGenericBlock(ConfigGwycraft.glowyblockDyedStoneCobbleID, Material.rock, "stonecobble").setLightValue(1F).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Gwycraft:glowyblockDyedStonecobble").setCreativeTab(tabs);
        blockDyedCobbleWalls = new BlockDyedCobbleWalls(ConfigGwycraft.blockDyedStoneCobbleWallsID, blockDyedStoneCobble).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Gwycraft:blockDyedCobbleWalls").setCreativeTab(tabs);
        glowyblockDyedCobbleWalls = new BlockDyedCobbleWalls(ConfigGwycraft.glowyblockDyedStoneCobbleWallsID, blockDyedStoneCobble).setLightValue(1F).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Gwycraft:glowyblockDyedCobbleWalls").setCreativeTab(tabs);
        blockDyedStoneCobbleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneCobbleSlab1ID, false, Material.rock, "stonecobble").setUnlocalizedName("Gwycraft:DyedStoneSlab1").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneCobbleDoubleSlab1 = (BlockHalfSlab) new BlockGwyGenericSlab1(ConfigGwycraft.blockDyedStoneCobbleDoubleSlab1ID, true, Material.rock, "stonecobble").setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab1").setHardness(2.0F);
        blockDyedStoneCobbleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneCobbleSlab2ID, false, Material.rock, "stonecobble").setUnlocalizedName("Gwycraft:DyedStoneSlab2").setHardness(2.0F).setCreativeTab(tabs);
        blockDyedStoneCobbleDoubleSlab2 = (BlockHalfSlab) new BlockGwyGenericSlab2(ConfigGwycraft.blockDyedStoneCobbleDoubleSlab2ID, true, Material.rock, "stonecobble").setUnlocalizedName("Gwycraft:DyedStoneDoubleSlab2").setHardness(2.0F);
        blockDyedStoneCobblePaver = new BlockGwyGenericPaver(ConfigGwycraft.blockDyedStoneCobblePaverID, "stonecobble").setUnlocalizedName("Gwycraft:BlockDyedStonePaver1").setHardness(2.0F).setCreativeTab(tabs);
// Logs
		blockDyedLog1 = new BlockDyedLog1(ConfigGwycraft.blockDyedLog1ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:blockDyedLog1");
        blockDyedLog2 = new BlockDyedLog2(ConfigGwycraft.blockDyedLog2ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:blockDyedLog2");
        blockDyedLog3 = new BlockDyedLog3(ConfigGwycraft.blockDyedLog3ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:blockDyedLog3");
        blockDyedLog4 = new BlockDyedLog4(ConfigGwycraft.blockDyedLog4ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:blockDyedLog4");
        glowyblockDyedLog1 = new BlockDyedLog1(ConfigGwycraft.glowyblockDyedLog1ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:glowyblockDyedLog1").setLightValue(1F);
        glowyblockDyedLog2 = new BlockDyedLog2(ConfigGwycraft.glowyblockDyedLog2ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:glowyblockDyedLog2").setLightValue(1F);
        glowyblockDyedLog3 = new BlockDyedLog3(ConfigGwycraft.glowyblockDyedLog3ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:glowyblockDyedLog3").setLightValue(1F);
        glowyblockDyedLog4 = new BlockDyedLog4(ConfigGwycraft.glowyblockDyedLog4ID).setCreativeTab(tabs).setUnlocalizedName("Gwycraft:glowyblockDyedLog4").setLightValue(1F);
// Gems
        blockGemOre = new BlockGemOre(ConfigGwycraft.blockGemOreID, Material.rock).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("gemOre").setCreativeTab(tabs);
        blockGemCompressed = new BlockGemCompressed(ConfigGwycraft.blockGemCompressedID, Material.rock).setLightValue(1F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockGemCompressed").setCreativeTab(tabs);
// Torches        
        blockWhiteDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockWhiteDyedTorchID, "torch_white").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_white").setCreativeTab(tabs);
        blockOrangeDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockOrangeDyedTorchID, "torch_orange").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_orange").setCreativeTab(tabs);
        blockMagentaDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockMagentaDyedTorchID, "torch_magenta").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_magenta").setCreativeTab(tabs);
        blockLBlueDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockLBlueDyedTorchID, "torch_lblue").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_lblue").setCreativeTab(tabs);
        blockYellowDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockYellowDyedTorchID, "torch_yellow").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_yellow").setCreativeTab(tabs);
        blockLGreenDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockLGreenDyedTorchID, "torch_lgreen").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_lgreen").setCreativeTab(tabs);
        blockPinkDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockPinkDyedTorchID, "torch_pink").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_pink").setCreativeTab(tabs);
        blockDGrayDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockDGrayDyedTorchID, "torch_dgray").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_dgray").setCreativeTab(tabs);
        blockLGrayDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockLGrayDyedTorchID, "torch_lgray").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_lgray").setCreativeTab(tabs);
        blockCyanDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockCyanDyedTorchID, "torch_cyan").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_cyan").setCreativeTab(tabs);
        blockPurpleDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockPurpleDyedTorchID, "torch_purple").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_purple").setCreativeTab(tabs);
        blockBlueDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockBlueDyedTorchID, "torch_blue").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_blue").setCreativeTab(tabs);
        blockBrownDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockBrownDyedTorchID, "torch_brown").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_brown").setCreativeTab(tabs);
        blockGreenDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockGreenDyedTorchID, "torch_green").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_green").setCreativeTab(tabs);
        blockRedDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockRedDyedTorchID, "torch_red").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_red").setCreativeTab(tabs);
        blockBlackDyedTorch = new BlockDyedTorch(ConfigGwycraft.blockBlackDyedTorchID, "torch_black").setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("gwycraft:torch_black").setCreativeTab(tabs);
// Items
        itemEnchantedGems = new ItemEnchantedGems(ConfigGwycraft.itemEnchantedGemsID).setUnlocalizedName("Gwycraft:itemEnchantedGems").setCreativeTab(tabs);
        itemDyedClay = new ItemDyedClay(ConfigGwycraft.itemDyedClayID).setUnlocalizedName("Gwycraft:itemDyedClay").setCreativeTab(tabs);
        itemDyedClayBricks = new ItemDyedClayBricks(ConfigGwycraft.itemDyedClayBricksID).setUnlocalizedName("Gwycraft:itemDyedClayBricks").setCreativeTab(tabs);
        itemDyedMud = new ItemDyedMud(ConfigGwycraft.itemDyedMudID).setUnlocalizedName("Gwycraft:itemMud").setCreativeTab(tabs);
        itemDyedMudBricks = new ItemDyedMudBricks(ConfigGwycraft.itemDyedMudBricksID).setUnlocalizedName("Gwycraft:itemMudBricks").setCreativeTab(tabs);
        itemDyedSticks = new ItemDyedSticks(ConfigGwycraft.itemDyedSticksID).setUnlocalizedName("Gwycraft:itemDyedSticks").setCreativeTab(tabs);
        itemGemShears = new ItemGemShears(ConfigGwycraft.itemGemShearsID).setUnlocalizedName("Gwycraft:gemshears").setCreativeTab(tabs);

        CommonProxy.registerRenderers();

        //  GameRegistry Register Blocks
     // Wool        
        GameRegistry.registerBlock(glowyWool, ItemGlowyWool.class, "glowyWool");
     // Stone
        GameRegistry.registerBlock(blockDyedStone, ItemGwyGeneric.class, "blockDyedStone");
        GameRegistry.registerBlock(glowyblockDyedStone, ItemGwyGeneric.class, "glowyblockDyedStone");
        GameRegistry.registerBlock(blockDyedStonePaver, ItemGwyGeneric.class, "blockDyedStonePaver");
        GameRegistry.registerBlock(blockDyedStoneSlab1, "blockDyedStoneSlab1");
        GameRegistry.registerBlock(blockDyedStoneSlab2, "blockDyedStoneSlab2");
     // Bookshelves
        GameRegistry.registerBlock(blockDyedBookcase, ItemDyedBookshelf.class, "blockDyedBookcase");
        GameRegistry.registerBlock(glowyblockDyedBookcase, ItemDyedBookshelf.class, "glowyblockDyedBookcase");
     // Brick
        GameRegistry.registerBlock(blockDyedBrick, ItemGwyGeneric.class, "blockDyedBrick");
        GameRegistry.registerBlock(glowyblockDyedBrick, ItemGwyGeneric.class, "glowyblockDyedBrick");
        GameRegistry.registerBlock(blockDyedBrickSlab1, "blockDyedBrickSlab1");
        GameRegistry.registerBlock(blockDyedBrickSlab2, "blockDyedBrickSlab2");
        GameRegistry.registerBlock(blockDyedBrickPaver, ItemGwyGeneric.class, "blockDyedBrickPaver");
     // Clay
        GameRegistry.registerBlock(blockDyedClayblock, ItemGwyGeneric.class, "blockDyedClayblock");
        GameRegistry.registerBlock(glowyblockDyedClayblock, ItemGwyGeneric.class, "glowyblockDyedClayblock");
     // Glass
        GameRegistry.registerBlock(blockDyedGlass, ItemDyedGlass.class, "blockDyedGlass");
        GameRegistry.registerBlock(glowyblockDyedGlass, ItemGlowyDyedGlass.class, "glowyblockDyedGlass");
     // Leaf
        GameRegistry.registerBlock(blockDyedLeaf, ItemDyedLeaf.class, "blockDyedLeaf");
        GameRegistry.registerBlock(glowyblockDyedLeaf, ItemDyedLeaf.class, "glowyblockDyedLeaf");
     // Mud Brick
        GameRegistry.registerBlock(blockDyedMudBrick, ItemGwyGeneric.class, "blockDyedMudBrick");
        GameRegistry.registerBlock(glowyblockDyedMudBrick, ItemGwyGeneric.class, "glowyblockDyedMudBrick");
        GameRegistry.registerBlock(blockDyedMudBrickPaver, ItemGwyGeneric.class, "blockDyedMudBrickPaver");
        GameRegistry.registerBlock(blockDyedMudBrickSlab1, "blockDyedMudBrickSlab1");
        GameRegistry.registerBlock(blockDyedMudBrickSlab2, "blockDyedMudBrickSlab2");
     // Planks
        GameRegistry.registerBlock(blockDyedPlank, ItemDyedPlank.class, "blockDyedPlank");
        GameRegistry.registerBlock(glowyblockDyedPlank, ItemGwyGeneric.class, "glowyblockDyedPlank");
        GameRegistry.registerBlock(blockDyedFences, ItemDyedFences.class, "blockDyedFences");
        GameRegistry.registerBlock(glowyblockDyedFences, ItemDyedFences.class, "glowyblockDyedFences");
     // Sand
        GameRegistry.registerBlock(blockDyedSand, ItemGwyGeneric.class, "blockDyedSand");
        GameRegistry.registerBlock(glowyblockDyedSand, ItemGwyGeneric.class, "glowyblockDyedSand");
     // Stone Brick
        GameRegistry.registerBlock(blockDyedStoneBrick, ItemGwyGeneric.class,"blockDyedStoneBrick");
        GameRegistry.registerBlock(glowyblockDyedStoneBrick, ItemGwyGeneric.class, "glowyblockDyedStoneBrick");
        GameRegistry.registerBlock(blockDyedStoneBrickPaver, ItemGwyGeneric.class, "blockDyedStoneBrickPaver");
        GameRegistry.registerBlock(blockDyedStoneBrickSlab1, "blockDyedStoneBrickSlab1");
        GameRegistry.registerBlock(blockDyedStoneBrickSlab2, "blockDyedStoneBrickSlab2");
     // Stone Cobble
        GameRegistry.registerBlock(blockDyedStoneCobble, ItemGwyGeneric.class, "blockDyedStoneCobble");
        GameRegistry.registerBlock(glowyblockDyedStoneCobble, ItemGwyGeneric.class, "glowyblockDyedStoneCobble");
        GameRegistry.registerBlock(blockDyedCobbleWalls, ItemDyedCobbleWalls.class, "blockDyedCobbleWalls");
        GameRegistry.registerBlock(glowyblockDyedCobbleWalls, ItemDyedCobbleWalls.class, "glowyblockDyedCobbleWalls");
        GameRegistry.registerBlock(blockDyedStoneCobblePaver, ItemGwyGeneric.class, "blockDyedStoneCobblePaver");
        GameRegistry.registerBlock(blockDyedStoneCobbleSlab1, "blockDyedStoneCobbleSlab1");
        GameRegistry.registerBlock(blockDyedStoneCobbleSlab2, "blockDyedStoneCobbleSlab2");
     // Logs
        GameRegistry.registerBlock(blockDyedLog1, ItemDyedLog1.class, "blockDyedLog1");
        GameRegistry.registerBlock(blockDyedLog2, ItemDyedLog2.class, "blockDyedLog2");
        GameRegistry.registerBlock(blockDyedLog3, ItemDyedLog3.class, "blockDyedLog3");
        GameRegistry.registerBlock(blockDyedLog4, ItemDyedLog4.class, "blockDyedLog4");
        GameRegistry.registerBlock(glowyblockDyedLog1, ItemDyedLog1.class, "glowyblockDyedLog1");
        GameRegistry.registerBlock(glowyblockDyedLog2, ItemDyedLog2.class, "glowyblockDyedLog2");
        GameRegistry.registerBlock(glowyblockDyedLog3, ItemDyedLog3.class, "glowyblockDyedLog3");
        GameRegistry.registerBlock(glowyblockDyedLog4, ItemDyedLog4.class, "glowyblockDyedLog4");
     // Gems
        GameRegistry.registerBlock(blockGemCompressed, ItemGemCompressed.class, "blockGemCompressed");
        GameRegistry.registerBlock(blockGemOre, ItemGemOre.class, "blockGemOre");
     // Torches        
        GameRegistry.registerBlock(blockWhiteDyedTorch, "blockWhiteDyedTorch");
        GameRegistry.registerBlock(blockOrangeDyedTorch, "blockOrangeDyedTorch");
        GameRegistry.registerBlock(blockMagentaDyedTorch, "blockMagentaDyedTorch");
        GameRegistry.registerBlock(blockLBlueDyedTorch, "blockLBlueDyedTorch");
        GameRegistry.registerBlock(blockYellowDyedTorch, "blockYellowDyedTorch");
        GameRegistry.registerBlock(blockLGreenDyedTorch, "blockLGreenDyedTorch");
        GameRegistry.registerBlock(blockPinkDyedTorch, "blockPinkDyedTorch");
        GameRegistry.registerBlock(blockDGrayDyedTorch, "blockDGrayDyedTorch");
        GameRegistry.registerBlock(blockLGrayDyedTorch, "blockLGrayDyedTorch");
        GameRegistry.registerBlock(blockCyanDyedTorch, "blockCyanDyedTorch");
        GameRegistry.registerBlock(blockPurpleDyedTorch, "blockPurpleDyedTorch");
        GameRegistry.registerBlock(blockBlueDyedTorch, "blockBlueDyedTorch");
        GameRegistry.registerBlock(blockBrownDyedTorch, "blockBrownDyedTorch");
        GameRegistry.registerBlock(blockGreenDyedTorch, "blockGreenDyedTorch");
        GameRegistry.registerBlock(blockRedDyedTorch, "blockRedDyedTorch");
        GameRegistry.registerBlock(blockBlackDyedTorch, "blockBlackDyedTorch");
     // Items
        GameRegistry.registerItem(itemEnchantedGems, "itemEnchantedGems", null);
        GameRegistry.registerItem(itemDyedClay, "itemDyedClay", null);
        GameRegistry.registerItem(itemDyedClayBricks, "itemDyedClayBricks", null);
        GameRegistry.registerItem(itemDyedMud, "itemDyedMud", null)   ;
        GameRegistry.registerItem(itemDyedMudBricks, "itemDyedMudBricks", null);
        GameRegistry.registerItem(itemDyedSticks, "itemDyedSticks", null);
        GameRegistry.registerItem(itemGemShears, "itemGemShears", null);
        
        LanguageRegistry.addName(blockWhiteDyedTorch, "White Torch");
        LanguageRegistry.addName(blockOrangeDyedTorch, "Orange Torch");
        LanguageRegistry.addName(blockMagentaDyedTorch, "Magenta Torch");
        LanguageRegistry.addName(blockLBlueDyedTorch, "Light Blue Torch");
        LanguageRegistry.addName(blockYellowDyedTorch, "Yellow Torch");
        LanguageRegistry.addName(blockLGreenDyedTorch, "Light Green Torch");
        LanguageRegistry.addName(blockPinkDyedTorch, "Pink Torch");
        LanguageRegistry.addName(blockDGrayDyedTorch, "Gray Torch");
        LanguageRegistry.addName(blockLGrayDyedTorch, "Light Gray Torch");
        LanguageRegistry.addName(blockCyanDyedTorch, "Cyan Torch");
        LanguageRegistry.addName(blockPurpleDyedTorch, "Purple Torch");
        LanguageRegistry.addName(blockBlueDyedTorch, "Blue Torch");
        LanguageRegistry.addName(blockBrownDyedTorch, "Brown Torch");
        LanguageRegistry.addName(blockGreenDyedTorch, "Green Torch");
        LanguageRegistry.addName(blockRedDyedTorch, "Red Torch");
        LanguageRegistry.addName(blockBlackDyedTorch, "Black Torch");
        LanguageRegistry.addName(itemGemShears, "Gem Shears");
             
        Item.itemsList[ConfigGwycraft.blockDyedStoneSlab1ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneSlab1ID - 256, blockDyedStoneSlab1, blockDyedStoneDoubleSlab1, false)).setUnlocalizedName("blockDyedStoneSlab1");
        Item.itemsList[ConfigGwycraft.blockDyedStoneSlab2ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneSlab2ID - 256, blockDyedStoneSlab2, blockDyedStoneDoubleSlab2, false)).setUnlocalizedName("blockDyedStoneSlab2");
        Item.itemsList[ConfigGwycraft.blockDyedStoneBrickSlab1ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneBrickSlab1ID - 256, blockDyedStoneBrickSlab1, blockDyedStoneBrickDoubleSlab1, false)).setUnlocalizedName("blockDyedStoneBrickSlab1");
        Item.itemsList[ConfigGwycraft.blockDyedStoneBrickSlab2ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneBrickSlab2ID - 256, blockDyedStoneBrickSlab2, blockDyedStoneBrickDoubleSlab2, false)).setUnlocalizedName("blockDyedStoneBrickSlab2");
        Item.itemsList[ConfigGwycraft.blockDyedBrickSlab1ID] = (new ItemSlab (ConfigGwycraft.blockDyedBrickSlab1ID - 256, blockDyedBrickSlab1, blockDyedBrickDoubleSlab1, false)).setUnlocalizedName("blockDyedBrickSlab1");
        Item.itemsList[ConfigGwycraft.blockDyedBrickSlab2ID] = (new ItemSlab (ConfigGwycraft.blockDyedBrickSlab2ID - 256, blockDyedBrickSlab2, blockDyedBrickDoubleSlab2, false)).setUnlocalizedName("blockDyedBrickSlab2");
        Item.itemsList[ConfigGwycraft.blockDyedMudBrickSlab1ID] = (new ItemSlab (ConfigGwycraft.blockDyedMudBrickSlab1ID - 256, blockDyedMudBrickSlab1, blockDyedMudBrickDoubleSlab1, false)).setUnlocalizedName("blockDyedMudBrickSlab1");
        Item.itemsList[ConfigGwycraft.blockDyedMudBrickSlab2ID] = (new ItemSlab (ConfigGwycraft.blockDyedMudBrickSlab2ID - 256, blockDyedMudBrickSlab2, blockDyedMudBrickDoubleSlab2, false)).setUnlocalizedName("blockDyedMudBrickSlab2");
        Item.itemsList[ConfigGwycraft.blockDyedStoneCobbleSlab1ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneCobbleSlab1ID - 256, blockDyedStoneCobbleSlab1, blockDyedStoneCobbleDoubleSlab1, false)).setUnlocalizedName("blockDyedStoneCobbleSlab1");
        Item.itemsList[ConfigGwycraft.blockDyedStoneCobbleSlab2ID] = (new ItemSlab (ConfigGwycraft.blockDyedStoneCobbleSlab2ID - 256, blockDyedStoneCobbleSlab2, blockDyedStoneCobbleDoubleSlab2, false)).setUnlocalizedName("blockDyedStoneCobbleSlab2");

        OreDictionary.registerOre("stoneCobble", Block.cobblestone);
        
        // Language Registry
        // 16 Meta
        for (int i = 0; i < 16; i++) {
        	// Dye is inverted compared to wool
        	ItemStack dye = new ItemStack(Item.dyePowder, 1, 15 - i);
        	
			ItemStack cloth = new ItemStack(Block.cloth, 1, i);
			ItemStack glowyWoolStack = new ItemStack(glowyWool, 1, i);
            ItemStack blockDyedStoneStack = new ItemStack(blockDyedStone, 1, i);
            ItemStack glowyblockDyedStoneStack = new ItemStack(glowyblockDyedStone, 1, i);
            ItemStack blockDyedBookcaseStack = new ItemStack(blockDyedBookcase, 1, i);
            ItemStack glowyblockDyedBookcaseStack = new ItemStack(glowyblockDyedBookcase, 1, i);
            ItemStack blockDyedPlankStack = new ItemStack(blockDyedPlank, 1, i);
            ItemStack glowyblockDyedPlankStack = new ItemStack(glowyblockDyedPlank, 1, i);
            ItemStack blockDyedBrickStack = new ItemStack(blockDyedBrick, 1, i);
            ItemStack glowyblockDyedBrickStack = new ItemStack(glowyblockDyedBrick, 1, i);
            ItemStack blockDyedClayblockStack = new ItemStack(blockDyedClayblock, 1, i);
            ItemStack glowyblockDyedClayblockStack = new ItemStack(glowyblockDyedClayblock, 1, i);
            ItemStack blockDyedGlassStack = new ItemStack(blockDyedGlass, 1, i);
            ItemStack glowyblockDyedGlassStack = new ItemStack(glowyblockDyedGlass, 1, i);
            ItemStack blockDyedLeafStack = new ItemStack(blockDyedLeaf, 1, i);
            ItemStack glowyblockDyedLeafStack = new ItemStack(glowyblockDyedLeaf, 1, i);
            ItemStack blockDyedMudBrickStack = new ItemStack(blockDyedMudBrick, 1, i);
            ItemStack glowyblockDyedMudBrickStack = new ItemStack(glowyblockDyedMudBrick, 1, i);
            ItemStack blockDyedSandStack = new ItemStack(blockDyedSand, 1, i);
            ItemStack glowyblockDyedSandStack = new ItemStack(glowyblockDyedSand, 1, i);
            ItemStack blockDyedStoneBrickStack = new ItemStack(blockDyedStoneBrick, 1, i);
            ItemStack glowyblockDyedStoneBrickStack = new ItemStack(glowyblockDyedStoneBrick, 1, i);
            ItemStack blockDyedStonecobbleStack = new ItemStack(blockDyedStoneCobble, 1, i);
            ItemStack glowyblockDyedStonecobbleStack = new ItemStack(glowyblockDyedStoneCobble, 1, i);
            ItemStack blockGemCompressedStack = new ItemStack(blockGemCompressed, 1, i);
            ItemStack blockGemOreStack = new ItemStack(blockGemOre, 1, i);
            ItemStack itemEnchantedGemsStack = new ItemStack(itemEnchantedGems, 1, i);
            ItemStack itemDyedClayStack = new ItemStack(itemDyedClay, 1, i);
            ItemStack itemDyedClayBricksStack = new ItemStack(itemDyedClayBricks, 1, i);
            ItemStack itemDyedMudStack = new ItemStack(itemDyedMud, 1, i);
            ItemStack itemDyedMudBricksStack = new ItemStack(itemDyedMudBricks, 1, i);
            ItemStack blockDyedFencesStack = new ItemStack(blockDyedFences, 1, i);
            ItemStack glowyblockDyedFencesStack = new ItemStack(glowyblockDyedFences, 1, i);
            ItemStack blockDyedCobbleWallsStack = new ItemStack(blockDyedCobbleWalls, 1, i);
            ItemStack glowyblockDyedCobbleWallsStack = new ItemStack(glowyblockDyedCobbleWalls, 1, i);
            ItemStack itemDyedSticksStack = new ItemStack(itemDyedSticks, 1, i);
            ItemStack blockDyedStonePaverStack = new ItemStack(blockDyedStonePaver, 1, i);
            ItemStack blockDyedBrickPaverStack = new ItemStack(blockDyedBrickPaver, 1, i);
            ItemStack blockDyedMudBrickPaverStack = new ItemStack(blockDyedMudBrickPaver, 1, i);
            ItemStack blockDyedStoneBrickPaverStack = new ItemStack(blockDyedStoneBrickPaver, 1, i);
            ItemStack blockDyedStoneCobblePaverStack = new ItemStack(blockDyedStoneCobblePaver, 1, i);
            
            // Language Registry
			LanguageRegistry.addName(glowyWoolStack, "Glowy " + gwyColorNames[glowyWoolStack.getItemDamage()] + " Wool");
			LanguageRegistry.addName(blockDyedStoneStack, gwyColorNames[blockDyedStoneStack.getItemDamage()] + " Stone");
            LanguageRegistry.addName(glowyblockDyedStoneStack, "Glowy " + gwyColorNames[glowyblockDyedStoneStack.getItemDamage()] + " Stone");
            LanguageRegistry.addName(blockDyedBookcaseStack, gwyColorNames[blockDyedBookcaseStack.getItemDamage()] + " Bookcase");
            LanguageRegistry.addName(glowyblockDyedBookcaseStack, "Glowy " + gwyColorNames[glowyblockDyedBookcaseStack.getItemDamage()] + " Bookcase");
            LanguageRegistry.addName(blockDyedPlankStack, gwyColorNames[blockDyedPlankStack.getItemDamage()] + " Plank");
            LanguageRegistry.addName(glowyblockDyedPlankStack, "Glowy " + gwyColorNames[glowyblockDyedPlankStack.getItemDamage()] + " Plank");
            LanguageRegistry.addName(blockDyedBrickStack, gwyColorNames[blockDyedBrickStack.getItemDamage()] + " Brick");
            LanguageRegistry.addName(glowyblockDyedBrickStack, "Glowy " + gwyColorNames[glowyblockDyedBrickStack.getItemDamage()] + " Brick");
			LanguageRegistry.addName(blockDyedClayblockStack, gwyColorNames[blockDyedClayblockStack.getItemDamage()] + " Clay Block");
			LanguageRegistry.addName(glowyblockDyedClayblockStack, "Glowy " + gwyColorNames[glowyblockDyedClayblockStack.getItemDamage()] + " Clay Block");
			LanguageRegistry.addName(blockDyedGlassStack, gwyColorNames[blockDyedGlassStack.getItemDamage()] + " Glass");
            LanguageRegistry.addName(glowyblockDyedGlassStack, "Glowy " + gwyColorNames[glowyblockDyedGlassStack.getItemDamage()] + " Glass");
			LanguageRegistry.addName(blockDyedLeafStack, gwyColorNames[blockDyedLeafStack.getItemDamage()] + " Leaf");
            LanguageRegistry.addName(glowyblockDyedLeafStack, "Glowy " + gwyColorNames[blockDyedLeafStack.getItemDamage()] + " Leaf");
            LanguageRegistry.addName(blockDyedMudBrickStack, gwyColorNames[blockDyedMudBrickStack.getItemDamage()] + " Mud Brick Block");
            LanguageRegistry.addName(glowyblockDyedMudBrickStack, "Glowy " + gwyColorNames[glowyblockDyedMudBrickStack.getItemDamage()] + " Mud Brick Block");
            LanguageRegistry.addName(blockDyedSandStack, gwyColorNames[blockDyedSandStack.getItemDamage()] + " Sand");
            LanguageRegistry.addName(glowyblockDyedSandStack, "Glowy " + gwyColorNames[glowyblockDyedSandStack.getItemDamage()] + " Sand");
            LanguageRegistry.addName(blockDyedStoneBrickStack, gwyColorNames[blockDyedStoneBrickStack.getItemDamage()] + " Stone Brick");
            LanguageRegistry.addName(glowyblockDyedStoneBrickStack, "Glowy " + gwyColorNames[glowyblockDyedStoneBrickStack.getItemDamage()] + " Stone Brick");
            LanguageRegistry.addName(blockDyedStonecobbleStack, gwyColorNames[blockDyedStonecobbleStack.getItemDamage()] + " Cobblestone");
            LanguageRegistry.addName(glowyblockDyedStonecobbleStack, "Glowy " + gwyColorNames[glowyblockDyedStonecobbleStack.getItemDamage()] + " Cobblestone");
            LanguageRegistry.addName(blockGemCompressedStack, gwyGemNames[blockGemCompressedStack.getItemDamage()] + " Block");
            LanguageRegistry.addName(blockGemOreStack, gwyGemNames[blockGemOreStack.getItemDamage()] + " Ore");
            LanguageRegistry.addName(itemEnchantedGemsStack, gwyGemNames[i]);
            LanguageRegistry.addName(itemDyedClayStack, gwyColorNames[i] + " Clay");
            LanguageRegistry.addName(itemDyedClayBricksStack, gwyColorNames[i] + " Clay Bricks");
            LanguageRegistry.addName(itemDyedMudStack, gwyColorNames[i] + " Mud");
            LanguageRegistry.addName(itemDyedMudBricksStack, gwyColorNames[i] + " Mud Bricks");
            LanguageRegistry.addName(blockDyedFencesStack, gwyColorNames[i] + " Fence");
            LanguageRegistry.addName(glowyblockDyedFencesStack, "Glowy " + gwyColorNames[i] + " Fence");
            LanguageRegistry.addName(blockDyedCobbleWallsStack, gwyColorNames[i] + " Cobble Walls");
            LanguageRegistry.addName(glowyblockDyedCobbleWallsStack, "Glowy " + gwyColorNames[i] + " Cobble Walls");
            LanguageRegistry.addName(itemDyedSticksStack, gwyColorNames[i] + " Stick");
            LanguageRegistry.addName(blockDyedStonePaverStack, gwyColorNames[i] + " Stone Paver");
            LanguageRegistry.addName(blockDyedBrickPaverStack, gwyColorNames[i] + " Brick Paver");
            LanguageRegistry.addName(blockDyedMudBrickPaverStack, gwyColorNames[i] + " Mud Brick Paver");
            LanguageRegistry.addName(blockDyedStoneBrickPaverStack, gwyColorNames[i] + " Stone Brick Paver");
            LanguageRegistry.addName(blockDyedStoneCobblePaverStack, gwyColorNames[i] + " Stone Cobble Paver");

            //  Add Recipes
            GameRegistry.addRecipe(new ItemStack(blockDyedBookcase, 1, i), "###", "XXX", "###", '#', blockDyedPlankStack, 'X', Item.book);
            GameRegistry.addRecipe(new ItemStack(glowyblockDyedBookcase, 1, i), "###", "XXX", "###", '#', glowyblockDyedPlankStack, 'X', Item.book);
            GameRegistry.addRecipe(new ItemStack(itemDyedSticks, 4, i), "X", "X", 'X', blockDyedPlankStack);
            GameRegistry.addRecipe(new ItemStack(blockGemCompressed, 1, i), "XX", "XX", 'X', itemEnchantedGemsStack);
            GameRegistry.addRecipe(new ItemStack(itemEnchantedGems, 4, i), "X", 'X', blockGemCompressedStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneBrick, 4, i), "xx", "xx", 'x', blockDyedStoneStack);
            GameRegistry.addRecipe(new ItemStack(glowyblockDyedStoneBrick, 4, i), "XX", "XX", 'X', glowyblockDyedStoneStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedFences, 2, i), "XXX", "XXX", 'X', itemDyedSticksStack);
            GameRegistry.addRecipe(new ItemStack(itemGemShears, 1, 0), " X", "X ", 'X', itemEnchantedGemsStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedMudBrick, 4, i), "XX", "XX", 'X', itemDyedMudBricksStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedClayblock, 1, i), "XX", "XX", 'X', itemDyedClayStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedBrick, 1, i), "XX", "XX", 'X', itemDyedClayBricksStack);
            GameRegistry.addRecipe(new ItemStack(blockDyedCobbleWalls, 1, i), "XXX", "XXX", 'X', blockDyedStonecobbleStack);
            GameRegistry.addRecipe(new ItemStack(glowyblockDyedCobbleWalls, 1, i), "XXX", "XXX", 'X', glowyblockDyedStonecobbleStack);
            
            // Add Shapeless Recipes
            GameRegistry.addShapelessRecipe(glowyWoolStack, new ItemStack(Block.glowStone), cloth);
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedSand, 8, i), dye, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedSand, 8, i), itemEnchantedGemsStack, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand, Block.sand);
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedPlank, 8, i), dye, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedPlank, 8, i), itemEnchantedGemsStack, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks, Block.planks);
            GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 4, 15-i), itemEnchantedGemsStack, Item.gunpowder, Item.glassBottle );
            GameRegistry.addShapelessRecipe(new ItemStack(itemDyedMud, 16, i), Block.dirt, Block.dirt, Block.dirt, Block.dirt, Block.dirt, Block.dirt, Item.clay, Item.potion, dye);
            GameRegistry.addShapelessRecipe(new ItemStack(itemDyedClay, 8, i), Item.clay, Item.clay, Item.clay, Item.clay, Item.clay, Item.clay, Item.clay, Item.clay, dye);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedClayblock, 8, i), itemEnchantedGemsStack, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay, Block.blockClay);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedBrick, 8, i), itemEnchantedGemsStack, Block.brick, Block.brick, Block.brick, Block.brick, Block.brick, Block.brick, Block.brick, Block.brick);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedFences, 8, i), itemEnchantedGemsStack, Block.fence, Block.fence, Block.fence, Block.fence, Block.fence, Block.fence, Block.fence, Block.fence);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedMudBrick, 8, i), Block.glowStone, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack, blockDyedMudBrickStack);
            
            // Add Furnace Recipes
            FurnaceRecipes.smelting().addSmelting(blockDyedStoneCobble.blockID, i, new ItemStack(blockDyedStone, 1, i ), 0.1F);
            FurnaceRecipes.smelting().addSmelting(glowyblockDyedStoneCobble.blockID, i, new ItemStack(glowyblockDyedStone, 1, i ), 0.1F);
            FurnaceRecipes.smelting().addSmelting(blockDyedSand.blockID, i, new ItemStack(blockDyedGlass, 1, i ), 0.1F);
            FurnaceRecipes.smelting().addSmelting(glowyblockDyedSand.blockID, i, new ItemStack(glowyblockDyedGlass, 1, i ), 0.1F);
            FurnaceRecipes.smelting().addSmelting(itemDyedMud.itemID, i, new ItemStack(itemDyedMudBricks, 1, i), 0.1F);
            FurnaceRecipes.smelting().addSmelting(itemDyedClay.itemID, i, new ItemStack(itemDyedClayBricks, 1, i), 0.1F);

            // Ore Dictionary
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockDyedStoneCobble, 8, i), dye, "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble"));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(glowyblockDyedStoneCobble, 8, i), itemEnchantedGemsStack, "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble", "stoneCobble"));

            // Recipes for Dyed Leaves
            for (int j = 0; j < 4; j++) {
                ItemStack leaf = new ItemStack(Block.leaves, 1, j);
                GameRegistry.addShapelessRecipe(new ItemStack(blockDyedLeaf, 8, i), dye, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);
                GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedLeaf, 8, i), itemEnchantedGemsStack, leaf, leaf, leaf, leaf, leaf, leaf, leaf, leaf);
            }

            // Recipes for Dyed Torches
            if ( i == 0)
                GameRegistry.addRecipe(new ItemStack(blockWhiteDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 1)
                GameRegistry.addRecipe(new ItemStack(blockOrangeDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 2)
                GameRegistry.addRecipe(new ItemStack(blockMagentaDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 3)
                GameRegistry.addRecipe(new ItemStack(blockLBlueDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 4)
                GameRegistry.addRecipe(new ItemStack(blockYellowDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 5)
                GameRegistry.addRecipe(new ItemStack(blockLGreenDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 6)
                GameRegistry.addRecipe(new ItemStack(blockPinkDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 7)
                GameRegistry.addRecipe(new ItemStack(blockDGrayDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 8)
                GameRegistry.addRecipe(new ItemStack(blockLGrayDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 9)
                GameRegistry.addRecipe(new ItemStack(blockCyanDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 10)
                GameRegistry.addRecipe(new ItemStack(blockPurpleDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 11)
                GameRegistry.addRecipe(new ItemStack(blockBlueDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 12)
                GameRegistry.addRecipe(new ItemStack(blockBrownDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i == 13)
                GameRegistry.addRecipe(new ItemStack(blockGreenDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            else if ( i ==14)
                GameRegistry.addRecipe(new ItemStack(blockRedDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
            GameRegistry.addRecipe(new ItemStack(blockBlackDyedTorch, 4), "X", "#", 'X', Item.coal, '#', itemDyedSticksStack);
        }

        // 8 Meta
        for (int i = 0; i < 8; i++) {

            // Item Stacks
            ItemStack blockDyedStoneSlab1Stack = new ItemStack(blockDyedStoneSlab1, 1, i);
            ItemStack blockDyedStoneSlab2Stack = new ItemStack(blockDyedStoneSlab2, 1, i);
            ItemStack blockDyedStone1Stack = new ItemStack(blockDyedStone, 8, i);
            ItemStack blockDyedStone2Stack = new ItemStack(blockDyedStone, 8, i+8);
            ItemStack blockDyedStoneBrickSlab1Stack = new ItemStack(blockDyedStoneBrickSlab1, 1, i);
            ItemStack blockDyedStoneBrickSlab2Stack = new ItemStack(blockDyedStoneBrickSlab2, 1, i);
            ItemStack blockDyedStoneBrick1Stack = new ItemStack(blockDyedStoneBrick, 8, i);
            ItemStack blockDyedStoneBrick2Stack = new ItemStack(blockDyedStoneBrick, 8, i+8);
            ItemStack blockDyedBrickSlab1Stack = new ItemStack(blockDyedBrickSlab1, 1, i);
            ItemStack blockDyedBrickSlab2Stack = new ItemStack(blockDyedBrickSlab2, 1, i);
            ItemStack blockDyedBrick1Stack = new ItemStack(blockDyedBrick, 8, i);
            ItemStack blockDyedBrick2Stack = new ItemStack(blockDyedBrick, 8, i+8);
            ItemStack blockDyedMudBrickSlab1Stack = new ItemStack(blockDyedMudBrickSlab1, 1, i);
            ItemStack blockDyedMudBrickSlab2Stack = new ItemStack(blockDyedMudBrickSlab2, 1, i);
            ItemStack blockDyedMudBrick1Stack = new ItemStack(blockDyedMudBrick, 8, i);
            ItemStack blockDyedMudBrick2Stack = new ItemStack(blockDyedMudBrick, 8, i+8);
            ItemStack blockDyedStoneCobbleSlab1Stack = new ItemStack(blockDyedStoneCobbleSlab1, 1, i);
            ItemStack blockDyedStoneCobbleSlab2Stack = new ItemStack(blockDyedStoneCobbleSlab2, 1, i);
            ItemStack blockDyedStoneCobble1Stack = new ItemStack(blockDyedStoneCobble, 8, i);
            ItemStack blockDyedStoneCobble2Stack = new ItemStack(blockDyedStoneCobble, 8, i+8);

            // Language Registry
            LanguageRegistry.addName(blockDyedStoneSlab1Stack, gwyColorSlab1Names[blockDyedStoneSlab1Stack.getItemDamage()] + " Stone Slab");
            LanguageRegistry.addName(blockDyedStoneSlab2Stack, gwyColorSlab2Names[blockDyedStoneSlab2Stack.getItemDamage()] + " Stone Slab");
            LanguageRegistry.addName(blockDyedStoneBrickSlab1Stack, gwyColorSlab1Names[blockDyedStoneBrickSlab1Stack.getItemDamage()] + " Stone Brick Slab");
            LanguageRegistry.addName(blockDyedStoneBrickSlab2Stack, gwyColorSlab2Names[blockDyedStoneBrickSlab2Stack.getItemDamage()] + " Stone Brick Slab");
            LanguageRegistry.addName(blockDyedBrickSlab1Stack, gwyColorSlab1Names[blockDyedBrickSlab1Stack.getItemDamage()] + " Brick Slab");
            LanguageRegistry.addName(blockDyedBrickSlab2Stack, gwyColorSlab2Names[blockDyedBrickSlab2Stack.getItemDamage()] + " Brick Slab");
            LanguageRegistry.addName(blockDyedMudBrickSlab1Stack, gwyColorSlab1Names[blockDyedMudBrickSlab1Stack.getItemDamage()] + " Mud Brick Slab");
            LanguageRegistry.addName(blockDyedMudBrickSlab2Stack, gwyColorSlab2Names[blockDyedMudBrickSlab2Stack.getItemDamage()] + " Mud Brick Slab");
            LanguageRegistry.addName(blockDyedStoneCobbleSlab1Stack, gwyColorSlab1Names[blockDyedStoneCobbleSlab1Stack.getItemDamage()] + " Stone Cobble Slab");
            LanguageRegistry.addName(blockDyedStoneCobbleSlab2Stack, gwyColorSlab2Names[blockDyedStoneCobbleSlab2Stack.getItemDamage()] + " Stone Cobble Slab");

            //  Add Recipes
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneSlab1, 6, i), "XXX", 'X', blockDyedStone1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneSlab2, 6, i), "XXX", 'X', blockDyedStone2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStonePaver, 12, i), "XXX", 'X', blockDyedStoneSlab1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStonePaver, 12, i+8), "XXX", 'X', blockDyedStoneSlab2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneBrickSlab1, 6, i), "XXX", 'X', blockDyedStoneBrick1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneBrickSlab2, 6, i), "XXX", 'X', blockDyedStoneBrick2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneBrickPaver, 12, i), "XXX", 'X', blockDyedStoneBrickSlab1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneBrickPaver, 12, i+8), "XXX", 'X', blockDyedStoneBrickSlab2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedBrickSlab1, 6, i), "XXX", 'X', blockDyedBrick1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedBrickSlab2, 6, i), "XXX", 'X', blockDyedBrick2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedBrickPaver, 12, i), "XXX", 'X', blockDyedBrickSlab1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedBrickPaver, 12, i+8), "XXX", 'X', blockDyedBrickSlab2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedMudBrickSlab1, 6, i), "XXX", 'X', blockDyedMudBrick1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedMudBrickSlab2, 6, i), "XXX", 'X', blockDyedMudBrick2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedMudBrickPaver, 12, i), "XXX", 'X', blockDyedMudBrickSlab1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedMudBrickPaver, 12, i+8), "XXX", 'X', blockDyedMudBrickSlab2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneCobbleSlab1, 6, i), "XXX", 'X', blockDyedStoneCobble1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneCobbleSlab2, 6, i), "XXX", 'X', blockDyedStoneCobble2Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneCobblePaver, 12, i), "XXX", 'X', blockDyedStoneCobbleSlab1Stack);
            GameRegistry.addRecipe(new ItemStack(blockDyedStoneCobblePaver, 12, i+8), "XXX", 'X', blockDyedStoneCobbleSlab2Stack);
        }        
   
        // 4 Meta
        for (int i = 0; i < 4; i++) {

            // Item Stacks
            ItemStack blockDyedLog1Stack = new ItemStack(blockDyedLog1, 1, i);
            ItemStack blockDyedLog2Stack = new ItemStack(blockDyedLog2, 1, i);
            ItemStack blockDyedLog3Stack = new ItemStack(blockDyedLog3, 1, i);
            ItemStack blockDyedLog4Stack = new ItemStack(blockDyedLog4, 1, i);
            ItemStack dye1 = new ItemStack(Item.dyePowder, 1, 15 - i);
            ItemStack dye2 = new ItemStack(Item.dyePowder, 1, 11 - i);
            ItemStack dye3 = new ItemStack(Item.dyePowder, 1, 7 - i);
            ItemStack dye4 = new ItemStack(Item.dyePowder, 1, 3 - i);
            ItemStack glowyblockDyedLog1Stack = new ItemStack(glowyblockDyedLog1, 1, i);
            ItemStack glowyblockDyedLog2Stack = new ItemStack(glowyblockDyedLog2, 1, i);
            ItemStack glowyblockDyedLog3Stack = new ItemStack(glowyblockDyedLog3, 1, i);
            ItemStack glowyblockDyedLog4Stack = new ItemStack(glowyblockDyedLog4, 1, i);
            ItemStack itemEnchantedGemsStack1 = new ItemStack(itemEnchantedGems, 1, i);
            ItemStack itemEnchantedGemsStack2 = new ItemStack(itemEnchantedGems, 1, i+4);
            ItemStack itemEnchantedGemsStack3 = new ItemStack(itemEnchantedGems, 1, i+8);
            ItemStack itemEnchantedGemsStack4 = new ItemStack(itemEnchantedGems, 1, i+12);

            // Language Registry
            LanguageRegistry.addName(blockDyedLog1Stack, gwyColorLog1Names[blockDyedLog1Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(blockDyedLog2Stack, gwyColorLog2Names[blockDyedLog2Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(blockDyedLog3Stack, gwyColorLog3Names[blockDyedLog3Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(blockDyedLog4Stack, gwyColorLog4Names[blockDyedLog4Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(glowyblockDyedLog1Stack, "Glowy " + gwyColorLog1Names[glowyblockDyedLog1Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(glowyblockDyedLog2Stack, "Glowy " + gwyColorLog2Names[glowyblockDyedLog2Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(glowyblockDyedLog3Stack, "Glowy " + gwyColorLog3Names[glowyblockDyedLog3Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(glowyblockDyedLog4Stack, "Glowy " + gwyColorLog4Names[glowyblockDyedLog4Stack.getItemDamage()] + " Log");

            //  Add Recipes
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedPlank, 4, i), blockDyedLog1Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedPlank, 4, i+4), blockDyedLog2Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedPlank, 4, i+8), blockDyedLog3Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(blockDyedPlank, 4, i+12), blockDyedLog4Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedPlank, 4, i), glowyblockDyedLog1Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedPlank, 4, i+4), glowyblockDyedLog2Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedPlank, 4, i+8), glowyblockDyedLog3Stack);
            GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedPlank, 4, i+12), glowyblockDyedLog4Stack);

            // Recipes for Dyed Leaves
            for (int j = 0; j < 4; j++) {
                ItemStack log = new ItemStack(Block.wood, 1, j);

                GameRegistry.addShapelessRecipe(new ItemStack(blockDyedLog1, 8, i), dye1, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(blockDyedLog2, 8, i), dye2, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(blockDyedLog3, 8, i), dye3, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(blockDyedLog4, 8, i), dye4, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedLog1, 8, i), itemEnchantedGemsStack1, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedLog2, 8, i), itemEnchantedGemsStack2, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedLog3, 8, i), itemEnchantedGemsStack3, log, log, log, log, log, log, log, log);
                GameRegistry.addShapelessRecipe(new ItemStack(glowyblockDyedLog4, 8, i), itemEnchantedGemsStack4, log, log, log, log, log, log, log, log);
            }
        }

        // Items
        // Language Registry
        // Recipes

    }
	
	@EventHandler 
    public void init(FMLInitializationEvent event) {
        LanguageRegistry.instance().addStringLocalization("itemGroup.GwyCraft", "en_US", "GwyCraft");
        GameRegistry.registerWorldGenerator(worldGen);   // Add this in your @Init method. If you haven't already, import cpw.mods.fml.common.registry.GameRegistry.      
    }
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method

	}
}