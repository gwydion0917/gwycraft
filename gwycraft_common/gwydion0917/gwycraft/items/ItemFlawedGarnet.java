package gwydion0917.gwycraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemFlawedGarnet extends Item
{

    public ItemFlawedGarnet(int par1) 
    {
        super(par1);
    }
    public void updateIcons(IconRegister par1IconRegister)
    {
         iconIndex = par1IconRegister.registerIcon("Gwycraft:gem_garnet");
    }

}
