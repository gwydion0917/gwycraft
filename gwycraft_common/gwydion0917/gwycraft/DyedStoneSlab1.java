package gwydion0917.gwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DyedStoneSlab1 extends BlockHalfSlab {

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public DyedStoneSlab1(int id) {
		super(id, isDoubleSlab, Material.rock);
		setUnlocalizedName("dyedStoneSlab1");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setStepSound(Block.stoneSingleSlab.stepSound);

	}

	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 7; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[7];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("Gwycraft:stone_" + i);
		}
	}

    @Override
    public String getFullSlabName(int i) {
        // TODO Auto-generated method stub
        return null;
    }

}
