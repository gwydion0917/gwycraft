package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedChiseledSandstone extends Block {

	public BlockDyedChiseledSandstone(Material mat) {
		super(mat);
		this.setSoundType(SoundType.STONE);
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int j = 0; j < 16; ++j) {
			par3List.add(new ItemStack(this, 1, j));
		}
	}
}
