package gwydion0917.gwycraft;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DyedStoneDoubleSlab1 extends BlockHalfSlab{
    /** The type of tree this slab came from. */
    public static final String[] colorSlab = new String[] {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] slabTextures = new String[] {"Gwycraft:stone_0", "Gwycraft:stone_1", "Gwycraft:stone_2", "Gwycraft:stone_3", "Gwycraft:stone_4", "Gwycraft:stone_5", "Gwycraft:stone_6", "Gwycraft:stone_7", "Gwycraft:stone_0", "Gwycraft:stone_1", "Gwycraft:stone_2", "Gwycraft:stone_3", "Gwycraft:stone_4", "Gwycraft:stone_5", "Gwycraft:stone_6", "Gwycraft:stone_7"};
    private Icon[] iconArray;

    public DyedStoneDoubleSlab1(int par1, boolean par2)
    {
        super(par1, par2, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName("dyedStoneSlab1");
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return this.iconArray[par2 % this.iconArray.length];
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return gwydion0917.gwycraft.Gwycraft.dyedStoneSlab1ID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(gwydion0917.gwycraft.Gwycraft.dyedStoneSlab1ID, 2, par1 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int par1)
    {
        if (par1 < 0 || par1 >= colorSlab.length)
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + colorSlab[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != gwydion0917.gwycraft.Gwycraft.dyedStoneDoubleSlab1ID)
        {
            for (int j = 0; j < 8; ++j)
            {
                par3List.add(new ItemStack(par1, 1, j));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.iconArray = new Icon[16];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(slabTextures[i]);
        }
    }
}
