package gwydion0917.gwycraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemFlawedAgate extends Item
{

    public ItemFlawedAgate(int par1) 
    {
        super(par1);
        setUnlocalizedName("Gwycraft:flawedAgate");
    }
    public void updateIcons(IconRegister par1IconRegister)
    {
         iconIndex = par1IconRegister.registerIcon("Gwycraft:gem_agate");
    }

}
