package gwydion0917.gwycraft.blocks;

import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.material.MapColor;

/**
 * Colored falling block (sand, glowy sand). Extends vanilla FallingBlock.
 */
public class GwyFallingBlock extends FallingBlock {
    public GwyFallingBlock(Properties props) {
        super(props);
    }

    @Override
    public MapColor defaultMapColor() {
        return MapColor.SAND;
    }
}
