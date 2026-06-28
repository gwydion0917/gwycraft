package gwydion0917.gwycraft.blocks;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SlabBlock;

/** A slab block colored via tintindex. Drops 2 items when broken as a double slab. */
public class GwyTintedSlabBlock extends SlabBlock implements ITintedGwyBlock {

    private final DyeColor dyeColor;

    public GwyTintedSlabBlock(DyeColor dyeColor, Properties props) {
        super(props);
        this.dyeColor = dyeColor;
    }

    @Override
    public DyeColor getDyeColor() {
        return dyeColor;
    }
}
