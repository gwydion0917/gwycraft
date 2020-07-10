package gwydion0917.gwycraft.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.GwycraftItems;
import gwydion0917.gwycraft.enums.EnumGemType;
import gwydion0917.gwycraft.interfaces.MultiItem;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockGemOre extends Block implements MultiItem {
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
		//GameRegistry.register(this);

		// GameRegistry.register(new ItemGemCompressed(this));
		/*
		GameRegistry.register(new ItemMultiTexture(this, this, new Function<ItemStack, String>() {
			@Nullable
			public String apply(@Nullable ItemStack stack) {
				return EnumGemType.byMetadata(stack.getItemDamage()).getUnlocalizedName();
			}
		}).setUnlocalizedName(name).setRegistryName(name));
		//*/
	}
	
	/**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return GwycraftItems.itemEnchantedGems;
    }
    
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
        	return MathHelper.getInt(rand, 3, 7);
        }
        
        return 0;
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state) {
        return state.getValue(GEMTYPE).getMetadata();
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
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> subItems) {
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
	
	/**
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(GEMTYPE).getMetadata());
    }

	public void registerBlockRenders() {
		for (EnumGemType enumGemType : EnumGemType.values()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), enumGemType.getMetadata(), new ModelResourceLocation(this.getRegistryName() + "_" + enumGemType.getName()));
		}
	}

	@Override
	public void registerItems(IForgeRegistry<Item> reg) {
		reg.register((new ItemMultiTexture(this, this, new ItemMultiTexture.Mapper() {
			public String apply(ItemStack stack) {
				return EnumDyeColor.byMetadata(stack.getItemDamage()).getUnlocalizedName();
			}
		})).setUnlocalizedName(this.getUnlocalizedName()).setRegistryName(this.getRegistryName()));
	}
}