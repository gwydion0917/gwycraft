package gwydion0917.gwycraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGemShears extends ItemShears
{

    public ItemGemShears() {
        super();
        setUnlocalizedName("Gwycraft:gemshears");
        setHasSubtypes(true);
    }
    
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        ItemStack stack = new ItemStack(par1, 1, 0);
        stack.addEnchantment(Enchantment.silkTouch, 1);
        par3List.add(stack);
    }
    @Override
    public void registerIcons(IIconRegister reg){
        this.itemIcon = reg.registerIcon("Gwycraft:gemshears");
}

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	//FIXME: This is probably wrong
        return true;
    }
}
