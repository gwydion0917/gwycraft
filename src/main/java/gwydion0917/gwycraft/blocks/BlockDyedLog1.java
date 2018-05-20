package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedLog1 extends BlockLog {
	/** The type of tree this log came from. */
	public static final String[] woodType = new String[] { "white", "orange", "magenta", "light blue" };
	public static final String[] treeTextureTypes = new String[] { "gwycraft:logside_0", "gwycraft:logside_1", "gwycraft:logside_2", "gwycraft:logside_3" };
	public static final String[] treeTopTextureTypes = new String[] { "gwycraft:logtop_0", "gwycraft:logtop_1", "gwycraft:logtop_2", "gwycraft:logtop_3" };
	
	public BlockDyedLog1() {
		super();
		this.setSoundType(SoundType.WOOD);
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	/*
	 * @Override
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
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
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
