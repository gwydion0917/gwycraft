package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDyedFences extends BlockFence {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	private final String field_149827_a;

	public BlockDyedFences(String par2Str, Material mat) {
		super(par2Str , Material.wood);
		this.field_149827_a = par2Str;
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
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

/*	@SideOnly(Side.CLIENT)
	// FIXME: Broke @Override
	public void registerIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("gwycraft:plank_"
					+ i);
		}
	}*/
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.field_149827_a);
    }

}
