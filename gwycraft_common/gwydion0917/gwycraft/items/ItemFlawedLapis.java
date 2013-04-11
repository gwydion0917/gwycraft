package gwydion0917.gwycraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemFlawedLapis extends Item {

	public ItemFlawedLapis(int par1) {
		super(par1);
		setUnlocalizedName("flawedLapis");
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("Gwycraft:gem_lapis_lazuli");
	}

}
