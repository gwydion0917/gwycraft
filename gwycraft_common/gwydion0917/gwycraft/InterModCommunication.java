package gwydion0917.gwycraft;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInterModComms;

public class InterModCommunication {

	public static void initIMC()
	{
		// Forestry
		// Digger
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.blockDyedStoneCobble.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.glowyblockDyedStoneCobble.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.blockDyedSand.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.glowyblockDyedSand.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.itemDyedClay.itemID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.itemDyedClayBricks.itemID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.itemDyedMud.itemID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "digger@" + Gwycraft.itemDyedMudBricks.itemID + ":*");
		
		// Builder
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyWool.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedStone.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedStone.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedClayblock.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedClayblock.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedGlass.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedGlass.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedMudBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedMudBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedStoneBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedStoneBrick.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedFences.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedFences.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.blockDyedCobbleWalls.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.glowyblockDyedCobbleWalls.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "builder@" + Gwycraft.itemDyedSticks.itemID + ":*");
		
		// Forester
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedLeaf.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedLeaf.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedLog1.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedLog2.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedLog3.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedLog4.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedLog1.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedLog2.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedLog3.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedLog4.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.blockDyedPlank.blockID + ":*");
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "forester@" + Gwycraft.glowyblockDyedPlank.blockID + ":*");
		
		// Miner
		FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "miner@" + Gwycraft.itemEnchantedGems.itemID + ":*");
		
		// End Forestry
		
		// Forge MultiPart
        // 16 Meta
        for (int i = 0; i < 16; i++) {
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyWool, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedStone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedStone, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedBookcase, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedBookcase, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedPlank, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedPlank, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedClayblock, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedClayblock, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedGlass, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedGlass, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedLeaf, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLeaf, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedMudBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedMudBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedSand, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedSand, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedStoneBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedStoneBrick, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedStoneCobble, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedStoneCobble, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockGemCompressed, 1, i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockGemOre, 1, i));
            }
        // 8 Meta
        for (int i = 0; i < 8; i++) {

            }

        // 4 Meta
        for (int i = 0; i < 4; i++) {

            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLog1,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLog2,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLog3,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLog4,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedLog1,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedLog2,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedLog3,1,i));
            FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.blockDyedLog4,1,i));
        }
	}
}
