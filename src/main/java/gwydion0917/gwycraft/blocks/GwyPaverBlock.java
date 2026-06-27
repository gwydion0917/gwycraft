package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * A thin paver block (1/16 height) that breaks if the block below is removed.
 * Replaces the 1.12 BlockGwyGenericPaver.
 */
public class GwyPaverBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public GwyPaverBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext ctx) {
        return SHAPE;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos,
                                Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!world.isClientSide && !world.getBlockState(pos.below()).getMaterial().isSolid()) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).getMaterial().isSolid();
    }
}
