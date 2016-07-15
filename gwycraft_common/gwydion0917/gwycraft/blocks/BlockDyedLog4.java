package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedLog4 extends BlockLog {
	/** The type of tree this log came from. */
	public static final String[] woodType = new String[] { "brown", "green", "red", "black" };
	public static final String[] treeTextureTypes = new String[] { "gwycraft:logside_12", "gwycraft:logside_13", "gwycraft:logside_14", "gwycraft:logside_15" };
	public static final String[] treeTopTextureTypes = new String[] { "gwycraft:logtop_12", "gwycraft:logtop_13", "gwycraft:logtop_14", "gwycraft:logtop_15" };
	
	public BlockDyedLog4() {
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

	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
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
