package gwydion0917.gwycraft;

import net.minecraftforge.fml.common.registry.GameRegistry;
import gwydion0917.gwycraft.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class GwycraftBlocks {
	public static Block glowyWool;
	public static Block blockDyedStone;
	public static Block glowyblockDyedStone;
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
	public static Block blockDyedMudBrickPaver;
	public static Block blockDyedPlank;
	public static Block glowyblockDyedPlank;
	public static Block blockDyedGravel;
	public static Block glowyblockDyedGravel;
	public static Block blockDyedSand;
	public static Block glowyblockDyedSand;
	public static Block blockDyedSandstone;
	public static Block blockDyedChiseledSandstone;
	public static Block blockDyedSmoothSandstone;
	public static Block glowyblockDyedSandstone;
	public static Block glowyblockDyedChiseledSandstone;
	public static Block glowyblockDyedSmoothSandstone;
	public static Block blockDyedStoneBrick;
	public static Block glowyblockDyedStoneBrick;
	public static Block blockDyedStoneCobble;
	public static Block glowyblockDyedStoneCobble;
	public static Block blockDyedStoneCobblePaver;
	public static Block blockGemOre;
	public static Block blockGemCompressed;
	public static Block blockDyedStonePaver;
	public static Block blockDyedBrickPaver;
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
	public static Block blockDyeVat;
	public static Block blockTableSaw;
	public static Block blockKiln;

	public static void init() {
		createBlocks();
		registerBlocks();
	}

	private static void createBlocks() {
		// Wool
		glowyWool = new BlockGlowyWool(Material.CLOTH).setHardness(0.8F).setUnlocalizedName("gwycraft.glowyWool").setLightLevel(1f).setCreativeTab(Gwycraft.tabs);

		// Stone
		blockDyedStone = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("gwycraft.blockDyedStone").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedStone = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("gwycraft.glowyblockDyedStone").setCreativeTab(Gwycraft.tabs);
		blockDyedStonePaver = new BlockGwyGenericPaver().setUnlocalizedName("gwycraft.blockDyedStonePaver").setHardness(2.0F).setCreativeTab(Gwycraft.tabs);

		// Bookshelves
		blockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setHardness(1.5F).setUnlocalizedName("gwycraft.blockDyedBookcase").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setLightLevel(1F).setHardness(1.5F).setUnlocalizedName("gwycraft.glowyblockDyedBookcase").setCreativeTab(Gwycraft.tabs);

		// Brick
		blockDyedBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setHardness(2F).setResistance(10F).setUnlocalizedName("gwycraft.blockDyedBrick").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(2F).setResistance(10F).setUnlocalizedName("gwycraft.glowyblockDyedBrick").setCreativeTab(Gwycraft.tabs);
		blockDyedBrickPaver = new BlockGwyGenericPaver().setUnlocalizedName("gwycraft.blockDyedBrickPaver").setHardness(2.0F).setCreativeTab(Gwycraft.tabs);

		// Clay
		blockDyedClayblock = new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE).setHardness(0.6F).setUnlocalizedName("gwycraft.blockDyedClayblock").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedClayblock = new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE).setLightLevel(1F).setHardness(0.6F).setUnlocalizedName("gwycraft.glowyblockDyedClayblock").setCreativeTab(Gwycraft.tabs);

		// Glass
		blockDyedGlass = new BlockDyedGlass().setHardness(0.6F).setUnlocalizedName("gwycraft.blockDyedGlass").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedGlass = new BlockDyedGlass().setLightLevel(1F).setHardness(0.6F).setUnlocalizedName("gwycraft.glowyblockDyedGlass").setCreativeTab(Gwycraft.tabs);

		// Leaf
		blockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLeaf");
		glowyblockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setLightLevel(1F).setUnlocalizedName("gwycraft.glowyblockDyedLeaf");

		// Mud Brick
		blockDyedMudBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setHardness(1.5f).setUnlocalizedName("gwycraft.blockDyedMudBrick").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedMudBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(1.5f).setUnlocalizedName("gwycraft.glowyblockDyedMudBrick").setCreativeTab(Gwycraft.tabs);
		blockDyedMudBrickPaver = new BlockGwyGenericPaver().setUnlocalizedName("gwycraft.blockDyedMudBrickPaver").setHardness(2.0F).setCreativeTab(Gwycraft.tabs);

		// Planks
		blockDyedPlank = new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.blockDyedPlank").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedPlank = new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD).setLightLevel(1F).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.glowyblockDyedPlank").setCreativeTab(Gwycraft.tabs);
		blockDyedFences = new BlockDyedFences("blockDyedFence", Material.WOOD).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.blockDyedFence").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedFences = new BlockDyedFences("glowyblockDyedFence", Material.WOOD).setLightLevel(1F).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.glowyblockDyedFence").setCreativeTab(Gwycraft.tabs);

		// Gravel
		blockDyedGravel = new BlockDyedGravel().setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedGravel").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedGravel = new BlockDyedGravel().setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedGravel").setCreativeTab(Gwycraft.tabs);

		// Sand
		blockDyedSand = new BlockDyedSand().setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSand").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedSand = new BlockDyedSand().setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSand").setCreativeTab(Gwycraft.tabs);
		blockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSandstone").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSandstone").setCreativeTab(Gwycraft.tabs);
		blockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
		blockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);

		// Stone Brick
		blockDyedStoneBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(2f).setUnlocalizedName("gwycraft.blockDyedStoneBrick").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedStoneBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(2f).setUnlocalizedName("gwycraft.glowyblockDyedStoneBrick").setCreativeTab(Gwycraft.tabs);
		blockDyedStoneBrickPaver = new BlockGwyGenericPaver().setUnlocalizedName("gwycraft.blockDyedStoneBrickPaver").setHardness(2.0F).setCreativeTab(Gwycraft.tabs);

		// Stone Cobble
		blockDyedStoneCobble = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("gwycraft.blockDyedStoneCobble").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedStoneCobble = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE).setLightLevel(1F).setHardness(2.0F).setUnlocalizedName("gwycraft.glowyblockDyedStoneCobble").setCreativeTab(Gwycraft.tabs);
		blockDyedCobbleWalls = new BlockDyedCobbleWalls(blockDyedStoneCobble).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("gwycraft.blockDyedCobbleWalls").setCreativeTab(Gwycraft.tabs);
		glowyblockDyedCobbleWalls = new BlockDyedCobbleWalls(blockDyedStoneCobble).setLightLevel(1F).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("gwycraft.glowyblockDyedCobbleWalls").setCreativeTab(Gwycraft.tabs);
		blockDyedStoneCobblePaver = new BlockGwyGenericPaver().setUnlocalizedName("gwycraft.blockDyedStonePaver").setHardness(2.0F).setCreativeTab(Gwycraft.tabs);

		// Logs
		blockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog1").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		blockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog2").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		blockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog3").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		blockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog4").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		glowyblockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog1").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		glowyblockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog2").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		glowyblockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog3").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		glowyblockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog4").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);

		// Gems
		blockGemOre = new BlockGemOre(Material.ROCK).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("gemOre").setCreativeTab(Gwycraft.tabs);
		blockGemCompressed = new BlockGemCompressed(Material.ROCK).setLightLevel(1F).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("blockGemCompressed").setCreativeTab(Gwycraft.tabs);

		// Torches
		blockWhiteDyedTorch = new BlockDyedTorch("torch_white").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.white").setCreativeTab(Gwycraft.tabs);
		blockOrangeDyedTorch = new BlockDyedTorch("torch_orange").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.orange").setCreativeTab(Gwycraft.tabs);
		blockMagentaDyedTorch = new BlockDyedTorch("torch_magenta").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.magenta").setCreativeTab(Gwycraft.tabs);
		blockLBlueDyedTorch = new BlockDyedTorch("torch_lblue").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.lblue").setCreativeTab(Gwycraft.tabs);
		blockYellowDyedTorch = new BlockDyedTorch("torch_yellow").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.yellow").setCreativeTab(Gwycraft.tabs);
		blockLGreenDyedTorch = new BlockDyedTorch("torch_lgreen").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.lgreen").setCreativeTab(Gwycraft.tabs);
		blockPinkDyedTorch = new BlockDyedTorch("torch_pink").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.pink").setCreativeTab(Gwycraft.tabs);
		blockDGrayDyedTorch = new BlockDyedTorch("torch_dgray").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.dgray").setCreativeTab(Gwycraft.tabs);
		blockLGrayDyedTorch = new BlockDyedTorch("torch_lgray").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.lgray").setCreativeTab(Gwycraft.tabs);
		blockCyanDyedTorch = new BlockDyedTorch("torch_cyan").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.cyan").setCreativeTab(Gwycraft.tabs);
		blockPurpleDyedTorch = new BlockDyedTorch("torch_purple").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.purple").setCreativeTab(Gwycraft.tabs);
		blockBlueDyedTorch = new BlockDyedTorch("torch_blue").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.blue").setCreativeTab(Gwycraft.tabs);
		blockBrownDyedTorch = new BlockDyedTorch("torch_brown").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.brown").setCreativeTab(Gwycraft.tabs);
		blockGreenDyedTorch = new BlockDyedTorch("torch_green").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.green").setCreativeTab(Gwycraft.tabs);
		blockRedDyedTorch = new BlockDyedTorch("torch_red").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.red").setCreativeTab(Gwycraft.tabs);
		blockBlackDyedTorch = new BlockDyedTorch("torch_black").setHardness(0.0F).setLightLevel(0.9375F).setUnlocalizedName("gwycraft.torch.black").setCreativeTab(Gwycraft.tabs);

		// Machines
		blockDyeVat = new BlockDyeVat();
		blockKiln = new BlockKiln();
		blockTableSaw = new BlockTableSaw();
	}

	private static void registerBlocks() {
		// Wool
		GameRegistry.registerBlock(glowyWool, ItemGlowyWool.class, "glowyWool");

		// Stone
		GameRegistry.registerBlock(blockDyedStone, ItemGwyGeneric.class, "blockDyedStone");
		GameRegistry.registerBlock(glowyblockDyedStone, ItemGwyGeneric.class, "glowyblockDyedStone");
		GameRegistry.registerBlock(blockDyedStonePaver, ItemGwyGeneric.class, "blockDyedStonePaver");

		// Bookshelves
		GameRegistry.registerBlock(blockDyedBookcase, ItemDyedBookshelf.class, "blockDyedBookcase");
		GameRegistry.registerBlock(glowyblockDyedBookcase, ItemDyedBookshelf.class, "glowyblockDyedBookcase");

		// Brick
		GameRegistry.registerBlock(blockDyedBrick, ItemGwyGeneric.class, "blockDyedBrick");
		GameRegistry.registerBlock(glowyblockDyedBrick, ItemGwyGeneric.class, "glowyblockDyedBrick");
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

		// Planks
		GameRegistry.registerBlock(blockDyedPlank, ItemDyedPlank.class, "blockDyedPlank");
		GameRegistry.registerBlock(glowyblockDyedPlank, ItemGwyGeneric.class, "glowyblockDyedPlank");
		GameRegistry.registerBlock(blockDyedFences, ItemDyedFences.class, "blockDyedFences");
		GameRegistry.registerBlock(glowyblockDyedFences, ItemDyedFences.class, "glowyblockDyedFences");

		// Sand
		GameRegistry.registerBlock(blockDyedSand, ItemGwyGeneric.class, "blockDyedSand");
		GameRegistry.registerBlock(glowyblockDyedSand, ItemGwyGeneric.class, "glowyblockDyedSand");
		GameRegistry.registerBlock(blockDyedSandstone, ItemGwyGeneric.class, "blockDyedSandstone");
		GameRegistry.registerBlock(glowyblockDyedSandstone, ItemGwyGeneric.class, "glowyblockDyedSandstone");
		GameRegistry.registerBlock(blockDyedSmoothSandstone, ItemGwyGeneric.class, "blockDyedSmoothSandstone");
		GameRegistry.registerBlock(glowyblockDyedSmoothSandstone, ItemGwyGeneric.class, "glowyblockDyedSmoothSandstone");
		GameRegistry.registerBlock(blockDyedChiseledSandstone, ItemGwyGeneric.class, "blockDyedChiseledSandstone");
		GameRegistry.registerBlock(glowyblockDyedChiseledSandstone, ItemGwyGeneric.class, "glowyblockDyedChiseledSandstone");

		// Stone Brick
		GameRegistry.registerBlock(blockDyedStoneBrick, ItemGwyGeneric.class, "blockDyedStoneBrick");
		GameRegistry.registerBlock(glowyblockDyedStoneBrick, ItemGwyGeneric.class, "glowyblockDyedStoneBrick");
		GameRegistry.registerBlock(blockDyedStoneBrickPaver, ItemGwyGeneric.class, "blockDyedStoneBrickPaver");

		// Stone Cobble
		GameRegistry.registerBlock(blockDyedStoneCobble, ItemGwyGeneric.class, "blockDyedStoneCobble");
		GameRegistry.registerBlock(glowyblockDyedStoneCobble, ItemGwyGeneric.class, "glowyblockDyedStoneCobble");
		GameRegistry.registerBlock(blockDyedCobbleWalls, ItemDyedCobbleWalls.class, "blockDyedCobbleWalls");
		GameRegistry.registerBlock(glowyblockDyedCobbleWalls, ItemDyedCobbleWalls.class, "glowyblockDyedCobbleWalls");
		GameRegistry.registerBlock(blockDyedStoneCobblePaver, ItemGwyGeneric.class, "blockDyedStoneCobblePaver");

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

		// Machines
		GameRegistry.registerBlock(blockDyeVat, "blockDyeVat");
		GameRegistry.registerBlock(blockKiln, "blockKiln");
		GameRegistry.registerBlock(blockTableSaw, "blockTableSaw");
	}

}
