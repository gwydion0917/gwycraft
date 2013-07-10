package gwydion0917.gwycraft.blocks;

import java.util.List;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGwyGenericSlab2 extends BlockHalfSlab {
    // textureName from constructor, ie: stonecobble
    private String tName;
	/** The type of tree this slab came from. */
	public static final String[] colorSlab = new String[] { "Light Gray",
			"Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black" };

	private Icon[] iconArray;

	public BlockGwyGenericSlab2(int par1, boolean par2, Material mat, String textureName) {
		super(par1, par2, mat);
	      tName = textureName;
	}

	/**
	 * Returns the slab block name with step type.
	 */
	@Override
	public String getFullSlabName(int par1) {
		if (par1 < 0 || par1 >= colorSlab.length) {
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + colorSlab[par1];
	}
    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }
    
//	public int idDropped(int par1, Random par2Random, int par3) {
//		return ConfigGwycraft.dyedStoneSlab2ID;
//	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 8; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2) {
		par2 = par2 % 8;
		if (par2 == 0)
			return this.iconArray[par2 & 7];
		else if (par2 == 1)
			return this.iconArray[par2 & 7];
		else if (par2 == 2)
			return this.iconArray[par2 & 7];
		else if (par2 == 3)
			return this.iconArray[par2 & 7];
		else if (par2 == 4)
			return this.iconArray[par2 & 7];
		else if (par2 == 5)
			return this.iconArray[par2 & 7];
		else if (par2 == 6)
			return this.iconArray[par2 & 7];

		return this.iconArray[par2 & 7];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];

		for (int i = 8; i < 16; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon("gwycraft:" + tName + "_" + i);
            this.iconArray[i-8] = par1IconRegister.registerIcon("gwycraft:" + tName + "_" + i);
		}
	}
}
