package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedBookcase extends BlockBookshelf {

	public BlockDyedBookcase(Material wood) {
		super();
		this.setSoundType(SoundType.WOOD);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		for (int j = 0; j < 16; ++j) {
			subItems.add(new ItemStack(this, 1, j));
		}
	}
	
	/**
	 * Determines the amount of enchanting power this block can provide to an
	 * enchanting table.
	 * 
	 * @param world
	 *            The World
	 * @param x
	 *            X position
	 * @param y
	 *            Y position
	 * @param z
	 *            Z position
	 * @return The amount of enchanting power this block produces.
	 */
	//@Override
	//public float getEnchantPowerBonus(World world, int x, int y, int z) {
	//	return 1f;
	//}
}
