package gwydion0917.gwycraft.items;

import gwydion0917.gwycraft.ConfigGwycraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;


public class ItemGemSword extends ItemSword {

    public ItemGemSword(ToolMaterial mat) {
        super(mat);

        setUnlocalizedName("Gwycraft:sword");
        setHasSubtypes(true);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye
     * returns 16 items)
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs,
                            List par3List) {
        ItemStack stack = new ItemStack(par1, 1, 0);
        par3List.add(stack);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack,
                                   ItemStack par2ItemStack) {
        // FIXME: This needs work
        return false;
    }

    @Override
    public int getItemEnchantability() {
        //return this.toolMaterial.getEnchantability();
        return 22;
    }

    @Override
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (ConfigGwycraft.toolsHaveEnchants) {
            int level = new Random().nextInt(30) + 1;
            par1ItemStack = EnchantmentHelper.addRandomEnchantment(new Random(), par1ItemStack, level);
        }
    }
}
