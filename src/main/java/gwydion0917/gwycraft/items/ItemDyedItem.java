package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.*;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemDyedItem extends ItemDye implements MultiItem {

	public ItemDyedItem(String name) {
		super();
		this.setCreativeTab(Gwycraft.tabs);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Register the object
		//GameRegistry.register(this);
	}

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
	@Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumDyeColor.byMetadata(MathHelper.clamp(stack.getItemDamage(), 0, 15)).getUnlocalizedName();
    }

	@Override
	public void registerBlockRenders() {
		for (int i = 0; i < 16; i++) {
			EnumDyeColor color = EnumDyeColor.byMetadata(i);
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(this.getRegistryName() + "_" + color.getName()));
		}
	}

	@Override
	public void registerItems(IForgeRegistry<Item> reg) {
		reg.register(this);
	}
}
