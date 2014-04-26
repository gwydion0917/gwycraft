package gwydion0917.gwycraft;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GwycraftTab extends CreativeTabs
{
    GwycraftTab(String par2Str)
    {
        super(par2Str);
    }
    
/*	FIXME: Broke tab?
    @SideOnly(Side.CLIENT)
    @Override
    *//**
     * the itemID for the item to be displayed on the tab
     *//*
    public int getTabIconItemIndex()
    {
        return ConfigGwycraft.blockGemCompressedID;
    }*/

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return null;
	}
}
