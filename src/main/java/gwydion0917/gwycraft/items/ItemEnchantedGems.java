package gwydion0917.gwycraft.items;

import java.util.List;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemEnchantedGems extends Item implements MultiItem {
	private final String name = "gem";

	public ItemEnchantedGems(String name) {
		// par1 not used
		super();
		this.setHasSubtypes(true);
		this.setCreativeTab(Gwycraft.tabs);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Register the object
		//GameRegistry.register(this);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			subItems.add(new ItemStack(this, 1, enumGemType.getMetadata()));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "." + EnumGemType.byMetadata(MathHelper.clamp(stack.getItemDamage(), 0, 16)).getUnlocalizedName();// + textureNames[arr];
	}

	public String getName() {
		return name;
	}

	@Override
	public void registerBlockRenders() {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			ModelLoader.setCustomModelResourceLocation(this, enumGemType.getMetadata(), new ModelResourceLocation(this.getRegistryName() + "_" + enumGemType.getName()));
		}
	}

	@Override
	public void registerItems(IForgeRegistry<Item> reg) {
	}
}
