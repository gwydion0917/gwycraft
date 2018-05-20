package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedLog3 extends BlockLog {
	/** The type of tree this log came from. */
	public static final String[] woodType = new String[] { "light gray", "cyan", "purple", "blue" };
	public static final String[] treeTextureTypes = new String[] { "gwycraft:logside_8", "gwycraft:logside_9", "gwycraft:logside_10", "gwycraft:logside_11" };
	public static final String[] treeTopTextureTypes = new String[] { "gwycraft:logtop_8", "gwycraft:logtop_9", "gwycraft:logtop_10", "gwycraft:logtop_11" };

	public BlockDyedLog3() {
		super();
		this.setSoundType(SoundType.WOOD);

	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	/*
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;

		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}

		return j1 | b0;
	}
	*/

	/**
	 * returns a number between 0 and 3
	 */
	public static int limitToValidMetadata(int par0) {
		return par0 & 3;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		subItems.add(new ItemStack(this, 1, 0));
		subItems.add(new ItemStack(this, 1, 1));
		subItems.add(new ItemStack(this, 1, 2));
		subItems.add(new ItemStack(this, 1, 3));
	}

	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
	/*
	 * @Override protected ItemStack createStackedBlock(int par1) { return new
	 * ItemStack(this.blockID, 1, limitToValidMetadata(par1)); }
	 */
}
