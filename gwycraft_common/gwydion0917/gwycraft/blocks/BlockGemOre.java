package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockGemOre extends Block
{
    /** The type of tree this log came from. */
    public static final String[] gemBlockTextures = new String[] {"Gwycraft:ore_agate", "Gwycraft:ore_amethyst", "Gwycraft:ore_aquamarine", "Gwycraft:ore_citrine", "Gwycraft:ore_emerald", "Gwycraft:ore_garnet", "Gwycraft:ore_hematite", "Gwycraft:ore_lapis_lazuli", "Gwycraft:ore_onyx", "Gwycraft:ore_quartz", "Gwycraft:ore_ruby", "Gwycraft:ore_sapphire", "Gwycraft:ore_tanzanite", "Gwycraft:ore_tigerseye", "Gwycraft:ore_topaz", "Gwycraft:ore_moonstone"};

        @SideOnly(Side.CLIENT)
        private Icon[] iconArray;

        public BlockGemOre(int id, Material mat) {
            super(id, mat);
        }

        @Override
        public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
            return this.iconArray[par2 % this.iconArray.length];
        }

        @Override
        /**
         * Returns the ID of the items to drop on destruction.
         */
//        public int idDropped(int par1, Random par2Random, int par3)
//        {
//         return this.blockID == ConfigGwycraft.blockGemOreID && damageDropped(0) ? ConfigGwycraft.flawedAgateID :
//                  (this.damageDropped(0) == 1 ? ConfigGwycraft.flawedAmethystID : 
//                  (this.damageDropped(par3) == 2 ? ConfigGwycraft.flawedAquamarineID : 
//                  (this.damageDropped(par3) == 3 ? ConfigGwycraft.flawedCitrineID : 
//                  (this.damageDropped(par3) == 4 ? ConfigGwycraft.flawedEmeraldID : 
//                  (this.damageDropped(par3) == 5 ? ConfigGwycraft.flawedGarnetID :
//                  (this.damageDropped(par3) == 6 ? ConfigGwycraft.flawedHematiteID :
//                  (this.damageDropped(par3) == 7 ? ConfigGwycraft.flawedLapisID :
//                  (this.damageDropped(par3)  == 8 ? ConfigGwycraft.flawedOnyxID :
//                  (this.damageDropped(par3)  == 9 ? ConfigGwycraft.flawedQuartzID :
//                  (this.damageDropped(par3)  == 10 ? ConfigGwycraft.flawedRubyID :
//                  (this.damageDropped(par3)  == 11 ? ConfigGwycraft.flawedSapphireID :
//                  (this.damageDropped(par3)  == 12 ? ConfigGwycraft.flawedTanzaniteID :
//                  (this.damageDropped(par3)  == 13 ? ConfigGwycraft.flawedTigerseyeID :
//                  (this.damageDropped(par3)  == 14 ? ConfigGwycraft.flawedTopazID :
//                  (this.damageDropped(par3)  == 15 ? ConfigGwycraft.flawedMoonstoneID :
//                   this.blockID)))))))))))))));
//       }


//        public int idDropped(int par1, Random par2Random, int par3)
//        {
//            return ConfigGwycraft.blockGemCompressedID;
//        }

        
        public int damageDropped(int metadata) {
            return metadata;
        }

        @SideOnly(Side.CLIENT)
        public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
            for (int i = 0; i < 16; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
       
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.iconArray = new Icon[gemBlockTextures.length];

            for (int i = 0; i < this.iconArray.length; ++i)
            {
                this.iconArray[i] = par1IconRegister.registerIcon(gemBlockTextures[i]);
            }
        }
    }