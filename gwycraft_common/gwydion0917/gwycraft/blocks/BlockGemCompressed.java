package gwydion0917.gwycraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemCompressed extends Block {
	/** The type of tree this log came from. */
	public static final String[] gemBlockTextures = new String[] {
			"gwycraft:gemblock_quartz", "gwycraft:gemblock_citrine",
			"gwycraft:gemblock_tanzanite", "gwycraft:gemblock_sapphire",
			"gwycraft:gemblock_topaz", "gwycraft:gemblock_agate",
			"gwycraft:gemblock_garnet", "gwycraft:gemblock_moonstone",
			"gwycraft:gemblock_hematite", "gwycraft:gemblock_aquamarine",
			"gwycraft:gemblock_amethyst", "gwycraft:gemblock_lapis_lazuli",
			"gwycraft:gemblock_tigerseye", "gwycraft:gemblock_emerald",
			"gwycraft:gemblock_ruby", "gwycraft:gemblock_onyx" };

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockGemCompressed(Material mat) {
		super(mat);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	// FIXME: Broke @Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return 0; // ConfigGwycraft.blockGemCompressedID;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[gemBlockTextures.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister
					.registerIcon(gemBlockTextures[i]);
		}
	}
}