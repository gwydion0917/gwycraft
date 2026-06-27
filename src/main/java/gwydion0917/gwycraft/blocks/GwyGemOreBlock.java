package gwydion0917.gwycraft.blocks;

import net.minecraft.block.OreBlock;

/**
 * Enchanted gem ore block. Extends OreBlock which handles XP drops (3-7 XP).
 * Item drops are handled by loot tables (gem item with fortune, silk touch → block).
 * Replaces the 1.12 BlockGemOre (which was a single 16-metadata block).
 */
public class GwyGemOreBlock extends OreBlock {
    public GwyGemOreBlock(Properties props) {
        super(props);
    }
}
