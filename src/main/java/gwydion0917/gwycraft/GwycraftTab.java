package gwydion0917.gwycraft;

import gwydion0917.gwycraft.blocks.GwycraftBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GwycraftTab extends CreativeTabs {
	GwycraftTab(String label) {
		super(label);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(GwycraftBlocks.blockGemCompressed));
	}
}
