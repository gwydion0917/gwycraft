package gwydion0917.gwycraft.interfaces;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public interface MultiItem {
    public void registerBlockRenders();
    public void registerItems(IForgeRegistry<Item> reg);
}
