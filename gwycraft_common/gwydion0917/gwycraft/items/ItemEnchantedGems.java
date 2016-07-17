package gwydion0917.gwycraft.items;

import java.util.List;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnchantedGems extends Item implements MultiItem {
	public static PropertyEnum<EnumGemType> GEMTYPE = PropertyEnum.<EnumGemType> create("type", EnumGemType.class);

	private final String name = "gem";

	public ItemEnchantedGems(String name) {
		// par1 not used
		super();
		this.setHasSubtypes(true);
		this.setCreativeTab(Gwycraft.tabs);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		// Register the object
		GameRegistry.register(this);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs par2CreativeTabs, List subItems) {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			subItems.add(new ItemStack(itemIn, 1, enumGemType.getMetadata()));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "." + EnumGemType.byMetadata(MathHelper.clamp_int(stack.getItemDamage(), 0, 16)).getUnlocalizedName();// + textureNames[arr];
	}

	public String getName() {
		return name;
	}

	@Override
	public void registerRenders() {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			ModelLoader.setCustomModelResourceLocation(this, enumGemType.getMetadata(), new ModelResourceLocation(this.getRegistryName() + "_" + enumGemType.getName()));
		}
	}
}
