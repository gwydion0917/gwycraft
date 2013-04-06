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

public class DyedStoneSlab1 extends BlockHalfSlab{
    /** The type of tree this slab came from. */
    public static final String[] colorSlab = new String[] {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] slabTextures = new String[] {"Gwycraft:stone_0", "Gwycraft:stone_1", "Gwycraft:stone_2", "Gwycraft:stone_3", "Gwycraft:stone_4", "Gwycraft:stone_5", "Gwycraft:stone_6", "Gwycraft:stone_7", "Gwycraft:stone_0", "Gwycraft:stone_1", "Gwycraft:stone_2", "Gwycraft:stone_3", "Gwycraft:stone_4", "Gwycraft:stone_5", "Gwycraft:stone_6", "Gwycraft:stone_7"};
    private Icon[] iconArray;

    public DyedStoneSlab1(int par1, boolean par2, Material mat)
    {
        super(par1, par2, mat);
//        setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
//    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
//    {
//        return this.iconArray[par2 % this.iconArray.length];
//    }

    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        par2 = par2%8;
        if(par2 == 0)
            return this.iconArray[par2 & 7];
        else if(par2 == 1)
            return this.iconArray[par2 & 7];
        else if(par2 == 2)
            return this.iconArray[par2 & 7];
        else if(par2 == 3)
            return this.iconArray[par2 & 7];
        else if(par2 == 4)
            return this.iconArray[par2 & 7];
        else if(par2 == 5)
            return this.iconArray[par2 & 7];
        else if(par2 == 6)
            return this.iconArray[par2 & 7];

        return this.iconArray[par2 & 7];
        
    }

//    {
//        return this.iconArray[par2 % this.iconArray.length];
//    }
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ConfigGwycraft.dyedStoneSlab1ID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(ConfigGwycraft.dyedStoneSlab1ID, 2, par1 & 7);
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
        if (par1 != ConfigGwycraft.dyedStoneSlab1ID)
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
