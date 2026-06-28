package gwydion0917.gwycraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * A thin paver block (1/16 height) that breaks if the block below is removed.
 */
public class GwyPaverBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public GwyPaverBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos,
                                Block blockIn, BlockPos fromPos, boolean isMoving) {
        // getMaterial().isSolid() is gone — use isFaceSturdy on the supporting face instead
        if (!world.isClientSide && !world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP);
    }
}
