package gwydion0917.gwycraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class ItemGemShears extends ItemShears
{

    public ItemGemShears(int par1) {
        super(par1);
        setUnlocalizedName("Gwycraft:gemshears");
        setHasSubtypes(true);
    }
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        ItemStack stack = new ItemStack(par1, 1, 0);
        stack.addEnchantment(Enchantment.silkTouch, 1);
        par3List.add(stack);
    }
    @Override
    public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon("Gwycraft:gemshears");
}

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return par2ItemStack.itemID == Item.diamond.itemID;
    }
}
