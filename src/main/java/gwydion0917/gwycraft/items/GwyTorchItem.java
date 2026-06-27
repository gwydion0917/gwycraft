package gwydion0917.gwycraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * Item for dyed torches. Places the floor TorchBlock when right-clicking the top of a block,
 * or the WallTorchBlock when right-clicking a wall face.
 * Replaces the 1.12 StandingAndWallBlockItem pattern (which used onItemUse).
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
    public ActionResultType useOn(ItemUseContext ctx) {
        Direction face = ctx.getClickedFace();
        Block toPlace;
        if (face == Direction.DOWN) {
            return ActionResultType.FAIL;
        } else if (face == Direction.UP) {
            toPlace = floorBlock;
        } else {
            toPlace = wallBlock;
        }

        BlockItemUseContext bCtx = new BlockItemUseContext(ctx);
        if (!bCtx.canPlace()) return ActionResultType.FAIL;

        BlockState state = toPlace.getStateForPlacement(bCtx);
        if (state == null) return ActionResultType.FAIL;

        World world = ctx.getLevel();
        if (!world.setBlock(bCtx.getClickedPos(), state, 11)) return ActionResultType.FAIL;

        net.minecraft.util.SoundEvent sound = state.getSoundType(world, bCtx.getClickedPos(), ctx.getPlayer()).getPlaceSound();
        world.playSound(null, bCtx.getClickedPos(), sound, SoundCategory.BLOCKS, 1.0F, 0.8F);

        if (!ctx.getPlayer().isCreative()) {
            ctx.getItemInHand().shrink(1);
        }
        return ActionResultType.sidedSuccess(world.isClientSide);
    }
}
