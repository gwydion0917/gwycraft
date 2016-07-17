package gwydion0917.gwycraft.client;

import gwydion0917.gwycraft.CommonProxy;
import gwydion0917.gwycraft.GwycraftBlocks;
import gwydion0917.gwycraft.blocks.BlockGemCompressed;
import gwydion0917.gwycraft.interfaces.MultiBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy {

	@SideOnly(Side.CLIENT)
	@Override
	public void registerRenderers() {
		for(MultiBlock block : GwycraftBlocks.ItemRenderers) {
			block.registerRenders();
		}
	}
}