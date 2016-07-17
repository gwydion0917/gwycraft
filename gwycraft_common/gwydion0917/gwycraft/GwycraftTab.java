package gwydion0917.gwycraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GwycraftTab extends CreativeTabs {
	GwycraftTab(String label) {
		super(label);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(GwycraftBlocks.blockGemCompressed);
	}
}
