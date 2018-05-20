package gwydion0917.gwycraft.blocks;

import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.List;

import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

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
	
	public static List <MultiItem> blocks = new ArrayList<MultiItem>();

	public static void init() {
		createBlocks();
		registerBlocks();
	}

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> reg = event.getRegistry();

        // Wool
        blocks.add((MultiItem) (glowyWool = register(reg, new BlockGlowyWool(Material.CLOTH, "glowy_wool"))));

        // Stone
        blocks.add((MultiItem) (blockDyedStone = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_stone").setHardness(1.5F).setResistance(10.0F))));
        blocks.add((MultiItem) (glowyblockDyedStone = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_stone").setLightLevel(1F).setHardness(1.5F).setResistance(10.0F))));
        blocks.add((MultiItem) (blockDyedStonePaver = register(reg, new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_stone_paver").setHardness(2.0F))));

        // Bookshelves
        //blockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setHardness(1.5F).setUnlocalizedName("gwycraft.blockDyedBookcase").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setLightLevel(1F).setHardness(1.5F).setUnlocalizedName("gwycraft.glowyblockDyedBookcase").setCreativeTab(Gwycraft.tabs);

        // Brick
        blocks.add((MultiItem) (blockDyedBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_brick").setHardness(2F).setResistance(10F))));
        blocks.add((MultiItem) (glowyblockDyedBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_brick").setLightLevel(1F).setHardness(2F).setResistance(10F))));
        blocks.add((MultiItem) (blockDyedBrickPaver = register(reg, new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_brick_paver").setHardness(2.0F))));

        // Clay
        blocks.add((MultiItem) (blockDyedClayblock = register(reg, new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE, "dyed_clay").setHardness(0.6F))));
        blocks.add((MultiItem) (glowyblockDyedClayblock = register(reg, new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE, "glowy_dyed_clay").setLightLevel(1F).setHardness(0.6F))));

        // Glass
        //blockDyedGlass = new BlockDyedGlass().setHardness(0.6F).setUnlocalizedName("gwycraft.blockDyedGlass").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedGlass = new BlockDyedGlass().setLightLevel(1F).setHardness(0.6F).setUnlocalizedName("gwycraft.glowyblockDyedGlass").setCreativeTab(Gwycraft.tabs);

        // Leaf
        //blockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLeaf");
        //glowyblockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setLightLevel(1F).setUnlocalizedName("gwycraft.glowyblockDyedLeaf");

        // Mud Brick
        blocks.add((MultiItem) (blockDyedMudBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_mud_brick").setHardness(1.5f))));
        blocks.add((MultiItem) (glowyblockDyedMudBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_mud_brick").setLightLevel(1F).setHardness(1.5f))));
        blocks.add((MultiItem) (blockDyedMudBrickPaver = register(reg, new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_mud_brick_paver").setHardness(2.0F))));

        // Planks
        blocks.add((MultiItem) (blockDyedPlank = register(reg, new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD, "dyed_plank").setHardness(2.0F).setResistance(5.0F))));
        blocks.add((MultiItem) (glowyblockDyedPlank = register(reg, new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD, "glowy_dyed_plank").setLightLevel(1F).setHardness(2.0F).setResistance(5.0F))));
        //blockDyedFences = new BlockDyedFences("blockDyedFence", Material.WOOD).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.blockDyedFence").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedFences = new BlockDyedFences("glowyblockDyedFence", Material.WOOD).setLightLevel(1F).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.glowyblockDyedFence").setCreativeTab(Gwycraft.tabs);

        // Gravel
        //blockDyedGravel = new BlockDyedGravel().setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedGravel").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedGravel = new BlockDyedGravel().setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedGravel").setCreativeTab(Gwycraft.tabs);

        // Sand
        blocks.add((MultiItem) (blockDyedSand = register(reg, new BlockGwyColoredFalling(Material.SAND, SoundType.SAND, "dyed_sand").setHardness(0.5F))));
        blocks.add((MultiItem) (blockDyedSand = register(reg, new BlockGwyColoredFalling(Material.SAND, SoundType.SAND, "glowy_dyed_sand").setHardness(0.5F).setLightLevel(1F))));
        //blockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSandstone").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSandstone").setCreativeTab(Gwycraft.tabs);
        //blockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
        //blockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);
        //glowyblockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);

        // Stone Brick
        blocks.add((MultiItem) (blockDyedStoneBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_stone_brick").setHardness(2f))));
        blocks.add((MultiItem) (glowyblockDyedStoneBrick = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_stone_brick").setLightLevel(1F).setHardness(2f))));
        blocks.add((MultiItem) (blockDyedStoneBrickPaver = register(reg, new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_stone_brick_paver").setHardness(2.0F))));

        // Stone Cobble
        blocks.add((MultiItem) (blockDyedStoneCobble = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_cobblestone").setHardness(2.0F).setResistance(10.0F))));
        blocks.add((MultiItem) (glowyblockDyedStoneCobble = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_cobblestone").setLightLevel(1F).setHardness(2.0F))));
        blocks.add((MultiItem) (blockDyedCobbleWalls = register(reg, new BlockDyedCobbleWalls(Material.ROCK, SoundType.STONE, "dyed_cobblestone_wall").setHardness(2.0F).setResistance(10.0F))));
        blocks.add((MultiItem) (glowyblockDyedCobbleWalls = register(reg, new BlockDyedCobbleWalls(Material.ROCK, SoundType.STONE, "glowy_dyed_cobblestone_wall").setLightLevel(1F).setHardness(2.0F).setResistance(10.0F))));
        blocks.add((MultiItem) (blockDyedStoneCobblePaver = register(reg, new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_cobblestone_paver").setHardness(2.0F))));

        // Logs
        //blockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog1").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //blockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog2").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //blockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog3").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //blockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog4").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //glowyblockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog1").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //glowyblockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog2").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //glowyblockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog3").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
        //glowyblockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog4").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);

        // Gems
        blocks.add((MultiItem) (blockGemOre = register(reg, new BlockGemOre(Material.ROCK, "ore_gem"))));
        blocks.add((MultiItem) (blockGemCompressed = register(reg, new BlockGemCompressed(Material.ROCK, "compressed_gem"))));

        // Torches
        blocks.add((MultiItem) (blockWhiteDyedTorch = register(reg, new BlockDyedTorch("white"))));
        blocks.add((MultiItem) (blockOrangeDyedTorch = register(reg, new BlockDyedTorch("orange"))));
        blocks.add((MultiItem) (blockMagentaDyedTorch = register(reg, new BlockDyedTorch("magenta"))));
        blocks.add((MultiItem) (blockLBlueDyedTorch = register(reg, new BlockDyedTorch("light_blue"))));
        blocks.add((MultiItem) (blockYellowDyedTorch = register(reg, new BlockDyedTorch("yellow"))));
        blocks.add((MultiItem) (blockLGreenDyedTorch = register(reg, new BlockDyedTorch("lime"))));
        blocks.add((MultiItem) (blockPinkDyedTorch = register(reg, new BlockDyedTorch("pink"))));
        blocks.add((MultiItem) (blockDGrayDyedTorch = register(reg, new BlockDyedTorch("gray"))));
        blocks.add((MultiItem) (blockLGrayDyedTorch = register(reg, new BlockDyedTorch("light_gray"))));
        blocks.add((MultiItem) (blockCyanDyedTorch = register(reg, new BlockDyedTorch("cyan"))));
        blocks.add((MultiItem) (blockPurpleDyedTorch = register(reg, new BlockDyedTorch("purple"))));
        blocks.add((MultiItem) (blockBlueDyedTorch = register(reg, new BlockDyedTorch("blue"))));
        blocks.add((MultiItem) (blockBrownDyedTorch = register(reg, new BlockDyedTorch("brown"))));
        blocks.add((MultiItem) (blockGreenDyedTorch = register(reg, new BlockDyedTorch("green"))));
        blocks.add((MultiItem) (blockRedDyedTorch = register(reg, new BlockDyedTorch("red"))));
        blocks.add((MultiItem) (blockBlackDyedTorch = register(reg, new BlockDyedTorch("black"))));

        // Machines
        //blockDyeVat = new BlockDyeVat();
        //blockKiln = new BlockKiln();
        //blockTableSaw = new BlockTableSaw();
        //*/
    }

    public static Block register(IForgeRegistry<Block> reg, Block block) {
        reg.register(block);
        return block;
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

    }

	private static void createBlocks() {
		return;
		/*
		// Wool
		blocks.add((MultiItem) (glowyWool = new BlockGlowyWool(Material.CLOTH, "glowy_wool")));//;.setHardness(0.8F).setUnlocalizedName("gwycraft.glowyWool").setLightLevel(1f).setCreativeTab(Gwycraft.tabs);

		// Stone
		blocks.add((MultiItem) (blockDyedStone = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_stone").setHardness(1.5F).setResistance(10.0F)));
		blocks.add((MultiItem) (glowyblockDyedStone = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_stone").setLightLevel(1F).setHardness(1.5F).setResistance(10.0F)));
		blocks.add((MultiItem) (blockDyedStonePaver = new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_stone_paver").setHardness(2.0F)));

		// Bookshelves
		//blockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setHardness(1.5F).setUnlocalizedName("gwycraft.blockDyedBookcase").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedBookcase = (BlockBookshelf) new BlockDyedBookcase(Material.WOOD).setLightLevel(1F).setHardness(1.5F).setUnlocalizedName("gwycraft.glowyblockDyedBookcase").setCreativeTab(Gwycraft.tabs);

		// Brick
		blocks.add((MultiItem) (blockDyedBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_brick").setHardness(2F).setResistance(10F)));
		blocks.add((MultiItem) (glowyblockDyedBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_brick").setLightLevel(1F).setHardness(2F).setResistance(10F)));
		blocks.add((MultiItem) (blockDyedBrickPaver = new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_brick_paver").setHardness(2.0F)));
		
		// Clay
		blocks.add((MultiItem) (blockDyedClayblock = new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE, "dyed_clay").setHardness(0.6F)));
		blocks.add((MultiItem) (glowyblockDyedClayblock = new BlockGwyGenericBlock(Material.CLAY, SoundType.STONE, "glowy_dyed_clay").setLightLevel(1F).setHardness(0.6F)));

		// Glass
		//blockDyedGlass = new BlockDyedGlass().setHardness(0.6F).setUnlocalizedName("gwycraft.blockDyedGlass").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedGlass = new BlockDyedGlass().setLightLevel(1F).setHardness(0.6F).setUnlocalizedName("gwycraft.glowyblockDyedGlass").setCreativeTab(Gwycraft.tabs);

		// Leaf
		//blockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLeaf");
		//glowyblockDyedLeaf = new BlockDyedLeaf().setCreativeTab(Gwycraft.tabs).setLightLevel(1F).setUnlocalizedName("gwycraft.glowyblockDyedLeaf");

		// Mud Brick
		blocks.add((MultiItem) (blockDyedMudBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_mud_brick").setHardness(1.5f)));
		blocks.add((MultiItem) (glowyblockDyedMudBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_mud_brick").setLightLevel(1F).setHardness(1.5f)));
		blocks.add((MultiItem) (blockDyedMudBrickPaver = new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_mud_brick_paver").setHardness(2.0F)));
		
		// Planks
		blocks.add((MultiItem) (blockDyedPlank = new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD, "dyed_plank").setHardness(2.0F).setResistance(5.0F)));
		blocks.add((MultiItem) (glowyblockDyedPlank = new BlockGwyGenericBlock(Material.WOOD, SoundType.WOOD, "glowy_dyed_plank").setLightLevel(1F).setHardness(2.0F).setResistance(5.0F)));
		//blockDyedFences = new BlockDyedFences("blockDyedFence", Material.WOOD).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.blockDyedFence").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedFences = new BlockDyedFences("glowyblockDyedFence", Material.WOOD).setLightLevel(1F).setHardness(2.0F).setResistance(5.0F).setUnlocalizedName("gwycraft.glowyblockDyedFence").setCreativeTab(Gwycraft.tabs);

		// Gravel
		//blockDyedGravel = new BlockDyedGravel().setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedGravel").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedGravel = new BlockDyedGravel().setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedGravel").setCreativeTab(Gwycraft.tabs);

		// Sand
		blocks.add((MultiItem) (blockDyedSand = new BlockGwyColoredFalling(Material.SAND, SoundType.SAND, "dyed_sand").setHardness(0.5F)));
		blocks.add((MultiItem) (blockDyedSand = new BlockGwyColoredFalling(Material.SAND, SoundType.SAND, "glowy_dyed_sand").setHardness(0.5F).setLightLevel(1F)));
		//blockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSandstone").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedSandstone = new BlockDyedSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSandstone").setCreativeTab(Gwycraft.tabs);
		//blockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedSmoothSandstone = new BlockDyedSmoothSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedSmoothSandstone").setCreativeTab(Gwycraft.tabs);
		//blockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setHardness(0.5F).setUnlocalizedName("gwycraft.blockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);
		//glowyblockDyedChiseledSandstone = new BlockDyedChiseledSandstone(Material.ROCK).setLightLevel(1F).setHardness(0.5F).setUnlocalizedName("gwycraft.glowyblockDyedChiseledSandstone").setCreativeTab(Gwycraft.tabs);

		// Stone Brick
		blocks.add((MultiItem) (blockDyedStoneBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_stone_brick").setHardness(2f)));
		blocks.add((MultiItem) (glowyblockDyedStoneBrick = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_stone_brick").setLightLevel(1F).setHardness(2f)));
		blocks.add((MultiItem) (blockDyedStoneBrickPaver = new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_stone_brick_paver").setHardness(2.0F)));
		
		// Stone Cobble
		blocks.add((MultiItem) (blockDyedStoneCobble = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_cobblestone").setHardness(2.0F).setResistance(10.0F)));
		blocks.add((MultiItem) (glowyblockDyedStoneCobble = new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "glowy_dyed_cobblestone").setLightLevel(1F).setHardness(2.0F)));
		blocks.add((MultiItem) (blockDyedCobbleWalls = new BlockDyedCobbleWalls(Material.ROCK, SoundType.STONE, "dyed_cobblestone_wall").setHardness(2.0F).setResistance(10.0F)));
		blocks.add((MultiItem) (glowyblockDyedCobbleWalls = new BlockDyedCobbleWalls(Material.ROCK, SoundType.STONE, "glowy_dyed_cobblestone_wall").setLightLevel(1F).setHardness(2.0F).setResistance(10.0F)));
		blocks.add((MultiItem) (blockDyedStoneCobblePaver = new BlockGwyGenericPaver(Material.ROCK, SoundType.STONE, "dyed_cobblestone_paver").setHardness(2.0F)));
		
		// Logs
		//blockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog1").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//blockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog2").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//blockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog3").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//blockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.blockDyedLog4").setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//glowyblockDyedLog1 = new BlockDyedLog1().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog1").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//glowyblockDyedLog2 = new BlockDyedLog2().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog2").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//glowyblockDyedLog3 = new BlockDyedLog3().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog3").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);
		//glowyblockDyedLog4 = new BlockDyedLog4().setCreativeTab(Gwycraft.tabs).setUnlocalizedName("gwycraft.glowyblockDyedLog4").setLightLevel(1F).setCreativeTab(Gwycraft.tabs).setHardness(2.0F);

		// Gems
		blocks.add((MultiItem) (blockGemOre = new BlockGemOre(Material.ROCK, "ore_gem")));
		blocks.add((MultiItem) (blockGemCompressed = new BlockGemCompressed(Material.ROCK, "compressed_gem")));
		
		// Torches
		blocks.add((MultiItem) (blockWhiteDyedTorch = new BlockDyedTorch("white")));
		blocks.add((MultiItem) (blockOrangeDyedTorch = new BlockDyedTorch("orange")));
		blocks.add((MultiItem) (blockMagentaDyedTorch = new BlockDyedTorch("magenta")));
		blocks.add((MultiItem) (blockLBlueDyedTorch = new BlockDyedTorch("light_blue")));
		blocks.add((MultiItem) (blockYellowDyedTorch = new BlockDyedTorch("yellow")));
		blocks.add((MultiItem) (blockLGreenDyedTorch = new BlockDyedTorch("lime")));
		blocks.add((MultiItem) (blockPinkDyedTorch = new BlockDyedTorch("pink")));
		blocks.add((MultiItem) (blockDGrayDyedTorch = new BlockDyedTorch("gray")));
		blocks.add((MultiItem) (blockLGrayDyedTorch = new BlockDyedTorch("light_gray")));
		blocks.add((MultiItem) (blockCyanDyedTorch = new BlockDyedTorch("cyan")));
		blocks.add((MultiItem) (blockPurpleDyedTorch = new BlockDyedTorch("purple")));
		blocks.add((MultiItem) (blockBlueDyedTorch = new BlockDyedTorch("blue")));
		blocks.add((MultiItem) (blockBrownDyedTorch = new BlockDyedTorch("brown")));
		blocks.add((MultiItem) (blockGreenDyedTorch = new BlockDyedTorch("green")));
		blocks.add((MultiItem) (blockRedDyedTorch = new BlockDyedTorch("red")));
		blocks.add((MultiItem) (blockBlackDyedTorch = new BlockDyedTorch("black")));

		// Machines
		//blockDyeVat = new BlockDyeVat();
		//blockKiln = new BlockKiln();
		//blockTableSaw = new BlockTableSaw();
		//*/
	}

	private static void registerBlocks() {
		// Machines
		//GameRegistry.registerBlock(blockDyeVat, "blockDyeVat");
		//GameRegistry.registerBlock(blockKiln, "blockKiln");
		//GameRegistry.registerBlock(blockTableSaw, "blockTableSaw");
	}

	public static void registerRenders() {
		for(MultiItem block : blocks) {
			block.registerBlockRenders();
		}
	}

    public static void registerItems(RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> reg = event.getRegistry();


        for(MultiItem block : blocks) {
            block.registerItems(reg);
        }

        //reg.register((new ItemCloth(blockDyedStone)).setUnlocalizedName(blockDyedStone.getUnlocalizedName()).setRegistryName(blockDyedStone.getRegistryName()));

        /*
        reg.register((new ItemMultiTexture(blockDyedStone, blockDyedStone, new ItemMultiTexture.Mapper() {
            public String apply(ItemStack stack) {
                return EnumDyeColor.byMetadata(stack.getItemDamage()).getUnlocalizedName();
            }
        })).setUnlocalizedName(blockDyedStone.getUnlocalizedName()).setRegistryName(blockDyedStone.getRegistryName()));
        //*/
    }
}
