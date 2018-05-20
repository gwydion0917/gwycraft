package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlowyDyedGlass extends BlockGlass {

	public BlockGlowyDyedGlass() {
		super(Material.GLASS, false);
		this.setUnlocalizedName("glowydyedGlass");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(0.3F);
		this.setSoundType(SoundType.GLASS);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
}
