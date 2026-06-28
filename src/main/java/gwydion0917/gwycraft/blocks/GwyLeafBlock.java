package gwydion0917.gwycraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Dyed leaf block — non-opaque, uses cutout render layer.
 * Does NOT decay (unlike vanilla LeavesBlock).
 * Render layer (cutout_mipped) is set in ClientSetup via ItemBlockRenderTypes.
 */
public class GwyLeafBlock extends Block {

    public GwyLeafBlock(Properties props) {
        super(props);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext ctx) {
        return Shapes.empty();
    }
}
