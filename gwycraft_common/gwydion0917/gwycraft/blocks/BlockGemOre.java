package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.Gwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;

public class BlockGemOre extends BlockOre
{
    /** The type of tree this log came from. */
    public static final String[] gemOreTextures = new String[] {"GwyCraft:ore_agate", "Gwycraft:ore_amethyst", "Gwycraft:ore_aquamarine", "Gwycraft:ore_citrine", "Gwycraft:ore_emerald", "Gwycraft:ore_garnet", "Gwycraft:ore_hematite", "Gwycraft:ore_lapis_lazuli", "Gwycraft:ore_moonstone", "Gwycraft:ore_onyx", "Gwycraft:ore_quartz", "Gwycraft:ore_ruby", "Gwycraft:ore_sapphire", "Gwycraft:ore_tanzanite", "Gwycraft:ore_tigerseye", "Gwycraft:ore_topaz"};

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    public BlockGemOre(int id) {
        super(id);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
              (this.blockID == ConfigGwycraft.blockGemOreID ? ConfigGwycraft.flawedAgateID : 
               this.blockID
               ))))))))))))));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return this.blockID == Block.oreLapis.blockID ? 4 + par1Random.nextInt(5) : 1;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1))
        {
            int j = par2Random.nextInt(par1 + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(par2Random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(par2Random);
        }
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        int j1 = 0;
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
                this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[gemOreTextures.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(gemOreTextures[i]);
        }
    }
}