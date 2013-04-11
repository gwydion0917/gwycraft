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

public class ItemDyedClayBricks extends ItemDye {

    public String[] textureNames = new String[] {"Gwycraft:claybrick_white", "Gwycraft:claybrick_orange", "Gwycraft:claybrick_magenta", "Gwycraft:claybrick_lblue", "Gwycraft:claybrick_yellow", "Gwycraft:claybrick_lime", "Gwycraft:claybrick_pink", "Gwycraft:claybrick_gray", "Gwycraft:claybrick_lgray", "Gwycraft:claybrick_cyan", "Gwycraft:claybrick_purple", "Gwycraft:claybrick_blue", "Gwycraft:claybrick_brown", "Gwycraft:claybrick_green", "Gwycraft:claybrick_red", "Gwycraft:claybrick_black"};
    public Icon[] icons;

    public int blockType;

    public ItemDyedClayBricks(int par1) 
    {
        super(par1);
        setUnlocalizedName("Gwycraft:itemDyedClayBrick");
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
