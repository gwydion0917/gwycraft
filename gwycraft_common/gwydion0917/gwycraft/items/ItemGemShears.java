package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;


public class ItemGemShears extends ItemShears {

    public ItemGemShears() {
        super();
        setUnlocalizedName("Gwycraft:gemshears");
        setHasSubtypes(true);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        ItemStack stack = new ItemStack(par1, 1, 0);
        par3List.add(stack);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        // FIXME: This needs work
        return false;
    }

    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (ConfigGwycraft.toolsHaveEnchants) {
            par1ItemStack.addEnchantment(Enchantment.silkTouch, 1);
        }
    }
}
