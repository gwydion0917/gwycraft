package gwydion0917.gwycraft.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDyedTorch extends BlockTorch {
    private String tName;
    
    public BlockDyedTorch(String textureName) {
        super();
        tName = textureName;
    }

    @SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister reg){
        this.blockIcon = reg.registerIcon("Gwycraft:" + tName);
}
//    public void registerIcons(IconRegister par1IconRegister) {
//        par1IconRegister.registerIcon("Gwycraft:" + tName);
//        }
}
