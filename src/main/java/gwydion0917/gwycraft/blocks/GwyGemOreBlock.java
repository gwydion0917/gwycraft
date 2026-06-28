package gwydion0917.gwycraft.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;

/**
 * Enchanted gem ore block. Extends DropExperienceBlock (replaces OreBlock, removed in 1.17).
 * XP range 3-7 matches original OreBlock behaviour.
 * Item drops are handled by loot tables (gem item with fortune, silk touch → block).
 */
public class GwyGemOreBlock extends DropExperienceBlock {
    public GwyGemOreBlock(Properties props) {
        super(props, UniformInt.of(3, 7));
    }
}
