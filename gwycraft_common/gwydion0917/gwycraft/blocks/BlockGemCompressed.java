package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGemCompressed extends Block {
	/** The type of tree this log came from. */
	public static final String[] gemBlockTextures = new String[] { "gwycraft:gemblock_quartz", "gwycraft:gemblock_citrine", "gwycraft:gemblock_tanzanite", "gwycraft:gemblock_sapphire", "gwycraft:gemblock_topaz", "gwycraft:gemblock_agate", "gwycraft:gemblock_garnet", "gwycraft:gemblock_moonstone", "gwycraft:gemblock_hematite", "gwycraft:gemblock_aquamarine",
			"gwycraft:gemblock_amethyst", "gwycraft:gemblock_lapis_lazuli", "gwycraft:gemblock_tigerseye", "gwycraft:gemblock_emerald", "gwycraft:gemblock_ruby", "gwycraft:gemblock_onyx" };

	public BlockGemCompressed(Material mat) {
		super(mat);
		this.setSoundType(SoundType.STONE);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
}