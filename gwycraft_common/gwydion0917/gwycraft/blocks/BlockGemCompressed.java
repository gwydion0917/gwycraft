package gwydion0917.gwycraft.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.enums.EnumGemType;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gwydion0917.gwycraft.interfaces.MultiBlock;

public class BlockGemCompressed extends Block implements MultiBlock {
	public static PropertyEnum<EnumGemType> GEMTYPE = PropertyEnum.<EnumGemType> create("type", EnumGemType.class);

	public BlockGemCompressed(Material mat, String name) {
		super(mat);
		this.setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(GEMTYPE, EnumGemType.QUARTZ));
		this.setLightLevel(1F);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Gwycraft.tabs);

		// Register the block and item
		GameRegistry.register(this);

		// GameRegistry.register(new ItemGemCompressed(this));
		GameRegistry.register(new ItemMultiTexture(this, this, new Function<ItemStack, String>() {
			@Nullable
			public String apply(@Nullable ItemStack stack) {
				return EnumGemType.byMetadata(stack.getItemDamage()).getUnlocalizedName();
			}
		}).setUnlocalizedName(name).setRegistryName(name));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List subItems) {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			subItems.add(new ItemStack(itemIn, 1, enumGemType.getMetadata()));
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(GEMTYPE, EnumGemType.byMetadata(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumGemType) state.getValue(GEMTYPE)).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { GEMTYPE });
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called
	 * when the block gets destroyed. It returns the metadata of the dropped
	 * item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state) {
		return ((EnumGemType) state.getValue(GEMTYPE)).getMetadata();
	}

	public void registerRenders() {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), enumGemType.getMetadata(), new ModelResourceLocation(this.getRegistryName() + "_" + enumGemType.getName()));
		}
	}
}