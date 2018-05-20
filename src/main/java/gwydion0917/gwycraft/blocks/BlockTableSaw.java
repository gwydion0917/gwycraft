package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTableSaw extends Block {

	public BlockTableSaw() {
		super(Material.ROCK);
		this.setUnlocalizedName("tableSaw");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setHardness(0.5F);
		setResistance(6.0F);
		this.setSoundType(SoundType.STONE);
	}
}
