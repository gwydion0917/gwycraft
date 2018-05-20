package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockDyedLeaf extends BlockLeaves {
	public BlockDyedLeaf() {
		super();
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(0.2F);
		this.setSoundType(SoundType.PLANT);
	}

	//@Override
	//public int damageDropped(int metadata) {
	//	return metadata;
	//}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	//@SideOnly(Side.CLIENT)
	//@Override
	//public void registerBlockIcons(IIconRegister par1IconRegister) {
	//	this.iconArray = new IIcon[16];
	//
	//	for (int i = 0; i < this.iconArray.length; ++i) {
	//		this.iconArray[i] = par1IconRegister.registerIcon("gwycraft:leaf_" + i);
	//	}
	//}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumType getWoodType(int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}
