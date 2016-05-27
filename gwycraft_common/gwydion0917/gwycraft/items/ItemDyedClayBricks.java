package gwydion0917.gwycraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemDyedClayBricks extends ItemDye {

    public String[] textureNames = new String[]{"Gwycraft:claybrick_white",
            "Gwycraft:claybrick_orange", "Gwycraft:claybrick_magenta",
            "Gwycraft:claybrick_lblue", "Gwycraft:claybrick_yellow",
            "Gwycraft:claybrick_lime", "Gwycraft:claybrick_pink",
            "Gwycraft:claybrick_gray", "Gwycraft:claybrick_lgray",
            "Gwycraft:claybrick_cyan", "Gwycraft:claybrick_purple",
            "Gwycraft:claybrick_blue", "Gwycraft:claybrick_brown",
            "Gwycraft:claybrick_green", "Gwycraft:claybrick_red",
            "Gwycraft:claybrick_black"};

    public int blockType;
    private final String name = "itemDyedClayBrick";

    public ItemDyedClayBricks() {
        super();
        setUnlocalizedName("Gwycraft:itemDyedClayBrick");
        this.setHasSubtypes(true);
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i < 16; i++)
            list.add(new ItemStack(this, 1, i));
    }


    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int arr = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
        return "item." + textureNames[arr];
    }


    public String getName() {
        return name;
    }
}
