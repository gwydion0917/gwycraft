package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockDyedTorch extends BlockTorch implements MultiItem {
	public BlockDyedTorch(String name) {
		super();
		this.setSoundType(SoundType.WOOD);
		this.setHardness(0.0F);
		this.setLightLevel(0.9375F);
		this.setUnlocalizedName(Gwycraft.MOD_ID +  ".torch." + name);
		this.setRegistryName(Gwycraft.MOD_ID, "torch_" + name);
		//this.setRegistryName("torch_" + name);
		this.setCreativeTab(Gwycraft.tabs);
		
		// Register the block
		//GameRegistry.register(this);
		//GameRegistry.register(new ItemBlock(this).setUnlocalizedName("torch." + name).setRegistryName("torch_" + name));
	}

	@Override
	public void registerBlockRenders() {
		final Item item = Item.getItemFromBlock(this);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return new ModelResourceLocation(item.getRegistryName(), "inventory");
            }
        });
	}

	@Override
	public void registerItems(IForgeRegistry<Item> reg) {
		reg.register(new ItemBlock(this).setUnlocalizedName(this.getUnlocalizedName()).setRegistryName(this.getRegistryName()));
	}
}
