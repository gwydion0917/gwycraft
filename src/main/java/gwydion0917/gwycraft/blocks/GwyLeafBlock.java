package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/**
 * Dyed leaf block — non-opaque, uses cutout render layer.
 * Does NOT decay (unlike vanilla LeavesBlock). Replaces BlockDyedLeaf.
 * Render layer (cutout_mipped) is set in ClientSetup via RenderTypeLookup.
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
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext ctx) {
        return VoxelShapes.empty();
    }
}
