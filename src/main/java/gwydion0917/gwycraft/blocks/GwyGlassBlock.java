package gwydion0917.gwycraft.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/**
 * Dyed glass block (transparent, cutout render layer). Replaces BlockDyedGlass.
 * Render layer (cutout) is set in ClientSetup via RenderTypeLookup.
 */
public class GwyGlassBlock extends AbstractGlassBlock {
    public GwyGlassBlock(Properties props) {
        super(props);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacent, Direction dir) {
        // Don't render shared faces between same-type glass blocks
        return adjacent.getBlock() instanceof GwyGlassBlock || super.skipRendering(state, adjacent, dir);
    }
}
