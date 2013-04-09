package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;

import java.util.List;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockDyedStonePaver2 extends BlockHalfSlab{
    /** The type of tree this slab came from. */
    public static final String[] colorSlab = new String[] {"Light Gray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
    public static final String[] slabTextures = new String[] {"Gwycraft:stone_8", "Gwycraft:stone_9", "Gwycraft:stone_10", "Gwycraft:stone_11", "Gwycraft:stone_12", "Gwycraft:stone_13", "Gwycraft:stone_14", "Gwycraft:stone_15", "Gwycraft:stone_8", "Gwycraft:stone_9", "Gwycraft:stone_10", "Gwycraft:stone_11", "Gwycraft:stone_12", "Gwycraft:stone_13", "Gwycraft:stone_14", "Gwycraft:stone_15"};

    private Icon[] iconArray;

    public BlockDyedStonePaver2(int par1, boolean par2, Material mat)
    {
        super(par1, par2, mat);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
//        setCreativeTab(CreativeTabs.tabBlock);
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
        return ConfigGwycraft.blockDyedStonePaver2ID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(ConfigGwycraft.blockDyedStonePaver2ID, 2, par1 & 7);
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
        if (par1 != ConfigGwycraft.blockDyedStonePaver2ID)
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
