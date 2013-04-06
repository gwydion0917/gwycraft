package gwydion0917.gwycraft;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import java.util.logging.Level;

import gwydion0917.gwycraft.CommonProxy;
import gwydion0917.gwycraft.ConfigGwycraft;
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
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.BlockCloth;
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
//      dyedMudbrickStairs = new DyedMudbrickStairs(dyedMudbrickStairsID);
        dyedLog1 = new DyedLog1(ConfigGwycraft.dyedLog1ID);
        dyedLog2 = new DyedLog2(ConfigGwycraft.dyedLog2ID);
        dyedLog3 = new DyedLog3(ConfigGwycraft.dyedLog3ID);
        dyedLog4 = new DyedLog4(ConfigGwycraft.dyedLog4ID);

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
            GameRegistry.addRecipe(glowyWoolStack, " x ", "xyx", " x ", 'y', cloth, 'x', gsDust);
            GameRegistry.addShapelessRecipe(glowyWoolStack, new ItemStack(Block.glowStone), cloth);
        }
        
        // 8 Meta
        for (int i = 0; i < 8; i++) {
        ItemStack dyedStoneSlab1Stack = new ItemStack(dyedStoneSlab1, 1, i);
        ItemStack dyedStoneSlab2Stack = new ItemStack(dyedStoneSlab2, 1, i);
        LanguageRegistry.addName(dyedStoneSlab1Stack, gwyColorSlab1Names[dyedStoneSlab1Stack.getItemDamage()] + " Stone Slab");
        LanguageRegistry.addName(dyedStoneSlab2Stack, gwyColorSlab2Names[dyedStoneSlab2Stack.getItemDamage()] + " Stone Slab");
	}        
   
        // 4 Meta
        for (int i = 0; i < 4; i++) {
            ItemStack dyedLog1Stack = new ItemStack(dyedLog1, 1, i);
            ItemStack dyedLog2Stack = new ItemStack(dyedLog2, 1, i);
            ItemStack dyedLog3Stack = new ItemStack(dyedLog3, 1, i);
            ItemStack dyedLog4Stack = new ItemStack(dyedLog4, 1, i);

            LanguageRegistry.addName(dyedLog1Stack, gwyColorLog1Names[dyedLog1Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog2Stack, gwyColorLog2Names[dyedLog2Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog3Stack, gwyColorLog3Names[dyedLog3Stack.getItemDamage()] + " Log");
            LanguageRegistry.addName(dyedLog4Stack, gwyColorLog4Names[dyedLog4Stack.getItemDamage()] + " Log");
        }
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}