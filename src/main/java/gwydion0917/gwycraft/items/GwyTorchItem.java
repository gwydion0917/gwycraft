package gwydion0917.gwycraft.items;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Item for dyed torches. Places the floor TorchBlock when right-clicking the top of a block,
 * or the WallTorchBlock when right-clicking a wall face.
 * 1.20.1 renames: ItemUseContext→UseOnContext, BlockItemUseContext→BlockPlaceContext,
 * ActionResultType→InteractionResult, World→Level, SoundCategory→SoundSource.
 */
public class GwyTorchItem extends Item {
    private final Block floorBlock;
    private final Block wallBlock;

    public GwyTorchItem(Block floorBlock, Block wallBlock, Properties props) {
        super(props);
        this.floorBlock = floorBlock;
        this.wallBlock = wallBlock;
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Direction face = ctx.getClickedFace();
        Block toPlace;
        if (face == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else if (face == Direction.UP) {
            toPlace = floorBlock;
        } else {
            toPlace = wallBlock;
        }

        BlockPlaceContext bCtx = new BlockPlaceContext(ctx);
        if (!bCtx.canPlace()) return InteractionResult.FAIL;

        BlockState state = toPlace.getStateForPlacement(bCtx);
        if (state == null) return InteractionResult.FAIL;

        Level world = ctx.getLevel();
        if (!world.setBlock(bCtx.getClickedPos(), state, 11)) return InteractionResult.FAIL;

        net.minecraft.sounds.SoundEvent sound = state.getSoundType(world, bCtx.getClickedPos(), ctx.getPlayer()).getPlaceSound();
        world.playSound(null, bCtx.getClickedPos(), sound, SoundSource.BLOCKS, 1.0F, 0.8F);

        if (!ctx.getPlayer().isCreative()) {
            ctx.getItemInHand().shrink(1);
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }
}
