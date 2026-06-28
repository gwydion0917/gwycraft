package gwydion0917.gwycraft.blocks;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

/**
 * A plain cube block whose color comes from a client-side tint (tintindex 0 on all faces)
 * rather than per-color textures. All 16 color variants share one block model.
 */
public class GwyTintedBlock extends Block implements ITintedGwyBlock {

    private final DyeColor dyeColor;

    public GwyTintedBlock(DyeColor dyeColor, Properties props) {
        super(props);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return dyeColor;
    }
}
