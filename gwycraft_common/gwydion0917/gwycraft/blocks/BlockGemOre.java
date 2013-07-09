package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockGemOre extends Block {
	/** The type of tree this log came from. */
	   public static final String[] gemBlockTextures = new String[] {
	        "gwycraft:ore_quartz", "gwycraft:ore_citrine", "gwycraft:ore_tanzanite", 
	        "gwycraft:ore_sapphire", "gwycraft:ore_topaz", "gwycraft:ore_agate", "gwycraft:ore_garnet",
	        "gwycraft:ore_moonstone", "gwycraft:ore_hematite", "gwycraft:ore_aquamarine", "gwycraft:ore_amethyst",
	        "gwycraft:ore_lapis_lazuli", "gwycraft:ore_tigerseye", "gwycraft:ore_emerald", 
	        "gwycraft:ore_ruby", "gwycraft:ore_onyx"};
	
   @SideOnly(Side.CLIENT)
	
	private Icon[] iconArray;

	public BlockGemOre(int id, Material mat) {
		super(id, mat);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
	return ConfigGwycraft.itemFlawedGemsID+256;
	}
	
    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
	@Override
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return 1 + par2Random.nextInt(par1 + 1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[gemBlockTextures.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister
					.registerIcon(gemBlockTextures[i]);
		}
	}
}