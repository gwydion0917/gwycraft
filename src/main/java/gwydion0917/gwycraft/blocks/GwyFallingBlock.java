package gwydion0917.gwycraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * Colored falling block (sand, glowy sand). Extends vanilla FallingBlock.
 * 1.20.3+: FallingBlock is abstract over codec(), so a simple codec is required.
 */
public class GwyFallingBlock extends FallingBlock {

    public static final MapCodec<GwyFallingBlock> CODEC = simpleCodec(GwyFallingBlock::new);

    public GwyFallingBlock(Properties props) {
        super(props);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

    @Override
    public MapColor defaultMapColor() {
        return MapColor.SAND;
    }
}
