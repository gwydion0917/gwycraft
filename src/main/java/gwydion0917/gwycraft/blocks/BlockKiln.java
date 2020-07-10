package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockKiln extends Block {

	public BlockKiln() {
		super(Material.ROCK);
		this.setUnlocalizedName("kiln");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(0.5F);
		this.setResistance(6.0F);
		this.setSoundType(SoundType.STONE);
	}
}
