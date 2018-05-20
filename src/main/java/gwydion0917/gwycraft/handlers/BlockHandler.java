package gwydion0917.gwycraft.handlers;

import gwydion0917.gwycraft.blocks.BlockDyedBookcase;
import gwydion0917.gwycraft.blocks.BlockGwyGenericBlock;
import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockHandler {

    public static void init(RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> reg = event.getRegistry();

        GwycraftBlocks.blockDyedStone = register(reg, new BlockGwyGenericBlock(Material.ROCK, SoundType.STONE, "dyed_stone").setHardness(1.5F).setResistance(10.0F));
    }

    public static Block register(IForgeRegistry<Block> reg, Block block) {
        reg.register(block);
        return block;
    }
}
