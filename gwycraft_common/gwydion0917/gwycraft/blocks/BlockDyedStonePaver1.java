package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockDyedStonePaver1 extends Block {
	/** The type of tree this slab came from. */
	public static final String[] colorSlab = new String[] { "White", "Orange",
			"Magenta", "Light Blue", "Yellow", "Light Green", "Pink",
			"Dark Grey" };
	public static final String[] slabTextures = new String[] {
			"Gwycraft:stone_0", "Gwycraft:stone_1", "Gwycraft:stone_2",
			"Gwycraft:stone_3", "Gwycraft:stone_4", "Gwycraft:stone_5",
			"Gwycraft:stone_6", "Gwycraft:stone_7", "Gwycraft:stone_0",
			"Gwycraft:stone_1", "Gwycraft:stone_2", "Gwycraft:stone_3",
			"Gwycraft:stone_4", "Gwycraft:stone_5", "Gwycraft:stone_6",
			"Gwycraft:stone_7" };
	private Icon[] iconArray;

	public BlockDyedStonePaver1(int id) {
		super(id, Material.rock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
		this.setLightOpacity(255);
	}

	@Override
	public void addCollisionBoxesToList(World par1World, int par2, int par3,
			int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		super.addCollisionBoxesToList(par1World, par2, par3, par4,
				par5AxisAlignedBB, par6List, par7Entity);
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return ConfigGwycraft.dyedStonecobbleID;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("Gwycraft:stone_"
					+ i);
		}
	}

	// FIXME: Is this needed?
	// protected int func_94351_d(World world, int i, int j, int k) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	//
	// protected int func_94350_c(int i) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// protected int func_94355_d(int i) {
	// // TODO Auto-generated method stub
	// return 0;
	// }

}
