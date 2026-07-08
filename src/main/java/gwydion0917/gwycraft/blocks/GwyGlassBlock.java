package gwydion0917.gwycraft.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Dyed glass block (transparent, cutout render layer).
 * Render layer (cutout) is set in ClientSetup via ItemBlockRenderTypes.
 */
public class GwyGlassBlock extends TransparentBlock {
    public GwyGlassBlock(Properties props) {
        super(props);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacent, Direction dir) {
        // Don't render shared faces between same-type glass blocks
        return adjacent.getBlock() instanceof GwyGlassBlock || super.skipRendering(state, adjacent, dir);
    }
}
