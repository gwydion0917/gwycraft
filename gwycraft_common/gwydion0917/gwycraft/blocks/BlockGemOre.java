package gwydion0917.gwycraft.blocks;

import java.util.List;
import java.util.Random;

import gwydion0917.gwycraft.GwycraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGemOre extends Block {
	/** The type of tree this log came from. */
	public static final String[] gemBlockTextures = new String[] { "gwycraft:ore_quartz", "gwycraft:ore_citrine", "gwycraft:ore_tanzanite", "gwycraft:ore_sapphire", "gwycraft:ore_topaz", "gwycraft:ore_agate", "gwycraft:ore_garnet", "gwycraft:ore_moonstone", "gwycraft:ore_hematite", "gwycraft:ore_aquamarine", "gwycraft:ore_amethyst",
			"gwycraft:ore_lapis_lazuli", "gwycraft:ore_tigerseye", "gwycraft:ore_emerald", "gwycraft:ore_ruby", "gwycraft:ore_onyx" };

	public BlockGemOre(Material mat) {
		super(mat);
		this.setSoundType(SoundType.STONE);
	}

	/*
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return GwycraftItems.itemEnchantedGems;
		// ConfigGwycraft.itemEnchantedGemsID+256;
	}
	*/

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		return 1 + par2Random.nextInt(par1 + 1);
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
}