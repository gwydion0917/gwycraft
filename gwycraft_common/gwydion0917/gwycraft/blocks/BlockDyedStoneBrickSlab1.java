package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockDyedStoneBrickSlab1 extends BlockHalfSlab{
    /** The type of tree this slab came from. */
    public static final String[] colorSlab = new String[] {"White", "Orange", "Magenta", "Light Blue", "Yellow", "Light Green", "Pink", "Dark Grey"};
    public static final String[] slabTextures = new String[] {"Gwycraft:stonebrick_0", "Gwycraft:stonebrick_1", "Gwycraft:stonebrick_2", "Gwycraft:stonebrick_3", "Gwycraft:stonebrick_4", "Gwycraft:stonebrick_5", "Gwycraft:stonebrick_6", "Gwycraft:stonebrick_7", "Gwycraft:stonebrick_0", "Gwycraft:stonebrick_1", "Gwycraft:stonebrick_2", "Gwycraft:stonebrick_3", "Gwycraft:stonebrick_4", "Gwycraft:stonebrick_5", "Gwycraft:stonebrick_6", "Gwycraft:stonebrick_7"};
    private Icon[] iconArray;

    public BlockDyedStoneBrickSlab1(int par1, boolean par2, Material mat)
    {
        super(par1, par2, mat);
    }

        public int idDropped(int par1, Random par2Random, int par3)
        {
            return ConfigGwycraft.blockDyedStoneBrickSlab1ID;
        }
        
        public String getFullSlabName(int i)
        {
            if (!isDoubleSlab)
                return super.getUnlocalizedName() + "blockDyedStoneBrickSlab";
            else
                return super.getUnlocalizedName() + "blockDyedStoneBrickDoubleSlab";
        }        
      
        @SideOnly(Side.CLIENT)
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
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.iconArray = new Icon[16];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(slabTextures[i]);
        }
    }
}
