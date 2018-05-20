package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedSandstone extends Block {
	public BlockDyedSandstone(Material mat) {
		super(mat);
		this.setSoundType(SoundType.STONE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> par3List) {
		for (int j = 0; j < 16; ++j) {
			par3List.add(new ItemStack(this, 1, j));
		}
	}
}
