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
		FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", new ItemStack(Gwycraft.glowyblockDyedLog1));

	}
}
