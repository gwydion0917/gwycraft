package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class BlockDyedTorch extends BlockTorch {
	private String resourceName;

	public BlockDyedTorch(String resourceName) {
		super();
		this.setSoundType(SoundType.WOOD);
		this.resourceName = resourceName;
	}
}
