package gwydion0917.gwycraft;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

public class InterModCommunication {

	public static void initIMC()
	{
		Loader.instance();
		if (Loader.isModLoaded("Forestry"))
			imcForestry();
		
		if (Loader.isModLoaded("ForgeMicroblock"))
			imcFMP();
		
	}
	
	public static void imcForestry(){
		// Forestry Backpack support
		// Digger
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftBlocks.blockDyedStoneCobble + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftBlocks.glowyblockDyedStoneCobble + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftBlocks.blockDyedSand + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftBlocks.glowyblockDyedSand + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftItems.itemDyedClay + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftItems.itemDyedClayBricks + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftItems.itemDyedMud + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + GwycraftItems.itemDyedMudBricks + ":*");
		
		// Builder
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyWool + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedStone + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedStone + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedClayblock + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedClayblock + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedGlass + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedGlass + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedMudBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedMudBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedStoneBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedStoneBrick + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedFences + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedFences + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedCobbleWalls + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedCobbleWalls + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftItems.itemDyedSticks + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.blockDyedSandstone + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + GwycraftBlocks.glowyblockDyedSandstone + ":*");
		
		// Forester
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedLeaf + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedLeaf + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedLog1 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedLog2 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedLog3 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedLog4 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedLog1 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedLog2 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedLog3 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedLog4 + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.blockDyedPlank + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + GwycraftBlocks.glowyblockDyedPlank + ":*");
		
		// Miner
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "miner@" + GwycraftItems.itemEnchantedGems + ":*");

	}
	
	public static void imcFMP(){
		// Forge MicroBlock support
        // 16 Meta
        for (int i = 0; i < 16; i++) {
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyWool, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedStone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedStone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedBookcase, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedBookcase, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedPlank, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedPlank, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedClayblock, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedClayblock, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedGlass, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedGlass, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedLeaf, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedLeaf, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedMudBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedMudBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedSand, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedSand, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedSandstone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedSandstone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedStoneBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedStoneBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedStoneCobble, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedStoneCobble, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockGemCompressed, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockGemOre, 1, i));
            }
        // 8 Meta
        for (int i = 0; i < 8; i++) {

            }

        // 4 Meta
        for (int i = 0; i < 4; i++) {

            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedLog1,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedLog2,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedLog3,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.glowyblockDyedLog4,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedLog1,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedLog2,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedLog3,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(GwycraftBlocks.blockDyedLog4,1,i));
        }
		
	}
	
}
