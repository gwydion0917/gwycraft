package gwydion0917.gwycraft.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemHandler {
    public static void init(RegistryEvent.Register<Item> event) {


        //
    }

    public static void register(IForgeRegistry<Item> reg, Item item) {
        reg.register(item);
    }
    public static void register(IForgeRegistry<Item> reg, Block block) {
        register(reg, new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
