package gwydion0917.gwycraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockDyedTorch extends BlockTorch {
    private String tName;
    
    public BlockDyedTorch(int par1, String textureName) {
        super(par1);
        tName = textureName;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister reg){
        this.blockIcon = reg.registerIcon("Gwycraft:" + tName);
}
//    public void registerIcons(IconRegister par1IconRegister) {
//        par1IconRegister.registerIcon("Gwycraft:" + tName);
//        }
}
