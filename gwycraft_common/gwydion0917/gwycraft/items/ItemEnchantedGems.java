package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnchantedGems extends Item {

	public String[] textureNames = new String[] { "Gwycraft:gem_quartz", "Gwycraft:gem_citrine", "Gwycraft:gem_tanzanite", "Gwycraft:gem_sapphire", 
	        "Gwycraft:gem_topaz", "Gwycraft:gem_agate", "Gwycraft:gem_garnet",  "Gwycraft:gem_moonstone", "Gwycraft:gem_hematite", "Gwycraft:gem_aquamarine",
	        "Gwycraft:gem_amethyst",  "Gwycraft:gem_lapis_lazuli",  "Gwycraft:gem_tigerseye",  "Gwycraft:gem_emerald", "Gwycraft:gem_ruby", "Gwycraft:gem_onyx"};
	public IIcon[] icons;

	public int blockType;

	public ItemEnchantedGems() {
		// par1 not used
		super();
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.icons = new IIcon[textureNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = iconRegister.registerIcon(textureNames[i]);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
		for (int i = 0; i < 16; i++)
			list.add(new ItemStack(this, 1, i));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int meta) {
		return icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
		return "item." + textureNames[arr];
	}

}
