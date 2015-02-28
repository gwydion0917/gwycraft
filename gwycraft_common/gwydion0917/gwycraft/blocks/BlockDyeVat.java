package gwydion0917.gwycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;


public class BlockDyeVat extends Block {

    public BlockDyeVat() {
        super(Material.rock);
        setBlockName("gwycraft.dyeVat");
        setBlockTextureName("gwycraft:dyeVat");
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.5F);
        setResistance(6.0F);
        setStepSound(Block.soundTypeStone);

    }

    public IIcon[] icons = new IIcon[6];

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        // 0 = bottom, 1 = top, 2-5 = sides
        this.icons[0] = reg.registerIcon("gwycraft:dye_vat_bottom");
        this.icons[1] = reg.registerIcon("gwycraft:dye_vat_bottom");
        for (int i = 2; i < 6; i++) {
            this.icons[i] = reg.registerIcon("gwycraft:dye_vat_side");
        }

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0:
                return icons[0];
            case 1:
                return icons[1];
            case 2:
                return icons[2];
            default:
                return icons[2];
        }
        //return this.icons[side];
    }

}
