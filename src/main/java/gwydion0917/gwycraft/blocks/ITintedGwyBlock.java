package gwydion0917.gwycraft.blocks;

import net.minecraft.world.item.DyeColor;

/** Marker interface for all GwyCraft blocks that use tintindex-based coloring. */
public interface ITintedGwyBlock {
    DyeColor getDyeColor();
}
