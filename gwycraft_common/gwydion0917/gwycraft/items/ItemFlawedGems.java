package gwydion0917.gwycraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

public class ItemFlawedGems extends ItemDye {

    public String[] textureNames = new String[] {"Gwycraft:gem_agate", "Gwycraft:gem_amethyst", "Gwycraft:gem_aquamarine", "Gwycraft:gem_citrine", "Gwycraft:gem_emerald", "Gwycraft:gem_garnet", "Gwycraft:gem_hematite", "Gwycraft:gem_lapis_lazuli", "Gwycraft:gem_onyx", "Gwycraft:gem_quartz", "Gwycraft:gem_ruby", "Gwycraft:gem_sapphire", "Gwycraft:gem_tanzanite", "Gwycraft:gem_tigerseye", "Gwycraft:gem_topaz", "Gwycraft:gem_moonstone"};
    public Icon[] icons;

    public int blockType;

    public ItemFlawedGems(int par1) 
    {
        super(par1);
        setUnlocalizedName("Gwycraft:flawedGems");
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    @Override

    public void registerIcons(IconRegister iconRegister)
    {
        this.icons = new Icon[textureNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon(textureNames[i]);
        }
    }

    public void getSubItems(int id, List list)
    { 
        for (int i = 0; i < 16; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int meta)
    {
        return icons[meta];
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
        return "item." +textureNames[arr];
    }

}
