package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.Gwycraft;

import java.util.List;

import net.minecraft.block.Block;
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

public class BlockGemCompressed extends Block
{
    /** The type of tree this log came from. */
    public static final String[] gemBlockTextures = new String[] {"GwyCraft:gemblock_agate", "Gwycraft:gemblock_amethyst", "Gwycraft:gemblock_aquamarine", "Gwycraft:gemblock_citrine", "Gwycraft:gemblock_emerald", "Gwycraft:gemblock_garnet", "Gwycraft:gemblock_hematite", "Gwycraft:gemblock_lapis_lazuli", "Gwycraft:gemblock_moonstone", "Gwycraft:gemblock_onyx", "Gwycraft:gemblock_quartz", "Gwycraft:gemblock_ruby", "Gwycraft:gemblock_sapphire", "Gwycraft:gemblock_tanzanite", "Gwycraft:gemblock_tigerseye", "Gwycraft:gemblock_topaz"};
   @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    public BlockGemCompressed(int id) {
        super(id, Material.wood);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == Block.oreCoal.blockID ? Item.coal.itemID : (this.blockID == Block.oreDiamond.blockID ? Item.diamond.itemID : (this.blockID == Block.oreLapis.blockID ? Item.dyePowder.itemID : (this.blockID == Block.oreEmerald.blockID ? Item.emerald.itemID : (this.blockID == Block.oreNetherQuartz.blockID ? Item.field_94583_ca.itemID : this.blockID))));
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

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int j1 = 0;

            if (this.blockID == Block.oreCoal.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
            else if (this.blockID == Block.oreDiamond.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Block.oreEmerald.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == Block.oreLapis.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == Block.oreNetherQuartz.blockID)
            {
                j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return this.blockID == Block.oreLapis.blockID ? 4 : 0;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[gemBlockTextures.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(gemBlockTextures[i]);
        }
    }
}