package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedGravel extends BlockGravel {
	public BlockDyedGravel() {
		super();
		this.setUnlocalizedName("dyedGravel");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.GROUND);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
}
