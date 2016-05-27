package gwydion0917.gwycraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemEnchantedGems extends Item {

    public String[] textureNames = new String[]{"Gwycraft:gem_quartz", "Gwycraft:gem_citrine", "Gwycraft:gem_tanzanite", "Gwycraft:gem_sapphire",
            "Gwycraft:gem_topaz", "Gwycraft:gem_agate", "Gwycraft:gem_garnet", "Gwycraft:gem_moonstone", "Gwycraft:gem_hematite", "Gwycraft:gem_aquamarine",
            "Gwycraft:gem_amethyst", "Gwycraft:gem_lapis_lazuli", "Gwycraft:gem_tigerseye", "Gwycraft:gem_emerald", "Gwycraft:gem_ruby", "Gwycraft:gem_onyx"};


    public int blockType;
    private final String name = "gem";

    public ItemEnchantedGems() {
        // par1 not used
        super();
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
