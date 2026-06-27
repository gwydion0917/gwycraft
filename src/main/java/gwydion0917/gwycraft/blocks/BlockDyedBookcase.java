package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.Gwycraft;
import gwydion0917.gwycraft.interfaces.MultiItem;
import gwydion0917.gwycraft.statemappers.StateMapperGwyColored;
import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockDyedBookcase extends BlockBookshelf implements MultiItem {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public BlockDyedBookcase(String name) {
        this(name, 0f);
    }

    public BlockDyedBookcase(String name, float lightLevel) {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setLightLevel(lightLevel);
        this.setCreativeTab(Gwycraft.tabs);
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
    }

    public int damageDropped(IBlockState state) {
        return ((EnumDyeColor) state.getValue(COLOR)).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (EnumDyeColor color : EnumDyeColor.values()) {
            list.add(new ItemStack(this, 1, color.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumDyeColor) state.getValue(COLOR)).getMetadata();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{COLOR});
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(COLOR).getMetadata());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockRenders() {
        ModelLoader.setCustomStateMapper(this, new StateMapperGwyColored());
        for (EnumDyeColor color : EnumDyeColor.values()) {
            ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                color.getMetadata(),
                new ModelResourceLocation(this.getRegistryName().toString().replace("glowy_", "") + "_" + color.getName())
            );
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
