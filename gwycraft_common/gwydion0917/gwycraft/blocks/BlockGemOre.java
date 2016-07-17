package gwydion0917.gwycraft.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.GwycraftItems;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.interfaces.MultiBlock;
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

public class BlockGemOre extends Block implements MultiBlock {
	public static PropertyEnum<EnumGemType> GEMTYPE = PropertyEnum.<EnumGemType> create("type", EnumGemType.class);

	public BlockGemOre(Material mat, String name) {
		super(mat);
		this.setSoundType(SoundType.STONE);
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

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 1 + random.nextInt(fortune + 1);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
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

	public void registerRenders() {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), enumGemType.getMetadata(), new ModelResourceLocation(this.getRegistryName() + "_" + enumGemType.getName()));
		}
	}
}