package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGwyGenericBlock extends Block {
	// textureName from constructor, ie: stonecobble
	//private String tName;

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockGwyGenericBlock(Material mat) {
		super(mat);
		//tName = textureName;
		
	 }

	@Override
	public IIcon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + i);
		}
	}

}
