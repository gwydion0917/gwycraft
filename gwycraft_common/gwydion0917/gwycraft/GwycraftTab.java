package gwydion0917.gwycraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GwycraftTab extends CreativeTabs {
	GwycraftTab(String par2Str) {
		super(par2Str);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		// return Item.getItemFromBlock(Blocks.golden_rail);
		return Item.getItemFromBlock(GwycraftBlocks.blockGemCompressed);
	}
}
